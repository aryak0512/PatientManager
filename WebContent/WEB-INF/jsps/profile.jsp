<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILE</title>
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
 #subjects {
  font-family: helvetica;
  border-collapse: collapse;
  text-align: center;
}
h2{
color: yellow;
background-color: red;
padding:10px;
}
#subjects td, #subjects th {
  border: 1px solid black;
  padding: 8px;
}

#subjects tr:nth-child(even){background-color: #f2f2f2;}

#subjects tr:hover {background-color: #ddd;}

#subjects th {
  padding-top: 8px;
  padding-bottom: 5px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}
</style>
<script type="text/javascript">
function alertMsg() {
	return confirm("Once submitted this form cannot be altered. Are you sure you want to continue?");
}
</script>
</head>
<body>
<div class="topnav">
  
  <a href="logout" id="logout">Log-out</a>
  <a href="home">Home</a>
  <a href="register">Add New Patient</a>
  <a href="update-page">Update Patient</a>
  
  <a href="${pageContext.request.contextPath}/track-income">Track Income</a>
  
</div>
<br>
<br>
<p align="center" style="font-size: 35px; font-weight: bold;">PATIENT PROFILE</p>


<div class="contain">


		<div class="col-lg-2">
	    </div>
	    
	    <div class="col-lg-8" align="center" id="maindiv">
	    <h3>Patient Name:</h3>
			<c:forEach items="${list }" var="p">
			   <font color="red" style="font-weight: bold;">
			   <c:out value="${ p.getName()}"/>
			   </font>
			</c:forEach>
		
			
			<h3>Patient History:</h3>
			<font color="red" style="font-weight: bold;">
			<p align="center"><c:out value="${msg }"/></p>
			</font>

		
			
   <table align="center" id="subjects">
			    <thead>
			      <tr>
			       
			        <th>DATE</th>
			        <th>ISSUES</th>
			        <th>MEDICINES</th>
			        <th>AMOUNT</th>
			        <th>BALANCE</th>
			        <th>BAL. UPDATE</th>
			      </tr>
			    </thead>
			    <tbody>
			<c:forEach items="${sessions }" var="s">
				   <tr>
			       
			        <td><c:out value="${s.getDate()}"/></td>
			        <td><c:out value="${s.getIssues()}"/></td>
			        <td><c:out value="${s.getMedicines() }"/></td>
			        <td><c:out value="${s.getAmount()}"/></td>
			        <td><c:out value="${s.getBalance() }"/></td>
			        <td><a href="changeBalance?id=${s.getId()}">change</a></td>
			        
			      </tr>
			</c:forEach>
			</tbody>
  </table>
       
			<h3>Today's Patient diagnosis:</h3>
			<sf:form method="post" onsubmit="return alertMsg();"   action="${pageContext.request.contextPath}/process-diagnosis" modelAttribute="sessionInfo">
			<font color="black" style="font-weight: bold;">
			Issues:
			</font>
			<br>
			<sf:textarea cols="40" rows="8" path="issues"/>
			<br><br><br>
			<font color="black" style="font-weight: bold;">
			Medicines:</font>
			<BR>
			<sf:textarea cols="40" rows="4" path="medicines"/>
			<br><br><br>
			<font color="black" style="font-weight: bold;">
			Total Amount:</font>
			<sf:input type="number" path="amount"/>
			<br><br><br>
			<font color="black" style="font-weight: bold;">
			Balance (if any):</font>
			<sf:input type="number" path="balance"/>
			<br><br>
			<c:forEach items="${list }" var="p">
			<input type="hidden" name="id" value="<c:out value="${p.getId()}"/>"/>
			</c:forEach>
			<input id="submitbutton" type="submit" value="SUBMIT" />
			
			</sf:form>
	    
	    
	    
	    </div>
	    
	    <div class="col-lg-2">
	    </div>















</body>
</html>