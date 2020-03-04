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
<title>All Teams</title>
</head>
<body>
	<form method="post" action="navigationServlet">
		<table>
			<c:forEach items="${requestScope.allTeams}" var="currentTeam">
				<tr>
					<td><input type="radio" name="id" value="${currentTeam.id}"></td>
					<td><b>${currentTeam.city}</b></td>
					<td><b>${currentTeam.nickname}</b></td>
					<td><b>${currentTeam.numOfPlayers}</b></td>
					<td><b>Players:</b></td>
				</tr>
				<c:forEach items="${currentTeam.players}" var="currentPlayer">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><i>${currentPlayer.playerName}, #${currentPlayer.playerNumber}</i></td>
					</tr>
				</c:forEach>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToTeam"> 
		<input type="submit" value="Delete" name="doThisToTeam"> 
		<input type="submit" value="Add" name="doThisToTeam">
	</form>
	<br />
		<a href="index.html">Back to index</a>
</body>
</html>