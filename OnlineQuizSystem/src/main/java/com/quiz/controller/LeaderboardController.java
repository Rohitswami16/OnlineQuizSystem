package com.quiz.controller;

import com.quiz.dao.ResultDAO;
import com.quiz.model.Results;
import com.quiz.model.Results;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/leaderboard")
public class LeaderboardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ResultDAO resultDAO = new ResultDAO();
		List<Results> results = resultDAO.getAllResults();

		request.setAttribute("results", results);
		RequestDispatcher dispatcher = request.getRequestDispatcher("leaderboard.jsp");
		dispatcher.forward(request, response);
	}
}
