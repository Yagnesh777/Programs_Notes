package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TextDisplay4 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	
		//This Servlet is being called using TextDisplay Servlet by Session Management
		
		HttpSession session = req.getSession();
		String str = (String) session.getAttribute("str"); 
		
		PrintWriter out = res.getWriter();
		out.println(str+" from TextDisplay4 (Session)");
		
		//removing the data from session
		session.removeAttribute("str");
	}
}
