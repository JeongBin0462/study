<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
<h2>MEMBER 테이블의 내용</h2>
<table width="100%" border="1">
	<tr>
		<td>이름</td><td>아이디</td><td>이메일</td>
	
	<c:forEach var="p" items="${ list }">
		<tr>
			<td>${ p.name }</td> 
			<td>${ p.memberId }</td> 
			<td>${ p.email }</td>
		</tr> 
	</c:forEach>
	</tr>
</table>
</body>
</html>