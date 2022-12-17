<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<link rel="stylesheet" href="register.css">
</head>
<body>

	<div id="alert"><span> ${status}</span></div>
	<div class="center">
        <div class="container">
            <div class="text">Sign Up Here</div>
            <form action="RegisterServ" method="post">
                <div class="data">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" required>
                </div>
                
                <div class="data">
                    <label for="mail">Email</label>
                    <input type="email" name="email" id="mail" required>
                </div>
                
                <div class="data">
                    <label for="mob">Contact No</label>
                    <input type="text" name="contact" id="mob" required>
                </div>

                <div class="data">
                    <label for="pass">Password</label>
                    <input type="password" name="pass" id="pass" required>
                </div>
                <div class="data">
                    <label for="cpass">Confirm Password</label>
                    <input type="password" name="cpass" id="cpass" required>
                </div>
                
                <div class="btn">
                    <div class="inner"></div> <!--This div is for background of button-->
                    <!-- <input type="submit" value="Login"> -->
                                <!-- OR -->
                    <button type="submit">Sign Up</button>
                </div>

                <div class="signin-link">
                    Have an account? <a href="login.jsp">Sign In Here</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>