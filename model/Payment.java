package com.restapi.sellNbuy.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement; 

public class Payment{
	
public String getPayment() {
	String paymentGrid = null;  
	Connection con = null;   
	Statement st = null;  
	ResultSet rs = null;    
	try {  
		con = DBConnection.createConnection(); //establishing connection  st = con.createStatement(); //Statement is used to write queries. Read more about it.  rs = st.executeQuery("select * from items"); //Here table name is users and nameUsesrs, passUsers are columns. fetching all the records and storing in a resultSet. 
		st = con.createStatement();
		
		rs = st.executeQuery("select *from payment");
if (rs.first())        { 
	paymentGrid = "<table border='1' cellspacing='1' cellpadding='1'><tr><th>No</th><th>Name</th><th>Description</th><th>Edit</t h><th>Delete</th></tr>";  
	rs.beforeFirst(); 

while(rs.next())  {
	paymentGrid = paymentGrid + "<tr><td>" + rs.getString(1) + "</td>"  
+ "<td>" + rs.getString(2) + "</td>" 
+ "<td>" + rs.getString(3) + "</td>" 
+ "<td><input id=\"btnEdit\" type=\"button\" name=\"btnEdit\"  param=\""
+ rs.getString(1) + "\" value=\"Edit\"</td>"  + "<td>" + "<input id=\"btnRemove\" type=\"button\" name=\"btnRemove\" param=\"" 
+ rs.getString(1) + "\" value=\"Remove\"</td></tr>";  
	} 
}    else  
	paymentGrid = "There are no items..."; 
paymentGrid = paymentGrid + "</table></br>"; 
}
	catch (SQLException e) {
		e.printStackTrace();
		}     
	return paymentGrid;
	}   

public String savePayment(String paymentID, String paymentMethod,String fulAmount,String date) { 
	String res = null; 
	String sql = null; 
	Connection con = null;
	Statement st = null;     
	try {   
		con = DBConnection.createConnection(); 
		//establishing connection   
		st = con.createStatement(); //Statement is used to write queries. Read more about it.    
		sql = "insert into payment (paymentID, paymentMethod,fulAmount,date) values ('" + paymentID + "', '" + paymentMethod + "','\" + fulAmount + \"', '\" + itmDesc + \"')";
		st.executeUpdate(sql);   
		res = "Successfully inserted..."; 
		}  
	catch(SQLException e) {  
		e.printStackTrace();
		}      
	return res;  
	}
}