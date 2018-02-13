//切换排序按钮样式
$(".wall_nav_box a").on("click", function () {
    if (!$(this).hasClass("active")) {
        $(this).addClass("active").siblings().removeClass("active");
        if ($(this).text() == "推荐") {
            sortFoucs = sortHot;
            $(".oneProduct").remove();
        }
        if ($(this).text() == "最新") {
            sortFoucs = sortOnlineTime;
            $(".oneProduct").remove();
        }
        if ($(this).text() == "价格") {
            sortFoucs = sortMoney;
            $(".oneProduct").remove();
        }
        offset = 0;//清空当前分页值
        sortFoucs.offset = 0;//清空当前分页
        bottomFalg = false;//清空到底标识
        loadProduct();
    }
});
/*筛选*/
$(".weui_navbar_item").click(function () {
    $(".screen").show();
});
$(".cancelBtn").click(function () {
    $(".screen").hide();
});
$(".screen-div>.filterProperty>div>ul>li").click(function () {
    $(this).find("a").addClass("active");
})

//初始化时加载产品
window.onload = function () {
    sortFoucs = sortHot;//设置当前排序方式
    loadProduct();
}

//产品列表页面游标
var offset = 0;
//每页产品个数
var items = 10;
//到达底部标识
var bottomFalg = false;

//当前排序
var sortFoucs = {};
//热门排序(按照销量)
var sortHot = {
    "sortStr": "product_sales",
    "sortType": "desc",
    "offset": offset,
    "item": items
};
//金额排序(按照价格)
var sortMoney = {
    "sortStr": "unit_price",
    "sortType": "desc",
    "offset": offset,
    "item": items
};
//最新排序(按照上线时间)
var sortOnlineTime = {
    "sortStr": "online_time",
    "sortType": "desc",
    "offset": offset,
    "item": items
};

//获取产品列表
function loadProduct() {
    $.ajax({
        url: "/api/product/list",
        dataType: "json",
        data: sortFoucs,
        type: "post",
        success: function (data) {
            if (data.length != 0) {
                addProductDom(data);
                //设置数据偏移值
                sortFoucs.offset += items;
            } else if ($(".oneProduct").length == 0) {
                $(".noProduct").show();
            } else {
                $(".jiazai").html("<p style='position: relative;font-size: 15px;bottom: 75px;left: 0;'>已经到底部了!</p>");
                $(".jiazai").show();
                bottomFalg = true;
            }
        },
        error: function (data) {
            console.log(JSON.stringify(data));
        }
    });
}

//生成产品列表dom
function addProductDom(data) {
    for (var product in data) {
        product = data[product];
        //产品外层div
        var content = $('<div class="oneProduct"></div>');
        //产品链接a标签
        var aTag = $('<a class="productA" href="/mobilemall/productdetails/' + product.productId + '"></a>');
        //左上角标签
        if (product.productTag != null && product.productTag != undefined && product.productTag != "") {
            var leftTag = $('<div><span>' + product.productTag + '</span></div>');
            content.append(leftTag);
        }
        //产品图片
        var backImage = $('<div class="backImage"><img src="' + urlToThumbnail(product.cover1) + '" /></div>');
        //产品信息
        var productInfo = $('<div class="product-msg">' +
            '<div class="product-name ellipsis-product-name">' + product.productAliasName + '</div>' +
            '<div class="product-value clearfix">' +
            '<div class="fl">¥' + product.unitPrice + '</div>' +
            '<div class="toCartBtn fr"><button><i class="icon iconfont icon-gouwuche" style="font-size: .6rem;"></i></button></div>' +
            '</div></div>');
        //添加到文档流	
        aTag.append(backImage);
        aTag.append(productInfo);
        content.append(aTag);
        $(".twoProduct").append(content);
    }
}

//开始加载中
$(document).ready(function () {
    $(window).scroll(function () {
        if ($(document).scrollTop() >= $(document).height() - $(window).height()) {
            $(".jiazai").show();//加载中提醒
            if (!bottomFalg)
                loadProduct();
        }
    });
});

//图片路径转换为缩略图路径
function urlToThumbnail(url) {
    var foucs = url.lastIndexOf("/");
    if (url.indexOf("thumbnailImage/") == -1) {
        url = url.substring(0, foucs) + "/thumbnailImage" + url.substring(foucs, url.length)
    }
    return url;
}