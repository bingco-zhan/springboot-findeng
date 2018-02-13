var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/customerBinding'
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
        {field: 'id', width: "7%", title: 'ID'}
        , {
            title: '申请用户ID', templet: function (data) {
                return data.apply.userId;
            }
        }
        , {
            title: '申请人头像', templet: function (data) {
                if (data.apply.userProtraitPic == undefined) data.apply.userProtraitPic = "img/default_avatar.jpg";
                return '<img style="width:50px;height:50px;" src="' + data.apply.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {
            title: '申请人', templet: function (data) {
                return data.apply.userNickname;
            }
        }
        , {
            title: '解绑人头像', templet: function (data) {
                if (data.unbundling.userProtraitPic == undefined) data.unbundling.userProtraitPic = "img/default_avatar.jpg";
                return '<img style="width:50px;height:50px;" src="' + data.unbundling.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {
            title: '解绑人', templet: function (data) {
                return data.unbundling.userNickname;
            }
        }
        , {field: 'createTime', title: '创建时间'}
        , {field: 'endTime', title: '审批时间'}
        , {
            field: 'status', title: '状态', templet: function (data) {
                switch (data.status) {
                    case 0:
                        return "未审核";
                    case 1:
                        return "不通过";
                    case 2:
                        return "通过";
                    default:
                        return "未知";
                }
            }
        }
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