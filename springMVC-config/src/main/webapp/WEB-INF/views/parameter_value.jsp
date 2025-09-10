<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style>
* {
	margin: 20px;
}
body {
    justify-items: center;
    text-align: center;
}
table, th, td {
  border: 1px solid;
  text-align: center
}
table {
	width: 300px;
	border-collapse: collapse;
}
</style>

	<div id="paramForm"></div>
	<br/>
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
	
	<script type="text/javascript" src="../../resources/js/parameter_value.js"></script>
</body>
</html>