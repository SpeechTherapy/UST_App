function Assignment(patientId,lessonId) {
		var obj = {
			"patientId" : patientId,
			"lessonId" : lessonId 
			
		}
		alert("Patientid" + " "+ patientId+ " "+"LessonID"+ " " + lessonId);

		$.ajax({
			url : "AssignLesson",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) {
			alert(response.header.message);

			}

		});
	}
	