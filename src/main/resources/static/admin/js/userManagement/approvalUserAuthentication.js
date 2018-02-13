var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/certificationApplication'
    , page: true
    , id: "table"
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
        {field: 'userId', title: '用户ID', width: "80"}
        , {field: 'companyName', title: '公司名', width: "180"}
        , {field: 'legalPerson', title: '真名', width: "80"}
        , {field: 'businessLicenceNumber', title: '执照号', width: "80"}
        , {
            title: '正面照', width: "80", templet: function (data) {
                if (data.lpIdcardFrontPic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.lpIdcardFrontPic + '" class="img-rounded" >';
            }
        }
        , {
            title: '反面照', width: "80", templet: function (data) {
                if (data.lpIdcardBackPic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.lpIdcardBackPic + '" class="img-rounded" >';
            }
        }
        , {
            title: '手持', width: "80", templet: function (data) {
                if (data.lpHandheldIdcardPic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.lpHandheldIdcardPic + '" class="img-rounded" >';
            }
        }
        , {
            title: '营业执照', width: "86", templet: function (data) {
                if (data.businessLicencePic == undefined) return "";
                return '<img style="width:50px;height:50px;" src="' + data.businessLicencePic + '" class="img-rounded" >';
            }
        }
        , {field: 'contact', width: "120", title: '联系电话'}
        , {
            field: 'submitTime', sort: true, width: "110", title: '提交时间', templet: function (data) {
                if (data.submitTime == undefined) return "";
                return data.submitTime.substring(0, 10);
            }
        }
        , {
            field: 'checkStatus', title: '状态', width: "80", templet: function (data) {
                switch (data.checkStatus) {
                    case 1:
                        return "待审批";
                    case 2:
                        return "失败";
                    case 3:
                        return "通过";
                    default:
                        return "未知";
                }
            }
        }
        , {
            title: '类型', width: "80", templet: function (data) {
                if (data.role == undefined || data.role.roleName == undefined)
                    return "未知";
                return data.role.roleName;
            }
        }
        , {field: 'companyAddressDetail', width: "180", title: '详细地址'}
        , {field: 'shortCompanyName', width: "120", title: '公司简称'}
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
    data = data.data;
    if (data.checkStatus != 1) {
        layer.msg('该申请表不在待审批状态!');
        return;
    }
    if (data.role == undefined || data.role.roleName == undefined) {
        data.role = {};
        data.role.roleName = "未知角色";
    }
    layer.open({
        title: '审批用户认证'
        , content: '<p>同意' + data.legalPerson + '的申请成为' + data.role.roleName + '的请求?</p>'
        , btn: ['同意', '拒绝', '返回']
        , btn1: function (index, layero) {
            sendApproval(data.applyId, 3);
            table.reload('table', {});
        }
        , btn2: function (index, layero) {
            sendApproval(data.applyId, 2);
            table.reload('table', {});
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
function sendApproval(applyId, checkStatus) {
    $.ajax({
        url: "/admin/api/certificationApplication",
        dataType: "json",
        type: "put",
        data: {
            "applyId": applyId,
            "checkStatus": checkStatus
        },
        success: function (json) {
            layer.msg(json.msg);
        },
        error: function (data) {
            layer.msg("请求错误!");
        }
    });
}