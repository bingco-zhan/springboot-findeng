//二维码初始化
$(".qrCodeSpan").click(function () {
    getQrCode();
});

function getQrCode() {
    $(".waiting").show();
    $(".shade").show();
    var url = location.href.split('#')[0].replace(/&/g, "-");
    var urlStr = "/wechat/websign?url=" + url;
    $.ajax({
        method: "GET",
        url: urlStr,
        success: function (result, status, jqXHR) {
            var appId = result.appId;
            var signature = result.signature;
            var timestamp = result.timestamp;
            var nonceStr = result.nonceStr;
            wx.config({
                debug: false,
                appId: appId,
                timestamp: timestamp,
                nonceStr: nonceStr,
                signature: signature,
                jsApiList: ['scanQRCode']
            });
            wx.error(function (res) {
                console.log(JSON.stringify(res));
            });
            wx.ready(function () {
                wx.scanQRCode({
                    needResult: 0,
                    scanType: ["qrCode"],
                    success: function (res) {
                        var result = res.resultStr;
                        $(".waiting").hide();
                        $(".shade").hide();
                    }
                });
            });
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("调用扫描二维码失败!");
        }
    });
}

//精品推荐显示数量
var items = 8;

$(".classfiy-btn").click(function () {
    $(".classfiy-div").toggle();
});
$(".classfiy-div").click(function () {
    $(".classfiy-div").show();
});

$(window).scroll(function () {
    if ($(window).scrollTop() > 170) {
        $(".form-group").addClass("form-group-line");
    }
    else if ($(window).scrollTop() < 170) {
        $(".form-group").removeClass("form-group-line");
    }
});
$(window).scroll(function (event) {
    $(".classfiy-div").hide();
});
/*判断是否在顶部  */
$(window).scroll(function () {
    var top = $(".floor_title ").offset().top;
    var gun = $(window).scrollTop();
    var top1 = top - gun;
    if (top1 <= 0) {
        $(".new-nav-list").addClass("new-nav-list-scroll");
    } else {
        $(".new-nav-list").removeClass("new-nav-list-scroll");
    }
});

/*点击精品推荐添加样式*/
$(".new-nav-list .new-nav-wrapper>div>a").click(function () {
    $(this).addClass("active").siblings().removeClass("active");
    $.ajax({
        url: "/api/product/hot/style/" + $(this).attr("data-id") + "?item=" + items,
        dataType: "json",
        type: "GET",
        success: function (result) {
            $('.new-goods-wrapper.clearfix').find('div').remove();
            for (var i = 0; i < result.length; i++) {
                var div = $("<div></div>");
                var a = $("<a href='" + "/mobilemall/productdetails/" + result[i].productId + "'></a>");
                var img = $('<img alt="" src="' + urlToThumbnail(result[i].cover1) + '" width="100%">');
                var div1 = $('<div class="new-goods-wrapper-word">' + result[i].productAliasName + '</div>');
                var div2 = $('<div class="clearfix new-goods-part"></div>');
                var span = $('<span class="new-goods-pric">￥' + result[i].retailPrice + '</span>');
                var span1 = $('<span class="new-goods-cart" data-id ="' + result[i].productId + '"><i class="icon iconfont">&#xe605;</i></span>');
                div.append(a);
                a.append(img);
                a.append(div1);
                a.append(div2);
                div2.append(span);
                div2.append(span1);
                $('.new-goods-wrapper.clearfix').append(div);
            }
            ;
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

/*点击底部图标*/
$(".findeng").click(function () {
    $(this).next().toggle();
});
/*欢迎页*/
$(".skip").click(function () {
    $(".welcomePic-div").hide();
    $(".index").show();
});
$(document).ready(function () {
    $(".welcomePic-div").fadeOut(3000);
    $(".index").fadeIn(1000);
});

var swiper = new Swiper('.seckill-slider', {
    slidesPerView: 3,
    paginationClickable: true,
    spaceBetween: 30,
    autoplay: 3000,
    autoplayDisableOnInteraction: false,
    loop: true,
});
var mySwiper1 = new Swiper('.swiper-container1', {
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
    pagination: '.sp1'
});
var mySwiper2 = new Swiper('.swiper-container2', {
    direction: 'horizontal',
    loop: true,
    autoplay: 3000,
    autoplayDisableOnInteraction: false,
    speed: 800
});
var mySwiper3 = new Swiper('.swiper-container3', {
    direction: 'horizontal',
    loop: true,
    autoplay: 4000,
    autoplayDisableOnInteraction: false,
    speed: 800
});
var mySwiper4 = new Swiper('.swiper-container4', {
    direction: 'horizontal',
    loop: true,
    autoplay: 4000,
    autoplayDisableOnInteraction: false,
    speed: 800,
});
var mySwiper5 = new Swiper('.swiper-container5', {
    direction: 'horizontal',
    loop: true,
    autoplay: 6000,
    autoplayDisableOnInteraction: false,
    speed: 800,
});
var mySwiper6 = new Swiper('.swiper-container6', {
    direction: 'horizontal',
    loop: true,
    autoplay: 8000,
    autoplayDisableOnInteraction: false,
    speed: 800,
});