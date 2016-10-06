<header class= "main-header">
    <!-- Logo -->
    
    <!-- Header Navbar: style can be found in header.less -->
   <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav"> 
          <li class="treeview">
          <a href="/ust/user/WelcomeTherapist">
            <i class="glyphicon glyphicon-home"></i>
            <span>Home</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right"></span></span></a></li>
<li class="treeview">
          <a href="/ust/info/Articulation">
            <i class="fa fa-info-circle"></i>
            <span>Articulation</span>
            <span class="pull-right-container">
              <span class="label label-primary pull-right"></span></span></a></li>
		  
		   <li class="dropdown" user-dropdown>
  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-file-text-o"></i> Lessons <b class="caret"></b>
<ul class="dropdown-menu" style="overflow:visible;">
                            <li><a href="/ust/user/Lessons"> <i class="fa fa-user"></i> View Lessons</a></li>
                            
    <li class="divider"></li>
                            <li><a href="/ust/user/AssignedLessonList"> <i class="fa fa-power-off"></i> Assigned Lessons</a></li>
</ul></li>
		  <li class="treeview">
          <a href="/ust/Assignment">
            <i class="fa fa-heartbeat"></i>
            <span>Patients</span>
           </a></li>
		 <li class="treeview">
          <a href="/ust/List">
            <i class="fa fa-file-text-o"></i>
            <span>Reports</span>
            </span>          </a>
			 <li class="treeview">
         <!--  <a href="#">
            <i class="fa fa-comments-o"></i>
            <span>Discussion</span>
            </span>          </a> -->
					 <li class="treeview">
          <a href="/ust/BlogPost">
            <i class="fa fa-feed"></i>
            <span>Blog</span>
            </span>          </a>
 <li class="treeview">
          <a href="/ust/AboutTherapist">
            <i class="glyphicon glyphicon-exclamation-sign"></i>
            <span>About</span>
            </span></a>          
			<li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="/ust/${UserPic}" class="user-image" alt="User Image">
              <span class="hidden-xs">${therapistName }</span></a>
            <ul class="dropdown-menu">
              <li class="user-header">
                <img src="/ust/${UserPic}" class="img-circle" alt="User Image">
                <p>
                  ${therapistName } - Therapist
                  <small>Member since ${CreatedOn}</small>
                </p>
              <li class="user-footer">
                <div class="pull-left">
                <a href="#openModal500"><button  class="btn btn-default" style="margin:2%;">Profile</button></a>
                  <div class="pull-right">
                  </div>
                  <a href="logout" class="btn btn-default btn-flat" style="margin-top:-1%; float:right; margin-right:-90%;">Sign out</a>
                </div>
              </li>
            </ul>
<div id="openModal500" class="modalDialog200">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		
                  
                   <figure class="snip1344"><img src="" alt="profile-sample1" class="background"/>
                    <a  class="fa fa-edit fa-2x" style="margin-left:80%; margin-top:-60%; color:#0066FF;
   background-color:transparent; border:hidden;" href="/ust/therapist/EditProfileTherapist">  </a>
                   <img src="/ust/${UserPic}" alt="profile-sample1" class="profile"/>
  <figcaption>
 
    <h3>${therapistName } 
    <span>Therapist</span>
    <span>${Hospital }</span>
    <span>${contactNo }</span>
    <span>${Email}</span>
    </h3>
  </figcaption>
</figure>
                
                </div></div></div>
              
          
     
    </nav>
  </header>