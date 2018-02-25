$(document).ready(function(){
	
	
})

function docterRegister(d_id){
	
	
}

function clearFileds(){

	$('#txtEmail').val('');
	$('#txtFname').val('');
	$('#txtLname').val('');
	$('#special').val('');
	
}

function registerDocter() {
	
	var dEmail = $('#txtEmail').val();
	var dFName = $('#txtFname').val();
	var dLName = $('#txtLname').val();
	var dSpecile = $('#special').val();
	
	
	var requestObj = {
			
			"dfirstName":dFName,
			"dlastName":dLName,
			"demail":dEmail,
			"dspecile":dSpecile,
			
		}
	
	$.ajax({ 
	    url: 'api/docter/saveUpdate',    
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
	    		
	    		alert("Successfully Registered.")
	    		clearFileds();
	    		
	    	}  
	    },
	    error: function(data){
	    	console.log(data.success);
	    }
	});
}