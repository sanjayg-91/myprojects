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
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		}
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
			
			String sql = "INSERT INTO profile_tbl (Username,Password,Name,Email,Phone,Gender,DOE) values (?,?,?,?,?,?,?)";
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database","root","root");
			
			//pstmt contains compiled query
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, gender);
			
			long millis = new Date().getTime();
			Timestamp timestamp = new Timestamp(millis);
			pstmt.setTimestamp(7, timestamp );
			
			//firing query
			
			pstmt.executeUpdate();
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		Signup su = new Signup(username, password, name, email, phone, gender);
		
		//sending object to jsp
		
		request.setAttribute("data", su);
		request.getRequestDispatcher("review.jsp").forward(request, response);
		
}
}