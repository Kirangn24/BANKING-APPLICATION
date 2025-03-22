package com.ps.BankingApp;

import java.io.IOException;
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
@WebServlet("/update")
public class UpdateDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection con = null;
        PreparedStatement ps3 = null;
        String Uquery = "UPDATE CUSTOMER SET ACCNAME=?, PHONE=?, EMAIL=? WHERE ACCNO=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");

            int accno = Integer.parseInt(req.getParameter("accno"));
            int pin = Integer.parseInt(req.getParameter("pin"));

            if (validateAccount(con, accno, pin)) {
                ps3 = con.prepareStatement(Uquery);
                ps3.setString(1, req.getParameter("accname"));
                ps3.setString(2, req.getParameter("phone"));
                ps3.setString(3, req.getParameter("mail"));
                ps3.setInt(4, accno);

                int update = ps3.executeUpdate();
                if (update > 0) {
                    resp.sendRedirect("ComplCustDetails");
                } else {
                    resp.getWriter().println("Failed to update the data. No records were affected.");
                }
            } else {
                resp.getWriter().println("Invalid account number or PIN. Update failed.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (ps3 != null) {
                    ps3.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean validateAccount(Connection con, int accno, int pin) throws SQLException {
        String query = "SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, accno);
            ps.setInt(2, pin);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
