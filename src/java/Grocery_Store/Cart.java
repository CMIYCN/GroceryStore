/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grocery_Store;

import java.util.ArrayList;

/**
 *
 * @author spc26
 */
public class Cart {
        
    public Cart(){
        
    }
            
    ArrayList<Item> contents = new ArrayList<Item>();

    public ArrayList<Item> getContents() {
        return contents;
    }
            
    
    //method to add item to the cart
    public void addItem(Item item){
        contents.add(item);
    }
    
    //method to delete item from the cart
    public void deleteItem(Item item){
        String name = item.getItemName();
        for (int i = contents.size() - 1; i >= 0; i--){
            String current = contents.get(i).getItemName();
            if (current == name){contents.remove(i); break;}
        }
    }
    
    public int getItemCount(){
        int count = contents.size();
        return count;
    }
    
    public float getCost(){
        float total = 0;
        for (Item x : contents){
            total += x.getPrice();
        }
        return total;
    }
    
    
    
}
    

