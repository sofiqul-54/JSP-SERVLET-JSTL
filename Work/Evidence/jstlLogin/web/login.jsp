<%-- 
    Document   : login
    Created on : Jan 3, 2019, 9:39:16 AM
    Author     : User
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Please Login</h1>
        <form action="loginAuthentiocate.jsp" method="post">
            <table>
                <tr>
                    <td>Username :</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password :</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>            
        </form>
        
        <font color="red">
        <c:if test="${not empty param.errMsg}">
            <c:out value="${param.errMsg}"/>
        </c:if>
        </font>
    </body>
</html>
