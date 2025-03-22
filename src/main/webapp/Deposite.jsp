<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Change PIN</title>
  <style>
    body {
      background-image: url('kk1.png'); /* Replace with a valid background image URL */
      background-size: cover;
      background-color: darkseagreen;
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-size: 16px; /* Adjusted font size */
      line-height: 1.6; /* Adjusted line height for better readability */
    }

    .container {
		
      width: 100%;
      max-width: 400px;
      margin: 20px auto;
      padding: 30px;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    form {
		
		background-color: rgb(187, 187, 255);
      padding: 30px;
      margin: 10%;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .form-group input {
      width: 100%;
      padding: 8px;
      box-sizing: border-box;
    }

    .btn {
      background-color: #4CAF50;
      color: white;
      padding: 12px 15px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    
    .error {
	color: red;
}

    .btn:hover {
      background-color: #45a049;
    }
  </style>
  
  <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(document).ready(function($) {
		$("#deposite").validate({
			rules : {
				accountNumber : {
					required : true,
					minlength : 6
				},
				withdrawAmount : {
					required : true,
					minlength : 1
				},
				
			},
			messages : {
				accountNumber : {
					required : "Please enter the account number.",
					minlength : "Account number must be at least 6 characters."
				},
				withdrawAmount : {
					required : "Please enter the Amount to Deposite.",
					minlength : "Amount to be greater than  0."
				},
				
			}
		});
	});
</script>
</head>
<body>

  <div class="container">
    <form id="deposite" action="deposite" method="post">
      <div class="form-group">
        <label for="accountNumber">Account Number</label>
        <input type="text" id="accountNumber" name="DAC" placeholder="Enter Account Number" required>
      </div>

      <div class="form-group">
        <label for="withdrawAmount">Deposit Amount</label>
        <input type="text" id="withdrawAmount" name="DA" placeholder="Enter Amount to Deposit" required>
      </div>

      <input type="submit" value="Deposit" class="btn">
    </form>
  </div>

</body>
</html>
