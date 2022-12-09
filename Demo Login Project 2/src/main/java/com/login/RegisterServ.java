package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Getting the entries of the user
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		//String cpass = request.getParameter("cpass");
		String contact = request.getParameter("contact");
		
		RequestDispatcher rd = null;
		Connection con = null; //so that we can close connection in finally block
		
		//Inserting the data in database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
			
			//Below field_names are same as of database
			String query ="insert into user_s(uname, upass, uemail, umob) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			//'Statement.RETURN_GENERATED_KEYS' this is for generating auto increment 'id' field automatically
			
			st.setString(1, name);
			st.setString(2, pass);
			st.setString(3, email);
			st.setString(4, contact);
			
			
			//1 registration session inserts 1 record in database. therefore rowcount==1;
			int rowcount = st.executeUpdate();
			System.out.println("success"); //to check if everything is ok and running
			
			//dispatching to sign-up page on successful registration
			rd = request.getRequestDispatcher("register.jsp");
			
			/* To generate message as 'account created successful' when successful insertion of 1 record. This 
			 * mesage will be called in 'register.jsp' page to display
			 */
			if(rowcount > 0) {
				request.setAttribute("status", "success");	
			}
			else {
				request.setAttribute("status", "failed");
			}
			rd.forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {con.close();} catch (SQLException e) {e.printStackTrace();} //closing the connection
		}	
	}
	/* ERROR GENERATED
	 * at umob field, mysql version was giving error as it was not updated.
	 * using "ALTER TABLE USER MODIFY  UMOB LONGTEXT;" query error was solved.
	 * error generated in console was MYSQL TRUNCATION.
	 * 
	 * 'useSSL=false' to avoid ssl exception
	 * */

}
