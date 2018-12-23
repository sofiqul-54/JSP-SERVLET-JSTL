<%-- 
    Document   : logout
    Created on : Dec 23, 2018, 12:42:38 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
        session.removeAttribute("loginUser");
        %>
        <a href="index.jsp">index.jsp</a>
    </body>
</html>
