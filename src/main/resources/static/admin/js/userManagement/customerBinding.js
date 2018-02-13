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
        {field: 'userId', title: '用户ID'}
        , {
            title: '头像', templet: function (data) {
                if (data.userProtraitPic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {field: 'userNickname', title: '昵称'}
        , {field: 'upperUserId', title: '上级ID'}
        , {
            field: 'role', title: '角色', templet: function (data) {
                if (data.role == undefined) return "";
                return data.role.roleName;
            }
        }
        , {field: 'lowerCount', sort: true, title: '下级数'}
        , {field: 'purchaseMoney', sort: true, title: '购买额'}
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