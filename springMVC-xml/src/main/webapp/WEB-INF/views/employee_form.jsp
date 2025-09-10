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
</style>


	
	<sf:form method="post" modelAttribute="employee">
		
		<table>
			<thead>
				<tr>
					<th colspan="2"><h1>Register Form</h1></th>
					<th></th>
				<tr>
			</thead>
			<tbody>
				<tr>
					<th>name:</th>
					<td><sf:input path="name" /></td>					
					<td><sf:errors path="name" style="color:red;"/>				
				</tr>
				<tr>
					<th>email:</th>
					<td><sf:input path="email" /></td>
					<td><sf:errors path="email" style="color:red;" />				
				</tr>
				<tr>
					<th>salary:</th>
					<td><sf:input path="salary" /></td>
					<td><sf:errors path="salary" style="color:red;" />
				</tr>
				<tr>
					<td><input type="submit" value="提交" /></td>					
					<td colspan="2"><sf:errors path="*" element="div" /></td>
				</tr>
			</tbody>
		</table>	
	</sf:form>
	
	
</body>
</html>