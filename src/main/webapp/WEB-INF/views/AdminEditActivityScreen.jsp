<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="AdminHeaderCss.jsp" %> 


    <script type="text/javascript" src="/ust/resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/ust/resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>

    
	<style>
	body
	{
	color:#FFFFFF;
	}
	th {
	background-color: #208492;
	font-size: 18px;
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
	width: 600px;
	position: relative;
	margin: 10% auto;
	padding: 10px 30px 13px 50px;
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
	
	
	</style>
</head>
   <%@ include file="AdminHeader.jsp" %> 
   <div style="float:right; margin-right:5%; margin-top:-3.5%;">
  <a href="/ust/user/DbLesson"><i class=" fa fa-arrow-left fa-3x" >&nbsp;&nbsp;&nbsp;</i></a>
  <a href="/ust/WordsAdminLesson"><i class=" fa fa-arrow-right fa-3x"  ></i></a>
  </div>
  
        <div id="page-wrapper"  style="background-color:#222222; width:70%;  margin-left:22.5%; margin-top:8%; " align="center"  >
               <div class="row" >
                <div class="col-lg-12 text-center v-center">
                
<h1 style="color:#00CCCC;  font-size:40px;"><b>Activity </b></h1> 


<div>
<a href="#openModal212" ><i class="fa fa-edit fa-2x" 
 style="color:#0066FF; background-color:transparent;" ></i></a></div>
<div id="openModal212" class="modalDialog">

	<div>
		<a href="#close" title="Close" class="close">X</a>
		<h2 style="color:#fff;">Edit Activity</h2>
 
  		
       <label style="margin-top:-3%; margin-left:-58%;">Edit Picture:</label>
        <input type="file" name="image"  style="margin-top:-5%; margin-left:52%;"/><br>
    
   
         <label style="margin-top:-3%; margin-left:-58%;">Edit Video: </label>
  <input type="file" name="user_Video" accept="mp3/*"  style="margin-top:-5%; margin-left:52%;"/><br> 
 <button class="btn btn-default">Save</button>
      
</div>

</div>


 <div class="box-body" >
 <div class="img" style="margin-left:5%; margin-top:3%;">
  <img style="width:100%; height:70%;" src="" name="imgbox" id="imgbox">
</div>

  

         





                
                
                
                  
 
               

            </div>
            </div>
            </div>
            <!-- /.row -->

        </div>
    
   
    
                             <%@ include file="AdminFooter.jsp" %> 

    <!-- /#wrapper -->
       <script type="text/javascript" src="/ust/resources/js/Controller/SoundsAdminLesson.js"></script>

   
</body>
</html>