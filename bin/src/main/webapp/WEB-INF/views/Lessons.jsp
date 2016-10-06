 <%@ page language="java" contentType="text/html;UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="TherapistCSS1.jsp" %> 
<style>

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
	height:30%;
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
<div class= "wrapper" style="align:center; ">

  <%@ include file="TherapistHeader.jsp" %> 
 
   <div class="content-wrapper" style="height:70%;">
    <br> 
    
		    <div class="box box-info" style="border-top:3px solid #333; border-left:3px solid #333;border-right:3px solid #333; border-bottom:3px solid #333;
		     width:80%; margin-left:12%; height:70%;  margin-top:3%;">
          <div class="box-body" style="width:80%; height:70%; "> 
			<div class="box">
            
              <h3 align="center"  style="font-size:60px; margin-left:20%;"><b> حرف تہجی</b></h3>
             
            </div>
            <div class="box" style="margin-top:-1%; margin-left:13%;  ">
              <br>
                              
                                <c:forEach items="${lessonList}" var="item">
								<td><a href="#openModal201">
								<button  class="btn btn-primary" style="margin:2%; align:center; width:6%;  height:6%; float:right; font-size:200%; outline-style:bold;" onclick="sendAjax(<c:out  value="${item.getLessonId()}"/>)" >
								<c:out value="${item.getLesson()}" /></button></a>

								
									
								</td>
								
								
							
						</c:forEach>

<div id="openModal201" class="modalDialog1">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<div id="wrapper" style="width:90%;  height:40%; margin:5% auto;">
		<a class="btn btn-primary"  style="width:60%; margin-left:20%;" href="/ust/StartActivityTherapist">Start Therapy</a><br><br>
		<a class="btn btn-primary"  style="width:60%; margin-left:20%;" href="/ust/TherapistSelection">Take Lesson</a>
        <br><br>
		<button class="btn btn-primary" style="width:60%; margin-left:20%;">Play Game</button>
		</div>
</div>
</div>

            </div>
            <!-- /.box-body -->
          </div>
        </div> </div></div>
        
     
 <%@ include file="TherapistFooter.jsp" %> 
   
        
        
               <script type="text/javascript" src="../resources/js/Controller/DbLesson.js"></script>
        
 
  <!-- jQuery 2.2.3 -->
<script src="../resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>

<!-- Bootstrap 3.3.6 -->
<script src="../resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../resources/components/Therapist/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../resources/components/Therapist/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../resources/components/Therapist/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../resources/components/Therapist/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../resources/components/Therapist/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../resources/components/Therapist/dist/js/demo.js"></script>
</body>
</html>
