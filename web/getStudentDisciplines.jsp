<%-- 
    Document   : getStudentDisciplines
    Created on : 04.01.2015, 8:48:02
    Author     : Katya
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="myObjects.Discipline"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    LinkedList<Discipline> list =(LinkedList)request.getAttribute("disciplineList");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
        <%if(list == null){%>
        Student not found
        <%}else if (list.size() == 0){%>
        Student don't have any discipline
        <%}else{
            for(Discipline d : list){%>
            <%= d.toString()%><br>
        <%}
        }%>
        
        </h1>
    </body>
</html>
