<%-- 
    Document   : adminlogin
    Created on : Nov 30, 2017, 4:27:01 PM
    Author     : spc26
    Admin Login Page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <form action="AdminLoginController" method="get">
            <table border="0">
                
                <tbody>
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" size="45" /></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" size="45" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Login" />
        </form>
                    
    </body>
</html>
