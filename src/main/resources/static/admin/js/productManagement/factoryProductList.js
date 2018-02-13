var form = layui.form;
var table = layui.table.render({
    elem: '#table'
    , url: '/admin/api/factoryProduct'
    , page: true
    , cellMinWidth: 80
    , height: 'full-55'
    , request: {
        pageName: 'offset' //页码的参数名称，默认：page
        , limitName: 'limit' //每页数据量的参数名，默认：limit
    }
    , response: {
        statusName: 'code' //数据状态的字段名称，默认：code
        , statusCode: "0" //成功的状态码，默认：0
        , msgName: 'msg' //状态信息的字段名称，默认：msg
        , countName: 'total' //数据总数的字段名称，默认：count
        , dataName: 'rows' //数据列表的字段名称，默认：data
    }
    , cols: [[
        {field: 'productId', title: '产品ID'}
        , {field: 'productName', width: "180", title: '产品名'}
        , {
            title: '产品图', templet: function (data) {
                if (data.cover == undefined) return '<img style="width:50px;height:50px"/>';
                return '<img style="width:50px;height:50px" src="' + data.cover.split(",")[0] + '" />';
            }
        }
        , {
            title: '库存', sort: true, templet: function (data) {
                if (data.productStock == undefined) data.productStock = 0;
                return data.productStock + "件";
            }
        }
        , {
            field: "originUnitPrice", title: '价格', sort: true, templet: function (data) {
                if (data.originUnitPrice == undefined) data.originUnitPrice = 0;
                return data.originUnitPrice + "元";
            }
        }
        , {
            title: '状态', templet: function (data) {
                switch (data.productStatus) {
                    case 2:
                        return "待审批";
                    case 5:
                        return "上架中";
                    case 6:
                        return "已下架";
                    case 7:
                        return "已删除";
                    default:
                        return "未知";
                }
            }
        }
        , {
            field: 'onlineTime', width: "110", sort: true, title: '上架时间', templet: function (data) {
                if (data.onlineTime == undefined) return "";
                return data.onlineTime.substring(0, 10);
            }
        }
        , {
            field: 'creatTime', width: "110", sort: true, title: '创建时间', templet: function (data) {
                if (data.creatTime == undefined) return "";
                return data.creatTime.substring(0, 10);
            }
        }
        , {
            title: '系列', width: "180", templet: function (data) {
                var domTxt = '<select data-id="' + data.productId + '"><option value="">请选择系列</option>';
                for (var i in productSeriesListJSON) {
                    if (data.productSeries != undefined && productSeriesListJSON[i].id == data.productSeries.id)
                        domTxt += '<option selected value="' + productSeriesListJSON[i].id + '">' + productSeriesListJSON[i].seriesName + '</option>';
                    else
                        domTxt += '<option value="' + productSeriesListJSON[i].id + '">' + productSeriesListJSON[i].seriesName + '</option>';
                }
                domTxt += '</select>';
                form.render('select');

                return domTxt;
            }
        }
        , {title: '操作', width: "140", toolbar: "#tool"}
    ]]
});

var searchData = {};//搜索数据
layui.form.on('submit(search)', function (data) {
    searchData = data.field;
    table.reload({
        where: mergeJson(searchData, sortData)
        , page: {curr: 1}
    });
    //收起折叠面板
    document.getElementsByClassName("layui-show")[0].classList.remove("layui-show");
    return false;
});

var sortData = {};//排序数据
layui.table.on('sort(table)', function (data) {
    sortData.field = data.field;
    sortData.sort = data.type;
    table.reload({
        where: mergeJson(searchData, sortData)
        , page: {curr: 1}
    });
});

//合并json字段
function mergeJson(json1, json2) {
    var result = {};
    for (var attr in json1) {
        if (json1[attr] != undefined && json1[attr] != "")
            result[attr] = json1[attr];
    }
    for (var attr in json2) {
        if (json2[attr] != undefined && json2[attr] != "")
            result[attr] = json2[attr];
    }
    return result;
};

	var searchData = {};//搜索数据
	layui.form.on('submit(search)', function(data){
		searchData = data.field;
		table.reload({
		  where:mergeJson(searchData,sortData)
		  ,page: {curr: 1}
		});
		//收起折叠面板
		document.getElementsByClassName("layui-show")[0].classList.remove("layui-show");
		return false;
	});
	
	var sortData = {};//排序数据
	layui.table.on('sort(table)', function(data){
		  sortData.field = data.field;
		  sortData.sort =data.type;
		  table.reload({
			  where:mergeJson(searchData,sortData)
			  ,page: {curr: 1}
		});
	});
	
	//合并json字段
	function mergeJson(json1, json2) {
		var result={};
		for(var attr in json1){
			if(json1[attr] != undefined && json1[attr] != "")
				result[attr]=json1[attr];
		}
		for(var attr in json2){
			if(json2[attr] != undefined && json2[attr] != "")
				result[attr]=json2[attr];
		}
		return result;
	};
	
	/**
	 * 监听工具栏
	 */
	layui.table.on('tool(table)', function(data){
		var productId = data.data.productId;
		var userId = data.data.userId;//注册用户ID
		var event = data.event;//事件名
		var url = "";
		switch(event){
			case "modify":
				$.ajax({
					url:'/admin/product/modifyFactoryProduct?productId='+productId,
					dataType:'text',
					type:'get',
					success:function(data) {
						var layerWin = layer.open({
						  	  title: "修改商品",
						  	  type: 1, 
						  	  btn: ['保存', '关闭'],
						  	  btn1: function(index, layero){},
							  btn2: function(index, layero){},
							  content: data
						});
						layer.full(layerWin);
					},
					error:function(err) {
						console.log(err);
					}
			  });
				break;
			case "delete":
			var layerWin = layer.open({
		  	  title: "删除商品",
		  	  type: 1, 
		  	  content:"确认删除商品?(不可恢复)",
		  	  btn: ['提交', '取消'],
		  	  btn1: function(index, layero){
		  		 $.ajax({
						url:'/admin/api/product/'+productId,
						dataType:'JSON',
						type:'delete',
						success:function(data) {
							layer.msg(data.msg);
							if(data.code == 1){
								table.reload({});
							}
							layer.closeAll('page');
						},
						error:function(err) {
							console.log(err);
						}
					 });
			  },
			  btn2: function(index, layero){},
			  });
			  break;
		}
	});
	
	/**
	 *监听系列select选择
	**/
	form.on('select()', function(data){
		  var productId = data.elem.getAttribute("data-id");
		  var seriesId = data.value;
		  var arr = new Array();
			arr.push(parseInt(productId));
		  if(productId != undefined){
			  $.ajax({
					url:'/admin/api/product/productSeries',
					data:{
						productIds:arr,
						seriesId:seriesId
					},
					dataType:'JSON',
					type:'put',
					success:function(data) {
						layer.msg(data.msg);
					},
					error:function(err) {
						console.log(err);
					}
			  });
		  }
	});
