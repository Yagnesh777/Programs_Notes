
//--------------- program for calling servlet in servlet and sharing data from 1 to other servlet

package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SquareServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//fetching the value k from AddServlet
		int k = (int) req.getAttribute("k"); //Typecasting since returned in object format.
		
		
		//Displaying the output
		System.out.println("Square of a added numbers is "+k*k); 	//in console(default)
		PrintWriter out = res.getWriter(); 
		out.println("Square of a added numbers is "+k*k);			//in browser
	}
	
}
