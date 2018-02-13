var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/userRole/all'
    , page: true
    , cellMinWidth: "170"
    , height: 'full-20'
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
        {field: 'id', width: "50", title: 'ID'}
        , {
            field: 'loginBackstage', width: "90", title: '登录后台', templet: function (data) {
                switch (data.loginBackstage) {
                    case 0:
                        return "否";
                    case 1:
                        return "是";
                    default:
                        return "未知";
                }
            }
        }
        , {
            field: 'permissions', width: "710", title: '拥有权限', templet: function (data) {
                if (data.permissions == undefined || data.permissions.length == 0) return "";
                var arr = data.permissions.split(',');
                var domTxt = "";
                for (var i in arr) {
                    for (var o in userPermissionList) {
                        if (userPermissionList[o].id == arr[i])
                            domTxt += '<div class="layui-col-md2"><span class="layui-badge-rim">' + userPermissionList[o].permissionDes + '</span></div>';
                    }
                }
                domTxt = '<div class="layui-row">' + domTxt + '</div>';
                return domTxt;
            }
        }
        , {field: 'roleName', width: "100", title: '角色名'}
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

/**
 * 监听工具栏
 */
layui.table.on('tool(table)', function (data) {
    var roleId = data.data.id;//角色id
    var event = data.event;//事件名
    var url = "";
    if (event == "updata")
        url = '/admin/roleManagement/modifyPermission?roleId=' + roleId;
    else
        url = '/admin/roleManagement/addUserRole';
    var ajax = new XMLHttpRequest();
    ajax.open('get', url);
    ajax.send();
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {
            if (event == "updata") {
                var layerWin = layer.open({
                    title: "修改角色",
                    type: 1,
                    btn: ['提交', '取消'],
                    btn1: function (index, layero) {
                        $(".modifyPermissionForm-subtim").click();
                        if ($("#verifyState").val() == 1) {
                            var ajaxData = $("#modifyPermissionForm").serializeObject();
                            if (ajaxData.permissions != undefined) {
                                ajaxData.permissions = "," + new Array(ajaxData.permissions).join(",") + ","
                            }
                            ajaxData.id = roleId;
                            //保存用户角色
                            $.ajax({
                                url: "/admin/api/userRole",
                                dataType: "json",
                                data: ajaxData,
                                type: "put",
                                success: function (data) {
                                    layer.msg(data.msg);
                                    if (data.code == 1) {
                                        layer.closeAll('page');//关闭所有弹层
                                    }
                                    $("#verifyState").val("");//提交成功清空验证状态
                                    table.reload({});
                                },
                                error: function () {
                                }
                            });
                        }
                    },
                    btn2: function (index, layero) {
                    },
                    content: ajax.responseText
                });
            } else {
                var layerWin = layer.open({
                    title: "新增角色",
                    type: 1,
                    btn: ['提交', '取消'],
                    btn1: function (index, layero) {
                        $(".addUserRoleForm-subtim").click();
                        if ($("#verifyState").val() == 1) {
                            var ajaxData = $("#addUserRoleForm").serializeObject();
                            if (ajaxData.permissions != undefined) {
                                ajaxData.permissions = "," + new Array(ajaxData.permissions).join(",") + ","
                            }
                            $.ajax({
                                url: "/admin/api/userRole",
                                dataType: "json",
                                data: ajaxData,
                                type: "post",
                                success: function (data) {
                                    layer.msg(data.msg);
                                    if (data.code == 1) {
                                        layer.closeAll('page');//关闭所有弹层
                                    }
                                    $("#verifyState").val("");//提交成功清空验证状态
                                    table.reload({});
                                },
                                error: function () {
                                }
                            });
                        }
                    },
                    btn2: function (index, layero) {
                    },
                    content: ajax.responseText
                });
            }
            layer.full(layerWin);//最大化窗口
        }
    }
});

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};