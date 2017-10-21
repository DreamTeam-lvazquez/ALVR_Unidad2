<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clother Form</title>
</head>
<body>
	<form action="ClotherController">
		<label>Jeans:</label><br/>
		<input type="text" name="jeans" value="${clother.jeans}"/> <br/>
		<label>T-Shirt:</label><br/>
		<input type="text" name="shirt" value="${clother.shirt}"/><br/>
		<label>Coats:</label><br/>
		<input type="text" name="coat" value="${clother.coat}"/> <br/>
		<input type="submit" name="btn_save" value="Save" />
		</form>
	</body>
</html>

