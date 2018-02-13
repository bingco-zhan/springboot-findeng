<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>商品列表</title>
    <link rel="stylesheet" href="/static/MobileMall/common/style.css"/>
    <link rel="stylesheet" href="/static/MobileMall/common/swiper.min.css">
    <link rel="stylesheet" href="/static/MobileMall/customer/css/productList.css">
</head>
<body>
<div class="fd-content productList">
    <div class="fd-bg-white">
        <!--查询-->
        <div class="fd-searchbar" style="position: inherit">
            <div class="fd-margin-l-10">
                <div class="fd-search-classBtn">
                    <i class="icon iconfont icon-31fanhui1"></i>
                </div>
            </div>
            <div class="fd-searchbar-input fd-margin-r-10" style=" background: #f5f5f5;">
                <i class="icon iconfont icon-sousuo1"></i>
                <form action="javascript:search();">
                    <input type="search" placeholder="请输入搜索内容" id="search-input">
                </form>
            </div>
            <div class="fd-searchbar-cancel fd-margin-0 fd-margin-r-5"
                 style="background: transparent;color: #000;height: 100%;">
                <a href="/mobilemall/classification">
                    <i class="icon iconfont icon-shaixuan fd-font-size-18" style="color: #999;"></i>
                    <p class="fd-font-size-12" style="line-height: 2.1rem">筛选</p>
                </a>
            </div>
        </div>
        <div class="fd_wall-nav">
            <div class="fd-row fd-text-center fd-padded-t-5 fd-order">
                <div class="fd-col-xs-3 fd-padded-b-5 active" ok="productId" ov="DESC">综合</div>
                <div class="fd-col-xs-3 fd-padded-b-5" ok="productSales" ov="DESC">销量</div>
                <div class="fd-col-xs-3 fd-padded-b-5" ok="isPopular" ov="DESC">推荐</div>
                <div class="fd-col-xs-3 fd-padded-b-5" ok="retailPrice" ov="DESC">价格<i
                        class="iconfont icon icon-31fanhui2 fd_show-arrow"></i></div>
            </div>
        </div>
    </div>
    <!--商品展示-->
    <div class="fd-padded-2">
        <div class="fd-row fd-plist">
            <div class="fd-col-xs-6">
                <div class="fd-custom-margin fd-bg-white" style="min-height: 275px;" onclick="toP(this)">
                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/15126365528350.jpg">
                    <div>
                        <!--<div class="fd-btn-label fd-btn-label-danger fd-pull-left">现货</div>-->
                        <span class="fd-ellipsis-2 fd-text-left fd-pname">素范 2017秋冬新款羽绒服女中长款轻薄 长款 超薄加厚 深蓝色 L</span>
                    </div>
                    <div class="fd-bg-white fd-card-list-header fd-padded-l-0 fd-padded-r-0">
                        <p class="fd-font-size-16 fd-bg-white fd-pull-left fd-txt-red fd-font-weight-600 fd-padded-l-5 fd-price">
                            ￥13223.00</p>
                        <span style="color:gray;font-size:.5rem;" class="fd-sales">销量:20</span>
                        <div class="fd-btn-label fd_list-cart fd-pull-right"><i
                                class="icon iconfont icon-31gouwuche fd-font-size-18"></i></div>
                    </div>
                </div>
                <div class="fd_badge-label1 fd-kind"><span>订货</span></div>
                <!--<div class="fd_badge-label2"><span>现货</span></div>-->
            </div>

        </div>
    </div>

    <!--分页-->
    <footer>
        <div class="fd-msg" style="text-align: center; margin-bottom: .5rem; color: gray;font-size: .5rem;">-- 上拉刷新 --
        </div>
        <div class="fd-padded-t-5 fd-padded-b-5 fd-page" hidden>
            <div class="fd-row">
                <div class="fd-col-offset-1 fd-col-xs-12">
                    <div class="fd-col-xs-10">
                        <div class="fd-col-xs-4" id="pagePrev">上一页</div>
                        <div class="fd-col-xs-4">
                            <div class="pageNumber"><span>1</span>/29</div>
                        </div>
                        <div class="fd-col-xs-4" id="pageNext">下一页</div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--右边栏-->
    <div class="right-nav"></div>
</div>
</body>
<script type="text/javascript" src="/static/MobileMall/common/jquery-1.11.0.js"></script>
<script type="text/javascript" src="/static/MobileMall/common/swiper.min.js"></script>
<script>
    /*导入右边栏*/
    $(document).ready(function () {
        $(".right-nav").load("/static/MobileMall/left.html")
    });
    /*设置图片高度*/
    $(".fd-padded-2 .fd-col-xs-6 img").css("height", $(".fd-padded-2 .fd-col-xs-6").width());

    /*存储后台搜索条件,这是一个JSON对象*/
    var pmodel_json = ${pmodel};
</script>
<script type="text/javascript" src="/static/MobileMall/customer/js/productList.js"></script>
</html>