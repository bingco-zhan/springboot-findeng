<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>商品详情</title>
    <link rel="stylesheet" href="/static/MobileMall/common/style.css"/>
    <link rel="stylesheet" href="/static/MobileMall/common/swiper.min.css">
    <link rel="stylesheet" href="/static/MobileMall/customer/css/product.css"/>
</head>
<body>
<div class="fd-content productDetails">
    <!--产品轮播-->
    <div class="swiper-container swiper-product">
        <div class="swiper-wrapper">
            <!-- <div class="swiper-slide">
                <a href=""><img src="/static/MobileMall/customer/img/20171130142206 (2).jpg"></a>
            </div> -->
					
					<#list product.cover?split(",") as pic>
						<div class="swiper-slide">
                            <img src="http://findeng.com:8080/findeng/picture/product/${pic}">
                        </div>
                    </#list>

        </div>
        <div class="swiper-pagination sp1"></div>
    </div>
    <!--产品内容-->
    <div class="fd-product-content fd-margin-b-10">
        <div class="fd-row fd-bg-white fd-padded-l-5 fd-padded-r-5 fd-padded-t-10 fd-padded-b-10">
            <div class="fd-col-xs-6"><p id="fd-pname">${product.productName}</p></div>
            <div class="fd-col-xs-6 fd-text-right">
                <span class="fd-border"><#if product.productKind == 0><i
                        class="icon iconfont icon-xihuan fd-padded-r-5"></i>订货</#if></span>
            </div>
            <div class="fd-col-xs-6 fd-padded-t-10"><strong class="prouctPric">￥${product.retailPrice}</strong><span
                    class="fd-custom-origin fd-font-size-12">原价:￥${product.retailPrice * 1.3}</span></div>
            <div class="fd-col-xs-6 fd-text-right fd-padded-t-10 query">
						<#if product.productKind == 1><span>查询库存</span></#if>
            </div>
        </div>
        <div class="fd-row fd-product-content fd-bg-white fd-high-grade fd-padded-t-5 fd-padded-l-5 fd-padded-r-5">
            <div class="fd-col-xs-4 fd-font-size-14"><i class="icon iconfont icon-quality fd-font-size-20"></i>品质保障
            </div>
            <div class="fd-col-xs-4 fd-font-size-14"><i class="icon iconfont icon-jiaoyi fd-font-size-20"></i>交易担保</div>
            <div class="fd-col-xs-4 fd-font-size-14"><i
                    class="icon iconfont icon-7tianwuliyoutuihuanhuoxianxing fd-font-size-20"></i>天无理由退货
            </div>
        </div>
    </div>
    <!--产品规格-->
    <div class="fd-margin-b-10 fd-bg-white fd-padded-l-5 fd-padded-r-5 fd-padded-t-10 fd-padded-b-10">
        <div class="norms">
            <div class="fd-row  lamp-color fd-padded-t-5"><!--灯的颜色-->
                <p class="fd-padded-t-5 fd-padded-l-5">颜色</p>
                <!-- <div class="fd-col-xs-4 fd-text-center">
                    <div class=" fd-media-list-item-inner">
                        <div class="fd-list-item-inner fd-ellipsis-1 fd-font-size-14">米黄色</div>
                    </div>
                </div> -->
            </div>

            <div class="fd-row  lamp-lightColor fd-padded-t-5"><!--光色-->
                <p class="fd-padded-t-5 fd-padded-l-5">光色</p>
                <!-- <div class="fd-col-xs-3">
                    <div class=" fd-media-list-item-inner">
                        <div class="fd-list-item-inner fd-ellipsis-1 fd-font-size-14 fd-text-center">单色</div>
                    </div>
                </div> -->

            </div>

            <div class="fd-row  lamp-spec fd-padded-t-5"><!--灯的规格-->
                <p class="fd-padded-t-5 fd-padded-l-5">规格</p>

                <!-- <div class="fd-col-xs-6">
                    <div class=" fd-media-list-item-inner">
                        <div class="fd-list-item-media"></div>
                        <div class="fd-list-item-inner fd-ellipsis-1 fd-font-size-14">T6061/S台灯</div>
                    </div>
                </div> -->

            </div>

        </div>
        <div class="product-number fd-padded-t-10">
            <div class="fd-list-item-inner fd-padded-r-5 fd-padded-t-10">
                <p class="fd-pull-left">数量</p>
                <div class="fd-row">
                    <div class="fd-col-xs-4 product-number-content fd-pull-right">
                        <div class="fd-col-xs-4 reduce"><i class="icon iconfont icon-jianquminus25"></i></div>
                        <div class="fd-col-xs-4"><input type="number" class="fd-input fd-text-center number" value="1">
                        </div>
                        <div class="fd-col-xs-4 increase"><i class="icon iconfont icon-jia"></i></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--店铺其他产品-->
    <div class="fd-card-list fd-margin-b-10 fd-bg-white">
        <div class="fd-card-list-header fd-padded-l-5">
            <div>
                <span style="vertical-align: middle;color: #ff0074;"><i
                        class="icon iconfont icon-xihuan fd-font-size-22"></i>猜你喜欢</span>
            </div>
            <i class="icon iconfont icon-83 fd-font-size-20"></i>
        </div>
        <div class="fd-row fd-row-card-content fd-custom-lunbo">
            <div class="swiper-container guess-like">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[0].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[0].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[0].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[0].retailPrice?c}</p>
                            </div>
                        </div>

                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[1].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[1].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[1].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[1].retailPrice?c}</p>
                            </div>
                        </div>
                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[2].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[2].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[2].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[2].retailPrice?c}</p>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide">
                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[3].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[3].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[3].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[3].retailPrice?c}</p>
                            </div>
                        </div>
                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[4].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[4].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[4].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[4].retailPrice?c}</p>
                            </div>
                        </div>
                        <div class="fd-col-xs-4">
                            <div class="fd-custom-margin">
                                <a href="/mobilemall/productdetails/${mylove[5].productId?c}"><img
                                        src="http://findeng.com:8080/findeng/picture/product/${mylove[5].cover?split(',')[0]}"></a>
                                <p class="fd-ellipsis-1 fd-font-size-12">${mylove[5].productName}</p>
                                <p class="fd-custom-item-price fd-font-size-12">￥${mylove[5].retailPrice?c}</p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 如果需要分页器 -->
                <div class="swiper-pagination swiper-paginationLike"></div>
            </div>
        </div>
    </div>
    <!--商品详情、规格参数、-->
    <div class="fd-margin-b-10 fd-details fd-bg-white">
        <div class="fd-row">
            <div class="fd-col-xs-6 fd-text-center active"> 商品详情</div>
            <div class="fd-col-xs-6 fd-text-center"> 规格参数</div>
        </div>
        <div class="fd-padded-t-10 fd-padded-b-10">
            <!--商品详情-->
            <div class="product-details">
                <!-- <div><img src="/static/MobileMall/customer/img/20171130142206 (2).jpg"/></div>
                <div><img src="/static/MobileMall/customer/img/20171130142206 (1).jpg"/></div>
                <div><img src="/static/MobileMall/customer/img/defaultImg.jpg"/></div>
                <div><img src="/static/MobileMall/customer/img/defaultImg.jpg"/></div>
                <div><img src="/static/MobileMall/customer/img/defaultImg.jpg"/></div> -->
						
						<#list product.descriptionPic?split(",") as pic>
							<div><img src="http://findeng.com:8080/findeng/picture/product/${pic}"></div>
                        </#list>

            </div>
            <!--规格参数-->
            <div class="product-norms">
                <p class="fd-text-center fd-padded-t-10 fd-padded-b-10">商品参数</p>
                <ul class="values fd-font-size-14">
                    <li><span>品牌</span> <span>${product.productBrand!}</span></li>
                    <li><span>类型</span> <span>${product.productType!}</span></li>
                    <li><span>材质</span> <span>${product.productMaterial!}</span></li>
                    <li><span>风格</span> <span>${product.productStyle!}</span></li>
                    <li><span>光源类型</span> <span id="lightType">${product.light_Type!}</span></li>
                    <li><span>光源数量</span> <span id="lightNumber">${product.lightNumber!}</span></li>
                    <li><span>功率</span> <span id="productPower">${product.productPower!}</span></li>
                    <li><span>空间</span> <span id="space">${product.productSpace!}</span>
                    </li>
                    <li><span>颜色</span> <span id="productColor">${product.productColor!}</span></li>
                    <li><span>型号</span> <span id="productCode">${product.productCode!}</span></li>
                    <li><span>产品尺寸</span> <span
                            id="productSize"> 长: ${product.productLength!?c}&emsp;x&emsp;宽: ${product.productWidth!?c}&emsp;x&emsp;高: ${product.productHeight!?c}</span>
                    </li>
                    <li><span>净重(kg)</span> <span id="productWeight">${product.productWeight!?c}</span></li>
                    <li><span>包装尺寸</span> <span
                            id="packageSize"> 长: ${product.packageLength!?c}&emsp;x&emsp;宽: ${product.packageWidth!?c}&emsp;x&emsp;高: ${product.packageHeight!?c}</span>
                    </li>
                    <li><span>毛重(kg)</span> <span id="packageWeight">${product.packageWeight!?c}</span></li>
                </ul>
            </div>
        </div>
    </div>
    <!--底部-->
    <footer>
        <div>
            <div class="fd-row fd-text-center">
                <div class="fd-col-xs-2"><i class="icon iconfont icon-31daifahuo fd-font-size-18"></i>
                    <p>客服</p></div>
                <div class="fd-col-xs-2">
                    <div class="fd-badge fooCartNum">9</div>
                    <i class="icon iconfont icon-31gouwuche fd-font-size-18"></i>
                    <p>购物车</p>
                </div>
                <div class="fd-col-xs-4 add-shoppingCart">加入购物车</div>
                <div class="fd-col-xs-4 once-buy">立即购买</div>
            </div>
        </div>
    </footer>

    <script type="text/javascript">
        var seriesList = ${seriesList}; // 系列商品
    </script>

</div>
</body>
<script type="text/javascript" src="/static/MobileMall/common/jquery-1.11.0.js"></script>
<script type="text/javascript" src="/static/MobileMall/common/swiper.min.js"></script>
<script type="text/javascript" src="/static/MobileMall/common/font/iconfont.js"></script>
<script src="/static/MobileMall/customer/js/productDetails.js"></script>
</html>
