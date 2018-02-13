<!-- 公众号数据界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>公众号数据</title>
</head>
<link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
<link href="https://cdn.bootcss.com/jquery-confirm/3.3.2/jquery-confirm.min.css" rel="stylesheet">
<link href="/static/admin/css/dataAnalysis/publicNumberData.css" rel="stylesheet"/>
<link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css"
      rel="stylesheet">
<body>
<div class="container-fluid" id="formName">
    <div class="row">
        <div class="col-md-2">
            <div class="panel panel-primary" style="margin-top: 1rem;">
                <div class="panel-heading">公众号数据</div>
                <div class="btn-group-vertical" style="width:100%;" role="group" aria-label="...">
                    <button data-maxSpan="7" data-key="getusersummary" type="button" class="btn btn-default data-btn">
                        用户增减数据
                    </button>
                    <button data-maxSpan="7" data-key="getusercumulate" type="button" class="btn btn-default data-btn">
                        累计用户数据
                    </button>
                    <button data-maxSpan="1" data-key="getarticlesummary" type="button"
                            class="btn btn-default data-btn">图文群发每日数据
                    </button>
                    <button data-maxSpan="1" data-key="getarticlesummary" type="button"
                            class="btn btn-default data-btn">图文群发总数据
                    </button>
                    <button data-maxSpan="3" data-key="getarticletotal" type="button" class="btn btn-default data-btn">
                        图文统计数据
                    </button>
                    <button data-maxSpan="1" data-key="getuserread" type="button" class="btn btn-default data-btn">
                        图文统计分时数据
                    </button>
                    <button data-maxSpan="7" data-key="getuserreadhour" type="button" class="btn btn-default data-btn">
                        图文分享转发数据
                    </button>
                    <button data-maxSpan="1" data-key="getusersharehour" type="button" class="btn btn-default data-btn">
                        图文分享转发分时数据
                    </button>
                    <button data-maxSpan="7" data-key="getupstreammsg" type="button" class="btn btn-default data-btn">
                        消息发送概况数据
                    </button>
                    <button data-maxSpan="1" data-key="getupstreammsghour" type="button"
                            class="btn btn-default data-btn">消息分送分时数据
                    </button>
                    <button data-maxSpan="30" data-key="getupstreammsgweek" type="button"
                            class="btn btn-default data-btn">消息发送周数据
                    </button>
                    <button data-maxSpan="30" data-key="getupstreammsgmonth" type="button"
                            class="btn btn-default data-btn">消息发送月数据
                    </button>
                    <button data-maxSpan="15" data-key="getupstreammsgdist" type="button"
                            class="btn btn-default data-btn">消息发送分布数据
                    </button>
                    <button data-maxSpan="30" data-key="getupstreammsgdistweek" type="button"
                            class="btn btn-default data-btn">消息发送分布周数据
                    </button>
                    <button data-maxSpan="30" data-key="getupstreammsgdistmonth" type="button"
                            class="btn btn-default data-btn">消息发送分布月数据
                    </button>
                    <button data-maxSpan="30" data-key="getinterfacesummary" type="button"
                            class="btn btn-default data-btn">接口分析数据
                    </button>
                    <button data-maxSpan="1" data-key="getinterfacesummaryhour" type="button"
                            class="btn btn-default data-btn">接口分析分时数据
                    </button>
                </div>
            </div>
        </div>
        <div class="col-md-10">
            <div class="panel panel-primary" style="margin-top: 1rem;">
                <div class="panel-heading">图表</div>
                <!-- 查询表单开始 -->
                <form class="form-inline" style="margin-top:1rem;margin-left:1rem;">
                    <div class="form-group">
                        <div class='input-group date datetimepicker' id='beginDate'>
                            <span class="input-group-addon" id="basic-addon1"
                                  style="background-color: #ffffff;">开始时间:</span>
                            <input name="beginDate" type='text' class="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class='input-group date datetimepicker' id='endDate'>
                            <span class="input-group-addon" style="background-color: #ffffff;">结束时间:</span>
                            <input name="endDate" type='text' class="form-control"/>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                    </div>
                    <button onclick="query()" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>查询
                    </button>
                </form>
                <!-- 查询表单结束 -->
                <div style="height:600px">
                    <div id="container" style="height: 100%"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/echarts/4.0.2/echarts.common.min.js"></script>
<script src="/static/admin/js/dataAnalysis/publicNumberData.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.20.1/moment-with-locales.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>