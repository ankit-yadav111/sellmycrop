<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Forget Password</title>
	<link href="resources/img/logo.png" type="image/png" rel="icon">
	<link rel="stylesheet" type="text/css" href="vendors/css/fluid.css">
	<link rel="stylesheet" type="text/css" href="resources/css/form.css"> 
</head>	
<body>
<section>
<form action="forgetpassword" method="get">
<div class="page1">	<br>
  <h3>Forget Password</h3>
	<div class="container" style='margin-right:50px'>	
	  <label>Email ID:</label> 
	  	<input type="email" name="num" placeholder="Enter the Email ID" size="35" required /><br>
	  	<input  type="submit" value="Send OTP" /></div>
    </div>
    </form>
</section>
</body>
</html>