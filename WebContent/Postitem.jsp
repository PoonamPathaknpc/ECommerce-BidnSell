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

body{
	font-family: Verdana;
}
</style>

</head>
<body>
<% String userId= (String)request.getAttribute("userId"); %>
<div class="top-bar" style="background: #c1bdba;">
	<div class="top-bar-left" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
			<li class="menu-text">Firefox</li>
		</ul>
	</div>
	<div class="top-bar-right" style="background-color : #c1bdba;">
		<ul class="menu" style="background-color: #c1bdba;">
		     <form action="Searchserv" method="post">
			<li><input type="search" style="height: 30px; width: 300px;"
						placeholder="Search" name="search"></li>
			<input type="hidden"  name="userId" value=<%=userId%> />
			<li><button type="button" class="buttonSearch" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229);; padding: 10px; " >Search</button>
			</li>
			</form>
			<li>
		        <form action="Profileserv" method="post">
		        <input type="hidden"  name="userId" value=<%=userId%> />
		          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:160px; background-color: rgb(43,155,229); padding: 10px;margin-left: 10px;">Profile Details
		              </button>
		            </form>
		      </li>
		      <li>
		            <form action="CartLookserv" method="post">
		            <input type="hidden"  name="userId" value=<%=userId%> />
		              <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:80px; background-color: rgb(43,155,229); padding: 10px;">Cart
		            </button>
		            </form>
		      </li>
		   <li>
          <form action="Logoutserv" method="post">
          <input type="hidden"  name="userId" value=<%=userId%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Logout
                </button>
        </form>
        </li>
		      
		</ul>
	</div>
</div>


<div class="row column text-center">
	<hr>
</div>
<div class="row" >
<div class="small-6 large-2 columns"><p style="text-align: center;">Menu</p>
	<hr>
	<form action="Viewbidserv" method="post">
	<input type="hidden"  name="userId" value=<%=userId%> />
		<button class="button link center" type="submit" style="font-size: 15px;padding: 15px;width: 180px">Posted Items</a><br>
	</button>
	</form>	 
	<form action="purchasedItems.html" method="post">
		<button class="button link center" type="submit" style="font-size: 15px;padding: 15px;width: 180px">Order History</a><br>
	</button>
	</form>

</div>
<%
System.out.println("postitem");
System.out.println(userId);
%>
<div class="small-6 large-2 columns row small-up-2 large-up-4" id="firstDiv" style="float: right;width: 80%;display: inline;">
	
	<div id="description">
	<br>
	<br>
	<br>
			<ol>
			<form action="Postitemserv" method="post">
					<input type="text" name="name" placeholder="ItemName">
					<input type="text" name="desc" placeholder="ItemDescription">
					<input type="hidden" name="userId" value=<%=userId%> />
					
					<input type="number" name="quantity" placeholder="item quantity" />
					
					<br>
					<span>
					<p>Gender:</p>
					<input type="radio" name="scopegender" class="gender" value="M"> Men &#09;
					<input type="radio" name="scopegender" class="gender" value="W" style="padding-left:5em"> Women
					<input type="radio" name="scopegender" class="gender" value="U" style="padding-left:5em"> Unisex<br>
					</p>
					</span>
					<span>
						<p> Category:</p>
						<input type="radio" name="dept" class="category" value="mobiles"> Mobiles &#09;
						<input type="radio" name="dept" class="category" value="camera" style="padding-left:5em"> 
						Cameras
						<input type="radio" name="dept" class="category" value="laptop"> Laptops &#09;
						<input type="radio" name="dept" class="category" value="tablet"> Tablets &#09;
						<br>
					</span><br>
					<input type="radio" name="used" class="category" value="new"> New &#09;
						<input type="radio" name="used" class="category" value="used"> Used &#09;


					<input type="submit" class="button" style="margin: auto;" value="PostItem">
					</form>
				
			</ol>
		</div>
		
		
	</div>
</div>



<div class="callout secondary">
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
