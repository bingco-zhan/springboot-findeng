<!-- 厂家修改商品 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>厂家修改商品</title>
</head>
<style>
.must {
    color: red;
}

.prview-content {
    text-align: center;
}

.prview {
    width: 200px;
    height: 200px;
}

.prview-item {
    width: 200px;
    height: 200px;
}

.layui-upload-btn {
    margin-top: -110%;
}

.layui-upload-choose {
    display: none;
}

.prview {
    border: 1px gray solid;
}

.img-remove {
    margin-left: 183px;
    font-size: 20px;
    color: red;
}

.remove-content {
    position: absolute;
    display: none;
}
</style>
<body>
 	 <!-- 隐藏上传详情图dom -->
 	 <div id="descriptionPicTemp" style="display:none;">
 	   <div class="layui-col-md3 layui-col-sm4 descriptionPic-Content">
 	  	 <div class="prview-content">
			<div class="layui-form-item prview-item">
                <div class="remove-content descriptionPic-Remove"><i class="layui-icon img-remove">&#x1006;</i></div>
                <img class="prview">
                <input lay-verify="descriptionPic" required name="descriptionPic" type="hidden">
            </div>
       	 </div>
       </div>
     </div>
    <!-- 隐藏上传详情图dom -->
    <div class="layui-fluid" style="margin-top: 10px;">
        <form class="layui-form layui-form-pane" action="" method="post" onsubmit="onsubmit();"
              id="factoryAddproductForm">
            <input id="verifyState" type="hidden">
            <!-- 产品抬头信息 -->
            <div class="layui-row">
                <div class="layui-col-md4 layui-col-sm6">
                    <div class="layui-form-item">
                        <label class="layui-form-label">商品型号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="productCode" required lay-verify="required" placeholder="请输入商品型号"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div class="layui-col-md4 layui-col-sm6">
                    <div class="layui-form-item">
                      <label class="layui-form-label">商品系列</label>
                      <div class="layui-input-inline">
                        <select name="productSeries.id">
                            <option value="">请选择产品系列</option>
                            <#list productSeriesList as productSeries>
                                <option value="${productSeries.id}">${productSeries.seriesName}</option>
                            </#list>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md4 layui-col-sm6">
                    <div class="layui-form-item">
                        <label class="layui-form-label">货型</label>
                        <div class="layui-input-block">
                            <input type="radio" name="productKind" value="1" title="现货" checked>
                            <input type="radio" name="productKind" value="0" title="订货">
                        </div>
                    </div>
                </div>
            </div>
            <!-- 产品抬头信息 -->

            <!-- 产品详情图 -->
            <div class="layui-row">
                <div class="layui-col-md1 layui-col-sm1">
                    <span class="layui-badge layui-bg-blue">详情图</span>
                    <span class="layui-badge">最多20张</span>
                </div>
                <div class="layui-col-md11 layui-col-sm11">
                    <div class="layui-col-md3 layui-col-sm4 descriptionPic-Upload-Content">
                        <div class="prview-content">
                            <div class="layui-form-item prview-item">
                                <img class="prview">
                                <button type="button" class="layui-btn layui-upload-btn">
                                    <i class="layui-icon">&#xe67c;</i>详情图
                                </button>
                                <input lay-verify="descriptionPic" required type="hidden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 产品详情图 -->

            <!-- 产品轮播图 -->
            <div class="layui-row">
                <div class="layui-col-md1 layui-col-sm1">
                    <span class="layui-badge layui-bg-blue">轮播图</span>
                </div>
                <div class="layui-col-md11 layui-col-sm11">
                    <div class="layui-col-md3 layui-col-sm4">
                        <div class="prview-content">
                            <div class="layui-form-item prview-item">
                                <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                                <img class="prview">
                                <button type="button" class="layui-btn layui-upload-btn">
                                    <i class="layui-icon">&#xe67c;</i>白底亮灯
                                </button>
                                <input lay-verify="cover" name="cover" type="hidden">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-sm4">
                        <div class="prview-content">
                            <div class="layui-form-item prview-item">
                                <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                                <img class="prview">
                                <button type="button" class="layui-btn layui-upload-btn">
                                    <i class="layui-icon">&#xe67c;</i>白底不亮灯
                                </button>
                                <input lay-verify="cover" name="cover" type="hidden">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md3 layui-col-sm4">
                        <div class="prview-content">
                            <div class="layui-form-item prview-item">
                                <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                                <img class="prview">
                                <button type="button" class="layui-btn layui-upload-btn">
                                    <i class="layui-icon">&#xe67c;</i>实景图
                                </button>
                                <input lay-verify="cover" name="cover" type="hidden">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 产品轮播图 -->

            <!-- 产品配灯图 -->
            <div class="layui-row">
                <div class="layui-col-md1 layui-col-sm1">
                    <span class="layui-badge layui-bg-blue">配灯图</span>
                </div>
                <div class="layui-col-md3 layui-col-sm4">
                    <div class="prview-content">
                        <div class="layui-form-item prview-item">
                            <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                            <img class="prview">
                            <button type="button" class="layui-btn layui-upload-btn">
                                <i class="layui-icon">&#xe67c;</i>配灯图
                            </button>
                            <input lay-verify="productPngPic" name="productPngPic" type="hidden">
                        </div>
                    </div>
                </div>
                <div class="layui-col-md1 layui-col-sm1">
                    <span class="layui-badge layui-bg-blue">每日推广</span>
                </div>
                <div class="layui-col-md3 layui-col-sm4">
                    <div class="prview-content">
                        <div class="layui-form-item prview-item">
                            <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                            <img class="prview">
                            <button type="button" class="layui-btn layui-upload-btn">
                                <i class="layui-icon">&#xe67c;</i>每日推广
                            </button>
                            <input name="productSpreadPic" type="hidden">
                        </div>
                    </div>
                </div>
                <div class="layui-col-md1 layui-col-sm1">
                    <span class="layui-badge layui-bg-blue">3C认证</span>
                </div>
                <div class="layui-col-md3 layui-col-sm4">
                    <div class="prview-content">
                        <div class="layui-form-item prview-item">
                            <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                            <img class="prview">
                            <button type="button" class="layui-btn layui-upload-btn">
                                <i class="layui-icon">&#xe67c;</i>3C认证
                            </button>
                            <input name="threeCCertification" type="hidden">
                        </div>
                    </div>
                </div>
            </div>
            <!-- 产品配灯图 -->

            <!-- 产品基本参数 -->
            <div class="layui-row">
                <!-- 左边 -->
                <div class="layui-col-md6 layui-col-sm6">
                    <div class="layui-col-md12 layui-col-sm12">
                        <span class="layui-badge layui-bg-blue">基本参数</span>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">类型</label>
                            <div class="layui-input-block">
                                <select name="productType" lay-verify="productType">
                                    <option value="">请选择产品类型</option>
                                    <#list productTypeList! as productType>
                                        <option value="${productType.propertyValueId!""}">${productType.propertyValue!""}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">价格</label>
                            <div class="layui-input-block">
                                <input type="number" name="originUnitPrice" required lay-verify="originUnitPrice"
                                       placeholder="请输入价格" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">风格</label>
                            <div class="layui-input-block">
                                <select name="productStyle" lay-verify="productStyle">
                                    <option value="">请选择产品风格</option>
                                    <#list productStyleList! as productStyle>
                                        <option value="${productStyle.propertyValueId!""}">${productStyle.propertyValue!""}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">交货期</label>
                            <div class="layui-input-block">
                                <input type="text" name="deliveryTime" required lay-verify="deliveryTime"
                                       placeholder="请输入交货期" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">光源类型</label>
                            <div class="layui-input-block">
                                <select name="lightType" lay-verify="lightType">
                                    <option value="">请选择光源类型</option>
                                    <#list lightTypeList! as lightType>
                                        <option value="${lightType.propertyValueId!""}">${lightType.propertyValue!""}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">光源数量</label>
                            <div class="layui-input-block">
                                <input type="number" name="lightNumber" required lay-verify="lightNumber"
                                       placeholder="请输入光源数量" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md12 layui-col-sm12">
                        <div class="layui-form-item">
                            <label class="layui-form-label">光源配送</label>
                            <div class="layui-input-block">
                                <input class="hasLightSource-radio" type="radio" name="hasLightSource" value="1" title="有" checked>
                                <input class="hasLightSource-radio" type="radio" name="hasLightSource" value="0" title="无">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">库存量</label>
                            <div class="layui-input-block">
                                <input type="number" name="productStock" required lay-verify="productStock"
                                       placeholder="请输入库存量" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">功率(w)</label>
                            <div class="layui-input-block">
                                <input type="number" name="productPower" required lay-verify="productPower"
                                       placeholder="请输入功率(w)" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">保质期</label>
                            <div class="layui-input-block">
                                <input type="text" name="qualityGuaranteeTime" required
                                       lay-verify="qualityGuaranteeTime" placeholder="请输入保质期" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">颜色</label>
                            <div class="layui-input-block">
                                <input type="text" name="productColor" required lay-verify="productColor"
                                       placeholder="请输入颜色" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">光色</label>
                            <div class="layui-input-block">
                                <input type="text" name="lightColor" required lay-verify="lightColor"
                                       placeholder="请输入光色" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">层数</label>
                            <div class="layui-input-block">
                                <input type="number" name="productPlies" required lay-verify="productPlies"
                                       placeholder="请输入层数" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">净重(kg)</label>
                            <div class="layui-input-block">
                                <input type="number" name="productWeight" required lay-verify="productWeight"
                                       placeholder="请输入净重" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">形状</label>
                            <div class="layui-input-block">
                                <select name="productShape" lay-verify="productShape">
                                    <option value="">请选择形状</option>
                                    <#list productShapeList! as productShape>
                                        <option value="${productShape.propertyValueId!""}">${productShape.propertyValue!""}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- 尺寸 -->
                    <div class="layui-col-md12 layui-col-sm12">
                        <span class="layui-badge layui-bg-blue">产品尺寸</span>
                        <span class="layui-badge">(填写最少两项)</span>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">长(cm)</label>
                            <div class="layui-input-block productSize">
                                <input type="number" name="productLength" required lay-verify="productSize"
                                       placeholder="请输入长" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">宽(cm)</label>
                            <div class="layui-input-block productSize">
                                <input type="number" name="productWidth" required lay-verify="productSize"
                                       placeholder="请输入宽" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">高(cm)</label>
                            <div class="layui-input-block productSize">
                                <input type="number" name="productHeight" required lay-verify="productSize"
                                       placeholder="请输入高" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">直径(cm)</label>
                            <div class="layui-input-block productSize">
                                <input type="number" name="productDiameter" required lay-verify="productSize"
                                       placeholder="请输入直径" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">离墙距离(cm)</label>
                            <div class="layui-input-block productSize">
                                <input type="number" name="productFromthewall" required lay-verify="productSize"
                                       placeholder="请输入离墙距离" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md12 layui-col-sm12">
                        <span class="layui-badge layui-bg-blue">包装尺寸</span>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">长(cm)</label>
                            <div class="layui-input-block">
                                <input type="number" name="packageLength" required lay-verify="packageLength"
                                       placeholder="请输入包装长" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">宽(cm)</label>
                            <div class="layui-input-block">
                                <input type="number" name="packageWidth" required lay-verify="packageWidth"
                                       placeholder="请输入包装宽" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">高(cm)</label>
                            <div class="layui-input-block">
                                <input type="number" name="packageHeight" required lay-verify="packageHeight"
                                       placeholder="请输入包装高" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md6 layui-col-sm6">
                        <div class="layui-form-item">
                            <label class="layui-form-label">毛重(kg)</label>
                            <div class="layui-input-block">
                                <input type="number" name="packageWeight" required lay-verify="packageWeight"
                                       placeholder="请输入包装毛重" class="layui-input">
                            </div>
                        </div>
                    </div>
                </div>
                <!-- 左边 -->

                <!-- 右边 -->
                <div class="layui-col-md6 layui-col-sm6">
                    <div class="layui-col-md12 layui-col-sm12">
                        <span class="layui-badge layui-bg-blue">主体材质</span>
                    </div>
                    <#list materialList as material>
                        <input type="checkbox" name="productMaterial" value="${material.propertyValueId!""}"
                               title="${material.propertyValue!""}">
                    </#list>
                </div>

                <div class="layui-col-md6 layui-col-sm6">
                    <div class="layui-col-md12 layui-col-sm12">
                        <span class="layui-badge layui-bg-blue">空间</span>
                    </div>
                    <#list spaceList as space>
                        <input type="checkbox" name="productSpace" value="${space.propertyValueId!""}"
                               title="${space.propertyValue!""}">
                    </#list>
                </div>
                <!-- 右边 -->
            </div>
            <!-- 产品基本参数 -->
        </form>
    </div>
</body>
</html>
<script>
var form = layui.form;
form.render();
</script>