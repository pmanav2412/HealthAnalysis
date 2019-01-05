<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
    background-color: white;
    height: 150%;
}

footer {
    padding: 1em;
    color: white;
       bottom: 30px;
       position: fixed;
    background-color: black;
    clear: left;
    text-align: center;
      width: 100%;
}
html {
    position: relative;
    min-width: 1024px;
    min-height: 768px;
    
}
home {
    height: 800px;
    width: 50%;
    background-color: powderblue;
}
user2{
 background-color: white;
 color:"#FFFFFF";
}

</style>

</head>
<body>
<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="user1" class="navbar-brand"> HEALTH ANALYSIS</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				
				
				<li> <a href ="/show-events1234"> All Events</a></li>
					<li> <a href ="/enrolevent">Enrolled Events</a></li>
				   <li> <a href ="/showex">MY EXERCISE</a></li>
				</ul>		
				<div class="nav navbar-nav navbar-right">
               <a href="/logout" class="navbar-brand"><strong>Logout</strong></a>
           
		</div>
	</div>
	</div>
	</div>
<div class="container text-center">
		<h3>Exercise Registration</h3>
		<hr>
<form class="form-horizontal" method="POST" action="/exadd">

			<div class="form-group">
				<label class="control-label col-md-3">Exercise Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="exname1" />
				</div>
			</div>
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Register" />
			</div>
		</form>
</div>
</body>
</html>