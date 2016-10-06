function sendAjaxDeactivate(therapistId,isActive) {
		var obj = {
			"therapistId" : therapistId,
			"isActive" : isActive
		}
		$.ajax({
			url : "Deactivate",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) {
			alert(response.header.message);
            window.location='TherapistListAdmin'

			},

		});
	}

function sendId(therapistId) {
	var obj = {
		"therapistId" : therapistId,
	}
	$.ajax({
		url : "Therapist",
		type : "POST",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(obj),
		success : function(response) {
		alert(response.header.message);
		},

	});
}
	