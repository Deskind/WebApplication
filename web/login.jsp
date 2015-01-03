<%-- 
    Document   : login
    Created on : 30.12.2014, 6:38:22
    Author     : Desk1nd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%
    String username = request.getParameter("uname");    
    String password = request.getParameter("pass");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application_users",
            "root", "140488");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from user where Name='" + username + "' and Password='" + password + "'");
    if (rs.next()) {
        session.setAttribute("username", username);
        //out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        con.close();
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>
