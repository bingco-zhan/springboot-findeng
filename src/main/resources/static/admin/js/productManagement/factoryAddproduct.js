var form = layui.form;
form.render('select');

//表单验证
form.verify({
    descriptionPic: function (value, item) {
        if ($(".descriptionPic-Content").length == 1) {
            return "请最少上传一张详情图!";
        }
    },
    cover: function (value, item) {
        if (value == undefined || value == "") {
            return "请上传三张轮播图!";
        }
    },
    productPngPic: function (value, item) {
        if (value == undefined || value == "") {
            return "请上传配灯图!";
        }
    },
    productSize: function (value, item) {
        var count = 0;
        $(".productSize").each(function (i) {
            value = $(".productSize").eq(i).children().val();
            if (value != "" && value != undefined) {
                count++;
            }
        });
        if (count < 2) return "产品尺寸最少填写两项!"
    }
});

//上传控件渲染
var uploadBtn = layui.upload.render({
    elem: '.layui-upload-btn' //绑定元素
    , url: '/admin/api/product/uploadImage' //上传接口
    , accept: "images"
    , exts: "jpg|png|jpeg"
    , size: 1024
    , multiple: true
    , done: function (res, index, upload) {//文件上传成功回调
        //其他图片处理
        var btn = this.item[0];
        var img = btn.previousSibling.previousSibling;
        var imgSrc = res.arr[0].httpSrc;
        //详情图添加dom
        if ($(btn).next().next().attr("lay-verify") == "descriptionPic") {
            if ($(".descriptionPic-Content").length == 21) {
                layer.msg("详情图最大上限20张!");
                return;
            }
            var layContent = $(btn).parent().parent().parent();
            var temp = $("#descriptionPicTemp").clone();
            temp.find("img").attr("src", imgSrc);
            temp.find("input").val(imgSrc);
            temp.find(".remove-content").css("display", "block");//删除按钮显示
            layContent.before(temp.html());
            if ($(".descriptionPic-Content").length == 21) {
                $(".descriptionPic-Upload-Content").css("display", "none");
            }
            return;
        }
        //图片上传
        $(img).attr("src", imgSrc);//设置图片路径
        $(btn).css("display", "none");//设置上传按钮隐藏
        $(btn).prev().prev().css("display", "block");//删除按钮显示
        $(btn).next().next().val(imgSrc);//设置表单隐藏input值
    }
    , error: function () {
        //请求异常回调 
    }
});

//图片删除按钮
$(document).on("click", ".img-remove", function () {
    var btn = $(this).parent();
    var img = btn.next();
    //详情图删除dom
    if (btn.hasClass("descriptionPic-Remove")) {
        btn.parent().parent().parent().remove();
        if ($(".descriptionPic-Content").length < 21) {
            $(".descriptionPic-Upload-Content").css("display", "block");
        }
    }
    btn.css("display", "none");//隐藏删除图片按钮
    btn.next().next().css("display", "inline-block");//显示上传按钮
    btn.next().removeAttr("src");//删除图片src属性
    img.after('<img class="prview">');//添加新的图片标签
    img.remove();//删除就图片标签
    btn.next().next().next().next().val("");//删除图片表单路径
});

//监听光源类型为自带LED的话必须配光源
form.on('select', function (data) {
    var select = $(data.elem);
    if (select.attr("lay-verify") == "lightType" && data.value == 619) {
    }
});

var productMaterialCount = 0;
var productSpaceCount = 0;
//监听材质和空间选择数量
form.on('checkbox', function (data) {
    var checkBox = $(data.elem);
    if (data.elem.checked) {
        if (checkBox.attr("name") == "productMaterial") {
            productMaterialCount++;
        } else if (checkBox.attr("name") == "productSpace") {
            productSpaceCount++;
        }
    } else {
        if (checkBox.attr("name") == "productMaterial") {
            productMaterialCount--;
        } else if (checkBox.attr("name") == "productSpace") {
            productSpaceCount--;
        }
    }
});

//表单提交方法
layui.form.on('submit(formFactoryAddproduct)', function(data){
	alert(productMaterialCount);alert(productSpaceCount);
	var ajaxObjectData = $("#factoryAddproductForm").serializeObject();
	var coverArr = new Array(ajaxObjectData.cover);
	var descriptionPicArr = new Array(ajaxObjectData.descriptionPic);
	var productMaterialArr = new Array(ajaxObjectData.productMaterial);
	var productSpaceArr = new Array(ajaxObjectData.productSpace);
	ajaxObjectData.descriptionPic = descriptionPicArr.join(",");//详情图
	ajaxObjectData.productMaterial = productMaterialArr.join(",");//产品材质
	ajaxObjectData.productSpace = productSpaceArr.join(",");//产品空间
	ajaxObjectData.cover = coverArr.join(",");//产品轮播图
	if(productMaterialCount == 0 || productMaterialCount > 3){layer.msg("产品材质选择最少一项,最多三项");return;}
	if(productSpaceCount == 0 || productSpaceCount > 3){layer.msg("产品空间选择最少一项,最多三项");return;}
	$.ajax({
		url:"/admin/api/product",
		dataType:"json",
		type:"post",
		data:ajaxObjectData,
		success:function(json){
			if(json.code == 1){
				layer.open({
				  title: '消息'
				  ,time: 3000
				  ,content: json.msg
				  ,end: function(index, layero){ 
					  location.reload();
				  }    
				});     
			}else{
				layer.msg(json.msg);
			}
		},
		error:function(data){
			layer.msg("保存产品错误!");
		}
	});
	return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
});

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
        	if(this.value != "")
        		o[this.name] = this.value || '';
        }
    });
    return o;
};