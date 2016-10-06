<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Terms and Condition</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../resources/components/Therapist/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../resources/components/Therapist/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../resources/components/Therapist/plugins/iCheck/square/blue.css">
<style>
body{
   background-image:url(../resources/images/Blur.jpg);
  
  }
</style>
<script src="http://code.jquery.com/jquery-1.8.3.js" ></script>
   <script type="text/javascript">
   document.getElementById("field_terms").setCustomValidity("Please indicate that you accept the Terms and Conditions");
   </script>

  
</head>
<body>
<div>
    <div  >
<div class="login-box" style="width:50%; height:170px;" >
  <div class="login-logo">
    <a href="#"><b style="color:#FFF">Terms and Conditions</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body" style="height:150%;">
    <form>

     <div class="box box-solid box-default">
        <div class="box-body">
          <p> <li>
          <ul>I have accepted the <a href="#" >Terms and Condition Agreement </a> and the <a href="#" >Privacy Policy.</a>
          </ul></li>
          <li>
          <ul>I may receive emails from Urdu Speech Therapy Application
          </ul>
          </li>
          <li>
          <ul>I am responsible for the advices and reccomendations from the doctors community registered in the application.</ul>
          </li>
         
          </p>

          </div>
        <!-- /.box-body -->
      </div>
       
       <div class="checkbox icheck">
            <label>
        <input onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');" id="field_terms" type="checkbox" required name="terms"> I accept the <u>Terms and Conditions</u>
            </label>
          </div>
          <div class="col-xs-4" style="margin-left:35%; margin-top:-3%;">
          <a type="submit" class="btn btn-primary btn-block btn-flat"   style="margin-left:90%;" href="../Patientprofile" >Accept</a>
        </div>
      
    </form>
    <!-- /.social-auth-links -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="../resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="../resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="../resources/components/Therapist/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
</div>
</div>
</body>
</html>
