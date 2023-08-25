<%--
  Created by IntelliJ IDEA.
  User: gimhwigyeong
  Date: 2023/08/25
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Error 발생</h1>
<h3>error message: ${errMsg}</h3>
<h3>error class: ${errClass}</h3>

<a href="${pageContext.request.contextPath}/ex05_exception.html">홈으로</a>

</body>
</html>
