<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
	아이디 : 
	<%= session.getAttribute("ID") %>
</p>
	<a href="index.jsp">처음으로 돌아가기</a>
</body>
</html>