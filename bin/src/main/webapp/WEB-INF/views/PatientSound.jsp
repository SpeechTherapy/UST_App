<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

        <%@ include file="PatientCss.jsp" %>
   
<style>
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
   .modalDialog {
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



.modalDialog:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog > div {
	
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
        <%@ include file="PatientHeader.jsp" %>
    
 
   <div class="content-wrapper">
    <br> 
		    <div class="box box-info" style="border-top:4px solid #003; border-left:4px solid #003; border-right:4px solid #003; border-bottom:4px solid #003; width:60%; margin-left:20%; height:70%;  ">
          <div class="box-body" style="width:100%; height:70%;"> 
			<div class="box" >
          
              <h3 align="center" class="box-title"  style="font-size:24px;"><b> Sounds </b></h3>
           
			</div>
            <!-- /.box-header -->
            <div class="box" style="margin-top:10%;">
              <c:forEach items="${soundList}" var="item">
                                          <c:if test="${item.soundIsActive==1}">


<button  class="btn btn-primary" style="margin-top:5%; margin-left:15%; width:10%; font-size:30px;">
<c:out  value="${item.getSound()}"/></button>
<br>
<iframe src="" controls style=" margin-right:20%; margin-top:-10%; float:right; width:15%; height:10%;" frameborder="0" autostart="false"  ></iframe> 
</p>
<a  onclick="sendAjax(1)"><i class="fa fa-microphone fa-5x" style="color:red width:20%; margin-right:20%; margin-top:-10%; float:right;"></i>
</a>
<div style=" margin-left:60%; margin-top:-5%;width:2%;float:left; ">
<audio src="/ust/${mediaAudio }" controls="true" loop="true" autoplay="false"  ></audio>

</div>

<br>

<br>
<br>
</c:if>

 </c:forEach>
            </div>
                             
            
            <!-- /.box-body -->
          </div>
        </div> 
        </div> 

                           <script type="text/javascript" src="../ust/resources/js/Controller/ActivityAjax.js"></script>
 
  <script src="../ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
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
