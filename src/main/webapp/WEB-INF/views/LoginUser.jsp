<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../resources/components/Therapist/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/ust/resources/components/Therapist/plugins/iCheck/square/blue.css">
  <script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
  });
</script>
<style>


body{
   background-image:url(/ust/resources/images/Blur.jpg);
  
  }

</style>

  
</head>
<body >
<div>
    <div  >
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b style="color:#FFF"> Login</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg">Sign in to start your session</p>

    <form action="login" method="post">
      <div class="form-group has-feedback">
<input type="text" class="form-control"  name="userName" placeholder="Username or Email" title="Minimum 5 letters or numbers." required>
      
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
      <input type = "password" name="userPassword" class="form-control" placeholder="Password" required>
        
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        
        <!-- /.col -->
        <div class="col-xs-4" style="margin-left:35%;">
          <button type="submit" class="btn btn-primary btn-block btn-flat" >Login</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <!-- /.social-auth-links -->
          <span style="color:red;"> ${message }</span><br>

    <a href="/ust/ChangingPassword/forgotpassword">I forgot my password</a><br><br>
    <a href="register" class="text-center">Register a new membership</a>

  </div>
  
  
</div>




</div>
 
</div>
<footer class="main-footer" style="position:fixed; width:100%; bottom:0;">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.5
    </div>
<strong>Copyright &copy; 2016-2017 <a href="http://urduspeechtherapy.com">Urdu Speech Therapy</a>.</strong> All rights. For any query
    Contact<strong> <a href="/ust/ContactUs" target="_blank"> Admin</a> </strong>
        </footer>


      
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<script src="/ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="/ust/resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="/ust/resources/components/Therapist/plugins/iCheck/icheck.min.js"></script>
</body>
</html>
