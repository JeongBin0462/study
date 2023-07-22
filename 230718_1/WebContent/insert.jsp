<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="member.MemberValidator"%>
<%@page import="dbutil.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String memberID = request.getParameter("memberID");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberValidator validator = new MemberValidator();
	Map<String, String> errors = validator.validate(memberID, name, password, email);
	session.setAttribute("errors", errors);
	if (errors.size() > 0) {
		response.sendRedirect("insertForm.jsp");
	} else {
	Connection conn = null;
	PreparedStatement stmt = null;
	
	try {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, memberID);
		map.put(2, password);
		map.put(3, name);
		map.put(4, email);
		
		String query = "INSERT INTO MEMBER VALUES (?,?,?,?)";
		if (email.trim().isEmpty()) {
			query = "INSERT INTO MEMBER (memberID, name, password) VALUES (?,?,?)";
			map.remove(4);
		}
		
		conn = DBUtil.getConnection();
		stmt = conn.prepareStatement(query);
		for (Map.Entry<Integer, String> create : map.entrySet()) {
			stmt.setString(create.getKey(), create.getValue());
		}
		stmt.executeUpdate();
	} finally {
		DBUtil.close(stmt);
		DBUtil.close(conn);
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>삽입</title>
</head>
<body>
	MEMBER 테이블에 새로운 레코드를 삽입했습니다.
</body>
</html>
<%
}
%>