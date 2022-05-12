<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Log in </title>
	<link href="resources/img/logo.png" type="image/png" rel="icon">
	<link rel="stylesheet" type="text/css" href="vendors/css/fluid.css">
	<link rel="stylesheet" type="text/css" href="resources/css/form.css"> 
	<link rel="stylesheet" type="text/css" href="resources/css/about.css"> 
</head>	
<body>
<header>
				<nav class="sticky-nav">
				<img src="resources/img/logo.png" alt="MyCrops Logo" class="logo">
				<ul class="main-nav">
					<li><a href="index.jsp">Home</a></li>
					<li><a href="login.jsp">Login</a></li>
					<li><a href="about.jsp">About Us</a></li>
					<li><a href="contactus.jsp">Contact Us</a></li>
				</ul>
			</nav></header>

<section>
<form action="login" method="post">
<div class="page1">	<br>
  <h3>Sign in</h3>
	
	<div class="container" style='margin-right:50px'>	
	  <label>Email ID :</label> 
	  	<input type="email"  name="Name" placeholder="Enter the Email Id" size="35"  required />

	  <label>Password:</label> 
	  <input type="password" name="Password" placeholder="Enter Your Password" required />
	  
      <div class="submit-now"><input type="submit" name="Submit"></div>
      <div class="forgot"><a href="forgetpassword.jsp">Forgot Your Password</a>  
      <p>Create an Account.<a href="signup.jsp">SignUp</a></p>
      </div>
    </div>
  </div> 
</form>
</section>
</body>
</html>