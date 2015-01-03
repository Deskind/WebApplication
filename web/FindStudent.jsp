<%-- 
    Document   : FindStudent
    Created on : 02.01.2015, 13:24:23
    Author     : Katya
--%>

<%@page import="appServlets.MySessionListener"%>
<%@page import="myObjects.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.JDBCStudentDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h1>
           <%Student s = new JDBCStudentDAO().findStudent(MySessionListener.connection, request.getParameter("FirstName"), request.getParameter("LastName"));%>
           <%if(s!=null){%>
           <%= s.toString()%>
           <%}else{%>
           Student not found
           <%}%>
           
        </h1>
    </body>
</html>
