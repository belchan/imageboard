jQuery(document).ready(function ($) {
    $.get("boards", function (data) {
        var arr = data;
        for (var i = 0; i < arr.length; i++) {
            var s = "<a href=\"/";
            s += arr[i].name;
            s += "/\" class=\"boardlink\">/";
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
