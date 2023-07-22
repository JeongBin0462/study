<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags/mytag" prefix="my"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MEMBER 테이블 레코드 삽입</title>
</head>
<body>
	<form action="insert.jsp" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" name="memberID" size="10">
					<%-- <c:forEach var="entry" items="${ errors }"> --%>
					<!-- fn:startsWith: 시작문자가 memberid이면 true 반환 -->
					<%-- 	<c:if test="${ fn:startsWith(entry.key, 'memberid') }"> --%>
					<%-- 		<span>${ entry.value }</span> --%>
					<%-- 	</c:if> --%>
					<%-- </c:forEach> --%>
					<my:errors fieldName="memberid" errors="${ errors }"></my:errors>
				</td>
				<td>비밀번호</td>
				<td>
					<input type="text" name="password" size="10">
					<my:errors fieldName="password" errors="${ errors }"></my:errors>
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" size="10">
					<my:errors fieldName="name" errors="${ errors }"></my:errors>
				</td>
				<td>이메일</td>
				<td>
					<input type="text" name="email" size="10">
					<my:errors fieldName="email" errors="${ errors }"></my:errors>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<input type="submit" value="삽입">
				</td>
			</tr>
		</table>
	</form>
	<my:errors fieldName="duplicationId" errors="${ errors }"></my:errors>
</body>
</html>

<%
	session.removeAttribute("errors");
%>