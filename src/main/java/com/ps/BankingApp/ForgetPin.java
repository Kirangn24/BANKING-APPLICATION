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

@WebServlet("/forget")
public class ForgetPin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String AccNo = req.getParameter("AN");
        String Name = req.getParameter("AHN");

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM employee WHERE ACCNO=? and ACCNAME=?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
            ps = con.prepareStatement(query);
            int Accno = Integer.parseInt(AccNo);
            ps.setInt(1, Accno);
            ps.setString(2, Name);
            rs = ps.executeQuery();
            PrintWriter out = resp.getWriter();
            if (rs.next()) {
                int ACCNUM = rs.getInt(1);
                String ACCNAME = rs.getString(2);
                int PIN = rs.getInt(6);

                out.println("<html><body>"
                        + "<h1>Your ACCOUNT NUM IS: " + ACCNUM + "</h1>"
                        + "<h1>ACCOUNT HOLDER NAME IS: " + ACCNAME + "</h1>"
                        + "<h1>Your Password is: " + PIN + "</h1></body></html>");
                out.println("<html><body><h1>Back to Login</h1><a href='customerLogin.jsp'><input type='button' value='back'></a></body></html>");

            } else {
                out.println("<html><body><h1>Invalid user</h1></body></html>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
