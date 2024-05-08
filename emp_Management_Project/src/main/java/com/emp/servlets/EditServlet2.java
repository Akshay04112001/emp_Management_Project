package com.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String empid = request.getParameter("empid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        long number = Long.parseLong(request.getParameter("number"));
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        String batch = request.getParameter("batch");

        Emp e = new Emp();
        e.setEmpid(empid);
        e.setName(name);
        e.setEmail(email);
        e.setNumber(number); 
        e.setLocation(location);
        e.setDate(date);
        e.setBatch(batch);

        int status = EmpDao.update(e);

        if (status > 0) {
            response.sendRedirect("ViewServlet");
        } else {
            out.println("Sorry! unable to update record");
        }

        out.close();
    }
}
