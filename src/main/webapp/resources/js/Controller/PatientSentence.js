function sendAjax(SentencesID) 
{
		var obj = {
			"SentencesID" : SentencesID,
		}
		$.ajax(
				{
			url : "SentencesID",
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