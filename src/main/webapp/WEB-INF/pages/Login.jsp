<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <!-- <link rel="stylesheet" href="static/css/style.css"> -->
  
    <script src='static/js/jquery.js'></script>
  <!-- <script  src="static/js/index.js"></script> -->
  <!-- <script  src="static/js/login.js"></script> -->
  
</head>
<body>
<form:form action="login" method="post">
  <table>
  	<tr>
  		<td><label>Enter User Name</label></td>
  		<td><input type="text" name="email"/></td>
  	</tr>
    <tr>
  		<td><label>Enter Password</label></td>
  		<td><input type="password" name="password"/></td>
  	</tr>
  	<tr>
  		<td><button type="submit">Login</button></td>
  	</tr>
  </table>
</form:form>
  <c:if test="${invalid != null }">
  	${invalid}
  </c:if>
  
</body>
</html>
