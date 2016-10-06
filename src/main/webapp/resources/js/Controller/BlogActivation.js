function sendButton(postId,isActive) {
		var obj = {
			"postId" : postId,
			"isActive" :isActive

		}

		$.ajax(
				{
			url : "Button",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response)
			{
				alert(response.header.message);
                window.location='AdminBlog'


			},

		});
	}
