<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
th, td {
  padding: 1px;
  padding-right: 8px;
  text-align: left; 
  vertical-align: center;
}
tr:nth-child(even) {background-color: #f2f2f2;}
</style>
<title>All Players</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allPlayers}" var="currentPlayer">
				<tr>
					<td><input type="radio" name="id" value="${currentPlayer.playerId}"></td>
					<td>${currentPlayer.playerName}</td>
					<td>${currentPlayer.playerNumber}</td>
					<td>${currentPlayer.team.city}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToPlayer"> 
		<input type="submit" value="Delete" name="doThisToPlayer"> 
		<input type="submit" value="Add" name="doThisToPlayer">
	</form>
	<br />
		<a href="index.html">Back to index</a>
</body>
</html>