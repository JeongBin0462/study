<%@page import="java.util.Map"%>
<%@page import="member.MemberValidator"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="dbutil.DBUtil"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String memberID = request.getParameter("memberID");
	String name = request.getParameter("name");
	
	MemberValidator validator = new MemberValidator();
	Map<String, String> errors = validator.validateName(name);
	session.setAttribute("errors", errors);
	
	if (errors.size() > 0) {
		response.sendRedirect("updateForm.jsp");
	} else {
		int updateCount = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			String query = "UPDATE MEMBER SET NAME = ? WHERE MEMBERID = ?";
					
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, memberID);
			updateCount = stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
%>
<html>
<head><title>이름변경</title></head>
<body>
		<% if(updateCount > 0){ %>
		<%= memberID %>의 이름을 <%= name %>(으)로 변경
		<% } else { %>
		<%= memberID %> 이 아이디가 존재하지 않음
		<% 	
		}
	}
		%>
</body>
</html>