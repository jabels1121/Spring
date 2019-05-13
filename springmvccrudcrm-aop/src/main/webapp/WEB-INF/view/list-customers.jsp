<%--
  Created by IntelliJ IDEA.
  User: Jabels
  Date: 3/13/2019
  Time: 10:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>

    <%-- link to our style sheet --%>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/web-resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
    <div id="container">
        <div id="content">

            <%-- add new button: Add Customer --%>
            <input type="button" value="Add Customer"
                   class="add-button"
                   onclick="window.location.href='customerForm'; return false;"
            />

            <!--  add a search box -->
            <form:form action="search" method="post">
                Search customer: <input type="text" name="theSearchName" />

                <input type="submit" value="Search" class="add-button" />

                <input type="button" value="Refresh" class="add-button"
                       onclick="window.location.href='list'; return false;" />
            </form:form>

            <%-- add out html table here --%>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>

                <%-- looping over model attribute called customers that retrieved from DB using hibernate--%>
                <c:forEach var="customer" items="${customers}">

                    <%-- construct an "update" link with customer id --%>
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>

                    <%-- construct a "delete" link with customer id --%>
                    <c:url var="deleteLink" value="/customer/delete">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>

                    <tr>
                        <td>${customer.firstName}</td>
                        <td>${customer.lastName}</td>
                        <td>${customer.email}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if (!(confirm('Are you sure you want to delete a customer?'))) return false"
                            >Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
