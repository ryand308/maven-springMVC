<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<s:url value="/app2/rs" var="rs"></s:url>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${rs}/table.css">
</head>
<body>

	<div id="paramForm"></div>
	<br />

	<c:if test="${id != null && name != null }">
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
	</c:if>
	
	<script type="text/javascript" src="${rs}/parameter_value.js"></script>
</body>
</html>