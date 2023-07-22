<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숫자 입력</title>
</head>
<body>
	<!-- action이 없으면 현재경로로 -->
	<!-- sum에서 요청하면 sum에서 응답하고 minus에서 요청하면 minus에서 응답 -->
	${ message }
	<form method="post">
		<input type="number" name="num1">
		<input type="number" name="num2">
		<input type="submit">
	</form>
</body>
</html>