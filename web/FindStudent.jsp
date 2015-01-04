<%-- 
    Document   : findStudent
    Created on : 04.01.2015, 8:22:05
    Author     : Katya
--%>

<%@page import="myObjects.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Student st = (Student)request.getAttribute("student");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <%if(st==null){%>
        Student not found
        <%}else{%>
        <%= st.toString()%>
        <%}%>
        </h1>
    </body>
</html>
