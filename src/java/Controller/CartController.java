/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Grocery_Store.Cart;
import Grocery_Store.Item;
import Grocery_Store.MySQLDBHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author spc26
 */
public class CartController extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String cartAction = request.getParameter("action");
        String itemName = request.getParameter("itemName");
        System.out.println(cartAction + itemName);
        

        HttpSession session = request.getSession();
        Cart shoppingCart;
        shoppingCart = (Cart) session.getAttribute("cart");
        if(shoppingCart == null){
            shoppingCart = new Cart();
            session.setAttribute("cart", shoppingCart);
        }
        
        MySQLDBHelper dbHelper = new MySQLDBHelper();
        Item item = null;
        try {
            item = dbHelper.selectSpecificItem(itemName);
             if(cartAction.equals("a")){
            shoppingCart.addItem(item);
            
            System.out.println(shoppingCart.getItemCount());
            response.sendRedirect("inventory.jsp");  
        }else if (cartAction.equals("r")){
            item = dbHelper.selectSpecificItem(itemName);
            shoppingCart.deleteItem(item);
            System.out.println(shoppingCart.getItemCount());
            response.sendRedirect("inventory.jsp");  
        } else if (cartAction.equals("v")){response.sendRedirect("cart.jsp"); 
        } else if (cartAction.equals("b")){response.sendRedirect("inventory.jsp"); }
        } catch (SQLException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

    
    

}
