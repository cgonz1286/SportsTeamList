<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>
	<form action="editTeamServlet" method="post">
		City: <input type="text" name="city" value="${teamToEdit.city}">
		Nickname: <input type="text" name="nickname" value="${teamToEdit.nickname}">
		Number of Players: <input type="number" name="numOfPlayers" size="3" maxlength="3" min="0" max="999" value="${teamToEdit.numOfPlayers}" required>
		<input type="hidden" name="id" value="${teamToEdit.id}"> 
		<input type="submit" value="Save Edited Team">
	</form>
</body>
</html>