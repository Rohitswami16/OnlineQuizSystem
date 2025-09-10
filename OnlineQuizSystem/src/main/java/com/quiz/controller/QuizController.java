package com.quiz.controller;

import com.quiz.dao.QuestionDAO;
import com.quiz.dao.OptionDAO;
import com.quiz.model.Question;
import com.quiz.model.Option;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@WebServlet("/takeQuiz")
public class QuizController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionDAO questionDAO = new QuestionDAO();
		OptionDAO optionDAO = new OptionDAO();

		List<Question> questions = questionDAO.getAllQuestions();
		Map<Integer, List<Option>> optionsMap = new HashMap<>();

		for (Question q : questions) {
			List<Option> options = optionDAO.getOptionsByQuestionId(q.getId());
			optionsMap.put(q.getId(), options);
		}

		request.setAttribute("questions", questions);
		request.setAttribute("optionsMap", optionsMap);
		RequestDispatcher dispatcher = request.getRequestDispatcher("takeQuiz.jsp");
		dispatcher.forward(request, response);
	}
}
