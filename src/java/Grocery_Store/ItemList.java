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
public class ItemList {
    
    private ArrayList<Item> list = null;
    
    public ItemList(){
        
    }
    
    public ItemList(ArrayList<Item> inList){
        list = new ArrayList<Item> (inList);
    }
    
}
