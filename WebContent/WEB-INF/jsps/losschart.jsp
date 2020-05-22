<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOSS ANALYSIS</title>
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
   margin-top:10%;
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
margin:1%;
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
#piechart{
margin-bottom:10%;
padding:1%;
}
#leftblock{
background-color: white;
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
  padding: 4px;
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
</head>
<body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">  
var final_data=[] 
	function loadIncomeData() {
	var months=["January","February","March","April","May", "June", "July", "August", "September", "October", "November", "December"];
    var income=[];
		for(var i=0;i<months.length;i++){
			var value=(document.getElementById(months[i]).value);
			//console.log(typeof value)
			//console.log(value)
			var flo=parseFloat(value);
			//var c = parseFloat(divs)
			income.push(flo);
		}
		for(var i =0;i<months.length;i++){
			var data_point=[]
			data_point.push(months[i]);
			data_point.push(income[i]);
            final_data.push(data_point);
		}
		//console.log([final_data]);
    }
    
    
    
    
		function loadLossData() {
			var months=["Januaryl","Februaryl","Marchl","Aprill","Mayl", "Junel", "Julyl", "Augustl", "Septemberl", "Octoberl", "Novemberl", "Decemberl"];
		    var loss=[];
				for(var i=0;i<months.length;i++){
					var value=(document.getElementById(months[i]).value);
					//console.log(typeof value)
					//console.log(value)
					var flo=parseFloat(value);
					//var c = parseFloat(divs)
					income.push(flo);
				}
				for(var i =0;i<months.length;i++){
					var data_point=[]
					data_point.push(months[i]);
					data_point.push(income[i]);
		            final_data.push(data_point);
				}
				//console.log([final_data]);
		    }
 
    
		// Load google charts
		google.charts.load('current', {'packages':['corechart']});
		google.charts.setOnLoadCallback(drawChart);

		// Draw the chart and set the chart values
		function drawChart() {
          console.log(final_data)
		  var data = google.visualization.arrayToDataTable([
		  	['Task', 'Income'],
		  	
            final_data[0],
            final_data[1],
            final_data[2],
            final_data[3],
            
            final_data[4],
            final_data[5],
            final_data[6],
            final_data[7],
            
            final_data[8],
            final_data[9],
            final_data[10],
            final_data[11]

		  	]);

		  // Optional; add a title and set the width and height of the chart
		  var options = {
		  	'title':'LOSS DISTRIBUTION',  
		  	hAxis: {
      			title: 'Loss(in rupees)'
   		  	},
     		vAxis: {
      			title: 'Months'
   	 		},
   	 		
    		'width':650, 'height':500};

		  // Display the chart inside the <div> element with id="piechart"
		  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
		  chart.draw(data, options);
		}
			
</script>
</head>
</head>

<body onload="loadIncomeData()">
<div class="topnav">
  
  <a href="logout" id="logout">Log-out</a>
  <a  href="home">Home</a>
  <a href="register">Add New Patient</a>
  <a href="update-page">Update Patient</a>
  
  <a id="active-link" href="#">Track Income</a>
  
</div>
<br>
<br>
<p align="center" style="font-size: 35px; font-weight: bold; margin:0%;">LOSS ANALYSIS</p>
<div class="contain">
		<div class="col-lg-2" align="center" id="leftblock">
		<br>
		<br>
			<font color="green" style="font-weight: bold;"><u>QUICK STATS</u></font><br><br>
			<font color="black" style="font-weight: bold;">TODAY'S INCOME:</font>
			<br>
			<font color="red" style="font-weight: bold;">
			<c:out value="${todays_income }"/></font>
			<br>
			<br>
			<font color="black" style="font-weight: bold;">THIS MONTH:</font>
			<br>
			<font color="red" style="font-weight: bold;">
			<c:out value="${month_income }"/></font>
			<br><br>
			<font color="blue" style="font-weight: bold;">
			<a href="track-income">MONTHLY INCOME</a></font>
			<br><br>
			<font color="blue" style="font-weight: bold;">
			<a href="#">MONTHLY LOSS</a></font>
			<br>
		
		<br>
	    </div>
		<div class="col-lg-8" align="center">
		<div id="piechart"></div>
	    </div>
	    
	    <div class="col-lg-2" align="center">
	    
	    <table align="center" id="subjects">
			    <thead>
			      <tr>
			       
			        <th>Loss incurred(by month)</th>
			      </tr>
			    </thead>
			    <tbody>
				<c:forEach items="${income }" var="s">
				   <tr>
			       		
			        <td><c:out value="${s}"/></td>
			        
			      </tr>
				</c:forEach>
			</tbody>
 		 </table>		
	    </div>
	    
	    
	    
</div>
			<input type="hidden" id="January" value="<c:out value="${income[0]}"/>">
			<input type="hidden" id="February" value="<c:out value="${income[1]}"/>">
			<input type="hidden" id="March" value="<c:out value="${income[2]}"/>">
			<input type="hidden" id="April" value="<c:out value="${income[3]}"/>">
			<input type="hidden" id="May" value="<c:out value="${income[4]}"/>">
			<input type="hidden" id="June" value="<c:out value="${income[5]}"/>">
			<input type="hidden" id="July" value="<c:out value="${income[6]}"/>">
			<input type="hidden" id="August" value="<c:out value="${income[7]}"/>">
			<input type="hidden" id="September" value="<c:out value="${income[8]}"/>">
			<input type="hidden" id="October" value="<c:out value="${income[9]}"/>">
			<input type="hidden" id="November" value="<c:out value="${income[10]}"/>">
			<input type="hidden" id="December" value="<c:out value="${income[11]}"/>">
<div class="footer">
  <p>Copyright &copy; Aryak's Medical Portal 2020 | MADE BY: Aryak Deshpande</p>
</div>

</body>
</html>