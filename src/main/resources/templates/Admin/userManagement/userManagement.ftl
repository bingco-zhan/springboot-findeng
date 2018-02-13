<!-- 用户权限管理界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户权限管理</title>
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/userManagement/userManagement.css" rel="stylesheet"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-collapse">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">查询面板</h2>
                <div class="layui-colla-content">
                    <!-- 搜索栏 -->
                    <form class="layui-form layui-form-pane">
                        <!-- row -->
                        <div class="layui-row layui-md-space3 layui-col-space10">
                            <div class="layui-col-md10">
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="number" name="userId" placeholder="用户 ID" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="upperUserId" placeholder="上级ID"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="userNickname" placeholder="用户昵称"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="companyName" placeholder="公司名" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="role.id">
                                                <option value="">请选择用户角色</option>
									        <#list userRoleList as userRole>
									        	<option value="${userRole.id}">${userRole.roleName}</option>
                                            </#list>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-col-md2">
                                <button class="layui-btn" lay-submit lay-filter="search">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                        <!-- row -->
                    </form>
                    <!-- 搜索栏 -->
                </div>
            </div>
        </div>
        <div class="layui-row">
            <table class="layui-hide" id="table" lay-filter="table"></table>
        </div>
    </div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
<script type="text/javascript" src="/static/admin/js/userManagement/userManagement.js"></script>
</html>
<script type="text/html" id="tool">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="modify">修改</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="delete">删除</a>
</script>
<script>
    var userRoleArr = ${userRoleJSONArr};
</script>