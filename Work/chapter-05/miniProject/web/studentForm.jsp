<%-- 
    Document   : studentForm
    Created on : Dec 15, 2018, 10:57:13 AM
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
            <h:form> 
                <h1>Hello World!</h1>
                <p>Student Name: <h:inputText value="#{studentsController.st.name}"/></p>
                <h:commandButton value="Registration" action="submit"/>
            </h:form>
        </body>
    </f:view>
</html>
