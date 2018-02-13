// Waves初始化
Waves.displayEffect();
var welcomePicId;
//初始化界面
$(function () {
    var id = $("#img").attr("data-id");
    if (id != undefined) {
        welcomePicId = id;
    }
    //初始化设置所有图片change值为0
    $("#img").attr("change", 0);
});

$(document).on("click", "#img", function () {
    $("#file").click();
});

window.onload = function () {
    var fileTag = document.getElementById('file');
    fileTag.onchange = function () {
        var file = fileTag.files[0];
        var fileSize = file.size;
        var size = fileSize / 1024 / 1024;
        if (size > 1) {
            alert("上传图片不能超过1M");
            return false;
        }
        var fileReader = new FileReader();
        fileReader.onloadend = function () {
            if (fileReader.readyState == fileReader.DONE) {
                document.getElementById('img').setAttribute('src', fileReader.result);
            }
        };
        fileReader.readAsDataURL(file);
    };
};

//监听图片改变
function imgloading(img) {
    if ($(img).attr("src").indexOf("://") == -1) {
        $(img).attr("change", 1);
    }
}

//点击保存
function savePic() {
    var imgData = $("#img").attr("src");
    var changeFalg = $("#img").attr("change");
    if (imgData == "" || imgData == undefined) {
        showMsg("图片为空!");
    } else if (changeFalg == 0) {
        showMsg("保存成功!");
    } else {
        $.ajax({
            url: '/admin/api/welcomepic',
            type: 'post',
            dataType: 'json',
            data: {imgData: imgData},
            success: function (data) {
                if (data.code == 1) {
                    $("#img").attr("change", 0);
                    welcomePicId = data.entity.welcomePicId;
                    showMsg("保存成功!");
                } else {
                    showMsg("保存图片失败!");
                }
            },
            error: function (error) {
                console.log(error);
                showMsg("保存图片失败!");
            }
        });
    }
}

//点击删除
function deletePic() {
    if ((welcomePicId == undefined || welcomePicId == "")
        && ($("#img").attr("src") != undefined)) {
        $(".pic_content").append('<img change="0" class="pic" onload="imgloading(this);" id="img" style="width:300px;height:400px;margin-top: 30px;" />');
        $("#img").remove();
    }
    if (welcomePicId == undefined || welcomePicId == "")
        showMsg("图片为空");
    else
        $.ajax({
            url: '/admin/api/welcomepic/' + welcomePicId,
            type: 'delete',
            dataType: 'json',
            success: function (data) {
                if (data.code == 1) {
                    showMsg("删除成功!");
                    welcomePicId = "";
                    $(".pic_content").append('<img change="0" class="pic" id="img" style="width:300px;height:400px;margin-top: 30px;" />');
                    $("#img").remove();
                } else {
                    showMsg("删除图片失败!");
                }
            },
            error: function (error) {
                console.log(error);
                showMsg("删除图片失败!");
            }
        });
}

//显示对话框
function showMsg(msg) {
    $("#modal_text").html(msg);
    $('#modal').modal('show');
}