<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 2/26/2019
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
    The customer confirmed: ${customer.firstName} ${customer.lastName}
    <br><br>
    Free passes: ${customer.freePasses}
    <br><br>
    Postal code: ${customer.postalCode}
    <br><br>
    Course code: ${customer.courseCode}

    <hr><br>
    <button type="submit"><a href="${pageContext.request.contextPath}" >Main menu</a></button>
</body>
</html>
