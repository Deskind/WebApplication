<%-- 
    Document   : success
    Created on : 30.12.2014, 6:59:20
    Author     : Desk1nd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="appServlets.*" %>
<% HttpSession httpSession = null;
httpSession = request.getSession();
//new MySessionListener().sessionCreated(new HttpSessionEvent(request.getSession()));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="java.jpg">
        <form action="logout.jsp">
            <input type="submit" value="Logout">
           
            <br>
            <br>
        </form>
        <a href="showAllStudents.jsp">Get all students names</a><br>
        <a href ="addStudentForm.jsp">Add student</a><br>
        <a href ="delStudentForm.jsp">Delete student</a>
        <h2>If you want to find student enter first and last names</h2>
        <form action="FindStudent.jsp">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="LastName">
            <input type="submit" value="Find Student"> 
        </form>
        
        <h2>If you want to change first name of the student enter current first and last names and after enter new first name.</h2>
        <form action="ChangeFirstName.jsp">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="FirstName">
            <input type="text" name="NewName" value="NewName">
            <input type="submit" value="Change first name">
        </form>
        
        <h2>If you want to change last name of the student enter current first and last names and after enter new last name.</h2>
        <form action="ChangeLastName.jsp">
            <input type="text" name="FirstName" value="FirstName">
           - <input type="text" name="LastName" value="LastName">
            <input type="text" name="NewName" value="NewName">
            <input type="submit" value="Change second name">
        </form>
        
        <h2>If you want to assign discipline to student enter his first and last names and name of discipline</h2>
        <form action="AssignDiscipline.jsp">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="LastName">
            <input type="text" name="Discipline" value="Discipline">
            <input type="submit" value="Assign discipline">
        </form>
        
        <h2>If you want to get all student's disciplines enter first and last names.</h2>
        <form action="GetAllStudentDisciplines.jsp">
            <input type="text" name="FirstName" value="FirstName">
            <input type="text" name="LastName" value="LastName">
            <input type="submit" value="Get all disciplines">
        </form>
    </body>
</html>
