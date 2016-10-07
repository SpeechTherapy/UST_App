function sendAjax(sentencesId) 
{
		var obj = {
			"sentencesId" : sentencesId,
		}
		$.ajax(
				{
			url : "SetSentencesId",
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