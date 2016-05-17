var board = getCookie("board");
var thread = getCookie("thread");
var page = getCookie("page");


jQuery(document).ready(function ($) {

    function fillPostBox(post, threadTemplateInstance) {
        var subj = "№ " + post.id + " " + post.name;
        var message = post.message;

        var childrenMain = threadTemplateInstance.children();
        var children = childrenMain.get(0);


        children.childNodes[1].innerHTML  = subj;
        children.getElementsByTagName("p")[0].innerHTML = message;

        return threadTemplateInstance;
    }

    function extracted(postEntity) {
        var postTemplate = $("#post").clone();
        return fillPostBox(postEntity, postTemplate);
    }

    function extractedMain(postEntity) {

        var title = document.getElementsByTagName("title")[0]
        title.innerHTML = postEntity.name;

        var threadTemplateInstance = $("#postMain").clone();
        return fillPostBox(postEntity, threadTemplateInstance);
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
        $("#mainDiv").append(extractedMain(arr[0]));
        for (var i = 1; i < arr.length; i++) {
            $("#mainDiv").append(extracted(arr[i]));
        }
    });

    request.fail(function( jqXHR, textStatus ) {
       // alert( "Request failed: " + textStatus );
    });
});
