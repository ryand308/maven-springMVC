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
<style>
*{
	margin: 10px;	
}
</style>

	
		<table>
			<thead>
				<tr>
					<th>no.</th>
					<th>name</th>
					<th>email</th>
					<th>salary</th>
					<th>date</th>
					<th>update</th>
					<th>delete</th>
				</tr>
			</thead>
			<tbody>
				<form action="#">
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
				            <td><a href="./remove?empid=<%= emp.getEmpId() %>">刪除</a></td>
						</tr>
					<%} %>				
				</form>
			</tbody>
		</table>			
	
</body>
</html>