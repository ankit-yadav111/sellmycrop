<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Buyer</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="resources/img/logo.png" type="image/png" rel="icon">
    <link rel="stylesheet" type="text/css" href="resources/css/about.css">
	<link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="resources/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="resources/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="resources/vendor/perfect-scrollbar/perfect-scrollbar.css">
	<link rel="stylesheet" type="text/css" href="resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="resources/css/main.css">
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
<div class="main-nav1">
<br><br><br>
<h1>Crop Details</h1>
<div class="form1">
<form action="logout" method="post">
<button class="btn btn-full">Logout</button>
</form></div>
<%
String email=(String)session.getAttribute("email");
session.setAttribute("email", email);
%>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
      url="jdbc:mysql://localhost:3306/login"
      user="root"  password="Password@959988"/>
      <sql:query dataSource="${db}" var="crop">
      SELECT Crop,Price,Address,Pincode, Contact from Rice where Email_ID=?;
      <sql:param value="<%=email%>" />
    </sql:query>
    <% int i=0; %>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">Crop</th>
								<th class="column3">Price(Rs/kg)</th>
								<th class="column2">Address</th>
								<th class="column4">Pincode</th>
								<th class="column5">Contact No.</th>
								<th class="column6">Delete</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="row" items="${crop.rows}">
						<%i=1; %>
								<tr>
									<td class="column1"><c:out value="${row.Crop}"/></td>
									<td class="column3"><c:out value="${row.Price}"/></td>
									<td class="column2"><c:out value="${row.Address}"/></td>
									<td class="column4"><c:out value="${row.Pincode}"/></td>
									<td class="column5"><c:out value="${row.Contact}"/></td>
									<td class="column6"><button class="btn btn-full"><a href="remove?crop=<c:out value="${row.Crop}"/>"><b>Delete</b></a></button></td>
								</tr>
								</c:forEach> 
								
								<sql:query dataSource="${db}" var="crop">
								SELECT Crop,Price,Address,Pincode, Contact from Wheat where Email_ID=?;
								<sql:param value="<%=email%>" />
								</sql:query>
								<c:forEach var="row" items="${crop.rows}">
								<%i=1; %>
								<tr>
									<td class="column1"><c:out value="${row.Crop}"/></td>
									<td class="column2"><c:out value="${row.Price}"/></td>
									<td class="column3"><c:out value="${row.Address}"/></td>
									<td class="column4"><c:out value="${row.Pincode}"/></td>
									<td class="column5"><c:out value="${row.Contact}"/></td>
									<td class="column6"><button class="btn btn-full"><a href="remove?crop=<c:out value="${row.Crop}"/>"><b>Delete</b></a></button></td>
								</tr>
								</c:forEach>
						</tbody>
					</table><br>
 <% if (i==0){
	   out.print("<p align=\"center\" style=\"font-size:25px\" style=\"font-family:verdana\" >no record found</p>");
     }%>
<button class="btn btn-full"><a href="BuyerUpdate.jsp" ><b>Update</b></a></button>
					
				</div>
			</div>
		</div>
	</div>
</div>
	

<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>