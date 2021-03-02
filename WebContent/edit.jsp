<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>Edit Form</title>
</head>
<body>
    <header style="height: 30px;background-color: teal;">
    
    </header>
    <div class="container">
        <img alt="" src="images/edit-logo.jpg" style="height: 200px;">
        
        <h2>Edit data:</h2>
        
<form action="UpdateServlet" method="post">
<label>Username</label>
<input type="text" name="username" value = "${signup.username}"class="form-control" style="width: 60%;">

<label>Password</label>
<input type="password" name="password" value = "${signup.password}" class="form-control" style="width: 60%;">


<label>Name</label>
<input type="text" name="name" value = "${signup.name}" class="form-control" style="width: 60%;">

<label>Email</label>
<input type="email" name="email" value = "${signup.email}" class="form-control" style="width: 60%;" readonly="readonly">

<label>Phone</label>
<input type="number" name="phone" value = "${signup.phone}" class="form-control" style="width: 60%;">


<label>Gender</label>
<select  name="gender" class="form-control" style="width: 60%;">
    <option ${signup.gender =='--Select--'?'selected':'' }>--Select--</option>
    <option ${signup.gender =='Male'?'selected':'' }>Male</option>
     <option ${signup.gender =='Female'?'selected':'' }>Female</option>
      <option ${signup.gender =='Other'?'selected':'' }>Other</option>
</select>

<br/>
<button type="submit" class="btn btn-primary">Update</button>
<a href="FetchServlet">
<button type="button" class="btn btn-danger">Back</button>
</a>
</form>
    
    </div>
</body>
</html>