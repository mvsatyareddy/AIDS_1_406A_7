<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sell or Buy Books</title>
	<style>
		
		body {
  font-family: Arial, sans-serif;
  background-image: url('background.jpg');
  background-repeat: no-repeat;
  background-size: cover;
}
.btn-center {
			display: flex;
			justify-content: center;
			align-items: center;
			height: 50vh;
		}
		button {
			display: inline-block;
			margin: 20px;
			padding: 10px 20px;
			background-color: #4CAF50;
			color: white;
			border: none;
			border-radius: 5px;
			font-size: 18px;
			cursor: pointer;
			transition: background-color 0.3s ease;
		}
		
		button:hover {
			background-color: #3e8e41;
		}
		
		a {
			color: white;
			text-decoration: none;
		}
	</style>
</head>
<body>

<div class="btn-center">
	<button><a href="sell.jsp">SELL</a></button>
	<button><a href="buy.jsp">BUY</a></button>
</div>
</body>
</html>
