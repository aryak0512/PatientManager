<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@900&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Dancing+Script&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Baloo+Chettan+2&display=swap" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>LOGIN PAGE</title>
<style type="text/css">
body{
background-image: url("resources/nn.png");
background-size: cover;


}
#motto{
margin:5%;
font-style: bold;
font-size: 60px;
font-family: 'Montserrat', sans-serif;
color:white;
opacity: 0.2;

}
#log{
font-style: bold;
font-size: 30px;
font-family: 'Montserrat', sans-serif;
color:black;
}
#labels{
font-size: 10px;
font-family: 'Montserrat', sans-serif;
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   margin-top:5%;
   margin-bottom:1%;
   width: 100%;
   font-weight:bold;
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
input{
background-color: white;
border-radius: 8px;
}
#formo{
margin-left:20%;
margin-right:0%;
float:right;
}
</style>
</head>
<body>


<div class="contain">


		<div class="col-lg-4">
	    </div>


		<div class="col-lg-4" align="center">
				<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
				<p id="log">ADMIN LOGIN</p>
				<br>
				<font color="black" style="font-weight: bold;">
				<c:out value="${msg }"/></font>
				
				<sf:form method="post" action="${pageContext.request.contextPath}/process-login" modelAttribute="user">
				<br>
				<font color="black" style="font-weight: bold;">Username:</font>&nbsp;&nbsp;
				<sf:input type="text" path="username"/><sf:errors path="username"/>
				<br><br><br>
				<font color="black"  style="font-weight: bold;">Password:</font>&nbsp;&nbsp; 
				
				<sf:input type="password" path="password"/><sf:errors path="password"/>
				<br><br><br>
				<input type="submit" class="btn btn-danger" value="LOGIN"/>
				</sf:form>
		</div> 
		
		
		<div class="col-lg-4">
	    </div> 
</div>



<div class="footer">
  <p>Copyright &copy; Aryak's Medical Portal 2020 | MADE BY: Aryak Deshpande</p>
</div>
</body>
</html>

