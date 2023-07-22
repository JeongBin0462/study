<%@page import="member.Member"%>
<%@page import="member.MemberRepo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try {
		MemberRepo repo = new MemberRepo();
		List<Member> list = repo.getAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("viewMemberList.jsp").forward(request, response);
	} catch(Exception e) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		out.println("요청 처리 중 에러 발생. 관리자에게 문의하세요.");
	}
%>