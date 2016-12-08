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
 

<% 
	String userId=request.getParameter("userId");
String itemId=request.getParameter("itemId");
String sellerId=request.getParameter("sellerId");
String price=request.getParameter("price");
String itemName=request.getParameter("itemName");
String image=request.getParameter("image");
    %>
<div class="top-bar" style="background: #c1bdba;">
	<div class="top-bar-left" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
			<li class="menu-text">Company Name</li>
		</ul>
	</div>
	<div class="top-bar-right" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
		
		<form action="Searchserv" method="post">
         <li><input type="search" name="search" style="height:30px; width:300px;" placeholder="Search"></li>
         <li>      
         <button type="submit" class="button" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229);padding: 10px;color: white;font-size: 15px;" >Search
          </button>       
         </li>
         </form>
		
		 <li>
          <form action="CartLookserv" method="post">
          <input type="hidden"  name="userId" value=<%=userId%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Cart
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
<div class="row" style="left:0;">
	
	<div >
		<h3><%=itemName%></h3>
		
		<form action="Cartserv" method = "post">
		<div class="row">
			Quantity
				<input type="number" name="quantity" value="1" min="1" max="5" size="20">
			<div  style="float: left;">Price
				<label style="font-size:1.5rem;"><%=price%>&&<%=userId%></label>
			</div>
		</div>
		
		<input type="hidden"  name="userId" value=<%=userId%> />
			<input type="hidden"  name="itemId" value=<%=itemId%> />
			<input type="hidden"  name="sellerId" value=<%=sellerId%> />
			<input type="hidden"  name="price" value=<%=price%> />
			<input type="hidden"  name="itemName" value=<%=itemName%> />
			<input type="hidden"  name="image" value=<%=image%> />
			<input type="submit"  class="button" name="AddToCart" value='AddToCart'/>
		
		</form>
	</div>
</div>

<div class="column row">
	<hr>
	<ul class="tabs" data-tabs id="example-tabs">
		<li class="tabs-title is-active"><a href="#panel1" aria-selected="true">Reviews</a></li>
		<li class="tabs-title"><a href="#panel2">Similar Products</a></li>
	</ul>
	
	<div class="tabs-content" data-tabs-content="example-tabs">
		<div class="tabs-panel is-active" id="panel1">
			<h4>Reviews</h4>
			<div class="media-object stack-for-small">
				<div class="media-object-section">
				</div>
				<div class="media-object-section" >
					<h5>Mike Stevenson</h5>
					<p>This like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you.</p>
				</div>
			</div>
			<div class="media-object stack-for-small">
				<div class="media-object-section">
				</div>
				<div class="media-object-section">
					<h5>Mike Stevenson</h5>
					<p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
				</div>
			</div>
			<div class="media-object stack-for-small">
				<div class="media-object-section"></div>
				<div class="media-object-section">
					<h5>Mike Stevenson</h5>
					<p>I'm going to improvise. Listen, there's something you should know about me... about inception. An idea is like a virus, resilient, highly contagious. The smallest seed of an idea can grow. It can grow to define or destroy you</p>
				</div>
			</div>
			<label id="myreview">
			My Review
			<textarea placeholder="None"></textarea>
			</label>
			<button class="button">Submit Review</button>
		</div>
		<div class="tabs-panel" id="panel2">
			<div class="row medium-up-3 large-up-5">
				<div class="column">
					<img class="thumbnail" src="http://placehold.it/350x200">
					<h5>Other Product <small>$22</small></h5>
					<p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
					<a href="#" class="button hollow tiny expanded">Buy Now</a>
				</div>
				<div class="column">
					<img class="thumbnail" src="http://placehold.it/350x200">
					<h5>Other Product <small>$22</small></h5>
					<p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
					<a href="#" class="button hollow tiny expanded">Buy Now</a>
				</div>
				<div class="column">
					<img class="thumbnail" src="http://placehold.it/350x200">
					<h5>Other Product <small>$22</small></h5>
					<p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
					<a href="#" class="button hollow tiny expanded">Buy Now</a>
				</div>
				<div class="column">
					<img class="thumbnail" src="http://placehold.it/350x200">
					<h5>Other Product <small>$22</small></h5>
					<p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
					<a href="#" class="button hollow tiny expanded">Buy Now</a>
				</div>
				<div class="column">
					<img class="thumbnail" src="http://placehold.it/350x200">
					<h5>Other Product <small>$22</small></h5>
					<p>In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam.</p>
					<a href="#" class="button hollow tiny expanded">Buy Now</a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="callout secondary">
	<div class="row">
		<div class="large-3 large-offset-2 columns">
			<ul class="menu vertical">
				<li><a href="#"><p style="font-weight:bold;">COMPANY NAME</p></a></li>
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
    