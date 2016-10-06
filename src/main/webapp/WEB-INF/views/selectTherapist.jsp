<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Select Therapist</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet"
	href="../resources/components/Therapist/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="../resources/components/Therapist/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../resources/components/Therapist/dist/css/skins/_all-skins.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/iCheck/flat/blue.css">
<!-- Morris chart -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/morris/morris.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Date Picker -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/datepicker/datepicker3.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/daterangepicker/daterangepicker.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<style>
body {
	background-image: url(../resources/images/Blur.jpg);
}
</style>

</head>
<body>
	<div>
		<!-- Content Header (Page header) -->

		<div class="box box-primary"
			style="border-top: 3px solid #636; width: 50%; height: 70%; margin-left: 25%;">

			<div>

				<c:forEach items="${therapistList}" var="item">

					<img class="profile-user-img img-responsive img-circle"
						src="../<c:out value="${item.getUser().getUserPic()}"/>"
						alt="User profile picture">
					<h3 class="profile-username text-center">
						<c:out value="${item.therapistName}" />
					</h3>
					<p class="text-muted text-center" style="color: Black;">Therapist</p>
					<div class="box-body" align="center">
						<strong style="color: Black;"><i
							class="fa fa-book margin-r-5"></i> Contact Number</strong>
						<p class="text-muted">
							<c:out value="${item.therapistContact}" />
						</p>

						<strong style="color: Black;"><i
							class="fa fa-map-marker margin-r-5"></i> Hospital Name & Location
						</strong>

						<p class="text-muted">
							<c:out value="${item.getHospital().getHospitalName()}" />
							-
							<c:out value="${item.getHospital().getHospitalAddress()}" />
							-
							<c:out value="${item.getHospital().getCity().getCityName()}" />
						</p>

						<strong style="color: Black;"><i
							class="fa fa-pencil margin-r-5"></i>Email</strong>
						<p>
							<c:out value="${item.getUser().getEmail()}" />
						</p>
						
						
						<a class="label label-danger"
							style="width: 10%;"
							onclick="selectTherapist(<c:out value="${item.getTherapistId()}" />)"  
							 href="termsAndConditions" >
							Select</a><br><br>
							
							
						<hr>

					</div>
					<!-- /.box-body -->
				</c:forEach>


			</div>

			<!-- jQuery 2.2.3 -->
			<script
				src="../resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
			<!-- jQuery UI 1.11.4 -->
			<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
			<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
			<script>
				$.widget.bridge('uibutton', $.ui.button);
			</script>
			<!-- Bootstrap 3.3.6 -->
			<script
				src="../resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
			<!-- Morris.js charts -->
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
			<script
				src="../resources/components/Therapist/plugins/morris/morris.min.js"></script>
			<!-- Sparkline -->
			<script
				src="../resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>
			<!-- jvectormap -->
			<script
				src="../resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
			<script
				src="../resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
			<!-- jQuery Knob Chart -->
			<script
				src="../resources/components/Therapist/plugins/knob/jquery.knob.js"></script>
			<!-- daterangepicker -->
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
			<script
				src="../resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>
			<!-- datepicker -->
			<script
				src="../resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>
			<!-- Bootstrap WYSIHTML5 -->
			<script
				src="../resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
			<!-- Slimscroll -->
			<script
				src="../resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>
			<!-- FastClick -->
			<script
				src="../resources/components/Therapist/plugins/fastclick/fastclick.js"></script>
			<!-- AdminLTE App -->
			<script src="../resources/components/Therapist/dist/js/app.min.js"></script>
			<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
			<script
				src="../resources/components/Therapist/dist/js/pages/dashboard.js"></script>
			<!-- AdminLTE for demo purposes -->
			<script src="../resources/components/Therapist/dist/js/demo.js"></script>
			<script type="text/javascript"
				src="../resources/js/Controller/SelectTherapist.js"></script>
</body>
</html>