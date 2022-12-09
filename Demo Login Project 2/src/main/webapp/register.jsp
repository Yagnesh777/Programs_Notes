<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<!-- if register successful then to generate message -->
<input type="hidden" id="status" value="<% request.getAttribute("status"); %>">
<p> <% request.getAttribute("status"); %></p>

	<form action="RegisterServ" method="post">
		<h4>Sign Up</h4>
		<input type="text" placeholder="enter your name" name="name"> <br>
		<input type="email" placeholder="enter your email" name="email"><br>
		<input type="text" placeholder="enter phone number" name="contact"><br>
		<input type="password" placeholder="enter password" name="pass"> <br>
		<input type="password" placeholder="confirm password" name="cpass"> <br>
		<input type="submit" value="Sign Up" name="register">
		
		<a href="login.jsp">Already a member?</a>
	</form>
	
<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status=="success"){
		swal("Account created successfully","success"); //not defined by me
	}
</script>
</body>
</html>