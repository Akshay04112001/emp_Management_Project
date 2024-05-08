package com.emp.servlets;

import java.io.IOException;
import java.io.IOException;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public Hello() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uname =request.getParameter("u-name");
			String password =request.getParameter("p-word");
			
			
			if(uname.equals("java") && password.equals("1234")) {
				response.sendRedirect("newFile.html");
				
			}
			
			else {
				response.sendRedirect("error.html");
				
			}
			
		}
		
		}


