<%@page import="employee.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
* {
	margin: 10px;
}
table {
	width: 600px;
}
</style>
	<form action="">
		<table>
			<tbody>
				<tr>
					<th>on.</th>
					<th>name</th>
					<th>email</th>
					<th>salary</th>
					<th>date</th>
					<th>update</th>
					<th>delete</th>
				</tr>
				<% List<Employee> list = (List<Employee>) request.getAttribute("empList");
				   int x = 0;
				   for(Employee emp : list) {%>				   
					<tr>
						<td><%= ++x %></td>
						<td><%= emp.getName() %></td>
			            <td><%= emp.getEmail() %></td>
			            <td><%= emp.getSalary() %></td>
			            <td><%= emp.getDate() %></td>
			            <td><input type="submit" formaction="update/<%= emp.getEmpId() %>" value="更新" /></td>			            
			            <td><input type="submit" formaction="remove/<%= emp.getEmpId() %>" value="刪除"/></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</form>
</body>
</html>
