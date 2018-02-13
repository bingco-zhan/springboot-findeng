/**
 * Created by findeng on 2018/1/27.
 */
//设置距离底部的距离
$(".productDetails ").css("margin-bottom", $("footer").outerHeight());
var mySwiper1 = new Swiper('.swiper-product', {
    direction: 'horizontal',
    //loop: true,
    autoplay: 3000,
    autoplayDisableOnInteraction: false,
    speed: 800,
    effect: 'coverflow',
    slidesPerView: 1,
    centeredSlides: true,
    coverflow: {
        rotate: 30,
        stretch: 10,
        depth: 60,
        modifier: 2,
        slideShadows: true
    },
    observer: true,
    observeParents: false,
    onSlideChangeEnd: function (swiper) {
        swiper.update();
    },
    pagination: '.sp1'
});
$(function () {
    var he = mySwiper1.width;
    $(".swiper-product .swiper-slide").css("height", he);
});

var mySwiper1 = new Swiper('.guess-like', {
    direction: 'horizontal',
    loop: true,
    autoplay: 3000,
    autoplayDisableOnInteraction: false,
    speed: 800,
    effect: 'coverflow',
    slidesPerView: 1,
    centeredSlides: true,
    coverflow: {
        rotate: 30,
        stretch: 10,
        depth: 60,
        modifier: 2,
        slideShadows: true
    },
    pagination: ".swiper-paginationLike"
});

$(".fd-details .fd-row:nth-child(1) div").click(function () {
    $(this).addClass("active").siblings().removeClass("active");
    if ($(".fd-details .fd-row:nth-child(1) div:nth-child(1)").hasClass("active")) {
        $(".product-norms").hide();
        $(".product-details").show()
    } else if ($(".fd-details .fd-row:nth-child(1) div:nth-child(2)").hasClass("active")) {
        $(".product-norms").show();
        $(".product-details").hide();
    }
});
/**/
$(window).scroll(function () {
    var top = $(".fd-details").offset().top;
    var gun = $(window).scrollTop();
    var top1 = top - gun;
    if (top1 <= 0) {
        $(".fd-details .fd-row:nth-child(1)").addClass("nav-list-scroll");
        //$(".new-nav-list-scroll").css("top",$(".form-group").height()+10)
    } else {
        $(".fd-details .fd-row:nth-child(1)").removeClass("nav-list-scroll");
    }
});
//加的效果
$(".increase").click(function () {
    var n = $(this).siblings().find(".number").val();
    var number = parseInt(n) + 1;
    if (number == 0) {
        return;
    }
    $(this).siblings().find(".number").val(number);
});
//减的效果
$(".reduce ").click(function () {
    var n = $(this).siblings().find(".number").val();
    var number = parseInt(n) - 1;
    if (number == 0) {
        return;
    }
    $(this).siblings().find(".number").val(number);
});

function specslection1(s1) {
    /*选择规格*/
    $(s1).click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        } else {
            $(this).addClass("active").parent('[class*="fd-col-xs"]').siblings().find(".fd-media-list-item-inner").removeClass("active");
        }
    });
}

/*加入购物车*/
$(".add-shoppingCart").click(function () {
    $(".fooCartNum").html((parseInt($(".fooCartNum").text())) + (parseInt($(".number").val())));
});
/*立即购买*/
$(".once-buy").click(function () {

});

// ----------------------------------------------------------------------------- //
/*
 * 详情页里有 var seriesList 同系列商品,在此处做选择联动.......
 */

var color = new Array();
var lightColor = new Array();

function initSpec() {
    for (var x = 0; x < seriesList.length; x++) {
        if (!xxoo(color, seriesList[x].productColor)) {
            color.push(seriesList[x].productColor);
        }

        if (!xxoo(lightColor, seriesList[x].lightColor)) {
            lightColor.push(seriesList[x].lightColor);
        }
    }
}

initSpec();

// 生成类别	------s-------->>>>
for (var x in color) {
    var color_html = "<div class='fd-col-xs-4 fd-text-center'><div class='fd-media-list-item-inner'>" +
        "<div class='fd-list-item-inner fd-ellipsis-1 fd-font-size-14'>" + color[x] + "</div></div></div>";
    $(".lamp-color").append(color_html);
}

for (lt in lightColor) {
    var lightColor_html = "<div class='fd-col-xs-3'><div class='fd-media-list-item-inner'>" +
        "<div class='fd-list-item-inner fd-ellipsis-1 fd-font-size-14 fd-text-center'>" +
        lightColor[lt] + "</div></div></div>";
    $(".lamp-lightColor").append(lightColor_html);
}
specslection1(".norms .fd-media-list-item-inner");
//生成类别		-------e------->>>>

//生成商品列表		------s----->>>>
$(".lamp-color, .lamp-lightColor > div").click(function () {
    $(".lamp-spec").empty("div").append("<p class='fd-padded-t-5 fd-padded-l-5'>规格</p>");
    // 如果颜色和光色都被选中
    if ($(".lamp-lightColor .active").length > 0 && $(".lamp-color .active").length > 0) {

        for (x in seriesList) {
            if (xxooxxoo(seriesList[x], $(".lamp-color .active > div").text(), $(".lamp-lightColor .active > div").text())) {
                var product_html = "<div class='fd-col-xs-6'><div class='fd-media-list-item-inner' data-id='" + seriesList[x].productId + "'><div class='fd-list-item-media'>" +
                    "</div><div class='fd-list-item-inner fd-ellipsis-1 fd-font-size-14'>" + seriesList[x].productName + "</div></div></div>";
                $(".lamp-spec").append(product_html);
            }
        }

        specslection2(".lamp-spec .fd-media-list-item-inner");
    }
});

//生成商品列表		------e----->>>>

function specslection2(s1) {
    /*选择规格*/
    $(s1).click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        } else {
            $(this).addClass("active").parent('[class*="fd-col-xs"]').siblings().find(".fd-media-list-item-inner").removeClass("active");

            $.ajax({
                url: '/mobilemall/productAjax/' + $(this).attr("data-id"),
                dataType: 'json',
                type: 'GET',
                async: false,
                success: function (data, status, XHR) {
                    loadData(data);
                },
                error: function (XHR, sttaus, error) {
                    alert("Error !");
                }
            });
        }
    });
}

/**
 * 加载商品信息
 * @param product
 */
function loadData(product) {
    console.log(product);
    var $sw = $(".swiper-product .swiper-wrapper").empty();
    //var covers = product.cover.split(",");
    for (var x = 0, covers = product.cover.split(","), len = covers.length; x < len; x++) {
        $sw.append("<div class='swiper-slide'><img src='http://findeng.com:8080/findeng/picture/product/" + covers[x] + "'></div>");
    }
    $("#fd-pname").text(product.productName);
    $("#lightType").text(product.light_Type);
    $("#lightNumber").text(product.lightNumber);
    $("#productPower").text(product.productPower);
    $("#space").text(product.productSpace);
    $("#productColor").text(product.productColor);
    $("#productCode").text(product.productCode);
    $("#productSize").text(" 长: " + product.productLength + "  宽: " + product.productWidth + "  高: " + product.productHeight);
    $("#productWeight").text(product.productWeight);
    $("#packageSize").text(" 长: " + product.packageLength + "  宽: " + product.packageWidth + "  高: " + product.packageHeight);
    $("#packageWeight").text(product.packageWeight);
}

//----------------------------------------------------------------------------- //

function xxoo(array, e1) {
    for (var x = 0; x < array.length; x++) {
        if (e1 == "" || array[x] == e1) {
            return true;
        }
    }
    return false;
}

function xxooxxoo(element, color, lightColor) {
    if (element.productColor == color && element.lightColor == lightColor) {
        return true;
    } else
        return false;
}