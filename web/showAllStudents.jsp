<%-- 
    Document   : showAllStudents
    Created on : 30.12.2014, 7:34:08
    Author     : Desk1nd
--%>

<%@page import="appServlets.MySessionListener"%>
<%@page import="myObjects.Student"%>
<%@page import="dao.JDBCStudentDAO"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h1>
            <%LinkedList<Student> list = new JDBCStudentDAO().selectAllStudents(MySessionListener.connection);%>
            <% for(int i = 0; i < list.size(); i+=1) { %>
        <tr>      
            <td><%=list.get(i).toString()%></td><br>
        </tr>
    <% } %>
        </h1><br>
    </body>
</html>
