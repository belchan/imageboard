<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.12.15
  Time: 22.39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/css/belchan.css"/>
    <meta charset="UTF-8">
    <title>${board.desc} | Belchan</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%--C3EEG-LGNTV-UPLX--%>
<div class="container">
    <h2>/${board.name}/ ${board.desc}</h2>


    <div class="list-group" id="list-posts">
        <c:forEach var="post" items="${posts}"><br>

            <div>
                <a class="list-group-item">
                    <h4 class="list-group-item-heading">${post.subject}</h4>


                    <p class="list-group-item-text"><img src="https://avatars.yandex.net/get-music-content/6178e572.a.1133973-1/600x600" align="left"
                                                         width="100" height="100"
                                                         alt="${post.fileOriginal}">${post.message}</p>
                </a>
            </div>
        </c:forEach>
    </div>
    <hr>
    <div class="list-group" id="list-boards">
        <c:forEach var="board" items="${boards}">
            <a href="${board.name}" class="list-group-item">
                <h4 class="list-group-item-heading">/${board.name}/</h4>

                <p class="list-group-item-text">${board.desc}</p>
            </a>
        </c:forEach>
    </div>
</div>

<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/belchan.js"></script>
</body>
</html>