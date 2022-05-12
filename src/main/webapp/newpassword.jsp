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
</head>	
<body>
<% 
response.setHeader("Cache_Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}
%>
<section>
<form action="newpassword" method="post">
<div class="page1">	
  <h3>New Password</h3>
	<br>
	<div class="container" style='margin-right:50px'>	
	  <label>Password:</label> 
	  	<input type="password" name="pass" placeholder="" required minlength="6"></input>
	  	
	  	<label>Confirm Password:</label>
	  	<input type="password" name="confirm" placeholder="" required minlength="6"></input>
	  	<input type ="submit" value="Submit">
    </div>
  </div> 
</form>
</section>
</body>
</html>