<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Successful</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            background-image: url('emlgn.jpeg');
        }

        h1 {
            color: #333;
            text-align: center;
        }

        .grid-container {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            column-gap: 180px;
        }

        .grid-item {
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 10px;
            text-align: center;
            margin-bottom: 20px;
        }

        button {
            background-color: #007bff;
            color: #fff;
            padding: 8px 16px;
            border: 1px solid #0056b3;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 14px;
        }
    </style>
</head>

<body>
    <h1>Login Successful!!!</h1>

    <div class="grid-container">
        <div class="grid-item">
            <p>Customers Details: <button onclick="displayCustomerDetails()">Customer Details</button></p>
        </div>

        <div class="grid-item">
            <p>Add a customer data: <button onclick="window.location.href='Add.html'">Add Details</button></p>
        </div>

       <!--  <div class="grid-item">
            <p>Update a customer data: <button onclick="window.location.href='Update.html'">Update Details</button></p>
        </div> -->

        <div class="grid-item">
            <p>Delete customer data: <button onclick="window.location.href='DeleteDetails.html'">Delete Details</button></p>
        </div>

        <div class="grid-item">
            <p>View customer details: <button onclick="window.location.href='viewDetails.jsp'">View Details</button></p>
        </div>

        <div class="grid-item">
            <p>Go Back to Main Menu: <button onclick="window.location.href='EmpLogin.jsp'">Go to Main</button></p>
        </div>
    </div>

    <script>
        function displayCustomerDetails() {
            // Create a form dynamically
            var form = document.createElement("form");
            form.setAttribute("method", "post");
            form.setAttribute("action", "ComplCustDetails");

            // Append the form to the body
            document.body.appendChild(form);

            // Submit the form
            form.submit();
        }
    </script>
</body>

</html>
