<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대륙 선택</title>
</head>
<body>
	<form action="countryContinent_t.jsp">
		<select name="continent">
			<option value="North America">북미</option>
			<option value="Asia">아시아</option>
			<option value="Africa">아프리카</option>
			<option value="Europe">유럽</option>
			<option value="South America">남미</option>
			<option value="Antarctica">남극</option>
		</select>
		<input type="submit" value="선택">
	</form>
	
	<c:if test="${ not empty list }">
	<ul>
		<c:forEach var="country" items="${ list }">
		<li>${ country.continent } : ${ country.name }</li>
		</c:forEach>
	</ul>
	</c:if>
</body>
</html>