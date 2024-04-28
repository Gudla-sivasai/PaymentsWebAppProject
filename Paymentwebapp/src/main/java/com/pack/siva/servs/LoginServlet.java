package com.pack.siva.servs;

import com.pack.siva.dao.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.*;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
				RequestDispatcher rd = request.getRequestDispatcher("/dashboard.html");
				rd.forward(request, response);

			} else {
				response.setContentType("text/html");  
				response.getWriter().write("<p style='color:red;'> Login failed try again !!! <p>");
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
