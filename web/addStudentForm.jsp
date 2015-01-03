<%-- 
    Document   : addStudent
    Created on : 30.12.2014, 9:21:59
    Author     : Desk1nd
--%>

<%@page import="appServlets.MySessionListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.setAttribute("connection", MySessionListener.connection);
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h2>Add student</h2>
        <form action="addStudent.jsp?">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="LastName">
            <input type="submit" value="add student">
            </form>
    </body>
</html>
