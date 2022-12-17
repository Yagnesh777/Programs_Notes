package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.connection.GetConnection;

public class UserDAO {
	
	public boolean insertUser(User user) {
		
		String query = "insert into users values(?,?,?,?)";
		try {
			PreparedStatement ps = GetConnection.getConnect().prepareStatement(query);
			
			ps.setString(1, user.getuName());
			ps.setString(2, user.getuPass());
			ps.setString(3, user.getuEmail());
			ps.setLong(4, user.getuMob());
			
			return ps.executeUpdate()>0;
		} catch (SQLException e) {e.printStackTrace();}
		return false; //if above doesn't work then just returning false 
	}
	
	public User getUser(long mobile, String password) {	
		
		String query = "select * from users where umob=? and upass=?";
		try {
			PreparedStatement ps = GetConnection.getConnect().prepareStatement(query);
			
			ps.setLong(1, mobile);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				User user = new User();
				user.setuName(rs.getString(1));
				user.setuPass(rs.getString(2));
				user.setuEmail(rs.getString(3));
				user.setuMob(rs.getLong(4));
				
				return user;
			}
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
//	public List<User> getAllUsers(){
//		
//		List<User> list = null;
//		try {
//			list = new ArrayList<User>();
//			
//			String query = "select * from users";
//			PreparedStatement ps = GetConnection.getConnect().prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				User user = new User();
//				user.setuName(rs.getString(1));
//				user.setuPass(rs.getString(2));
//				user.setuEmail(rs.getString(3));
//				user.setuMob(rs.getLong(4));
//				
//				list.add(user); //adding records fetched from database to list.
//			}
//		} catch (SQLException e) {e.printStackTrace();}
//		return list;
//	}

}
