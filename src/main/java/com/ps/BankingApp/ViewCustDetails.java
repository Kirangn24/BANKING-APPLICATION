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
import jakarta.servlet.http.HttpSession;

@WebServlet("/view")
public class ViewCustDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String accNum = (String) session.getAttribute("can");
        String accPin = (String) session.getAttribute("cp");

        String query = "SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";
        String url = "jdbc:mysql://localhost:3306/employee1?user=root&password=tiger";

        try {
            int accNumInt = Integer.parseInt(accNum);
            int accPinInt = Integer.parseInt(accPin);

            try (Connection con = DriverManager.getConnection(url);
                 PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, accNumInt);
                ps.setInt(2, accPinInt);

                try (ResultSet rs = ps.executeQuery()) {
                    PrintWriter out = resp.getWriter();

                    if (rs.next()) {
                        String name = rs.getString(2);
                        long phone = rs.getLong(3);
                        String mail = rs.getString(4);
                        double balance = rs.getDouble(5);

                        out.println("<html><head><style>"
                                + "body {"
                                + "  background-color:#87CEEB;"
                                + "  background-size: cover;"
                                + "  background-repeat: no-repeat;"
                                + "}"
                                + "</style></head><body><center>"
                                + "<H1> DETAILS OF THE CUSTOMER YOU HAVE LOGIN</H1>"
                                + "<table border='1'><tr><td><h2>name is:</h2></td><td><h2>" + name + "</h2></td></tr>"
                                + "<tr><td><h2>phone is:</h2></td><td><h2>" + phone + "</h2></td></tr>"
                                + "<tr><td><h2>Email is :</h2></td><td><h2>" + mail + "</h2></td></tr>"
                                + "<tr><td><h2>balance is:</h2></td><td><h2> " + balance + "</h2></td></tr></table>"
                                + "</center></body></html>");
                        out.println("<br><br><h2><center>Back to Customer Interface</center></h2>");
                        out.println("<h3><center><a href='CustomerInterface.jsp'>RETURN BACK</a></center></h3>");
                    } else {
                        out.println("<html><head><style>"
                                + "body {"
                                + "  background-color: #FF0000; "
                                + "}"
                                + "</style></head><body><center>"
                                + "<h1>INVALID ACCOUNT NUMBER && PIN!!</h1>"
                                + "<br><br><h2><center>IF YOU WANT TO RELOGIN</center></h2>"
                                + "<h3><center><a href='viewDetails.html'>RESET</a></center></h3>"
                                + "</center></body></html>");
                    }
                }
            }

        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
