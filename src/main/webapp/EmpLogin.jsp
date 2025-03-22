<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Employee Login</title>
	<style>
		body {
			background-image: url(https://cdn.pixabay.com/photo/2014/02/27/16/10/flowers-276014_1280.jpg);
			font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			background-position: center;
			background-size: cover;
			margin: 0;
		}

		form {
			max-width: 80%;
			background-color: rgba(192, 192, 192, 0.9);
			padding: 20px;
			border-radius: 8px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			text-align: center;
			margin: auto;
		}

		h1 {
			color: #333;
			text-align: center;
		}

		label {
			display: block;
			margin: 10px 0;
			font-weight: bold;
			color: #555;
			text-align: left;
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
			color: #fff;
			cursor: pointer;
		}

		a {
			text-decoration: none;
			color: #3498db;
			font-weight: bold;
			text-align: right;
			display: block;
		}
	</style>

	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
	<script>
		$(document).ready(function ($) {
			$("#empLoginForm").validate({
				rules: {
					EMI: {
						required: true,
					},
					EP: {
						required: true,
					},
				},
				messages: {
					EMI: {
						required: "Please enter the Employee ID.",
					},
					EP: {
						required: "Please enter the password.",
					},
				},
				errorElement: "span",
				errorPlacement: function (error, element) {
					error.addClass("error-message");
					error.insertAfter(element);
				}
			});
		});
	</script>
</head>

<body>

	<form method="get" action="EmpLogin2.jsp" id="empLoginForm">
		<h1>EMPLOYEE LOGIN</h1>
		<label for="employee_id">Employee ID:</label>
		<input type="text" name="EMI" required>

		<label for="password">Password:</label>
		<input type="password" name="EP" required>

		<input type="submit" value="Login">

		<br><br>
		<a href="ForgotPin.html">Forgot Password?</a> <!-- Add an appropriate href value -->
	</form>

</body>

</html>
