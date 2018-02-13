<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>繁灯网</title>
    <link rel="stylesheet" href="/static/MobileMall/common/style.css"/>
    <link rel="stylesheet" href="/static/MobileMall/common/font/iconfont.css"/>
    <link rel="stylesheet" href="/static/MobileMall/customer/css/index.css"/>
    <link rel="stylesheet" href="/static/MobileMall/common/swiper.min.css">
</head>

<body>
<div class="fd-content">
    <!--查询-->
    <div class="fd-searchbar">
        <div class="fd-margin-l-10">
            <div class="fd-search-classBtn">
                <i class="icon iconfont icon-fenlei"></i>
            </div>
        </div>
        <div class="fd-searchbar-input ">
            <form action="javascript:search();">
                <input type="search" placeholder="请输入搜索内容" id="search-input">
            </form>
        </div>
        <div class="fd-searchbar-cancel">
            <i class="icon iconfont icon-sousuo1 fd-font-size-18"></i>
        </div>
    </div>
    <div>
        <div class="fd-classfiy-wrapper">
            <div class="fd-triangle-up"></div>
            <section class="fd-grid">
                <div class="fd-row">
				        
				            <#list styles as style>
                                <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                    <span class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                          data-id="${style.propertyValueId}">${style.propertyValue}</span>
                                </div>
                            </#list>

            </section>
        </div>
    </div>
    <!--轮播-->
    <div class="swiper-container swiper-container1">
        <div class="swiper-wrapper">

					<#list carousels as carousel>
                        <div class="swiper-slide">
                            <a href="${carousel.carouselLink}">
                                <img src="/static/picture/carousel/${carousel.carouselPic}" width="100%">
                            </a>
                        </div>
                    </#list>

        </div>
        <div class="swiper-pagination"></div>
    </div>
    <!--菜单-->
    <div class="fd-row fd-caidan-row fd-nav-five fd-bg-white fd-margin-b-10">
        <a class="fd-col-xs-2 fd-entry-link" href="/mobilemall/productlist?productTag=爆款&offset=1&limit=10">
            <i class="icon iconfont icon-xianshiqianggou"></i>
            <div class="fd-label">热销</div>
        </a>
        <a class="fd-col-xs-2 fd-entry-link" href="/mobilemall/productlist?productTag=新品&offset=1&limit=10">
            <i class="icon iconfont icon-xianshiqianggou"></i>
            <div class="fd-label">新品</div>
        </a>
        <a class="fd-col-xs-2 fd-entry-link" href="/mobilemall/productlist?productTag=推荐&offset=1&limit=10">
            <i class="icon iconfont icon-xianshiqianggou"></i>
            <div class="fd-label">推荐</div>
        </a>
        <a class="fd-col-xs-2 fd-entry-link" href="/mobilemall/productlist?offset=1&limit=10">
            <i class="icon iconfont icon-xianshiqianggou"></i>
            <div class="fd-label">全部</div>
        </a>
        <a class="fd-col-xs-2 fd-entry-link">
            <i class="icon iconfont icon-xianshiqianggou"></i>
            <div class="fd-label">同城</div>
        </a>
    </div>
    <!--店铺信息-->
			<#if DPXX??>
				 <div class="fd-bg-white">
                     <div class="fd-card-list-header">
                         <div>
                             <span>店铺信息</span>
                         </div>
                     </div>
                     <!--	<div style="background-image: url(customer/img/banner.jpg);background-size: 100% 100%;">-->
                     <div class="shop-bnner">
                         <img src="/static/MobileMall/customer/img/banner.jpg" width="100%"/>
                         <div class="shopInfo-textDate">
                             <p class="fd-text-left"><span
                                     class="fd-font-size-18 fd-ellipsis-1">${DPXX.companyName}</span></p>
                             <p class="fd-text-left "><span><strong>联系电话:</strong>${DPXX.phoneNumber}</span></p>
                             <p class="fd-text-left "><span
                                     class="fd-ellipsis-2"><strong>店铺信息:</strong>${DPXX.companyAddressDetail}</span></p>
                         </div>
                     </div>
                 </div>
            </#if>

    <!--活动-->
    <div class="fd-card-list fd-margin-b-10 fd-bg-white">
        <div class="fd-card-list-header fd-padded-l-5">
            <div>
                <div class="sprite fd-pull-left"></div>
                <span style="bottom: 13px;position: absolute;">活动火爆中</span>
            </div>
            <i class="icon iconfont icon-83 fd-font-size-20"></i>
        </div>
        <div>
            <div class="fd-row fd-row-card-content fd-custom-lunbo">

						<#list HDs as hd>
                            <div class="fd-col-xs-4">
                                <a href="/mobilemall/productdetails/${hd.productId}">
                                    <div class="fd-custom-margin">
                                        <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${hd.cover?split(',')[0]}"/>
                                        <p class="fd-ellipsis-1 fd-font-size-12">${hd.productName}</p>
                                        <p class="fd-custom-item-price fd-font-size-12">￥${hd.retailPrice}<span
                                                class="fd-custom-origin fd-font-size-12">￥${hd.retailPrice * 1.3}</span>
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </#list>

            </div>
        </div>
    </div>
    <!--新品-->
    <div class="fd-card-list fd-margin-b-10">
        <img src="customer/img/newP_01.jpg"/>
        <div class="fd-row fd-row-card-content fd-bg-lightgray">
            <div class="fd-col-xs-12">
                <div class="">

								<#list DDs as d>
									<div class="fd-col-xs-3">
                                        <div class="fd-margin-t-10 fd-bg-white fd-custom-jianju">
                                            <h4 class="fd-text-left fd-padded-l-10"><#if d_index == 0>吊灯</#if>
                                                &nbsp;</h4>
                                            <a href="/mobilemall/productlist?offset=1&limit=10&types=180">
                                                <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${d.cover?split(',')[0]}"/>
                                            </a>
                                        </div>
                                    </div>
                                </#list>
								
								<#list SDDs as sd>
									<div class="fd-col-xs-3">
                                        <div class="fd-custom-margin fd-margin-t-10 fd-bg-white">
                                            <h4 class="fd-text-left fd-padded-l-10">吸顶灯</h4>
                                            <a href="/mobilemall/productlist?offset=1&limit=10&types=185">
                                                <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${sd.cover?split(',')[0]}"/>
                                            </a>
                                        </div>
                                    </div>
                                </#list>

                </div>
            </div>
					
					<#list BDs as b>
						<div class="fd-col-xs-4">
                            <div class="fd-custom-margin fd-margin-t-5 fd-bg-white">
                                <h4 class="fd-text-center">壁灯</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&types=181">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${b.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>
					
					<#list TDs as t>
						<div class="fd-col-xs-4">
                            <div class="fd-custom-margin fd-margin-t-5 fd-bg-white">
                                <h4 class="fd-text-center">台灯</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&types=182">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${t.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>
					
					<#list LDDs as ld>
						<div class="fd-col-xs-4">
                            <div class="fd-custom-margin fd-margin-t-5 fd-bg-white">
                                <h4 class="fd-text-center">落地灯</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&types=184">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${ld.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>

        </div>
        <div class="fd-card-list-content fd-margin-t-10">
            <img src="customer/img/activity_03.jpg">
        </div>
    </div>
    <!--风格分类-->
    <div class="fd-bg-e9">
        <div class="fd-card-list-header fd-tit-img">
            <div class="tit-img">
                <img src="customer/img/fengelan.jpg" width="100%"/>
            </div>
        </div>
        <div class="fd-row fd-row-card-content fd-bg-e9">
            <div class="fd-col-xs-6">
                <div class="fd-custom-margin fd-margin-t-3">
                    <h4 class="fd-text-left fd-padded-l-10">新中式</h4>
							<#list SZSs as szs>
								<a href="/mobilemall/productlist?offset=1&limit=10&styles=526">
                                    <div class="fd-col-xs-6 fd-bg-white">
                                        <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${szs.cover?split(',')[0]}"/>
                                    </div>
                                </a>
                            </#list>
                </div>
            </div>
            <div class="fd-col-xs-6">
                <div class="fd-custom-margin fd-margin-t-3">
                    <h4 class="fd-text-left fd-padded-l-10">现代简约</h4>
							<#list XDJYs as xd>
								<a href="/mobilemall/productlist?offset=1&limit=10&styles=210">
                                    <div class="fd-col-xs-6 fd-bg-white">
                                        <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${xd.cover?split(',')[0]}"/>
                                    </div>
                                </a>
                            </#list>

                </div>
            </div>
            <div class="fd-col-xs-6">
                <div class="fd-custom-margin fd-margin-t-3">
                    <h4 class="fd-text-left fd-padded-l-10">美式</h4>
							<#list MSs as ms>
								<a href="/mobilemall/productlist?offset=1&limit=10&styles=657">
                                    <div class="fd-col-xs-6 fd-bg-white">
                                        <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${ms.cover?split(',')[0]}"/>
                                    </div>
                                </a>
                            </#list>
                </div>
            </div>
            <div class="fd-col-xs-6">
                <div class="fd-custom-margin fd-margin-t-3">
                    <h4 class="fd-text-left fd-padded-l-10">欧式</h4>
							<#list OSs as os>
								<a href="/mobilemall/productlist?offset=1&limit=10&styles=208">
                                    <div class="fd-col-xs-6 fd-bg-white">
                                        <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${os.cover?split(',')[0]}"/>
                                    </div>
                                </a>
                            </#list>
                </div>
            </div>
						
					<#list HXDFGs as hxd>
						<div class="fd-col-xs-3">
                            <div class="fd-custom-margin fd-margin-t-3">
                                <h4 class="fd-text-center">后现代</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&styles=649">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${hxd.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>

					<#list GDZSs as gdzs>
						<div class="fd-col-xs-3">
                            <div class="fd-custom-margin fd-margin-t-3">
                                <h4 class="fd-text-center">中式</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&styles=604">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${gdzs.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>
					
					<#list BOs as bo>
						<div class="fd-col-xs-3">
                            <div class="fd-custom-margin fd-margin-t-3">
                                <h4 class="fd-text-center">北欧</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&styles=671">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${bo.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>
					
					<#list ETDs as etd>
						<div class="fd-col-xs-3">
                            <div class="fd-custom-margin fd-margin-t-3">
                                <h4 class="fd-text-center">儿童灯</h4>
                                <a href="/mobilemall/productlist?offset=1&limit=10&styles=212">
                                    <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${etd.cover?split(',')[0]}"/>
                                </a>
                            </div>
                        </div>
                    </#list>
        </div>
        <div class="fd-card-list-content fd-margin-t-10">
            <img src="customer/img/activity_01.jpg"/>
        </div>
    </div>
    <!--今日推荐-->
    <div class="fd-card-list fd-margin-b-10 fd-bg-white">
        <div class="fd-card-list-header fd-padded-r-0">
            <div>
                <h2>今日推荐</h2>
            </div>
            <div class="fd-pull-right fd-padded-t-10"><span class="fd-font-size-12 fd-pull-left">查看更多</span><i
                    class="icon iconfont icon-gengduo fd-pull-right fd-flipx"></i></div>
        </div>
        <div class="fd-list-item fd-padded-b-10">
            <div class="fd-box-show">
                <ul class="fd-list fd-media-list">
                    <li>
                        <div class="swiper-container Recommend">
                            <div class="swiper-wrapper">
										
									<#list toDays as tdy>
                                        <div class="fd-media-list-item-inner swiper-slide"
                                             onclick="location.href='/mobilemall/productdetails/${tdy.productId}';">
                                            <div class="fd-list-item-media">
                                                <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/${tdy.cover?split(',')[0]}"/>
                                            </div>
                                            <div class="fd-list-item-inner">
                                                <div class="fd-list-item-text fd-padded-t-10">
                                                    <div class="fd-list-item-title fd-font-size-18 fd-ellipsis-2">
                                                            ${tdy.productName}&emsp;&emsp;&emsp;
                                                    </div>
                                                </div>
                                                <div class="fd-list-item-text fd-padded-t-10">
                                                    <p class="fd-custom-item-price fd-font-size-14">￥${tdy.retailPrice}
                                                        <span class="fd-custom-origin fd-font-size-14">￥${tdy.retailPrice / 1.3}</span>
                                                    </p>
                                                    <span>销量:${tdy.productSales}</span>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>

                            </div>
                        </div>
                    </li>
                </ul>
                <!--<div class="swiper-container Recommend">
                    <div class="swiper-wrapper">
                        <div class="swiper-slide">
                            <img src="customer/img/20171130142206 (2).jpg" width="100%" />
                        </div>
                        <div class="swiper-slide">
                            <img src="customer/img/20171130142206 (1).jpg" width="100%" />
                        </div>
                        <div class="swiper-slide">
                            <img src="customer/img/20171130142206 (3).jpg" width="100%" />
                        </div>
                    </div>
                </div> -->
            </div>
        </div>
    </div>
    <!--同城-->
    <div class="fd-bg-e9">
        <div>
            <img src="customer/img/style_Column2.jpg" width="100%">
            <a class="more fd-font-size-14" href="/mobilemall/productListAjax?productTag=爆款&offset=4&limit:10">
                <span>查看更多</span><i class="icon iconfont icon-diqufucengjinruliangfantuananniu fd-font-size-22"></i>
            </a>
        </div>
        <div class="swiper-container seckill-slider">
            <div class="swiper-wrapper">
  					
  					<#list TCs as tc>
                        <div class="swiper-slide">
                            <a href="productDetails.html">
                                <img src="${tc.cover}"/>
                                <p class="hot-dress-module-word fd-text-center fd-ellipsis-2">${tc.productName}</p>
                                <p class="hot-dress-module-pric fd-text-center fd-custom-item-price">
                                    ￥${tc.unitPrice}</p>
                            </a>
                        </div>
                    </#list>

            </div>
        </div>
    </div>
    <!--猜你喜欢-->
    <div>
        <div class="fd-card-list-content">
            <img src="customer/img/fengelan_01.png">
        </div>
        <div class="fd-row fd-row-card-content fd-bg-lightgray myLove">

            <div class="fd-col-xs-6" style="height: 274px">
                <div class="fd-custom-margin fd-margin-t-3 fd-bg-white">
                    <div onclick="productdetails(this);" class="fd-product-detailHeight" data-id="">
                        <img src=""/>
                        <div class="fd-btn-label fd-btn-label-danger fd-pull-left">
                            现货
                        </div>
                        <span class="fd-ellipsis-2 fd-text-left ">productName</span>
                    </div>
                    <div class="fd-bg-white fd-card-list-header fd-padded-l-0 fd-padded-r-0">
                        <p class="fd-custom-item-price fd-font-size-12 fd-bg-white a fd-pull-left">￥1234645.00
                        <div class="fd-btn-label fd-btn-label-danger fd-pull-right fd-goods-cart" onclick="addCart();">
                            <i class="icon iconfont icon-31gouwuche fd-font-size-18"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="fd-more-btn fd-hide">查看更多</div>
    <div class="dropload-load fd-text-center">
        <div><i class="icon iconfont icon-jiazaizhong"></i></div>
    </div>
    <!--底部-->
    <footer class="fd-bar fd-bar-tab" id="footer">
        <div class="fd-bar-tab-item fd-active" tapmode="">
            <i class="icon iconfont icon-31shouye"></i>
            <div class="fd-bar-tab-label">首页</div>
        </div>
        <div class="fd-bar-tab-item classify" tapmode="">
            <i class="icon iconfont icon-fenlei"></i>
            <div class="fd-bar-tab-label">分类</div>
        </div>
        <div class="fd-bar-tab-item" tapmode="">
            <div class="fd-badge fooCartNum">9</div>
            <i class="icon iconfont icon-31gouwuche"></i>
            <div class="fd-bar-tab-label">购物车</div>
        </div>
        <div class="fd-bar-tab-item" tapmode="">
            <div class="fd-dot"></div>
            <i class="icon iconfont icon-wo"></i>
            <div class="fd-bar-tab-label">我的</div>
        </div>
    </footer>
    <!--右边栏-->
    <div class="right-nav"></div>
</div>
<!--<div class="fd-tips fd-margin-b-15" id="tips-1">
    <i class="icon iconfont icon-diqufucengdanchujinggao fd-font-size-22"></i>
    <div class="fd-tips-title">消息提示条消息提示条消息提示</div>
    <i class="fd-iconfont fd-icon-close"  onclick="closeTips()"></i>
</div>-->
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="/static/MobileMall/common/font/iconfont.js"></script>
<script type="text/javascript" src="/static/MobileMall/common/swiper.min.js"></script>
<script type="text/javascript" src="/static/MobileMall/customer/js/index.js"></script>

</html>