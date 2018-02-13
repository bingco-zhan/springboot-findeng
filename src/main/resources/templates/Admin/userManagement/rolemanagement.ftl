<!-- 角色权限管理界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色权限管理界面</title>
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/userManagement/roleManagement.css" rel="stylesheet"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <table class="layui-hide" id="table" lay-filter="table"></table>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/userManagement/rolemanagement.js"></script>
</html>
<script type="text/html" id="tool">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="updata">修改权限</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="add">新增角色</a>
</script>
<script>
    var userPermissionList = ${userPermissionList}
</script>