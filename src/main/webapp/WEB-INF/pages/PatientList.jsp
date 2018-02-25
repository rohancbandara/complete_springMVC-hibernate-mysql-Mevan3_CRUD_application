<!DOCTYPE html>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.rcb.dbconnection.DbConnection"%>
<%@page import="com.rcb.model.Patient"%>
<html>
<head>
	<title>Patient list</title>
</head>
<body>
<%
//hadaling back -----
response.setHeader("Cache-Control", "no-Cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");


if(session.getAttribute("username")==null){
	response.sendRedirect("index.jsp");
}

%>
<h3>Welcome :${username }        <a href="login">logout</a></h3>

	<form action="PatientAdd.jsp" method="get">
		<label>Patient:</label>
		<input type="text" name="patient" id="patient">
		<input type="submit" name="btnSearch" id="btnAddNewPatient" value="Add New Patient" >

		<table border="1">
				<th scope="col">PID</th><th scope="col">Patient Name</th><th scope="col">NIC</th><th scope="col">Email</th><th scope="col">Gender</th><th scope="col">Date of Birth</th><th scope="col">Blood Group</th>
				<th scope="col">Marital</th><th scope="col">Address</th><th scope="col">Contact</th><th scope="col">Status</th><th  scope="col">Create Date</th><th colspan="2" scope="col">Action</th>
			
			<%
	Patient patient=new Patient();
	DbConnection db=new DbConnection();
	String p_fname,p_lname,p_nic,p_email,p_gender,p_dob,p_blood_group,p_marital,p_haddress,p_tel,p_status,create_date;
	int id;
	try{
		String sql="SELECT * FROM tbl_patient";
		ResultSet rs=db.getData(sql);
		while(rs.next()){
			id=rs.getInt("p_id");
			p_fname=rs.getString("p_fname");
			p_lname=rs.getString("p_lname");
			p_nic=rs.getString("p_nic");
			p_email=rs.getString("p_email");
			p_gender=rs.getString("p_gender");
			p_dob=rs.getString("p_dob");
			p_blood_group=rs.getString("p_blood_group");
			p_marital=rs.getString("p_marital");
			p_haddress=rs.getString("p_haddress");
			p_tel=rs.getString("p_tel");
			p_status=rs.getString("p_status");
			create_date=rs.getString("create_date");
			
		
			%>
			<tr>
				<td><%=id %></td>
				<td><%=p_fname %> <%=p_lname %></td>
				<td><%=p_nic %></td>
				<td><%=p_email %></td>
				<td><%=p_gender %></td>
				<td><%=p_dob %></td>
				<td><%=p_blood_group %></td>
				<td><%=p_marital %></td>
				<td><%=p_haddress %></td>
				<td><%=p_tel %></td>
				<td><%=p_status %></td>
				<td><%=create_date%></td>
				<td><a href="/Medicle_Record_System/setpid?id=<%=id %>">Edit</a></td>
				<td><a href="/Medicle_Record_System/patientDelete?id=<%=id %>">Delete</a></td>
				
		    </tr>
			<%
		}
	}
	catch(Exception e){
		e.printStackTrace();
		}

%>	
		</table>


	</form>

                            
</body>
</html>