package com.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import jakarta.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        String empid = request.getParameter("empid");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String s = request.getParameter("num");
		long l =Long.parseLong(s);
		String location = request.getParameter("location");
		String date = request.getParameter("date");
		String batch = request.getParameter("batch");
      
		Emp e = new Emp();
		e.setEmpid(empid);
		e.setName(name);
		e.setEmail(email);
		e.setNumber(l);
		e.setLocation(location);
		e.setDate(date);
		e.setBatch(batch);

		int status = EmpDao.save(e);
		if (status > 0) {
			System.out.println(status);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
			out.print("<p> Record saved successfully!</p>");
		} else {
			out.println("Sorry! unable to save record");
		}

		out.close();
	}

}
