<!-- 导购机授权界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>导购机授权界面</title>
</head>
<style>
    .must {
        color: red;
    }

    .prview-content {
        text-align: center;
        margin-left: 5%;
    }

    .prview {
        width: 200px;
        height: 200px;
    }

    .prview-item {
        width: 200px;
        height: 200px;
    }

    .layui-upload-btn {
        margin-top: -110%;
    }

    .layui-upload-choose {
        display: none;
    }

    .prview {
        border: 1px gray solid;
    }

    .img-remove {
        margin-left: 183px;
        font-size: 20px;
        color: red;
    }

    .remove-content {
        position: absolute;
        display: none;
    }
</style>
<body>
<form class="layui-form layui-form-pane" action="" method="post" onsubmit="onsubmit();" id="addUserRoleForm">
    <input id="userId" name="userId" required lay-verify="userId" type="hidden">
    <input id="verifyState" type="hidden">
    <div class="layui-form-item">
        <label class="layui-form-label">授权</label>
        <div class="layui-input-block">
            <input type="radio" name="lampSelectionLogin" value="1" title="是">
            <input type="radio" name="lampSelectionLogin" value="0" title="否" checked>
        </div>
    </div>
    <div class="prview-content">
        <div class="layui-form-item prview-item">
            <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
            <img class="prview">
            <button type="button" class="layui-btn layui-upload-btn">
                <i class="layui-icon">&#xe67c;</i>合作合同
            </button>
            <input lay-verify="lampPermissionAuthroPic" name="lampPermissionAuthroPic" type="hidden">
        </div>
    </div>
    <div class="layui-form-item" style="display:none;">
        <div class="layui-input-block">
            <button class="layui-btn addUserRoleForm-subtim" lay-submit lay-filter="addUserRole">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
</html>
<script>
    layui.form.render('radio');

    var uploadBtn = layui.upload.render({
        elem: '.layui-upload-btn' //绑定元素
        , url: '/admin/api/lampPermission/uploadImage' //上传接口
        , accept: "images"
        , exts: "jpg|png|jpeg"
        , size: 1024
        , multiple: true
        , done: function (res, index, upload) {//文件上传成功回调
            var btn = this.item[0];
            var img = btn.previousSibling.previousSibling;
            var imgSrc = res.arr[0].httpSrc;
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
    $(".img-remove").on("click", function () {
        var btn = $(this).parent();
        var img = btn.next();
        btn.css("display", "none");//隐藏删除图片按钮
        btn.next().next().css("display", "inline-block");//显示上传按钮
        btn.next().removeAttr("src");//删除图片src属性
        img.after('<img class="prview">');//添加新的图片标签
        img.remove();//删除就图片标签
        btn.next().next().next().next().val("");//删除图片表单路径
    });

    //表单提交方法
    layui.form.on('submit(addUserRole)', function (data) {
        $("#verifyState").val(1);//设置验证状态为1
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
</script>