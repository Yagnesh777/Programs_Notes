package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextDisplay5 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	
		//This Servlet is being called using TextDisplay Servlet by Cookie
		
		//all the cookies in the website are sent to this servlet. It selects which cookie it wants
		Cookie cookies[] = req.getCookies();
		
		String str = "";	//always need to initialize this
		for(Cookie c: cookies) {
			if(c.getName().equals("str")) { //currently this str is a string. If not then convert it to integer in below
				str = c.getValue();		
			}
		}
		PrintWriter out = res.getWriter();
		out.println(str+" from TextDisplay5 (Cookie)");
	}
}
