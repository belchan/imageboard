jQuery(document).ready(function ($) {

    function extracted(thread) {
        var threadTemplateInstance = $("#thread").clone();
        var children = threadTemplateInstance.children();


        var subj = "<a href=\"/" + board + "/res/";
        subj += thread.id;
        subj += ".html\" class=\"boardlink\">";
        subj += "№ " + thread.id + " " +  thread.name;
        subj += "</a>";

        var message = thread.message;

        //noinspection JSAnnotator
        children.get(1).innerHTML = subj;
        //noinspection JSAnnotator
        children.get(2).innerHTML = message;
        return threadTemplateInstance;
    }

    var request = $.ajax({
        url: "threads",
        method: "GET",
        data: {
            boardName: board,
            thread: thread,
            page: page
        },
        dataType: "json"
    });

    request.done(function( arr ) {
        for (var i = 0; i < arr.length; i++) {
            var s = extracted(arr[i]);
            $("#body p").append(s)
            // var html = $("#body p").html();
            // html += s;
            // $("#body p").html(html)
        }
    });

    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
});
