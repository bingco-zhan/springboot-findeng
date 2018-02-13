<!-- 平台商品列表界面 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>平台商品列表界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/public/layui/css/layui.css" rel="stylesheet">
    <link href="/static/admin/css/productManagement/platformProductList.css" rel="stylesheet"/>
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
                                            <input type="number" name="productId" placeholder="产品ID"
                                                   class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <input type="text" name="productName" placeholder="产品名" class="layui-input">
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="productStatus">
                                                <option value="">请选择产品状态</option>
                                                <option value="2">待审核</option>
                                                <option value="5">已上线</option>
                                                <option value="6">已下架</option>
                                                <option value="7">已删除</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-col-md3">
                                    <div class="layui-form-item">
                                        <div class="layui-inline">
                                            <select name="userId" lay-search>
                                                <option value="">请选择厂家</option>
									        <#list factoryList as factory>
									        	<option value="${factory[0]?c}">${factory[2]}</option>
									        </#list>
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
<script src="https://cdn.bootcss.com/jquery/2.2.2/jquery.min.js"></script>
<script src="/public/layui/layui.all.js"></script>
<script src="/static/admin/js/productManagement/platformProductList.js"></script>
</html>
<script type="text/html" id="tool">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="modify">修改</a>
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="delete">删除</a>
</script>