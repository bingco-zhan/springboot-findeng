var form = layui.form;
var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/customProduct'
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
        {field: 'productId', title: '产品ID', width: "80"}
        , {field: 'productName', title: '产品名', width: "130"}
        , {
            title: '产品图', width: "80", templet: function (data) {
                if (data.cover == undefined) return '<img style="width:50px;height:50px"/>';
                return '<img style="width:50px;height:50px" src="' + data.cover + '" />';
            }
        }
        , {
            title: '现/订货', width: "80", templet: function (data) {
                if (data.productKind == 1) return '<input type="checkbox" checked lay-skin="switch" lay-text="现货|订货">';
                return '<input type="checkbox" lay-skin="switch" lay-text="现货|订货">';
            }
        }
        , {
            field: "unitPrice", title: '价格', width: "80", sort: true, templet: function (data) {
                if (data.unitPrice == undefined) data.unitPrice = 0;
                return data.unitPrice + "元";
            }
        }
        , {
            title: '状态', width: "80", templet: function (data) {
                switch (data.productStatus) {
                    case 2:
                        return "待审批";
                    case 5:
                        return "上架中";
                    case 6:
                        return "已下架";
                    case 7:
                        return "已删除";
                    default:
                        return "未知";
                }
            }
        }
        , {
            field: 'productSales', width: "80", title: '销量', sort: true, templet: function (data) {
                if (data.productSales == undefined) data.productSales = 0;
                return data.productSales + "件";
            }
        }
        , {
            field: 'creatTime', width: "110", title: '创建时间', templet: function (data) {
                if (data.creatTime == undefined) return "";
                return data.creatTime.substring(0, 10);
            }
        }
        , {
            field: 'onlineTime', width: "110", title: '上架时间', templet: function (data) {
                if (data.onlineTime == undefined) return "";
                return data.onlineTime.substring(0, 10);
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
    switch (event) {
        case "dealer":
            title = "注册经销商";
            url = "/admin/userAuthentication/registeredDealer";
            break;
        case "factory":
            title = "注册厂家";
            url = "/admin/userAuthentication/registeredFactory";
            break;
        case "staff":
            title = "注册业务员";
            url = "/admin/userAuthentication/registeredStaff";
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
                    console.log('提交');
                },
                btn2: function (index, layero) {
                    console.log('取消');
                },
                content: ajax.responseText
            });
            layer.full(layerWin);
            form.render('select');
        }
    }
});