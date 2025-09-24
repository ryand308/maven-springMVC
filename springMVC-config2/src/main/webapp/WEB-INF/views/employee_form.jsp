<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>

<c:url value="/app/mvc/save" var="save"></c:url>

	<form action="${save}" method="post">
		<label for="name">Name:</label><br>
		<input type="text" id="name" name="name" required><br/>
		<label for="email">email:</label><br>
		<input type="email" id="email" name="email" required><br>
		<label for="salary">salary:</label><br>
		<input type="number" id="salary" name="salary" required><br>
		<input type="submit" value="送出" />
	</form>

</body>
</html>