<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Sign Up </title>
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
<form action="signup" method="post">
<div class="page2"> <br>
   <h3>Create an Account</h3>
     <label>Full Name:</label>
     <input type="text" name="name"  placeholder="Enter Your Full Name(First Name,Last Name)" required></input>
  
     <label>Email ID :</label>
     <input type="email"  name="mail"  placeholder="Enter Your Email Id" required size="55"></input>

     <label>Address :</label>
     <input type="text" name="add"  placeholder="Enter Your Address" required></input>

     <label>Pincode : </label>
     <input type="number" name="pincode"  placeholder="Enter Your Pincode" required maxlength="6"></input>

     <label>State:</label> 
      <select name="state" >		
      	<option>Andaman And Nicobar Islands</option>
        <option>Andhra Pradesh</option>
        <option>Arunachal Pradesh</option>
        <option>Assam</option>
        <option>Bihar</option>
        <option>Chandigarh</option>
        <option>Chhattisgarh</option>
        <option>Dadra And Nagar Haveli</option>
        <option>Daman And Diu</option>
        <option>Delhi</option>
        <option>Goa</option>
        <option>Gujarat</option>
        <option>Haryana</option>
        <option>Himachal Pradesh</option>
        <option>Jammu And Kashmir</option>
        <option>Jharkhand</option>
        <option>Karnataka</option>
        <option>Kerala</option>
        <option>Ladakh</option>
        <option>Lakshadweep</option>
        <option>Madhya Pradesh</option>
        <option>Maharashtra</option>
        <option>Manipur</option>
        <option>Meghalaya</option>
        <option>Mizoram</option>
        <option>Nagaland</option>
        <option>Odisha</option>
        <option>Puducherry</option>
        <option>Punjab</option>
        <option>>Rajasthan</option>
        <option>Sikkim</option>
        <option>Tamil Nadu</option>
        <option>Telangana</option>
        <option>Tripura</option>
        <option>Uttar Pradesh</option>
        <option>Uttarakhand</option>
        <option>West Bengal</option>
      </select>

     <label>Password:</label> 
     <input type="password" name="pass" placeholder="Enter Your Password" required minlength="6"></input>
     
     <label>Confirm Password:</label> 
     <input type="password" name="confirm" placeholder="Confirm Your Password" required minlength="6"></input>
     
      <input type="submit" class="button" name="Submit">
      <input type="reset"  class="button" name="Reset">
    <div>  
    <p class="back-signin" ">Already have an Account.<a href="login.jsp">Login</a></p></div>
</div> 
</form>
</section>
</body>
</html>