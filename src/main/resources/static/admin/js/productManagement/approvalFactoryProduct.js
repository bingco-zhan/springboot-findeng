var form = layui.form;
var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/product'
    , page: true
    , cellMinWidth: 80
    , where: {productStatus: 2}
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
        {field: 'productId', title: '产品ID'}
        , {field: 'productName', width: "200", title: '产品名'}
        , {field: 'productBrand', width: "200", title: '品牌'}
        , {
            title: '产品图', templet: function (data) {
                if (data.cover == undefined) return '<img style="width:50px;height:50px"/>';
                return '<img style="width:50px;height:50px" src="' + data.cover.split(",")[0] + '" />';
            }
        }
        , {
            title: '库存', templet: function (data) {
                if (data.productStock == undefined) data.productStock = 0;
                return data.productStock + "件";
            }
        }
        , {
            field: "originUnitPrice", width: "80", title: '价格', sort: true, templet: function (data) {
                if (data.originUnitPrice == undefined) data.originUnitPrice = 0;
                return data.originUnitPrice + "元";
            }
        }
        , {
            field: "productKind", title: '货型', templet: function (data) {
                switch (data.productKind) {
                    case 0:
                        return "订货";
                    case 1:
                        return "现货";
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
        , {title: '操作', width: "140", toolbar: "#tool"}
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

});

/**
 *监听系列select选择
 **/
form.on('select()', function (data) {
    var productId = data.elem.getAttribute("data-id");
    var seriesId = data.value;
    var arr = new Array();
    arr.push(parseInt(productId));
    if (productId != undefined) {
        $.ajax({
            url: '/admin/api/product/productSeries',
            data: {
                productIds: arr,
                seriesId: seriesId
            },
            dataType: 'JSON',
            type: 'put',
            success: function (data) {
                console.log(data.msg);
                ;
            },
            error: function (err) {
                console.log(err);
            }
        });
    }
});