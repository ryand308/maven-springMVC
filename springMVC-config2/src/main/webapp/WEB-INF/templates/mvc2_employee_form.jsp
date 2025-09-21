<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/app2/rs/general.css">
</head>
<body>


	<form:form modelAttribute="employee" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><form:input path="name"/></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>Salary:</td>
			<td><form:input path="salary"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<form:hidden path="empId"/>
				<input type="submit" value="Save Changes"/>
			</td>
		</tr>
	</table>
	
</form:form>
</body>
</html>