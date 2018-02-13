<!-- 用户权限管理界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户权限管理</title>
    <meta http-equiv="pragma"/>
    <meta http-equiv="Cache-Control" content="no-cache, must-revalidate"/>
    <meta http-equiv="expires" content="0"/>
    <link href="../admin/css/userManagement/userManagement.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap3-dialog/1.35.4/css/bootstrap-dialog.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div id="toolbar">
        <button id="btn_edit" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>

        <div class="columns columns-right pull-right" style="margin:0px;margin-left:5px;">

            <input id="search_id" type="text" style="display: inline-block;width: 100px;" class="form-control"
                   placeholder="id" aria-describedby="basic-addon1">

            <input id="search_upperuserid" type="text" style="display: inline-block;width: 100px;" class="form-control"
                   placeholder="上级id" aria-describedby="basic-addon1">

            <input id="search_nickname" type="text" style="display: inline-block;width: 150px;" class="form-control"
                   placeholder="昵称" aria-describedby="basic-addon1">

            <input id="search_companyname" type="text" style="display: inline-block;width: 150px;" class="form-control"
                   placeholder="公司名" aria-describedby="basic-addon1">

            <button id="btn_search" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>搜索
            </button>
        </div>
    </div>
    <table id="table"></table>
</div>

<div id="modal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p id="modal_text"></p>
                <div id="edit_content" class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">id</span>
                                <input id="userId" type="text" class="form-control" placeholder="id"
                                       aria-describedby="basic-addon1" disabled="disabled">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">上级id</span>
                                <input id="upperUserId" type="number" class="form-control" placeholder="上级id"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">电话</span>
                                <input id="phoneNumber" type="number" class="form-control" placeholder="电话"
                                       aria-describedby="basic-addon1">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">角色</span>
                                <select id="role" class="form-control">
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">openid</span>
                                <input id="openId" type="text" class="form-control" placeholder="id"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">登陆导购机</span>
                                <select id="lampSelectionLogin" class="form-control">
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">昵称</span>
                                <input id="userNickname" type="text" class="form-control" placeholder="昵称"
                                       aria-describedby="basic-addon1">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">真实姓名</span>
                                <input id="legalPersonName" type="text" class="form-control" placeholder="真实姓名"
                                       aria-describedby="basic-addon1">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">公司名</span>
                                <input id="companyName" type="text" class="form-control" placeholder="公司名"
                                       aria-describedby="basic-addon1">
                            </div>
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon1">公司地址</span>
                                <input id="companyAddressDetail" type="text" class="form-control" placeholder="公司地址"
                                       aria-describedby="basic-addon1">
                            </div>
                        </div>
                    </div>
                </div>
                <div id="delete_content" class="container-fluid">
                    <div class="row">
                        <p>确定删除用户<h4 style="color:red;">(注意:不可恢复!)</h4></p>
                    </div>
                </div>
                <div class="modal-footer delete" style="display:none">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-danger" onclick="submitDelete()">提交</button>
                </div>
                <div class="modal-footer edit" style="display:none">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="submitEdit()">提交</button>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="../admin/js/userManagement/userManagement.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
</html>