
//-------------------------------- program for sendRedirect ------------------------------------------

package com.servlet.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CubeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
		int k = Integer.parseInt(req.getParameter("k"));
		// It becomes int k = k (this is from AddServlet)
		
		PrintWriter out = res.getWriter(); 
		out.println("Cube of a added numbers is "+k*k*k);
		
	}

}
