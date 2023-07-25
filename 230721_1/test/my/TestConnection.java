package my;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestConnection {
	@Test
	public void testConn() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 1")) {
			rs.next();
			int result = rs.getInt(1);

			assertSame(1, result);
		} catch (SQLException e) {
			e.printStackTrace();

			fail();
		}
	}
}
