<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 4/18/2019
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>Spring REST Demo</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">Get all students</a>
</body>
</html>
