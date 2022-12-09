<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<!-- if login successful then to generate message -->
<input type="hidden" id="status" value="<% request.getAttribute("status"); %>">

	<form action="LoginServ" method="post">
<!--This doesn't directly points to the Login Servlet. It points to the annotation name that maps jsp and servlet-->
		<h4>Sign In</h4>
		
		<input type="text" placeholder="enter username" name="username"> <br>
		<input type="password" placeholder="enter password" name="password"> <br>
		<a href="">forgot password</a>
		<input type="submit" value="Sign In" name="login"><br>
		
		<a href="register.jsp">create an account</a>		
	</form>
	
<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status=="failed"){
		swal("Login Unsuccessful!! Check username or password.","error"); //not defined by me
	}
</script> 
</body>
</html>