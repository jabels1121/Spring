<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 2/19/2019
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <style>
        a, u{
            text-decoration: none;
            color: black;
        }
        a:hover
        {
            color: #b3bcb2;
            text-decoration:none;
            cursor:pointer;
        }
    </style>
</head>
<body>
<h2>Spring MVC - demo app!</h2>
<hr><br>
<button type="submit"><a href="hello/showForm" >Hello Form</a></button>
<br><br>
<button type="submit"><a href="student/showForm" >Student Form</a></button>
<br><br>
<button type="submit"><a href="customer/showForm" >Customer Form</a></button>
</body>
</html>
