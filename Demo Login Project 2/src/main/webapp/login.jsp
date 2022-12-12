<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="login.css">

</head>
<body>
<!-- if login successful then to generate message -->
<input type="hidden" id="status" value="<% request.getAttribute("status"); %>">

	<div class="center">
        <div class="container">
            <div class="text">Sign In Here</div>
            <form action="LoginServ" method="post">
<!--This doesn't directly points to the Login Servlet. It points to the annotation name that maps jsp and servlet-->
                <div class="data">
                    <label for="name">Username</label>
                    <input type="text" name="username" id="name" required>
                </div>

                <div class="data">
                    <label for="pass">Password</label>
                    <input type="password" name="password" id="pass" required>
                </div>

                <div class="forgot-pass">
                    <a href="#">Forgot Password?</a>
                </div>
                
                <div class="btn">
                    <div class="inner"></div> <!--This div is for background of button-->
                    <!-- <input type="submit" value="Login"> -->
                                <!-- OR -->
                    <button type="submit">Login</button>
                </div>

                <div class="signup-link">
                    Not a member? <a href="register.jsp">Signup now</a>
                </div>
            </form>
        </div>
    </div>
	
<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status=="failed"){
		swal("Login Unsuccessful!! Check username or password.","error");  //not defined by me
	}
</script> 
</body>
</html>