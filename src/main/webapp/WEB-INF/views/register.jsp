<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Registration</title>
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

 <script>
    function validatePass(p1, p2) {

     if (p1.value != p2.value || p1.value == '' || p2.value == '') {

         p2.setCustomValidity('Password incorrect');

     } else {

         p2.setCustomValidity('');
     }
 }
    </script>
    <style>


body{
   background-image:url(../resources/images/Blur.jpg);
  
  }

</style>
    
</head>
<body >
<div class="register-box">
  <div class="register-logo">
    <a href="../resources/components/Therapist/index2.html"><b style="color:#FFF;">Sign Up</b></a>
  </div>
  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>

    <form action="register" method="post">
      <div class="form-group has-feedback">
      <input type="email" name="email" class="form-control" placeholder="Email Address" required>
    
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      
      
      <div class="form-group has-feedback">
      <input type="text" class="form-control" name="userName" placeholder="Username" pattern="[a-zA-Z0-9]{5,}"title="Minimum 5 letters or numbers." required />
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      
      
      <div class="form-group has-feedback">
       <input type='password' id='p1' name="userPassword" class="form-control" placeholder="Password" required>
       
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      
      <div class="form-group has-feedback">
       <input type='password' onfocus="validatePass(document.getElementById('p1'), this);" oninput="validatePass(document.getElementById('p1'), this);"  name="password" placeholder="Confirm Password" class="form-control" required>
       
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
      
        <div class="col-xs-4" >
          <button type="submit"  class="btn btn-primary btn-block btn-flat">Next</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
<br>
    <span style="color:red;">${message }</span>
<br>
    <a href="../user/LoginUser" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

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
</body>
</html>
