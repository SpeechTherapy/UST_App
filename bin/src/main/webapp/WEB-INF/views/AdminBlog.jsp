<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <%@ include file="AdminHeaderCss.jsp" %> 
  
<!-- Custom Theme files -->

 <link href="../ust/resources/components/adminblog/css/adminstyle.css" rel='stylesheet' type='text/css' /> 	
<script src="/ust/resources/components/adminblog/js/jquery-1.11.1.min.js"></script>

<!-- animation-effect -->
<link href="/ust/resources/components/adminblog/css/animate.min.css" rel="stylesheet"> 
<script src="../ust/resources/components/adminblog/js/wow.min.js"></script>
<script>
 new WOW().init();
</script>
    <script type="text/javascript" src="../ust/resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../ust/resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>    
      <style>
	body
	{
	color:#FFFFFF;
	}
	
.modalDialog {
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

.modalDialog:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog > div {
	width: 30%;
	position: relative;
	margin: 15% auto;
	padding: 8px 90px 25px 0px;
	border-radius: 10px;
	background: #fff;
	background: -moz-linear-gradient(#fff, #999);
	background: -webkit-linear-gradient(#fff, #999);
	background: -o-linear-gradient(#fff, #999);
}


.button {
    background-color:#CCCCCC;
    border: none;
    color: black;
    padding: 10px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.close {
	background: #606061;
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
	box-shadow: 1px 1px 3px #000;
}

.close:hover { background: #00d9ff; }



-webkit-transition: opacity 400ms ease-in;
-moz-transition: opacity 400ms ease-in;
transition: opacity 400ms ease-in;


        div {
            padding-bottom:20px;
        }

   
   header img {
  float: left;
  width: 100px;
  height: 100px;
  background: #555;
}

.header h1 {
}
   
   </style>
 
</head>
<body>

    <div id="wrapper" style="width=:40%;">
         <%@ include file="AdminHeader.jsp" %> 
        
       <div id="page-wrapper"  style="background-color:#222222;  width:100%; "  >
        <div class="row ">
            
           <div class="well" style="height:5%;  ">
                      
                        <div class="header-bottom" >
		<div class="container" >
			<div class="logo wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
				<h1><a href="index.html">BLOGS</a></h1>
				<p><label class="of"></label>MANAGE ALL BLOGS<label class="on"></label></p>
			</div>
		</div>
	</div>
<!-- banner -->

<div class="banner">
<div class="container">	
		<h2>Urdu Speech Therapy</h2>
		<p>Urdu Speech Therapy Application is a clinical program aimed at improving speech of communication disorder due to articulation problem , hearing impaired with and without gadgets(Hearing aids etc.) and normal people.
</p>
	</div>
</div>

	<!-- technology-left -->
	 <c:forEach items="${postList}" var="item">
	<!-- <div style="display:block;" > -->
	<div style="width:48%;display:inline-block;float:left;margin-left:1%;">
			<div class="w3ls">
				<div class="col-md-12 w3ls-left wow fadeInDown"  data-wow-duration=".8s" data-wow-delay=".2s">
					
					 <div class="tc-ch">
					 
						<div class="tch-img">
							<a href="singlepage.html">
							
							<img src="/ust/${item.getBlogpic() }" style="height:40%; width:70%;" ></a>
							
						</div>
					
						<h3><a href="singlepage.html"><c:out  value="${item.getBlogHeading()}"/></a></h3>
					<h6>BY <c:out  value="${item.getTherapist().getTherapistName()}"/></h6>
							<p>
							 <c:out  value="${item.getBlogBody()}"/>
							</p>
							   
							  
	<c:choose>
       <c:when test="${item.getStatus()!='0'}">
        <td><button class="btn btn-danger"  style="width:25%;  font-size:15px;"
         onclick="sendButton('<c:out  value="${item.getPostId()}"/>',0)">Deactivate</button>
        </td>
       </c:when>
       <c:otherwise>
        <td><button class="btn btn-success"  style="width:20%;  font-size:15px;"
        onclick="sendButton('<c:out  value="${item.getPostId()}"/>',1)">Activate</button>
        </td>
       </c:otherwise>
      </c:choose>
			<div style="float:right;">		
<a href="ViewCompleteBlog" class="btn btn-danger" style="width:90%;">
	Continue Reading</a></div>
						</div></div>
</div>
</div>
<!-- </div> --> 
                  
                   
                     </c:forEach></div></div>
        </div>    




		</div>
                         <%@ include file="AdminFooter.jsp" %> 
                             <script type="text/javascript" src="/ust/resources/js/Controller/BlogActivation.js"></script>
                         

</body>
</html>

