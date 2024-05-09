package com.servlets;

import com.dao.*;

import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.*;  

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailId = request.getParameter("email");
		String phNo = request.getParameter("phno");
		Date dob = Date.valueOf( request.getParameter("dob"));
		String address = request.getParameter("address");
		String pswd = request.getParameter("pswd");
		
		
		PaymentsWebAppDAO dao = new PaymentsWebAppDAO();
		try {
		dao.storeUserDetails(userName, firstName, lastName, emailId, phNo, dob, address, pswd);
		
		}
		catch ( Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");  
		response.getWriter().write("<p style='color:green;'>Registration Successfull! Please Login<p>");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.include(request, response);
	}

}
