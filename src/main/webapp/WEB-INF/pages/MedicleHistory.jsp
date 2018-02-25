<!DOCTYPE html>
<html>
<head>
	<title>Medicle History.</title>
</head>
<body>
<% if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>
</body>
</html>