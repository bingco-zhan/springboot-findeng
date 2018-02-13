$(".shopI").on('click', function () {
    var dot = $(this).parent();
    if (dot.hasClass("active")) {
        $(".chooseAll").removeClass("active");
        dot.removeClass("active");
        dot.parent().find(".commodity").removeClass("active");
    } else {
        dot.addClass("active");
        dot.parent().find(".commodity").addClass("active");
        var flag = true;
        $(".shopName").each(function () {
            if (!$(this).hasClass("active")) {
                flag = false;
                return false;
            }
        });
        if (flag) {
            $(".chooseAll").addClass("active");
        }
    }
});
$(".oneI").on('click', function () {
    var dot = $(this).parent();
    if (dot.hasClass("active")) {
        dot.removeClass("active");
        dot.parent().find(".shopName").removeClass("active");
        $(".chooseAll").removeClass("active");
    } else {
        dot.addClass("active");
        var flag = true;
        dot.parent().find(".commodity").each(function () {
            if (!$(this).hasClass("active")) {
                flag = false;
                return false;
            }
        });
        if (flag) {
            dot.parent().find(".shopName").addClass("active");
            $(".shopName").each(function () {
                if (!$(this).hasClass("active")) {
                    flag = false;
                    return false;
                }
                if (flag) {
                    $(".chooseAll").addClass("active");
                }

            });
        }
    }
});
$(".chooseAll").click(function () {
    if ($(this).hasClass("active")) {
        $(this).removeClass("active");
        $(".shopName").removeClass("active");
        $(".commodity").removeClass("active");
    } else {
        $(this).addClass("active");
        $(".shopName").addClass("active");
        $(".commodity").addClass("active");
    }
});
//加的效果
$(".increase").click(function () {
    var n = $(this).siblings(".num").val();
    console.log(n);
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
//返回键
$(".back").click(function () {
    history.go(-1);
});