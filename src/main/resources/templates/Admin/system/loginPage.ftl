<!-- 登录页面 -->
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录页</title>

    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="/static/public/checkbix/css/checkbix.min.css" rel="stylesheet"/>
    <link href="/static/admin/css/system/loginPage.css" rel="stylesheet"/>
</head>
<body>
<div class="page-header">
    <h3>繁灯网后台管理系统</h3>
</div>
<div id="login-window">
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-account"></i></span>
        <div class="fg-line">
            <input id="username" type="text" class="form-control" name="username" placeholder="帐号" required autofocus
                   value="admin">
        </div>
    </div>
    <div class="input-group m-b-20">
        <span class="input-group-addon"><i class="zmdi zmdi-male"></i></span>
        <div class="fg-line">
            <input id="password" type="password" class="form-control" name="password" placeholder="密码" required
                   value="123456">
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="checkbox">
        <input id="rememberMe" type="checkbox" class="checkbix" data-text="自动登录" name="rememberMe">
    </div>
    <a id="login-bt" href="javascript:;" class="waves-effect waves-button waves-float"><i
            class="zmdi zmdi-arrow-forward"></i></a>
</div>
<div class="page-footer">
    <h6>@中山市伙丁科技有限公司</h6>
</div>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.js"></script>
<script src="/static/public/checkbix/js/checkbix.min.js"></script>

<script src="/static/admin/js/system/loginPage.js"></script>
<script type="text/javascript">
    Checkbix.init();
</script>
</body>
</html>