<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page import="java.util.ArrayList"%>


<!doctype html>
<html class="no-js" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Search Result</title>
<link rel="stylesheet"
	href="https://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link
	href='https://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css'
	rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//LOGIN
		$('#login').click(function(e) {
			e.preventDefault();
			var id = $(this).attr('href');
			var maskHeight = $(document).height();
			var maskWidth = $(window).width();
			$('#mask').css({
				'width' : maskWidth,
				'height' : maskHeight
			});
			$('#mask').fadeIn(1000);
			$('#mask').fadeTo("slow", 0.5);
			var winH = $(window).height();
			var winW = $(window).width();
			$(id).css('top', winH / 2 - $(id).height() / 2);
			$(id).css('left', winW / 2 - $(id).width() / 2);
			$(id).fadeIn(2000);
		});

		//LOGIN
		$('#register').click(function(e) {
			e.preventDefault();
			var id = $(this).attr('href');
			var maskHeight = $(document).height();
			var maskWidth = $(window).width();
			$('#mask').css({
				'width' : maskWidth,
				'height' : maskHeight
			});
			$('#mask').fadeIn(1000);
			$('#mask').fadeTo("slow", 0.5);
			var winH = $(window).height();
			var winW = $(window).width();
			$(id).css('top', winH / 2 - $(id).height() / 2);
			$(id).css('left', winW / 2 - $(id).width() / 2);
			$(id).fadeIn(2000);
		});

		//Common for LOGIN and REGISTER
		$('.window #close').click(function(e) {
			e.preventDefault();
			$('#mask').hide();
			$('.window').hide();
		});
		$('#mask').click(function() {
			$(this).hide();
			$('.window').hide();
		});

	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		function sortByGender(a, b) {
			return $(a).find('p.sex').text() > $(b).find('p.sex').text();

		}

		function sortByPop(a, b) {
			return $(a).find('p.pop').text() < $(b).find('p.pop').text();

		}

		function sortByDept(a, b) {
			return $(a).find('p.dept').text() > $(b).find('p.dept').text();
		}

		function sortByName(a, b) {
			return $(a).find('p.name').text() > $(b).find('p.name').text();
		}

		function reorderEl(el) {
			var container = $('#firstDiv');
			container.html('');
			el.each(function() {
				$(this).appendTo(container);
			});
		}

		$('#gender').click(function() {
			reorderEl($('li.n').sort(sortByPop));
		});

		$('#pop').click(function() {
			reorderEl($('li.n').sort(sortByPop));
		});

		$('#dept').click(function() {
			reorderEl($('li.n').sort(sortByDept));
		});

		$('#name').click(function() {
			reorderEl($('li.n').sort(sortByName));
		})
	});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				var test1;
				var test2;
				var test3;
				var test4;
				$("input[name$='gender']").click(function() {
					test1 = $(this).val();
					$("li.n > div.row").hide();
					$('.' + test3).not('.' + test2).not('.' + test1).hide();
					$('.' + test1).show();
				});
				$("input[name$='condition']").click(function() {
					test2 = $(this).val();
					$("li.n > div.row").hide();
					$('.' + test2).show();
					$('.' + test2).not('.' + test1).hide();
					$('.' + test3).not('.' + test2).not('.' + test1).hide();

				});
				$("input[name$='dept']").click(function() {
					test3 = $(this).val();
					$("li.n > div.row").hide();
					$('.' + test2).not('.' + test1).hide();
					$('.' + test3).not('.' + test2).not('.' + test1).hide();
					$('.' + test3).show();
				});
				$("input[name$='pop']").click(
						function() {
							test4 = $(this).val();
							$("li.n > div.row").hide();
							$('.' + test4).not('.' + test3).not('.' + test2)
									.not('.' + test1).hide();
							$('.' + test4).show();
						});

			});
</script>




<style>
.log-in-form {
	border: 1px solid #cacaca;
	padding: 1rem;
	border-radius: 3px;
	background-color: #fff;
}

#mask {
	position: absolute;
	left: 0;
	top: 0;
	z-index: 9000;
	background-color: #000;
	display: none;
}

#boxes .window {
	position: absolute;
	left: 0;
	top: 0;
	display: none;
	z-index: 9999;
}

#boxes #dialog1, #dialog2 {
	width: 400px;
}

#close {
	float: right;
}

.row {
	padding-left: .9375rem;
	padding-right: .9375rem;
}

.row #category {
	display: block;
	width: 85%;
	float: left;
	height: 100%;
}

.row #viewitems {
	display: block;
	float: right;
	width: 15%;
	height: 40px;
}

#viewitems .button {
	float: right;
	height: 80%;
	line-height: 0.2rem;
}

hr {
	padding: 0px;
	margin-top: 0.5rem;
	margin-bottom: 0.5rem;
}

.expanded {
	font-size: 15px;
	height: 35px;
	padding: 10px;
}

#default {
	all: initial; * {
	all: unset;
}

}
#firstDiv.n.row {
	font-family: Verdana;
	font-size: 16px;
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
					<li><input type="search" style="height: 30px; width: 300px;"
						placeholder="Search" name="search"></li>
						
					<li><input type="hidden" name="userId" value=<%=userId%> />
						<button type="submit" class="button" name="search"
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
							a New Item</button>
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


	<div class="row column text-center">
		<h5>Search Results</h5>
		<hr>
	</div>
	<div class="row" id="default">
		<div class="small-2 column">
			<h4 style="text-align: center;">Sort By</h4>
			<hr />
			<button class="button" id="gender"
				style="text-align: center; margin-left: 60PX;">Sort By
				gender</button>
			<button class="button" id="pop"
				style="text-align: center; margin-left: 50px;">Sort By
				Popularity</button>
			<button class="button" id="dept"
				style="text-align: center; margin-left: 45PX;">Sort By
				Department</button>
			<button class="button" id="name"
				style="text-align: center; margin-left: 60PX;">Sort By Name</button>
			<hr>
			<h4 style="text-align: center;">Filters</h4>
			<hr />
			<h5 style="text-align: center;">Gender</h5>
			<input type="radio" name="gender" value="M" />Male <input
				type="radio" name="gender" value="W" /> Female <input type="radio"
				name="gender" value="U" />Unisex <br>
			<hr>
			<h5 style="text-align: center;">Condition</h5>
			<input type="radio" name="condition" value="New" />New <input
				type="radio" name="condition" value="Used" />Used <br>
			<hr>
			<h5 style="text-align: center;">Department</h5>
			<input type="radio" name="dept" value="mobiles">Mobile <input
				type="radio" name="dept" value="cameras">Camera <input
				type="radio" name="dept" value="laptops">Laptop <input
				type="radio" name="dept" value="tablets">Tablet <br>
			<hr>
			<h5 style="text-align: center;">Popularity</h5>
			<input type="radio" name="pop" value="1" />1 <input type="radio"
				name="pop" value="2" />2 <input type="radio" name="pop" value="3" />3
			<input type="radio" name="pop" value="4" />4 <input type="radio"
				name="pop" value="5" />5 <input type="radio" name="pop" value="6" />6
			<input type="radio" name="pop" value="7" />7 <input type="radio"
				name="pop" value="8" />8 <input type="radio" name="pop" value="9" />9
			<input type="radio" name="pop" value="10" />10 <input type="radio"
				name="pop" value="11" />11 <input type="radio" name="pop"
				value="12" />12 <input type="radio" name="pop" value="13" />13 <input
				type="radio" name="pop" value="14" />14 <input type="radio"
				name="pop" value="15" />15 <input type="radio" name="pop"
				value="16" />16 <input type="radio" name="pop" value="17" />17 <input
				type="radio" name="pop" value="18" />18 <input type="radio"
				name="pop" value="19" />19 <input type="radio" name="pop"
				value="20" />20



			</ul>
			<h5 style="text-align: center;">Pr</h5>
			<hr />
		</div>
		<div class="small-6 large-2 columns row small-up-2 large-up-4"
			id="firstDiv" style="float: right; width: 80%; display: inline;">
			<%
				int count = (Integer) request.getAttribute("count");

				int temp = 0;

				int j = 0;

				for (int i = 0; i < count; i++) {

					j++;
					String used = (String) request.getAttribute("used" + Integer.toString(j));
					String name = (String) request.getAttribute("name" + Integer.toString(j));

					String dept = (String) request.getAttribute("dept" + Integer.toString(j));
					String pop = (String) request.getAttribute("pop" + Integer.toString(j));
					String desc = (String) request.getAttribute("desc" + Integer.toString(j));
					String itemId = (String) request.getAttribute("itemId" + Integer.toString(j));
					String gender = (String) request.getAttribute("gender" + Integer.toString(j));

					/*String item_id=item.getitemid();
					String dept=item.getdept();
					String pop=item.getpop();
					String desc=item.getdesc();
					String gender=item.getgender();
					String Used = item.getused();
					
					System.out.println(userId);				
					System.out.println(name);*/
			%>
			<li style="font-family: Verdana; font-size: 16px; list-style: none"
				class="n" style="list-style: none;">
				<%
					String classname = "'row" + " " + gender + " " + used + " " + dept + " " + pop + " row-vals'";
						System.out.println(classname);
				%>
				<div class=<%=classname%>>
					<b><p class="name" style="display: inline-block"><%=name%></p></b>
					

					<a style="float: right; right: 0;" class="button"
						href="Biditem.jsp?userId=<%=userId%>&name=<%=name%>&itemId=<%=itemId%>&desc=<%=desc%> ">
						Bid </a> <br>
					<b>Gender:</b>
					<p class="sex" style="display: inline"><%=gender%>
					</p>
					<br> <br>
					<b>Popularity: </b>
					<p class="pop" style="display: inline"><%=pop%>
					</p>
					<br> <br> <b>Department: </b>
					<p class="dept" style="display: inline"><%=dept%>
					</p>
					<br> <br> <b>Condition: </b>
					<p class="condition" style="display: inline-block"><%=used%></p>
					<a class="button" style="width: 100px; float: right; right: 0"
						href=" Biditem.jsp?userId=<%=userId%>&name=<%=name%>&desc=<%=desc%> " style="margin:auto; width:100px;">
						Open </a>
				</div>
			</li>
			<%
				}
			%>

		</div>

	</div>
	<div id="boxes">
		<div id="dialog1" class="window">
			<div class="row">
				<div id="form">
					<form>
						<div class="row log-in-form">
							<div id="close">
								<a>X</a>
							</div>
							<h4 class="text-center">LOGIN</h4>
							<label>Username <input type="text" placeholder="firefox">
							</label> <label>Password <input type="password"
								placeholder="Password">
							</label>
							<p>
								<a type="submit" class="button expanded">Log In</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="mask"></div>
	</div>
	</div>
	<div id="boxes">
		<div id="dialog2" class="window">
			<div class="row">
				<div id="form">
					<form post>
						<div class="row log-in-form">
							<div id="close">
								<a>X</a>
							</div>
							<h4 class="text-center">CREATE ACCOUNT</h4>
							<label>Username <input type="text"
								placeholder="ssp151830">
							</label> <label>Email <input type="text"
								placeholder="john.doe@gmail.com">
							</label> <label>Password <input type="password"
								placeholder="Password">
							</label> <label>Verify Password <input type="password"
								placeholder="Password">
							</label>
							<p>
								<a type="submit" href="profile.html" class="button expanded">Create
									Account</a>
							</p>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="mask"></div>
	</div>
	<div class="callout secondary">
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
					<li><a href="#">
							<p style="font-weight: bold;">Firefox</p>
					</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">Careers</a></li>
				</ul>
			</div>
			<div class="large-3 columns">
				<ul class="menu vertical">
					<li><a href="#">
							<p style="font-weight: bold;">HELP</p>
					</a></li>
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
