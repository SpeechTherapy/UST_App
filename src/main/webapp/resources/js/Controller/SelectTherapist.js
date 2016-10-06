function selectTherapist(therapistId) 
{
		var obj = {
			"therapistId" : therapistId,
		}
		$.ajax(
				{
			url : "SetTherapistId",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) 
			{
			alert("Done");
			},
		}
				);
	
}