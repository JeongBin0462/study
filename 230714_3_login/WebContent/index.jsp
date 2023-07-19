<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String managerId = "";
	boolean check = false;
	if (session.getAttribute("REMEMBER") != null) {
		managerId = (String) session.getAttribute("ID");
		check = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	관리자 페이지를 제공하는 사이트
	인덱스 페이지에 링크 구성
		1. 로그인(아이디 기억하기)
			1-1 로그아웃
		2. 관리자 페이지로
	관리자 아이디/비밀번호 -> web.xml의 설정값
	로그인 입력폼 (아이디 기억하기)
 --%>
 <fieldset>
 	<legend>로그인</legend>
 		<form action="<%= request.getContextPath() %>/loginCheck.jsp" method="post">
 		<div>
 			ID <input type="text" name="id" value="<%= managerId %>">
 			PASSWORD <input type="password" name="password">
 		</div>
 		<div>
 			<%
 				if(check) {
 			%>
 			<input type="checkbox" name="remember" checked="checked">아이디 기억하기
 			<%
 				} else {
 			%>
 			<input type="checkbox" name="remember">아이디 기억하기
 			<%
 				}
 			%>
 		</div>
 			<input type="submit" value="로그인">
 		</form>
 </fieldset>
</body>
</html>