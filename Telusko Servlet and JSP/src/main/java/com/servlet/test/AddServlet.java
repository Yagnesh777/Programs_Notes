
package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// our class becomes servlet as soon as we extend HttpServlet class
//@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	//predefined method of HttpServlet class
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {  
		//Creating reference of  predefined request and response object
		// using request obj u can fetch the request from the client, using response obj u can send the response to the client.
		
	/*	-> Other than service() HttpServlet class has 2 more methods: doGet, doPost
		-> Inorder for this servlet to work only with post method use 'doPost()' instead of service(). 
		-> NOTE: doPost works through the service() */
		
		
		int i = Integer.parseInt(req.getParameter("num1")); //since num1 (from index.html) is of String type, type conversion of string to int
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i+j;
		
		PrintWriter out = res.getWriter();
		//It is used to display the output on the browser rather than console(by default)
		out.println("The result is "+ k);
		System.out.println("The result is "+ k);
		
		
		//Normal Session: sharing data from this servlet to another servlet
		
		//Here "k" is a key, k is a value(from this servlet) so that we can refer in another servlet
//		req.setAttribute("k",k); 
		
		
		
		//Calling SquareServlet from this servlet
//		RequestDispatcher rd = req.getRequestDispatcher("square");	//'square' represents from web.xml file
//		rd.forward(req, res);
		
		
		
		//Calling CubeServlet from this servlet
		
		//res.sendRedirect("cube?k=" +k); //name same as in web.xml
		//Here URL rewriting is taking place
		//sendRedirect() works only with doGet() irrespective of the method in html page form or main servlet
		//Here the doGet() is of called servlet
	}

}
