<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 4/9/2019
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Jaybe home page</title>
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>

<h2>Hello on Jaybe home page!!!</h2>

<hr>

<%-- display user name and role --%>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role (s): <security:authentication property="principal.authorities"/>
</p>
<%-- Add a link to point to /leaders ... this is only for managers --%>
<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps)
    </p>
    <br>
    <hr>
</security:authorize>

<security:authorize access="hasRole('ADMIN')">
    <%-- Add a link to point to /system ... this is only for admins --%>
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Meeting</a>
        (Only for Admin peeps)
    </p>
    <hr>
</security:authorize>

<form:form action="${pageContext.request.contextPath}/logout"
           method="post">
    <input type="submit" value="Logout"/>
</form:form>

</body>
</html>
