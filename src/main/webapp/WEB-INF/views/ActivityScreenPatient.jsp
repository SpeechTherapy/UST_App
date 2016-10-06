<%@ page language="java" contentType="text/html;UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Activity Screen</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
 
 
   <link rel="stylesheet" href="style.css" />
<script src="progress.js" ></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<style>
.recoder {
	margin-left:5%;
}
div.img {
    margin: 1px;
    
    float: left;
    width: 180px;
	margin-left: 25%;
}
div .plus {
margin: 1px;
    
    float: left;
    width: 180px;
	

}







button {
margin-left: 10%;
width:150px;
height:50px;
background:#181818;
color:#FFF;
margin-top:-3%;
}

button:hover {
background-color:#ff0040;
color:#fff;
}

#panel {
   
    text-align: center;
    background-color: #e5eecc;
    border: solid 1px #c3c3c3;
	float:right;
	margin-right:6%;
	width:230px;
	height:80px;
}

#panel {
   padding:10px;
    display: none;
	position:fixed;
	
	
}

</style>


   

  
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper" style="background:#333;" >

 
  <div class="content-wrapper" style="height:100%; background-color:#333; ">
    
    <br> 
    	         <div style="float: left; margin-left: 10%; margin-top:2%;">
 <a href="/ust/PatientWord">
 <i class=" fa fa-arrow-left fa-3x">&nbsp;&nbsp;&nbsp;</i></a>
 <a href="/ust/user/WelcomePatient"><i class=" fa fa-home fa-3x">&nbsp;&nbsp;&nbsp;</i></a>
 <a href="/ust/ActivityScreenPatient"><i
  class=" fa fa-arrow-right fa-3x"></i></a>
</div>
		   
			
      

<div class="img" style="margin-left:5%; margin-top:3%;">
  <img style="width:270%; height:250%;" src="/ust/${mediaImage}" name="imgbox" id="imgbox">
</div>
<div style="float:right; margin-right:25%; margin-top:7%;">
<i class="fa fa-check fa-5x" style="color:red; width:20%;"></i><br>
<i class="fa fa-check fa-5x" style="color:red; width:20%;"></i><br>
<i class="fa fa-check fa-5x" style="color:red; width:20%;"></i><br>
</div>
  



<div style="float:right; margin-right:-5%; margin-top:25%;">
<a onclick="sendAjax(1)"><i class="fa fa-microphone fa-5x" style="color:red width:20%;"></i></a>
</div>

<div style="float:right; margin-right:-20%; margin-top:30%;">
<audio src="/ust/${mediaAudio }" controls="true" loop="true" autoplay="false" ></audio>

</div>
</div>
            <!-- /.box-body -->
         </div></div> 
         <script type="text/javascript" src="/ust/resources/js/Controller/ActivityAjax.js"></script>
  
<!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <link rel="stylesheet" href="/ust/resources/components/Therapist/bootstrap/css/bootstrap.min.css">
 
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/dist/css/skins/_all-skins.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/iCheck/flat/blue.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/morris/morris.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
  <!-- Date Picker -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/datepicker/datepicker3.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<!-- Slimscroll -->
<script src="/ust/resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/ust/resources/components/Therapist/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="/ust/resources/components/Therapist/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/ust/resources/components/Therapist/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/ust/resources/components/Therapist/dist/js/demo.js"></script>

</body>
</html>
