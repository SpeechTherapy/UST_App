<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="TherapistCSS1.jsp" %> 

  
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <script type="text/javascript" src="../ust/resources/js/Controller/Assignment.js"></script>
  
  <style>
*, *:before, *:after { box-sizing: border-box; }

body {
  height: 100vh;
  background: linear-gradient(#000, #999);
}
th
{
font-size:20px;

}
.modalDialog99 {
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



.modalDialog99:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog99 > div {
	
	width: 60%;
	height:45%;
	position: relative;
	margin: 10% auto;
	padding: 10px 40px 30px 20px;
	border-radius: 10px;
	background: #000;
	background: -moz-linear-gradient(#353535, #000);background: -webkit-linear-gradient(#353535, #000);
	background: -o-linear-gradient(#353535, #000);
}

.snip17 {
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
.snip17 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
}
.snip17 .background {
  width: 100%;
  vertical-align: top;
  opacity:0.1;
  -webkit-filter: grayscale(100%) blur(10px);
  filter: grayscale(100%) blur(10px);
  -webkit-transition: all 2s ease;
  transition: all 2s ease;
}
.snip17 figcaption {
  width: 100%;
  padding: 15px 25px;
  position: absolute;
  left: 0;
  top: 50%;
}
.snip17 .profile {
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
.snip17 h3 {
  margin: 0 0 5px;
  font-weight: 400;
}
.snip17 h3 span {
  display: block;
  font-size: 0.6em;
  color: #f39c12;
  opacity: 0.75;
}
.snip17 i {
  padding: 10px 5px;
  display: inline-block;
  font-size: 32px;
  color: #ffffff;
  text-align: center;
  opacity: 0.65;
}
.snip17 a {
  text-decoration: none;
}
.snip17 i:hover {
  opacity: 1;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}
.snip17:hover .background,
.snip17.hover .background {
  -webkit-transform: scale(1.3);
  transform: scale(1.3);
}
   .modalDialog33 {
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



.modalDialog33:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog33 > div {
	
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
<div class= "wrapper">

   <%@ include file="TherapistHeader.jsp" %> 
  
   <div class="content-wrapper" style="height:70%;">
    <br> 
		    <div class="box box-info" style="border-top: 3px solid #333; border-left: 3px solid #333; border-right: 3px solid #333;
 border-bottom: 3px solid #333; width: 80%; margin-left:10%; margin-top:3%; margin-right:10%; ">
				<div class="box-body" style="width:100%;  "> 
            <!-- /.box-header -->
            <h1 style="font-size:30px;"><center><b>Patient List</b></center></h1>
            <div class="box-body table-responsive no-padding" style="margin-top:3%; margin-left:-5%; width:120%;">
              <table class="table table-hover" style=" margin-left:10%; width:70%;" >
 
                <tr>

                    <th width="25%">Patient Name</th>
                  <th width="20%">Age</th>
                  <th width="20%">Gender</th>
                  <th width="25%">Assign Lesson</th>
                </tr>
                
               
                <c:forEach items="${patientList}" var="itemA">
<tr>
<td>  <br> <a href="ViewProfilePatient" target="_blank" onclick="sendId('<c:out  value="${itemA.patientId}"/>')">
  <c:out value="${itemA.patientName}"></c:out>
</a></td>



<td><c:out value="${itemA.patientAge }"/></td>
<td> <c:out value="${itemA.patientGender }"/></td>


           <td>      
 <a href="#openModal999"><span class="btn btn-danger" > Assign Lesson</span></a>
 <div id="openModal999" class="modalDialog99">
	<div>
		<a href="#close" title="Close" class="close">X</a>
			<table>
			  <c:forEach items="${lessonList}" var="item">
            
             
                              
								<td style=" margin-left:2%; margin-right:-2%; float:right;"><a href="#openModal999">
								
								<center>
								<button  class="btn btn-primary" style="width:81%; margin:4 auto%; height:7%;  font-size:200%;" 
								onclick="Assignment('<c:out  value="${itemA.getPatientId()}"/>','<c:out  value="${item.lessonId}"/>')" >
								<c:out value="${item.getLesson()}" /></button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</center></a>
</td>
							
									</c:forEach>
								
								  
								  
								  
            
            
            </table>
        
	
                
                </div></div>
  
      
     
      
    </div>
  
  </div>
</td>
</tr>

        </c:forEach>        
                
              </table>
            </div>
            <!-- /.box-body -->
            </form>
          </div>
       
          </div></div>
 
       <%@ include file="TherapistFooter.jsp" %>     
 
   </div></div>
       <script type="text/javascript" src="/ust/resources/js/Controller/DeactivatePatient.js"></script>
   

                         <script type="text/javascript" src="../ust/resources/js/Controller/List.js"></script>
  
<script src="../ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>

<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../ust/resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../ust/resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../ust/resources/components/Therapist/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../ust/resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../ust/resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../ust/resources/components/Therapist/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../ust/resources/components/Therapist/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../ust/resources/components/Therapist/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../ust/resources/components/Therapist/dist/js/demo.js"></script>
</body>
</html>