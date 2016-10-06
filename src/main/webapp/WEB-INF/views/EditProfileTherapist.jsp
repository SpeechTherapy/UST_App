<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Maintain Profile</title>
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
<!-- iCheck -->
<link rel="stylesheet"
	href="../resources/components/Therapist/plugins/iCheck/square/blue.css">
<style>
body {
	background-image: url(../resources/images/Blur.jpg);
}
</style>
</head>
<body>
	<div class="container" style="padding-top: 60px;">
		<h1 class="page-header" style="color: #FFF">Maintain Profile</h1>
		<div class="row">
			<!-- left column -->

		<form id="profile" action="Editprofile" method="post" enctype="multipart/form-data">
			<div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
					
						<img id="blah" src="../${userPic}" width="100"
							height="100" class="avatar img-circle img-thumbnail" /> <input
							type="file"
							onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
							class="text-center center-block well well-sm" name="file">
				</div>
			</div>
			<!-- edit form column -->

			<div class="col-md-8 col-sm-6 col-xs-12 personal-info">
				<div class="alert alert-info alert-dismissable" style="width: 80%">
					<a class="panel-close close" data-dismiss="alert">×</a> <i
						class="fa fa-coffee"></i> Changing your profile options lets you
					control how others see you and your profile.
				</div>

				<h3 style="color: #FFF">Personal info</h3>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">Name:</label>
					<div class="col-lg-4">
						<input class="form-control" name="Name" type="text" value="${therapistName }">
					</div>
				</div>
				<br>
				<br>
				<br>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">Hospital
						Name:</label>
					<div class="col-lg-4">
						<input class="form-control" type="text" name="hospitalName"
							autocomplete="on" value="${ hospitalName}">
						<datalist id="hospital">
							<c:forEach items="${hospitalList}" var="item">
								<option value="${item.hospitalName}"></option>
							</c:forEach>
						</datalist>
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">Hospital
						Address:</label>
					<div class="col-lg-4">
						<input class="form-control" name="hospAddress" type="text" value="${hospitalAddress}">
					</div>
				</div>
				<br> <br>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">City:</label>
					<div class="col-lg-4">
						<input class="form-control" list="city" name="cityId"
							autocomplete="on" value="${cityName}">
						<datalist id="city">
							<c:forEach items="${cityList}" var="item">
								<option value="${item.getCityId()}" label="${item.cityName }"></option>
							</c:forEach>

						</datalist>
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">Contact
						Number:</label>
					<div class="col-lg-4">
						<input class="form-control" id="contactNo" name="contactNumber"
							type="text" value="${contact}">
					</div>
				</div>
				<br>
				<br>
				<div class="form-group">
					<label class="col-lg-3 control-label" style="color: #FFF">Gender:</label>
					<div class="col-lg-4">
						<input type="radio" name="therapistGender" value="male">
						<label style="color: #FFF"> &nbsp;&nbsp;&nbsp; Male </label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
							name="therapistGender" value="female"> 
							<label style="color: #FFF">&nbsp;&nbsp;&nbsp;
						Female </label><br>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-4">

						<input class="btn btn-primary" type="submit" value="Submit">
					</div>
				</div>

			</div>
</form>
		</div>
		
	</div>
</body>
</html>
