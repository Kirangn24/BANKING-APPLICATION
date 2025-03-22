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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AccNum = req.getParameter("WAC");
        String Amt = req.getParameter("WA");
        int ACCNUM = Integer.parseInt(AccNum);
        Double AMT = Double.parseDouble(Amt);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
             PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE accno=?");
             PrintWriter out = resp.getWriter()) {

            ps.setInt(1, ACCNUM);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    double amount = rs.getDouble("BALANCE");
                    if (AMT > 0 && AMT <= amount) {

                        String s2 = "UPDATE CUSTOMER SET BALANCE=BALANCE-? WHERE ACCNO=?";
                        try (PreparedStatement ps4 = con.prepareStatement(s2)) {
                            ps4.setDouble(1, AMT);
                            ps4.setInt(2, ACCNUM);
                            ps4.executeUpdate();

                           
                            out.println("<h1>Withdraw Successfully</h1>");
                            out.println("<h1>Withdraw Amount is: " + AMT + "</h1>");
                            out.println("<p><h2>Back to Customer Interface <a href='CustomerInterface.jsp'>RETURN?</a></h2></p>");
                          
                        }
                    } else {
                        out.println("<h1>Invalid Amount</h1>");
                        out.println("<h2>Available Balance is: " + amount + "</h2>");
                    }
                } else {
                    out.println("Invalid user");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
        }
    }
}
