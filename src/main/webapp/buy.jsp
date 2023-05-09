<%@page import="java.util.Base64"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="container">
<div class="card-header my-3">Available Books</div>
<div class="row">
<%
try {
	Driver dob =new oracle.jdbc.driver.OracleDriver();
	DriverManager.registerDriver(dob);
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password");
	PreparedStatement pstmt=con.prepareStatement("select * from books");
	ResultSet rs=pstmt.executeQuery();
	 while (rs.next()) {
	        String bookname = rs.getString("bookname");
	        String price = rs.getString("bookprice");
	        String encodedImage = rs.getString("bookimg");
	        byte[] partyLogo = Base64.getDecoder().decode(encodedImage);
	%>

					<div class="col-md-3 my-3">
						<div class="card w-100" style="width: 18rem;">
						  <img src="<%= partyLogo == null ? "" : "data:image/jpg;base64," + Base64.getEncoder().encodeToString(partyLogo) %>" class="card-img-top" alt="no img">
						  <div class="card-body">
						    <h5 class="card-title">BOOK NAME: <%=bookname%></h5>
						    <h5 class="card-title">PRICE: <%=price%></h5>
						    <a class="btn btn-primary" href="buyed.html">BUY THIS</a>
						  </div>
						</div>
					
		</div>
	<%
	    }
    
}
catch(Exception e)
{
	
}
%>
</div>
</div>
</body>
</html>