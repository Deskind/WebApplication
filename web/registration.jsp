<%-- 
    Document   : registration
    Created on : 03.01.2015, 10:46:25
    Author     : Katya
--%>

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.JDBCStudentDAO"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String uname = request.getParameter("uname");
    String password = request.getParameter("password");
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(JDBCStudentDAO.getURL(), JDBCStudentDAO.getNAME(), JDBCStudentDAO.getPASSWORD());
    Statement st = connection.createStatement();
    int i = st.executeUpdate("insert into user (Name, Password) values ('" +uname + "', '" + password + "')");
    if(i > 0){
        response.sendRedirect("greatingUser.jsp");
    }else{
        response.sendRedirect("registrationDataError.jsp");
    }
    
    st.close();
    connection.close();
%>
