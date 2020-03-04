<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
th, td {
  padding: 1px;
  text-align: left; 
  vertical-align: center;
}
</style>
<title>Add Player</title>
</head>
<body>
	<form action="addPlayerServlet" method="post">
		<table style="width: 30%">
			<tr>
				<th>Player Name:</th>
				<td><input type="text" name="playerName" size="30" required></td>
			</tr>
			<tr>
				<th>Player Number:</th>
				<td><input type="number" name="playerNumber" size="3" maxlength="3" min="1" max="999" required></td>
			</tr>
			<tr>
				<th>Team:</th>
				<td>
					<select name="teamId">
						<c:forEach items="${requestScope.allTeams}" var="currentTeam">
							<option value="${currentTeam.id}">${currentTeam.city}|${currentTeam.nickname}</option>
						</c:forEach>
					</select> 
					<br />
				</td>
			</tr>
			<tr>
				<th><input type="submit" value="Add Player"></th>
			</tr>
		</table>
		<br />
		<a href="index.html">Back to index</a>
	</form>
</body>
</html>