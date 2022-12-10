<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo Response Page</title>
</head>
<body bgcolor="grey">
	
<!-- 	Java code is written inside delimiters -->
	<%
 	//JSP has request reference variable bydefault. No need of response object
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	int mul = num1*num2;
	
	out.println("Multiplication is "+ mul);
	
	%>
	
<!-- SCRPITLET TAG -->
	<%/*
	Code written inside it goes to service() of HttpServlet when JSP is converted to Servlet Class
	
	Inorder to write something outside of service() but inside of Servlet Class ie. some variable or method declaration
	we have to specify exclamation(!) inside of scriptlet.
	*/%>
	
	
<!-- DECLARATION TAG -->
	<%! int x=10; %>
	<!--The code inside this section goes inside of Servlet Class but outside ofservice() -->
	<!--It is used to declare variables and methods  -->

	
	
<!-- DIRECTIVE TAG -->
	<%@page import="javax.servlet.http.HttpServlet"%>
	<!--It is used to write the import statements, which are written outside of class in Servlets -->
	
	
<!-- EXPRESSION TAG -->
	<%= "Multiplication is "+mul %>
	<!--It is used to write the print statements  -->
	
	
	
	
</body>
</html>