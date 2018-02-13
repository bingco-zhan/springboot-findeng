<!-- 查看用户流水 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>查看用户流水</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/fundManagement/checkCapitalFlow.css" rel="stylesheet">
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-collapse">
            <div class="layui-colla-item">
                <h2 class="layui-colla-title">查询面板</h2>
                <div class="layui-colla-content">
                    <!-- 搜索栏 -->
                    <form class="layui-form layui-form-pane">
                        <!-- row -->
                        <div class="layui-row layui-md-space3 layui-col-space10">
                            <div class="layui-col-md10">
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="number" name="capitalFlowId" placeholder="流水号"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="number" name="wechatPayId" placeholder="微信单号"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="number" name="orderNumber" placeholder="订单号"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="number" name="money" placeholder="金额" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="user.userNickname" placeholder="用户昵称"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="capitalFlowType">
                                                <option value="">请选择流水类型</option>
                                                <option value="0">微信支付消费</option>
                                                <option value="1">厂家货款</option>
                                                <option value="2">业务员提成</option>
                                                <option value="3">提现到微信钱包</option>
                                                <option value="4">提现到银行卡</option>
                                                <option value="7">退货</option>
                                                <option value="8">退款</option>
                                                <option value="9">平台提成</option>
                                                <option value="10">平台物流费</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="layui-col-md2">
                                <button class="layui-btn" lay-submit lay-filter="search">立即提交</button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                            </div>
                        </div>
                        <!-- row -->
                    </form>
                    <!-- 搜索栏 -->
                </div>
            </div>
        </div>
        <div class="layui-row">
            <table class="layui-hide" id="table" lay-filter="table"></table>
        </div>
    </div>
</div>
</body>
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/fundManagement/checkCapitalFlow.js"></script>
</html>