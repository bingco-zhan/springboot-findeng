<!-- 用户折扣审批界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户折扣审批</title>
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/userManagement/discountApplication.css" rel="stylesheet"/>
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
                                            <input type="number" name="user.userId" placeholder="用户 ID"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="user.userNickname" placeholder="用户昵称"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="status">
                                                <option value="">请选择状态</option>
                                                <option value="0">待审批</option>
                                                <option value="1">审批通过</option>
                                                <option value="2">审批拒绝</option>
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
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/userManagement/discountApplication.js"></script>
<script type="text/html" id="tool">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="authorization">授权</a>
</script>
</html>