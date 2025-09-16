<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="#">
		<table>
			<tbody>
				<c:forEach items="${empList}" var="emp">
					<tr>
						<td>${emp}</td>
						<td><input type="submit" formaction="update/${emp.empId}" value="更新"/> </td>						 
						<td><a href="./remove?empid=${emp.empId}">刪除</a> </td>						
						 
					<tr/>
				</c:forEach>
			</tbody>
		</table>			
	</form>
	
</body>
</html>