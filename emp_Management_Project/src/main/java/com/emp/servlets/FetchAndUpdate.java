/*
 * 
 * For Update Data
 */

package com.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FetchAndUpdate")
public class FetchAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static Connection con;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String empid = request.getParameter("uname");

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empAppdb", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from user905 where empid=?");
			ps.setString(1, empid);
			out.print("<table width=25% border=1>");
			out.println("<a href='dashboard.html'>Home</a>");
			out.print("<center><h1>Record</h1></center>");

			ResultSet rs = ps.executeQuery();

			/* Printing column names */

			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next())

			{

				out.print("<tr>");

				out.print("<td>" + rsmd.getColumnName(1) + "</td>");

				out.print("<td>" + rs.getString(1) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(2) + "</td>");

				out.print("<td>" + rs.getString(2) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(3) + "</td>");

				out.print("<td>" + rs.getString(3) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(4) + "</td>");

				out.print("<td>" + rs.getString(4) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(5) + "</td>");

				out.print("<td>" + rs.getString(5) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(6) + "</td>");

				out.print("<td>" + rs.getString(6) + "</td></tr>");

				out.print("<tr><td>" + rsmd.getColumnName(7) + "</td>");

				out.print("<td>" + rs.getString(7) + "</td></tr>");

				out.print("<td><a href='EditServlet?empid=" + rs.getString(1) + "'>Update</a></td></tr>");
			}

			out.print("</table>");

		} catch (Exception e2)

		{

			e2.printStackTrace();

		}

		finally {
			out.close();

		}

	}

}
