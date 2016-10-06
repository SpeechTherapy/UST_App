function Treport(patientId) 
{
		var obj = {
			"patientId" : patientId,
		}
		$.ajax(
				{
			url : "SetPatientId",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) 
			{
			//alert(response.header.message);
			},
		}
				);
	
}

function TassignedId(assignedId) 
{
		var obj = {
			"assignedId" : assignedId,
		}
		$.ajax(
				{
			url : "SetAssignedId",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) 
			{
			//alert(response.header.message);
			},
		}
				);
	
}