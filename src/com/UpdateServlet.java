package com;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		
		
		//Code for Database
		try {
			//Load database driver here from Jar file
			Class.forName("com.mysql.jdbc.Driver");
			// make connection with database
			//import java.sql package only
			
			String sql = "UPDATE profile_tbl set Username=?,Password=?,Name=?,Phone=?,Gender=? where Email =?";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database","root","root");
			
			//pstmt contains compiled query
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, gender);
			pstmt.setString(6, email);
			
			//firing query
			
			pstmt.executeUpdate();
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		//Here first time this servlet is calling another servlet
		//which url pattern is = /FetchServlet
		//FetchServlet -> this servlet will show all the data from the database
		request.getRequestDispatcher("FetchServlet").forward(request, response);
           	
}
}