<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clothes list</title>
</head>
<body>
	<table border="1">
		<tr>
           <th>
				<form action="ClotherController">
					<input type="submit" name="btn_new"
					value="New">
				</form>
			</th>
		<th>Id</th>
		<th>Jeans</th>
		<th>T-Shirt</th>
		<th>Coats</th>
		</tr>
		<c:forEach var="clother" items="${clothers}">
		<tr>
			<td>
				<form action="ClotherController">
					<input type="hidden" name="id"
					value="${clother.id}" />
					<input type="submit" name="btn_edit"
					value="Edit"/>
					<input type="submit" name="btn_delete"
					value="Delete"/>
				</form>
			</td>
			<td>${clother.id}</td>
			<td>${clother.jeans}</td>
			<td>${clother.shirt}</td>
			<td>${clother.coat}</td>
		</tr>
	</c:forEach>
		
	</table>
</body>
</html>