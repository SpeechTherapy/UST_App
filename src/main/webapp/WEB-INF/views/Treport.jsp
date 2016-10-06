<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="TherapistCSS1.jsp" %> 
 
  <style>
*, *:before, *:after { box-sizing: border-box; }

body {
  height: 100vh;
  background: linear-gradient(#000, #999);
}

th
{
font-size:20px;

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
</head>
<body class="hold-transition skin-purple sidebar-mini">
<div class= "wrapper">
 <%@ include file="TherapistHeader.jsp" %>
 
   <div class="content-wrapper">
    <br> 
		    <div class="box box-info" style="border-top: 3px solid #636; border-left: 3px solid #636; border-right: 3px solid #636;
 border-bottom: 3px solid #636; width: 80%; margin-left:10%; margin-top:3%; margin-right:10%; ">
 <div class="box-body" style="width:100%;  "> 
			
           
			  
            <div class="box-body box-profile" style= "width:20%; height:15%; float:right; margin-top:1%;">
              <img class="profile-user-img img-responsive img-circle" src="/ust/${Pic}" alt="User profile picture" >
			  </div>
             
		<div style="margin-left:10%;">
        <h2 style="font-size:30px;"><center><b> Report</b></center></h2>
        </div>
			
            <!-- /.box-header -->
  <div class="box-body table-responsive no-padding" style="margin-top:-3%; margin-left:-5%; width:120%;">
              <table class="table table-hover" style=" margin-left:10%; width:70%;" >
                <tr>
                  
				 
                  <th style="width:30%; border-color:white;"> </th>
                       <th style="width:30%; border-color:white;"> </th>
                            <th style="width:30%; border-color:white;"> </th>
                                 <th style="width:30%; border-color:white;"> </th>

                </tr>
              <tr>
                  <td><b>Patient Name:</b></td>
				   <td> ${patientName } </td>
                  <td><b>Therapist Name:</b></td>
				  <td></td>
                  
                </tr>
                <tr>
                  <td><b>Guardian Name:</b></td>
				  <td>${guardianName }</td>
                  <td><b>Sounds:</b></td>
				  <td>${patientProgressSound }</td>
                </tr>
                <tr>
                  <td><b>Date of Birth:</b></td>
				  <td>${dOB }</td>
                  <td><audio src="" controls="true" loop="true" autoplay="false" ></audio></td>
				  <td></td>
                </tr>
				 <tr>
                  <td><b>Age:</b></td>
				  <td>${age }</td>
                  <td><b>Words:</b></td>
				  <td>${patientProgressWord }</td>
                </tr>
				 <tr>
                  <td><b>Allergies:</b></td>
				  <td>${Allergies }</td>
                  <td><audio src="" controls="true" loop="true" autoplay="false" ></audio></td>
                <td></td>
				</tr>
				 <tr>
                  <td><b>Contact No.</b></td>
				  <td>${contactNum }</td>
                  <td><b>Sentences:</b></td>
				  <td>${patientProgressSentences }</td>
                </tr>
				<tr>
                  <td><b>Assigned Lesson:</b></td>
                  <td>${lesson }</td>
				  <td><audio src="" controls="true" loop="true" autoplay="false" ></audio></td>
                <td></td>
				</tr>
              </table>
			  <br><br>
            </div>
            <!-- /.box-body -->
          </div>
        </div> 
        </div>
         
        </div> 
 
<script src="../ust/resources/components/Therapist/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>

<script src="../ust/resources/components/Therapist/bootstrap/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/morris/morris.min.js"></script>

<script src="../ust/resources/components/Therapist/plugins/sparkline/jquery.sparkline.min.js"></script>

<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<script src="../ust/resources/components/Therapist/plugins/knob/jquery.knob.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="../ust/resources/components/Therapist/plugins/daterangepicker/daterangepicker.js"></script>

<script src="../ust/resources/components/Therapist/plugins/datepicker/bootstrap-datepicker.js"></script>

<script src="../ust/resources/components/Therapist/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>

<script src="../ust/resources/components/Therapist/plugins/slimScroll/jquery.slimscroll.min.js"></script>

<script src="../ust/resources/components/Therapist/plugins/fastclick/fastclick.js"></script>

<script src="../ust/resources/components/Therapist/dist/js/app.min.js"></script>

<script src="../ust/resources/components/Therapist/dist/js/pages/dashboard.js"></script>

<script src="../ust/resources/components/Therapist/dist/js/demo.js"></script>
</body>
</html>
    