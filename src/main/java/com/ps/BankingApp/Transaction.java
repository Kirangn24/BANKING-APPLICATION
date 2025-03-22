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
@WebServlet("/transaction")
public class Transaction extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String FACCNO=req.getParameter("fan");
		String SACCNO=req.getParameter("san");
		String FPIN=req.getParameter("fp");
		String BAL=req.getParameter("amount");
		Connection con=null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
	    String query="SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";
	    ResultSet rs=null;
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
			ps1=con.prepareStatement(query);
			ps1.setString(1, FACCNO);
            ps1.setString(2, FPIN);
            rs = ps1.executeQuery();
            PrintWriter out=resp.getWriter();
            if(rs.next()) {
            	double balance = rs.getDouble("BALANCE");
            	if(balance>=Double.parseDouble(BAL)) {
            		ps2 = con.prepareStatement("UPDATE CUSTOMER SET BALANCE=BALANCE-? WHERE ACCNO=?");
            		ps2.setDouble(1, Double.parseDouble(BAL));
                    ps2.setString(2, FACCNO);
                    ps2.executeUpdate();
                    
                    // Add the amount to the recipient's account
                    ps2 = con.prepareStatement("UPDATE CUSTOMER SET BALANCE=BALANCE+? WHERE ACCNO=?");
                    ps2.setDouble(1, Double.parseDouble(BAL));
                    ps2.setString(2, SACCNO);
                    ps2.executeUpdate();
            		
                    out.println("<h1>Transaction Succeccful!</h1>");
                    out.println("<h2>Back to Customer Interface<a href='CustomerInterface.jsp'>Return</a></h2>");

            	}
            }else {
                // Insufficient balance
                out.println("Insufficient balance for the transaction.");
            }
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	    finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps1 != null) ps1.close();
                if (ps2 != null) ps2.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	    
	}
}
