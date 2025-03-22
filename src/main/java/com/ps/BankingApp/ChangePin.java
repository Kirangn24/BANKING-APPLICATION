package com.ps.BankingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/pin")
public class ChangePin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String AccNum=req.getParameter("p1");
		String Pin=req.getParameter("p2");
		String NPin=req.getParameter("p3");
		String CNPin=req.getParameter("p4");
		
		int ACCNUM=Integer.parseInt(AccNum);
		//int PIN=Integer.parseInt(Pin);
		//int NPIN=Integer.parseInt(NPin);
		//int CNPIN=Integer.parseInt(CNPin);
		
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		PreparedStatement ps4=null;
		String query="SELECT * FROM CUSTOMER WHERE accno=? and pin=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?user=root&password=tiger");
			ps=con.prepareStatement(query);
			ps.setInt(1, ACCNUM);
			ps.setString(2, Pin);
			rs=ps.executeQuery();
			PrintWriter out=resp.getWriter();
			
			if(rs.next()) {
				String pas=rs.getString(6);
				if(pas.equals(Pin)) {
					if(NPin.equals(CNPin)) {
						String s2 = "UPDATE CUSTOMER SET PIN=? WHERE ACCNO=?";
						ps4 = con.prepareStatement(s2);
						ps4.setString(1, NPin);
						ps4.setInt(2, ACCNUM);
						ps4.executeUpdate();
						out.println("<h1>Password changed, New password is: "+NPin+"</h1>");
						out.println("<a href='customerLogin.jsp'>Back To Login</a>");
					}
					else {
						out.println("check entered passwords");
					}
				}
				else {
					out.println("invalid password");
				}
			}
			else {
				out.println("Invalid password");
			}
			
		


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

}
