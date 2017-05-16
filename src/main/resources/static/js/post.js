jQuery(document).ready(function ($) {
    $("#sendPost").click( function () {
        var request = $.ajax({
            url: "/post",
            method: "POST",
            data: {
                boardName: board,
                threadId: thread,
                page: page,
                name: $("#name").val(),
                email: $("#email").val(),
                subj: $("#subject").val(),
                text: $("#message").val(),
                file : "notSupport",
                embeded : "notSupport",
                embededType : "notSupport",
                password: $("#pwd").val(),
                tag : "notSupport",
                tripCode : "notSupport"
            },
            dataType: "json"
        });
        request.done(function( arr ) {
            window.location.href = "/"+board + "/res/" + arr + ".html"
        });
    });
});