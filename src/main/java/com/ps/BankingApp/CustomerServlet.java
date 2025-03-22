package com.ps.BankingApp;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			Connection connection = DbUtil.getConnection();
			
			 String query = "SELECT * FROM CUSTOMER";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            ResultSet resultSet = pstmt.executeQuery();

	            List<Customer> customers = new ArrayList<>();

	            while (resultSet.next()) {
	                Customer customer = new Customer();
	                customer.setId(resultSet.getInt("id"));
	                customer.setName(resultSet.getString("name"));
	                customer.setEmail(resultSet.getString("email"));
	                customers.add(customer);
	            }

	            req.setAttribute("customers", customers);
	            req.getRequestDispatcher("/customer.jsp").forward(req, resp);

	            resultSet.close();
	            pstmt.close();
	            connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
            req.getRequestDispatcher("/customer.jsp").forward(req, resp);
		}
	}
}
