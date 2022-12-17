package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	
	public static Connection con; //this can be written inside the method as well
	public static Connection getConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
			
			System.out.println("Connection Successful");
			
			return con;
			
		} catch (SQLException | ClassNotFoundException e) {e.printStackTrace();}
		
		return null; //if local return generates error then executing this
	}
	
	public static void main(String[] args) {
		
		getConnect();
	}
}
