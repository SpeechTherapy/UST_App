<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="TherapistCSS1.jsp" %> 
<style>
 span1 {
  display: block;
  font-size: 0.6em;
  color:#fff;
  opacity: 0.75;
  
}


body {
	background-image: url(/ust/resources/images/Blur.jpg);
}
</style>
</head>
<body>
	<div class="container" style="padding-top: 60px;">
		<h1 class="page-header" style="color: #FFF">Therapist's Profile</h1>
		<div class="row">
			<!-- left column -->

		<form id="profile" action="profile" method="post" enctype="multipart/form-data">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
	<img id="blah" src="/ust/${userPic}" style="width:300%; height:700%" class="avatar img-circle img-thumbnail" /> 
				</div>
			</div>
			<!-- edit form column -->

			<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
			

				
				<div class="form-group">
		  
 <div style="margin-top:15%; margin-left:20%;">
 <h1 style="color:#fff;">
   <lable style="margin:4%;font-size:30px;">Name:</lable> <span><b>${therapistName }</b></span><br> <br>
 <lable style="margin:4%; font-size:30px;">User:</lable><span>Therapist</span><br>
   <lable style="margin:4%; font-size:30px;">Hospital:</lable> <span>${Hospital}</span><br>
   <lable style="margin:4%; font-size:30px;">Contact No:</lable><span>${contactNo }</span><br>
  <lable style="margin:4%; font-size:30px;">Email: </lable> <span>${Email}</span><br>
    </h1>
    </div>
  
					
				
				

				

			</div>
</form>
		</div>
		  
	</div>
</body>
</html>
