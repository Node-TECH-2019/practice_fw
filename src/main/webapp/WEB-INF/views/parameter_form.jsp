<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>input form</title>
	</head>
	<body>
		<form action="show_parameter.do" method="POST">
			name: <input type="text" name="name">
			<br>
			price: <input type="text" maxlength="5" name="price" oninput="value = value.replace(/[^0-9]+/i,'');" />
			<br>
			<input type="submit" value="send to parameter">
		</form>

		<hr>

		<form action="show_model.do" method="POST">
			name: <input type="text" name="name">
			<br>
			price: <input type="text" maxlength="5" name="price" oninput="value = value.replace(/[^0-9]+/i,'');" />
			<br>
			<input type="submit" value="send to model">
		</form>
	</body>
</html>
