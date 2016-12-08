<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Search Result</title>
<link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
 <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){

  //LOGIN
  $('#login').click(function(e) {
    e.preventDefault();
    var id = $(this).attr('href');
    var maskHeight = $(document).height();
    var maskWidth = $(window).width();
    $('#mask').css({'width':maskWidth,'height':maskHeight});
    $('#mask').fadeIn(1000);  
    $('#mask').fadeTo("slow",0.5);  
    var winH = $(window).height();
    var winW = $(window).width();
    $(id).css('top',  winH/2-$(id).height()/2);
    $(id).css('left', winW/2-$(id).width()/2);
    $(id).fadeIn(2000);
  });
  
  //LOGIN
  $('#register').click(function(e) {
    e.preventDefault();
    var id = $(this).attr('href');
    var maskHeight = $(document).height();
    var maskWidth = $(window).width();
    $('#mask').css({'width':maskWidth,'height':maskHeight});
    $('#mask').fadeIn(1000);  
    $('#mask').fadeTo("slow",0.5);  
    var winH = $(window).height();
    var winW = $(window).width();
    $(id).css('top',  winH/2-$(id).height()/2);
    $(id).css('left', winW/2-$(id).width()/2);
    $(id).fadeIn(2000);
  });
  
  //Common for LOGIN and REGISTER
  $('.window #close').click(function (e) {
    e.preventDefault();
    $('#mask').hide();
    $('.window').hide();
  });   
  $('#mask').click(function () {
    $(this).hide();
    $('.window').hide();
  });
  
});
</script>
<style>
.log-in-form {
  border: 1px solid #cacaca;
  padding: 1rem;
  border-radius: 3px; 
  background-color:#fff;
}

#mask 
{
  position:absolute;
  left:0;
  top:0;
  z-index:9000;
  background-color:#000;
  display:none;
}
  
#boxes .window 
{
  position:absolute;
  left:0;
  top:0;
  display:none;
  z-index:9999;
}

#boxes #dialog1,#dialog2
{
  width:400px; 
}

#close{
 float:right;
}
.row{
  padding-left: .9375rem;
  padding-right: .9375rem;
}
.row #category{
  display: block;
  width:85%;
  float: left;
  height:100%;
}
.row #viewitems{
  display: block;
  float: right;
  width:15%;
  height:40px;
}
#viewitems .button{
  float:right;
  height:80%;
  line-height:0.2rem;
}
hr{
  padding: 0px;  
  margin-top:0.5rem;
  margin-bottom:0.5rem;
}
.expanded{
  font-size: 15px;
  height: 35px;
  padding: 10px;
}

#default{
  all: initial;
  * {
    all: unset;
  }
}

#profile{
  background-color:#ebebef;
  width: 70%;
  margin: 0 auto;
  height: 460px;
  border-collapse: collapse;
  border-left: 1px solid #d0d0d0;
  border-right: 1px solid #d0d0d0;
}
#profile #form{
  padding: 1rem;
}
#profile #col1{
  float:left;
  width:45%;
  height: 400px;
  margin-left: 1rem;
}
#profile #col2{
  float:right;
  width:45%;
  height: 400px;
  margin-right: 1rem;
}
#profile #header{
  background-color:#fcfcfa;
  height: 8%;
  position: relative; 
}
#header p {
   position: absolute;            
   top: 50%;                         
   transform: translate(0, -50%);
   padding:1rem;
   font-weight:bold;
}
.formInput{
    margin: auto;
    width: 60%;
    padding: 10px;
}

</style>

</head>
<%

String userName=request.getParameter("userId");
%>
<body>
<div class="top-bar" style="background: #c1bdba;">
  <div class="top-bar-left" style="background: #c1bdba;">
    <ul class="menu" style="background: #c1bdba;">
      <li class="menu-text">Firefox</li>
    </ul>
  </div>
  <div class="top-bar-right" style="background: #c1bdba;">
    <ul class="menu" style="background: #c1bdba;">
     <form action="Searchserv" method="post">
      <li><input type="search" style="height: 30px; width: 300px;"
						placeholder="Search" name="search"></li>
      <li>       
        <input type="hidden"  name="userId" value=<%=userName%> />
        <button type="submit" class="button" name="search" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229);padding: 10px;color: white;font-size: 15px;" >Search
        </button>       
        </li>
       
      </form>
      <li>
            <form action="Profileserv" method="post">
             <input type="hidden"  name="userId" value=<%=userName%> />
              <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px; font-size: 15px;">Profile Details
                  </button>
                </form>
          </li>
          <li>
                <form action="CartLookserv" method="post">
                 <input type="hidden"  name="userId" value=<%=userName%> />
                  <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:80px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Cart
                </button>
                </form>
          </li>
          <li>
          <form action="Postitemtempserv" method="post">
          <input type="hidden"  name="userId" value= <%=userName%> />
          
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Post a New Item
                </button>
        </form>
        </li>
        <li>
          <form action="Logoutserv" method="post">
          <input type="hidden"  name="userId" value=<%=userName%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Logout
                </button>
        </form>
        </li>
		      
    </ul>
  </div>
</div>

<div style="text-align: center;">
<br>
<br>
  <p style="text-align: center;">
  Item is posted  is successfully. 
  </p>
  <form action="Loginwelcome.jsp" method="post" style="font-size: 15px;padding: 15px; width: 150px; font-family: Menlo;">
  <input type="hidden" value=<%=userName%> name="userId" />
  <input class="button"  style="margin-left:15cm;" type="submit" value="Go Back to Shopping" />
  </form>
</div>

<div class="callout secondary" style="margin: auto; position: fixed;bottom: 0; width: 100%">
  <div class="row">
    <div class="large-3 large-offset-2 columns">
      <ul class="menu vertical">
        <li>
          <a href="#">
            <p style="font-weight:bold;">Firefox</p>
          </a>
        </li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Contact Us</a></li>
        <li><a href="#">Careers</a></li>
      </ul>
    </div>
    <div class="large-3 columns">
      <ul class="menu vertical">
        <li>
          <a href="#">
            <p style="font-weight:bold;">HELP</p>
          </a>
        </li>
        <li><a href="#">FAQ</a></li>
        <li><a href="#">Cancellation & Returns</a></li>
        <li><a href="#">Gift Cards</a></li>
      </ul>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
<script>
      $(document).foundation();
    </script>
<script type="text/javascript" src="https://intercom.zurb.com/scripts/zcom.js"></script>
</body>
</html>
