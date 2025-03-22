<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Details</title>
</head>
<body>
    <h2>Customer Details:</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
        <%-- You can use JSTL or scriptlets to loop through the customer data --%>
        <%
            // Assuming you have a List<Customer> customers in your Servlet
            // Iterate through the list and display each customer's information
            for (Customer customer : customers) {
        %>
        <tr>
            <td><%= customer.getId() %></td>
            <td><%= customer.getName() %></td>
            <td><%= customer.getEmail() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
