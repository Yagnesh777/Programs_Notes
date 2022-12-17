
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDAO;

@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long contact = Long.parseLong(request.getParameter("contact"));
		String password = request.getParameter("password");
		UserDAO ud = new UserDAO();
		User fetch = ud.getUser(contact, password);
		
		
		//Retrieving the data from the database
			if(fetch != null) { //if has record or wrong password
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			else {			//if no record dispatch to login page
				request.setAttribute("error", "Invalid Login Credentials !!");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		
	}

}
