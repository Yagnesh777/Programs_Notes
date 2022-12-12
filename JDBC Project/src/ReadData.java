//?useSSL=false     this is used to handle SSL Exception

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//2   load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");	
		
		//3	  Establish a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
		
		//4	  Create Statement
		Statement st = con.createStatement();
		
		//5   Execute the query. 'executeQuery() = used to fetch the data from DB/ DQL'
		ResultSet rs = st.executeQuery("select * from jdbc");
		
		//6   Process the result. Fetching the result stored in rs object
		// fetching whole table
		// loop runs until every record is iterated over
		while(rs.next()) {	
			// using column-name same as DB
			String data = rs.getString("Name") +" "+ rs.getDate("DOB") +" "+ rs.getLong("Contact");
			System.out.println(data);
			// using column no.
			System.out.println(rs.getString(1) +" "+ rs.getDate(2) +" "+ rs.getLong(3));
		}
		
		//7	  Close Statement and Connection 
		st.close();
		con.close();
	}

}
