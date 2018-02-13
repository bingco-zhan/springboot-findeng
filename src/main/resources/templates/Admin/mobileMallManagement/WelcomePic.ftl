<!DOCTYPE HTML>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改欢迎图</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.css" rel="stylesheet"/>
    <link href="/static/admin/css/mobileMallManagement/welcomePic.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/css/fileinput.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid pic_content" style="text-align:center">
		<#if welcomepic??>
            <img data-id="${welcomepic.welcomePicId}" src="${WelcomePicSrc+welcomepic.welcomePicUrl}" change="0"
                 onload="imgloading(this);" class="pic" id="img" style="width:300px;height:400px;margin-top: 30px;"/>
        <#else>
			<img change="0" onload="imgloading(this);" class="pic" id="img"
                 style="width:300px;height:400px;margin-top: 30px;"/>
        </#if>
</div>
<div class="container-fluid" style="text-align:center">
    <button onclick="savePic(this)" type="button" style="width:15%;margin-top: 20px;" class="btn btn-success btn-keep">
        保存
    </button>
    <button onclick="deletePic(this)" type="button" style="width:15%;margin-top: 20px;"
            class="btn btn-danger btn-delete">删除
    </button>
</div>
<input id="file" class="upload" name="file" accept="image/*" type="file" style="display:none;">

<!-- 弹出框 -->
<div id="modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
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
<script src="https://cdn.bootcss.com/node-waves/0.7.5/waves.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/fileinput.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-fileinput/4.4.6/js/locales/zh.js"></script>
<script type="text/javascript" src="/static/admin/js/mobileMallManagement/welcomePic.js"></script>
</html>