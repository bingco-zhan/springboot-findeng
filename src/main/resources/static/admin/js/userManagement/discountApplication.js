var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/discountApplication'
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
                return data.user.userId;
            }
        }
        , {
            title: '用户昵称', templet: function (data) {
                return data.user.userNickname;
            }
        }
        , {field: 'title', title: '折扣标题'}
        , {field: 'welcomeTitle', title: '购买证明'}
        , {
            field: 'creatTime', sort: true, title: '申请时间', templet: function (data) {
                if (data.creatTime == undefined) return "";
                return data.creatTime.substring(0, 10);
            }
        }
        , {
            field: 'checkTime', sort: true, title: '审核时间', templet: function (data) {
                if (data.checkTime == undefined) return "";
                return data.checkTime.substring(0, 10);
            }
        }
        , {
            title: '状态', templet: function (data) {
                switch (data.status) {
                    case 0:
                        return "待审核";
                    case 1:
                        return "审核通过";
                    case 2:
                        return "审核拒绝";
                    default:
                        return "未知";
                }
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
    data = data.data;
    if (data.status != 0) {
        layer.msg('该申请表不在待审批状态!');
        return;
    }
    layer.open({
        title: '审批用户折扣'
        , content: '<p>同意[' + data.user.userNickname + ']的折扣申请?</p>'
        , btn: ['同意', '拒绝', '返回']
        , btn1: function (index, layero) {
            sendApproval(data.id, 1);
        }
        , btn2: function (index, layero) {
            sendApproval(data.id, 2);
        }
        , btn3: function (index, layero) {
        }
    });
});

/**
 * 发送审批认证请求
 * @param applyId 认证表id
 * @param checkStatus 审批状态2-成功,3-拒绝
 */
function sendApproval(id, status) {
    $.ajax({
        url: "/admin/api/discountApplication/approval",
        dataType: "json",
        type: "put",
        data: {
            "id": id,
            "status": status
        },
        success: function (json) {
            layer.msg(json.msg);
            if (json.code == 3) {
                table.reload('table', {});
            }
        },
        error: function (data) {
            layer.msg("请求错误!");
        }
    });
}