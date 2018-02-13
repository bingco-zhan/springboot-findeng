<!-- 系统设置界面 -->
﻿<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>系统设置</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<link href="/public/layui/css/layui.css" rel="stylesheet">
<link href="/static/admin/css/system/systemsetting.css" rel="stylesheet"/>
<body>
<h3 style="text-align:center;">系统设置</h3>
<div class="layui-fluid">
    <div class="layui-row">
        <form class="layui-form layui-form-pane">
            <div class="layui-row layui-md-space3 layui-col-space10">
                <div class="layui-col-md3">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <select id="theme" lay-filter="theme">
                                <option value="zheng-upms-server">绿色皮肤</option>
                                <option value="zheng-oss-web">蓝色皮肤</option>
                                <option value="zheng-cms-admin">深蓝皮肤</option>
                                <option value="zheng-pay-admin">粉红皮肤</option>
                                <option value="zheng-ucenter-home">紫色皮肤</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="nav" style="position: absolute;bottom: 0;right: 10px;">
    <button onclick="save()" class="layui-btn">保存</button>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/system/systemsetting.js"></script>
</html>