<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Customer Details</title>
<style>
body {
	background-size: 100%;
	background-image:
		url(https://qph.cf2.quoracdn.net/main-qimg-755e9878f669ffae63f61c5836ed376c-lq);
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

h1 {
	margin-bottom: 20px;
	color: #333;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	cursor: pointer;
}

.error {
	color: red;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(document).ready(function($) {
		$("#loginForm").validate({
			rules : {
				AN : {
					required : true,
					minlength : 6
				},
				UP : {
					required : true,
					minlength : 4
				},
				confirmUP : {
					required : true,
					minlength : 4,
					equalTo : "#UP"
				}
			},
			messages : {
				AN : {
					required : "Please enter the account number.",
					minlength : "Account number must be at least 6 characters."
				},
				UP : {
					required : "Please enter the PIN.",
					minlength : "PIN must be at least 4 characters."
				},
				confirmUP : {
					required : "Please enter the confirmation PIN.",
					minlength : "PIN must be at least 4 characters.",
					equalTo : "PIN mismatch."
				}
			}
		});
	});
</script>
</head>
<body>
	<form id="loginForm" action="adpin" method="post">
		<h1>Add User Input PIN</h1>
		<input type="text" name="AN" id="AN" placeholder="Account Number">
		<input type="password" name="UP" id="UP"
			placeholder="User generate the PIN" maxlength="4"> <input
			type="password" name="confirmUP" placeholder="Confirm PIN"
			maxlength="4"> <input type="submit" value="Generate PIN">
	</form>
</body>
</html>
