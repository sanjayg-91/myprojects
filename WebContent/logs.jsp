<!DOCTYPE html>
<%@page import="filter.FilterCoffee"%>
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

<title>Logs</title>
</head>
<body>
    <header style="height: 30px;background-color: aqua;">
    You are logged in as : <b>${sessionScope.data.name}</b> 
    
    </header>
    <div class="container">
        <img alt="" src="images/dblogo.jpg" style="height: 250px;">
         <h3>People who have logged: </h3>
         <%
            //this called jsp scriptlet tag
            //where we can write all java code inside jsp pages
            //req.setAttribute("psignups", signups);
         //List<Signup> signups=new ArrayList<Signup>();
            List<String> requestMapped = FilterCoffee.requestMapped;
         %>
         <table class="table">
    <thead>
      <tr>
      <th>SNo.</th>
        <th>Logged:</th>
        
      </tr>
    </thead>
    <tbody>
    <%
    int count = 1;
     for(String log:requestMapped){
    	 %>
				<tr>
					<td><%=count++%></td>
					<td><%=log%></td>
					
					<td>
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