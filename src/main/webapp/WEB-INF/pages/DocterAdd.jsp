<!DOCTYPE html>

<html>
<head>
 <script src='static/js/jquery.js'></script>
  <script  src="static/js/docterRegister.js"></script>
	<title>Add Docter</title>
</head>
<body>

<h3>Welcome :${username }        <a href="login">logout</a></h3>




<h3>Basic Info</h3>
		 <label >Email </label>
            <input name="txtEmail" type="text" id="txtEmail"  placeholder="Email" /><br>
		 <label >First Name </label>
            <input name="txtFname" type="text" id="txtFname"  placeholder="First Name" /><br>
         <label >Last Name </label>
            <input name="txtLname" type="text" id="txtLname"  placeholder="Last Name" /><br>
         <label >Special </label>
            <select name="special" id="special" >
				<option value="0">-Select Special-</option>
				
			
			</select><br>
         
          <button onclick="registerDocter()">Register</button>
         <button onclick="clearFileds()">Clear</button>
		 
		 







</body>
</html>