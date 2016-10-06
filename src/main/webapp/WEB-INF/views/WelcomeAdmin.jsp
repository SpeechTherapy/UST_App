 <%@ include file="AdminHeaderCss.jsp" %> 
 
<script>
/** Used Only For Touch Devices **/
( function( window ) {

  // for touch devices: add class cs-hover to the figures when touching the items
  if( Modernizr.touch ) {

    // classie.js https://github.com/desandro/classie/blob/master/classie.js
    // class helper functions from bonzo https://github.com/ded/bonzo

    function classReg( className ) {
      return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
    }

    // classList support for class management
    // altho to be fair, the api sucks because it won't accept multiple classes at once
    var hasClass, addClass, removeClass;

    if ( 'classList' in document.documentElement ) {
      hasClass = function( elem, c ) {
        return elem.classList.contains( c );
      };
      addClass = function( elem, c ) {
        elem.classList.add( c );
      };
      removeClass = function( elem, c ) {
        elem.classList.remove( c );
      };
    }
    else {
      hasClass = function( elem, c ) {
        return classReg( c ).test( elem.className );
      };
      addClass = function( elem, c ) {
        if ( !hasClass( elem, c ) ) {
            elem.className = elem.className + ' ' + c;
        }
      };
      removeClass = function( elem, c ) {
        elem.className = elem.className.replace( classReg( c ), ' ' );
      };
    }

    function toggleClass( elem, c ) {
      var fn = hasClass( elem, c ) ? removeClass : addClass;
      fn( elem, c );
    }

    var classie = {
      // full names
      hasClass: hasClass,
      addClass: addClass,
      removeClass: removeClass,
      toggleClass: toggleClass,
      // short names
      has: hasClass,
      add: addClass,
      remove: removeClass,
      toggle: toggleClass
    };

    // transport
    if ( typeof define === 'function' && define.amd ) {
      // AMD
      define( classie );
    } else {
      // browser global
      window.classie = classie;
    }

    [].slice.call( document.querySelectorAll( '.team-grid__member' ) ).forEach( function( el, i ) {
      el.querySelector( '.member__info' ).addEventListener( 'touchstart', function(e) {
        e.stopPropagation();
      }, false );
      el.addEventListener( 'touchstart', function(e) {
        classie.toggle( this, 'cs-hover' );
      }, false );
    } );

  }

})( window );

</script>    
	 

    <script type="text/javascript" src="../resources/components/AdminScreen/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="../resources/components/AdminScreen/bootstrap/js/bootstrap.min.js"></script>   
    
	<style>
	
	
	</style>
</head>
<body><div id="wrapper">
        
 <%@ include file="AdminHeader.jsp" %> 

       <div class="box box-info" style="width:98%; margin-left:1%; height:60%;">
      <div class="box-body">
        <p>&nbsp;</p>
        <p>&nbsp;</p>
      <img src="../resources/images/Speech-header1.jpg" width="80%;"    style=" alignment-adjust:central; margin-top:-6%; margin-left:7%; height:40%;"></div>
    </div>
      <aside></aside>
      <a href="AdminBlog.jsp" > <img src="../resources/images/download.jpg" width="15%"    style=" alignment-adjust:central;  margin-left:8%; height:15%; margin-top:2%;"></div>
    <div style="color:white; width:20%; height:10%; float:right; margin-top:-12%; margin-right:40%;">
  <h2 style="color:white;">Blogs</h2>
  <p>Checkout blogs!</p>
</div>
    </a>
    </aside>
    </div>
    </div>
     <%@ include file="AdminFooter.jsp" %> 
    
</body>
</html>
