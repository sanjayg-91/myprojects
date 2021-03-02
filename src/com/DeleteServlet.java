package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This is email id in jsp which record you want to delete
				String email=request.getParameter("ddata");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String sql="delete from profile_tbl where email=?";
					//making connection to the database
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database","root","root");
					PreparedStatement pstmt=conn.prepareStatement(sql);
					//setting values inside the place holders
					pstmt.setString(1, email);
					//fire the query!!!
					pstmt.executeUpdate();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				//Here first time this servlet is calling another servlet
				//which url pattern is = /FetchServlet
				//FetchServlet -> this servlet will show all the data from the database
				request.getRequestDispatcher("FetchServlet").forward(request, response);
		           	
	}
}