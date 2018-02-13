<!-- 注册经销商模板 -->
<html>
<head>
    <title>注册经销商</title>
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
<div class="layui-fluid" style="margin-top: 10px;">
    <form class="layui-form layui-form-pane" action="/admin/api/certificationApplication" method="post"
          onsubmit="onsubmit();" id="registeredDealerForm">
        <!-- 表单验证状态,仅仅用于父页面判断是否提交表单 -->
        <input id="verifyState" type="hidden">
        <input id="userId" name="userId" required lay-verify="userId" type="hidden">
        <input id="roleId" name="role.id" required lay-verify="roleId" type="hidden">
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">公司全称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="companyName" required lay-verify="required" placeholder="请输入公司全称"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">公司简称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="shortCompanyName" required lay-verify="required" placeholder="请输入公司简称"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">营业执照号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="businessLicenceNumber" required lay-verify="required"
                               placeholder="请输入营业执照号" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">企业执法人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="legalPerson" required lay-verify="required" placeholder="请输入企业执法人"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4 layui-col-sm6">
                <div class="layui-form-item">
                    <label class="layui-form-label">注册手机号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="contact" required lay-verify="required|phone" placeholder="请输入注册手机号"
                               class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-col-md12 layui-col-sm12">
                <!-- 地址选择 -->
                <div class="layui-form-item">
                    <label class="layui-form-label">地址</label>
                    <div class="layui-input-inline">
                        <select id="province" name="provinceId" required lay-verify="required" lay-filter="province"
                                lay-search>
                            <option value="">请选择省</option>
					        <#list provinceList! as province>
					        	<option value="${province.addressId}">${province.addressName}</option>
                            </#list>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select id="city" name="cityId" required lay-verify="required" lay-filter="city" lay-search>
                            <option value="">请选择市</option>
                        </select>
                    </div>
                    <div class="layui-input-inline">
                        <select id="area" name="areaId" required lay-verify="required" lay-filter="area" lay-search>
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
                        <input type="text" name="companyAddressDetail" required lay-verify="required"
                               placeholder="请输入详细地址" class="layui-input">
                    </div>
                </div>
                <!-- 详细地址填写 -->
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                        <img class="prview">
                        <button type="button" class="layui-btn layui-upload-btn">
                            <i class="layui-icon">&#xe67c;</i>营业执照
                        </button>
                        <input lay-verify="businessLicencePic" name="businessLicencePic" type="hidden">
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                        <img class="prview">
                        <button type="button" class="layui-btn layui-upload-btn">
                            <i class="layui-icon">&#xe67c;</i>法人手持身份证
                        </button>
                        <input lay-verify="lpHandheldIdcardPic" name="lpHandheldIdcardPic" type="hidden">
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                        <img class="prview">
                        <button type="button" class="layui-btn layui-upload-btn">
                            <i class="layui-icon">&#xe67c;</i>法人身份证正面
                        </button>
                        <input lay-verify="lpIdcardFrontPic" name="lpIdcardFrontPic" type="hidden">
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                        <img class="prview">
                        <button type="button" class="layui-btn layui-upload-btn">
                            <i class="layui-icon">&#xe67c;</i>法人身份证反面
                        </button>
                        <input lay-verify="lpIdcardBackPic" name="lpIdcardBackPic" type="hidden">
                    </div>
                </div>
            </div>
            <div class="layui-col-md6 layui-col-sm6">
                <div class="prview-content">
                    <div class="layui-form-item prview-item">
                        <div class="remove-content"><i class="layui-icon img-remove">&#x1006;</i></div>
                        <img class="prview">
                        <button type="button" class="layui-btn layui-upload-btn">
                            <i class="layui-icon">&#xe67c;</i>店面实景图
                        </button>
                        <input lay-verify="jcv" name="jcv" type="hidden">
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-col-md12 layui-col-sm12" style="display:none;">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn registeredDealerForm-subtim" lay-submit lay-filter="formDealer">立即提交
                    </button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    //表单提交方法
    form.on('submit(formDealer)', function (data) {
        $("#verifyState").val(1);//设置验证状态为1
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    //表单验证
    form.verify({
        userId: function (value, item) {
            if (value == undefined || value == "") {
                return "申请用户参数为空,请联系系统管理员!";
            }
        },
        roleId: function (value, item) {
            if (value == undefined || value == "") {
                return "申请角色参数为空,请联系系统管理员!";
            }
        },
        businessLicencePic: function (value, item) {//营业执照
            if (value == undefined || value == "") {
                return "请上传营业执照图";
            }
        },
        lpHandheldIdcardPic: function (value, item) {//法人手持身份证
            if (value == undefined || value == "") {
                return "请上传法人手持身份证图";
            }
        },
        lpIdcardFrontPic: function (value, item) {//法人身份证正面
            if (value == undefined || value == "") {
                return "请上传法人身份证正面图";
            }
        },
        lpIdcardBackPic: function (value, item) {//法人身份证背面
            if (value == undefined || value == "") {
                return "请上传法人身份证背面图";
            }
        },
        jcv: function (value, item) {//实景图
            if (value == undefined || value == "") {
                return "请上传实景图";
            }
        },
        logoPic: function (value, item) {//厂家logo
            if (value == undefined || value == "") {
                return "请上传厂家logo图";
            }
        }
    });

    //营业执照
    var uploadBtn = layui.upload.render({
        elem: '.layui-upload-btn' //绑定元素
        , url: '/admin/api/certificationApplication/uploadImage' //上传接口
        , accept: "images"
        , exts: "jpg|png|jpeg"
        , size: 1024
        , multiple: true
        , done: function (res, index, upload) {//文件上传成功回调
            var btn = this.item[0];
            var img = btn.previousSibling.previousSibling;
            var imgSrc = res.arr[0].httpSrc;
            $(img).attr("src", imgSrc);//设置图片路径
            $(btn).css("display", "none");//设置上传按钮隐藏
            console.log($(btn).prev().prev());
            $(btn).prev().prev().css("display", "block");//删除按钮显示
            $(btn).next().next().val(imgSrc);//设置表单隐藏input值
        }
        , error: function () {
            //请求异常回调
        }
    });

    //图片删除按钮
    $(".img-remove").on("click", function () {
        var btn = $(this).parent();
        var img = btn.next();
        btn.css("display", "none");//隐藏删除图片按钮
        btn.next().next().css("display", "inline-block");//显示上传按钮
        btn.next().removeAttr("src");//删除图片src属性
        img.after('<img class="prview">');//添加新的图片标签
        img.remove();//删除就图片标签
        btn.next().next().next().next().val("");//删除图片表单路径
    });

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