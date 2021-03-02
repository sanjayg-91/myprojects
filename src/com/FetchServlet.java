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
 * Servlet implementation class FetchServlet
 */
@WebServlet("/FetchServlet")
public class FetchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Signup> fetch = new ArrayList<Signup>();
		try {
			// Loading the driver
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-form-database", "root",
					"root");
			String sql = "select PID,Username,Password,Name,Email,Phone,Gender,DOE from profile_tbl";
			Statement stmt = con.createStatement();
			// fire the query
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int pid = rs.getInt(1);
				String username = rs.getString(2);
				String password = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String gender = rs.getString(7);
				Timestamp doe = rs.getTimestamp(8);
				Signup signup = new Signup(username, password, name, email, phone, gender);
				signup.setPid(pid);
				signup.setDoe(doe);
				fetch.add(signup);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// setting data into request scope with key = psignups
		// so that we can access it on jsp
		request.setAttribute("psignups", fetch);
		request.getRequestDispatcher("fetch.jsp").forward(request, response);
	}

}
