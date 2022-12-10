<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP DEMO PROGRAM</h3>
	
	<%--Declaration Tag --%>
	<%!
		int x=10, y=30, z=x+y;  //These are instance variables of class "demo_jsp"(converted)
	%>
	
	<%-- Expression Tag --%>
	<%= "Addition of 10 and 30 is "+z %>
	
	
	<%-- Exception Handling --%>
	
	<%-- Scriptlet Tag --%>
	<%
		int l=5,m=0;
	
		int n=l/m;
	//This will definitely throw exception.
	%>
	<%-- Directive Tag--%>	
	<%@ page errorPage="error_in_demo.jsp" %>
	<!-- Catching the error in another jsp file-->	
	
</body>
</html>

<%-- Comment in JSP File --%>
