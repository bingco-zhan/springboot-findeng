//初始化
$(function () {
    /**
     * 初始化材质和空间
     */
    initCheckBox($(".materialCheckBox"), 38, "material");
    initCheckBox($(".spaceCheckBox"), 40, "space");
    /**
     * 监听详情图图片上传按钮点击事件
     */
    $(document).on("click", ".upload_button", function () {
        $("#file").click();//触发选择文件
        var img = $(this).next();//图片标签
        var btn = $(this);//按钮	
        var detail_map_box = $(this).parent().parent();
        $("#file").off("change").on("change", function () {//解决事件多次绑定
            //限制图片上传类型
            if (btn.hasClass("detail_map")) {
                var allowtype = ["jpg", "png", "Jpeg"];
            } else if (btn.next().hasClass("lightingChoice")) {
                var allowtype = ["png"];
            } else {
                var allowtype = ["jpg", "png", "Jpeg"];
            }
            //详情图最大数量
            var maxdis = 20;
            //渲染图片
            if (imgReader($(this), img, allowtype)) {
                btn.css("display", "none");
                if (btn.hasClass("detail_map") && $(".detail_map").length < maxdis)//上传的是详情图
                    detail_map_box.after('<div class="col-md-3 col-sm-4 col-xs-5 imgcontent"><a class="thumbnail"><button class="upload_button detail_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button><img></a></div>');
                if (btn.hasClass("carousel_map"))//上传的是轮播图
                    btn.prev().css("display", "none");
            }
        });
    });

    /**
     * 删除图片DOM方法
     */
    $(document).on("click", ".glyphicon-remove", function () {
        if ($(this).next().find("button").hasClass("carousel_map")) {
            $(this).next().find("button").next().remove();
            $(this).next().find("button").parent().append('<img>');
            $(this).next().find("button").css("display", "block");
            $(this).next().find("p").css("display", "block");
            $(this).remove();
            return;
        }
        if ($(this).next().find("button").hasClass("lightingChoice")) {
            $(this).next().find("button").next().remove();
            $(this).next().find("button").parent().append('<img>');
            $(this).next().find("button").css("display", "block");
            $(this).remove();
            return;
        }
        if ($(this).next().find("button").hasClass("dailyPromotion")) {
            $(this).next().find("button").next().remove();
            $(this).next().find("button").parent().append('<img>');
            $(this).next().find("button").css("display", "block");
            $(this).remove();
            return;
        }
        if ($(this).next().find("button").hasClass("authentication")) {
            $(this).next().find("button").next().remove();
            $(this).next().find("button").parent().append('<img>');
            $(this).next().find("button").css("display", "block");
            $(this).remove();
            return;
        }
        $(this).parent().remove();
        if ($(".detail_map").length < 20 && $(".detail_map").eq($(".detail_map").length - 1).next().attr("src") != undefined) {
            var detail_map_box = $(".detail_map").eq($(".detail_map").length - 1).parent().parent();
            detail_map_box.after('<div class="col-md-3 col-sm-4 col-xs-5 imgcontent"><a class="thumbnail"><button class="upload_button detail_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button><img></a></div>');
        }
    });

    /**
     * 图片渲染方法
     * @param {Object} 文件input元素
     * @param {Object} 需要渲染的img元素
     * @param {Object} 允许的文件类型 如[ "jpg", "gif","png","Jpeg"]
     */
    function imgReader(file_input, img, allowtype) {
        file_input[0].outerHTML = file_input[0].outerHTML;//清空文件路径
        var file = file_input[0].files[0];
        if (file == undefined) return false;//如果文件为空不处理
        var fileSize = file.size;
        var size = fileSize / 1024 / 1024;//获取文件大小
        if (size > 1) {
            $.confirm({
                title: "警告",
                content: '文件不能大于1M!',
                cancelButton: false,
                confirmButton: false,
                confirmButton: "OK",
                backgroundDismiss: true,
                closeIcon: false
            });
            return false;
        } else {
            //校验文件类型
            if (!checkfiletype(file_input[0].value, allowtype)) {
                $.confirm({
                    title: "警告",
                    content: '请上传正确文件类型' + allowtype,
                    cancelButton: false,
                    confirmButton: false,
                    backgroundDismiss: true,
                    closeIcon: false
                });
                return false;//判断文件类型
            }
        }
        //渲染img标签
        var fileReader = new FileReader();
        fileReader.onloadend = function () {
            if (fileReader.readyState == fileReader.DONE) {
                img.attr('src', fileReader.result);
                img.parent().before('<i class="glyphicon glyphicon-remove"></i>');
            }
        };
        fileReader.readAsDataURL(file);
        return true;
    }

    /**
     * 验证文件类型
     * @param {Object} filepath 获取到的文件路径
     * @param {Object} allowtype 允许通过的文件类型数组如 图片： [ "jpg", "gif","png","Jpeg"]
     */
    function checkfiletype(filepath, allowtype) {
        //截取文件后缀名    
        var thisfiletype = filepath.substring(filepath.lastIndexOf(".") + 1, filepath.length).toLowerCase();
        if ($.inArray(thisfiletype, allowtype) == -1) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 提交按钮
     */
    $(document).on("click", "#subtim_btn", function () {
        var ajaxData = checkInput();
        if (ajaxData) {
            $.confirm({
                title: "提示",
                content: "确认提交?",
                confirmButtonClass: 'btn-info',
                cancelButtonClass: 'btn-danger',
                confirmButton: "立即提交",
                cancelButton: '取消',
                onAction: function (action) {
                    if (action == "confirm") {
                        $.ajax({
                            url: "/admin/api/product",
                            dataType: "json",
                            type: "post",
                            data: ajaxData,
                            success: function (json) {
                                if (json.code == 1) {
                                    //提交成功,开始上传图片
                                    uploadProductPic(json.entity.productId);
                                }
                            },
                            error: function (data) {
                                showMsg("提示", "保存产品错误!");
                            }
                        });
                    }
                }
            })
        }
    });

    /**
     * 获取产品图片上传数据
     * @param productId 上传图片的产品id
     */
    function uploadProductPic(productId) {
        var detail_map = $(".detail_map");//详情图(多图)
        var carousel_map = $(".carousel_map"); //轮播图(多图)
        var lightingChoice = $(".lightingChoice");//配灯图
        var dailyPromotion = $(".dailyPromotion");//每日推广图
        var authentication = $(".authentication");//认证图
        //计算上传图片总数
        var imgCount = detail_map.length + carousel_map.length;
        if (lightingChoice.next().attr("src") != undefined) imgCount++;
        if (dailyPromotion.next().attr("src") != undefined) imgCount++;
        if (authentication.next().attr("src") != undefined) imgCount++;
        //如果详情图最后一个为占位图片但是没有选择的话总图片数减1
        if (detail_map.eq(detail_map.length).next().attr("src") == undefined)
            imgCount--;

        //上传详情图
        var dataArr = new Array();
        for (var i = 0; i < detail_map.length; i++) {
            var data = {};
            data.productId = productId;
            data.imgBase64 = detail_map.eq(i).next().attr("src");
            data.type = "descriptionPic";
            if (data.imgBase64 != undefined) {
                dataArr.push(data);
            }
        }
        //上传轮播图
        for (var i = 0; i < carousel_map.length; i++) {
            var data = {};
            data.productId = productId;
            data.imgBase64 = carousel_map.eq(i).next().attr("src");
            data.type = "cover";
            if (data.imgBase64 != undefined) {
                dataArr.push(data);
            }
        }
        //上传配灯图
        if (lightingChoice.next().attr("src") != undefined) {
            var data = {};
            data.productId = productId;
            data.imgBase64 = lightingChoice.next().attr("src");
            data.type = "productPngPic";
            dataArr.push(data);
        }
        //上传每日推广图
        if (dailyPromotion.next().attr("src") != undefined) {
            var data = {};
            data.productId = productId;
            data.imgBase64 = dailyPromotion.next().attr("src");
            data.type = "productSpreadPic";
            dataArr.push(data);
        }
        //上传认证图
        if (authentication.next().attr("src") != undefined) {
            var data = {};
            data.productId = productId;
            data.imgBase64 = authentication.next().attr("src");
            data.type = "threeCCertification";
            dataArr.push(data);
        }
        uploadPic(dataArr);
    }

    /**
     * 发送上传图片请求
     */
    function uploadPic(dataArr) {
        var progressBar = $.confirm({
            title: "上传图片中(" + 0 + "/" + dataArr.length + ")",
            content: '<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%"><span class="sr-only"></span></div></div>',
            buttons: {"ok": {isHidden: true}}
        });
        var currentProgress = 0;

        for (var i = 0; i < dataArr.length; i++) {
            $.ajax({
                url: "/admin/api/product/image",
                data: dataArr[i],
                dataType: "json",
                type: "post",
                async: true,
                success: function (json) {
                    if (i == dataArr.length) {
                        currentProgress++;
                        progressBar.setTitle("上传图片中(" + currentProgress + "/" + dataArr.length + ")");
                        progressBar.setContent('<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: ' + (currentProgress / dataArr.length) * 100 + '%"><span class="sr-only"></span></div></div>');
                        if (i == currentProgress) {
                            progressBar.close();
                            showMsg("提示", "产品上传完毕!");
                            clearForm();//清空提交数据
                        }
                    }
                    if (json.code == 1) {

                    } else {
                        showMsg("提示", "上传图片错误!");
                    }
                },
                error: function (data) {
                    showMsg("提示", "上传图片错误!上传类型:" + data.type);
                }
            });
        }
        //重置页面
        clearForm();
    }

    /**
     * 设置上传图片对话框进度条进度
     */
    function setProgress(progressBar, currentProgress, maxProgress) {
        var percentage = (currentProgress / maxProgress) * 100;
        //设置对话框内容和标题
        progressBar.setTitle("上传图片中(" + currentProgress + "/" + maxProgress + ")");
        progressBar.setContent('<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: ' + percentage + '%"><span class="sr-only"></span></div></div>');
    }

    /**
     * 重置按钮
     */
    $(document).on("click", "#reset_btn", function () {
        clearForm();
    });

    /**
     * 校验和生成提交数据
     */
    function checkInput() {
        //商品型号校验
        if ($("#productCode").val().trim() == "") {
            showMsg("提示", "请填写商品型号");
            return false;
        }//商品型号校验
        //系列校验
        if ($("#series").selectpicker("val") == null || $("#series").selectpicker("val") == -1) {
            showMsg("提示", "请选择系列");
            return false;
        }
        //货型
        if (!($(".goodsOfType").eq(0).prop('checked') || $(".goodsOfType").eq(1).prop('checked'))) {
            showMsg("提示", "请填写货型是现货还是订货");
            return false;
        }
        //详情图校验
        if ($(".detail_map").length <= 1) {
            showMsg("提示", "请填写上传最少一张详情图");
            return false;
        }//详情图校验
        //轮播图校验
        var carousel_maps = $(".carousel_map");
        if ($(carousel_maps).eq(0).next().attr("src") == undefined) {
            showMsg("提示", "请上传白底亮灯图");
            return false;
        }
        if ($(carousel_maps).eq(1).next().attr("src") == undefined) {
            showMsg("提示", "请上传白底不亮灯");
            return false;
        }
        if ($(carousel_maps).eq(2).next().attr("src") == undefined) {
            showMsg("提示", "请上传搭配主图，实景图");
            return false;
        }
        //配灯图校验
        if ($(".lightingChoice").next().attr("src") == undefined) {
            showMsg("提示", "请上传配灯图");
            return false;
        }
        //基本参数校验
        if ($(".selectType").attr("data-id") == undefined) {
            showMsg("提示", "请选择宝贝类型");
            return false;
        }
        if ($(".Price").val().trim() == "") {
            showMsg("提示", "请填写宝贝价格");
            return false;
        }
        if ($(".style").attr("data-id") == undefined) {
            showMsg("提示", "请选择产品风格");
            return false;
        }
        if ($(".delivery").val().trim() == "") {
            showMsg("提示", "请填写宝贝交货期");
            return false;
        }
        if ($(".stock").val().trim() == "") {
            showMsg("提示", "请填写宝贝库存量");
            return false;
        }
        if ($(".lightType").attr("data-id") == undefined) {
            showMsg("提示", "请选择宝贝光源类型");
            return false;
        }
        if ($(".lightNumber").val().trim() == "") {
            showMsg("提示", "请填写宝贝光源数量");
            return false;
        }
        if ($(".shelfLife").val().trim() == "") {
            showMsg("提示", "请填写宝贝保质期");
            return false;
        }
        if (!($(".LightDistribution").eq(0).prop('checked') || $(".LightDistribution").eq(1).prop('checked'))) {
            showMsg("提示", "请填写选择是否配送光源");
            return false;
        }
        if ($(".lightType").attr("data-id") == 619 && $(".power").val().trim() == "") {
            showMsg("提示", "如果宝贝自带LED光源必须填写功率");
            return false;
        }
        var productLength = $(".product-length").val();
        var productWidth = $(".product-width").val();
        var productHeight = $(".product-height").val();
        var productDiameter = $(".product-diameter").val();
        if (productDiameter == "" && (productLength == "" || productWidth == "" || productHeight == "")) {
            showMsg("提示", "请正确填写宝贝尺寸(填写长宽高或者直径)");
            return false;
        }
        //检查材质和空间(最少选择一项)
        var selectedChecks = $(".addonColor");
        var materialFalg = false;
        var spaceFalg = false;
        for (var i = 0; i < selectedChecks.length; i++) {
            if (selectedChecks.eq(i).parent().hasClass("material"))
                materialFalg = true;
            else if (selectedChecks.eq(i).parent().hasClass("space"))
                spaceFalg = true;
        }
        if (!materialFalg) {
            showMsg("提示", "请最少选择一项材质");
            return false;
        }
        if (!spaceFalg) {
            showMsg("提示", "请最少选择一项空间");
            return false;
        }
        if ($(".layer").val().trim() == "") {
            showMsg("提示", "请填写层数");
            return false;
        }
        if (!productSizeCheck()) {
            showMsg("提示", "请填写产品尺寸(最少两项)");
            return false;
        }
        var data = {};
        //返回产品请求数据
        data.productCode = $("#productCode").val().trim();//产品型号
        if (($(".goodsOfType").eq(0).prop('checked'))) data.productKind = 1; else data.productKind = 0;//货型
        data.productType = $(".selectType").attr("data-id");//类型
        data.productStyle = $(".style").attr("data-id");//风格
        data.lightType = $(".lightType").attr("data-id");//光源类型
        if (!($(".LightDistribution").eq(0).prop('checked'))) data.hasLightSource = 0; else data.hasLightSource = 1;//光源配送
        data.productPower = $(".power").val();//功率
        data.productPlies = $(".layer").val();//层
        data.productWeight = $(".product-weight").val();//净重
        data.originUnitPrice = $(".Price").val();//价格
        data.deliveryTime = $(".delivery").val();//交货期
        data.lightNumber = $(".lightNumber").val();//光源数量
        data.productStock = $(".stock").val();//库存量
        data.qualityGuaranteeTime = $(".shelfLife").val();//保质期
        data.productColor = $(".colour").val();//颜色
        data.productShape = $(".product-shape").attr("data-id");//形状
        data.productLength = $(".product-length").val();//长
        data.productWidth = $(".product-width").val();//宽
        data.productHeight = $(".product-height").val();//高
        data.productDiameter = $(".product-diameter").val();//直径
        data.productFromthewall = $(".product-fromthewall").val();//离墙距离
        data.packageLength = $(".package-length").val();//包材长
        data.packageWidth = $(".package-width").val();//包材宽
        data.packageHeight = $(".package-height").val();//包材高
        data.packageWeight = $(".package-weight").val();//包材毛重
        data["productSeries.id"] = $("#series").val();//产品系列ID
        var materialDOM = $(".material");//材质DOM
        var spaceDOM = $(".space");//空间DOM
        var materiaArr = new Array();//材质数组
        var spaceArr = new Array();//空间数组
        for (var i = 0; i < materialDOM.length; i++) {
            var checkbox = materialDOM.eq(i).children(":first");
            if (checkbox.hasClass("addonColor")) {
                materiaArr[materiaArr.length] = checkbox.attr("data-id");
            }
        }
        for (var i = 0; i < spaceDOM.length; i++) {
            var checkbox = spaceDOM.eq(i).children(":first");
            if (checkbox.hasClass("addonColor")) {
                spaceArr[spaceArr.length] = checkbox.attr("data-id");
            }
        }
        data.productMaterial = materiaArr.join(",");//材质
        data.productSpace = spaceArr.join(",");//空间
        return data;
    }
});

/**
 * 初始化空间和材质checkBox选项
 */
function initCheckBox(obj, propertyValue, attribute) {
    $.ajax({
        url: "/api/propertyValue",
        data: {
            "haveProduct": 1,
            "ids": [propertyValue]
        },
        dataType: "json",
        type: "get",
        success: function (json) {
            if (obj.find("div").length > 2) return;
            for (var i in json) {
                obj.append('<div class="col-md-4 col-xs-6"><div class="input-group ' + attribute + '" ><span class="input-group-addon checkbox" data-id="' + json[i].propertyValueId + '"><input type="checkbox" aria-label="..."><i class="glyphicon glyphicon-ok"></i></span><input style="font-size:14px;padding: 0px;padding-left:5px" type="text" value="' + json[i].propertyValue + '" class="form-control" aria-label="..." disabled="disabled"></div></div>');
            }
            spaceCount = 0;//选中空间数
            materialCount = 0;//选中材质数
        },
        error: function () {
            console.log("获取用户角色失败!");
        }
    });
}

/**
 * 切换空间和材质的checkbox选择状态
 */
var spaceCount = 0;//选中空间数
var materialCount = 0;//选中材质数
var materialSize = 3; //最大材质选择数
var spaceSize = 3;//最大空间选择数
$(document).on("click", ".checkbox", function () {
    var span = $(this).toggleClass("addonColor")[0];
    //特殊要求空间和材质每项最多选3个
    if ($(span).hasClass("addonColor")) {
        if ($(span).parent().hasClass("material")) {
            materialCount++;
        } else {
            spaceCount++;
        }
    } else {
        if ($(span).parent().hasClass("material")) {
            materialCount--;
        } else {
            spaceCount--;
        }
    }
    if (materialCount > materialSize) {
        $(this).toggleClass("addonColor");
        materialCount--;
        showMsg("提示", "宝贝材质最多只能" + materialCount + "种");
    }
    if (spaceCount > spaceSize) {
        $(this).toggleClass("addonColor");
        spaceCount--;
        showMsg("提示", "宝贝使用空间最多只能" + spaceCount + "种");
    }
});

/**
 * 下拉选框加载选项
 */
function addItem(btn) {
    var ul = $(btn).next();
    if (ul.find("li").length > 0) return;
    $.ajax({
        url: "/api/propertyValue",
        data: {
            "haveProduct": 1,
            "ids": [$(btn).attr("value")]
        },
        dataType: "json",
        type: "get",
        success: function (json) {
            for (var i in json) {
                ul.append('<li><a onclick="menuChoice(this)" data-id="' + json[i].propertyValueId + '">' + json[i].propertyValue + '</a></li>');
            }
        },
        error: function () {
            console.log("获取用户角色失败!");
        }
    });
}

/**
 * 检查产品尺寸输入是否正确(最少输入两样)
 */
function productSizeCheck(input) {
    var fillInLength = 0;//产品尺寸填写数量
    if ($(".product-length").val() != "") fillInLength++;//长度
    if ($(".product-width").val() != "") fillInLength++;//宽度
    if ($(".product-height").val() != "") fillInLength++;//高度
    if ($(".product-diameter").val() != "") fillInLength++;//直径
    if ($(".product-dromTheWall").val() != "") fillInLength++;//离墙距离
    if (fillInLength < 2) return false;
    return true;
}

/**
 * 选择框选择功能
 */
function menuChoice(obj) {
    var str = $(obj).html();
    //特殊要求:当选择自带LED时光源必须配送功率必须填写
    if ($(obj).attr("data-id") == 619) {
        str += "(必配光源)"
        $(".LightDistribution").eq(0).prop('checked', true);//选中光源配送
        $(".LightDistribution").eq(0).attr("disabled", "disabled");
        $(".LightDistribution").eq(1).attr("disabled", "disabled");
        $(".power").prev().html('<i class="must">*</i>' + $(".power").prev().html());
    } else {
        $(".LightDistribution").eq(0).removeAttr("disabled", "disabled");
        $(".LightDistribution").eq(1).removeAttr("disabled", "disabled");
        $(".power").prev().find("i").remove();
    }
    var btn = $(obj).parent().parent().parent().find("button");
    btn.html(str);
    btn.attr("data-id", $(obj).attr("data-id"));
}

/**
 * 清空输入数据
 */
var isClear = false;

function clearForm() {
    $.ajax({cache: false});
    $(".container-fluid").load(location.href + ".container-fluid", function (response, status, xhr) {
        if (!isClear) {
            isClear = true;
            initCheckBox($(".materialCheckBox"), 38, "material");
            initCheckBox($(".spaceCheckBox"), 40, "space");
            initSeriesSelect();
        }
    });
    isClear = false;
}

/**
 * 弹出提示弹窗
 */
function showMsg(title, msg) {
    $.confirm({
        title: title,
        content: msg,
        cancelButton: false,
        confirmButton: false,
        backgroundDismiss: true,
        closeIcon: false
    });
}