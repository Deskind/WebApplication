<%-- 
    Document   : showAllStudents
    Created on : 03.01.2015, 18:55:52
    Author     : Katya
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="myObjects.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    LinkedList<Student> list =(LinkedList)request.getAttribute("studentList");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <% for(int i = 0; i < list.size(); i+=1) { %>
        <tr>      
            <td><%=list.get(i).toString()%></td><br>
        </tr>
    <% } %>
        </h1>
    </body>
</html>
