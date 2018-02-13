<!-- 审批客户解绑界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>审批客户解绑界面 </title>
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/userManagement/approvalUnbinding.css" rel="stylesheet">
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
                                            <input type="text" name="apply.userNickname" placeholder="申请用户昵称"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="unbundling.userNickname" placeholder="解绑用户昵称"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="status">
                                                <option value="">请选择类型</option>
                                                <option value="0">未审核</option>
                                                <option value="1">不通过</option>
                                                <option value="2">已通过</option>
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
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/userManagement/approvalUnbinding.js"></script>
</html>