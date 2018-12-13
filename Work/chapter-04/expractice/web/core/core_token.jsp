<%-- 
    Document   : core_token
    Created on : Dec 13, 2018, 10:05:18 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Programmers!</h1>
        <c:set var="queryResult" value="Dan,Jeep,Male,26,Java Developer,London" scope="request"/>
        
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Sex</th>
                <th>Age</th>
                <th>occupation</th>
                <th>Location</th>
            </tr>
            <tr>
                <c:forTokens items="${queryResult}" delims="," var="token">
                    <td><c:out value="${token}"/></td>
                </c:forTokens>
            </tr>
        </table>
        
    </body>
</html>
