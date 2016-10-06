 <%@ include file="TherapistCSS1.jsp" %> 

  <style>
*, *:before, *:after { box-sizing: border-box; }

body {
  height: 100vh;
  background: linear-gradient(#000, #999);
}

.modal-container {
  margin: 0 auto;
  padding-top: 60px;
  position: relative;
  width: 160%;
}

.modal-container button {
  display: block;
  margin: 0 auto;
  color: #fff;
  width: 20%;
  height: 50px;
  line-height: 50px;
 background: linear-gradient(#000, #999);
  font-size: 22px;
  border: 0;
  border-radius: 3px;
  box-shadow: 0 5px 5px -5px #333;
  transition: background 0.3s ease-in;
}

.modal-container .modal-backdrop {
  height: 0;
  width: 10%;
  opacity: 0;
  overflow: hidden;
  transition: opacity 0.2s ease-in;
}

.modal-container #modal-toggle {
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  margin: 0;
  opacity: 0;
  cursor: pointer;
}

.modal-container #modal-toggle:hover ~ button { background: #1E824C; }

.modal-container #modal-toggle:checked {
  width: 40%;
  height: 30%;
  position: fixed;
  left: 0;
  top: 0;
  z-index: 9;
  opacity: 0;
}

.modal-container #modal-toggle:checked ~ .modal-backdrop {
  background-color: rgba(0, 0, 0, 0.6);
  width: 100vw;
  height: 100vh;
  position: fixed;
  left: 0;
  top: 0;
  z-index: 9;
  pointer-events: none;
  opacity: 1;
}

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content {
  background: linear-gradient(#000, #999);
  max-width: 40%;
  width: 30%;
  height: 40%;
  padding: 5px 10px;
  position: absolute;
  left: calc(50% - 200px);
  top: 25%;
  border-radius: 4px;
  z-index: 999;
  pointer-events: auto;
  cursor: auto;
  box-shadow: 0 3px 7px rgba(0, 0, 0, 0.6);
}
@media (max-width: 400px) {

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content { left: 0; }
}

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content .modal-close {
  color: #666;
  position: absolute;
  right: 2px;
  top: 0;
  padding-top: 7px;
  background: #000;
  font-size: 16px;
  width: 25px;
  height: 28px;
  font-weight: bold;
  text-align: center;
  cursor: pointer;
}

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content .modal-close.button {
  top: initial;
  bottom: 20px;
  right: 20px;
  background:#CCC;
  color: #fff;
  width: 50px;
  border-radius: 2px;
  font-size: 14px;
  font-weight: normal;
}

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content .modal-close.button:hover {
  color: #fff;
  background: linear-gradient(#000, #999);;
}

.modal-container #modal-toggle:checked ~ .modal-backdrop .modal-content .modal-close:hover { color: #333; }
</style>
  <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-46156385-1', 'cssscript.com');
  ga('send', 'pageview');

</script>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper">

     <%@ include file="TherapistHeader.jsp" %> 
    
   <div class="content-wrapper" style="height:70%;">
    <br> 
		    <div class="box box-info" style="border-top: 3px solid #333; border-left: 3px solid #333; border-right: 3px solid #333;
 border-bottom: 3px solid #333; width: 80%; margin-left:10%; margin-top:3%; margin-right:10%; ">
				<div class="box-body" style="width:100%;  "> 
             <h1 style="font-size:35px;"><center><b>Blog Post</b></center></h1><br>
             
            <!-- /.box-header -->
            <div class="col-md-4 col-sm-6 col-xs-12">
				<div class="text-center">
				<span>${ msg}</span>
							<form id="blog" style="height:20%;" action="blog" method="post" enctype="multipart/form-data">
					
						<img id="blah" src="/us" width="170"
							height="400" float="right" class="avatar img-circle img-thumbnail" /> <input
							type="file"
							onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"
							class="text-center center-block well well-sm" name="file">
				</div>
			</div>
<div class="box-body table-responsive no-padding" >
   <div class="well" style="height:20%; width:auto%; ">
                        
                           <label>Title</label> <input type="text" placeholder="Enter Title" class="form-control" name="blogHeading" style="width:30%;"> 
                                
                        <h4>Blogs</h4>
                        <form role="form" style="height:50%;">
                            
                                <textarea class="form-control" rows="3" style="height:30%; width:90%;" name="blogBody"></textarea><br>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            
                        </form>
                    </div>


                    
            </div>
            <!-- /.box-body -->
          </div>
        </div> 
          
        </div> 
          <%@ include file="TherapistFooter.jsp" %>
          </div> 
  
  <!-- ./wrapper -->
  <!-- jQuery 2.2.3 -->
<script src="../ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../ust/resources/components/Therapist/https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.6 -->
<script src="../ust/resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/morris/morris.min.js"></script>
<!-- Sparkline -->
<script src="../ust/resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../ust/resources/components/Therapist/plugins/knob/jquery.knob.js"></script>
<!-- daterangepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../ust/resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../ust/resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../ust/resources/components/Therapist/plugins/fastclick/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../ust/resources/components/Therapist/dist/js/app.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../ust/resources/components/Therapist/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../ust/resources/components/Therapist/dist/js/demo.js"></script>
</body>
</html>
