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

@WebServlet("/adpin")
public class AddUserPin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AccNumber = req.getParameter("AN");
        String UPIN = req.getParameter("UP");
        String UQuery = "UPDATE CUSTOMER SET PIN=? WHERE ACCNO=? ";
        String IQuery = "INSERT INTO CUSTOMER (ACCNO, PIN) VALUES (?, ?)";
        String url = "jdbc:mysql://localhost:3306/employee1?user=root&password=tiger";
        Connection con = null;
        PreparedStatement UPs = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url);

            // Check if PIN already exists for the account
            UPs = con.prepareStatement(UQuery);
            UPs.setInt(1, Integer.parseInt(UPIN));
            UPs.setInt(2, Integer.parseInt(AccNumber));
            int updatedRows = UPs.executeUpdate();

            if (updatedRows > 0) {
                // PIN was updated successfully
                System.out.println("PIN updated successfully");
                PrintWriter out = resp.getWriter();
                out.println("<h1>PIN updated successfully.</h1>"
                        + "<h2><p>If you want to log in:<a href='customerLogin.jsp'>Customer Login</a></p></h2>");
            } else {
                // PIN does not exist. Proceeding with the insert.
                System.out.println("PIN does not exist for this account. Proceeding with the insert.");

                // You can add your insert logic here if needed
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (UPs != null) {
                    UPs.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
