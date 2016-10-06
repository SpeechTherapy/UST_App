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

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<style>


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

 <header class= "main-header" style="background:#333;  " onmouseover="this.style.opacity='1'; " onmouseout="this.style.opacity='0.0';" >
 
   <nav class="navbar navbar-static-top">


      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav"> 
          <li class="treeview">
          <a href="/ust/user/WelcomeTherapist">
            <i class="glyphicon glyphicon-home"></i>
            <span>Home</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right"></span></span></a></li>
<li class="treeview">
          <a href="/ust/info/Articulation">
            <i class="fa fa-info-circle"></i>
            <span>Articulation</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right"></span></span></a></li>
		  
		    <li class="dropdown" user-dropdown>
  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text-o"></i> Lessons <b class="caret"></b>
<ul class="dropdown-menu" style="overflow:visible;">
                            <li><a href="/ust/user/Lessons"> <i class="fa fa-user"></i> View Lessons</a></li>
                            
    <li class="divider"></li>
                            <li><a href="/ust/user/AssignedLessonList"> <i class="fa fa-power-off"></i> Assigned Lessons</a></li>
</ul></li>

		  <li class="treeview">
          <a href="/ust/Assignment">
            <i class="fa fa-heartbeat"></i>
            <span>Patients</span>
           </a></li>
		 <li class="treeview">
          <a href="/ust/List">
            <i class="fa fa-file-text-o"></i>
            <span>Reports</span>
                     </a>
			 <li class="treeview">
          <a href="#">
            <i class="fa fa-comments-o"></i>
            <span>Discussion</span>
                    </a>
					 <li class="treeview">
          <a href="/ust/BlogPost">
            <i class="fa fa-feed"></i>
            <span>Blog</span>
                   </a>
 <li class="treeview">
          <a href="About.html">
            <i class="glyphicon glyphicon-exclamation-sign"></i>
            <span>About</span>
            </a>          
			<li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="user2-160x160.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">Shanza Khan</span></a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="user2-160x160.jpg" class="img-circle" alt="User Image">
                <p>
                   Shanza Khan - Therapist
                  <small>Member since Nov. 2016</small>
                </p>
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                     
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
       </li>
			  </li>
              </ul>
              
          
            
       
      </div>
    </nav></header>
    
   <div class="content-wrapper" style="height:75%;">
    <br> 
		    <div class="box box-info" style="border-top:4px solid #333; border-left:4px solid #333; border-right:4px solid #333; border-bottom:4px solid #333; width:auto; background-color:#333;  height:auto; margin-top:-2%;  ">
          <div class="box-body" style="width:100%; height:75%;"> 
			
      

<div class="img" style="margin-left:30%; margin-top:3%;">
  <img style="width:270%; height:250%;" src="/ust/${mediaImage}" name="imgbox" id="imgbox">
</div>

  



<div style="float:right; margin-right:15%; margin-top:15%;">
<a onclick="sendAjax(1)"><i class="fa fa-microphone fa-5x" style="color:red width:20%;"></i></a>
</div>
<div style="float:right; margin-right:-15%; margin-top:20%;">
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
