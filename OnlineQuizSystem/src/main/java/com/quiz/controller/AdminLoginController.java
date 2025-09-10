package com.quiz.controller;

import com.quiz.dao.AdminDAO;
import com.quiz.model.Admin;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AdminDAO adminDAO = new AdminDAO();
		Admin admin = adminDAO.validateAdmin(username, password);

		if (admin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			response.sendRedirect("adminPanel");
		} else {
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("adminLogin.jsp");
	}
}
