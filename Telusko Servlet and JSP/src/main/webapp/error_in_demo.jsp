<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!--specifying if this is an error page for some other jsp page  -->
	<%@ page isErrorPage="true" %> 
	<h3>error</h3>
	<!--specifying the exception message generated  -->
	<%= exception.getMessage() %>
	
</body>
</html>