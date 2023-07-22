package member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DBUtil;

public class MemberRepo {
	public List<Member> getAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = new ArrayList<>();
		try {
			String query = "SELECT * FROM MEMBER ORDER BY MEMBERID";
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String name = rs.getString("name");	
				String memberId = rs.getString("memberid");	
				String email = rs.getString("email");
				
				list.add(new Member(name, memberId, email));
			}
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}
}
