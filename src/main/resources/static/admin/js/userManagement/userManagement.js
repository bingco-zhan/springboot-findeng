var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/user'
    , page: true
    , cellMinWidth: "170"
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
        {field: 'userId', width: "60", title: 'ID'}
        , {field: 'upperUserId', width: "80", title: '上级ID'}
        , {field: 'userNickname', width: "150", title: '用户昵称'}
        , {
            field: 'userProtraitPic', title: '头像', width: "80", templet: function (data) {
                if (data.userProtraitPic == undefined) data.userProtraitPic = "img/default_avatar.jpg";
                return '<img style="width:50px;height:50px;" src="' + data.userProtraitPic + '" class="img-rounded" >';
            }
        }
        , {field: 'phoneNumber', width: "120", title: '电话'}
        , {
            field: 'role', width: "80", title: '角色', templet: function (data) {
                if (data.role == undefined) return "未知";
                return data.role.roleName;
            }
        }
        , {field: 'withdrawMoney', sort: true, width: "100", title: '已提现'}
        , {field: 'flowMoney', sort: true, width: "100", title: '可支配'}
        , {field: 'pendingMoney', sort: true, width: "100", title: '待结算'}
        , {field: 'qqNumber', width: "120", title: 'QQ'}
        , {field: 'email', width: "150", title: '邮箱'}
        , {field: 'companyName', width: "100", title: '公司名'}
        , {field: 'companyAddressDetail', width: "100", title: '地址'}
        , {
            field: 'checkStatus', width: "80", title: '审核状态', templet: function (data) {
                if (data.checkStatus == 3) return "通过";
                if (data.checkStatus == 2) return "失败";
                else return "待审";
            }
        }
        , {field: 'applyId', width: "80", title: '认证ID'}
        , {field: 'userIdenticalCode', width: "80", title: '编码'}
        , {
            field: 'followTime', width: "110", sort: true, title: '关注时间', templet: function (data) {
                if (data.followTime == undefined) return "";
                return data.followTime.substring(0, 10);
            }
        }
        , {
            field: 'rentVisitTime', width: "110", sort: true, title: '上次登录', templet: function (data) {
                if (data.rentVisitTime == undefined) return "";
                return data.rentVisitTime.substring(0, 10);
            }
        }
        , {
            field: 'lampSelectionLogin', width: "80", title: '配灯系统', templet: function (data) {
                if (data.lampSelectionLogin == 1) return "是";
                else return "否";
            }
        }
        , {
            field: 'isConcern', width: "80", title: '关注', templet: function (data) {
                if (data.isConcern == 1) return "是";
                else return "否";
            }
        }
        , {width: "120", title: '操作', toolbar: "#tool"}
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