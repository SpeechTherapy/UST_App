<%@ page language="java" contentType="text/html;UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


  <%@ include file="AdminHeaderCss.jsp" %> 
    <script type="text/javascript" src="/ust/resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
       <script type="text/javascript" src="/ust/resources/js/Controller/DbLesson.js"></script>
    
    <script type="text/javascript" src="/ust/resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>  
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
	background: #000;
	background: -moz-linear-gradient(#353535, #000);background: -webkit-linear-gradient(#353535, #000);
	background: -o-linear-gradient(#353535, #000);
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

    <div id="wrapper">
          <%@ include file="AdminHeader.jsp" %> 
      <div id="page-wrapper"  style="background-color:#222222; width:84%;  margin-left:7%;  margin-top:10%;" align="center">
        <div class="row text-center">
               <h1 style="color:#00CCCC;  margin-left:10%; font-size:70px; "><b>حرف تہجی</b></h1>
          


<c:forEach items="${lessonList}" var="item">

<center>

<td><a href="#openModal3">
<button  class="btn btn-default" style="margin:2%; align:center; width:5%;  height:6%; float:right; font-size:200%;"  onclick="sendAjax(<c:out  value="${item.getLessonId()}"/>)" >
<c:out  value="${item.getLesson()}"/></button></a></td>
</c:forEach>

<div id="openModal3" class="modalDialog">
	<div>
		<a href="#close" title="Close" class="close">X</a>
		<div id="wrapper" >
		 <center>
        <a href="/ust/SoundsAdminLesson" class="btn btn-default" style=" width:130%; margin-left:-130%; ">Sounds</button></a><br><br>
  <a href="/ust/WordsAdminLesson" class="btn btn-default" style=" width:130%; margin-left:-130%; ">Words</button></a><br><br>
  
 <a href="/ust/SentencesAdminLesson" class="btn btn-default" style=" width:130%; margin-left:-130%;">Sentences</button></a>
 </center>
		</div>
		</div>
		</div>
 <%@ include file="AdminFooter.jsp" %> 

</body>
</html>

