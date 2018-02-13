$(".fd-search-classBtn").click(function () {
    window.history.back();
});

/*选择排序*/
$(".fd-order > div").click(function () {
    if (!$(this).hasClass("active")) {
        $(this).addClass("active").siblings().removeClass("active");
        pmodel_json["ok"] = $(this).attr("ok");
        pmodel_json["ov"] = $(this).attr("ov");
        console.log(pmodel_json);
        $(".fd-plist").empty();
        pmodel_json.offset = 1;
        count = 5;
        sendAjax();
        $(".fd-msg").show();
    }
});

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
var count = 5;
var curren = 0, pageNum = 0;

var domTemp = $(".fd-plist > div").clone();
$(".fd-plist").empty();
sendAjax();


function sendAjax() {
    console.log(pmodel_json);
    $.ajax({
        url: '/mobilemall/productListAjax',
        data: pmodel_json,
        dataType: 'json',
        type: 'GET',
        // async:false,
        traditional: true,
        success: function (data, status, XHR) {
            loadData(data.rows);
            pageNum = (data.total % 50 == 0) ? parseInt(data.total / 50) : parseInt(data.total / 50) + 1;
            curren = (pmodel_json.offset <= 5) ? 1 : parseInt(pmodel_json.offset / 5);
            console.log(data.total);
            console.log(pageNum);
            $(".pageNumber").html("<span>" + curren + "</span>/" + pageNum);
        },
        error: function (XHR, status, error) {
            alert("Error !");
        }
    });
}

$("#pagePrev").click(function () {
    if (curren > 1) {
        $(".fd-plist").empty();
        pmodel_json.offset = pmodel_json.offset - 4;
        count = 5;
        sendAjax();
        $(".fd-msg").show();
    }
});

$("#pageNext").click(function () {
    if (pageNum > curren) {
        $(".fd-plist").empty();
        pmodel_json.offset = pmodel_json.offset + 1;
        count = 5;
        sendAjax();
        $(".fd-msg").show();
    }
});

function loadData(list) {
    for (var x in list) {
        var dom = domTemp.clone();
        dom.find(".fd-custom-margin").attr("data-id", list[x].productId);
        dom.find("img").attr("src", "http://findeng.com:8080/findeng/picture/product/thumbnailImage/" + list[x].cover.split(",")[0]);
        dom.find(".fd-pname").text(list[x].productName);
        dom.find(".fd-price").text(list[x].retailPrice);
        dom.find(".fd-sales").text("销量:" + list[x].productSales);
        if (list[x].productKind == 0) {
            dom.find(".fd-kind").text("订货");
            dom.find(".fd_list-cart i").hide();
            dom.find(".fd_list-cart").css("background-color", "#ffffff");
        } else if (list[x].productTag != undefined) {
            var d = dom.find(".fd-kind");
            d.find("span").text(list[x].productTag);
            d.attr("class", "fd_badge-label2");

        } else {
            var d = dom.find(".fd-kind");
            d.find("span").text("现货");
            d.attr("class", "fd_badge-label2");
        }
        $(".fd-plist").append(dom);
    }
    if (list.length < 10) {
        $(".fd-notMany").show();
        $(".fd-msg").text("-- 没有了 --");
        L.unlock();

    } else if (count == 1) {
        $(".fd-page").show();
        $(".fd-msg").hide();

    } else {
        $(".fd-page").hide();
        pmodel_json.offset++;
        L.lock();
        $(".fd-msg").text("-- 上拉刷新 --");
    }
    $(".dropload-load").hide();
    count--;
}

function toP(e1) {
    window.location.href = "/mobilemall/productdetails/" + $(e1).attr("data-id");
}

// -------------------------------------------------------------------------------------------------- //

var cursorY = 0.00;
document.querySelector('body').ontouchstart = function (event) {
    cursorY = event.touches[0].pageY;
    console.log("start:" + event.touches[0].pageY);
}
document.querySelector('body').ontouchmove = function (event) {
    var move = cursorY - event.touches[0].pageY;

    if (cursorY + move > document.querySelector('body').offsetHeight) {
        if (L.allow) {
            $(".fd-msg").text("-- 刷新ing --");
            L.unlock();
            sendAjax();
        }
        console.log("到底了");
    }
}
document.querySelector('body').ontouchend = function (event) {
    console.log("end:" + event.changedTouches[0].pageY);
}
