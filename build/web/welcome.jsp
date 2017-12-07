<%-- 
    Document   : welcome
    Created on : Nov 30, 2017, 4:25:01 PM
    Author     : spc26
    User welcome page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("username")==null){
                response.sendRedirect("login.jsp");
            }
            
        %>
        <h1> Welcome, ${username} </h1> 
        
        <br>
        <p>
        <a href="UserInventory"> Item List </a>
        <br>
        <a href="CartController"> Shopping Cart </a>
        </p>
        <br>
        
        <form action="UserLogoutController">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
