<%--
  Created by IntelliJ IDEA.
  User: gimhwigyeong
  Date: 2023/08/24
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>param/b.do 요청완료</h2>

메시지 : ${message} <p>
 메뉴 : ${menus}<br>


<fieldset>
    <legend> 메뉴 선택</legend>

    <c:forEach items="${menu}" var = "menu">
        <input type = "checkbox" name = "menu" value = "${menu}}">${menu}
    </c:forEach>
</fieldset>

info = ${info} <br>
hobbies = ${hobbys}

</body>
</html>
