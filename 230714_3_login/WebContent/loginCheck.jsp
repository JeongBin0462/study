<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String remember = request.getParameter("remember");
	
	Map<String, String> manager = new HashMap<>();
	Enumeration<String> initParamEnum = application.getInitParameterNames();
	while(initParamEnum.hasMoreElements()) {
		String managerInfo = initParamEnum.nextElement();
		manager.put(managerInfo, application.getInitParameter(managerInfo));
	}
	
	if(id.equals(manager.get("managerId")) && password.equals(manager.get("managerPassword"))) {
		if(remember != null) {
			session.setAttribute("REMEMBER", remember);
		} else {
			session.removeAttribute("REMEMBER");
		}
		session.setAttribute("ID", id);
		request.getRequestDispatcher("managerPage.jsp")
		.forward(request, response);
	} else {
		response.sendRedirect("index.jsp");
	}
%>
