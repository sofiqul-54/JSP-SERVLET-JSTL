<%-- 
    Document   : simpleBean
    Created on : Dec 10, 2018, 11:57:57 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EL and Simple JavaBeans</title>
        <style>
            body, td{font-family: verdana; font-size: 10pt;}
        </style>
    </head>
    
    <body>
        <h1>EL and Simple JavaBeans</h1>
        
        <table border="1">       
            <tr>
            <form action="action.jsp" method="post">
                <td>Name :<input type="text" name="name"></td>
                <td>Age :<input type="number" name="age"></td>
                <td>Email :<input type="email" name="email"></td>
                <td>Password :<input type="password" name="pass"></td>
                <td><input type="submit"></td>
            </form>
            </tr>
        </table>
    </body>
</html>
