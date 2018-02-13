var map = new BMap.Map("container");

var point = new BMap.Point(109.01, 32.41);

map.centerAndZoom(point, 6);

map.enableScrollWheelZoom(true);

map.setMapStyle({
    style: 'light'
});

$(document).ready(function () {

    zcityrun('.zcityGroup');

    loadAjax();

    $('input[name=lampSelectionLogin]').bind('click', function () {
        var r = $('input[name=lampSelectionLogin]:checked')[0];
        map.clearOverlays(); // 清空标注
        if (r) {
            flag2 = true, flag1 = false;
        } else {
            flag1 = true, flag2 = true;
        }
        loadData(ajaxData); // 加载缓存
    });

    toLocation = function (obj) {
        $.ajax({
            url: 'http://api.map.baidu.com/geocoder/v2/?output=json&callback=showLocation',
            data: {
                address: obj.value, ak: 'zABA6b0Mz9pTYh3SaGPA26TR4B3Djgrw'
            },
            type: 'GET',
            dataType: "jsonp",
            success: function (d) {
                console.log(d);
                var point = new BMap.Point(d.result.location.lng, d.result.location.lat);

                map.centerAndZoom(point, d.result.confidence);
            },
            error: function () {
                console.log('系统出错了...');
            }
        });
    }

});

var ajaxData;

function loadAjax() {

    $.ajax({
        url: '/admin/api/findCoordinateByRoles',
        data: {
            'roles': [4, 8]
        },
        dataType: 'json',
        type: 'GET',
        contentType: 'application/json;charset=utf-8',
        success: function (d) {
            ajaxData = d; // 缓存
            loadData(d);
        },
        error: function (i, e, o) {
            alert('系统出错了...');
        }
    });
}

var flag1 = true; // 是否加载无导购权限的标识
var flag2 = true; // 是否加载有导购权限的标识

function loadData(d) {
    var data = [];
    if (document.createElement('canvas').getContext) { // 判断当前浏览器是否支持绘制海量点
        var points = []; // 添加海量点数据
        $.each(d, function (i, n) {
            if (n[1] * 1 == 0 && flag1) {
                var img = new Image();
                img.src = '/admin/img/dataAnalysis/sign-red.png';
                data.push({
                    geometry: {
                        type: 'Point',
                        coordinates: [n[2], n[3]],
                        text: n[0]
                    },
                    icon: img
                });
            }
            if (n[1] * 1 == 1 && flag2) {
                var img = new Image();
                img.src = '/admin/img/dataAnalysis/sign-blue.png';
                data.push({
                    geometry: {
                        type: 'Point',
                        coordinates: [n[2], n[3]],
                        text: n[0]
                    },
                    icon: img
                });
            }
        });

        var dataSet = new mapv.DataSet(data);

        var options = {
            draw: 'icon',
            methods: {
                click: function (item) {
                    findUserDetail(item);
                }
            }
        }
        var mapvLayer = new mapv.baiduMapLayer(map, dataSet, options);
    } else {
        alert('请在chrome、safari、IE8+以上浏览器查看本示例');
    }
}

function findUserDetail(item) {
    if (item) {
        var id = item.geometry.text;
        $.ajax({
            url: '/admin/api/user/' + id,
            dataType: 'json',
            type: 'GET',
            success: function (data) {
                var message = "<p><strong>店铺名</strong>: " + data.user.shortCompanyName + "</p>"
                    + "<p><strong>联系人</strong>: " + data.user.legalPersonName + "</p>"
                    + "<p><strong>联系电话</strong>: " + data.user.phoneNumber + "</p>"
                    + "<p><strong>客服</strong>: " + data.upUser.legalPersonName + "</p>"
                    + "<p><strong>地址</strong>: " + data.user.companyAddressDetail + "</p>";
                var infoWindow = new BMap.InfoWindow(message, {width: 150, height: 100}); // 创建信息窗口对象
                var point = new BMap.Point(item.geometry.coordinates[0], item.geometry.coordinates[1]);
                map.openInfoWindow(infoWindow, point); // 打开信息窗口
            },
            error: function (i, o, n) {
                console.log('系统出现错误...');
            }
        });
    }
}
