<%-- 
    Document   : inventory
    Created on : Dec 2, 2017, 4:06:06 PM
    Author     : spc26
--%>

<%@page import="Grocery_Store.*"%>
<%@page import="Controller.*"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
        <title>Home</title>
    </head>
    <body>
        <style>
        .glyphicon {font-size: 50px;}
        body {background-color: powderblue;}
        td   {font-size:x-large;width:25%}
        th   {font-size:xx-large;}
        </style>
        
        <div id="header" class="container">    
            <table>
                <tr>
                    <td><% 
                        int count = 0;
                        Cart cart = (Cart) session.getAttribute("cart");
                        if (cart != null){count = cart.getItemCount();}
                        int clearance = (Integer) session.getAttribute("scLevel");
                        if (clearance == 1){out.println("<form action='CartController' method='post'><input type='hidden' name='action' value='v'><button type='submit'> <span class = \"glyphicon glyphicon-shopping-cart\"></span></button></form>Item Count: "+ count);} 
                        if (clearance == 2){out.println("<a href=\"#\"><span class = \"glyphicon glyphicon-list-alt\"></span></a>");} 
                        %></td>
                    <td><h1 align='center'><strong>Foods-n-Such</strong></h1></td>
                    <td align='right'>Welcome, ${username}</td>
                </tr>
            </table>
        </div>
        <div id="form" class="container">
            <table class="table table-dark table-hover">
                <thead>
                <div class="col-12 col-md-auto"><th>Item</th></div>
                <th>Quantity</th>
                <th>Price</th>
                <th>Cart</th>
                </thead>
                <tbody>
            <%
                        MySQLDBHelper helper = new MySQLDBHelper();
                        ArrayList<Item> items = helper.selectAllItems();
                       
                        for (int i = 0; i < items.size(); i++) {
                            Item item = items.get(i);
                            out.println("<tr>");
                            out.println("<td>" + item.getItemName() + "</td>");
                            out.println("<td>" + item.getQty() + "</td>");
                            out.println("<td>$" + item.getPrice() + "</td>");                           
                            out.println("<td><div class=\"btn-group\"><form action='CartController' method='post'>"
                                    + "<input type='submit' class=\"btn btn-default btn-sm\" value='+' alt='Add to Cart' style=\"height:30px; width:80px\">"
                                    + "<input type='hidden' name='itemName' value='" + item.getItemName() + "'>"
                                    + "<input type='hidden' name='action' value='a'>" +
                                    "</form>"
                                    //+ "</td><td>"
                                    + "<form action='CartController' method='post'>"
                                    + "<input type='submit' class=\"btn btn-default btn-sm\" value='-' alt='Remove from Cart' style=\"height:30px; width:80px\">"
                                    + "<input type='hidden' name='itemName' value='" + item.getItemName() + "'>"
                                    + "<input type='hidden' name='action' value='r'>"
                                    + "</form></td></div></tr>");
                        }
                        out.println("</tbody>");
                        out.println("</table>");
                        
                    
            %>
          <form action="UserLogoutController" method="post">
           <p>
              <a class="btn btn-lg btn-primary" href="index.jsp" role="button">Logout</a>
          </p>
               
            </form>

    </body>
</html>