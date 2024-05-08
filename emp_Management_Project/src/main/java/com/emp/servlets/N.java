package com.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/N")
public class N extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String exampleRadios = request.getParameter("exampleRadios");
		
		PrintWriter out = response.getWriter();
		
		if (exampleRadios.equals("option1")) {
			response.sendRedirect("AdminLogin.html");
		} 
		else if (exampleRadios.equals("option2")) {
			response.sendRedirect("TrainerLogin.html");
			
		} else if (exampleRadios.equals("option3")) {
			response.sendRedirect("TraineeLogin.html");
		}

	}

}
