<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <title>活动列表</title>
    <link rel="stylesheet" href="asset/css/conmom.css"/>
    <link rel="stylesheet" href="asset/css/productList.css"/>
    <link rel="stylesheet" href="public/css/footer.css"/>
</head>
<body>
<div class="activityList productList">
    <div class="title"><i class="iconfont back icon-xiangzuo2"></i>活动列表</div>
    <div class="activity-div">
        <a class="activity-div-datalis">
            <div>
                <div class="activity-div-img">
                    <img src="asset/img/2.jpg"/>
                </div>
                <div class="activity-div-word">
							<span class="corner-tag">
								<div id="box1"></div>
								<div id="box2">活动</div>
 								<div id="box3"></div> 
							</span>
                    <div class="activity-div-name">新中式88278-4吸顶灯</div>
                    <div class="status-bar-box">
                        <div class="status-bar"></div>
                    </div>
                    <div class="activity-price">￥1234.00</div>
                    <span class="activity-pbtn">立即购买</span>
                </div>
            </div>
        </a>
        <a class="activity-div-datalis">
            <div>
                <div class="activity-div-img">
                    <img src="asset/img/5.png"/>
                </div>
                <div class="activity-div-word">
							<span class="corner-tag corner-tag-xinpin">
								<div id="box1"></div>
								<div id="box2">新品</div>
 								<div id="box3"></div> 
							</span>
                    <div class="activity-div-name">新中式88278-4吸顶灯</div>
                    <div class="status-bar-box">
                        <div class="status-bar"></div>
                    </div>
                    <div class="activity-price">￥1234.00</div>
                    <span class="activity-pbtn">立即购买</span>
                </div>
            </div>
        </a>
        <a class="activity-div-datalis">
            <div>
                <div class="activity-div-img">
                    <img src="asset/img/5.png"/>
                </div>
                <div class="activity-div-word">
							<span class="corner-tag">
								<div id="box1"></div>
								<div id="box2">活动</div>
 								<div id="box3"></div> 
							</span>
                    <div class="activity-div-name">新中式88278-4吸顶灯</div>
                    <div class="status-bar-box">
                        <div class="status-bar"></div>
                    </div>
                    <div class="activity-price">￥1234.00</div>
                    <span class="activity-pbtn">立即购买</span>
                </div>
            </div>
        </a>
    </div>
    <div class="pageDiv" style="">
        <div class="pageUpDown">
            <button id="pagePrev" data-offset="0">上一页</button>
            <button id="pageNow"><span id="now">1</span>/1</button>
            <button id="pageNext" data-offset="0">下一页</button>
        </div>
        <!-- 选择页数-->
        <div class="choosePage">
            <div class="choosePageClose">
                <span>选择页数</span>
                <i class="iconfont" id="closePage"></i>
            </div>
            <ul class="allPage">
                <li>1</li>
            </ul>
        </div>
    </div>
</div>
<!--底部[-->
<footer class="clearfix text-center footer">
    <div>
        <div class="bottom-area">
            <a class="bottom-nav-item active" href="">
                <i class="icon iconfont" style="font-size: .8rem;"></i>
                <p>主页</p>
            </a>
            <a class="bottom-nav-item" href="">
                <i class="icon iconfont icon-caidan" style="font-size: .8rem;"></i>
                <p>分类</p>
            </a>
            <a class="findeng">
                <div>
                    <img style="width:75%;margin-left: 0.3rem;" src="asset/img/logo.png" width="100%">
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
<!--底部]-->
</body>
<script type="text/javascript" src="public/jquery.min.js"></script>
<script>
    $("#pageNow").click(function () {
        $(".choosePage").toggle();
    });
    $("#closePage").click(function () {
        $(".choosePage").hide();
    });
</script>
</html>
