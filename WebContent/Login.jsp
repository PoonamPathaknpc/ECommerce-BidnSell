<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/bootstrap.css">
  <link rel="stylesheet" href="style.css">


</head>

<body>
  <div class="form">

<a class="button button-block" href="Login.jsp" style="font-style: Menlo; text-align: center;background-color: black" />Log In</a>

		
      <div class="tab-content">

				<div id="login">
          <h1>Welcome Back!</h1>
          
          <div >
		<c:if test="${not empty message}">
			<div  class="alert alert-dismissible alert-success">
				${message } 
			</div>
		</c:if>
		</div>

          <form action="Loginserv" method="post">
            <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email"required autocomplete="off" name="email"/>
          </div>

          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password"required autocomplete="off" name="pass"/>
          </div>

          <p class="forgot"><a href="#">Forgot Password?</a></p>

          <button class="button button-block"/>Log In</button>

          </form>
          <hr style="color: white"/>
        
        </div>

        

          <button class="button button-block" onclick="location.href='Signup.jsp'" style="font-style: Menlo; text-align: center;" />Sign-Up</button>

        </form>
      </div>
    </div>
  </div>

  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="index.js"></script>

</body>
</html>
    