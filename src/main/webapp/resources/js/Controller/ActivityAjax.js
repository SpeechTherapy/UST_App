function sendAjax(Yes) 
{
  var obj = {
   "Yes" : Yes,
  }
  alert("Recording has been started..");
  $.ajax(
    {
   url : "AudioRecorder",
   type : "POST",
   dataType : "json",
   contentType : "application/json",
   data : JSON.stringify(obj),
   success : function(response) 
   {
   alert("Recording has been saved");
   },
  }
    );
 
}