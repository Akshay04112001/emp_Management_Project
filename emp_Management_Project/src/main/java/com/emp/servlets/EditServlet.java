package com.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     PrintWriter out=response.getWriter();  
	        out.println("<h1>Update Employee</h1>");  
	        String sid=request.getParameter("empid");  
	          
	        Emp e=EmpDao.getEmployeeById(sid);  
       
	        
	          
		out.print("<form action='EditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='empid' value='" + e.getEmpid() + "'/></td></tr>");
		out.print("<tr><td>EmpName:</td><td><input type='text' name='name' value='" + e.getName() + "'/></td></tr>");
	    out.print("<tr><td>Email:</td><td><input type='email' name='email' value='" + e.getEmail()+ "'/></td></tr>");
		out.print("<tr><td>Number:</td><td><input type='number' name='number' value='" + e.getNumber() + "'/></td></tr>");
	    out.print("<tr><td>Location:</td><td><input type='text' name='location' value='" + e.getLocation() + "'/></td></tr>");
	    out.print("<tr><td>Joining_Date:</td><td><input type='text' name='date' value='" + e.getDate()+ "'/></td></tr>");
	    out.print("<tr><td>Batch_No:</td><td><input type='text' name='batch' value='" + e.getBatch() + "'/></td></tr>");

	    out.print("</td></tr>");
		out.print("<tr><td><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}


