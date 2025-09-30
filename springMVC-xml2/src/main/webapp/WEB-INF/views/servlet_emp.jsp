<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, employee.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
		<tbody>
			<tr>
				<th>on.</th>
				<th>name</th>
				<th>email</th>
				<th>salary</th>
				<th>date</th>

			</tr>
			<% List<Employee> list = (List<Employee>) request.getAttribute("list");
				   int x = 0;
				   for(Employee emp : list) {%>
			<tr>
				<td><%= ++x %></td>
				<td><%= emp.getName() %></td>
				<td><%= emp.getEmail() %></td>
				<td><%= emp.getSalary() %></td>
				<td><%= emp.getDate() %></td>				
			</tr>
			<%} %>
		</tbody></body>
</html>