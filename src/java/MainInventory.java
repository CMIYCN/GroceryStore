/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spc26
 */
@WebServlet(urlPatterns = {"/MainInventory"})
public class MainInventory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection myCon;
    private Statement myStmt;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        ResultSet rs;
        String query, colLabel, dat;
        int cols, i;
        ResultSetMetaData rsMd;
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Main Inventory</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet DBconnection at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            //create connection to the database
            try{
                Class.forName("com.mysql.jdbc.Driver");
                myCon = DriverManager.getConnection("jdbc:mysql://pugpen.org/pugpen67_webMVC", "pugpen67_web", "Wednesday13!");
            }catch(SQLException e){
                out.println("Connection Failed" + e.toString());
            }
            
            //create query statement
            try{
                myStmt = myCon.createStatement();
            }catch(Exception e){
                out.println("Query Statement Failed" + e.toString());
            }
            
            query = "select il.item_name, icl.item_cat_name, il.qty, il.price  from item_lst il\n" +
"join item_cat_lst icl on il.item_cat_id = icl.item_cat_id";
            //out.print("<p><b> Here is the query statement: </b>" + query + "</p>");
            
            //execute the query
            try{
                rs = myStmt.executeQuery(query);
                rsMd = rs.getMetaData();
                cols = rsMd.getColumnCount();
                
                out.println("<table border=1>");
                out.println("<caption> <b> Item Lists </b></caption>");
                out.println("<tr>");
                for(i = 1; i <= cols; i++){
                    colLabel = rsMd.getColumnLabel(i);
                    out.print("<th>" + colLabel + "</th>");
                }
                out.println("</tr>");
                
                //while loop to produce the rows
                while(rs.next()){
                    out.println("<tr>");
                    
                    for(i = 1; i <= cols; i++){
                        dat = rs.getString(i);
                        out.println("<td>" + dat + "</td>");
                }
                    out.println("</tr>");
            }
                out.println("</table>");
        }catch(Exception e){
            out.println("Query Execution Failed </br />" + e.toString());
        }//end of catch
            
            out.println("</body>");
            out.println("</html>");
            
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainInventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
// </editor-fold>


