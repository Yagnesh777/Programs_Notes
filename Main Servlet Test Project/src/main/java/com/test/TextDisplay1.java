package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TextDisplay1 extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		//-------getting data from the html file
		String str= req.getParameter("n1");
		
		//-------printing obtained data
//		PrintWriter out = res.getWriter();
//		out.println(str+" from TextDisplay1(i.e html page)");
		
		//-------just calling another servlet using RD
//		RequestDispatcher rd = req.getRequestDispatcher("2");
//		rd.forward(req,res);
		
		//-------calling, and also sending data from this servlet using RD
//		req.setAttribute("str",str);
//		RequestDispatcher rd = req.getRequestDispatcher("2");
//		rd.forward(req,res);
		
		//-------just calling another servlet using SR
//		res.sendRedirect("3");
		
		//-------calling, and also sending data from this servlet using SR
		//this is url rewriting
//		res.sendRedirect("3?str="+ str); 
		
		
		//-------Session Management
		//Inorder to not use url rewriting in sendRedirect we use session(to keep track of data)
//		HttpSession session = req.getSession();
//		//session will be there throughout the visit of client on that website.
//		session.setAttribute("str", str);
//		res.sendRedirect("4");
		
		
		//-------Cookie
		Cookie cook = new Cookie("str", str); //RHS str need to be a string.If not then convert it by adding +""
		res.addCookie(cook);
		res.sendRedirect("5");
		
		
	}
}
