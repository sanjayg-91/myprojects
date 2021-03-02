package com;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//Code for Database
		try {
			//Load database driver here from Jar file
			Class.forName("com.mysql.jdbc.Driver");
			// make connection with database
			//import java.sql package only
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database","root","root");
			String sql = "select PID,Username,Password,Name,Email,Phone,Gender,DOE from profile_tbl where Username=? and Password=?";
			
			//pstmt contains compiled query
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			
			
			//firing query
			
			ResultSet rs = pstmt.executeQuery();
			
			//create session  for logged in user
			
			if (rs.next()){
				HttpSession session = request.getSession();
				Signup su = new Signup(username, password, rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
				//adding User data into session
				
				session.setAttribute("data",su);
				
				//sending object to jsp
				
				request.setAttribute("data", su);
				request.getRequestDispatcher("review.jsp").forward(request, response);
				
			}else {
				request.setAttribute("message", "Sorry! Username and Password are not correct. Please try again. ");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
}
}