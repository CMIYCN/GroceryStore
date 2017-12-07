<%-- 
    Document   : admin_welcome
    Created on : Nov 30, 2017, 4:32:20 PM
    Author     : spc26
    Admin Welcome Page
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Welcome Page</title>
    </head>
    <body>
        <%
            if(session.getAttribute("username")==null){
                response.sendRedirect("adminlogin.jsp");
            }
            %>
            
        <h1>Welcome, ${username}</h1>
        
        <br>
        <p>
            <a href="MainInventory">Inventory</a>
            <br>
            <a href="SalesHistoryController">Sales Report</a>
            <br>
        </p>
        <br>
        
        <form action="AdminLogoutController">
            <input type="submit" value="Logout">
        </form>
    </body>
</html>
