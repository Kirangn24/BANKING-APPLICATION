<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Withdraw Amount</title>
<style>
body {
    background-size: 100%;
    background-image: url(kk2.png); /* Replace with a relevant image URL */
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.container {
    width: 100%;
    max-width: 400px;
    background-color: aquamarine;
    margin: 50px auto; /* Adjusted margin for better positioning */
    padding: 30px; /* Adjusted padding for better spacing */
    border: 1px solid #ccc;
    border-radius: 10px;
    /* Increased border-radius for a more rounded appearance */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
    margin-bottom: 20px;
    /* Increased margin for better separation between form groups */
}

.form-group label {
    display: block;
    font-weight: bold;
    margin-bottom: 10px; /* Increased margin for better spacing */
}

.form-group input {
    width: 100%;
    padding: 12px; /* Increased padding for better input field size */
    box-sizing: border-box;
}

.btn {
    background-color: #4CAF50;
    color: white;
    padding: 12px 15px; /* Adjusted padding for better button size */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
    /* Added transition for a smoother hover effect */
}

.error {
    color: red;
}

.btn:hover {
    background-color: #45a049;
}
</style>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
    jQuery.validator.addMethod(
        "checkAccountNumber",
        function(value, element) {
            return /^[0-9]{6}$/.test(value);
        });

    jQuery(document).ready(function($) {
        $("#Withdraw").validate({
            rules: {
                accountNumber: {
                    required: true,
                    checkAccountNumber: true
                },
                withdrawAmount: {
                    required: true,
                    maxlength: 1
                },
            },
            messages: {
                accountNumber: {
                    required: "Please enter the account number.",
                    checkAccountNumber: "Account number must be 6 digits."
                },
                withdrawAmount: {
                    required: "Enter the amount to be withdrawn.",
                    maxlength: "Amount should be a single digit."
                },
            }
        });
    });
</script>
</head>
<body>

<div class="container">
    <form id="Withdraw" action="Withdraw" method="post">
        <div class="form-group">
            <label for="accountNumber">Account Number</label>
            <input type="text" id="accountNumber" name="WAC" placeholder="Enter Account Number" required>
        </div>

        <div class="form-group">
            <label for="withdrawAmount">Withdraw Amount</label>
            <input type="text" id="withdrawAmount" name="WA" placeholder="Enter Amount to Withdraw" required>
        </div>

        <input type="submit" value="Withdraw" class="btn">
    </form>
</div>

</body>
</html>
