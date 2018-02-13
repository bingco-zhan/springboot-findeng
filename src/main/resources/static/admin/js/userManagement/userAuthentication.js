var form = layui.form;
var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/user'
    , page: true
    , height: 'full-55'
    , request: {
        pageName: 'offset' //页码的参数名称，默认：page
        , limitName: 'limit' //每页数据量的参数名，默认：limit
    }
    , response: {
        statusName: 'code' //数据状态的字段名称，默认：code
        , statusCode: "0" //成功的状态码，默认：0
        , msgName: 'msg' //状态信息的字段名称，默认：msg
        , countName: 'total' //数据总数的字段名称，默认：count
        , dataName: 'rows' //数据列表的字段名称，默认：data
    }
    , cols: [[
        {field: 'userId', title: 'ID', width: "60"}
        , {field: 'upperUserId', title: '上级ID', width: "80"}
        , {field: 'userNickname', title: '昵称', width: "100"}
        , {
            field: 'userProtraitPic', title: '头像', width: "80", templet: function (data) {
                if (data.userProtraitPic == undefined) data.userProtraitPic = "img/default_avatar.jpg";
                return '<img style="width:50px;height:50px;" src="' + data.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {field: 'phoneNumber', title: '电话', width: "120"}
        , {field: 'openId', title: '微信ID', width: "120"}
        , {
            width: "80", title: '角色', templet: function (data) {
                if (data.role == undefined || data.role.roleName == undefined)
                    return "未知";
                return data.role.roleName;
            }
        }
        , {field: 'companyName', width: "150", title: '公司名'}
        , {field: 'applyId', width: "80", title: '认证ID'}
        , {
            field: 'checkStatus', width: "70", title: '状态', templet: function (data) {
                if (data.checkStatus == 3) return "通过";
                if (data.checkStatus == 2) return "失败";
                else return "待审";
            }
        }
        , {width: "180", title: '操作', toolbar: "#tool"}
    ]]
});

var searchData = {};//搜索数据
layui.form.on('submit(search)', function (data) {
    searchData = data.field;
    table.reload({
        where: mergeJson(searchData, sortData)
        , page: {curr: 1}
    });
    //收起折叠面板
    document.getElementsByClassName("layui-show")[0].classList.remove("layui-show");
    return false;
});

var sortData = {};//排序数据
layui.table.on('sort(table)', function (data) {
    sortData.field = data.field;
    sortData.sort = data.type;
    table.reload({
        where: mergeJson(searchData, sortData)
        , page: {curr: 1}
    });
});

//合并json字段
function mergeJson(json1, json2) {
    var result = {};
    for (var attr in json1) {
        if (json1[attr] != undefined && json1[attr] != "")
            result[attr] = json1[attr];
    }
    for (var attr in json2) {
        if (json2[attr] != undefined && json2[attr] != "")
            result[attr] = json2[attr];
    }
    return result;
};

/**
 * 监听工具栏
 */
layui.table.on('tool(table)', function (data) {
    var userId = data.data.userId;//注册用户ID
    var event = data.event;//事件名
    var url = "";
    var title = "";
    var roleId;
    switch (event) {
        case "dealer":
            title = "注册经销商";
            url = "/admin/userAuthentication/registeredDealer";
            roleId = 4;
            break;
        case "factory":
            title = "注册厂家";
            url = "/admin/userAuthentication/registeredFactory";
            roleId = 1;
            break;
        case "staff":
            title = "注册业务员";
            url = "/admin/userAuthentication/registeredStaff";
            roleId = 2;
            layer.msg("该功能未开放");
            return false;
            break;
    }
    var ajax = new XMLHttpRequest();
    ajax.open('get', url + '?userId=' + userId);
    ajax.send();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var layerWin = layer.open({
                title: title,
                type: 1,
                btn: ['提交', '取消'],
                btn1: function (index, layero) {
                    var ajaxData;
                    //提交表单验证并获取表单数据
                    if (roleId == 1) {//注册厂家
                        $(".registeredFactoryForm-subtim").click();
                        ajaxData = $("#registeredFactoryForm").serialize();
                    }
                    if (roleId == 4) {//注册经销商
                        $(".registeredDealerForm-subtim").click();
                        ajaxData = $("#registeredDealerForm").serialize();
                    }
                    if (roleId == 2) {//注册业务员
                        $(".registeredStaffForm-subtim").click();
                        ajaxData = $("#registeredStaffForm").serialize();
                    }

                    if ($("#verifyState").val() == 1) {
                        $.ajax({
                            url: '/admin/api/certificationApplication',
                            dataType: 'json',
                            data: ajaxData,
                            type: 'post',
                            success: function (data) {
                                layer.msg(data.msg);
                                if (data.code == 2) {
                                    layer.closeAll('page');//关闭所有弹层
                                }
                                $("#verifyState").val("");//提交成功清空验证状态
                                table.reload({});
                            }
                        });
                    }
                    return false;
                },
                btn2: function (index, layero) {

                },
                content: ajax.responseText
            });
            $("#userId").val(userId);//设置子页面申请用户
            $("#roleId").val(roleId);//设置子页面申请角色
            layer.full(layerWin);
            form.render('select');
        }
    }
});