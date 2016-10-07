<%@ page language="java" contentType="text/html;UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <%@ include file="PatientCss.jsp" %> 

<style>
 body {
  font-family: Arial, sans-serif;

  background-size: cover;
  height: 100vh;
}






 .modalDialog1 {
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



.modalDialog1:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog1 > div {
	
	width: 25%;
	height:37%;
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

.close:hover {
 background: #00d9ff;
 }



-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;
@media screen and (max-width: 700px){
  .box{
    width: 90%;
  }
  .popup{
    width: 50%;
  }
}
</style>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper">

  <%@ include file="PatientHeader.jsp" %> 
 
   <div class="content-wrapper" style="height:70%;">
   
    <br>
    <div style="float: right; margin-right: 10%; margin-top:-1%;">
 
</div>
           <div class="box box-info" style="border-top: 3px solid #333; border-left: 3px solid #333; 
           border-right: 3px solid #333;
 border-bottom: 3px solid #333; width: 40%; margin-left:30%; margin-top:3%; margin-right:10%; ">
				<div class="box-body" style="width:90%;  margin-top:3%; "> 
            <!-- /.box-header -->
            <h1 style="font-size:30px;"><center><b>My Lessons</b></center></h1>
            <div class="box-body table-responsive no-padding" style=" margin-left:-5%; width:120%;">
              <table class="table table-hover" style=" margin-left:20%; width:70%;  " >
                <tr>
                  <th width="10%">Status</th>
                <th style="width:7%; ">Assigned Lessons</th>
                </tr>
                
                
               <div id="openModal202" class="modalDialog1">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<div id="wrapper" style="width:90%;  height:40%; margin:5% auto;">
			 <a class="btn btn-primary" style="width:60%; margin-left:20%; "  href="StartActivityPatient" > Start Activity</a><br><br>
            <a class="btn btn-primary"  style="width:60%; margin-left:20%;" href="PatientSound"
             > Sounds</a><br><br>
            <a class="btn btn-primary"  style="width:60%; margin-left:20%;" href="PatientWord"
             > Words</a><br><br>
      <a class="btn btn-primary" style="width:60%; margin-left:20%;" href="PatientSentence" > Sentences</a><br>
               
            
            <br><br>
		</div>
	</div>
	 
            
            <tr style="width:90%;">
            <c:forEach items="${AssignedChapter}" var="item">
            
<td>	<a href="#openModal202" onclick="sendAjax(<c:out  value="${item.getLesson().getLessonId()}"/>)"> <span class=" btn btn-success" style="width:45%;">Start</span></a></td>


 
<td>
								<button class="btn btn-primary" style="width:20%; ">
									<c:out value="${item.getLesson().getLesson()}" /></button></td>
									</tr>
									</c:forEach>
									</table>

            </div>
            <!-- /.box-body -->
          </div>
  </div>
   
    </div> 
     <%@ include file="TherapistFooter.jsp" %>  </div>
  <!-- Content Wrapper. Contains page content -->
    <!-- Content Header (Page header) -->
                   <script type="text/javascript" src="../ust/resources/js/Controller/PatientLesson.js"></script>
    

    <!-- Main content -->
          
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->

  <!-- ./wrapper -->
  <!-- jQuery 2.2.3 -->
<script src="../ust/resources/components/PatientWelcome/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../ust/resources/components/PatientWelcome/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../ust/resources/components/PatientWelcome/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../ust/resources/components/PatientWelcome/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../ust/resources/components/PatientWelcome/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../ust/resources/components/PatientWelcome/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../ust/resources/components/PatientWelcome/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../ust/resources/components/PatientWelcome/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../ust/resources/components/PatientWelcome/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../ust/resources/components/PatientWelcome/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../ust/resources/components/PatientWelcome/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../ust/resources/components/PatientWelcome/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../ust/resources/components/PatientWelcome/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../ust/resources/components/PatientWelcome/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../ust/resources/components/PatientWelcome/dist/js/demo.js"></script>
</body>
</html>
