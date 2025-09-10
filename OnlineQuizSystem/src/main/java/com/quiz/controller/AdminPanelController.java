package com.quiz.controller;

import com.quiz.dao.QuestionDAO;
import com.quiz.dao.OptionDAO;
import com.quiz.model.Question;
import com.quiz.model.Option;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/adminPanel")
public class AdminPanelController extends HttpServlet {

	private QuestionDAO questionDAO;
	private OptionDAO optionDAO;

	@Override
	public void init() throws ServletException {
		questionDAO = new QuestionDAO();
		optionDAO = new OptionDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("admin") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminPanel.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("adminLogin.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("admin") == null) {
			response.sendRedirect("adminLogin.jsp");
			return;
		}

		try {
			String questionText = request.getParameter("questionText");
			int numOptions = Integer.parseInt(request.getParameter("numOptions"));
			int correctAnswer = Integer.parseInt(request.getParameter("correctAnswer"));

			Question question = new Question();
			question.setQuestionText(questionText);
			int questionId = questionDAO.addQuestion(question);

			for (int i = 1; i <= numOptions; i++) {
				String optionText = request.getParameter("option" + i);
				if (optionText != null && !optionText.trim().isEmpty()) {
					Option option = new Option();
					option.setQuestionId(questionId);
					option.setOptionText(optionText);
					option.setCorrect(i == correctAnswer);
					optionDAO.addOption(option);
				}
			}

			response.sendRedirect("adminPanel?success=Question added!");

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("adminPanel?error=Failed to add question.");
		}
	}
}
