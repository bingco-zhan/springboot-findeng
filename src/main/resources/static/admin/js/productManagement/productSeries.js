var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/productSeries'
    , page: true
    , text: {none: '<button class="layui-btn" lay-submit lay-filter="addSeries">添加系列</button>'}
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
        , {field: 'seriesName', title: '系列名'}
        , {
            field: 'creatTime', title: '创建时间', templet: function (data) {
                if (data.creatTime == undefined) return "";
                return data.creatTime.substring(0, 10);
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

/**
 * 监听工具栏
 */
layui.table.on('tool(table)', function (data) {
    var id = data.data.id;
    if (data.event == "delete") {
        layer.open({
            title: "删除系列",
            type: 1,
            btn: ['删除', '取消'],
            content: '确认删除该系列?(系列下必须没有产品)',
            btn1: function (index, layero) {
                $.ajax({
                    url: '/admin/api/productSeries/' + id,
                    dataType: 'json',
                    type: 'delete',
                    success: function (data) {
                        layer.msg(data.msg);
                        layer.closeAll('page');
                        table.reload({});
                    }
                });
            },
            btn2: function (index, layero) {

            }
        });
    } else {
        addSeries();
    }
});

//监听无数据的时候的添加按钮
layui.form.on('submit(addSeries)', function (data) {
    addSeries();
    return false;
});

//添加系列对话框
function addSeries() {
    var layerWin = layer.open({
        title: "添加系列",
        type: 1,
        btn: ['添加', '取消'],
        btn1: function (index, layero) {
            var value = layero.find("input").val();
            if (value == undefined || value == "") {
                layer.msg("系列名不能为空");
                return false;
            } else {
                $.ajax({
                    url: '/admin/api/productSeries',
                    dataType: 'json',
                    data: {seriesName: value},
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg);
                        if (data.code == 1) {
                            layer.closeAll('page');//关闭所有弹层
                        }
                        table.reload({});
                    }
                });
            }
        },
        btn2: function (index, layero) {

        },
        content: '<input type="text" name="title" placeholder="请输入系列名称" class="layui-input">   '
    });
}