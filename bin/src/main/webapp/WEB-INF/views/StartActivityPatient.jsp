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

.snip1344 {
  font-family: 'Open Sans', Arial, sans-serif;
  position: fixed;
  float: left;
  overflow:hidden;
  margin: 20px ;
  
  min-width: 170px;
  max-width: 270px;
  width: 100%;
  height:60%;
  color: #ffffff;
  text-align: center;
  line-height: 1.4em;
  background-color: #141414;
}
.snip1344 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
}
.snip1344 .background {
  width: 100%;
  vertical-align: top;
  opacity:0.1;
  -webkit-filter: grayscale(100%) blur(10px);
  filter: grayscale(100%) blur(10px);
  -webkit-transition: all 2s ease;
  transition: all 2s ease;
}
.snip1344 figcaption {
  width: 100%;
  padding: 15px 25px;
  position: absolute;
  left: 0;
  top: 50%;
}
.snip1344 .profile {
  border-radius: 50%;
  position: absolute;
  bottom: 50%;
  left: 50%;
  max-width: 100px;
  opacity: 1;
  box-shadow: 3px 3px 20px rgba(0, 0, 0, 0.5);
  border: 2px solid rgba(255, 255, 255, 0.5);
  -webkit-transform: translate(-50%, 0%);
  transform: translate(-50%, 0%);
}
.snip1344 h3 {
  margin: 0 0 5px;
  font-weight: 400;
}
.snip1344 h3 span {
  display: block;
  font-size: 0.6em;
  color: #f39c12;
  opacity: 0.75;
}
.snip1344 i {
  padding: 10px 5px;
  display: inline-block;
  font-size: 32px;
  color: #ffffff;
  text-align: center;
  opacity: 0.65;
}
.snip1344 a {
  text-decoration: none;
}
.snip1344 i:hover {
  opacity: 1;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}
.snip1344:hover .background,
.snip1344.hover .background {
  -webkit-transform: scale(1.3);
  transform: scale(1.3);
}
   .modalDialog200 {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0,0,0,0.8);
	z-index: 99999;
	opacity:0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}



.modalDialog200:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog200 > div {
	
	width: 25%;
	height:70%;
	position: relative;
	margin: 10% auto;
	padding: 10px 40px 30px 20px;
	border-radius: 10px;
	background: #000;
	background: -moz-linear-gradient(#353535, #000);background: -webkit-linear-gradient(#353535, #000);
	background: -o-linear-gradient(#353535, #000);
}


.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.close {
	background:#000;
	color: #FFFFFF;
	line-height: 25px;
	position: absolute;
	right: -12px;
	text-align: center;
	top: -10px;
	width: 24px;
	text-decoration: none;
	font-weight: bold;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	border-radius: 12px;
	-moz-box-shadow: 1px 1px 3px #000;
	-webkit-box-shadow: 1px 1px 3px #000;
	box-shadow: 3px 2px 3px #000;
}

.close:hover { background: #00d9ff; }



-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;
</style>




   

  
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper" style="background:#333;" >

<header class= "main-header" style="background:#333;  " onmouseover="this.style.opacity='1'; " onmouseout="this.style.opacity='0.0';" >    <!-- Logo -->
    
    <!-- Header Navbar: style can be found in header.less -->
   <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav"> 
          <li class="treeview">
          <a href="/ust/user/WelcomePatient">
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
                            <li><a href="/ust/LessonsPatient"> <i class="fa fa-user"></i> View Lessons</a></li>
                            
  
</ul></li>
		  <li class="treeview">
          <a href="#openModal500">
            <i class="fa fa-heartbeat"></i>
            <span>Therapist Info</span>
           </a></li>
		 <li class="treeview">
          <a href="/ust/Report">
            <i class="fa fa-file-text-o"></i>
            <span>My Report</span>
                     </a>
			 <li class="treeview">
         
					 <li class="treeview">
          <a href="/ust/PatientBlog">
            <i class="fa fa-feed"></i>
            <span>Blog</span>
                    </a>
 <li class="treeview">
          <a href="AboutPatient">
            <i class="glyphicon glyphicon-exclamation-sign"></i>
            <span>About</span>
           </a>          
			<li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/ust/${userPic}" class="user-image" alt="User Image">
              <span class="hidden-xs">${patientName }</span></a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="/ust/${userPic}" class="img-circle" alt="User Image">
                <p>
                  ${patientName } - Patient
                  <small>Member since ${createdOn}</small>
                </p>
              <li class="user-footer">
                <div class="pull-left">
                <a href="#openModal600"><button  class="btn btn-default" style="margin:2%;">Profile</button></a>
                  </div>
                  <div class="pull-right">
                  <a href="logout" class="btn btn-default btn-flat" style="margin-top:-1%; float:right; margin-right:-90%;">Sign out</a>
                </div>
                </li>
              </li>
            </ul>
            
            <!-- therapist info popup -->

          
     
    </nav>
  </header>
  <div id="openModal600" class="modalDialog9900">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		
                  
                   <figure class="snip1344">
                    <a  class="fa fa-edit fa-2x" style="margin-left:80%; margin-top:-60%; color:#0066FF;
   background-color:transparent; border:hidden;" href="/ust/Patientprofile" target="_blank">  </a>
                   <img src="/ust/${userPic}" alt="profile-sample1" class="profile"/>
  <figcaption>
 
    <h3>${patientName } 
    <span>Patient</span>
    <br>
        <span>${guradianName}</span>
    
    <span>${contactNo }</span>
    <span>${email}</span>
    </h3>
  </figcaption>
</figure>
                
                </div></div></div>       
            
            
            
            
<div id="openModal500" class="modalDialog200">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		
                  
                   <figure class="snip1344"><img src="" alt="profile-sample1" class="background"/>
                    
                   <img src="/ust/${UserPic}" alt="profile-sample1" class="profile"/>
  <figcaption>
 
    <h3>${therapistName } 
    <span>Therapist</span>
    <br>
    <span>${Hospital }</span>
    <span>${contactNo}</span>
    <span>${Email}</span>
    </h3>
  </figcaption>
</figure>
                
                </div></div></div>
              
   <div class="content-wrapper" style="height:75%;">
    <br> 
		    <div class="box box-info" style="border-top:4px solid #333; border-left:4px solid #333; border-right:4px solid #333; border-bottom:4px solid #333; width:auto; background-color:#333;  height:auto; margin-top:-2%;  ">
          <div class="box-body" style="width:100%; height:75%;"> 
			
      

<div class="img" style="margin-left:30%; margin-top:10%;">
  <img style="width:100%; height:100%;background:white;" src="/ust/${lessonPic}" name="imgbox" id="imgbox">
</div>





<div style="float:right; margin-right:15%; margin-top:15%;">
<a onclick="sendAjax(1)"><i class="fa fa-microphone fa-5x" style="color:red width:20%;"></i></a>
</div>



<iframe width="560" height="315" src="${videoRefrence}" frameborder="0" border="white" ></iframe>



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
