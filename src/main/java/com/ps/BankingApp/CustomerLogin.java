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
@WebServlet("/Cuslogin")
public class CustomerLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ACCNO=req.getParameter("CAN");
		String PIN=req.getParameter("CP");
		HttpSession ses = req.getSession();
		
		ses.setAttribute("can", ACCNO);
		ses.setAttribute("cp", PIN);
		Connection con=null;
		PreparedStatement ps3 = null;
	    String query="SELECT * FROM customer WHERE ACCNO=? AND PIN=?";
	    ResultSet rs=null;
	    
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
			ps3=con.prepareStatement(query);
			int Accno=Integer.parseInt(ACCNO);
			int Pin=Integer.parseInt(PIN);
			ps3.setInt(1, Accno);
			ps3.setInt(2, Pin);
			rs=ps3.executeQuery();
			PrintWriter out=resp.getWriter();
			if(rs.next())
			{
				String ACCNAME=rs.getString(2);
				long PHONE=rs.getLong(3);
				String EMAIL=rs.getString(4);
				int BALANCE=rs.getInt(5);
				
				req.getRequestDispatcher("CustomerInterface.jsp").forward(req, resp);
			}
			else {
				out.println("<html><head><body bgcolor='lightblue'><h1>Invalid ACCNO && Password!!!<h1>"
						 
				           + "</body></head></html>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
