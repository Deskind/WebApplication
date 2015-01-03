<%-- 
    Document   : GetAllStudentDisciplines
    Created on : 02.01.2015, 23:24:43
    Author     : Katya
--%>

<%@page import="dao.JDBCStudentDAO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="appServlets.MySessionListener"%>
<%@page import="myObjects.Discipline"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h1>
            
            <%LinkedList<Discipline> list = new JDBCStudentDAO().getAllStudentsDisciplines(MySessionListener.connection,
                    request.getParameter("FirstName"), request.getParameter("LastName"));
            if(list == null){%>
            Student not found
            <%}else if(list.size()==0){%>
            The student don't have any discipline
            <%}else{
            for(int i = 0; i < list.size(); i+=1) { %>
        <tr>      
            <td><%=list.get(i).toString()%></td><br>
        </tr>
    <% }
            } %>
        </h1>
    </body>
</html>
