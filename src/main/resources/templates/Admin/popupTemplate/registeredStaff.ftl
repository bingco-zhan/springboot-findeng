<!-- 注册业务员模板 -->
<html>
<head>
    <title>注册业务员</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
    .must {
        color: red;
    }

    .prview-content {
        text-align: center;
        margin-left: 30%;
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
        margin-left: -35%;
    }

    .layui-btn {
        margin-top: -110%;
    }
</style>
<body>
<div class="layui-fluid" style="margin-top: 10px;">
    <form class="layui-form layui-form-pane">
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">公司全称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="companyName" required="" lay-verify="required" placeholder="请输入公司全称"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">公司简称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="shortCompanyName" required="" lay-verify="required"
                               placeholder="请输入公司简称" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">营业执照号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="businessLicenceNumber" required="" lay-verify="required"
                               placeholder="请输入营业执照号" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">企业执法人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="legalPerson" required="" lay-verify="required" placeholder="请输入企业执法人"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">注册手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="contact" required="" lay-verify="required" placeholder="请输入注册手机号"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md12 layui-col-sm12">
                <!-- 地址选择 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-inline">
                        <select id="province" name="provinceId" lay-filter="province" lay-search>
                            <option value="">请选择省</option>
					        <#list provinceList! as province>
					        	<option value="${province.addressId}">${province.addressName}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select id="city" name="cityId" lay-filter="city" lay-search>
                            <option value="">请选择市</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select id="area" name="areaId" lay-filter="area" lay-search>
                            <option value="">请选择县/区</option>
                        </select>
                    </div>
                </div>
                <!-- 地址选择 -->
            </div>
            <div class="layui-col-md12 layui-col-sm12">
                <!-- 详细地址填写 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">详细地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="contact" required="" lay-verify="required" placeholder="请输入详细地址"
                               class="layui-input">
                    </div>
                </div>
                <!-- 详细地址填写 -->
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>营业执照
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>法人手持身份证
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>法人身份证正面
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>法人身份证反面
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>店面实景图
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <img class="prview">
                        <button type="button" class="layui-btn" id="test1">
                            <i class="layui-icon">&#xe67c;</i>厂家Logo
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    //监听省份选择
    layui.form.on('select(province)', function (data) {
        var city = document.getElementById("city");
        var area = document.getElementById("area");
        if (data.value == "") {
            city.options.length = 1;
            area.options.length = 1;
            form.render('select');
            return;
        } else {
            city.options.length = 1;
            area.options.length = 1;
        }

        var ajax = new XMLHttpRequest();
        ajax.open('get', '/admin/api/address/upId?upId=' + data.value);
        ajax.send();
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4 && ajax.status == 200) {
                var city = document.getElementById("city");
                var JSONArr = JSON.parse(ajax.responseText).arr;
                for (var i in JSONArr) {     //循环添加多个值
                    city.options.add(new Option(JSONArr[i].addressName, JSONArr[i].addressId));
                }
                form.render('select');
            }
        }
    });

    //监听城市选择
    layui.form.on('select(city)', function (data) {//市
        var area = document.getElementById("area");
        if (data.value == "") {
            area.options.length = 1;
            form.render('select');
            return;
        } else {
            area.options.length = 1;
        }
        var ajax = new XMLHttpRequest();
        ajax.open('get', '/admin/api/address/upId?upId=' + data.value);
        ajax.send();
        ajax.onreadystatechange = function () {
            if (ajax.readyState == 4 && ajax.status == 200) {
                var area = document.getElementById("area");
                var JSONArr = JSON.parse(ajax.responseText).arr;
                for (var i in JSONArr) {     //循环添加多个值
                    area.options.add(new Option(JSONArr[i].addressName, JSONArr[i].addressId));
                }
                form.render('select');
            }
        }
    });
</script>