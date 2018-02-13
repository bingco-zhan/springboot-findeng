<!-- 用户地图界面 -->
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=yes"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户分布地图</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/static/admin/css/dataAnalysis/zcity.css" rel="stylesheet"/>
    <style type="text/css">
        html {
            height: 100%;
            width: 100%;
        }

        body {
            height: 100%;
            width: 100%;
            margin: 0px;
            padding: 0px;
        }

        .bingco-float {
            position: absolute;
            z-index: 99999;
            left: 5%;
        }

        #container {
            width: 100%;
            height: 100%;
        }

        .img-thumbnail {
            width: 98%;
            height: 98%;
            margin: 1%;
        }
    </style>
</head>

<body>

<table class="demoTable bingco-float">
    <tr>
        <td class="td-04">
            <div class="zcityGroup" city-range="{'level_start':1,'level_end':3}"></div>
        </td class="td-04">
        <td>
            <div class="input-group">
					<span class="input-group-addon"> <input id="0" value="0"
                                                            type="checkbox" name="lampSelectionLogin"/>
					</span> <label for="0" class="form-control" style="width: 70px">有导购</label>
            </div>
        </td>
    </tr>
</table>

<div class="img-thumbnail">
    <div id="container"></div>
    <canvas id="canvas"></canvas>
</div>
</body>
<script type="text/javascript"
        src="http://api.map.baidu.com/api?v=2.0&ak=zABA6b0Mz9pTYh3SaGPA26TR4B3Djgrw">
    //v2.0版本的引用方式：src="http://api.map.baidu.com/api?v=2.0&ak=您的密钥"
</script>
<script type="text/javascript" src="//www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/static/admin/js/dataAnalysis/mapv.js"></script>
<script type="text/javascript" src="/static/admin/js/dataAnalysis/map.js"></script>
<script type="text/javascript" src="/static/admin/js/dataAnalysis/zcity.js"></script>
</html>