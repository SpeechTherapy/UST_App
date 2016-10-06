function sendAjax(lessonId) 
{
		var obj = {
			"lessonId" : lessonId,
		}
		$.ajax(
				{
			url : "SetLessonId",
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


function sendId(patientId) {
	var obj = {
		"patientId" : patientId,
	}
	$.ajax({
		url : "Patient",
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(obj),
		success : function(response) {
		alert(response.header.message);
		},

	});
}