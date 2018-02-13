var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/capitalFlow'
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
        {field: 'capitalFlowId', title: '流水号', width: "240"}
        , {field: 'orderNumber', title: '订单号', width: "240"}
        , {field: 'wechatPayId', title: '微信支付单号', width: "240"}
        , {field: 'money', title: '金额', sort: true, width: "100"}
        , {
            field: 'capitalFlowType', title: '流水类型', width: "100", templet: function (data) {
                switch (data.capitalFlowType) {
                    case 0:
                        return "微信支付消费";
                    case 1:
                        return "厂家货款";
                    case 2:
                        return "业务员提成";
                    case 3:
                        return "提现到微信钱包";
                    case 4:
                        return "提现到银行卡";
                    case 7:
                        return "退货";
                    case 8:
                        return "退款";
                    case 9:
                        return "平台提成";
                    case 10:
                        return "平台物流费";
                    default:
                        return "未知";
                }
            }
        }
        , {
            field: 'settlementStatus', title: '结算状态', width: "100", templet: function (data) {
                switch (data.settlementStatus) {
                    case 0:
                        return "待结算";
                    case 1:
                        return "结算成功";
                    case 2:
                        return "结算失败";
                    default:
                        return "未知";
                }
            }
        }
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
        , {
            title: '结算用户', width: "100", templet: function (data) {
                return data.user.userNickname;
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