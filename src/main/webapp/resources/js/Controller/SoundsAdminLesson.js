function submit(){    var data = new FormData();    var formFiles = $('input[type=file]');/*    data.append('image', formFiles[0].files[0]);*/    data.append('audio', formFiles[0].files[0]);    data.append('name',$('input[name=SoundName]').val());    console.log("form data " + data);    $.ajax({        url: 'sounds',           cache:false,        processData:false,        contentType:false,        data:data,        type: 'POST',        success: function(response){            if(response.statusCode==200){                alert(response.message);            }else{                window.location='SoundsAdminLesson'            }        }    });} function DeactivateSounds(soundsId,isActive) { var obj = {  "soundsId" : soundsId,  "isActive": isActive } $.ajax({  url : "DeactivateSounds",  type : "POST",  dataType : "json",  contentType : "application/json",  data : JSON.stringify(obj),  success : function(response) {  alert(response.header.message);  window.location='SoundsAdminLesson'  } });}