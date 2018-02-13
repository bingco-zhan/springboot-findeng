function serializeJSON(id) {
    var tempArr = $("#" + id).serializeArray();
    var json = new Object();
    if (tempArr instanceof Array) {
        $.each(tempArr, function (i, n) {
            if (n.value != "") json[n.name] = n.value;
        });
    }
    return json;
}