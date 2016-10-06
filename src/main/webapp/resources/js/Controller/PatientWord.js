function sendAjaxWord(WordsID) 
{
		var obj = {
			"WordsID" : WordsID,
		}
		$.ajax(
				{
			url : "WordsId",
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