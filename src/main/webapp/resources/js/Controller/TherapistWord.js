function sendAjaxWord(wordsId) 
{
		var obj = {
			"wordsId" : wordsId,
		}
		$.ajax(
				{
			url : "SetWordsId",
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