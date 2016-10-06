<!DOCTYPE html>
<html lang="en"> 
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  
  <title>New Password</title>
  <link rel="stylesheet" href="/ust/resources/components/Newwpassword/css/style.css">
</head>
<body>
  <form method="post" action = "../newpassword" class="login">
    <p>
      <label for="password">Password:</label>
     						<input type="password" class="form-control"  id="p1" placeholder="New password" name="userPassword" >
						<input type="text" class="form-control" name="userId" id="txtPass" value = "${userId}"  >


    </p>

    <p>
      <label for="password">Confirm Password:</label>
     						<input type="password" class="form-control" id="p2" placeholder="Re-type password" onfocus="validatePass

(document.getElementById('p1'), this);" oninput="validatePass(document.getElementById('p1'), this);">

    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
    <span>${message }</span>
  </form>
</body>
</html>
