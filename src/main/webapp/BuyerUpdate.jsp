<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
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

<% 
response.setHeader("Cache_Control","no-cache, no-store, must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("email")==null){
	response.sendRedirect("login.jsp");
}
%>
<section>
<form action="update" method="post">
<div class="page2"> <br>
   <h3>Enter the Crop</h3>
     <label>Crop:</label>
     <select name="crop">		
        <option>Wheat</option>
        <option>Rice</option>
     </select>
     <label>Price(Rs/kg):</label>
     <input type="tel" name="price"  placeholder="Enter the Price" size="55" required></input>
     
     <label>Address :</label>
     <input type="text" name="add"  placeholder="Enter Your Address" required></input>

     <label>Pincode : </label>
     <input type="tel" name="pincode"  placeholder="Enter Your Pincode" size="55" required maxlength="6"></input>
     <label>Contact No: : </label>
     <input type="text" name="num"  placeholder="Contact No." size="55" required maxlength="10"></input>

    
      <input type="submit" class="button" name="Update">
      <input type="reset"  class="button" name="Reset Now">
     
</form>
</section>
</body>
</html>