<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href='http://fonts.googleapis.com/css?family=Droid+Serif|Open+Sans:400,700' rel='stylesheet' type='text/css'>

 <%@ include file="PatientCss.jsp" %>

	<link rel="stylesheet" href="/ust/resources/components/TherapistBlog/css/reset.css"> <!-- CSS reset -->
	<link rel="stylesheet" href="/ust/resources/components/TherapistBlog/css/style.css"> <!-- Resource style -->
	<script src="/ust/resources/components/TherapistBlog/js/modernizr.js"></script> 

  <style>
*, *:before, *:after { box-sizing: border-box; }

body {
  height: 100vh;
  background: linear-gradient(#000, #999);
}

</style>
  <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-46156385-1', 'cssscript.com');
  ga('send', 'pageview');

</script>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper">

     <%@ include file="PatientHeader.jsp" %> 
    
   <div class="content-wrapper" style="height:auto%;">
    <br>
    
		   <headerr>
		<h1 style="font-size:37px; color:#000;"><b>Blogs</b></h1>
	</headerr>
	

<section id="cd-timeline" class="cd-container" >
    <c:forEach items="${postList}" var="item">
<c:if test="${item.status==1}">
  
    
		<div class="cd-timeline-block">
			<div class="cd-timeline-img cd-picture" style="background: url(/ust/${item.blogpic}) no-repeat;
    background-size: cover;">
				
			</div> 
			<div class="cd-timeline-content">
				<h2 style="font-size:30px;">"<c:out value="${item.blogHeading}" /></h2>
				<p style="font-size:20px;"><c:out value="${item.blogBody}" />	</p>
				<span class="cd-date"><c:out value="${item.getTherapist().getTherapistName()}" /></span>
			</div> <!-- cd-timeline-content -->
		</div> <!-- cd-timeline-block -->
</c:if>
 </c:forEach>


		 
	</section>
	</div>
	<footer class="main-footer" style="position:fixed; width:100%; bottom:0;">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.5
    </div>
    <strong>Copyright &copy; 2016-2017 <a href="http://urduspeechtherapy.com">Urdu Speech Therapy</a>.</strong> All rights
    </footer>
	</div></body></html>
  
         
  
  <!-- ./wrapper -->
  <!-- jQuery 2.2.3 -->
<script src="../ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../ust/resources/components/Therapist/https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/ust/resources/components/TherapistBlog/js/main.js"></script>
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
<script src="../ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.js">
