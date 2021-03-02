<!DOCTYPE html>
<%@page import="com.Signup"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<title>Fetch</title>
</head>
<body>
    <header style="height: 30px;background-color: aqua;">
    You are logged in as : <b>${sessionScope.data.name}</b> 
    
    </header>
    <div class="container">
        <img alt="" src="images/dblogo.jpg" style="height: 250px;">
         <h3>People who have signed up: </h3>
         <%
            //this called jsp scriptlet tag
            //where we can write all java code inside jsp pages
            //req.setAttribute("psignups", signups);
         //List<Signup> signups=new ArrayList<Signup>();
            List<Signup> fetch=(List<Signup>)request.getAttribute("psignups");
         %>
         <table class="table">
    <thead>
      <tr>
      <th>PID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Name</th>
          <th>Email</th>
            <th>Phone</th>
              <th>Gender</th>
              <th>DOE</th>
              <th>Actions: </th>
      </tr>
    </thead>
    <tbody>
    <%
     for(Signup sd:fetch){
    	 %>
				<tr>
					<td><%=sd.getPid()%></td>
					<td><%=sd.getUsername()%></td>
					<td><%=sd.getPassword()%></td>
					<td><%=sd.getName()%></td>
					<td><%=sd.getEmail()%></td>
					<td><%=sd.getPhone()%></td>
					<td><%=sd.getGender()%></td>
					<td><%=sd.getDoe()%></td>
					<td>
					<a href="DeleteServlet?ddata=<%=sd.getEmail()%>">
					  <img alt="" src="images/del.png">
					  </a>
					  &nbsp;
					   <a href="EditServlet?ddata=<%=sd.getEmail()%>">
					  <img alt="" src="images/edit.png">
					  </a>
					</td>
				</tr>
				<%
					}
				%>
    </tbody>
  </table>
         <a href="LogoutServlet">
<button type="button" class="btn btn-danger">Logout</button>
</a>
       
    </div>
</body>
</html>