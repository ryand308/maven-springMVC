<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>

	<div id="paramForm"></div>
	<br />

	<table>
		<tbody>
			<tr>
				<th>id</th>
				<th>name</th>
			</tr>
			<tr>
				<td>${id}</td>
				<td>${name}</td>
			</tr>
		</tbody>
	</table>
	<c:url value="/app/gener/home" var="home" />
	<a href="${home}">home</a>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/parameter_value.js"></script>
</body>
</html>