<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.servlets.Bean.Cart"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Foundation | Welcome</title>
<link rel="stylesheet" href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<style>
#cart{
	width: 70%;
	margin: 0 auto;
	height: 500px;
	overflow: hidden;
	border-collapse: collapse;
	border-left: 1px solid #d0d0d0;
	border-right: 1px solid #d0d0d0;
}
#cart #header{
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
   
#cart #item-list{
	height: 74%;
	overflow-y: auto;
}
#cart #amount{
	background-color:#eeeeee;
	height: 10%;
}
#amount p {
   font-weight:bold;
   text-align:right;
   padding: 0.8rem 2rem;
}

#cart #place-order{
	background-color:#000000;
	margin: 0 auto;
	height: 8%;
}
#cart td{
	height: 90px;
}
table {
    border-collapse: collapse;
    border-style: hidden;
}
table td{
    background-color:#ffffff;
	border-bottom: 1px solid #d0d0d0;
	border-left: 1px solid #e2e2e2;
	text-align:center;
	position: relative;
	padding: 1rem 1rem 1rem 1rem;
}
table th {
	background-color:#eeeeee;
	border-bottom: 1px solid #d0d0d0;
	border-left: 1px solid #e2e2e2;
}
#place-order #button1 .button{
	display: block;
	width:50%;
	float: left;
	height:100%;
	background-color: rgb(43,155,229);
	font-size: 20px;
}
#place-order #button2 .button{
	display: block;
	float: left;
	width:50%;
	border-left: 1px solid #ffffff;
	height:100%;
	font-size: 20px;
}
.button.expanded{
	height:100%;
}
#cart-image{
	padding: 0rem 1rem;
}
#qty{
	width:25px;
	height:25px;
	padding:2px;
	margin : 0 auto;
	text-align:center;
}
#product_name{
	text-align:left;
	vertical-align:top;
}
#remove{
	position: absolute;
    bottom: 0.2rem;
    right: 0.5rem;
}
</style>

</head>
<body style="background-color: #c1bdba ">
<%
String username = (String)request.getAttribute("userId");

String status = (String)request.getAttribute("status");

%>
<div class="top-bar" style="background: #c1bdba;">
	<div class="top-bar-left" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
			<li class="menu-text">ECommerce Application</li>
		</ul>
	</div>
	<div class="top-bar-right" style="background: #c1bdba;">
		<ul class="menu" style="background: #c1bdba;">
		 <form action="Searchserv" method="post">
		 <input type='hidden' value=<%=username%> name='userId' />
			<li><input type="search" style="height:30px; width:300px;" placeholder="Search"></li>
			<li><button type="button" class="buttonSearch" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229); padding: 10px;" >Search</button></li>
			<li>
		 </form>
				<form action="Profileserv" method="post">
				<input type='hidden' value=<%=username%> name='userId' />
					<button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:160px; background-color: rgb(43,155,229); padding: 10px;margin-left: 10px;">Profile Details
      				</button>
      			</form>
			</li>
      		<li>
      			<form action="CartLookserv" method="post">
      			<input type='hidden' value=<%=username%> name='userId' />
      				<button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:80px; background-color: rgb(43,155,229); padding: 10px;">Cart
      			</button>
      			</form>
      		</li>
      		<li>
          <form action="Logoutserv" method="post">
          <input type="hidden"  name="userId" value=<%=username%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Logout
                </button>
        </form>
        </li>
		</ul>
	</div>
</div>

<div id="cart">
	<div id="header">
		<p>YOUR CART</p>
	</div>
	<div id="item-list">
		<table width="100%">
			<colgroup>
				<col width="10%">
				<col width="45%">
				<col width="10%">
				<col width="15%">
				<col width="15%">
			</colgroup>
			<tr>
				<th colspan="2">ITEM</th>
				<th>QTY</th>
				<th>PRICE</th>
				<th>SUBTOTAL</th>
			</tr>
			
			<%
			
			int count= (Integer)request.getAttribute("count");
			int total=0;
			
			%>
			<%
			if(status.equals("false"))
			{
			%>
			<p>There are <%=count %>items in your cart.</p>
			<% 
			}
			else
			{
				int j=0;
			for(int i=0;i<count;i++)
			{
				j++;
				
				String itemId=(String)request.getAttribute("ITEM_ID"+Integer.toString(j));
				String Item_Name=(String)request.getAttribute("ITEM_NAME"+Integer.toString(j));
				String quantity=(String)request.getAttribute("Quantity"+Integer.toString(j));
				String price=(String)request.getAttribute("Price"+Integer.toString(j));
				total=total+(Integer.parseInt(price))*Integer.parseInt(quantity);
				
				//int subtotal = Integer.parseInt(price)* Integer.parseInt(quantity);
			%>
			<tr><td style='padding:0;'>
			<td> <%=Item_Name%></td>
			<td><%=quantity %></td>
			<td><%=price%></td>
			
			
			<td>
			<form method='post' action='Cartremoveserv'>
			<input type='hidden' value=<%=username%> name='userId'/>
			
			<input type='hidden' value=<%=itemId %> name='itemId'/>
			<input type='submit'value='Remove'/>
			</form>
			</td>
			
			
			</tr>
			
			<%
			}
			
			}
			
			%>
			
			
			
		</table>
	</div>
	<div id="amount">
		<p>Amount Payable : <%=Integer.toString(total)%> </p>
	</div>
	<div id="place-order">
		<div id="button1">
		<form action="Loginwelcome.jsp" method="post" ><input type="hidden" class="button expanded" value=<%=username%> name="userId" /> <input type="submit" class="button expanded" value="CONTINUE SHOPPING" /></form>
			
		</div>
		<div id="button2">
			<form action="Checkoutserv" method="post" ><input type="hidden" class="button expanded" value=<%=username%> name="userId" /> <input type="submit" class="button expanded" value="PLACE ORDER" /></form>
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

<script src="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.js"></script>
<script>
      $(document).foundation();
</script>
<script type="text/javascript" src="https://intercom.zurb.com/scripts/zcom.js"></script>
</body>
</html>
