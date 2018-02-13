<!-- 添加用户角色 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加用户角色</title>
</head>
<body>
<div class="layui-fluid" style="margin-top: 10px;">
    <form class="layui-form layui-form-pane" action="" method="post" onsubmit="onsubmit();" id="addUserRoleForm">
        <input id="verifyState" type="hidden">
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">角色名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roleName" required lay-verify="required" placeholder="请输入角色名"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">登录后台</label>
                    <div class="layui-input-block">
                        <select name="loginBackstage" lay-verify="required">
                            <option value="0">否</option>
                            <option value="1">是</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row">
				<#list userPermissionList! as userPermission>
                    <input type="checkbox" name="permissions" value="${userPermission.id}"
                           title="${userPermission.permissionDes}">
                </#list>
        </div>
        <div class="layui-col-md12 layui-col-sm12" style="display:none;">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn addUserRoleForm-subtim" lay-submit lay-filter="addUserRole">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    layui.form.render('select');
    layui.form.render('checkbox');
    //表单提交方法
    layui.form.on('submit(addUserRole)', function (data) {
        $("#verifyState").val(1);//设置验证状态为1
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
</script>