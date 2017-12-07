/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grocery_Store;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author spc26
 */
public class Order {
    
    Cart cart;
    private int orderId;
    private Date orderDate;
    private float totalCost;
    
    public Order(Cart x){
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        cart = x;
        orderDate = date;
        totalCost = cart.getCost();
    }
    
    public Order(int orderId, Date oDate, Float cost){
        this.orderId = orderId;
        this.orderDate = oDate;
        this.totalCost = cost;
    }
    
    public int getOrderId(){
        return orderId;
    }
    
    public void setOrderId(int orderId){
        this.orderId = orderId;
    }
    
    public Date getOrderDate(){
        return orderDate;
    }
    
    public void setOrderDate(Date oDate){
        this.orderDate = oDate;
    }
    
    public float getTotalCost(){
        return totalCost;
    }
    
    public void setTotalCost(Float cost){
        this.totalCost = cost;
    }
    
    //method to create order
    public void createOrder(ItemList cart, String username){
        
    }
    
    //method to get ordered items
    public String getOrderedItems(int orderId){
        
        String items = "";
        
        return items;
    }
}
