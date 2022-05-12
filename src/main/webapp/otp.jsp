<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>OTP Verification </title>
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
<form action="otp" method="post">
<div class="page1" >	<br>
  <h3>OTP Verification</h3>
	<div class="container" style='margin-right:50px'>	
	  <label>Enter OTP:</label> 
	  	<input type="text" name="code" placeholder="Enter the OTP" required maxlength="6" /><br>
	  	<input  type="submit" value="Submit" /></div>
    </div>
    </form>
</section>
</body>
</html>