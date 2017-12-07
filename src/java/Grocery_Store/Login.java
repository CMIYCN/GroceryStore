/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grocery_Store;

import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author spc26
 */
public class Login {
        
     public Login(){
         
     }
     
     public static void main(String[] args){
         Login userLogin = new Login();
     }
    
     public int validate(String username, String password) throws ClassNotFoundException{
        boolean check = false;
        int scLevel = 0;
        MySQLDBHelper helper = new MySQLDBHelper();
        ArrayList<User> userLst = helper.selectAllUsers();
        
        for(int i = 0; i < userLst.size(); i++){
            out.println("input: " + username + ", " + password);
            out.println("from DB: " + userLst.get(i).getUsername() + ", " +
                    userLst.get(i).getPassword() + ", " + 
                    userLst.get(i).getAdmin());
            if(userLst.get(i).getUsername().equals(username) 
                    && userLst.get(i).getPassword().equals(password)){
                
               scLevel = 1;
               if (userLst.get(i).getAdmin()==1){
                   scLevel = 2;
               }
                break;
            }
        }
      
         return scLevel;
    }
    
}
