<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<a class="button button-block" href="Signup.jsp" style="font-style: Menlo; text-align: center;background-color: black" />Sign-Up</a>
      <div class="tab-content">
        
                <div id="signup">
          <h1>Sign Up for Free</h1>

          <form action="Signupserv" method="post">

          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="fname" />
            </div>

            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text"required autocomplete="off" name="lname"/>
            </div>
          </div>

          <div class="field-wrap">
            <label>
              Email<span class="req">*</span>
            </label>
            <input type="email"required autocomplete="off" name="email"/>
          </div>

          <div class="top-row">
          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" required autocomplete="off" name="pwd"/>
          </div>
          <div class="field-wrap">
            <label>
              Complete Address<span class="req">*</span>
            </label>
            <input type="text" required autocomplete="off" name="faddr"/>
          </div>
           <div class="field-wrap">
              <label>
                City<span class="req">*</span>
              </label>
              <input type="text" required autocomplete="off" name="city"/>
            </div>
          </div>

          
          <div class="field-wrap">
            <label for="state"></label>
            <select class="state" id="state" name="state" style="background-color: black; width: 100%; height: 40px;color: grey; font-family: 'Titillium Web', sans-serif; font-size: 22px ">
            	  <option value="None" selected="selected">--Select State--</option>
            	  <option value="Maine">Maine</option>
                  <option value="New Hampshire">New Hampshire</option>
                  <option value="Vermont">Vermont</option>
                  <option value="Massachusetts">Massachusetts</option>
                  <option value="Connecticut">Connecticut</option>
                  <option value="Rhode Island">Rhode Island</option>
                  <option value="New York">New York</option>
                  <option value="New Jersey">New Jersey</option>
                  <option value="Pennsylvania">Pennsylvania</option>
                  <option value="Delaware">Delaware</option>
                  <option value="Maryland">Maryland</option>
                  <option value="Virginia">Virginia</option>
                  <option value="Florida">Florida</option>
                  <option value="Texas">Texas</option>
                  <option value="Kentucky">Kentucky</option>
                  <option value="Tennessee">Tennessee</option>
                  <option value="North Carolina">North Carolina</option>
                  <option value="South Carolina">South Carolina</option>
                  <option value="Georgia">Georgia</option>
                  <option value="Alabama">Alabama</option>
                  <option value="Mississippi">Mississippi</option>
                  <option value="Arkansas">Arkansas</option>
                  <option value="Louisiana">Louisiana</option>
                  <option value="Missouri">Missouri</option>
                  <option value="Oklahoma">Oklahoma</option>
                  <option value="Ohio">Ohio</option>
                  <option value="Nebraska">Nebraska</option>
                  <option value="Michigan">Michigan</option>
                  <option value="Indiana">Indiana</option>
                  <option value="Wisconsin">Wisconsin</option>
                  <option value="Illinois">Illinois</option>
                  <option value="Minnesota">Minnesota</option>
                  <option value="Iowa">Iowa</option>
                  <option value="North Dakota">North Dakota</option>
                  <option value="South Dakota">South Dakota</option>
                  <option value="Kansas">Kansas</option>
                  <option value="Colorado">Colorado</option>
                  <option value="New Mexico">New Mexico</option>
                  <option value="Arizona">Arizona</option>
                  <option value="Nevada">Nevada</option>
                  <option value="California">California</option>
                  <option value="Wyoming">Wyoming</option>
                  <option value="Montana">Montana</option>
                  <option value="Utah">Utah</option>
                  <option value="Idaho">Idaho</option>
                  <option value="Washington">Washington</option>
                  <option value="Oregon">Oregon</option>
                  <option value="Alaska">Alaska</option>
                  <option value="Hawaii">Hawaii</option>
                  <option value="West Virginia">West Virginia</option>
            </select>
          </div>

          <div class="field-wrap">
            <label>
              ZipCode<span class="req">*</span>
            </label>
            <input type="number" maxlength="5"  required autocomplete="off" name="zip"/>
          </div>
		<div class="field-wrap">
            <label>
              Phonenumber<span class="req">*</span>
            </label>
            <input type="number" maxlength="10"  required autocomplete="off" name="phn"/>
          </div>

          <button type="submit" class="button button-block"/>Get Started</button>

        </form>
      </div>
				
        <hr/>
        <button class="button button-block" onclick="location.href ='Login.jsp'" style="font-style: Menlo; text-align: center;" />Already have an account?</button>
    </div>
  </div>

  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="index.js"></script>

</body>
</html>
    