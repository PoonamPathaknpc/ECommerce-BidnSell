<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<title>Product Name</title>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Item Opened</title>
<link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>

<style>
.button, .expanded{
	background-color: rgb(43,155,229);
}
#star {
    line-height:10px;
}

#star img {
    width: 20px; 
	height: 20px;
}
#displaypic{
	width: 600px; 
	height: 300px;
}
#thumbpics{
	width: 200px; 
	height: 150px;
}
#description{
	margin-left:1rem;
}
#description li{
	list-style-type:disc;
}
</style>

</head>
<body>
 

<body>
<% String userId=request.getParameter("userId"); %>
<div class="top-bar" style="background: #c1bdba;">
	<div class="top-bar-left" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
			<li class="menu-text">Firefox</li>
		</ul>
	</div>
	<div class="top-bar-right" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
		<li>
			<form action="Searchserv" method="post">
			<li><input type="search" style="height:30px; width:300px;color: white" placeholder="Search"></li>
			<input type="hidden"  name="userId" value=<%=userId%> />
			<li><button type="button" class="buttonSearch" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229);; padding: 10px; " >Search</button></li>
			
			</form>
			
			</li>
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
          <form action="Postitemtempserv" method="post">
          <input type="hidden"  name="userId" value= <%=userId%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:160px; background-color: rgb(43,155,229); padding: 10px;">Post a New Item
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
<br>
<div class="row">
	<div class="medium-6 columns">
	<%
	String name=request.getParameter("name");
	
	String itemId=request.getParameter("itemId");
	String desc=request.getParameter("desc");
	
	System.out.println(itemId + " from jsp");
	System.out.println(userId + " from jsp");
	
	

%>
	</div>
	<div>
		<h3 align="center"><%=name%></h3>
		
		</br>
		<div>
			<h4 align="center">
				<%=desc%>
			</h4>
		</div>
		<div class="row">
			
			<div class="small-3 columns" style="float:right;">Price
	<form action="Bidrequestserv" class="button expanded" method="post" >
				<label style="font-size:1.5rem;"><input type="number" name="price" placeholder="amount"></label>
				
		
		<input type="hidden" name="userId" value=<%=userId%> />
		<input type="hidden" name="itemId" value=<%=itemId%> />
		<input type="submit"  style= "color:black;" value="Bid Now" />
		</form>
		</div>
		</div>
	</div>
</div>



<div class="callout secondary" style="bottom: 0; position: absolute; width: 100%">
	<div class="row">
		<div class="large-4 columns">
				<h5>Heading 5</h5>
			<p>Lorem ipsum dolor sit amet, pri ea vidisse delicatissimi. Nam mucius sadipscing te, et commodo utroque qui. Dolore blandit appetere id nec, ei veniam omnesque vis. Dicat tation molestie his ei. Mei adversarium instructior interpretaris eu, eu cum malis dolorum voluptatibus.</p>
		</div>
		<div class="large-3 large-offset-2 columns">
			<ul class="menu vertical">
				<li><a href="#"><p style="font-weight:bold;">Firefox</p></a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="#">Careers</a></li>
			</ul>
		</div>
		<div class="large-3 columns">
			<ul class="menu vertical">
				<li><a href="#"><p style="font-weight:bold;">HELP</p></a></li>
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
