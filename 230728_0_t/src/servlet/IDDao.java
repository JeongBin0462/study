package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IDDao {
	public IDDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(String id) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO id VALUES (?)")) {
			stmt.setString(1, id);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public int count(String id) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db", "root", "root");
				PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM id WHERE id = ?")) {
			stmt.setString(1, id);
			try (ResultSet rs = stmt.executeQuery()) {
				rs.next();
				return rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
