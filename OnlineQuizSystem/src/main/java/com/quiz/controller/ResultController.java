package com.quiz.controller;

import com.quiz.dao.OptionDAO;
import com.quiz.dao.QuestionDAO;
import com.quiz.dao.ResultDAO;
import com.quiz.model.Option;
import com.quiz.model.Question;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/submitQuiz")
public class ResultController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentName = request.getParameter("studentName");
		int score = 0;

		QuestionDAO questionDAO = new QuestionDAO();
		OptionDAO optionDAO = new OptionDAO();

		List<Question> questions = questionDAO.getAllQuestions();

		for (Question question : questions) {
			String param = "answer_" + question.getId();
			String selectedOptionIdStr = request.getParameter(param);

			if (selectedOptionIdStr != null) {
				int selectedOptionId = Integer.parseInt(selectedOptionIdStr);
				Option selectedOption = optionDAO.getOptionById(selectedOptionId);

				if (selectedOption != null && selectedOption.isCorrect()) {
					score++;
				}
			}
		}

		ResultDAO resultDAO = new ResultDAO();
		resultDAO.saveResult(studentName, score);

		request.setAttribute("studentName", studentName);
		request.setAttribute("score", score);
		request.setAttribute("totalQuestions", questions.size());

		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
