<%-- 
    Document   : logout
    Created on : 30.12.2014, 7:30:12
    Author     : Desk1nd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="appServlets.*" %>
<!DOCTYPE html>
<%
    if(MySessionListener.connection != null){
    MySessionListener.connection.close();
    }
    response.sendRedirect("index.jsp");
%>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>-->
