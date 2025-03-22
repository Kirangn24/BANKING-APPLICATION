<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Pin</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-size: cover;
            background-position: center;
            background-image: url(https://scontent.fblr20-3.fna.fbcdn.net/v/t1.18169-9/14100242_483778545163647_6783423617156952927_n.png?_nc_cat=101&ccb=1-7&_nc_sid=c2f564&_nc_ohc=BYtxShDiB1UAX-yF7ZY&_nc_ht=scontent.fblr20-3.fna&oh=00_AfC7IyQAnOKiWjjJqjFnNnd6ExLcXJ_s8CMWF_ylptBseA&oe=65A541D8);
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-container {
            max-width: 400px;
            width: 100%;
            padding: 20px;
            border-radius: 10px;
            background-color: rgb(255, 255, 189);
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        .form-container h1 {
            text-align: center;
        }

        .input-field {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .submit-btn {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .error-message {
            color: red;
            font-size: 12px;
            margin-top: 5px;
            display: block;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
    <script>
        $(document).ready(function ($) {
            $.validator.addMethod("different", function(value, element, param) {
                return value !== $(param).val();
            }, "Old and new pin should be different.");

            $("#changepin").validate({
                rules: {
                    p1: {
                        required: true,
                        minlength: 6
                    },
                    p2: {
                        required: true,
                        minlength: 4
                    },
                    p3: {
                        required: true,
                        minlength: 4,
                        different: "#accountPin"
                    },
                    p4: {
                        required: true,
                        minlength: 4,
                        equalTo: "#newPin"
                    }
                },
                messages: {
                    p1: {
                        required: "Please enter the account number.",
                        minlength: "Account number must be at least 6 characters."
                    },
                    p2: {
                        required: "Enter the old pin.",
                        minlength: "Pin should be at least 4 characters."
                    },
                    p3: {
                        required: "Please enter the new PIN.",
                        minlength: "PIN must be at least 4 characters.",
                        different: "Old and new pin should be different."
                    },
                    p4: {
                        required: "Please enter the confirm PIN.",
                        minlength: "PIN must be at least 4 characters.",
                        equalTo: "Mismatch password"
                    }
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
<form id="changepin" action="pin" method="post" class="form-container">
    <h1>Change Pin</h1>
    <label for="accountNumber">Account Number</label>
    <input type="text" id="accountNumber" placeholder="Enter Account Number" name="p1" required class="input-field">

    <label for="accountPin">Account Pin</label>
    <input type="password" id="accountPin" placeholder="Enter Account Pin" name="p2" required class="input-field">

    <label for="newPin">New Pin</label>
    <input type="password" id="newPin" placeholder="Enter New Pin" name="p3" required class="input-field">

    <label for="confirmPin">Confirm Pin</label>
    <input type="password"  placeholder="Confirm Pin" name="p4" required class="input-field">

    <input type="submit" value="Change Pin" class="submit-btn">
</form>
</body>
</html>
