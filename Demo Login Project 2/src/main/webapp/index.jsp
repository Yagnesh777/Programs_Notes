<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%
	/*Check if user is logged-in inorder to access this page. If not then redirects to login page.
	JSP has implicit objects predefined */
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
%>
	Hello World
</body>
</html>