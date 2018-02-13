//产品缩略图路径
var ProductThumbnailSrc = "${ProductThumbnailSrc}";

//返回键
$(".back").click(function () {
    history.go(-1);
});

//轮播图
var mySwiper = new Swiper('.carousel', {
    direction: 'horizontal',
    loop: true,
    effect: 'coverflow',
    slidesPerView: 1,
    centeredSlides: true,
    noSwiping: false,
    coverflow: {
        rotate: 30,
        stretch: 10,
        depth: 60,
        modifier: 2,
        slideShadows: true
    },
    pagination: '.swiper-pagination',
});
var swiper = new Swiper('.resemble', {
    pagination: '.swiper-p2',
    slidesPerView: 3,
    paginationClickable: true,
    spaceBetween: 30,
    autoplay: 2000,
    autoplayDisableOnInteraction: false,
    loop: true,
});

/*判断是否在顶部  */
$(window).scroll(function () {
    var top = $(".module-moresku").offset().top;
    var gun = $(window).scrollTop();
    var top1 = top - gun;
    if (top1 <= 0) {
        $(".title_two").css("display", "block");
    } else {
        $(".title_two").css("display", "none");
    }
    var topD = $(".print-details").offset().top;
    var top2 = topD - gun;
    if (top2 <= 0) {
        $(".title_two .picture-detel").addClass("active");
        $(".title_two .parameter").removeClass("active");
    } else {
        $(".title_two .picture-detel").removeClass("active");
        $(".title_two .parameter").addClass("active");
    }
});
$("#toCartDiv").click(function () {
    $(".moveCart").addClass("move");
    setTimeout(function () {
        $(".moveCart").removeClass("move");
    }, 2000)
});
$(".click-jia").click(function () {
    $(this).hide().next().show();
});
//加的效果
$(".increase").click(function () {
    var n = $(this).siblings(".num").val();
    var num = parseInt(n) + 1;
    if (num == 0) {
        return;
    }
    $(this).siblings(".num").val(num);
});
//减的效果
$(".reduce ").click(function () {
    var n = $(this).siblings(".num").val();
    var num = parseInt(n) - 1;
    if (num == 0) {
        return;
    }
    $(this).siblings(".num").val(num);
});


/* 点击添加产品 */
$(".prop-rows-content .prop-list .prop-item").click(function () {
    var th = $(this);
    //点击系列产品刷新界面请求
    if (!$(this).hasClass("active")) {
        $.ajax({
            url: "/api/product/detail/" + $(this).eq(0).attr('id'),
            type: "get",
            dataType: "json",
            success: function (data) {
                reView(data);
                th.removeClass("active");
                th.addClass("active").siblings().removeClass("active");
            },
            error: function (msg) {
                console.log("刷新页面报错");
                console.log(msg);
            }
        });
    }
});

//点击系列产品刷新界面方法
function reView(data) {
    var product = data.product;
    //设置轮播图
    mySwiper.removeAllSlides();
    if (product.cover1 != null)
        mySwiper.appendSlide('<div class="swiper-slide"><div class="backImage"><img src="' + product.cover1 + '"><img src="' + getSaveProductPath(product.cover1) + '" style="z-index:100;position:absolute;top:0;opacity:0;left:0px"></div></div>');
    if (product.cover2 != null)
        mySwiper.appendSlide('<div class="swiper-slide"><div class="backImage"><img src="' + product.cover2 + '"><img src="' + getSaveProductPath(product.cover2) + '" style="z-index:100;position:absolute;top:0;opacity:0;left:0px"></div></div>');
    if (product.cover3 != null)
        mySwiper.appendSlide('<div class="swiper-slide"><div class="backImage"><img src="' + product.cover3 + '"><img src="' + getSaveProductPath(product.cover3) + '" style="z-index:100;position:absolute;top:0;opacity:0;left:0px"></div></div>');
    if (product.cover4 != null)
        mySwiper.appendSlide('<div class="swiper-slide"><div class="backImage"><img src="' + product.cover4 + '"><img src="' + getSaveProductPath(product.cover4) + '" style="z-index:100;position:absolute;top:0;opacity:0;left:0px"></div></div>');
    if (product.cover5 != null)
        mySwiper.appendSlide('<div class="swiper-slide"><div class="backImage"><img src="' + product.cover5 + '"><img src="' + getSaveProductPath(product.cover5) + '" style="z-index:100;position:absolute;top:0;opacity:0;left:0px"></div></div>');
    //设置产品基础信息
    $(".product-word").html(product.productAliasName);
    $(".price-now--price").html(product.retailPrice);

    //设置产品规格参数
    //设置产品尺寸
    var productSize = "";
    if (product.productLength != null) productSize += "长:" + product.productLength;
    if (product.productWidth != null && product.productLength != null) productSize += "*";
    if (product.productWidth != null) productSize += "宽:" + product.productWidth;
    if ((product.productWidth != null || product.productLength != null) && product.productHeight != null) productSize += "*";
    if (product.productHeight != null) productSize += "高:" + product.productHeight;
    if ((product.productWidth != null || product.productLength != null || product.productHeight != null) && product.productDiameter != null) productSize += "*";
    if (product.productDiameter != null) productSize += "直径:" + product.productDiameter;
    $("#productSize").html(productSize);
    $("#productWeight").html(product.productWeight);

    //设置包装尺寸
    var packageSize = "";
    if (product.packageLength != null) packageSize += "长:" + product.packageLength;
    if (product.packageLength != null && product.packageWidth != null) packageSize += "*";
    if (product.packageWidth != null) packageSize += "宽:" + product.packageWidth;
    if ((product.packageLength != null || product.packageWidth != null) && product.packageHeight != null) packageSize += "*";
    if (product.packageHeight != null) packageSize += "高:" + product.packageHeight;
    $("#packageSize").html(packageSize);
    $("#packageWeight").html(product.packageWeight);

    $("#productBrand").html(product.productBrand);//品牌
    $("#type").html(data.type);//类型
    $("#material").html(data.material);//材质
    $("#style").html(data.style);//风格
    $("#lightType").html(data.lightType);//光源类型
    $("#lightNumber").html(product.lightNumber);//光源数量
    $("#productPower").html(product.productPower);//功率
    $("#space").html(product.space);//空间
    $("#productColor").html(product.productColor);//产品颜色
    $("#productCode").html(product.productCode);//产品型号
}

//通过封面地址获取分享图片地址
function getSaveProductPath(url) {
    return url.replace('product', 'saveProduct');
}

//规格参数div隐藏
$(".goods-spec").click(function () {
    $(".info").toggle();
});