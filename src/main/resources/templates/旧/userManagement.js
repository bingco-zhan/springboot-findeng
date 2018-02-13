var role;
//搜索的参数
var userId = "";
var upperUserId = "";
var userNickname = "";
var companyName = "";
var isSearch = false;
//页面初始化
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

    //3.加载用户角色
    $.ajax({
        url: "/admin/api/userRole/all",
        dataType: "json",
        type: "get",
        success: function (json) {
            role = json;
            //初始化用户角色选择
            for (var index in role) {
                $("#role").append("<option value='" + role[index].id + "'>" + role[index].roleName + "</option>");
            }
        },
        error: function () {
            console.log("获取用户角色失败!");
        }
    });
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table').bootstrapTable({
            url: '/admin/api/user',         //请求后台的URL（*）
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",//请求头数据
            method: 'get',                      //请求方式（*）
            dataType: 'json',					//返回数据类型
            toolbar: '#toolbar',                //工具按钮用哪个容器
            undefinedText: "-",					//空值时显示字符
            striped: false,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        		//可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,					//设置为 true启用 全匹配搜索，否则为模糊搜索
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            onDblClickRow: onDblClickRow,
            uniqueId: "userId",                 //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            idField: "userId",					//指定主键列
            singleSelect: true,					//禁止多选
            columns: [{
                title: '选中',
                checkbox: true,
                align: 'center'
            }, {
                field: 'userId',
                title: 'id',
                align: 'center'
            }, {
                field: 'upperUserId',
                title: '上级id',
                align: 'center'
            }, {
                field: 'userNickname',
                title: '昵称',
                align: 'center'
            }, {
                field: 'userProtraitPic',
                title: '头像',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == undefined) {
                        index = "img/default_avatar.jpg";
                    }
                    return '<img onerror="imgError(this)" style="width:50px;height:50px" src="' + value + '" class="img-rounded" >';
                }
            }, {
                field: 'phoneNumber',
                title: '电话',
                align: 'center',
                visible: false
            }, {
                field: 'openId',
                title: '微信id',
                align: 'center',
                visible: false
            }, {
                field: 'role',
                title: '角色',
                align: 'center',
                formatter: function (value, row, index) {
                    for (var i in role) {
                        if (role[i].id == value) {
                            return role[i].roleName
                        }
                    }
                }
            }, {
                field: 'withdrawMoney',
                title: '已提现',
                align: 'center'
            }, {
                field: 'flowMoney',
                title: '可支配',
                align: 'center'
            }, {
                field: 'pendingMoney',
                title: '待结算',
                align: 'center'
            }, {
                field: 'qqNumber',
                title: 'qq',
                visible: false,
                align: 'center'
            }, {
                field: 'email',
                title: '邮箱',
                visible: false,
                align: 'center'
            }, {
                field: 'companyName',
                title: '公司名',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value != "" && value != undefined)
                        return '<div style="width:100px">' + value + '</div>';
                    else
                        return "-";
                }
            }, {
                field: 'companyAddressDetail',
                title: '地址',
                align: 'center',
                visible: false,
                formatter: function (value, row, index) {
                    if (value != "" && value != undefined)
                        return '<div style="width:100px">' + value + '</div>';
                    else
                        return "-";
                }
            }, {
                field: 'checkStatus',
                title: '审核状态',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == 3) return value = "通过";
                    if (value == 2) return value = "失败";
                    else return value = "待审";
                }
            }, {
                field: 'applyId',
                title: '认证ID',
                align: 'center',
                visible: false
            }, {
                field: 'userIdenticalCode',
                title: '编码',
                align: 'center',
                visible: false
            }, {
                field: 'followTime',
                title: '关注时间',
                align: 'center',
                visible: false
            }, {
                field: 'rentVisitTime',
                title: '上次登录',
                align: 'center'
            }, {
                field: 'lampSelectionLogin',
                title: '配灯系统',
                align: 'center',
                formatter: function (value, row, index) {
                    if (value == 1) return value = "是";
                    else return value = "否";
                }
            }, {
                field: 'isConcern',
                title: '关注',
                align: 'center',
                visible: false,
                formatter: function (value, row, index) {
                    if (value == 1) return value = "是";
                    else return value = "否";
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        if (isSearch) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset / params.limit,  //页码
                userId: userId,
                upperUserId: upperUserId,
                userNickname: userNickname,
                companyName: companyName
            };
        } else {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset / params.limit  //页码
            };
        }

        return temp;
    };

    return oTableInit;
};

//搜索按钮
$("#btn_search").click(function () {
    var search_id = $("#search_id").val();
    var search_upperuserid = $("#search_upperuserid").val();
    var search_nickname = $("#search_nickname").val();
    var search_companyname = $("#search_companyname").val();
    if (search_id != "" && search_upperuserid != ""
        && search_nickname != "" && search_companyname != "") {
        isSearch = false;
        $('#table').bootstrapTable("selectPage", 1);
    } else {
        userId = search_id;
        upperUserId = search_upperuserid;
        userNickname = search_nickname;
        companyName = search_companyname;
        isSearch = true;
        $('#table').bootstrapTable("selectPage", 1);
    }
});

//页面按钮初始化
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        var btn_edit = $("#btn_edit");
        var btn_delete = $("#btn_delete");
    };
    return oInit;
};

//图片加载报错后图片默认值
function imgError(img) {
    img.src = "img/default_avatar.jpg";
}


//修改按钮
$("#btn_edit").click(function () {
    editUser();
});

//修改用户方法
function editUser(row) {
    var Selection = $('#table').bootstrapTable("getSelections")[0];
    if (Selection == undefined) Selection = row;
    if (row != undefined || Selection != undefined) {
        $("#modal_text").css("display", "none");
        $("#delete_content").css("display", "none");
        $("#edit_content").css("display", "block");
        $(".modal-footer").css("display", "block");
        $(".delete").css("display", "none");
        $(".edit").css("display", "block");
        var userId = Selection.userId;//用户id
        var upperUserId = Selection.upperUserId;//上级id
        var userNickname = Selection.userNickname;//昵称
        var phoneNumber = Selection.phoneNumber;//电话号码
        var roleId = Selection.role;//角色id
        var legalPersonName = Selection.legalPersonName;//真实姓名
        var companyAddressDetail = Selection.companyAddressDetail;//公司地址
        var companyName = Selection.companyName;//公司名
        var lampSelectionLogin = Selection.lampSelectionLogin;//配灯系统权限
        var openId = Selection.openId;//微信唯一id
        $("#userId").val(userId);
        $("#upperUserId").val(upperUserId);
        $("#userNickname").val(userNickname);
        $("#phoneNumber").val(phoneNumber);
        $("#role").val(roleId);
        $("#legalPersonName").val(legalPersonName);
        $("#companyName").val(companyName);
        $("#companyAddressDetail").val(companyAddressDetail);
        $("#openId").val(openId);
        $("#lampSelectionLogin").val(lampSelectionLogin);
        $('#modal').modal('show');
    } else {
        var modal_text = $('#modal_text').html("请选中修改项目");
        $("#modal_text").css("display", "block");
        $("#delete_content").css("display", "none");
        $("#edit_content").css("display", "none");
        $(".delete").css("display", "none");
        $(".edit").css("display", "none");
        $('#modal').modal('show');
    }
}

//删除按钮
$("#btn_delete").click(function () {
    var Selection = $('#table').bootstrapTable("getSelections");
    if (Selection.length < 1) {
        var modal_text = $('#modal_text').html("请选中删除项目");
        $("#modal_text").css("display", "block");
        $("#delete_content").css("display", "none");
        $("#edit_content").css("display", "none");
        $(".modal-footer").css("display", "none");
        $(".delete").css("display", "none");
        $(".edit").css("display", "none");
        $('#modal').modal('show');
    } else {
        $("#modal_text").css("display", "none");
        $("#delete_content").css("display", "block");
        $("#edit_content").css("display", "none");
        $(".modal-footer").css("display", "block");
        $(".delete").css("display", "block");
        $(".edit").css("display", "none");
        $('#modal').modal('show');
    }
});

//提交修改请求
function submitEdit() {
    $.ajax({
        url: "/admin/api/user",
        dataType: "json",
        type: "put",
        data: {
            userId: $("#userId").val(),
            upperUserId: $("#upperUserId").val(),
            userNickname: $("#userNickname").val(),
            phoneNumber: $("#phoneNumber").val(),
            role: $("#role").val(),
            legalPersonName: $("#legalPersonName").val(),
            companyName: $("#companyName").val(),
            companyAddressDetail: $("#companyAddressDetail").val(),
            openId: $("#openId").val(),
            lampSelectionLogin: $("#lampSelectionLogin").val()
        },
        success: function (json) {
            //刷新列表
            if (json.code == 1) {
                $('#table').bootstrapTable("refreshOptions", {});
                //显示服务端返回消息
                showDialog(json.msg);
            }
        },
        error: function () {
            showDialog("修改用户失败");
        }
    });
}

//提交删除请求
function submitDelete() {
    var Selection = $('#table').bootstrapTable("getSelections");
    $.ajax({
        url: "/admin/api/user/" + Selection[0].userId,
        dataType: "json",
        type: "delete",
        success: function (json) {
            //刷新列表
            if (json.code == 1) {
                $('#table').bootstrapTable("refreshOptions", {});
                //显示服务端返回消息
                showDialog(json.msg);
            }
        },
        error: function () {
            showDialog("删除用户失败");
        }
    });
}

//操作成功提示
function showDialog(message) {
    var modal_text = $('#modal_text').html(message);
    $("#modal_text").css("display", "block");
    $("#delete_content").css("display", "none");
    $("#edit_content").css("display", "none");
    $(".delete").css("display", "none");
    $(".edit").css("display", "none");
    $('#modal').modal('show');
}

//双击行项目
function onDblClickRow(row, e, field) {
    editUser(row);
}