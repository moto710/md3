
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign Up Form</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script type="application/x-javascript">
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); }
  </script>

  <link href="${pageContext.request.contextPath}/css/signUp.css" rel="stylesheet" type="text/css" media="all" />

  <link href="//fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,700,700i" rel="stylesheet">

</head>
<body>
<div class="main-w3layouts wrapper">
  <h1>Welcome to MT Coffee shop</h1>
  <div class="main-agileinfo">
    <div class="agileits-top">
      <form method="post">
        <input class="text" type="text" name="userName" placeholder="Username" required>
        <input class="text email" type="email" name="email" placeholder="Email" required>
        <input class="text" type="password" name="passWord" placeholder="Password" required>
        <input class="text w3lpass" type="password" name="rePassWord" placeholder="Confirm Password" required="">
        <input class="text" type="text" name="fullName" placeholder="Full Name" required>
        <input class="text" type="text" name="phone" placeholder="Phone Number" required>
        <input class="text" type="text" name="address" placeholder="Address" required>
        <div class="wthree-text">
          <label class="anim">
            <input type="checkbox" class="checkbox" required="">
            <span>I Agree To The Terms & Conditions</span>
          </label>
          <div class="clear"> </div>
        </div>
        <input type="submit" value="SIGNUP">
      </form>
      <p>Already have an Account? <a href="${pageContext.request.contextPath}/login?action=login"> Login Now!</a></p>
    </div>
  </div>
  <div class="colorlibcopy-agile">
    <p>© 2018 Colorlib Signup Form. All rights reserved | Design by <a href="https://colorlib.com/" target="_blank">Colorlib</a></p>
  </div>
  <ul class="colorlib-bubbles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
  </ul>
</div>
</body>
</html>
