<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME PAGE</title>
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
#maindiv{
background-color: white;
padding-top: 30px;
padding-bottom: 30px;
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
  <a id="active-link" href="#">Home</a>
  <a href="register">Add New Patient</a>
  <a href="update-page">Update Patient</a>
  
  <a href="track-income">Track Income</a>
  
</div>
<br>
<br>
<p align="center" style="font-size: 35px; font-weight: bold;">HOME PAGE</p>

<font color="red" style="font-weight: bold;">
<p align="center"><c:out value="${msg }"/></p>
</font>
<div class="contain">


		<div class="col-lg-3">
	    </div>
	    
	    
	    
	    <div class="col-lg-6" align="center" id="maindiv">
			    <form method="post" action="${pageContext.request.contextPath}/process-search">
				<font color="black" style="font-weight: bold;">Enter patient name: </font>
				<input type="text" name="name" required>
				<input id="submitbutton" type="submit" value="SEARCH">
				</form>
				<br>
				<br>
				<font color="blue" style="font-weight: bold;">
				<p align="left">LIST OF PATIENTS:</p>
				<br>
				
				
				
				<c:forEach items="${list}" var="p">
				<p align="left">
				<font color="black" style="font-weight: bold;">Name:</font>
				<font color="red" style="font-weight: bold;">
				<c:out value="${p.getName() }"/></font>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="black" style="font-weight: bold;">Mobile:</font>
				<font color="red" style="font-weight: bold;">
				<c:out value="${p.getMobile() }"/></font>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a id="selectbutton" href="${pageContext.request.contextPath}/get-profile?id=${p.getId()}">SELECT</a>
				</p>
				
				<hr>
				
				</c:forEach>
	    
	    </div>
	    
	    
	    <div class="col-lg-3">
	    </div>
</div>

<div class="footer">
  <p>Copyright &copy; Aryak's Medical Portal 2020 | MADE BY: Aryak Deshpande</p>
</div>



</body>
</html>