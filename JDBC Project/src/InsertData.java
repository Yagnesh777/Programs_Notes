
/*
 * createStatement is used to directly pass the values in sql query.
 * Can also pass parameters in createStatement, but is not good
 * 
 * prepareStatement is used to pass parameters in sql query. We specify '?' for parameters in sql query
 * sql query is passed inside prepareStatement().
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	
	// for CREATE_STATEMENT
	public void insertData1() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
		Statement st = con.createStatement();
		
		// 'executeUpdate()' = used to insert/del/update the data from DB/ DML 
		//Here no ResultSet is used, since we are adding the data not fetching
		int count = st.executeUpdate("insert into jdbc values('Cersei', '1992-10-10', 5680011245)");
		
		System.out.println(count +" row affected.");
		st.close();
		con.close();
	}
	
	//for CREATE_STATEMENT
	//Using parameters instead of direct use of values in sql query
	public void insertData2(String a, String d, long c) throws ClassNotFoundException, SQLException {
		
		String name = a;
		String dob = d;
		long contact = c;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
		Statement st = con.createStatement();
		int count = st.executeUpdate("insert into jdbc values('"+name+"', '"+dob+"', "+contact+")");
		
		System.out.println(count +" row affected.");
		st.close();
		con.close();
		
	}
	
	//FOR PREPARE_STATEMENT
	public void insertData3(String a, String d, long c) throws ClassNotFoundException, SQLException {
		
		String name = a;
		String dob = d;
		long contact = c;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
		PreparedStatement st = con.prepareStatement("insert into jdbc values(?,?,?)");
		st.setString(1, name);
		st.setString(2, dob);
		st.setLong(3, contact);
		
		//don't need to pass sql query in executeUpdate()
		int count = st.executeUpdate();
		System.out.println(count +" row affected.");
		st.close();
		con.close();
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		InsertData d = new InsertData();
		d.insertData1();
		d.insertData2("Robb", "1988-03-27", 91024511187l);
		d.insertData3("Diana", "2001-08-24", 33472190090l);
	}

}
