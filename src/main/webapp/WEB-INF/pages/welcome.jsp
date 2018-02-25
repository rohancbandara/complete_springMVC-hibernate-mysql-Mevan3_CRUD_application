<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	<!-- <link rel="stylesheet" href="static/css/style.css"> -->

	<script src='static/js/jquery.js'></script>
	<!-- <script  src="static/js/index.js"></script> -->
	<!-- <script  src="static/js/login.js"></script> -->

</head>
<body>
<h1>*****Welcome Page*****</h1>
<form >
	<table>
		<tr >
			<td width="50%">
				<a href="/RCB_SpringMVC/log">User Login</a>
			</td>

		</tr>

		<tr>
			<td width="50%">
			<a href="/RCB_SpringMVC/registration">User Registration</a>
			</td>
		</tr>

	</table>
</form>
</body>
</html>
