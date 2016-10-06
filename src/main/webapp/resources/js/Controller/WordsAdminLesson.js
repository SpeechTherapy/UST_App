function DeactivateWords(wordsId,isActive) {
		var obj = {
			"wordsId" : wordsId,
			"isActive": isActive
		}
		$.ajax({
			url : "DeactivateWords",
			type : "POST",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(obj),
			success : function(response) {
				alert(response.header.message);

                window.location='WordsAdminLesson'

			},

		});
	}
	
function ajax(){

    var data = new FormData();
    var formFiles = $('input[type=file]');
    data.append('image', formFiles[0].files[0]);
    data.append('audio', formFiles[1].files[0]);
    data.append('name',$('input[name=wordName]').val());

    console.log("form data " + data);

    $.ajax({
        url: 'uploadWord',
        cache:false,
        processData:false,
        contentType:false,
        data:data,
        type: 'POST',
        success: function(response){
            if(response.statusCode==200){
                alert(response.message);
            }else{
                window.location='WordsAdminLesson'
            }
        }
    });

}
