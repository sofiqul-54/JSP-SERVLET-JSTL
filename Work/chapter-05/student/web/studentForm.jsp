<%-- 
    Document   : studentForm
    Created on : Dec 17, 2018, 11:54:14 AM
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
            <title>JSP Page</title>
        </head>
        <body>
            <h1>Hello World!</h1>
            <h:form>
                Name : <h:inputText value="#{studebtCon.suedent.name}" size="35"/> <br><br>
                ID &ensp;: <h:inputText value="#{studebtCon.suedent.name}" size="35"/> <br><br>
                <h:commandButton action="submit" value="Submit"/>
            </h:form>
        </body>
    </f:view>
</html>
