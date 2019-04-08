<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 4/9/2019
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Jaybe home page</title>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<h2>Hello on Jaybe home page!!!</h2>

    <form:form action="${pageContext.request.contextPath}/logout"
               method="post">
        <input type="submit" value="Logout" />
    </form:form>

</body>
</html>
