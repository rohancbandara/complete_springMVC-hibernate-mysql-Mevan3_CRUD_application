<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration</title>

  <script src='static/js/jquery.js'></script>
  <script  src="static/js/register.js"></script>

</head>
<body>

	<table>
		<tr>
			<td><label>First Name :</label></td>
			<td><input type="text" id="first_name"/></td>
		</tr>
		<tr>
			<td><label>Last Name :</label></td>
			<td><input type="text" id="last_name"/></td>
		</tr>
		<tr>
			<td><label>Email :</label></td>
			<td><input type="text" id="email"/></td>
		</tr>
		<tr>
			<td><label>User Name :</label></td>
			<td><input type="text" id="user_name" /></td>
		</tr>
		<tr>
			<td><label>Password :</label></td>
			<td><input type="password" id="password"/></td>
		</tr>
		<tr>
			<td><button onclick="clearFileds()">Clear</button></td>
			<td><button onclick="register()">Register</button></td>
		</tr>
	</table>
	<input type="hidden" id="userId"/>
	
	
	<table border="1" class="tble">
		<thead>
			<tr>
				<td>Full Name</td>
				<td>User Name</td>
				<td>Email</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody id="userTableBody" class="tble">
		</tbody>
	</table>
	
</body>
</html>