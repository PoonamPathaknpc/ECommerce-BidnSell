<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.IOException"%>
<%@ page import="java.net.InetSocketAddress"%>
<%@ page import="net.spy.memcached.MemcachedClient"%>


      
<% 

            String userName = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userid"))
                        userName = cookie.getValue();
                   
                }
            }
            
            System.out.println(userName);
            if (userName == null)
                response.sendRedirect("Login.jsp");
            
            
        %>

<!doctype html>
<!--author : firefox team -->
<html class="no-js" lang="en">
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<title>Items for SALE</title>
<link rel="stylesheet" href="http://dhbhdrzi4tiry.cloudfront.net/cdn/sites/foundation.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.0.0/foundation.css">
<link href='http://cdnjs.cloudflare.com/ajax/libs/foundicons/3.0.0/foundation-icons.css' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" type="text/css" href="style.css">
 <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="index.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
  .buttonbuy{
    background-color: 
  }
</style>
</head>
<body style="background:;">

<div class="top-bar" style="background: #c1bdba;">
  <div class="top-bar-left" style="background: #c1bdba;">
    <ul class="menu" style="background: #c1bdba;">
      <li class="menu-text">Items for SALE</li>
    </ul>
  </div>
  <div class="top-bar-right" style="background: #c1bdba;">
    <ul class="menu" style="background: #c1bdba;">
      <form action="Searchserv" method="post">
      <li><input type="search" name="search" style="height:30px; width:300px;" placeholder="Search"></li>
       <li>      
        <input type="hidden"  name="userId" value=<%=userName%> />
        <button type="submit" class="button" style="height:30px; line-height:0.3rem;background-color: rgb(43,155,229);padding: 10px;color: white;font-size: 15px;" >Search
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
          <input type="hidden"  name="userId" value=<%=userName%> />
          <button id="" class="button" type="submit"  style="height:30px; line-height:0.3rem;width:200px; background-color: rgb(43,155,229); padding: 10px;font-size: 15px;">Post an Item
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


<div class="row column text-center">
  <h2>Items</h2>
  <hr>
</div>

<div class="row small-up-2 large-up-4" id="firstDiv">
  
  <div class="row">
    <div class="column">
      <img class="thumbnail" src="1.jpg" name="iphone">
      <h5>Iphone 6s</h5>
      <p>$600</p>
      <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='1'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='600'/>
      <input type="hidden"  name="itemName" value='Iphone6s'/>
      <input type="hidden"  name="image" value='1.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
      
      
    </div>
    <div class="column">
      <img class="thumbnail" src="2.jpg" name="s4">
      <h5>Samsung Galaxy S4</h5>
      <p>$300</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='2'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='300'/>
      <input type="hidden"  name="itemName" value='samsungGalaxyS4'/>
      <input type="hidden"  name="image" value='2.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="3.jpg" name="iphone5s">
      <h5>iPhone 5S</h5>
      <p>$250</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='3'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='250'/>
      <input type="hidden"  name="itemName" value='Iphone5s'/>
      <input type="hidden"  name="image" value='3.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="4.jpg" name="dellinspiron">
      <h5>Dell Inspiron 15R</h5>
      <p>$400</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='4'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='400'/>
      <input type="hidden"  name="itemName" value='dellInspiron15R'/>
      <input type="hidden"  name="image" value='4.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
  </div>
</div>
<hr>
<div class="row small-up-2 large-up-4" id="secondDiv">
  
  <div class="row">
    <div class="column">
      <img class="thumbnail" src="5.jpg" name="acreChrome">
      <h5>Acer Chromepad 11</h5>
      <p>$180</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='5'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='180'/>
      <input type="hidden"  name="itemName" value='acerChromePad11'/>
      <input type="hidden"  name="image" value='5.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="6.jpg" name="macbookpro">
      <h5>Macbook Pro 13(Non-Retina)</h5>
      <p>$700</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='6'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='700'/>
      <input type="hidden"  name="itemName" value='macbookpro13'/>
      <input type="hidden"  name="image" value='6.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="7.jpg" name="nikonD">
      <h5>Nikon DSLR</h5>
      <p>$600</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%>/>
      <input type="hidden"  name="itemId" value='7'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='600'/>
      <input type="hidden"  name="itemName" value='nikonD'/>
      <input type="hidden"  name="image" value='7.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="8.jpg" name="nikonCool">
      <h5>Nikon Coolpix 15MP</h5>
      <p>$210</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='8'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='210'/>
      <input type="hidden"  name="itemName" value='nikonCool'/>
      <input type="hidden"  name="image" value='8.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
  </div>
</div>
<hr>
<div class="row small-up-2 large-up-4" id="thirdDiv">
  
  <div class="row">
    <div class="column">
      <img class="thumbnail" src="9.jpg" name="canonD53">
      <h5>Canon D5300</h5>
      <p>$900</p>
      <br>
      
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='9'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='900'/>
      <input type="hidden"  name="itemName" value='canonD53'/>
      <input type="hidden"  name="image" value='9.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="10.jpg" name="fire">
      <h5>Kindle Fire HD 8</h5>
      <p>$80</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='10'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='80'/>
      <input type="hidden"  name="itemName" value='fire'/>
      <input type="hidden"  name="image" value='10.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="11.jpg" name="surface">
      <h5>Microsoft Surface Pro 4</h5>
      <p>$900</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='11'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='900'/>
      <input type="hidden"  name="itemName" value='surface'/>
      <input type="hidden"  name="image" value='11.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
    <div class="column">
      <img class="thumbnail" src="12.jpg" name="samsungTab8">
      <h5>Samsung Galaxy Tab 8</h5>
      <p>$350</p>
       <form method="post" action="StaticCart.jsp" >
      <input type="hidden"  name="userId" value=<%=userName%> />
      <input type="hidden"  name="itemId" value='12'/>
      <input type="hidden"  name="sellerId" value='1'/>
      <input type="hidden"  name="price" value='350'/>
      <input type="hidden"  name="itemName" value='samsungTab8'/>
      <input type="hidden"  name="image" value='12.jpg'/>
      <input type="submit"  class="button" name="Buy" value='Buy' style="background-color: #1ab188" />
      </form>
    </div>
  </div>
</div>
<hr>

<div id="boxes">
  <div id="mask"></div>
</div>

<div id="boxes">
  <div id="mask"></div>
</div>

<div class="callout secondary" style="background: ;">
    <div class="large-3 large-offset-2 columns">
    <ul>
        <li><a href="#">Contact Us</a></li>
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


