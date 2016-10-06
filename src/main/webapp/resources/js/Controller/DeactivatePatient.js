function sendAjaxDeactivateButton(patientId,isActive) {
		var obj = {
			"patientId" : patientId,
			"isActive" :isActive
		}
		$.ajax({
			url : "DeactivateButton",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) {
				alert(response.header.message);
                window.location='PatientListAdmin'


			},

		});
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