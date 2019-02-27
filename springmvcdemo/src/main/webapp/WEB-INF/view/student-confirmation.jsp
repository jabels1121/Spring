<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 2/24/2019
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student confirmation</title>
</head>
<body>
<%--@elvariable id="student" type="com.jaybe.springdemo.mvc.controller.Student"--%>
The Student is confirmed: ${student.firstName} ${student.lastName} from ${student.country}
<br><br>
Favorite language: ${student.favoriteLanguage}
<br><br>
Operating systems:
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
    <li> ${temp} </li>
    </c:forEach>
</ul>

<hr><br>
<button type="submit"><a href="/" >Main menu</a></button>
</body>
</html>