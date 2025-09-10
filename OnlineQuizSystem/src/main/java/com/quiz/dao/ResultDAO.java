package com.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.quiz.model.Results;
import com.quiz.util.DBConnection;

public class ResultDAO {
	public void saveResult(String studentName, int score) {
		String sql = "INSERT INTO results (student_name, score) VALUES (?, ?)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, studentName);
			stmt.setInt(2, score);
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Results> getAllResults() {
		List<Results> results = new ArrayList<>();
		String sql = "SELECT * FROM results ORDER BY score DESC";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				Results r = new Results();
				r.setStudentName(rs.getString("student_name"));
				r.setScore(rs.getInt("score"));
				results.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

}
