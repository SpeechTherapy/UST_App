function DeactivateSentences(sentencesId,isActive) {
		var obj = {
			"sentencesId" : sentencesId,
			"isActive": isActive
		}
		$.ajax({
			url : "DeactivateSentences",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) {
			alert(response.header.message);
            window.location='SentencesAdminLesson'

			},

		});
	}
	
function ajaxCall(){

    var data = new FormData();
    var formFiles = $('input[type=file]');
    data.append('image', formFiles[0].files[0]);
    data.append('audio', formFiles[1].files[0]);
    data.append('name',$('input[name=SentencesName]').val());

    console.log("form data " + data);

    $.ajax({
        url: 'sentences',
        cache:false,
        processData:false,
        contentType:false,
        data:data,
        type: 'POST',
        success: function(response){
            if(response.statusCode==200){
                alert(response.message);
            }else{
                window.location='SentencesAdminLesson'
            }
        }
    });

}

