<%-- 
    Document   : core_if
    Created on : Dec 12, 2018, 12:54:27 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sofiqul54.CalendarBean" %>
<jsp:useBean id="cal" class="com.sofiqul54.CalendarBean"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Java Programmers!!</h1>
        Time is Currently : <br><br>
        <c:out value="${cal.time}"/>,
        <c:set var="hour" value="${cal.hour}" scope="request"/>
        <b>
            <c:if test="${hour >= 0 && hour <=11}">
            Good Morning!!
            </c:if>
            <c:if test="${hour >=12 && hour <=17}">
                God Afternoon!!
            </c:if>
                <c:if test="${hour>=18 && hour <=23}">
                Good Evining!!
            </c:if>
        </b>
            
    </body>
</html>
