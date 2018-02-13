var curthemeName;

layui.form.on('select(theme)', function (data) {
    curthemeName = data.value; //得到被选中的值
    $('body', window.parent.document).attr("id", curthemeName);//设置主页面样式
});

//保存主题
function save() {
    $.cookie('themeName', curthemeName);
}
