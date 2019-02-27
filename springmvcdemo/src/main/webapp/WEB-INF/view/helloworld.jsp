<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 2/23/2019
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Greetings form</title>
</head>
<body>

    <h2>Hello World of Spring!</h2>
    <br><br>

    Student Name: ${param.studentName}
    <hr>
    Message: ${message}

    <hr><br>
    <button type="submit"><a href="/" >Main menu</a></button>
</body>
</html>
