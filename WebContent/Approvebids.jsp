<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.servlets.Bean.SearchIteam"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<title>Product Name</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Item Opened</title>
<link rel="stylesheet"
	href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css'
	rel='stylesheet' type='text/css'>

<style>
.button, .expanded {
	background-color: rgb(43, 155, 229);
}

#star {
	line-height: 10px;
}

#star img {
	width: 20px;
	height: 20px;
}

#displaypic {
	width: 600px;
	height: 300px;
}

#thumbpics {
	width: 200px;
	height: 150px;
}

#description {
	margin-left: 1rem;
}

#description li {
	list-style-type: disc;
}
</style>

</head>
<%
	String userId = (String) request.getAttribute("userId");
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
					<li><input type="search" name="search"
						style="height: 30px; width: 300px;" placeholder="Search"></li>
					<li><input type="hidden" name="userId" value=<%=userId%> />
						<button type="submit" class="button"
							style="height: 30px; line-height: 0.3rem; background-color: rgb(43, 155, 229); padding: 10px; color: white; font-size: 15px;">Search
						</button></li>
				</form>
				<li>
					<form action="Profileserv" method="post">
						<input type="hidden" name="userId" value=<%=userId%> />

						<button id="" class="button" type="submit"
							style="height: 30px; line-height: 0.3rem; width: 200px; background-color: rgb(43, 155, 229); padding: 10px; font-size: 15px;">Profile
							Details</button>
					</form>
				</li>
				<li>
					<form action="CartLookserv" method="post">
						<input type="hidden" name="userId" value=<%=userId%> />
						<button id="" class="button" type="submit"
							style="height: 30px; line-height: 0.3rem; width: 80px; background-color: rgb(43, 155, 229); padding: 10px; font-size: 15px;">Cart
						</button>
					</form>
				</li>
				<li>
					<form action="Postitemtempserv" method="post">
						<input type="hidden" name="userId" value=<%=userId%> />
						<button id="" class="button" type="submit"
							style="height: 30px; line-height: 0.3rem; width: 200px; background-color: rgb(43, 155, 229); padding: 10px; font-size: 15px;">Post
							an Item</button>
					</form>
				</li>
				<li>
					<form action="Logoutserv" method="post">
						<input type="hidden" name="userId" value=<%=userId%> />
						<button id="" class="button" type="submit"
							style="height: 30px; line-height: 0.3rem; width: 200px; background-color: rgb(43, 155, 229); padding: 10px; font-size: 15px;">Logout
						</button>
					</form>
				</li>
			</ul>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="medium-6 large-5 columns""></div>
		<div class="medium-6 large-5 columns"
			style="margin: auto; float: left; padding: 10px; margin:;">
			<table>
				<tr>
					<th>User</th>
					<th>Bid Price</th>
					<th>Approve</th>
					<%
						int count = (Integer) request.getAttribute("count");

						int temp = 0;
						String c = Integer.toString(count);
						String status = (String) request.getAttribute("status");
						if (status == "true") {
							List<SearchIteam> it = new ArrayList();
							it = (ArrayList<SearchIteam>) request.getAttribute("SearchIteam");
							for (int i = 0; i < it.size(); i++) {
								SearchIteam item = (SearchIteam) it.get(i);
								String bidId = item.getitemid();
								//String used=(String)request.getAttribute("used");
								String biddername = item.getname();
								String price = item.getquantity();
					%>
				</tr>
				<tr>
					<td><%=biddername%></td>
					<td><%=price%></td>
					<td><form action="Biddingdoneserv" method="post">
							<input type="hidden" value=<%=bidId%> name=bidId /> <input
								type="hidden" value=<%=userId%> name=userId />
							<button id="" class="button" type="submit"
								style="height: 30px; line-height: 0.3rem; width: 160px; background-color: rgb(43, 155, 229); padding: 10px; margin: 10px;">Approve
								Bid</button>
						</form></td>
				</tr>
				<%
					}
					} else {
				%>

				<tr><p>There are no Bids for this product till now.</p></tr>

				<%
					}
				%>


			</table>
		</div>
	</div>


	<br>
	<div class="callout secondary"
		style="position: absolute; width: 100%; bottom: 0; height: 100px">
		<div class="row">
			<div class="large-4 columns">
				<h5>Heading 5</h5>
				<p>Lorem ipsum dolor sit amet, pri ea vidisse delicatissimi. Nam
					mucius sadipscing te, et commodo utroque qui. Dolore blandit
					appetere id nec, ei veniam omnesque vis. Dicat tation molestie his
					ei. Mei adversarium instructior interpretaris eu, eu cum malis
					dolorum voluptatibus.</p>
			</div>
			<div class="large-3 large-offset-2 columns">
				<ul class="menu vertical">
					<li><a href="#"><p style="font-weight: bold;">Firefox</p></a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Careers</a></li>
				</ul>
			</div>
			<div class="large-3 columns">
				<ul class="menu vertical">
					<li><a href="#"><p style="font-weight: bold;">HELP</p></a></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">Cancellation & Returns</a></li>
					<li><a href="#">Gift Cards</a></li>

				</ul>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	<script
		src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
	<script>
		$(document).foundation();
	</script>
	<script type="text/javascript"
		src="https://intercom.zurb.com/scripts/zcom.js"></script>
</body>
</html>
