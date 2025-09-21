<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css" />
</head>
<body>
	<!-- 不受專案及路徑位置而變換；絕對路徑 -->
	<c:url value="/app/mvc/update" var="update" />
	<c:url value="/app/mvc/remove" var="remove" />
	
		<table>
			<thead>
				<tr>
					<th>in.</th>
					<th>name</th>
					<th>email</th>
					<th>salary</th>
					<th>date</th>
					<th>update</th>
					<th>remove</th>
				</tr>
			</thead>
		<tbody>
			<form action="#">
				<c:forEach items="${empList}" var="emp" varStatus="status">
					<tr>
						<td>${status.index}</td>
						<td>${emp.name}</td>
						<td>${emp.email}</td>
						<td>${emp.salary}</td>
						<td>${emp.date}</td>
						<td><input type="submit" formaction="${update}/${emp.empId}" value="更新" /></td>
						<td><a href="${remove}?empid=${emp.empId}">刪除</a></td>

					</tr>
				</c:forEach>
			</form>
		</tbody>
	</table>			
	
	
</body>
</html>