package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multiply")
public class JspDemo extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		int mul = num1*num2;
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><body bgcolor='yellow'>");	//html code in java file
		out.println("Multiplication is "+ mul);
		out.println("</body></html>");
		
		
/*	Generally when we inspect page source of the response, we get to see the html page
 * 	But in this code, response page data is only showed. i.e what we print 
 * 	We wrote html code in java file, which doesn't look good and is also an headache
 * 	Therefore JSP comes into picture.
 */
	}
}
