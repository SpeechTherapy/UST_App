

function Therapist(therapistId) {
	alert(therapistId);
	var obj = {
		"therapistId" : therapistId,
		
	}
	$.ajax({
		url : "SetTherapist",
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(obj),
		success : function(response) {
		alert(response.header.message);

		},

	});
}