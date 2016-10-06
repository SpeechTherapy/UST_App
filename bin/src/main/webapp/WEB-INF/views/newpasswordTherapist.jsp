
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
 
 
  <link rel="stylesheet" type="text/css" href="../resources/components/AdminScreen/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="../resources/components/AdminScreen/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="../resources/components/AdminScreen/css/local.css" />

    <script type="text/javascript" src="../resources/components/AdminScreen/js/jquer-1.11.3.min.js"></script>
    <script type="text/javascript" src="../resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>

<script>
    function validatePass(p1, p2) {

     if (p1.value != p2.value || p1.value == '' || p2.value == '') {

         p2.setCustomValidity('Password incorrect');

     } else {

         p2.setCustomValidity('');

     }

 }
    </script>

</head>
<body>
	<div class="logo">Reset Password</div>
	
		<form   method="post"  action = "../newpasswordTherapist" >
			
						<label for="lg_username" class="sr-only">User ID</label>
						<input type="text" class="form-control" name="userId" id="txtPass" value = "${userId}" >
					
					<div class="form-group">
						<label for="lg_username" class="sr-only">New Password</label>
						<input type="password" class="form-control"  id="p1" placeholder="New password" name="userPassword" >
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Confirm Password</label>
						<input type="password" class="form-control" id="p2" placeholder="Re-type password" 
						onfocus="validatePass(document.getElementById('p1'), this);"
						oninput="validatePass(document.getElementById('p1'), this);">
					</div>
					
				<button type="submit"><i class="fa fa-chevron-right"></i></button>

			
			<span>${message}</span>
		</form>

	

</body>
</html>