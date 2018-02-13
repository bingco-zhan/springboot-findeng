<!-- 修改用户角色权限 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改用户角色权限</title>
</head>
<body>
<div class="layui-fluid" style="margin-top: 10px;">
    <form class="layui-form layui-form-pane" action="" method="post" onsubmit="onsubmit();" id="modifyPermissionForm">
        <input id="verifyState" type="hidden">
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">角色名</label>
                    <div class="layui-input-inline">
                        <input type="text" value="${userRole.roleName}" name="roleName" required lay-verify="required"
                               placeholder="请输入角色名" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">登录后台</label>
                    <div class="layui-input-block">
                        <select name="loginBackstage" lay-verify="required">
                            <option value="0">否</option>
                            <option <#if userRole.loginBackstage == 1>selected</#if> value="1">是</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row">
				<#list userPermissionList! as userPermission>
					<#if (userRole.permissions!"") == "">
						<input type="checkbox" name="permissions" value="${userPermission.id}"
                               title="${userPermission.permissionDes}">
                    <#elseif (userRole.permissions!"null"?string)?index_of(((","+userPermission.id+",")!""?string)) != -1>
						<input type="checkbox" name="permissions" checked value="${userPermission.id}"
                               title="${userPermission.permissionDes}">
                    <#else>
						<input type="checkbox" name="permissions" value="${userPermission.id}"
                               title="${userPermission.permissionDes}">
                    </#if>
                </#list>
        </div>
        <div class="layui-col-md12 layui-col-sm12" style="display:none;">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn modifyPermissionForm-subtim" lay-submit lay-filter="modifyPermission">
                        立即提交
                    </button>
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
    layui.form.on('submit(modifyPermission)', function (data) {
        $("#verifyState").val(1);//设置验证状态为1
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
</script>