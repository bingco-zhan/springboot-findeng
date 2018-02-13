<!-- 供应商添加商品页面 -->
<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>供应商添加商品界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/admin/css/productManagement/factoryAddproduct.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/css/bootstrap-select.min.css" rel="stylesheet">
    <title>供应商添加商品</title>
</head>
<body>
<div class="container-fluid" id="formName">
    <div class="row">
        <div class="col-md-3">
            <div class="input-group" style="margin-top:7px;">
                <span class="input-group-addon"><i class="must">*</i>商品型号</span>
                <input id="productCode" type="text" class="form-control" placeholder="请输入商品型号"
                       aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="col-md-3 form-group">
            <div class="input-group" style="margin-top:7px;">
                <span class="input-group-addon"><i class="must">*</i>产品系列</span>
                <select id="series" class="selectpicker series" data-live-search="true" title="--请选择系列--">
                    <option selected="selected" value="-1">--请选择系列--</option>
			        <#list productSeries as ps>
					 	<option value="${ps.id?c}">${ps.seriesName}系列</option>
                    </#list>
                </select>
            </div>
        </div>
        <div class="col-md-3" style="margin-top:7px;">
            <div class="input-group">
                <span class="input-group-addon"><i class="must">*</i>货型</span>
                <div class="input-group">
                    <div class="input-group-addon">
				       <span style="padding-right: 25px;">
				       	 	<input class="goodsOfType" name="optionsRadios1" value="option3" type="radio"
                                   aria-label="...">现货
				       </span>
                        <span>
				        	<input class="goodsOfType" name="optionsRadios1" value="option4" type="radio"
                                   aria-label="...">订货
				       </span>
                    </div>
                    <div class="input-group-addon"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" id="detalpric">
        <div class="col-lg-1 col-md-1 col-sm-2 col-xs-12 ">
            <div class="title-content clearfix">
                <span class="title-tag"><i class="must">*</i>详情图</span>
                <span class="subtitle-tag col-sm-12">最多20张</span>
            </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-5 imgcontent">
            <a class="thumbnail">
                <button class="upload_button detail_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                <img>
            </a>
        </div>
    </div>
    <!-- 结束详情图 -->
    <div class="row" id="lunbopric">
        <div style="padding-right:0px;" class="col-lg-1 col-md-1 col-sm-2 col-xs-12 ">
            <div class="title-content clearfix">
                <span class="title-tag"><i class="must">*</i>轮播图</span>
                <span class="subtitle-tag col-sm-12">像素800*800</span>
            </div>
        </div>
        <div class="">
            <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
                <a class="thumbnail">
                    <p class="prompt_text">*白底亮灯</p>
                    <button class="upload_button carousel_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                    <img/>
                </a>
            </div>
            <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
                <a class="thumbnail">
                    <p class="prompt_text">*白底不亮灯</p>
                    <button class="upload_button carousel_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                    <img/>
                </a>
            </div>
            <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
                <a class="thumbnail">
                    <p class="prompt_text">*搭配主图，实景图</p>
                    <button class="upload_button carousel_map"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                    <img/>
                </a>
            </div>
        </div>
    </div>
    <!-- 结束轮播图 -->
    <div class="row" id="mustpric">
        <div style="padding-right:0px;" class="col-lg-1 col-md-1 col-sm-2 col-xs-12 ">
            <div class="title-content clearfix othe">
                <span class="title-tag"><i class="must">*</i>配灯图</span>
                <span class="subtitle-tag col-sm-12">像素800*800(png格式)</span>
            </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
            <a class="thumbnail">
                <button class="upload_button lightingChoice"><i class="glyphicon glyphicon-plus "></i>点击上传</button>
                <img/>
            </a>
        </div>
        <div style="padding-right:0px;" class="col-lg-1 col-md-1 col-sm-2 col-xs-12 ">
            <div class="title-content clearfix">
                <span class="title-tag">每日推广</span>
            </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
            <a class="thumbnail">
                <button class="upload_button dailyPromotion"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                <img/>
            </a>
        </div>
        <div style="padding-right:0px;" class="col-lg-1 col-md-1 col-sm-2 col-xs-12 ">
            <div class="title-content clearfix">
                <span class="title-tag">认证</span>
            </div>
        </div>
        <div class="col-md-3 col-sm-4 col-xs-6 imgcontent">
            <a class="thumbnail">
                <button class="upload_button authentication"><i class="glyphicon glyphicon-plus"></i>点击上传</button>
                <img/>
            </a>
        </div>
    </div>
    <!-- 结束配灯图 -->
    <!-- 输入框开始-->
    <div class="row ">
        <div class="col-md-6 typeList">
            <div class="col-md-12">
                <div class="title-content clearfix">
                    <span class="title-tag"><i class="must">*</i>基本参数</span>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>类型</span>
                    <div class="btn-group">
                        <button type="button" onclick="addItem(this)" value="37"
                                class="btn btn-default dropdown-toggle selectType" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            请选择类型 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu"></ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>价格</span>
                    <input type="number" class="Price form-control" placeholder="请输入价格" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>风格</span>
                    <div class="btn-group">
                        <button type="button" onclick="addItem(this)" value="39"
                                class="style btn btn-default dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            请选择风格 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu"></ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>交货期</span>
                    <input type="number" class="delivery form-control" placeholder="请输入交货期	"
                           aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>光源类型</span>
                    <div class="btn-group">
                        <button type="button" onclick="addItem(this)" value="55"
                                class="lightType btn btn-default dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            请选择光源类型 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu"></ul>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>光源数量</span>
                    <input type="number" class="lightNumber form-control" placeholder="请输入光源数量"
                           aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>光源配送</span>
                    <div class="input-group">
                        <div class="input-group-addon">
				       <span style="padding-right: 25px;">
				       	 	<input class="LightDistribution" name="optionsRadios" value="option1" type="radio"
                                   aria-label="...">是
				       </span>
                            <span>
				        	<input class="LightDistribution" name="optionsRadios" value="option2" type="radio"
                                   aria-label="...">否
				       </span>
                        </div>
                        <div class="input-group-addon"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>库存量</span>
                    <input type="number" class="stock form-control" placeholder="请输入库存量"
                           aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">功率(w)</span>
                    <input type="text" class="power form-control" placeholder="请输入功率" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>保质期</span>
                    <input type="text" class="shelfLife form-control" placeholder="请输入时间(例:12月)"
                           aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon"><i class="must">*</i>层</span>
                    <input type="number" class="layer form-control" placeholder="请输入层" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">颜色</span>
                    <input type="text" class="colour form-control" placeholder="请输入颜色" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">净重(kg)</span>
                    <input type="text" class="product-weight form-control" placeholder="请输入净重"
                           aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6">
                <div class="input-group">
                    <span class="input-group-addon">形状</span>
                    <div class="btn-group">
                        <button type="button" onclick="addItem(this)" value="54"
                                class="product-shape btn btn-default dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                            请选择形状 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu"></ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 materialCheckBox">
            <div class="col-md-12">
                <div class="title-content clearfix">
                    <span class="title-tag"><i class="must">*</i>主体材质</span>
                </div>
            </div>

        </div>
    </div>
    <!-- 输入框结束 -->
    <div class="row">
        <!-- 产品尺寸开始 -->
        <div class="col-md-6 typeList">
            <div class="col-md-12">
                <div class="title-content clearfix">
                    <span class="title-tag"><i class="must">*</i>产品尺寸</span>
                    <span class="subtitle-tag col-sm-12">(填写最少两项)</span>
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">长(cm)</span>
                    <input type="number" class="product-length form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">宽(cm)</span>
                    <input type="number" class="product-width form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">高(cm)</span>
                    <input type="number" class="product-height form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">直径(cm)</span>
                    <input type="number" class="product-diameter form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">离墙距离(cm)</span>
                    <input type="number" class="product-fromthewall form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <!-- 产品尺寸结束 -->
            <!-- 包装尺寸开始 -->
            <div class="col-md-12">
                <div class="title-content clearfix">
                    <span class="title-tag">包装尺寸</span>
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">长(cm)</span>
                    <input type="number" class="package-length form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">宽(cm)</span>
                    <input type="number" class="package-width form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">高(cm)</span>
                    <input type="number" class="package-height form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="col-md-6 ">
                <div class="input-group">
                    <span class="input-group-addon">毛重(kg)</span>
                    <input type="number" class="package-weight form-control" aria-describedby="basic-addon1">
                </div>
            </div>
            <!-- 包装尺寸结束 -->
        </div>
        <!-- 空间开始 -->
        <div class="col-md-6 spaceCheckBox">
            <div class="col-md-12">
                <div class="title-content clearfix">
                    <span class="title-tag"><i class="must">*</i>空间</span>
                </div>
            </div>

        </div>
        <!-- 空间结束 -->
        <!-- 底部提交按钮 -->
        <div class="container-fluid" style="height:0px;">
            <div class="col-md-9"></div>
            <button id="subtim_btn" type="button" class="btn-lg btn btn-success">
                立即提交
            </button>
            <button id="reset_btn" type="button" class="btn-lg btn btn-success" style="margin-left:20px;">
                重置
            </button>
        </div>
        <!-- 底部提交按钮 -->
    </div>
</div>
<input class="upload" id="file" accept="image/*" type="file" style="display: none"/>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/admin/js/productManagement/factoryAddproduct.js"></script>
<script src="https://cdn.bootcss.com/jquery-confirm/2.5.1/jquery-confirm.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/bootstrap-select.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-select/2.0.0-beta1/js/i18n/defaults-zh_CN.min.js"></script>
</html>