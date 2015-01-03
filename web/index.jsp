<%-- 
    Document   : LogIn
    Created on : 30.12.2014, 6:22:55
    Author     : Desk1nd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example</title>
    </head>
    <body background="java.jpg">
        <form method="post" action="login.jsp">
            <center>
            <table>
                <thead>
                    <tr>
                        <th colspan="2">Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Yet Not Registered??? <a href="registrationForm.jsp">Register Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
