package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextDisplay3 extends HttpServlet {
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		//REDIRECTING
	
		//This Servlet is being called using TextDisplay Servlet by redirecting
		
		String str= req.getParameter("str");//Typecasting since returned in object format.
		
		PrintWriter out = res.getWriter();
		out.println(str+" from TextDisplay3 (Redirecting)");
	}
}
