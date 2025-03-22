<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Customer Interface</title>
<style>
body {
	background-image:url(a11.png);
	font-family: 'Arial', sans-serif;
	background-color: #f4f4f4;
	background-size: 100%;
	margin: 0;
	padding: 20px;
	text-align: center;
}

table {
	width: 50%;
	margin: 0 auto;
}

th, td {
	padding: 30px;
	text-align: center;
}

.custom-button {
	background-color: #007bff;
	color: #fff;
	padding: 20px;
	border: none;
	border-radius: 10px;
	cursor: pointer;
	width: 60%;
	font-size: 16px;
}
</style>
</head>

<body>
	<table>
		<tr>
			<th colspan="2">
				<h1 style="color: white;">CUSTOMER INTERFACE</h1>
			</th>
		</tr>
		<tr>
			<form action="CheckBal" method="post">
				<td><input type="submit" value="CHECK BALANCE"
					class="custom-button "></td>
			</form>
			<td><button class="custom-button"
					onclick="window.location.href='Transaction.jsp'">TRANSFER
					MONEY</button></td>
		</tr>
		<tr>
			<td><button class="custom-button"
					onclick="window.location.href='changePin.jsp'">CHANGE PIN</button></td>
			
			
			<form id="view-details-form" action="view" method="get">
				<input type="hidden" name="can" value="${sessionScope.can}" /> <input
					type="hidden" name="cp" value="${sessionScope.cp}" />
				<td><input type="submit" value="VIEW ACCOUNT"
					class="custom-button "></td>
			</form>
		</tr>
		<tr>
			<!-- Modify this line to navigate to Withdraw.html -->
			<td><button class="custom-button"
					onclick="window.location.href='Withdraw.jsp'">WITHDRAW</button></td>
			<td><button class="custom-button"
					onclick="window.location.href='Deposite.jsp'">DEPOSIT</button></td>
		</tr>
		<tr>
			<td colspan="2"><button class="custom-button"
					onclick="window.location.href='customerLogin.jsp'">EXIT</button></td>
		</tr>
	</table>
</body>

</html>
