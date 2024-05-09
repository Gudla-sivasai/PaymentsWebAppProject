package com.servlets;

import com.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.*;




public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userNameOrPhoneNo = request.getParameter("username");
		String password = request.getParameter("pswd");

		System.out.println(userNameOrPhoneNo);
		System.out.println(password);

		PaymentsWebAppDAO dao = new PaymentsWebAppDAO();
		try {
			if (dao.loginValidate(userNameOrPhoneNo, password)) {
				response.setContentType("text/html");
				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);

			} else {
				response.setContentType("text/html");  
				response.getWriter().write("<p style='color:red;'> Login failed try again !!! <p>");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
