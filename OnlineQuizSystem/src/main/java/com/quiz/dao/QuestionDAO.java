package com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import com.quiz.model.Question;
import com.quiz.util.DBConnection;

public class QuestionDAO {

	public int addQuestion(Question question) {
		String sql = "INSERT INTO questions (question) VALUES (?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, question.getQuestionText());
			int affectedRows = stmt.executeUpdate();

			if (affectedRows == 0) {
				throw new RuntimeException("Creating question failed.");
			}

			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new RuntimeException("Creating question failed, no ID obtained.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		String sql = "SELECT * FROM questions";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Question question = new Question();
				question.setId(rs.getInt("question_id"));
				question.setQuestionText(rs.getString("question"));
				questions.add(question);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
