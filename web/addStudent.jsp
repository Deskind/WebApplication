<%-- 
    Document   : addStudent
    Created on : 03.01.2015, 18:38:25
    Author     : Katya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String s = (String)request.getAttribute("message");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <%= s%>
        </h1>
    </body>
</html>
