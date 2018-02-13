<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0"/>
    <meta name="format-detection" content="telephone=no,email=no,date=no,address=no">
    <title>分类</title>
    <link rel="stylesheet" href="common/style.css"/>
    <style>
        .classification .fd-J_ping {
            text-align: center;
            padding: .2rem 0;
            border: 1px solid transparent;
            color: #333;
        }

        .classification .fd-J_ping.active {
            padding: .2rem 0;
            border: 1px solid #f00;
            color: #f00;
        }

        .classification .fd-card-list .fd-card-list-header {
            position: relative;
            width: 100%;
            height: 50px;
            background-color: #fff;
        }

        .classification .fd-card-list.fd-fixed .fd-card-list-header {
            background-color: #FFF;
            height: 50px;
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            z-index: 99;
        }

        .classification .fd-card-list .fd-card-list-header .fd-list-item-inner {
            background: #f5f5f5;
            border-left: 10px solid #ec2500;
        }

        .classification .fd-card-list:nth-child(1) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid #ff7b03;
        }

        .classification .fd-card-list:nth-child(2) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgba(190, 141, 202, 0.9);
        }

        .classification .fd-card-list:nth-child(3) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid #80b201;
        }

        .classification .fd-card-list:nth-child(4) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid #ffb503;
        }

        .classification .fd-card-list:nth-child(5) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid #ff2600;
        }

        .classification .fd-card-list:nth-child(6) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(116, 160, 217);
        }

        .classification .fd-card-list:nth-child(7) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(116, 217, 209);
        }

        .classification .fd-card-list:nth-child(8) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(116, 160, 217);
        }

        .classification .fd-card-list:nth-child(9) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(228, 211, 73);
        }

        .classification .fd-card-list:nth-child(10) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(116, 160, 217);
        }

        .classification .fd-card-list:nth-child(10) .fd-card-list-header .fd-list-item-inner {
            border-left: 10px solid rgb(116, 160, 217);
        }

        .classification .fd-card-list .fd-card-list-header .fd-list-item-inner span {
            padding-left: .5rem;
        }

        .filterFooter {
            position: fixed;
            bottom: 0;
            left: 0;
            width: 100%;
            background-color: #FAFAFA;
            text-align: center;
        }

        .filterFooter .cancelBtn {
            background-color: #FFF;
            color: #6A6A6A;
            border: 1px solid #6A6A6A;
            width: 40%;
            margin-right: 10%;
        }

        .filterFooter > button {
            padding: 8px 5px;
            border-radius: 3px;
            width: 60px;
            line-height: normal;
            font-size: .5rem;
        }

        .filterFooter .sureBtn {
            background-color: red;
            color: #fff;
            border: 1px solid red;
            font-family: "微软雅黑";
            width: 40%;
        }

        .classification .fd-card-list .fd-card-list-header .fd-list-item-inner span:nth-child(2) {
            margin-top: .1rem;
            color: #757575;
        }
    </style>
</head>
<body>
<div class="fd-content classification">
    <div class="fd-filterSearch">
        <div class="fd-searchbar" style="position: inherit;">
            <div class="fd-searchbar-input " style="margin-right: 0.5rem;">
                <i class="icon iconfont icon-sousuo1"></i>
                <form action="javascript:search();">
                    <input type="search" placeholder="请输入搜索内容" id="search-input">
                </form>
            </div>
            <div class="fd-searchbar-cancel fd-font-size-14" style="display: none;">搜索</div>
        </div>
    </div>
    <div class="fd-filterMain">
        <div class="fd-card-list fd-margin-b-0 fd-bg-white" id="style">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>风格</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-styles">
                    <div class="fd-row">
					            
					            <#list styles as style>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${style.propertyValueId}">${style.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>类型</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-types">
                    <div class="fd-row">
								
								<#list types as type>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${type.propertyValueId}">${type.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>空间</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-rooms">
                    <div class="fd-row">
					            
					            <#list rooms as room>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${room.propertyValueId}">${room.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>材质</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-materials">
                    <div class="fd-row">
					            
					            <#list materials as material>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${material.propertyValueId}">${material.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>形状</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-shapes">
                    <div class="fd-row">
					            
					            <#list forms as form>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${form.propertyValueId}">${form.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>层数</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-plies">
                    <div class="fd-row">
					            
					            <#list gradations as gradation>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${gradation.propertyValueId}">${gradation.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>直径</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-diameters">
                    <div class="fd-row">
					            
					            <#list diameters as diameter>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${diameter.propertyValue}">${diameter.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>长度</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-lengths">
                    <div class="fd-row">
					            
					            <#list lengths as length>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${length.propertyValue}">${length.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>高度</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-widths">
                    <div class="fd-row">
					            
					            <#list heigths as heigth>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${heigth.propertyValue}">${heigth.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>价格</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-prices">
                    <div class="fd-row">
					            
					            <#list prices as price>
                                    <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${price.propertyValue}">${price.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="fd-card-list fd-margin-b-0 fd-bg-white">
            <div class="fd-card-list-header fd-padded-l-5">
                <div class="fd-list-item-inner fd-list-item-arrow"><span>光源类型</span><span
                        class="fd-pull-right fd-font-size-14">查看更多</span></div>
            </div>
            <div class="fd-padded-l-10 fd-padded-r-10">
                <section class="fd-grid fd-lightTypes">
                    <div class="fd-row">
                        <!-- <div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                           <a class="fd-col-xs-11 fd-J_ping fd-font-size-12" data-id="22">现代简约</a>
                        </div> -->
					            
					            <#list ligths as ligth>
					            	<div class="fd-col-xs-3 fd-padded-b-5 fd-padded-t-5">
                                        <a class="fd-col-xs-11 fd-J_ping fd-font-size-12"
                                           data-id="${ligth.propertyValueId}">${ligth.propertyValue}</a>
                                    </div>
                                </#list>

                    </div>
                </section>
            </div>
        </div>
        <div class="filterFooter fd-padded-t-10 fd-padded-b-10">
            <button class="cancelBtn fd-font-size-16">取消</button>
            <button class="sureBtn fd-font-size-16">确定</button>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="common/jquery-1.11.0.js"></script>
<script>
    var dataId = new Array();
    $(".classification").css("margin-bottom", $(".filterFooter").outerHeight());
    /*选择分类*/
    $(".fd-J_ping").click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active");
        } else {
            $(this).addClass("active");
        }
    });
    /*输入框获取、失去焦点*/
    $("#search-input").focus(function () {
        $(".fd-searchbar-cancel").css("display", "block");
    });
    /*搜索*/
    $(".fd-searchbar-cancel").click(function () {
        window.location.href = "/mobilemall/productlist?offset=1&limit=10&like=" + $("#search-input").val();
    });

    $(".cancelBtn").click(function () {
        window.history.back();
    });
    /*判断是否在顶部  */
</script>
<script type="text/javascript" src="/static/MobileMall/customer/js/classification.js"></script>
</html>
