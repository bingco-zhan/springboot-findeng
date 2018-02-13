<!-- 平台订单列表界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://cdn.bootcss.com/select2/4.0.6-rc.1/css/select2.min.css" rel="stylesheet">
    <title>Insert title here</title>
    <style>
        .btnGroup {
            margin-bottom: 15px;
        }

        .paging-box-inner .paging-search {
            display: inline-block;
            padding-left: 0;
            margin: 20px 0;
            border-radius: 0px;
            margin-left: -3px;
        }

        .paging-box-inner .paging-search div {
            display: inline;
        }

        .paging-box-inner .paging-search div span {
            position: relative;
            float: left;
            text-decoration: none;
            background-color: #fff;
            border: 1px solid #ddd;
            padding: 3px 13px;
            margin: 0px 5px;
            font-size: 12px;
            line-height: 1.5;
        }

        .paging-box-inner .paging-search .pagingNum {
            padding: 3px 0px;
        }

        .paging-box-inner .paging-search input {
            border: 0px;
            outline: none;
            background: transparent;
        }

        #pagingNum {
            width: 50px;
            text-align: center;
        }

        .pagination-sm > li > a, .pagination-sm > li > span {
            padding: 5px 13px;
            margin: 0px 5px;
        }

        .pagination > li > .pageIndex, .pagination > li > .pageIndex:hover {
            border-color: transparent;
            color: #000;
            background-color: #fff;
        }

        .selection .select2-selection {
            height: 34px;
            border: 1px solid #ccc;
            line-height: 34px;
        }

        .selection .select2-selection span {

            height: 34px !important;
            line-height: 34px !important;
        }
    </style>
</head>
<body>
<div class="container-fluid" style="margin-top: 10px">
    <!--搜索-->
    <div class="panel panel-default">
        <div class="panel-body">
            <form class="form-inline" id="searchForm">
                <div class="form-group">
                    <input type="text" name="" class="form-control orderNumber" placeholder="订单号">
                </div>
                <div class="form-group">
                    <input type="text" name="" class="form-control productName" placeholder="产品名字">
                </div>
                <div class="form-group">
                    <select name="" class="form-control factorySelect " placeholder="厂家名称">
                        <option></option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="text" name="" class="form-control userNickName" placeholder="买家名字">
                </div>
                <div class="form-group">
                    <input type="text" name="" class="form-control" placeholder="客服名字">
                </div>
                <div class="form-group">
                    <input type="text" name="" class="form-control" placeholder="物流名字">
                </div>
                <div class="form-group">
                    <input type="text" name="" class="form-control" placeholder="物流园名字">
                </div>

                <div class="form-group">
                    <a class="btn btn-default" id="btn_search">搜索</a>
                </div>
            </form>
        </div>
    </div>
    <!--状态-->
    <div class="btnGroup">
        <button type="button" class="btn btn-default btn-primary" data-status="11">订单</button>
        <button type="button" class="btn btn-default" data-status="1">待发货</button>
        <button type="button" class="btn btn-default" data-status="2">待收货</button>
        <button type="button" class="btn btn-default" data-status="3">已签收</button>
        <button type="button" class="btn btn-default" data-status="4">已完成</button>
        <button type="button" class="btn btn-default" data-status="5">已关闭</button>
        <button type="button" class="btn btn-default" data-status="0">待付款</button>
        <button type="button" class="btn btn-default" data-status="return">退款/退货</button>
    </div>
    <div>
        <table id="tb_orderList" class="table table-bordered table-hover">
            <thead></thead>
            <tbody></tbody>
        </table>
        <!--分页-->
        <div class="paging-box-inner text-center clearfix pagination-detail">
            <div class="paging-center"></div>
        </div>
        <!--分页-->
    </div>
</div>
</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/select2/4.0.6-rc.1/js/select2.min.js"></script>
<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script type="text/javascript"
        src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="../admin/js/orderManagement/platformOrderList.js"></script>

</html>