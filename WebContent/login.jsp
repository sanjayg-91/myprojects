<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Login Form</title>
</head>
<body>
    <header style="height: 30px;background-color: blue;">
    
    </header>
    <div class="container">
        <img alt="" src="images/login.png" style="height: 100px;">
       <h2>Login Page:</h2> 
       <span style ="font-size: 18px; color: red; font-weight: bold; "> ${message} </span>
       <hr/>
       <span style ="font-size: 18px; color: blue; font-weight: bold; "> ${applicationScope.email} </span>
       <span style ="font-size: 18px; color: red; font-weight: bold; "> ${applicationScope.address} </span>
       <span style ="font-size: 18px; color: orange; font-weight: bold; "> ${applicationScope.phone} </span>
       <hr/>
<form action="LoginServlet" method="post">
<label>Username</label>
<input type="text" name="username" class="form-control" style="width: 60%;">

<label>Password</label>
<input type="password" name="password" class="form-control" style="width: 60%;">

<br/>
<button type="submit" class="btn btn-primary">Sign In</button>
<a href="signup.html">
<button type="button" class="btn btn-danger">Sign Up</button>
</a>
</form>
    
    </div>
</body>
</html>