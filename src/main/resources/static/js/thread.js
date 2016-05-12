var board = getCookie("board");
var thread = getCookie("thread");
var page = getCookie("page");


jQuery(document).ready(function ($) {

    function extracted(thread) {
        var threadTemplateInstance = $("#thread").clone();
        var children = threadTemplateInstance.children();


        var subj = "№ " + thread.id + " " +  thread.name;

        var message = thread.message;

        //noinspection JSAnnotator
        children.get(1).innerHTML = subj;
        //noinspection JSAnnotator
        children.get(2).innerHTML = message;
        return threadTemplateInstance;
    }

    var request = $.ajax({
        url: "/posts",
        method: "GET",
        data: {
            boardName: board,
            threadId: thread,
            page: page
        },
        dataType: "json"
    });

    request.done(function( arr ) {
        var title = document.getElementsByTagName("title")[0]
        title.innerHTML = arr[0].name;
        for (var i = 0; i < arr.length; i++) {
            var s = extracted(arr[i]);
            $("#body p").append(s);
        }
    });

    request.fail(function( jqXHR, textStatus ) {
        alert( "Request failed: " + textStatus );
    });
});
