<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="asset/css/conmom.css"/>
    <link rel="stylesheet" href="asset/css/shopCat.css"/>
</head>
<body>
<div class="balance">
    <div class="title"><i class="iconfont back icon-xiangzuo2"></i>确认订单</div>
    <div class="payOrder">
        <div class="payAddress clearfix">
            <i class="icon iconfont icon-dizhi"></i>
            <div>
                <div class="address-contacter"><span>收货人：梁雪梅 13750050530</span></div>
                <div class="address-addr"><span>收货地址：广东省中山市古镇镇银泉灯饰4楼1卡</span></div>
            </div>
            <i class="icon iconfont icon-xiangyou address-arrow"></i>
        </div>
        <div class="address-img">
            <span>选择新地址</span>
        </div>
    </div>
    <!--商品列表-->
    <div class="oneShop ">
        <div class="shopName active">
            <!--<span class="shopI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <a href="/findeng/product/shopProductList?shopId=30089">
                <i class="iconfont"></i>
            </a>
            <i class="iconfont show"></i>
        </div>
        <div class="commodity active" data-id="76415" data-product-id="6721">
            <!--<span class="oneI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/15056181400620.jpg">
            <div class="cartLeft">
                <p><a href="/findeng/product/productDetail?productId=6721">欧式奢华81725-8吊灯</a></p>
                <div class="numDiv">
                    <span class="change-num reduce">-</span>
                    <input class="num" type="tel" value="1" maxdata="100" data-price="1342.0" data-originprice="1342.0">
                    <span class="change-num increase">+</span>
                </div>
            </div>
            <div class="cartRight">
                <i class="iconfont delIcon"></i>
                <h4>￥1342.00</h4>
            </div>
        </div>

        <div class="commodity active" data-id="76416" data-product-id="6726">
            <!--<span class="oneI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/15056185964870.jpg">
            <div class="cartLeft">
                <p><a href="/findeng/product/productDetail?productId=6726">欧式奢华81725-6+15+10+6吊灯</a></p>
                <div class="numDiv">
                    <span class="change-num reduce">-</span>
                    <input class="num" type="tel" value="11" maxdata="100" data-price="9120.0"
                           data-originprice="9120.0">
                    <span class="change-num increase">+</span>
                </div>
            </div>
            <div class="cartRight">
                <i class="iconfont delIcon"></i>
                <h4>￥100320.00</h4>
            </div>
        </div>
    </div>
    <div class="oneShop">
        <div class="shopName ">
            <!--<span class="shopI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <a href="/findeng/product/shopProductList?shopId=30089">
                <i class="iconfont"></i>
            </a>
            <i class="iconfont show"></i>
        </div>
        <div class="commodity" data-id="76415" data-product-id="6721">
            <!--<span class="oneI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/15056181400620.jpg">
            <div class="cartLeft">
                <p><a href="/findeng/product/productDetail?productId=6721">欧式奢华81725-8吊灯</a></p>
                <div class="numDiv">
                    <span class="change-num reduce">-</span>
                    <input class="num" type="tel" value="1" maxdata="100" data-price="1342.0" data-originprice="1342.0">
                    <span class="change-num increase">+</span>
                </div>
            </div>
            <div class="cartRight">
                <i class="iconfont delIcon"></i>
                <h4>￥1342.00</h4>
            </div>
        </div>

        <div class="commodity" data-id="76416" data-product-id="6726">
            <!--<span class="oneI"><span class="radius "><i class="iconfont"></i></span></span>-->
            <img src="http://findeng.com:8080/findeng/picture/product/thumbnailImage/15056185964870.jpg">
            <div class="cartLeft">
                <p><a href="/findeng/product/productDetail?productId=6726">欧式奢华81725-6+15+10+6吊灯</a></p>
                <div class="numDiv">
                    <span class="change-num reduce">-</span>
                    <input class="num" type="tel" value="11" maxdata="100" data-price="9120.0"
                           data-originprice="9120.0">
                    <span class="change-num increase">+</span>
                </div>
            </div>
            <div class="cartRight">
                <i class="iconfont delIcon"></i>
                <h4>￥100320.00</h4>
            </div>
        </div>
    </div>
    <!--商品列表-->
    <!--备注-->
    <div class="RemmLogistics">
        <label for="logisticsInput">请选择发货物流公司</label>
        <select id="logisticsSelect">
            <option value="2277">vbcbcvb</option>
            <option value="0">其他</option>
        </select>
        <input type="text" name="suggestLogistics" id="logisticsInput" placeholder="请输入发货物流公司">
    </div>
    <div class="RemmLogistics">
        <label>备注:</label>
        <textarea rows="6" cols="8" placeholder="请输入备注..." class="orderRemark"></textarea>
    </div>
    <div class="delivery">
        <span class="check"><i class="iconfont"></i></span>
        <span>到古镇银泉取货</span>
    </div>
    <!--备注-->
    <div class="orderBottom">
        <div class="allMoney">
            <span><span>￥<span id="moneySpan">102322.00</span></span></span>
        </div>
        <button class="payOrder" id="payOrderBtn">提交</button>
    </div>
</div>
</body>
</html>
