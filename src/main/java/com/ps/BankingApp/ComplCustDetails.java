//package com.ps.BankingApp;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//@WebServlet("/ComplCustDetails")
//public class ComplCustDetails extends HttpServlet {
//
//    static {
//        // Load MySQL JDBC driver during class loading
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            throw new ExceptionInInitializerError(e);
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String query = "SELECT * FROM CUSTOMER";
//
//        try (
//                // Establish a connection to the database
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
//
//                // Create a statement
//                PreparedStatement preparedStatement = connection.prepareStatement(query);
//
//                // Execute the query and get the result set
//                ResultSet resultSet = preparedStatement.executeQuery();
//        ) {
//            out.println("<html><body><center>");
//            out.println("<h2>Customer Details</h2>");
//            out.println("<table border='1'><tr><th>customer_AccNum</th><th>Customer Name</th><th>Customer Phone</th><th>Customer EmailID</th><th>Account Balance</th><th>Customer Pin</th><th>UPDATE DETAILS</th><th>DELETE DETAILS</th></tr>");
//
//            while (resultSet.next()) {
//                int customer_Acc_Num = resultSet.getInt("ACCNO");
//                String customer_Name = resultSet.getString("ACCNAME");
//                String phone = resultSet.getString("PHONE");
//                int pin = resultSet.getInt("PIN");
//                String Email = resultSet.getString("EMAIL");
//                double balance = resultSet.getDouble("BALANCE");
//                
//                String Update = "<html><body><form method='post' action='update'><input type='hidden' name='accno' value='" + customer_Acc_Num + "'><input type='submit' value='Update'></form></body></html>";
//                String Delete = "<html><body><form method='post' action='delete'><input type='hidden' name='accno' value='" + customer_Acc_Num + "'><input type='submit' value='Delete'></form></body></html>";
//
//                out.println("<tr><td>" + customer_Acc_Num + "</td><td>" + customer_Name + "</td><td>" + phone + "</td><td>" + Email + "</td> <td>" + balance + "</td><td>" + pin + "</td><td>" + Update + "</td><td>" + Delete + "</td> </tr>");
//            }
//
//            out.println("</table>");
//            out.println("</center></body></html>");
//            
//            out.println("<html><body><center>");
//            out.println("<table border=''><tr><th><h2>Add Customer Details..?<a href='Add.html'><input type='submit' value='ADD'></a></h2></th></tr>");
//
//            out.println("</table>");
//            out.println("</center></body></html>");
//
//            out.println("<html><body><center><h2>Back to Employee Interface..?<a href='EmpLogin2.jsp'><input type='submit' value='BACK'></a></h2></center></body></html>");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            out.println("Error: " + e.getMessage());
//        } finally {
//            out.close();
//        }
//    }
//}





package com.ps.BankingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ComplCustDetails")
public class ComplCustDetails extends HttpServlet {

    static {
        // Load MySQL JDBC driver during class loading
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String query = "SELECT * FROM CUSTOMER";

        try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");

                // Create a statement
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                // Execute the query and get the result set
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            out.println("<html><body><center>");
            out.println("<h2>Customer Details</h2>");
            out.println("<table border='1'><tr><th>customer_AccNum</th><th>Customer Name</th><th>Customer Phone</th><th>Customer EmailID</th><th>Account Balance</th><th>Customer Pin</th><th>DELETE DETAILS</th></tr>");

            while (resultSet.next()) {
                int customer_Acc_Num = resultSet.getInt("ACCNO");
                String customer_Name = resultSet.getString("ACCNAME");
                String phone = resultSet.getString("PHONE");
                int pin = resultSet.getInt("PIN");
                String Email = resultSet.getString("EMAIL");
                double balance = resultSet.getDouble("BALANCE");

//                String Update = "<html><body><form method='post' action='update'>" +
//                        "<input type='hidden' name='accno' value='" + customer_Acc_Num + "'>" +
//                        "<input type='hidden' name='pin' value='" + pin + "'>" +
//                        "<input type='text' name='accname' placeholder='Enter Name'>" +
//                        "<input type='text' name='phone' placeholder='Enter Phone'>" +
//                        "<input type='text' name='mail' placeholder='Enter Email'>" +
//                        "<input type='submit' value='Update'>" +
//                        "</form></body></html>";
                String Delete = "<html><body><form method='post' action='delete'>" +
                        "<input type='hidden' name='accno' value='" + customer_Acc_Num + "'>" +
                        "<input type='submit' value='Delete'>" +
                        "</form></body></html>";

                out.println("<tr><td>" + customer_Acc_Num + "</td><td>" + customer_Name + "</td><td>" + phone + "</td><td>" + Email + "</td> <td>" + balance + "</td><td>" + pin + "</td><td>" + Delete + "</td> </tr>");
            }

            out.println("</table>");
            out.println("</center></body></html>");

            out.println("<html><body><center>");
            out.println("<table border=''><tr><th><h2>Add Customer Details..?<a href='Add.html'><input type='submit' value='ADD'></a></h2></th></tr>");

            out.println("</table>");
            out.println("</center></body></html>");

            out.println("<html><body><center><h2>Back to Employee Interface..?<a href='EmpLogin2.jsp'><input type='submit' value='BACK'></a></h2></center></body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        } finally {
            out.close();
        }
    }
}

