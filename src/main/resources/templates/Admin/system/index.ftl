<!-- 管理页面框架 -->
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>繁灯网后台管理系统</title>
    <link href="https://cdn.bootcss.com/fullPage.js/2.9.4/jquery.fullpage.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
          rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css"
          rel="stylesheet"/>
    <link href="/static/admin/css/system/index.css" rel="stylesheet"/>
</head>
<body>
<header id="header">
    <ul id="menu">
        <li id="guide" class="line-trigger">
            <div class="line-wrap">
                <div class="line top"></div>
                <div class="line center"></div>
                <div class="line bottom"></div>
            </div>
        </li>
        <li id="logo" class="hidden-xs">
            <a href="javascript:void(0);">
                <img style="width:35px;margin-top:-3%;" src="img/logo.png"/>
            </a>
            <span id="system_title">繁灯网后台管理系统</span>
        </li>
        <li class="pull-right">
            <ul class="hi-menu">
                <li class="dropdown" style="display:none;">
                    <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                        <i class="him-icon zmdi zmdi-dropbox"></i>
                    </a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li class="skin-switch hidden-xs">请选择系统切换</li>
                        <li class="divider hidden-xs"></li>
                        <li><a class="waves-effect switch-systems" href="javascript:;" systemid="1"
                               systemname="zheng-upms-server" systemtitle="权限管理系统"><i
                                class="zmdi zmdi-shield-security"></i> 权限管理系统</a></li>
                        <li><a class="waves-effect switch-systems" href="javascript:;" systemid="2"
                               systemname="zheng-cms-admin" systemtitle="内容管理系统"><i class="zmdi zmdi-wikipedia"></i>
                            内容管理系统</a></li>
                        <li><a class="waves-effect switch-systems" href="javascript:;" systemid="3"
                               systemname="zheng-pay-admin" systemtitle="支付管理系统"><i class="zmdi zmdi-paypal-alt"></i>
                            支付管理系统</a></li>
                        <li><a class="waves-effect switch-systems" href="javascript:;" systemid="4"
                               systemname="zheng-ucenter-home" systemtitle="用户管理系统"><i class="zmdi zmdi-account"></i>
                            用户管理系统</a></li>
                        <li><a class="waves-effect switch-systems" href="javascript:;" systemid="5"
                               systemname="zheng-oss-web" systemtitle="存储管理系统"><i class="zmdi zmdi-cloud"></i>
                            存储管理系统</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="waves-effect waves-light" data-toggle="dropdown" href="javascript:;">
                        <i class="him-icon zmdi zmdi-more-vert"></i>
                    </a>
                    <ul class="dropdown-menu dm-icon pull-right">
                        <li class="hidden-xs"><a class="waves-effect" data-ma-action="fullscreen"
                                                 href="javascript:fullPage();"><i class="zmdi zmdi-fullscreen"></i> 全屏模式</a>
                        </li>
                        <li><a class="waves-effect" data-ma-action="clear-localstorage" href="javascript:;"><i
                                class="zmdi zmdi-delete"></i> 清除缓存</a></li>
                        <li><a class="waves-effect" href="javascript:Tab.addTab('系统设置', '/admin/systemsetting');"><i
                                class="zmdi zmdi-settings"></i> 系统设置</a></li>
                        <li><a class="waves-effect" href="javascript:logout();"><i class="zmdi zmdi-run"></i> 退出登录</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</header>
<section id="main">
    <!-- 左侧导航区 -->
    <aside id="sidebar">
        <!-- 个人资料区 -->
        <div class="s-profile">
            <a class="waves-effect waves-light" href="javascript:;">
                <div class="sp-pic">
                    <img id="userProtraitPic" src="${user.userProtraitPic!""}"/>
                </div>
                <div class="sp-info">
                    <span id="userNickname">您好！${user.userNickname!""}</span>
                    <i class="zmdi zmdi-caret-down"></i>
                </div>
            </a>
            <ul class="main-menu">
                <li><a class="waves-effect" href="javascript:Tab.addTab('个人资料', '/admin/userInfo');"><i
                        class="glyphicon glyphicon-user"></i> 个人资料</a></li>
                <li><a class="waves-effect" href="javascript:Tab.addTab('系统设置', '/admin/systemsetting');"><i
                        class="glyphicon glyphicon-cog"></i> 系统设置</a>
                <li>
                <li><a class="waves-effect" href="javascript:logout();"><i class="glyphicon glyphicon-log-out"></i> 退出登录</a>
                </li>
            </ul>
        </div>
        <!-- /个人资料区 -->
        <!-- 菜单区 -->
        <ul class="main-menu" id="main-menu">
            <li>
                <a class="waves-effect" href="javascript:Tab.addTab('首页', 'home');"><i
                        class="glyphicon glyphicon-home"></i> 首页</a>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-usd"></i>资金管理</a>
                <ul>
					<#if (role.permissions!"")?index_of(",21,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('查看资金流水详情', '/admin/checkCapitalFlow');">资金流水</a></li>
                    </#if>
					<#if (role.permissions!"")?index_of(",22,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('审批提现申请', '/admin/withdrawalsApproval');">审批提现申请</a></li>
                    </#if>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-user"></i>客户管理</a>
                <ul>
						<#if (role.permissions!"")?index_of(",6,")!=-1>
							<li><a class="waves-effect"
                                   href="javascript:Tab.addTab('用户认证', '/admin/userAuthentication');">用户认证</a></li>
                        </#if>
						<#if (role.permissions!"")?index_of(",23,")!=-1>
							<li><a class="waves-effect"
                                   href="javascript:Tab.addTab('审批用户认证', '/admin/approvalUserAuthentication');">审批用户认证</a>
                            </li>
                        </#if>
						<#if (role.permissions!"")?index_of(",8,")!=-1>
							<li><a class="waves-effect" href="javascript:Tab.addTab('导购机权限', '/admin/lampPermission');">导购机权限</a>
                            </li>
                        </#if>
						<#if (role.permissions!"")?index_of(",9,")!=-1>
							<li><a class="waves-effect"
                                   href="javascript:Tab.addTab('折扣审批', '/admin/discountApproval');">用户折扣审批</a></li>
                        </#if>
						<#if (role.permissions!"")?index_of(",10,")!=-1>
							<li><a class="waves-effect"
                                   href="javascript:Tab.addTab('客户绑定关系', '/admin/customerBinding');">客户绑定关系</a></li>
                        </#if>
						<#if (role.permissions!"")?index_of(",11,")!=-1>
							<li><a class="waves-effect"
                                   href="javascript:Tab.addTab('客户解绑审批', '/admin/approvalUnbinding');">客户解绑审批</a></li>
                        </#if>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-th-large"></i>商品管理</a>
                <ul>
					<#if (role.permissions!"")?index_of(",12,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('供应商商品管理', '/admin/product/factoryProductList');">供应商商品管理</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",13,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('供应商添加商品', '/admin/product/factory');">供应商添加商品</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",25,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('经销商商品管理', '/admin/product/dealersProductList');">经销商商品管理</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",27,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('经销商添加商品', '/admin/product/dealers');">经销商添加商品</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",26,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('平台商品管理', '/admin/product/platformProductList');">平台商品管理</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",28,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('平台添加商品', '/admin/product/platform');">平台添加商品</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",24,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('审批厂家商品', '/admin/approvalFactoryProduct');">审批厂家商品</a></li>
                    </#if>
					<#if (role.permissions!"")?index_of(",32,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('商品系列管理', '/admin/productSeries');">商品系列管理</a></li>
					</#if>
				</ul>
			</li>
			<li class="sub-menu system_menus system_1 3">
				<a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-list-alt"></i>订单管理</a>
				<ul>
					<#if (role.permissions!"")?index_of(",15,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('供应商订单列表', '/admin/factoryOrderList');">供应商订单列表</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",29,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('经销商订单列表', '/admin/dealersOrderList');">经销商订单列表</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",30,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('平台订单列表', '/admin/platformOrderList');">平台订单列表</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",16,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('库存状况', '/admin/stockStatus');">库存状况</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",17,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('售后服务', '/admin/afterService');">售后服务</a></li>
                    </#if>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-stats"></i>平台数据分析</a>
                <ul>
					<#if (role.permissions!"")?index_of(",18,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('财务报表', '/admin/fundReport');">财务报表</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",19,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('用户报表', '/admin/userdReport');">用户报表</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",20,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('用户地图', '/admin/userMap');">用户地图</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",5,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('业绩报告', '/admin/earningReport');">业绩报告</a></li>
                    </#if>
					<#if (role.permissions!"")?index_of(",31,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('公众号数据', '/admin/publicNumberData');">公众号数据</a>
                        </li>
                    </#if>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-asterisk"></i> 用户权限管理</a>
                <ul>
					<#if (role.permissions!"")?index_of(",3,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('用户管理', '/admin/userManagement');">用户管理</a></li>
                    </#if>
					<#if (role.permissions!"")?index_of(",2,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('角色权限管理', '/admin/roleManagement');">角色权限管理</a>
                        </li>
                    </#if>
                </ul>
            </li>
            <li class="sub-menu system_menus system_1 3">
                <a class="waves-effect" href="javascript:;"><i class="glyphicon glyphicon-phone"></i> 手机商城管理</a>
                <ul>
					<#if (role.permissions!"")?index_of(",1,")!=-1>
						<li><a class="waves-effect" href="javascript:Tab.addTab('修改轮播图', '/admin/CarouselFigure');">修改轮播图</a>
                        </li>
                    </#if>
					<#if (role.permissions!"")?index_of(",4,")!=-1>
						<li><a class="waves-effect"
                               href="javascript:Tab.addTab('修改欢迎图', '/admin/WelcomePic');">修改欢迎图</a></li>
                    </#if>
                </ul>
            </li>
            <li>
                <div class="upms-version">
                    <i class="glyphicon glyphicon-copyright-mark"></i>中山市伙丁网络科技有限公司
                </div>
            </li>
        </ul>
        <!-- /菜单区 -->
    </aside>
    <!-- /左侧导航区 -->
    <section id="content">
        <div class="content_tab">
            <div class="tab_left">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-left"></i></a>
            </div>
            <div class="tab_right">
                <a class="waves-effect waves-light" href="javascript:;"><i class="zmdi zmdi-chevron-right"></i></a>
            </div>
            <ul id="tabs" class="tabs">
                <li id="tab_home" data-index="home" data-closeable="false" class="cur">
                    <a class="waves-effect waves-light">首页</a>
                </li>
            </ul>
        </div>
        <div class="content_main">
            <div id="iframe_home" class="iframe cur">
                <div class="page-header">
                    <h3>繁灯网后台管理系统</h3>
                </div>
                <p id="role">用户角色:${role.roleName!""}</p>
            </div>
        </div>
    </section>
</section>
<footer id="footer"></footer>

<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.js"></script>
<script src="https://cdn.bootcss.com/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.js"></script>
<script src="/static/public/bootstrap/js/BootstrapMenu.min.js"></script>
<script src="https://cdn.bootcss.com/device.js/0.2.7/device.min.js"></script>
<script src="https://cdn.bootcss.com/fullPage.js/2.9.4/jquery.fullpage.min.js"></script>
<script src="/static/public/jquery/js/jquery.jdirk.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="/static/admin/js/system/index.js"></script>
</body>
</html>