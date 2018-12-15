<%-- 
    Document   : studentrs
    Created on : Dec 15, 2018, 11:02:41 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Student Form</title>
        </head>
        <body>
            <h1>Student Info</h1>
            <p>Name: <h:outputText value="#{studentsController.st.name}"/></p>
        </body>
    </f:view>
</html>
