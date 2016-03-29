<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="src/main/webapp/css/belchan.css"/>
    <meta charset="UTF-8">
    <title>Belchan</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<%--C3EEG-LGNTV-UPLX--%>
<div class="container">
    <h2>Список досок</h2>

    <div class="list-group" id="list-boards">
        <c:forEach var="board" items="${boards}">
            <a href="${board.name}" class="list-group-item">
                <h4 class="list-group-item-heading">/${board.name}/</h4>

                <p class="list-group-item-text">${board.desc}</p>
            </a>
        </c:forEach>
    </div>
</div>

<!-- IPv6-test.com button BEGIN -->
<a href='http://ipv6-test.com/validate.php?url=referer'><img src='http://ipv6-test.com/button-ipv6-big.png'
                                                             alt='ipv6 ready' title='ipv6 ready' border='0'/></a>
<!-- IPv6-test.com button END -->

<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/belchan.js"></script>
</body>
</html>