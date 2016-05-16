jQuery(document).ready(function ($) {
    var countImagesMinOne = 3;
    var numImg = Math.round(Math.random()*(countImagesMinOne))+1;

    $("#bg").css({"background-image": "url(\"/css/images/bg" + numImg + ".jpg\")"});
    $.get("boards", function (data) {
        var arr = data;
        for (var i = 0; i < arr.length; i++) {
            var s = "<a href=\"/";
            s += arr[i].name;
            s += "\" class=\"boardlink\">/";
            s += arr[i].name;
            s += "/ ";
            s += arr[i].desc;
            s += "</a>";
            s += "&nbsp;&bull;&nbsp;";

            var html = $("#header b p").html();
            html += s;
            $("#header b p").html(html)
        }


    }, "json");
});
