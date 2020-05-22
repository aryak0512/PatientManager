<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE FORM</title>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Baloo+Chettan+2&display=swap" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body{
background-image: url("resources/bac.jpg");
background-size: cover;
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   margin-top:5%;
   margin-bottom:1%;
   width: 100%;
   background-color: transparent;
   color: black;
   text-align: center;
   font-weight: bold;
}
.topnav {
  overflow: hidden;
  background-color: #333;
}


.topnav a {
  
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
.contain{
margin:5%;
}
.col-lg-6{
align-content: center;
}
#logout{
float: right;
}
#logo{
float: left;
}
#submitbutton{
background-color: green;
color: white;
font-weight: bold;
}
#content{
margin-left:10%;
margin-right:10%;
}
#select{
font-size: 40px;
font-family: 'Montserrat', sans-serif;
color:blue;
font-style:normal;
}
#submitbutton{
background-color: green;
color:white;
}
#selectbutton{
background-color: blue;
color:yellow;
padding: 8px;
}
#submitbutton{
background-color: green;
color:white;
}
#active-link{
background-color: green;
color: yellow;
}
</style>
</head>
<body>
<div class="topnav">
  
  <a href="logout" id="logout">Log-out</a>
  
  <a href="home">Home</a>
  <a id="active-link" href="#">Add New Patient</a>
    <a href="update-page">Update Patient</a>
  
  <a href="track-income">Track Income</a>
  
</div>
<br>
<br>
<p align="center" style="font-size: 35px; font-weight: bold;">UPDATE PATIENT DETAILS</p>

<div class="contain">
	<div class="row">
	    <div class="col-lg-4">
	    </div>
	    
	     <div class="col-lg-4" align="center">
			    <sf:form method="post" action="${pageContext.request.contextPath}/process-update-info" modelAttribute="patient">
				<c:forEach  items="${list }" var="p">
				<font color="black" style="font-weight: bold;">
				Patient name: </font>
				
				<sf:input type="text" path="name" value="${p.getName() }" />
				<br>
				<br>
				<font color="black" style="font-weight: bold;">
				Mobile:</font>
				
				<sf:input type="text" path="mobile" value="${p.getMobile() }"/>
				<sf:input type="hidden" path="id" value="${p.getId() }"/>
				<br><br>
				<input id="submitbutton" type="submit" value="UPDATE INFO" >
				</c:forEach>
				</sf:form>
	     </div>
	    
	    
	     <div class="col-lg-4">
	    </div>

	</div>
</div>

<div class="footer">
  <p>Copyright &copy; Aryak's Medical Portal 2020 | MADE BY: Aryak Deshpande</p>
</div>





</body>
</html>