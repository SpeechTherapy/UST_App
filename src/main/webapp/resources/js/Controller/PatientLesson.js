function sendAjax(AssignedLessonId) 
{
		var obj = {
			"AssignedLessonId" : AssignedLessonId,
		}
		$.ajax(
				{
			url : "SetId",
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