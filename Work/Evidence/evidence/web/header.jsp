<%-- 
    Document   : header
    Created on : Dec 23, 2018, 12:05:51 PM
    Author     : User
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <c:if test="${empty sessionScope['loginUser']}">
            <c:redirect url="login.jsp"/>            
        </c:if>
<a href="logout.jsp">Logout
    <c:out value="${sessionScope['loginUser']}"/>
</a>
    
