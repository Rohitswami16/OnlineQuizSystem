package com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.quiz.model.Option;
import com.quiz.util.DBConnection;

public class OptionDAO {

	public boolean addOption(Option option) {
		String sql = "INSERT INTO options (question_id, option_text, is_correct) VALUES (?, ?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, option.getQuestionId());
			stmt.setString(2, option.getOptionText());
			stmt.setBoolean(3, option.isCorrect());

			int rows = stmt.executeUpdate();
			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Option> getOptionsByQuestionId(int questionId) {
		List<Option> options = new ArrayList<>();
		String sql = "SELECT * FROM options WHERE question_id = ?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, questionId);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Option option = new Option();
					option.setOptionId(rs.getInt("option_id"));
					option.setQuestionId(rs.getInt("question_id"));
					option.setOptionText(rs.getString("option_text"));
					option.setCorrect(rs.getBoolean("is_correct"));
					options.add(option);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return options;
	}

	public Option getOptionById(int optionId) {
		String sql = "SELECT * FROM options WHERE option_id=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, optionId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Option option = new Option();
				option.setOptionId(rs.getInt("option_id"));
				option.setQuestionId(rs.getInt("question_id"));
				option.setOptionText(rs.getString("option_text"));
				option.setCorrect(rs.getBoolean("is_correct"));
				return option;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
