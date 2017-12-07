/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Grocery_Store.Login;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class UserLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
                
        Login user = new Login();
//        boolean validated = false;
//        try {
//            validated = user.validate(username, password);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        out.println(validated);
        
        try {
            
            
//            if(user.validate(username, password)==1){
//                HttpSession session = request.getSession();
//                session.setAttribute("username", username);
//                response.sendRedirect("welcome.jsp");   
//            }else{
//                
//                response.sendRedirect("login.jsp");

                int clearance = user.validate(username, password);
                /*    
                switch(clearance){
                    case 0:
                        response.sendRedirect("login.jsp");
                        break;
                    case 1:
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        response.sendRedirect(password);
                   }
                   */
                if (clearance != 0){
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("scLevel", clearance);
                        response.sendRedirect("inventory.jsp");
                } else{
                    response.sendRedirect("login.jsp");
                }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
