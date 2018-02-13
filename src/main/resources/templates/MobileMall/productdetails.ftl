<!-- 产品详情 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <title>繁灯网</title>
    <link rel="stylesheet" href="../../asset/css/commom.css"/>
    <link rel="stylesheet" href="../../asset/css/product.css"/>
    <link rel="stylesheet" href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css"/>
</head>
<body>
	<#assign data=detailJSON?eval />
<div class="productDetalis">
    <div class="title title_one" style="display: block;">
        <i class="iconfont back">&#xe624;</i>
        <i class="iconfont topCart">&#xe605;
            <span class="plusSpan all">0</span>
        </i>
    </div>
    <div class="title title_two" style="display: none;">
        <ul>
            <li class="active parameter">详细参数</li>
            <li class="picture-detel">图片详情</li>
        </ul>
        <i class="iconfont back">&#xe624;</i>
        <i class="iconfont topCart">&#xe605;
            <span class="plusSpan all">0</span>
        </i>
    </div>

    <!--轮播图-->
    <div class="swiper-container carousel made">
        <div class="swiper-wrapper">
			      <#if data.product.cover1??>
			      	 <div class="swiper-slide goods-scroll">
                         <div class="backImage">
                             <img src="${data.product.cover1?replace("product","saveProduct")}"
                                  style="z-index:100;position:absolute;top:0;opacity:0;">
                             <img src="${data.product.cover1}">
                         </div>
                     </div>
                  </#if>
			      <#if data.product.cover2??>
			      	 <div class="swiper-slide goods-scroll">
                         <div class="backImage">
                             <img src="${data.product.cover2?replace("product","saveProduct")}"
                                  style="z-index:100;position:absolute;top:0;opacity:0;">
                             <img src="${data.product.cover2}">
                         </div>
                     </div>
                  </#if>
			      <#if data.product.cover3??>
			      	 <div class="swiper-slide goods-scroll">
                         <div class="backImage">
                             <img src="${data.product.cover3?replace("product","saveProduct")}"
                                  style="z-index:100;position:absolute;top:0;opacity:0;">
                             <img src="${data.product.cover3}">
                         </div>
                     </div>
                  </#if>
			      <#if data.product.cover4??>
			      	 <div class="swiper-slide goods-scroll">
                         <div class="backImage">
                             <img src="${data.product.cover4?replace("product","saveProduct")}"
                                  style="z-index:100;position:absolute;top:0;opacity:0;">
                             <img src="${data.product.cover4}">
                         </div>
                     </div>
                  </#if>
			       <#if data.product.cover5??>
			      	 <div class="swiper-slide goods-scroll">
                         <div class="backImage">
                             <img src="${data.product.cover5?replace("product","saveProduct")}"
                                  style="z-index:100;position:absolute;top:0;opacity:0;">
                             <img src="${data.product.cover5}">
                         </div>
                     </div>
                   </#if>
        </div>
        <div class="swiper-pagination"></div>
    </div>

    <!--商品信息-->
    <div class="product-msg">
        <div class="clearfix">
            <div class="product-name" style="float: left">
                <p class="product-word">${data.product.productAliasName}</p>
                <div class="price-now">
                    <span class="price-now--unit">¥</span>
                    <span class="price-now--price">${data.product.retailPrice?c}</span>
                </div>
            </div>
            <div class="hasOrNot" style="display:none;">
                <p>交货期：${(data.product.deliveryTime!2)+1}天</p>
            </div>

        </div>
        <div>
            <div class="service-content-item item clearfix">
                <div>
                    <div>
			      				<span class="item-icon">
									<div class="meili-all-vue-base-image">
										<i class="icon iconfont">&#xe61a;</i>
									</div>
								</span>
                    </div>
                    <span>品质保证</span>
                </div>
                <div>
                    <div>
			      				<span class="item-icon">
									<div class="meili-all-vue-base-image">
										<i class="icon iconfont">&#xe60d;</i>
									</div>
								</span>
                    </div>
                    <span>交易担保</span>
                </div>
                <div>
		      			 	<span class="item-icon">
								<div class="meili-all-vue-base-image">
									<i class="icon iconfont icon-jiaoyibaozhang"></i>
								</div>
							</span>
                    <span class="item-name">
				       			 7天无理由退货
			      			</span>
                </div>
            </div>
        </div>
    </div>

    <!--产品规格-->
    <div class="module-moresku">
        <div class="dialog">
            <div class="dialog-core">
                <div class="meili-all-vue-detail-base-sku sku sku m-fixed" position="bottom">
                    <div class="sku-content">
                        <div class="sku-content-scroll">
                            <div class="scroll">
                                <div class="prop">
                                    <dl class="prop-rows">
                                        <dt class="prop-rows-title" style="padding-left: .1rem;">
                                            产品规格：
                                            <span class="showprice1 hide" data-price="690"><i
                                                    class="iconfont"></i></span><s id="costPrice1"
                                                                                    style="display:inline-block;padding: 0.1rem 0.4rem 0.4rem;float: right;font-size: .5rem;"
                                                                                    data-price=""></s>
                                        </dt>
                                        <dd class="prop-rows-content homology">
                                            <ol class="prop-list">
														    <#list data.seriesProduct! as sProduct>
                                                                <li class="prop-item <#if data.product.productId == sProduct.productId>active</#if>"
                                                                    id="${sProduct.productId?c}">
                                                                    <img alt=""
                                                                         src="${ProductThumbnailSrc+sProduct.cover1?replace(sProduct.cover1?substring(0,sProduct.cover1?last_index_of("/")+1),"")}">
                                                                    <span>${sProduct.productName}</span>
                                                                </li>
                                                            </#list>
                                            </ol>
                                        </dd>
                                    </dl>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix buyNum">
                            <div class="fl">购买数量</div>
                            <div class="numDiv">
                                <span class="change-num reduce">-</span>
                                <input class="num" type="tel" value="1" maxdata="100" data-price="1342.0"
                                       data-originprice="1342.0">
                                <span class="change-num increase">+</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--产品规格-->
    <!--产品参数-->
    <div class="goods-spec">产品规格参数
        <span class="icon iconfont icon-xiangyou fr"></span>
    </div>
    <div class="info" style="display: block;">
        <ul class="infoMenu">
            <li class="active hidLi">规格参数</li>
        </ul>
        <div class="">
            <ul class="values">
                <li>
                    <span>品牌</span>
                    <span id="productBrand">${data.product.productBrand!""}</span>
                </li>

                <li>
                    <span>类型</span>
                    <span id="type">${data.type!""}</span>
                </li>
                <li>
                    <span>材质</span>
                    <span id="material">${data.material!""}</span>
                </li>
                <li>
                    <span>风格</span>
                    <span id="style">${data.style!""}</span>
                </li>
                <li>
                    <span>光源类型</span>
                    <span id="lightType">${data.lightType!""}</span>
                </li>
                <li>
                    <span>光源数量</span>
                    <span id="lightNumber">${data.product.lightNumber!""}</span>
                </li>
                <li>
                    <span>功率</span>
                    <span id="productPower">${data.product.productPower!""}</span>
                </li>
                <li>
                    <span>空间</span>
                    <span id="space">${data.space!""}</span>
                </li>
                <li>
                    <span>颜色</span>
                    <span id="productColor">${data.product.productColor!""}</span>
                </li>
                <li>
                    <span>型号</span>
                    <span id="productCode">${data.product.productCode!""}</span>
                </li>
                <li>
                    <span>产品尺寸</span>
                    <span id="productSize">
										<#if data.product.productLength??>
								    	 	长:${data.product.productLength?c+"*"}
                                        </#if>
								 		 <#if data.product.productWidth??>
								     		宽:${data.product.productWidth?c+"*"}
                                         </#if>
								  		<#if data.product.productHeight??>
								     		高:${data.product.productHeight?c+"*"}
                                        </#if>
								  		<#if data.product.productDiameter??>
								     		直径:${data.product.productDiameter?c+"*"}
                                        </#if>
                    </span>
                </li>
                <li>
                    <span>净重(kg)</span>
                <span id="productWeight">
									<#if data.product.productWeight??>
                                        ${data.product.productWeight?c}</span>
                                    </#if>
                </li>
                <li>
                    <span>包装尺寸</span>
                    <span id="packageSize">
										<#if data.product.packageLength??>
								           	  长:${data.product.packageLength?c+"*"}
                                        </#if>
								 		<#if data.product.packageWidth??>
								           	 宽:${data.product.packageWidth?c+"*"}
                                        </#if>
								  		<#if data.product.packageHeight??>
								           	 高:${data.product.packageHeight?c+"*"}
                                        </#if>
                    </span>
                </li>
                <li>
                    <span>毛重(kg)</span>
                    <span id="packageWeight">
										<#if data.product.packageWeight??>
                                            ${data.product.packageWeight?c}
                                        </#if>
                    </span>
                </li>
            </ul>
        </div>
    </div>
    <!--产品参数-->
    <!-- 产品推荐[ -->
			<#if data.similarProduct??>
			<div class="resemble-div">
                <div>相似推荐<span style="float: right;color: #888;" id="similarMore">查看更多</span></div>
                <div>
                    <div class="swiper-container resemble">
                        <div class="swiper-wrapper">
				        	<#list data.similarProduct as sProduct>
                                <div class="swiper-slide">
                                    <a href="/mobilemall/productdetails/${sProduct.productId?c}">
                                        <img src="${ProductThumbnailSrc+sProduct.cover1?replace(sProduct.cover1?substring(0,sProduct.cover1?last_index_of("/")+1),"")}"
                                             width=" 100%"/>
                                        <p>¥${sProduct.retailPrice}</p>
                                    </a>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
            </#if>
    <!-- 产品推荐] -->
    <!--图片详情-->
    <div id="scrollDiv">
        <ul class="infoMenu">
            <li class="active hidLi print-details">图片详情</li>
        </ul>
        <div class="imagesScroll scrollDiv " style="overflow: scroll;">
            <div class="images">
					  <#if data.product.descriptionPic1??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic1}"></#if>
					  <#if data.product.descriptionPic2??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic2}"></#if>
					  <#if data.product.descriptionPic3??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic3}"></#if>
					  <#if data.product.descriptionPic4??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic4}"></#if>
					  <#if data.product.descriptionPic5??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic5}"></#if>
					  <#if data.product.descriptionPic6??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic6}"></#if>
					  <#if data.product.descriptionPic7??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic7}"></#if>
					  <#if data.product.descriptionPic8??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic8}"></#if>
					  <#if data.product.descriptionPic9??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic9}"></#if>
					  <#if data.product.descriptionPic10??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic10}"></#if>
					  <#if data.product.descriptionPic11??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic11}"></#if>
					  <#if data.product.descriptionPic12??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic12}"></#if>
					  <#if data.product.descriptionPic13??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic13}"></#if>
					  <#if data.product.descriptionPic14??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic14}"></#if>
					  <#if data.product.descriptionPic15??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic15}"></#if>
					  <#if data.product.descriptionPic16??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic16}"></#if>
					  <#if data.product.descriptionPic17??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic17}"></#if>
					  <#if data.product.descriptionPic18??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic18}"></#if>
					  <#if data.product.descriptionPic19??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic19}"></#if>
					  <#if data.product.descriptionPic20??><img
                              style="background: url(../../asset/img/defaultImg.jpg) no-repeat;"
                              src="${data.product.descriptionPic20}"></#if>
            </div>
        </div>
    </div>
    <!--图片详情-->
    <!--底部-->
    <div class="addCart text-center" id="states_zhengchang">
        <div class="cartDiv contactIcon gpsA">
            <i class="icon iconfont icon-dizhi2"></i>
            <p>导航</p>
        </div>
        <div class="cartDiv contactIcon" id="phoneKe">
            <i class="icon iconfont icon-weixin"></i>
            <p>客服</p>
        </div>
        <div id="toCartDiv" class="cartDiv buyBtn toCart">
            <a id="toCart" class="shopping-cart">加入购物车</a>
        </div>
        <div id="toBuyDiv" class="cartDiv buyBtn toBuy">
            <a id="toBuy" href="">立即购买</a>
        </div>
    </div>
    <div style="display:none;" class="addCart text-center" id="states_xiajia">
        <div class="cartDiv contactIcon gpsA">
            <i class="icon iconfont icon-dizhi2"></i>
            <p>导航</p>
        </div>
        <div class="cartDiv contactIcon" id="phoneKe">
            <i class="icon iconfont icon-weixin"></i>
            <p>客服</p>
        </div>
        <div class="cartDiv buyBtn" style="background: #ccc;color: #fff;width:60.2%">
            <span>该产品已下架</span>
        </div>
    </div>
    <!--底部-->
</div>
<!-- 等待加载 -->
<div class="moveCart"></div>
<!-- 弹出层 -->
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
<script type="text/javascript" src="../../asset/js/productDetails.js"></script>
</html>
