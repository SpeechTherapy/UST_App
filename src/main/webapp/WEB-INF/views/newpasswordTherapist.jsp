<!DOCTYPE html>
<html lang="en"> 
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  
  <title>New Password</title>
  <link rel="stylesheet" href="/ust/resources/components/Newwpassword/css/style.css">
  <link rel="stylesheet" href="/ust/resources/components/Newwpassword/scss/style.css">
</head>
<body>
<form   method="post"  action = "../newpasswordTherapist"  class="login">
<input type="hidden" class="form-control" name="userId" id="txtPass" value = "${userId}" > 
<div style="align:center; "> 

      <label for="password"  >Password:</label>
     
      
     <p>
     						<input type="password" class="form-control"  id="p1" placeholder="New password" name="userPassword"  >
						

</p>
   
  
      <label for="password" >Confirm-password:</label>
   
      <p>
      
     						<input type="password"  class="form-control" id="p2" placeholder="Re-type password" onfocus="validatePass

(document.getElementById('p1'), this);" oninput="validatePass(document.getElementById('p1'), this);">

    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">Login</button>
    </p>
    <span>${message }</span>
    </div> 
  </form>
</body>
</html>
