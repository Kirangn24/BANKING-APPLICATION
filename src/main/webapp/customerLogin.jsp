<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
    <style>
    .error {
	color: red;
}
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-image: url('culogin.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }

        form {
            max-width: 600px;
            background-color: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            margin-bottom: 20px;
        }

        h1 {
            color: rgb(255, 255, 255);
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin: 10px 0;
            font-weight: bold;
            color: rgb(255, 255, 255);
        }

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        .act {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        div.actions > * {
            margin-right: 280px;
            margin-left: 280px;
        }

        div.actions {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        a,
        .alternative-button {
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
            display: block;
            padding: 10px;
            color: #fff;
            text-align: center;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>

</head>

<body>


    <script>
        $(document).ready(function ($) {
            $("#loginForm").validate({
                rules: {
                    CAN: {
                        required: true,
                        minlength: 1
                    },
                    CP: {
                        required: true,
                        minlength: 4
                    }
                },
                messages: {
                    CAN: {
                        required: "Please enter the account number.",
                        minlength: "Account number must be at least 1 character."
                    },
                    CP: {
                        required: "Please enter the password.",
                        minlength: "Password must be at least 4 characters."
                    }
                }
            });
        });

        function myFun() {
            var x = document.getElementById("myInput");
            if (x.type === "password") {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }
    </script>

    <div class="act">
        <form method="post" action="Cuslogin" id="loginForm">
            <h1>CUSTOMER LOGIN</h1>
            <label for="account_number">Account Number:</label>
            <input type="text" name="CAN" required placeholder="Enter the account number">

            <label for="pin">PIN:</label>
            <input type="password" name="CP" id="myInput" required placeholder="Enter the password" >
            <input type="checkbox" onclick="myFun()" style="display: inline-block;"><span style="color: white;">Show Password</span><br><br>

            <input type="submit" value="Login">
            <a href="ForgotPin.html" style="background-color:rgb(0, 0, 0);;">Forgot Password</a>
        </form><br><br>

        <div class="actions">
            <a href="addPin.jsp" style=" background-color: #3498db">Dont Have A Pin</a>
            <a href="EmpLogin.jsp" style=" background-color: #3498db">Employee Login</a>
        </div>
    </div>
</body>

</html>
