<%-- 
    Document   : login
    Created on : Nov 29, 2017, 4:21:38 PM
    Author     : spc26
    User Login Page
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="Controller.*"%>

<%
    String username = (request.getParameter("username") == null)
            ? ""
            : request.getParameter("username");
    %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="UserLoginController" method="post">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" size="45" required /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input  type="password" name="password" size="45" required /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Login" />
        </form>
                    
    </body>
</html>
