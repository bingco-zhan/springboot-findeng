//监听图片改变
function imgloading(img) {
    if ($(img).attr("src").indexOf("://") == -1) {
        $(img).attr("change", 1);
    }
}

//轮播图演示
var mySwiper1 = new Swiper('.swiper-container1', {
    direction: 'horizontal',
    loop: true,
    autoplay: 2000,
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

//监听链接改变
$(document).on("change", ".link", function () {
    console.log("12");
    $(this).attr("change", 1);
});

//选择图片
$(function () {
    $(document).on("click", ".pic", function () {
        var img = $(this);//图片img标签
        var fileTag = $(this).siblings(".upload");//文件上传input
        fileTag.click();
        $(this).siblings(".upload").on("change", function () {
            imageChangFalg = true;
            var file = fileTag[0].files[0];
            var fileSize = file.size;
            var size = fileSize / 1024 / 1024;
            if (size > 1) {
                alert("上传图片不能超过1M");
                return false;
            }
            var fileReader = new FileReader();
            fileReader.onloadend = function () {
                if (fileReader.readyState == fileReader.DONE) {
                    img.attr('src', fileReader.result);
                }
            };
            fileReader.readAsDataURL(file);
        });
    });
});


//点击保存
$(document).on("click", ".btn-keep", function () {
    var ajaxdata = {};
    //获取轮播图id
    var id = $(this).parent().parent().children().html();
    //如果id为空或者未定义就是新创建项目
    if (id == "" || id == undefined) {
        addCarousel($(this));
        return;
    }
    ajaxdata.id = id;
    //如果图片修改过提交图片
    var img = $(this).parent().parent().find(".pic");
    if (img.attr("change") == 1) {
        ajaxdata.imgData = $(this).parent().parent().find(".pic").attr("src");
    }
    //如果链接修改过提交链接数据
    var link = $(this).parent().parent().find(".form-control");
    if (link.attr("change") == 1) {
        ajaxdata.link = link.val();
    }
    //如果图片为空不允许提交
    if ($(this).parent().parent().find(".pic").attr("src") != undefined) {
        //如果数据修改过发送请求修改
        if (link.attr("change") == 1 || img.attr("change") == 1) {
            $.ajax({
                url: '/admin/api/carousel',
                type: 'put',
                dataType: 'json',
                data: ajaxdata,
                success: function (data) {
                    img.attr("change", 0);
                    link.attr("change", 0);
                    showMsg(data.msg);
                },
                error: function (error) {
                    console.log(error);
                    alert("保存失败!");
                }
            });
        } else {//如果数据没有修改过直接完成
            showMsg("保存成功!");
        }
    } else {
        showMsg("图片不能为空!");
    }
});

//添加新的轮播图
function addCarousel(btn) {
    var ajaxdata = {};
    var id = $(btn).parent().parent().children().eq(0);
    var img = $(btn).parent().parent().find(".pic");
    var imgData = img.attr("src");
    var link = $(btn).parent().parent().find(".form-control");
    var linkData = link.val();
    ajaxdata.link = linkData;
    ajaxdata.imgData = imgData;
    if ($(btn).parent().parent().find(".pic").attr("src") != undefined) {
        $.ajax({
            url: '/admin/api/carousel',
            type: 'post',
            dataType: 'json',
            data: ajaxdata,
            success: function (data) {
                if (data.code == 1) {
                    img.attr("change", 0);
                    link.attr("change", 0);
                    id.html(data.entity.carouselId);
                    showMsg(data.msg);
                }
            },
            error: function (error) {
                console.log(error);
                alert("保存失败!");
            }
        });
    } else {
        showMsg("图片不能为空!");
    }
}

//删除按钮
$(document).on("click", ".btn-delete", function () {
    //获取轮播图id
    var id = $(this).parent().parent().children().html();
    var tr = $(this).parent().parent();
    if (id == "" || id == undefined) {
        tr.remove();
    } else {
        $.ajax({
            url: "/admin/api/carousel/" + id,
            dataType: "json",
            type: "delete",
            success: function (data) {
                if (data.code == 1) {
                    showMsg(data.msg);
                    tr.remove();
                } else {
                    showMsg(data.msg);
                }
            },
            error: function (error) {
                console.log(error);
                alert("删除失败!");
            }
        });
    }
});

//点击新增按钮添加table item
$(document).on("click", ".btn_add", function () {
    $("tbody").prepend("<tr>" +
        "<td></td>" +
        "<td style='width:200px;' class='tupian'>" +
        "<div style='position: relative;'>" +
        "<img onload='imgloading(this);' class='pic' change='0'>" +
        "<a class='shanchu'></a>" +
        "<input class='upload' name='file' accept='image/*' type='file' style='display: none'/></div>" +
        "</td>" +
        "<td>" +
        "<p style='text-align:center; padding-top: 20px;'>链接地址</p>" +
        "<input change='0' style='vertical-align: middle;text-align: center; type='text' class='form-control link' placeholder='链接地址' aria-describedby='basic-addon1'>" +
        "</td>" +
        "<td style='width:200px;'>" +
        "<button type='button' style='width:48%;margin-top:8%;' class='btn btn-success btn-keep'>保存</button>" +
        "<button type='button' style='width:48%;margin-top:8%;margin-left:2.1%' class='btn btn-danger btn-delete'>删除</button>" +
        "</td>" +
        "</tr>");
});

//显示对话框
function showMsg(msg) {
    $("#modal_text").html(msg);
    $('#modal').modal('show');
}