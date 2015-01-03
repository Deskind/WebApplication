<%-- 
    Document   : delStudent
    Created on : 01.01.2015, 20:38:51
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
            String s = new JDBCStudentDAO().deleteStudent(MySessionListener.connection, request.getParameter("FirstName"), request.getParameter("LastName"));
            %>
            <%= s%>
        </h1>
    </body>
</html>
