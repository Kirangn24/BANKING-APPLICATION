package com.ps.BankingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement ps4 = null;
        String Dquery = "DELETE FROM CUSTOMER WHERE ACCNO=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
            System.out.println("Enter the account number: ");
            ps4 = con.prepareStatement(Dquery);

            int Accno = Integer.parseInt(req.getParameter("accno"));
            ps4.setInt(1, Accno);
            out.println("<html><body>");
            out.println("<h2>You have delete the data of ACCNO: " + Accno + "?</h2>");
            int n = ps4.executeUpdate();
            if (n > 0) {
                out.println("<h2>Data successfully deleted.</h2>");
            } else {
                out.println("<h2>Data deletion failed. Account number not found.</h2>");
            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        } finally {
            try {
                if (ps4 != null)
                    ps4.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Forward the request back to ComplCustDetails servlet
        RequestDispatcher dispatcher = req.getRequestDispatcher("/ComplCustDetails");
        dispatcher.forward(req, resp);
    }
}
