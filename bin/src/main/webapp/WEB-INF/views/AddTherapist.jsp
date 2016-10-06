<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <%@ include file="AdminHeaderCss.jsp" %> 
    <script type="text/javascript" src="../ust/resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../ust/resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>   
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

    <div id="wrapper">
         <%@ include file="AdminHeader.jsp" %> 
       <div id="page-wrapper" style="background-color:#222222; width:84%;  margin-left:7%;   heihgt:100%; margin-top:10%;"   >

            <div class="row">
              <div class="col-lg-6" style="margin-left:30%; margin-top:1%;" >
                <form action="AddTherapist" method="post" >
               <h1 style="color:#00CCCC;  margin-left:15%; font-size:40px;"><b>Add Therapist</b></h1>
			   <br>
			   <c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">x</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
			   
                  <div class="form-group">
                  
                    <label class="col-lg-9" >Email Address </label> 
                       <div class="col-lg-9">
                   <input class="form-control" type="email" name="email" placeholder="Email Address" required  >  
                 </div>
                 <div class="col-md-1">
                <i class="fa fa-envelope fa-2x"></i>
            </div>
 
                  </div>
                 
                  <div class="form-group">
                
                    <label class="col-lg-9" >Username</label>
                  <div class="col-lg-9">
                    <input class="form-control" type="text" name="userName" placeholder="Username" pattern="[a-zA-Z0-9]{5,}"title="Minimum 5 letters or numbers." required />
                  </div>
                   <div class="col-md-1">
                <i class="fa fa-user fa-2x"></i>
            </div></div>
            
             <div class="form-group">
                
                    <label class="col-lg-9" >Password</label>
                  <div class="col-lg-9">
                    <input class="form-control" type='password' onFocus="validatePass(document.getElementById('p1'), this);" 
                    oninput="validatePass(document.getElementById('p1'), this);"  
                    name="userPassword" placeholder="Confirm Password"required>
                  </div>
                   <div class="col-md-1">
                <i class="fa fa-key fa-2x"></i>
            </div></div>
            
             <div class="form-group">
                
                    <label class="col-lg-9" >Confirm Password</label>
                  <div class="col-lg-9">
 <input class="form-control" type='password' onFocus="validatePass(document.getElementById('p1'), this);" oninput="validatePass(document.getElementById('p1'), this);"  name="password" placeholder="Confirm Password"required>
                  </div>
                   <div class="col-md-1">
                <i class="fa fa-key fa-2x"></i>
         </div>
      <div class="col-md-10" ><br><br>
             <button type="submit" class="btn btn-default" >Register</button>
          </div></div>
                  
                  
                  
                </form>
              </div>
            </div>
     </div>
    </div> 
 <%@ include file="AdminFooter.jsp" %> 
  

</body>
</html>