<%-- 
    Document   : addStudent
    Created on : 02.01.2015, 12:25:54
    Author     : Katya
--%>

<%@page import="appServlets.MySessionListener"%>
<%@page import="dao.JDBCStudentDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h1>
            <%
            String s = new JDBCStudentDAO().addStudent(MySessionListener.connection, request.getParameter("FirstName"), request.getParameter("LastName"));
            %>
            <%= s%>
        </h1>
    </body>
</html>
