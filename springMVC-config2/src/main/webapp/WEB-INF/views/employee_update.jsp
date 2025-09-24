<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/general.css">
</head>
<body>

<c:url value="/app/mvc/update" var="update"></c:url>

	<form action="${update}" method="post">
		<label for="name">Name:</label><br>
		<input type="text" id="name" name="name" placeholder="${emp.name}" value="${emp.name}"><br/>
		<label for="email">email:</label><br>
		<input type="email" id="email" name="email" placeholder="${emp.email}" value="${emp.email}"><br>
		<label for="salary">salary:</label><br>
		<input type="number" id="salary" name="salary" placeholder="${emp.salary}" value="${emp.salary}"><br>
		
		<input type="hidden" name="empId" value="${emp.empId}" /> 
		<input type="submit" value="送出" />
	</form>


</body>
</html>