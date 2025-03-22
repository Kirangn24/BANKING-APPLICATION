<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transfer to Account</title>
<style>
body {
	background-size: 100%;
	background-image:
		url(https://paytmblogcdn.paytm.com/wp-content/uploads/2023/12/1_EPF_How-to-Transfer-Money-from-One-Bank-Account-to-Another-Bank-Account-800x500.webp);
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.d1 {
	background-color: rgb(255, 184, 149);
	max-width: 400px;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

.head {
	color: #333;
}

.but {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

.s1 {
	width: 100%;
	padding: 12px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

.error {
	color: red;
}

.s1:hover {
	background-color: #45a049;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(document)
			.ready(
					function($) {
						$("#transferForm")
								.validate(
										{
											rules : {
												fan : {
													required : true,
													minlength : 6
												},
												san : {
													required : true,
													minlength : 6
												},
												fp : {
													required : true,
													minlength : 4,
												},
												amount : {
													required : true,
													minlength : 1,
												}
											},
											messages : {
												fan : {
													required : "Please enter the account number.",
													minlength : "Account number must be at least 6 characters."
												},
												san : {
													required : "Please enter the recipient account number.",
													minlength : "Recipient account number must be at least 6 characters."
												},
												fp : {
													required : "Please enter the PIN.",
													minlength : "PIN must be at least 4 characters."
												},
												amount : {
													required : "Please enter the amount to transfer.",
													minlength : "Amount should be greater than '0'."
												}
											}
										});
					});
</script>
</head>
<body class="f1">
	<form id="transferForm" action="transaction" method="post">
		<div class="d1">
			<h1 class="head">Transfer to Account</h1>
			<input type="text" placeholder="Enter your account number" required
				id="fan" name="fan" class="but"><br> <input type="text"
				placeholder="Enter recipient account number" required id="san"
				name="san" class="but"><br> <input type="password"
				placeholder="Enter your PIN" required id="fp" name="fp" class="but"><br>
			<input type="text" placeholder="Enter amount" required name="amount"
				id="amount" class="but"><br> <input type="submit"
				value="Transfer" class="s1"><br>
		</div>
	</form>
</body>
</html>
