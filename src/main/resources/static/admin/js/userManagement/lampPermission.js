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
        {field: 'userId', title: 'ID'}
        , {field: 'userNickname', title: '用户昵称'}
        , {
            field: 'userProtraitPic', title: '头像', templet: function (data) {
                if (data.userProtraitPic == undefined) data.userProtraitPic = "img/default_avatar.jpg";
                return '<img style="width:50px;height:50px;" src="' + data.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {field: 'rentVisitTime', title: '最近访问', sort: true}
        , {
            field: 'lampSelectionLogin', title: '登陆权限', templet: function (data) {
                if (data.lampSelectionLogin == 1)
                    return "有权"
                else
                    return "无权";
            }
        }
        , {
            field: 'lampPermissionAuthroPic', title: '购买合同', templet: function (data) {
                if (data.lampPermissionAuthroPic == "" || data.lampPermissionAuthroPic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.lampPermissionAuthroPic + '" class="img-rounded" >';
            }
        }
        , {title: '操作', toolbar: "#tool"}
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
    if (sortData.sort == null) {
        sortData.field = null;
        sortData.sort = null;
    }
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

layui.table.on('tool(table)', function (data) {
    var userId = data.data.userId;//注册用户ID
    var url = "/admin/lampPermission/authorize";
    var ajax = new XMLHttpRequest();
    ajax.open('get', url);
    ajax.send();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            var layerWin = layer.open({
                title: "导购机授权",
                type: 1,
                btn: ['提交', '取消'],
                btn1: function (index, layero) {
                    $(".addUserRoleForm-subtim").click();
                    if ($("#verifyState").val() == 1) {
                        var ajaxData = $("#addUserRoleForm").serialize();
                        $.ajax({
                            url: '/admin/api/lampPermission/authentication',
                            dataType: 'json',
                            data: ajaxData,
                            type: 'put',
                            success: function (data) {
                                layer.msg(data.msg);
                                if (data.code == 1) {
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
        }
        $("#userId").val(userId);//设置子页面申请用户
    }
});