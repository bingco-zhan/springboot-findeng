var $html = $("<form method='get' action='/mobilemall/productlist'>");

/*点击确认，提交选择的分类*/
$(".sureBtn").click(function () {
    $html.empty().append("<input name='offset' value='1'/><input name='limit' value='10'/>");
    init(".fd-styles", "styles").init(".fd-types", "types").init(".fd-rooms", "rooms")
        .init(".fd-materials", "materials").init(".fd-shapes", "shapes").init(".fd-plies", "plies")
        .init(".fd-diameters", "diameters").init(".fd-lengths", "lengths").init(".fd-widths", "widths")
        .init(".fd-prices", "prices").init(".fd-lightTypes", "lightTypes");
    $html.appendTo("body").submit();

});

function init(clazz, name) {
    var $clazz = $(clazz).find(".active");
    if ($clazz.length == 0) return this;
    $clazz.each(function (i, o) {
        $html.append("<input name='" + name + "' value='" + $(o).attr("data-id") + "'/>");
    });
    return this;
}