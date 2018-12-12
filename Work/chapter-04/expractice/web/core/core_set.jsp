<%-- 
    Document   : core_set
    Created on : Dec 12, 2018, 12:18:52 PM
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
        <h1>Hello World!</h1>
        <c:set var="browser" value="${header['User-Agent']}" scope="session"/>
        Your Browser User is : <c:out value="${browser}"/>
    </body>
</html>
