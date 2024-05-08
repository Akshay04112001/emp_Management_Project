package com.emp.servlets;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
import java.io.IOException;
import jakarta.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
      
    	response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        out.println("<a href='dashboard.html'>Home</a>");  
        out.println("<h1>Employees List</h1>");  
          
          
        List<Emp> list=EmpDao.getAllEmployees();  
        out.print("<form action='ViewServlet' method='get'>");
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>EmpID:</th><th>Name:</th><th>Email:</th><th>Number:</th><th>Location:</th><th>Date:</th><th>Batch:</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp c:list){  
        	   out.print("<tr><td>"+c.getEmpid()+"</td><td>"+c.getName()+"</td><td>"+c.getEmail()+"</td><td>"+c.getNumber()+"</td><td>"+c.getLocation()+"</td><td>"+c.getDate()+"</td><td>"+c.getBatch()+"</td><td><a href='EditServlet?empid="+c.getEmpid()+"'>edit</a></td><td><a href='DeleteServlet?empid="+c.getEmpid()+"'>delete</a></td></tr>");  
              }   
         out.print("</table>");  
         out.print("</form>");
    out.close();   
    }  
}  