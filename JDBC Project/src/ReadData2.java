import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadData2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yysdb?useSSL=false","root","12345");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from jdbc where Name='Tywin'");
		
		// fetching single record
		rs.next();
		String data = rs.getString(1) +" "+ rs.getDate(2) +" "+ rs.getLong(3);
		System.out.println(data);
	}

}
