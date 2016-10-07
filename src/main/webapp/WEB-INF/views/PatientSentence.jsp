<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="PatientCss.jsp" %> 

<style>



	




-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;
</style>

</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper">

<%@ include file="PatientHeader.jsp" %>     
   
   <div class="content-wrapper" style="height:70%;">
    <br> 
    <div style="float: right; margin-right: 10%; margin-top:-1%;">
 <a href="/ust/PatientWord">
 <i class=" fa fa-arrow-left fa-3x">&nbsp;&nbsp;&nbsp;</i></a>
 
</div>
		    <div class="box box-info" style="border-top: 3px solid #333; border-left: 3px solid #333; border-right: 3px solid #333;
 border-bottom: 3px solid #333; width: 80%; margin-left:10%; margin-top:3%; margin-right:10%; ">
				<div class="box-body" style="width:100%;  "> 
             <h1 style="font-size:35px;"><center><b>Sentences</b></center></h1><br>
              
		
            <!-- /.box-header -->
            <div class="box" style="margin-top:1%;">
              <c:forEach items="${sentencesList}" var="item">
              <c:if test="${item.sentencesIsActive==1}">

<a href="/ust/ActivityScreenPatient"><button   class="btn btn-primary" style=" margin-left:40%; width:20%; height:10%; 
font-size:24px;" 
onclick="sendAjax(<c:out  value="${item.sentencesId}"/>)">
<b><c:out  value="${item.getSentences()}"/></b></button></a><br>



<br>
</c:if>
 </c:forEach>
            </div>
       
 </div> 
 
        </div>  </div></div>
        <%@ include file="TherapistFooter.jsp" %>
 
               <script type="text/javascript" src="/ust/resources/js/Controller/PatientSentence.js"></script>

  <!-- ./wrapper -->
 <script src="/ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
  </script>
  <!-- Bootstrap 3.3.6 -->
  <script src="/ust/resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
  <!-- Morris.js charts -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
  <script src="/ust/resources/components/Therapist/plugins/morris/morris.min.js"></script>
  <!-- Sparkline -->
  <script src="/ust/resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>
  <!-- jvectormap -->
  <script src="/ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
  <script src="/ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
  <!-- jQuery Knob Chart -->
  <script src="/ust/resources/components/Therapist/plugins/knob/jquery.knob.js"></script>
  <!-- daterangepicker -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
  <script src="/ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>
  <!-- datepicker -->
  <script src="/ust/resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>
  <!-- Bootstrap WYSIHTML5 -->
  <script src="/ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
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
