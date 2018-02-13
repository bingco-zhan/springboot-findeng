var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/withdrawalApplication'
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
        {field: 'id', title: 'ID'}
        , {
            title: '提现用户昵称', width: "150", templet: function (data) {
                return data.launchUser.userNickname;
            }
        }
        , {
            title: '审批用户昵称', width: "150", templet: function (data) {
                if (data.applicationUser == undefined) return "";
                return data.applicationUser.userNickname;
            }
        }
        , {field: 'money', title: '金额', sort: true, width: "100"}
        , {
            title: '提现类型', width: "120", templet: function (data) {
                switch (data) {
                    case 3:
                        return "提现到钱包";
                    case 4:
                        return "提现到银行卡";
                    default:
                        return "提现到银行卡";
                }
            }
        }
        , {field: 'remark', width: "200", title: '备注'}
        , {
            field: 'creatTime', width: "110", sort: true, title: '创建时间', templet: function (data) {
                if (data.creatTime == undefined) return "";
                return data.creatTime.substring(0, 10);
            }
        }
        , {
            field: 'settleTime', width: "110", sort: true, title: '结算时间', templet: function (data) {
                if (data.settleTime == undefined) return "";
                return data.settleTime.substring(0, 10);
            }
        }
        , {title: '操作', width: "80", toolbar: "#tool"}
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
    console.log(data);
    layer.open({
        title: '审批用户提现'
        , content: '审批用户提现'
        , btn: ['同意', '拒绝', '返回']
        , btn1: function (index, layero) {
            console.log("同意");
        }
        , btn2: function (index, layero) {
            console.log("拒绝");
        }
        , btn3: function (index, layero) {
            console.log("返回");
        }
    });
});