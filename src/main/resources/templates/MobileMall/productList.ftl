<!-- 产品列表 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>产品列表</title>
    <link rel="stylesheet" href="../public/dropload/css/dropload.css"/>
    <link rel="stylesheet" href="../asset/css/commom.css"/>
    <link rel="stylesheet" href="../asset/css/productList.css"/>
    <link rel="stylesheet" href="../asset/css/footer.css"/>
</head>
<body>
<div class="detaproductList productList">
    <div class="title"><i class="iconfont back icon-xiangzuo2" onclick="window.history.go(-1)"></i>产品列表</div>
    <!--搜索栏-->
    <div class="product-content">
        <form class="search">
            <div class="formDiv">
                <input placeholder="请输入搜索内容......" class="searchInput" id="keyword" value="">
                <a class="searchBtn" id="photoBtn"><i class="icon iconfont icon-sousuokuangsousuo"></i></a>
            </div>
        </form>
    </div>

    <!--按钮栏-->
    <div class="wall_nav_box">
        <a class="item active"><span class="in_border">推荐</span></a>
        <a class="item"><span class="in_border">最新</span></a>
        <a class="item"><span class="in_border">价格</span></a>
        <a class="item"><span class="in_border weui_navbar_item">筛选</span></a>
    </div>

    <!--商品列表-->
    <div class="content">
        <div class="clearfix">
            <div class="twoProduct">

            </div>
        </div>
        <div class="loading"></div>
    </div>
</div>

<!-- 没有商品数据时 -->
<div class="noProduct">
    <span><i class="iconfont">&#xe623;</i></span>
    <p>没有找到符合条件的灯具</p>
    <button id="allBtn">查看所有商品</button>
</div>
<!--筛选-->
<div class="screen">
    <div class="screen-popup"></div>
    <div class="filterSearch">
        <input type="text" placeholder="请输入关键字搜索" id="filterKeyword">
        <button class="findProductBtn"><i class="icon iconfont"></i></button>
    </div>
    <div class="screen-div">
        <div class="filterProperty mainProperty">
            <span>风格<i class="icon iconfont icon-xia" style="float: right;"></i></span>
            <div>
                <ul>
                    <li>
                        <a class="active">现代简约</a>
                    </li>
                    <li>
                        <a>欧式奢华</a>
                    </li>
                    <li>
                        <a>简约美式</a>
                    </li>
                    <li>
                        <a>古典美式</a>
                    </li>
                    <li>
                        <a>新中式</a>
                    </li>
                    <li>
                        <a>古典中式</a>
                    </li>
                    <li>
                        <a>后现代风格</a>
                    </li>
                    <li>
                        <a>儿童灯/老人/礼品</a>
                    </li>
                    <li>
                        <a>田园风/花草灯</a>
                    </li>
                    <li>
                        <a>地中海/蒂凡尼</a>
                    </li>
                    <li>
                        <a>北欧/宜家风</a>
                    </li>
                    <li>
                        <a>工业风/LOFT</a>
                    </li>
                    <li>
                        <a>其他</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="filterProperty mainProperty">
            <span>类型<i class="icon iconfont icon-xia" style="float: right;"></i></span>
            <div>
                <ul>
                    <li>
                        <a class="active">现代简约</a>
                    </li>
                    <li>
                        <a>欧式奢华</a>
                    </li>
                    <li>
                        <a>简约美式</a>
                    </li>
                    <li>
                        <a>古典美式</a>
                    </li>
                    <li>
                        <a>新中式</a>
                    </li>
                    <li>
                        <a>古典中式</a>
                    </li>
                    <li>
                        <a>后现代风格</a>
                    </li>
                    <li>
                        <a>儿童灯/老人/礼品</a>
                    </li>
                    <li>
                        <a>田园风/花草灯</a>
                    </li>
                    <li>
                        <a>地中海/蒂凡尼</a>
                    </li>
                    <li>
                        <a>北欧/宜家风</a>
                    </li>
                    <li>
                        <a>工业风/LOFT</a>
                    </li>
                    <li>
                        <a>其他</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="filterProperty mainProperty">
            <span>空间<i class="icon iconfont icon-xia fr"></i></span>
            <div>
                <ul>
                    <li>
                        <a class="active">现代简约</a>
                    </li>
                    <li>
                        <a>欧式奢华</a>
                    </li>
                    <li>
                        <a>简约美式</a>
                    </li>
                    <li>
                        <a>古典美式</a>
                    </li>
                    <li>
                        <a>新中式</a>
                    </li>
                    <li>
                        <a>古典中式</a>
                    </li>
                    <li>
                        <a>后现代风格</a>
                    </li>
                    <li>
                        <a>儿童灯/老人/礼品</a>
                    </li>
                    <li>
                        <a>田园风/花草灯</a>
                    </li>
                    <li>
                        <a>地中海/蒂凡尼</a>
                    </li>
                    <li>
                        <a>北欧/宜家风</a>
                    </li>
                    <li>
                        <a>工业风/LOFT</a>
                    </li>
                    <li>
                        <a>其他</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="filterFooter">
            <button class="cancelBtn">取消</button>
            <button class="sureBtn">确定</button>
        </div>
    </div>
</div>
<!--筛选]-->
<!--底部[-->
<footer class="clearfix text-center footer">
    <div>
        <div class="bottom-area">
            <a class="bottom-nav-item active" href="#">
                <i class="icon iconfont" style="font-size: .8rem;"></i>
                <p>主页</p>
            </a>
            <a class="bottom-nav-item" href="/mobilemall/search">
                <i class="icon iconfont icon-caidan" style="font-size: .8rem;"></i>
                <p>分类</p>
            </a>
            <a class="findeng">
                <div>
                    <img style="width:75%;margin-left: 0.3rem;" src="../asset/img/logo.png" width="100%">
                </div>
            </a>
            <!--  -->
            <div class="component" style="display: none">
                <div class="cn-wrapper opened-nav" id="cn-wrapper">
                    <ul>
                        <li>
                            <a><span class="icon iconfont icon-dianhua2"></span></a>
                        </li>
                        <li>
                            <a><span class="icon iconfont icon-weixin1"></span></a>
                        </li>
                        <li>
                            <a><span class="icon iconfont icon-qietu-"></span></a>
                        </li>
                        <li>
                            <a><span class="icon iconfont icon-quanbu1"></span></a>
                        </li>
                        <li>
                            <a><span class="icon iconfont icon-tuijian2"></span></a>
                        </li>
                    </ul>
                </div>
            </div>
            <a class="bottom-nav-item" href="">
                <i class="icon iconfont" style="font-size: .8rem;"></i>
                <p>购物车</p>
            </a>
            <a class="bottom-nav-item" href="">
                <i class="icon iconfont" style="font-size: .8rem;"></i>
                <p>我的</p>
            </a>
        </div>
    </div>
</footer>
<!--加载动画-->
<div class="jiazai" style="display: none;width:100%;">
    <div class="sk-circle">
        <div class="sk-circle1 sk-child"></div>
        <div class="sk-circle2 sk-child"></div>
        <div class="sk-circle3 sk-child"></div>
        <div class="sk-circle4 sk-child"></div>
        <div class="sk-circle5 sk-child"></div>
        <div class="sk-circle6 sk-child"></div>
        <div class="sk-circle7 sk-child"></div>
        <div class="sk-circle8 sk-child"></div>
        <div class="sk-circle9 sk-child"></div>
        <div class="sk-circle10 sk-child"></div>
        <div class="sk-circle11 sk-child"></div>
        <div class="sk-circle12 sk-child"></div>
    </div>
    <div>加载中...</div>
</div>
<!--底部]-->
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="../public/dropload/js/dropload.min.js"></script>
<script type="text/javascript" src="../asset/js/productList.js"></script>
</html>
