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
@WebServlet("/CheckBal")
public class CheckBalance extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession ses = req.getSession();
		
		String AccNO=(String)ses.getAttribute("can");
		String Pin=(String)ses.getAttribute("cp");
		Connection con=null;
		PreparedStatement ps3 = null;
	    String query="SELECT * FROM CUSTOMER WHERE ACCNO=? AND PIN=?";
	    ResultSet rs=null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
			ps3=con.prepareStatement(query);
			int AC=Integer.parseInt(AccNO);
			int PN=Integer.parseInt(Pin);
			ps3.setInt(1, AC);
			ps3.setInt(2, PN);
			rs=ps3.executeQuery();
			PrintWriter out=resp.getWriter();
			
			if(rs.next())
			{
				
				int BALANCE=rs.getInt(5);
				
				out.println("<h1><center>CHECK BANK BALANCE</center></h1>");
				out.println("<html><head></head><center><body bgcolor='lightblue'>"
				        + "<table border='1' width='500'>"
				        + "<tr><td><h3>Balance of account Holder:</h3></td><td><h3> " + BALANCE + "</h3></td></tr>"
				        + "</table></body></center></html>");
				out.println("<center><p><h2> Back to Customer Interface <a href='CustomerInterface.jsp'>RETURN?</a></h2></p></center>");
			}
			else {
				out.println("<html><head><body bgcolor='lightblue'><h1>Invalid ACCNO && Password!!!<h1>"
						 
				           + "</body></head></html>");
				out.println("<h2> Back to Customer Interface <a href='CustomerInterface.jsp'>RETURN?</a></h2>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
