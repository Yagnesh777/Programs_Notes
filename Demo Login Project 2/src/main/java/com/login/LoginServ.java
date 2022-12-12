package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession ses = request.getSession();
		RequestDispatcher rd;
		Connection con = null;
		
		//Retrieving the data from the database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
			
			String query = "select * from user_s where uname= ? and upass= ?";
			//This query is to obtain the record using values given by user if exist.
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, username);
			st.setString(2, password);
			
			//checks if database has the obtained(by user) data in it
			ResultSet rs = st.executeQuery();
			if(rs.next()) { //if has record or wrong password
				ses.setAttribute("username", rs.getString(1));  //not understood
				rd = request.getRequestDispatcher("index.jsp");
			}
			else {			//if no record dispatch to login page
				request.setAttribute("status", "failed");
				rd = request.getRequestDispatcher("login.jsp");
			}
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
