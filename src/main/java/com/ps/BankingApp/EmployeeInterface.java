package com.ps.BankingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
@WebServlet("/login")
public class EmployeeInterface extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String EID = req.getParameter("EMI");
		String  PASSWORD=req.getParameter("EP");
		String query="SELECT * FROM employee1 WHERE EMPID=? AND PASSWORD=?";
		String url = "jdbc:mysql://localhost:3306/employee1?user=root&password=tiger";
		Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(query);
			int EMPID = Integer.parseInt(EID);
			ps.setInt(1, EMPID); 
			ps.setString(2, PASSWORD);
			rs=ps.executeQuery();
			PrintWriter out =resp.getWriter();
			if(rs.next())
			{
				out.println("<h1><center>Employee Login Succefully</center></h1>"
						+"<h2><center>if you want to enter the Employee Interface?<a href='EmpLogin2.html'>YESS!!</a></center></h2>");
			}
			else {
				out.println("<h1>Invalid user ID and password.</h1>"
						
						+" <p>invalid user_id and password?..<a href='EmpLogin.html'>RESET</a></p>");			}



		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
