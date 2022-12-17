
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDAO;

@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO ud = new UserDAO();
		User user = new User();
		//'setuName'is same as that of User class. && 'name' is obtained from jsp page
		user.setuName(request.getParameter("name"));
		user.setuPass(request.getParameter("pass"));
		user.setuEmail(request.getParameter("email"));
		user.setuMob(Long.parseLong(request.getParameter("contact")));
		
		//this is from UserDAO class
		boolean insert = ud.insertUser(user);
		
		// this is to generate alert message
		if(insert == true) {
			request.setAttribute("status", "Registration Successful..");	
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
		else {
			request.setAttribute("status", "Enter valid Credentials..");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
			
		}
			
			
	}
}
