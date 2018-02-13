<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>个人信息表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/public/layui/css/layui.css" rel="stylesheet"/>
    <link href="/admin/css/system/userInfo.css" rel="stylesheet"/>
</head>
<body>
<div class="layui-fluid mgtop">
    <div class="layui-row">
        <div class="layui-col-md2">
            <img id="headPic" src="${user.userProtraitPic}">
        </div>
        <div class="layui-col-md10">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">基础资料</h2>
                <div class="layui-colla-content layui-show">
                    <p id="userNickname">昵称：${user.userNickname!""}</p>
                    <p id="legalPersonName">姓名：${user.legalPersonName!""}</p>
                    <p id="companyName">公司：${user.companyName!""}</p>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">联系方式</h2>
                <div class="layui-colla-content layui-show">
                    <p id="phoneNumber">电话：${user.phoneNumber!""}</p>
                    <p id="openId">微信ID：${user.openId!""}</p>
                    <p id="wechatNumber">微信号：${user.wechatNumber!""}</p>
                    <p id="qqNumber">QQ号：${user.qqNumber!""}</p>
                    <p id="email">邮箱：${user.email!""}</p>
                    <p id="role">角色：${role.roleName!""}</p>
                </div>
            </div>
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">其他信息</h2>
                <div class="layui-colla-content layui-show">
                    <p id="userIdenticalCode">
                        用户地址：${address.province.addressName!""}${address.city.addressName!""}${address.area.addressName!""}</p>
                    <p id="userIdenticalCode">用户编码：${user.userIdenticalCode!""}</p>
                    <p id="rentVisitTime">最近访问：${user.rentVisitTime!""}</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
</html>