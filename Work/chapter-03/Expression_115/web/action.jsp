<%-- 
    Document   : action
    Created on : Dec 10, 2018, 12:48:34 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="p" class="com.sofiqul54.Person" scope="request">
    <jsp:setProperty name="p" property="*"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Personal Information</h1>
    <td>${p.name}</td><br>
    <td>${p.age}</td><br>
    <td>${p.email}</td><br>
    <td>${p.pass}</td><br>
    <td>&nbsp;</td>
</body>
</html>
