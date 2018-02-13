var currPage = 0;//页码，记录当前第几页
var currOrderStatus = 1;//状态
var limit = 10;
var stockedFlag;//加入待发货标识
var ifHappenReturn;//退货
var imgPath = "";
var factoryName;//厂家名字
var orderNumber;//订单号
//var userNickName;//买家名字
//var productName;//产品，名字
if (currOrderStatus == 11) {
    currOrderStatus = 1;
    stockedFlag = 0;
}
$(function () {
    getPicPath();
    orderlistLoad();
    searchContent();
})

/*
 * 获取图片地址前缀
 * */
function getPicPath() {
    $.ajax({
        type: "get",
        url: "/api/urlConfig",
//		data:params,
        dataType: "json",
        success: function (json) {
            //console.log(json)
            imgPath = json.ProductThumbnailSrc;//图片路径
        }
    })
}

/*
 * 点击按钮选择订单状态，并重新加载数据
 * */
function addClick() {
    $(".btnGroup .btn").off("click").on("click", function () {
        var OrderStatus = $(this).attr("data-status");//状态
        if (OrderStatus) {
            //如果点了订单按钮
            if (OrderStatus == 11) {//订单
                currOrderStatus = 1;
                stockedFlag = 0;
            }
            //如果点了退款退货按钮
            else if (OrderStatus == "return") {
                currOrderStatus = 1;
                stockedFlag = 0;
                ifHappenReturn = true;
            }
            //如果点了其他按钮
            else {
                //将其他按钮的状态作为查询订单的状态
                currOrderStatus = OrderStatus;
            }
            currPage = 0;
            orderlistLoad();
        }
        $(this).addClass("btn-primary").siblings().removeClass("btn-primary");
    })
}

/*
 * 点击页码按钮跳转到对应分页
 * */
function goPage() {
    $(".pagination").off("click", "a").on("click", "a", function () {
        //得到用户到底点击的是哪一个操作按钮（首页，上一页，下一页，末页）
        var option = $(this).attr("data-page")
        var pageSum = parseInt($("#pageSum").html());
        //点击了第一页
        if (option == 'first' && currPage != 0) {
            currPage = 0;
        }
        //点击了上一页
        else if (option == "pre" && currPage != 0) {
            currPage = currPage - 1 < 0 ? 0 : currPage - 1;
        }
        //点击了下一页
        else if (option == "next" && currPage != pageSum - 1) {
            currPage = currPage + 1 > pageSum - 1 ? pageSum - 1 : currPage + 1;
        }
        //点击了最后一页
        else if (option == "last" && currPage != pageSum - 1) {
            currPage = pageSum - 1;
        }
        //点击了跳转按钮
        else if (option == "go") {
            var page = $("#pagingNum").val();
            if (page > pageSum) {
                currPage = pageSum - 1;
            }
            if (page == 0) {
                currPage = 0;
            } else {
                page = parseInt(page) - 1;
                if (page != currPage) {
                    currPage = page;
                }
            }
        }
        orderlistLoad();

    })

    $(".paging-center").off("click", "input").on("click", "input", function () {
        //得到用户到底点击的是哪一个操作按钮（首页，上一页，下一页，末页）
        var option = $(this).attr("data-page")
        var pageSum = parseInt($("#pageSum").html());
        //点击了跳转按钮
        if (option == "go") {
            var page = $("#pagingNum").val();
            if (page > pageSum) {
                currPage = pageSum - 1;
            }
            if (page == 0) {
                currPage = 0;
            } else {
                page = parseInt(page) - 1;
                if (page != currPage) {
                    currPage = page;
                }
            }

            orderlistLoad();
        }


    })
    $("#btn_search").off("click").on("click", function () {
        factoryName = $('.factorySelect').find("option:selected").text();
        orderNumber = $('.orderNumber').val();
        /*userNickName = $('.userNickName').val();
        productName = $('.productName').val();*/
        currOrderStatus = 1;
        orderlistLoad();

    })
}

/*
 * 订单加载
 * */
function orderlistLoad() {
    var params = {offset: currPage, limit: limit, orderStatus: currOrderStatus};
    if (stockedFlag) {
        params.stockedFlag = stockedFlag;
    }
    if (ifHappenReturn) {
        params.ifHappenReturn = 1;
        params.ifHappenRefund = 1;
    }
    if (factoryName) {
        params["seller.shortCompanyName"] = factoryName;
    }
    if (orderNumber) {
        params.orderNumber = orderNumber;
    }
    /*	if(userNickName){
            params["seller.userNickName"]=userNickName;
        }
        if(productName){
            params.productName=productName;
        }*/
    $.ajax({
        type: "get",
        url: "/admin/api/orderForm",
        data: params,
        dataType: "json",
        success: function (json) {
            //声明一个字符串，用来保存遍历生成的html代码
            var str = "";
            if (!ifHappenReturn) {
                str += "<thead><tr><th class='text-center'>订单号</th>";
                str += "<th class='text-center'>卖家</th>";
                str += "<th class='text-center'>买家</th>";
                str += "<th class='text-center'>编号</th>";
                if (currOrderStatus != 0) {
                    str += "<th class='text-center'>客服</th>";
                }
                str += "<th>订单总额</th>";
                if (currOrderStatus != 0) {
                    str += "<th class='text-center'>下单时间</th>";
                }
                str += "<th class='text-center'>客户备注</th>";
                if (currOrderStatus == 2 || currOrderStatus == 3 || currOrderStatus == 4) {
                    str += "<th class='text-center'>发货时间</th>";
                }
                if (currOrderStatus != 0 && currOrderStatus != 2 && currOrderStatus != 3 && currOrderStatus != 4 && currOrderStatus != 5) {
                    str += "<th class='text-center'>操作</th>";
                }
                str += "<th class='text-center'>产品名</th>";
                str += "<th class='text-center'>产品图片</th>";
                str += "<th class='text-center'>数量</th>";
                if (currOrderStatus != 0 && currOrderStatus != 2 && currOrderStatus != 3 && currOrderStatus != 4 && currOrderStatus != 5) {
                    str += "<th class='text-center'>已收货数量</th>";
                    str += "<th class='text-center'>急单</th>";
                    str += "<th class='text-center'>现货数</th>";
                    str += "<th class='text-center'>备货数</th>";
                    str += "<th class='text-center'>交货期</th>";
                    str += "<th class='text-center'>员工备注</th>";
                }
                str += "<th class='text-center'>单价</th>";
                str += "</tr></thead>";
                //遍历请求到的数据中的rows属性
                for (var i = 0; i < json.rows.length; i++) {
                    var order = json.rows[i].orderForm;
                    var products = json.rows[i].orderItemList;
                    var pl = products.length;
                    for (var j = 0; j < products.length; j++) {
                        str += "<tr>";
                        if (j == 0) {
                            str += "<td rowspan='" + pl + "'>" + order.orderNumber + "</td>";//订单号
                            str += "<td rowspan='" + pl + "'>" + (order.seller.shortCompanyName ? order.seller.shortCompanyName : "") + "</td>";//卖家名字
                            str += "<td rowspan='" + pl + "'>" + (order.buyer.userNickname ? order.buyer.userNickname : "") + "</td>";//买家名字
                            str += "<td rowspan='" + pl + "'>" + order.seller.userIdenticalCode + "</td>";//编号
                            if (currOrderStatus != 0) {
                                //str+="<td rowspan='"+pl+"'>"+order.upUser.userNickname+"</td>";//客服
                                str += "<td rowspan='" + pl + "'>客服</td>";//客服
                            }
                            str += "<td rowspan='" + pl + "'>" + order.orderMoney + "</td>";//订单总额
                            if (currOrderStatus != 0) {
                                str += "<td rowspan='" + pl + "'>" + (order.orderTime ? order.orderTime : "") + "</td>";//下单时间
                            }
                            //str+="<td rowspan='"+pl+"'>"+(order.orderRemark?order.orderRemark:"")+"</td>";//客户备注
                            str += "<td rowspan='" + pl + "'><input type='text' placeholder='客户备注' value='" + (order.orderRemark ? order.orderRemark : "") + "'/></td>";//客户备注
                        }
                        if (currOrderStatus == 2 || currOrderStatus == 3 || currOrderStatus == 4) {
                            str += "<td>" + order.sendTime + "</td>";//发货时间
                        }
                        if (currOrderStatus != 0 && currOrderStatus != 2 && currOrderStatus != 3 && currOrderStatus != 4 && currOrderStatus != 5) {
                            str += "<td><input type='checkbox'/></td>";//操作
                        }
                        str += "<td>" + products[j].product.productName + "</td>";//产品名
                        str += "<td><img width='80' height='80' src='" + (products[j].product.productPngPic ? (imgPath + products[j].product.productPngPic) : "img/defaultImg.jpg") + "'></td>";//产品图片
                        str += "<td ><div class='input-group'><span class='input-group-addon minus'>-</span>" +
                            "<input type='text' class='number form-control input-sm text-center' value='" + (products[j].orderItemNumber ? products[j].orderItemNumber : 0) + "' />" +
                            "<span class='input-group-addon plus'>+</span></div></td>";
                        if (currOrderStatus != 0 && currOrderStatus != 2 && currOrderStatus != 3 && currOrderStatus != 4 && currOrderStatus != 5) {
                            str += "<td>" + (products[j].receiveNumber ? products[j].receiveNumber : 0) + "</td>";//已收货数量
                            str += "<td>" + (products[j].isRushOrder ? (products[j].isRushOrder = 1 ? '是' : '否') : "") + "</td>";//急单
                            str += "<td>" + (products[j].spotGoodsNum ? products[j].spotGoodsNum : 0) + "</td>";//现货数
                            str += "<td>" + (products[j].haveGoodsNum ? products[j].haveGoodsNum : 0) + "</td>";//备货数
                            str += "<td>" + (products[j].consignmentTime ? products[j].consignmentTime : "") + "</td>";//交货期
                            // str+="<td>"+(products[j].orderItemRemark?products[j].orderItemRemark:"")+"</td>";//员工备注
                            str += "<td><input type='text' placeholder='客户备注' value='" + (products[j].orderItemRemark ? products[j].orderItemRemark : "") + "'/></td>";//员工备注
                        }
                        str += "<td>" + products[j].orderItemPrice + "</td>";//单价
                        str += "</tr>";
                    }
                }
            }
            if (ifHappenReturn) {
                str += "<thead><tr><th class='text-center'>订单号</th><th class='text-center'>退款号</th><th class='text-center'>卖家</th>";
                str += "<th class='text-center'>买家</th><th class='text-center'>退款金额</th><th class='text-center'>商品图片</th>";
                str += "<th class='text-center'>产品型号</th><th class='text-center'>产品价格</th><th class='text-center'>数量</th>";
                str += "<th class='text-center'>退款时间</th><th class='text-center'>状态</th><th class='text-center'>操作</th></thead>";
                //遍历请求到的数据中的rows属性
                for (var i = 0; i < json.rows.length; i++) {
                    var order = json.rows[i].orderForm;
                    var products = json.rows[i].orderItemList;
                    var pl = products.length;
                    for (var j = 0; j < products.length; j++) {
                        str += "<tr>";
                        str += "<td>" + order.orderNumber + "</td>";//订单号
                        str += "<td>" + (products[j].returnRecord.buyerCapitalFlowId ? products[j].returnRecord.buyerCapitalFlowId : "") + "</td>";//退款编号
                        str += "<td>" + (order.seller.shortCompanyName ? order.seller.shortCompanyName : "") + "</td>";//卖家名字
                        str += "<td>" + (order.buyer.userNickname ? order.buyer.userNickname : "") + "</td>";//买家名字
                        str += "<td>" + products[j].returnRecord.returnInfoMoney + "</td>";//退款金额
                        str += "<td><img width='80' height='80' src='" + (products[j].product.productPngPic ? (imgPath + products[j].product.productPngPic) : "img/defaultImg.jpg") + "'></td>";//产品图片
                        str += "<td>" + products[j].product.productCode + "</td>";//产品型号
                        str += "<td>" + products[j].orderItemPrice + "</td>";//单价
                        str += "<td>" + (products[j].orderItemNumber ? products[j].orderItemNumber : 0) + "</td>";//数量
                        // str+="<td>"+(products[j].refundStatus?(products[j].refundStatus):(products[j].returnStatus))+"</td>";//状态
                        /* if(products[j].returnRecord && products[j].refundStatus==1){
                             str+="<td>退款申请中</td>";//状态
                         }
                         if(products[j].returnRecord && products[j].refundStatus==2){
                             str+="<td>退款失败</td>";//状态
                         }*/
                        str += "<td>" + (products[j].returnRecord.refundTime ? products[j].returnRecord.refundTime : "") + "</td>";//退款时间
                        if (order.ifHappenReturn == 1) {//退货
                            if (products[j].returnStatus == 1) {
                                str += "<td>退货申请中</td>";//状态
                                str += "<td></td>";
                            }
                            if (products[j].returnStatus = 2) {
                                str += "<td>退货失败</td>";//状态
                                str += "<td></td>";
                            }
                            if (products[j].returnStatus == 3) {
                                str += "<td>买家待发货</td>";//状态
                                str += "<td></td>";
                            }
                            if (products[j].returnStatus == 4) {
                                str += "<td>卖家待收货</td>";//状态
                                str += "<td><button onclick='throughRefund(" + products[j].returnRecord.returnInfoId + ")'>退款</button></td>";
                            }
                            if (products[j].returnStatus == 5) {
                                str += "<td>退货成功</td>";//状态
                                str += "<td><button>打款</button></td>";
                            }
                        } else if (order.ifHappenRefund == 1) {//退款
                            if (products[j].refundStatus == 1) {
                                str += "<td>退款申请中</td>";//状态
                                str += "<td><button onclick='throughRefund(" + products[j].returnRecord.returnInfoId + ")'>退款</button></td>";
                            }
                            if (products[j].refundStatus == 2) {
                                str += "<td>退款失败</td>";//状态
                                str += "<td></td>";
                            }
                            if (products[j].refundStatus == 3) {
                                str += "<td>退款成功</td>";//状态
                                str += "<td><button>打款</button></td>";
                            }
                        }
                        str += "</tr>";
                    }
                }
            }
            //console.log(json);
            $("table").html(str);
            $("table tbody td").css({"vertical-align": "middle", "textAlign": "center"});
            var pageSum = Math.ceil(json.total / 10);
            /*str = '<button type="button" class="btn btn-default btn-primary" data-page="first">首页</button>';
            str += '<button type="button" class="btn btn-default btn-primary" data-page="pre">上一页</button>';
            str += '第<input type="number" id="currPage" value="'+(currPage+1)+'">页 / 第<span id="pageSum"> '+pageSum+'</span> 页 ';
            str += '<button type="button" class="btn btn-default btn-primary" data-page="go">跳转</button>';
            str += '<button type="button" class="btn btn-default btn-primary" data-page="next">下一页</button>';
            str += '<button type="button" class="btn btn-default btn-primary" data-page="last">末页</button>';
            $("div.pagination").html(str);*/

            str = '<ul class="pagination-sm pagination">';
            str += '<li><a data-page="first">首页</a></li>';
            str += '<li><a data-page="pre">上一页</a></li>';
            //str +='<li><a class="pageIndex">第'+(currPage+1)+'页/共'+pageSum+'页</a></li>';
            str += '<li><a class="pageIndex">第<span id="currPage">' + (currPage + 1) + '</span>页/共<span id="pageSum">' + pageSum + '</span>页</a></li>';
            str += '<li><a data-page="next">下一页</a></li>';
            str += '<li><a data-page="last">尾页</a></li>';
            str += '</ul>';
            str += '<div class="paging-search">';
            str += '<div><span class="pagingNum"><input type="number"  id="pagingNum" value="' + (currPage + 1) + '"></span></div>';
            str += '<div><span class="pagingSearch"><input type="button" data-page="go" value="跳转"></span></div>';
            str += '</div>'
            $(".pagination-detail .paging-center").html(str);

            addClick();
            goPage();
            stockedFlag = 0;
            ifHappenReturn = false;
            factoryName = "";

        },
        error: function () {
            stockedFlag = 0;
        }
    });
}

/*
 * 搜索
 * */
function searchContent() {
    $.ajax({
        type: "get",
        url: "/admin/api/select/user",
        data: {role: 1},
        dataType: "json",
        success: function (json) {
            console.log(json);
            var data = [];
            //将接口获得的数据转换为[{id:xx,text:xx},{id:xx,text:xx},{id:xx,text:xx}]的形式，因为select2要求必须是这种格式
            json.forEach(function (v) {
                //如果id和名称都存在的话
                if (v[1] && v[0]) {	//将id和名称作为下拉框的一个选项
                    data.push({id: v[0], text: v[1]});
                }
            })
            //厂家名称
            $('.factorySelect').select2({
                width: '196px', //需要覆盖已更改的默认值;
                data: data,
                placeholder: "请选择厂家",
                allowClear: true,
            })

        }
    });

}

   


