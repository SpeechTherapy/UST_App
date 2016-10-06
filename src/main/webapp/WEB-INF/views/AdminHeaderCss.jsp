
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin-UST</title>

    <link rel="stylesheet" type="text/css" href="/ust/resources/components/AdminScreen/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/ust/resources/components/AdminScreen/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="/ust/resources/components/AdminScreen/css/local.css" />
    
    <style>
#container {
    text-align: justify;
    -ms-text-justify: distribute-all-lines;
    text-justify: distribute-all-lines;
    width:100%;
margin-top:10%;
}
#container>div {
    width: 100px;
    height: 100px;
    vertical-align: top;
    display: inline-block;
    *display: inline;
    zoom: 1;
 	   
}
span {
    width: 100%;
    display: inline-block;
    font-size: 0;
    line-height: 0
}


.snip1344 {
  font-family: 'Open Sans', Arial, sans-serif;
  position: fixed;
  
  overflow:hidden;
  margin: 10px ;
  margin-left:4%;
  min-width: 1000px;
  max-width: 1000px;
  width: 1300%;
  height:80%;
  color: #ffffff;
  
  line-height: 1.4em;
  background-color: #141414;
}
.snip1344 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.25s ease;
  transition: all 0.25s ease;
}
.snip1344 .background {
  width: 1200%;
  vertical-align: top;
  opacity:0.1;
  -webkit-filter: grayscale(100%) blur(10px);
  filter: grayscale(100%) blur(10px);
  -webkit-transition: all 2s ease;
  transition: all 2s ease;
}
.snip1344 figcaption {
  width: 2000%;
  
 
  top: 2%;
}
.snip1344 .profile {
  border-radius: 50%;
  position: absolute;
 margin-top:-20%;
 margin-left: 5%;
  
  max-width: 800px;
  opacity: 1;
  box-shadow: 3px 3px 20px rgba(0, 0, 0, 0.5);
  border: 2px solid rgba(255, 255, 255, 0.5);
  -webkit-transform: translate(-50%, 0%);
  transform: translate(-50%, 0%);
}
.snip1344 h3 {
  margin: 0 0 5px;
  font-weight: 400;
}
.snip1344 h3 span {
  display: block;
  font-size: 0.6em;
  color: #f39c12;
  opacity: 0.75;
}
.snip1344 i {
  padding: 10px 5px;
  display: inline-block;
  font-size: 32px;
  color: #ffffff;
  text-align: center;
  opacity: 0.65;
}
.snip1344 a {
  text-decoration: none;
}
.snip1344 i:hover {
  opacity: 1;
  -webkit-transition: all 0.35s ease;
  transition: all 0.35s ease;
}
.snip1344:hover .background,
.snip1344.hover .background {
  -webkit-transform: scale(1.3);
  transform: scale(1.3);
}
   .modalDialog5 {
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



.modalDialog5:target {
	opacity:1;
	pointer-events: auto;
}

.modalDialog5 > div {
	
	width: 75%;
	height:85%;
	position: relative;
	margin: 5% auto;
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


.wrapper--team {
  
  
  background-color: #E9E7D0;
}


}
@media screen and (min-width: 64em) {
  .l-container {
    max-width: 64rem;
  }
}
@media screen and (min-width: 75em) {
  .l-container {
    max-width: 75rem;
  }
}

.team-grid {
  margin: 0;
  text-align: center;

}

.team-grid__member {
  font-family: $tisa;
  
  max-width: 100%;

  display: inline-block;

  width: 100%;


  box-sizing: border-box;
  
}

@media screen and (min-width: 28em) {
  .team-grid__member {
    width: 49%;
    max-width: none;
  }
}
@media screen and (min-width: 42em) {
  .team-grid__member {
    width: 32.5%;
  }
}
@media screen and (min-width: 62em) {
  .team-grid__member {
    width: 19.45%;
  } 
}

//////////////////////
// MODULE GRID
//////////////////////
.team-grid__member {
  position: fixed;

}

.team-grid__member img {

  display: block;
  border-radius:50%;
 
}

.member__info {
  color: #fff;
  height: 60%;
  width: 40%;
  position: fixed;
  
}

.member__name {
  font-size: 1rem;
  letter-spacing: 1px;
  line-height: 1.2rem;
  
  padding: 0 12px;
}

.member__title {
  margin-bottom: 0.75rem;
  font-size: 0.8rem;
  font-weight: normal;
  line-height: 1rem;
  padding: 0 1.5rem;
}


// FIX THE TOUCH METHOD
//.no-touch .team-grid__member:hover .member__info,



// ----- Middle Alignment Vertical ----- //
.member__info {

  display: block;
  height: 100%;
  }

.center-vert-content {
  display:block;

}
</style>
    