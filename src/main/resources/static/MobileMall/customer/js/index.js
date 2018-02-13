var isloading = 0;
$(function () {
    $(".fd-classfiy-wrapper").css("top", $(".fd-searchbar").outerHeight());
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
    //同城
    var swiper = new Swiper('.seckill-slider', {
        slidesPerView: 3.5,
        paginationClickable: true,
        spaceBetween: 30,
        // autoplay : 2000,
        autoplayDisableOnInteraction: false,
        loop: true,
        observer: true,
        observeParents: true
    });
    //活动轮播
    var mySwiper = new Swiper('.swiper-activuty', {
        direction: 'horizontal',
        loop: true,
        autoplay: 3000,
    })
    //今日推荐
    var mySwiper = new Swiper('.Recommend', {
        direction: 'horizontal',
        loop: true,
        autoplay: 3000,
    })
    //设置距离底部的距离
    var Height1 = $("footer").height();
    $(".fd-content").css("margin-bottom", Height1);
    //所有框居中
    var leftMargin = "-" + Math.round($(".fd-searchbar").outerWidth() / 2) + "px";
    $(".fd-searchbar").css({"left": "50%", "margin-left": leftMargin});
});

function showTip(content) {
    $("body").append('<div class="tip">' + content + '</div>');
    $(".tip").css("opacity", "0.8");
    setTimeout(function () {
        $(".tip").css("opacity", "0");
    }, 1000);
}


//搜索框
$(".fd-search-classBtn").click(function (event) {
    var e = window.event || event;
    if (e.stopPropagation) {
        e.stopPropagation();
    } else {
        e.cancelBubble = true;
    }
    $(".fd-classfiy-wrapper").toggle();
});
document.onclick = function () {
    $(".fd-classfiy-wrapper").hide();
};

$(window).scroll(function (event) {
    $(".fd-classfiy-wrapper").hide();
});

/*点击购物车*/
function addCart() {
    showTip("加入购物车成功");
    $(".fooCartNum").html(parseInt($(".fooCartNum").text()) + 1);
}

/*导入右边栏*/
$(document).ready(function () {
    $(".right-nav").load("left.html")
});

/*点击分类*/
$(".classify").click(function () {
    window.location.href = window.location.protocol + "//" + window.location.hostname
        + ":" + window.location.port + "/mobilemall/classification";
});

function productdetails(dom) {
    window.location.href = "/mobilemall/productdetails/" + $(dom).attr("data-id");
}

// -------------------------------------------------------------------------------------------------- //
var Lock = function () {
    return {
        allow: true,
        lock: function () {
            this.allow = true
        },
        unlock: function () {
            this.allow = false
        }
    }
}

var L = new Lock();

var cursorY = 0.00;
document.querySelector('.myLove').ontouchstart = function (event) {
    cursorY = event.touches[0].pageY;
    console.log("start:" + event.touches[0].pageY);
}
document.querySelector('.myLove').ontouchmove = function (event) {
    var move = cursorY - event.touches[0].pageY;
    if (cursorY + move > document.querySelector('body').offsetHeight) {
        if (L.allow) {
            $(".dropload-load").show();
            L.unlock();
            loading();
        }
        console.log("到底了");

    }
}
document.querySelector('.myLove').ontouchend = function (event) {
    console.log("end:" + event.changedTouches[0].pageY);
}

var offset = 1, limit = 10;
var domTemp = $(".myLove > div");
$(".myLove").empty();
loading();

function loading() {
    $.ajax({
        url: '/mobilemall/productListAjax',
        data: {
            productTag: "爆款",
            offset: offset,
            limit: limit
        },
        dataType: 'JSON',
        type: 'GET',
        contentType: 'application/json',
        async: true,
        success: function (data, status, XHR) {
            console.log(data);
            for (l in data.rows) {
                var dom = domTemp.clone();
                dom.find("img").attr("src", "http://findeng.com:8080/findeng/picture/product/thumbnailImage/" + data.rows[l].cover.split(",")[0]);
                dom.find(".fd-product-detailHeight > div").text(data.rows[l].productKind == 0 ? "订货" : "现货");
                dom.find(".fd-product-detailHeight").attr("data-id", data.rows[l].productId);
                dom.find(".fd-product-detailHeight > span").text(data.rows[l].productName);
                dom.find("p").text("￥" + data.rows[l].retailPrice);
                if (data.rows[l].productKind * 1 == 0) {
                    dom.find(".fd-goods-cart").remove();
                }
                $(".myLove").append(dom);
            }
            offset++;
            if (offset != 6 && data.rows.length >= 10) {
                L.lock();
            } else $(".fd-more-btn").show();
            $(".dropload-load").hide();
        },
        error: function (XHR, status, error) {
            alert("Error !");
        }
    });
}

$(".fd-more-btn").click(function () {
    window.location.href = "/mobilemall/productlist?productTag=爆款&offset=" + offset + "&limit=10";
});
//-------------------------------------------------------------------------------------------------- //