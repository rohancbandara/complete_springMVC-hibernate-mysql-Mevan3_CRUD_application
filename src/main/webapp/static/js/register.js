$(document).ready(function() {
	//clear();
	getAll();
})

function userEdit(user_id) {
	clearFileds();
	$('#userId').val(user_id);
	getById();
	$('.tble').hide();
}

function userDelete(user_id) {
	$.ajax({
		  url: "api/user/delete?userId="+user_id,
		  type: "DELETE",
		  data: {},
		  success: function(data) {
				getAll();
		  },
		  error: function(xhr) {
		    alert("Error");
		  }
	});
}

function register() {
	
	var userId = $('#userId').val() == '' ? -1: $('#userId').val();
	var firstName = $('#first_name').val();
	var lastName = $('#last_name').val();
	var userName = $('#user_name').val();
	var email = $('#email').val();
	var password = $('#password').val();
	
	var requestObj = {
			"userId":userId,
			"firstName":firstName,
			"lastName":lastName,
			"email":email,
			"userName":userName,
			"password":password
		}
	
	$.ajax({ 
	    url: 'api/user/saveUpdate',    
	    type: "POST", 
	    headers: { 
	        'Accept': 'application/json', 
	        'Content-Type': 'application/json' 
	    },
	    dataType:"json",
	    data: JSON.stringify(requestObj), //Stringified JSON Object

	    success: function(data) {  
	    	if(!data.success) {
	    		alert(data.statusList);	
	    	} else {
	    		$('#userId').val('');
	    		alert("Successfully Registered.")
	    		clearFileds();
	    		getAll();
	    	}  
	    },
	    error: function(data){
	    	console.log(data.success);
	    }
	});
}

function clearFileds(){

	$('#first_name').val('');
	$('#last_name').val('');
	$('#user_name').val('');
	$('#email').val('');
	$('#password').val('');
}

function getById () {
	var userId = $('#userId').val();
	$.ajax({
		  url: "api/user/get",
		  type: "GET",
		  data: { 
			 userId: userId
		  },
		  success: function(data) {
			  setValuesToInput(data.response);
		  },
		  error: function(xhr) {
		    alert("Error");
		  }
		});
}

function setValuesToInput (user) {
	$('#first_name').val(user.firstName);
	$('#last_name').val(user.lastName);
	$('#user_name').val(user.userName);
	$('#email').val(user.email);
	$('#password').val(user.password);
}

function getAll () {
	$.ajax({
		  url: "api/user/getAll",
		  type: "GET",
		  data: {},
		  success: function(data) {
			  setUserList(data.response);
		  },
		  error: function(xhr) {
		    alert("Error");
		  }
		});
}

function setUserList (userList) {
	 $('.tble').show();
	 $('#userTableBody').empty();
	 $.each(userList, function (index, user){
		 $('#userTableBody').append(
				"<tr>" +
					"<td>"+user.firstName+" "+user.lastName+"</td>"+
					"<td>"+user.userName+"</td>"+
					"<td>"+user.email+"</td>"+
					"<td><button onclick='userEdit("+user.userId+")'>Edit</button><button onclick='userDelete("+user.userId+")'>Delete</button></td>"+
		 		"</tr>"
		 	);
	 });
}
