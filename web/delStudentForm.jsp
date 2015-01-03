<%-- 
    Document   : delStudentForm
    Created on : 02.01.2015, 12:53:58
    Author     : Katya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <h2>Delete student</h2>
        <form action="delStudent.jsp?">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="LastName">
            <input type="submit" value="delete student">
            </form>
    </body>
</html>
