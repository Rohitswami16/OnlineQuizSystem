package com.quiz.dao;

import com.quiz.model.Admin;
import com.quiz.util.DBConnection;
import java.sql.*;

public class AdminDAO {

	public Admin validateAdmin(String username, String password) {
		Admin admin = null;
		String sql = "SELECT * FROM admin WHERE username=? AND password=?";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setUsername(rs.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
}