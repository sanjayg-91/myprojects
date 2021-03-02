package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pemail=request.getParameter("ddata");
		
		Signup signup = new Signup();
		try {
			// Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database", "root",
					"root");
			String sql = "select PID,Username,Password,Name,Email,Phone,Gender,DOE from profile_tbl where email=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,pemail);
			// fire the query 
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int pid = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				Timestamp doe = rs.getTimestamp(8);
				signup = new Signup(username, password, name, pemail, phone, gender);
				signup.setPid(pid);
				signup.setDoe(doe);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// setting data into request scope with key = psignups
		// so that we can access it on jsp
		request.setAttribute("signup", signup);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
}