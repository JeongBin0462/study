<%@page import="java.sql.PreparedStatement"%>
<%@page import="country.Country"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;

List<Country> list = new ArrayList<>();

String query = request.getParameter("continent");

try {
	Class.forName(application.getInitParameter("jdbcDriverName"));
	conn = DriverManager.getConnection(application.getInitParameter("jdbcURL")
			, application.getInitParameter("jdbcID")
			, application.getInitParameter("jdbcPassword"));
	stmt = conn.prepareStatement("SELECT Continent, Name FROM country WHERE Continent = ?");
	stmt.setString(1, query);

	rs = stmt.executeQuery();

	while (rs.next()) {
		String continent = rs.getString("Continent");
		String name = rs.getString("Name");
		
		list.add(new Country(continent, name));
	}
	request.setAttribute("list", list);
	request.getRequestDispatcher("/WEB-INF/selectContinent.jsp").forward(request, response);
} catch (Exception e) {
	e.printStackTrace();

	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	out.println("요청 처리 중 에러 발생. 관리자에게 문의하세요.");
} finally {
	if (rs != null) {
		try {
			rs.close();
		} catch (Exception e) {
		}
	}
	if (stmt != null) {
		try {
			stmt.close();
		} catch (Exception e) {
		}
	}
	if (conn != null) {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}
}
%>