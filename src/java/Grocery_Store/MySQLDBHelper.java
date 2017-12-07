package Grocery_Store;

import Grocery_Store.User;
import Grocery_Store.Item;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/*
 * created by Adam Pugliese
 */

public class MySQLDBHelper {
    
	
	public MySQLDBHelper(){
		//nothing here
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		// Class.forName("org.sqlite.JDBC");
		MySQLDBHelper test = new MySQLDBHelper();
		test.test();
	}
	
	private void test() throws ClassNotFoundException, SQLException{
                
                //Test for select item count
                //out.println(this.selectItemCount());
                
                /*
	    	// TEST FOR SELECT ALL ITEMS
	    	 
	    	ArrayList<Item> items = new ArrayList<Item>(this.selectAllItems());
	    	System.out.println("ID\tName\tQty\tPrice"); //column labels
	    	for (int i = 0; i < items.size(); i++)
	    	{
	    		// System.out.println(ing.get(i).toString());
	    		System.out.println(items.get(i).getItemId() + "\t" 
	    							+ items.get(i).getItemName() + "\t"
	    							+ items.get(i).getQty() + "\t"
	    							+ items.get(i).getPrice());
	    							
	    	}
                */
                /*
        	// TEST FOR SELECT ALL USERS
	    	 
	    	ArrayList<User> users = new ArrayList<User>(this.selectAllUsers());
	    	System.out.println("ID\tUsername\tPassword\tAdmin"); //column labels
	    	for (int i = 0; i < users.size(); i++)
	    	{
	    		// System.out.println(ing.get(i).toString());
	    		System.out.println(users.get(i).getUserId() + "\t" 
	    							+ users.get(i).getUsername() + "\t"
	    							+ users.get(i).getPassword() + "\t"
	    							+ users.get(i).getAdmin());
	    	}        
                */
	}
        
	
	
    private Connection connect() throws SQLException, ClassNotFoundException {
        Connection conn = null;
         try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://pugpen.org/pugpen67_webMVC", "pugpen67_web", "Wednesday13!");
                
        }catch(SQLException e){
                out.println("Connection Failed" + e.toString());
        }
         
        return conn;
    }
    
    public int selectItemCount() throws ClassNotFoundException{ 
    	int count = -1;
    	String sql = "SELECT COUNT(*) from item_lst;";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
    		
               System.out.println("Query Success");
               
               while (rs.next()) {count = rs.getInt(1);}

               //return recipeLst;
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
    	}
    	return count;
    }
    
    
    public ArrayList<User> selectAllUsers() throws ClassNotFoundException{ 
    	ArrayList<User> userLst = new ArrayList<User>();
    	String sql = "SELECT * from user_lst;";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)){
    		
               System.out.println("Query Success");
               
               while (rs.next()) {

                   User user = new User();
                   user.setUserId(rs.getInt("user_id"));
                   user.setUsername(rs.getString("username"));
                   user.setPassword(rs.getString("password"));
                   user.setAdmin(rs.getInt("admin"));
                   
                   
                   userLst.add(user);
               }
               //return recipeLst;
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
    	}
    	return userLst;
    }
    
	public ArrayList<Item> selectAllItems() throws SQLException, ClassNotFoundException{ 
		ArrayList<Item> itemLst = new ArrayList<Item>();
		String sql = "SELECT * from item_lst;";
		
		try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){
			
	            System.out.println("Query Success");
	           
	           while (rs.next()) {
	
	               Item item = new Item();
	               item.setItemId(rs.getInt("item_id"));
	               item.setItemName(rs.getString("item_name"));
	               item.setQty(rs.getInt("qty"));
                       item.setPrice(rs.getFloat("price"));
	              
	               
	               itemLst.add(item);
	           }
	           //return recipeLst;
	           
		} catch (SQLException e) {
	           System.out.println(e.getMessage());
		}
		return itemLst;
	}  
        
        public Item selectSpecificItem(String name) throws SQLException, ClassNotFoundException{ 
		ArrayList<Item> itemLst = new ArrayList<Item>();
		String sql = "SELECT * from item_lst where item_name = '" + name + "';";
		
		try (Connection conn = this.connect();
	            Statement stmt  = conn.createStatement();
	            ResultSet rs    = stmt.executeQuery(sql)){
			
	            System.out.println("Query Success");
	           
	           while (rs.next()) {
	
	               Item item = new Item();
	               item.setItemId(rs.getInt("item_id"));
	               item.setItemName(rs.getString("item_name"));
	               item.setQty(rs.getInt("qty"));
                       item.setPrice(rs.getFloat("price"));
	              
	               
                       return item;
	           }
	           //return recipeLst;
	           
		} catch (SQLException e) {
	           System.out.println(e.getMessage());
		}
                Item item = new Item();
                return item;
		//return itemLst.get(1);
	}
        
        public boolean addOrder(Order x) throws ClassNotFoundException{ 
    	boolean success = false;
        
    	String sql = "INSERT INTO orders(total,create_dt) values (" + x.getTotalCost() + ",'" + x.getOrderDate() + "');";
    	
    	try (Connection conn = this.connect();
                Statement stmt  = conn.createStatement();){
                stmt.executeUpdate(sql);
               System.out.println("Query Success");
               success = true;
               //while (rs.next()) {count = rs.getInt(1);}

               //return recipeLst;
               
    	} catch (SQLException e) {
               System.out.println(e.getMessage());
               success = false;
    	}
    	return success;
    }
}