<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <%@ include file="AdminHeaderCss.jsp" %> 
    <script type="text/javascript" src="/ust/resources/js/Controller/DeactivatePatient.js"></script>

  <script type="text/javascript" src="/ust/resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/ust/resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>  
	<style>
	body
	{
	color:#000000;
	}
		th {
	background-color: #208492;
	font-size: 18px;
}

.snip12 {
  font-family: 'Open Sans', Arial, sans-serif;
  position: fixed;
  float: left;
  overflow:hidden;
  margin: 20px ;
  
  min-width: 170px;
  max-width: 270px;
  width: 100%;
  height:60%;
  color: #ffffff;
  text-align: center;
  line-height: 1.4em;
  background-color: #141414;
}
.snip12 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
}
.snip12 .background {
  width: 100%;
  vertical-align: top;
  opacity:0.1;
  -webkit-filter: grayscale(100%) blur(10px);
  filter: grayscale(100%) blur(10px);
  -webkit-transition: all 2s ease;
  transition: all 2s ease;
}
.snip12 figcaption {
  width: 100%;
  padding: 15px 25px;
  position: absolute;
  left: 0;
  top: 50%;
}
.snip12 .profile {
  border-radius: 50%;
  position: absolute;
  bottom: 50%;
  left: 50%;
  max-width: 100px;
  opacity: 1;
  box-shadow: 3px 3px 20px rgba(0, 0, 0, 0.5);
  border: 2px solid rgba(255, 255, 255, 0.5);
  -webkit-transform: translate(-50%, 0%);
  transform: translate(-50%, 0%);
}
.snip12 h3 {
  margin: 0 0 5px;
  font-weight: 400;
}
.snip12h3 span {
  display: block;
  font-size: 0.6em;
  color: #f39c12;
  opacity: 0.75;
}
.snip12 i {
  padding: 10px 5px;
  display: inline-block;
  font-size: 32px;
  color: #ffffff;
  text-align: center;
  opacity: 0.65;
}
.snip12 a {
  text-decoration: none;
}
.snip12 i:hover {
  opacity: 1;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}
.snip12:hover .background,
.snip12.hover .background {
  -webkit-transform: scale(1.3);
  transform: scale(1.3);
}
   .modalDialog700 {
	position: fixed;
	font-family: Arial, Helvetica, sans-serif;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	background: rgba(0,0,0,0.8);
	z-index: 99999;
	opacity:0;
	-webkit-transition: opacity 400ms ease-in;
	-moz-transition: opacity 400ms ease-in;
	transition: opacity 400ms ease-in;
	pointer-events: none;
}



.modalDialog700:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog700 > div {
	
	width: 25%;
	height:70%;
	position: relative;
	margin: 10% auto;
	padding: 10px 40px 30px 20px;
	border-radius: 10px;
	background: #000;
	background: -moz-linear-gradient(#353535, #000);background: -webkit-linear-gradient(#353535, #000);
	background: -o-linear-gradient(#353535, #000);
}


.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.close {
	background:#000;
	color: #FFFFFF;
	line-height: 25px;
	position: absolute;
	right: -12px;
	text-align: center;
	top: -10px;
	width: 24px;
	text-decoration: none;
	font-weight: bold;
	-webkit-border-radius: 12px;
	-moz-border-radius: 12px;
	border-radius: 12px;
	-moz-box-shadow: 1px 1px 3px #000;
	-webkit-box-shadow: 1px 1px 3px #000;
	box-shadow: 3px 2px 3px #000;
}

.close:hover { background: #00d9ff; }




-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;
	</style>
</head>
<body>

    <div id="wrapper">
         <%@ include file="AdminHeader.jsp" %> 
       <div id="page-wrapper"  style="background-color:#222222;  margin-top:10%; width:84%;  margin-left:7%; " align="center"  >
            <div class="row">
                <div class="col-lg-12 text-center v-center">
<form method="get">
<div class="box">
            <div class="box-header">

<h1 style="color:#00CCCC; margin-left:5%;  font-size:40px;"><b>Patient's List</b></h1> <br><br>
  </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
               <table class="table table-bordered" style="width:68%; color:#fff; 
 float:right; margin-right:15%; background-color:transparent; "  >
                <tr>
                <th><center>Name</center></th>
                  <th><center>Registration Date</center></th>
                  <th><center>Status</center></th>
                </tr>
                
                
          
                
                <c:forEach items="${patientList }" var="item">
<tr>
						<td><a href="ViewProfilePatient" target="_blank" onclick="sendId('<c:out  value="${item.patientId}"/>')"><br>
						<c:out value="${item.patientName}"></c:out></a></td>
						<td><br>
						<c:out value="${item.createdDate}"></c:out></td>
						<c:choose>
							<c:when test="${item.user.userIsActive !='0'}">
								<td><button class="btn btn-danger" style="width:60%;  font-size:15px;"
									onclick="sendAjaxDeactivateButton('<c:out  value="${item.patientId}"/>',0)">Deactivate</button>
									
								</td>
							</c:when>
							<c:otherwise>
								<td><button class="btn btn-success" style="width:50%;  font-size:15px;"
									onclick="sendAjaxDeactivateButton('<c:out  value="${item.patientId}"/>',1)">Activate</button>
								</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
            <!-- /.box-body -->
</form>
                </div>
            </div>
            <div class="text-center">
                
            </div>
            <div class="row">
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->
    </div> 
                             <%@ include file="AdminFooter.jsp" %> 
   
</body>
</html>