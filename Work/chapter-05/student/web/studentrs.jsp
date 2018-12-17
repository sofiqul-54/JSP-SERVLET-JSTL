<%-- 
    Document   : studentrs
    Created on : Dec 17, 2018, 12:01:26 PM
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
                <h:outputText value="#{studebtCon.suedent.name}"/>               
            </h:form>
        </body>
    </f:view>
</html>
