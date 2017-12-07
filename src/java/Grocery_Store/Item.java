package Grocery_Store;

/**
 * A class that represents an item
 */

import java.io.*;
import static java.lang.System.out;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author spc26
 */
public class Item {
    
    private int itemId;
    private String itemName;
    private String itemCategory;
    private int qty;
    private float price;
    private Connection myCon;
    private Statement myStmt;
    
    public Item(){
        
    }
    
    public Item(int itemId, String itemName, String itemCategory, int qty, 
            Float price){
        
        itemId = this.itemId;
        itemName = this.itemName;
        itemCategory = this.itemCategory;
        qty = this.qty;
        price = this.price;
    }
    
    public static void main(String []args) throws ClassNotFoundException{
        
        Item test = new Item();
        test.setItemName("Bread");
        test.decrement();
        out.println("test");
       
        
    }
    

    public String toString(){
        String result = "";
        result += this.itemId + "\t";
        result += this.itemName + "\t";
        result += this.qty + "\t";
        result += this.price;
        return result;
    }
    
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
    
    private boolean increment() throws ClassNotFoundException{
        //code to increment in DB
        //db connection stuff
       
        
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
                out.println("Query Statement Failed " + e.toString());
            }
            
          String query = "UPDATE item_lst set qty = qty + 1 where item_name ='" + this.itemName + "';";
        
        try {
            myStmt.executeUpdate(query);
        } catch (Exception e) {
            out.println("Query Execution Failed " + e.toString());
        }
        
        qty++; 
        return true;
    }
    
    private boolean decrement() throws ClassNotFoundException{
        //code to increment in DB
        //db connection stuff
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
            String sql = "UPDATE item_lst set qty = qty - 1 where item_name ='" + this.itemName + "';";
            
            try{
                myStmt.executeUpdate(sql);
            }catch(Exception e){
                out.println("Query Execution Failed " + e.toString());
            }
        qty--;
        
        return true;
    }
    
    //method to get item details
    public Item getItemDetails(String itemName){
        Item item = new Item();
        
        return item;
    }
    
    
}
