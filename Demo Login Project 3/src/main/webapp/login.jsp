<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet" href="login.css">


</head>
<body onload='document.login-form.contact.focus()'>
<!-- if login successful then to generate message -->
	<div id="alert"><span>${error}</span></div>

	<div class="center">
        <div class="container">
            <div class="text">Sign In Here</div>
            <form action="LoginServ" method="post" id="login-form">
<!--This doesn't directly points to the Login Servlet. It points to the annotation name that maps jsp and servlet-->
                <div class="data">
                    <label for="mob">Mobile No.</label>
                    <input type="text" name="contact" id="mob" required>
                </div>
                
                <div id="result"></div>

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
                    <button type="submit" onclick="phonenumber(document.login-form.contact)">Login</button>
                </div>

                <div class="signup-link">
                    Not a member? <a href="register.jsp">Signup now</a>
                </div>
            </form>
        </div>
    </div>

<script>

	// Mobile Number Validation 
      function validateNumber(input) {
        var re = /^(\d{3})[- ]?(\d{3})[- ]?(\d{4})$/

        return re.test(input)
      }

      function validateForm(event) {
        var number = document.getElementById('mob').value
        if (!validateNumber(number)) {
          //alert('Please enter a valid number')
          const ele = document.getElementById('result')
          ele.innerHTML = 'enter a valid mobile no.'
          ele.style.color = 'red'
        } 
        event.preventDefault()
      }

      document.getElementById('login-form').addEventListener('submit', validateForm)
    </script>

</body>
</html>

https://www.codemystery.com/javascript-form-validation-email-phone-number-name/
