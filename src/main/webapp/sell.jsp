<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Selling Form</title>
	<style>
		/* Center the form on the page */
		form {
			display: flex;
			flex-direction: column;
			align-items: center;
			margin: auto;
			max-width: 600px;
		}

		/* Style the input fields */
		input[type="number"], input[type="text"], input[type="file"] {
			width: 100%;
			padding: 12px 20px;
			margin: 8px 0;
			box-sizing: border-box;
			border: none;
			border-bottom: 2px solid #ccc;
			background-color: #f8f8f8;
		}

		/* Style the required input fields */
		input:required {
			border-color: red;
		}

		/* Style the sell button */
		button {
			background-color: #4CAF50;
			color: white;
			padding: 14px 20px;
			margin: 20px 0;
			border: none;
			cursor: pointer;
			width: 100%;
		}

		button:hover {
			opacity: 0.8;
		}

		/* Style the form container */
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}

		/* Style the form header */
		h2 {
			text-align: center;
			margin-top: 40px;
			margin-bottom: 20px;
		}
	</style>
</head>
<body>
	<h2>Book Selling Form</h2>
	<form action="Party_List" method="post" enctype="multipart/form-data">
		<label for="uid">USER ID</label>
		<input type="number" id="uid" name="uid" placeholder="ID" required=""><br>

		<label for="bookimg">IMAGE OF THE BOOK</label>
		<input type="file" id="bookimg" name="bookimg" size='10'><br>

		<label for="bookname">NAME OF THE BOOK</label>
		<input type="text" id="bookname" name="bookname"><br>

		<label for="bookprice">PRICE</label>
		<input type="text" id="bookprice" name="bookprice"><br>

		<button type="submit">SELL</button>
	</form>
</body>
</html>
