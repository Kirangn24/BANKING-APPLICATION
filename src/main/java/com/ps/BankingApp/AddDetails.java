package com.ps.BankingApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/add")
public class AddDetails extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String AccName=req.getParameter("AC");
		String phone=req.getParameter("PH");
		String Email=req.getParameter("EI");
		Connection con = null;
	    PreparedStatement ps = null;
	    String url = "jdbc:mysql://localhost:3306/employee1?user=root&password=tiger";
	    String query = "INSERT INTO CUSTOMER(ACCNAME,PHONE,EMAIL) VALUES(?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url);
			ps = con.prepareStatement(query);
			ps.setString(1, AccName);
	        long Phone=Long.parseLong(phone);
	        ps.setLong(2, Phone);
	        ps.setString(3, Email);
	        int i=ps.executeUpdate();
			if(i>0) {
				out.println("<h1>Data stored succefully<h1>");
				out.println("<h2>UPDATE THE DETAILS/CRUD!!<a href='EmpLogin2.jsp'>Back to CRUD?</a><h2>");
				
			}
			else {
				out.println("failed to save data");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	}
}
