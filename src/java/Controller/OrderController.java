package Controller;


import Grocery_Store.Item;
import Grocery_Store.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spc26
 */
public class OrderController extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
//        HttpSession session = request.getSession();
//        
//        //get cart items of the current session
//        Item cart;
//        cart = (Item) session.getAttribute("cart");
//        
//        //get user information from the current session
//        User user;
//        user = (User) session.getAttribute("user");
//        
//        try{
//            GroceryStore store = new GroceryStore();
//            store.addOrder(cart, user.getUsername());
//            
//            request.getSession().setAttribute("cart", cart);
//            request.getSession().setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + 
//                 "/index.jsp?thanks=Your order has been successfully added." +
//                    "Thanks for shopping with us");
//        }catch(Exception e){
//            
//        }
    }
    
}
