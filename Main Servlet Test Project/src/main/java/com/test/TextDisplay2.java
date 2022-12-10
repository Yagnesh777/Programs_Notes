package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextDisplay2 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		//DISPATCHING
		
		//This Servlet is being called using TextDisplay Servlet by dispatching the request
		
		String str=(String) req.getAttribute("str");//Typecasting since returned in object format by setAttribute.
		
		PrintWriter out = res.getWriter();
		out.println(str+" from TextDisplay2 (Dispatching)");
	}
}
