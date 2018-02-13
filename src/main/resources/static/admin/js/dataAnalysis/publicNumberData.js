$(function () {
    $('.datetimepicker').datetimepicker({
        format: 'YYYY-MM-DD',
        locale: moment.locale('zh-cn')
    });

    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    }
    //示例代码
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    var data = genData(50);

    option = {
        title: {
            text: '同名数量统计',
            subtext: '纯属虚构',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            type: 'scroll',
            orient: 'vertical',
            right: 10,
            top: 20,
            bottom: 20,
            data: data.legendData,

            selected: data.selected
        },
        series: [
            {
                name: '姓名',
                type: 'pie',
                radius: '55%',
                center: ['40%', '50%'],
                data: data.seriesData,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };


    function genData(count) {
        var nameList = [
            '赵', '钱', '孙', '李', '周', '吴', '郑', '王', '冯', '陈', '褚', '卫', '蒋', '沈', '韩', '杨', '朱', '秦', '尤', '许', '何', '吕', '施', '张', '孔', '曹', '严', '华', '金', '魏', '陶', '姜', '戚', '谢', '邹', '喻', '柏', '水', '窦', '章', '云', '苏', '潘', '葛', '奚', '范', '彭', '郎', '鲁', '韦', '昌', '马', '苗', '凤', '花', '方', '俞', '任', '袁', '柳', '酆', '鲍', '史', '唐', '费', '廉', '岑', '薛', '雷', '贺', '倪', '汤', '滕', '殷', '罗', '毕', '郝', '邬', '安', '常', '乐', '于', '时', '傅', '皮', '卞', '齐', '康', '伍', '余', '元', '卜', '顾', '孟', '平', '黄', '和', '穆', '萧', '尹', '姚', '邵', '湛', '汪', '祁', '毛', '禹', '狄', '米', '贝', '明', '臧', '计', '伏', '成', '戴', '谈', '宋', '茅', '庞', '熊', '纪', '舒', '屈', '项', '祝', '董', '梁', '杜', '阮', '蓝', '闵', '席', '季', '麻', '强', '贾', '路', '娄', '危'
        ];
        var legendData = [];
        var seriesData = [];
        var selected = {};
        for (var i = 0; i < 50; i++) {
            name = Math.random() > 0.65
                ? makeWord(4, 1) + '·' + makeWord(3, 0)
                : makeWord(2, 1);
            legendData.push(name);
            seriesData.push({
                name: name,
                value: Math.round(Math.random() * 100000)
            });
            selected[name] = i < 6;
        }

        return {
            legendData: legendData,
            seriesData: seriesData,
            selected: selected
        };

        function makeWord(max, min) {
            var nameLen = Math.ceil(Math.random() * max + min);
            var name = [];
            for (var i = 0; i < nameLen; i++) {
                name.push(nameList[Math.round(Math.random() * nameList.length - 1)]);
            }
            return name.join('');
        }
    }
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
});

var dataKey;//接口键
var dataMaxSpan;//接口时间最大跨度
$(".data-btn").on("click", function (btn) {
    dataKey = $(this).attr("data-key");
    dataMaxSpan = $(this).attr("data-maxSpan");
    $(".panel-heading").html($(this).html() + '(跨度:' + dataMaxSpan + '天)');
    initCharts(dataKey, dataMaxSpan);//初始化图表
});

/**
 * 初始化图表
 */
function initCharts(dataKey, dataMaxSpan) {
    if (dataKey == "getusersummary" && dataKey == "getusercumulate") {
        genData(dataKey, dataMaxSpan);
    }
}

/**
 * 查询按钮响应
 */
function query() {
    var formData = $("form").serializeObject();
    if (dataKey == undefined) {
        showMsg("警告!", "请选择查询类型");
        return;
    }
    else if ($.trim(formData.beginDate) == "") {
        showMsg("警告!", "开始时间不能为空");
        return;
    }
    else if ($.trim(formData.endDate) == "") {
        showMsg("警告!", "结束时间不能为空");
        return;
    }
    else {

    }
    var range = ((new Date(formData.endDate).getTime() - new Date(formData.beginDate).getTime()));
    console.log(range);
    console.log(range / (1000 * 60 * 60));
    getData(dataKey, formData.beginDate, formData.endDate);
}

/**
 * 获取数据
 * @param 接口键
 * @param 开始时间
 * @param 结束时间
 */
function getData(key, beginDate, endDate) {
    //登录用户初始化
    $.ajax({
        url: "/wechat/statistics",
        dataType: "json",
        data: {
            "key": key,
            "beginDate": beginDate,
            "endDate": endDate
        },
        type: "get",
        async: true,
        success: function (data) {
            conosle.log(data);
        },
        error: function () {
            showMsg("提示", "获取数据失败!");
        }
    });
}

/**
 * 弹出提示弹窗
 */
function showMsg(title, msg) {
    $.confirm({
        title: title,
        content: msg,
        backgroundDismiss: true,
        buttons: {"ok": {isHidden: true}}
    });
}
