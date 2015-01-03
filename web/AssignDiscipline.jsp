<%-- 
    Document   : AssignDiscipline
    Created on : 02.01.2015, 14:03:11
    Author     : Katya
--%>

<%@page import="myObjects.Discipline"%>
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
            <%String s = new JDBCStudentDAO().assignDiscipline(MySessionListener.connection,
             request.getParameter("FirstName"), request.getParameter("LastName"), request.getParameter("Discipline"));%>
             <%= s%>
        </h1>
    </body>
</html>
