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
@WebServlet("/deposite")
public class Deposite extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String AccNum=req.getParameter("DAC");
		String Amt=req.getParameter("DA");
		int ACCNUM=Integer.parseInt(AccNum);
		Double AMT=Double.parseDouble(Amt);
		
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		PreparedStatement ps4=null;
		String query="SELECT * FROM CUSTOMER WHERE accno=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
			ps=con.prepareStatement(query);
			ps.setInt(1, ACCNUM);
			rs=ps.executeQuery();
			PrintWriter out=resp.getWriter();
			
			if(rs.next()) {
				double amount=rs.getDouble("BALANCE");
				if(amount>=0) {
					String s2 = "UPDATE CUSTOMER SET BALANCE=BALANCE+? WHERE ACCNO=?";
					ps4 = con.prepareStatement(s2);
					ps4.setDouble(1, AMT);
					ps4.setInt(2, ACCNUM);
					ps4.executeUpdate();
					out.println("<h1>Deposite Succefully</h1>");
					out.println("<h1>Deposite Amount is: "+AMT+"</h1>");
					out.println("<p><h2> Back to Customer Interface <a href='CustomerInterface.jsp'>RETURN?</a></h2></p>");
				}
				else {
					out.println("<h1>Deposite UnSuccefully!!</h1>");
					out.println("<a href='customerLogin.jsp'>Back To Login</a>");
				}
			}
			else {
				out.println("<h1>Invalid user!!</h1>");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (ps4 != null) ps4.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

}
