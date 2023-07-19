<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB Connection 테스트용 페이지</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(application.getInitParameter("jdbcDriverName"));
			conn = DriverManager.getConnection(application.getInitParameter("jdbcURL")
					, application.getInitParameter("jdbcID")
					, application.getInitParameter("jdbcPassword"));
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT 100");
			
			if (rs.next()) {
				int result = rs.getInt(1);
				out.println(result == 100 ? "접속 성공" : "");
			}
		} catch (Exception e) {
			// 서버의 기록으로서 오류 메시지 남김
			e.printStackTrace();
			// 개발단계에서 오류를 잡기 위해 
			// throw e;
			
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			out.println("요청 처리 중 에러 발생. 관리자에게 문의하세요.");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch(Exception e) {
					
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch(Exception e) {
					
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					
				}
			}
		}
	%>
</body>
</html>