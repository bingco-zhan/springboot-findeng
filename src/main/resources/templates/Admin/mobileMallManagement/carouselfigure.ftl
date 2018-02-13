<!-- 修改轮播图 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改轮播图</title>
    <link href="https://cdn.bootcss.com/Swiper/3.4.2/css/swiper.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/css/fileinput.min.css" rel="stylesheet">
    <link href="/static/admin/css/mobileMallManagement/carouselfigure.css" rel="stylesheet"/>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <h5 class="text-center text-success" style="margin-top:10px;">效果</h5>
                <!--轮播图-->
                <div style="margin-top:-10px;" class="swiper-container swiper-container1 carousel banner">
                    <div class="swiper-wrapper">
	      					<#list carouselList! as Carousel>
	      						<#if Carousel.carouselPic!="">
		    						<div id="Carousel_index" class="swiper-slide">
                                        <a href="#" class="thumbnail">
                                            <img style="width:500px;" src="${CarouselImageSrc+Carousel.carouselPic!""}">
                                        </a>
                                    </div>
                                </#if>
                            </#list>
                    </div>
                    <div class="swiper-pagination sp1"></div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>
        <div class="col-md-12">
            <div id="toolbar">
                <button id="btn_edit" type="button" class="btn-primary btn btn_add"
                        style="margin-bottom:10px;float:right;">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增
                </button>
            </div>
            <div class="bootstrap-table">
                <div class="fixed-table-container" style="padding-bottom: 0px;">
                    <div class="table-responsive">
                        <table class="table table-hover" id="table" data-search="true" data-show-toggle="true"
                               data-show-columns="true" data-mobile-responsive="true" style="margin-top: 0px;">
                            <thead style="display: table-header-group;">
                            <tr>
                                <th style="min-width:10px;" data-field="0">
                                    <div class="th-inner ">id</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th style="min-width:100px;" data-field="1">
                                    <div class="th-inner ">图片</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th style="min-width:150px;" data-field="2">
                                    <div class="th-inner ">链接</div>
                                    <div class="fht-cell"></div>
                                </th>
                                <th style="min-width:100px;" data-field="3">
                                    <div class="th-inner ">操作</div>
                                    <div class="fht-cell"></div>
                                </th>
                            </tr>
                            </thead>
								<#list carouselList as carousel>
									<tr>
                                        <td>${carousel.carouselId!""}</td>
                                        <td style="width:200px;" class="tupian">
                                            <div style="position: relative;">
								            	<#if carousel.carouselPic!="">
									            	<img class="pic" change="0" onload="imgloading(this);"
                                                         src="${CarouselImageSrc+carousel.carouselPic!""}">
                                                <#else>
									            	<img class="pic" change="0">
                                                </#if>
                                                <a class="shanchu"></a>
                                                <input class="upload" name="file" accept="image/*" type="file"
                                                       style="display: none"/>
                                            </div>
                                        </td>
                                        <td>
                                            <p style="text-align:center; padding-top: 20px;">链接地址</p>
                                            <input change="0" style="vertical-align: middle;text-align: center; type="
                                                   text" class="form-control link" placeholder="链接地址"
                                            aria-describedby="basic-addon1" value="${carousel.carouselLink!""}">
                                        </td>
                                        <td style="width:200px;">
                                            <button type="button" style="width:48%;margin-top:8%;"
                                                    class="btn btn-success btn-keep">保存
                                            </button>
                                            <button type="button" style="width:48%;margin-top:8%"
                                                    class="btn btn-danger btn-delete">删除
                                            </button>
                                        </td>
                                    </tr>
                                </#list>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 弹出框 -->
    <div id="modal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">对话框</h4>
                </div>
                <div class="modal-body">
                    <h5 id="modal_text"></h5>
                    <div class="modal-footer delete" style="display:none">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="btn btn-danger" onclick="submitDelete()">提交</button>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/Swiper/3.4.2/js/swiper.jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/locales/zh.js"></script>
<script type="text/javascript" src="/static/admin/js/mobileMallManagement/carouselfigure.js"></script>
</html>