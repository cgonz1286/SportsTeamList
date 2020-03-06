<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Edit Player</title>
</head>
<body>
	<form action="editPlayerServlet" method="post">
		<table style="width: 30%">
			<tr>
				<th>Player Name:</th>
				<td><input type="text" name="playerName" value="${playerToEdit.playerName}"></td>
			</tr>
			<tr>
				<th>Player Number:</th>
				<td><input type="number" name="playerNumber" size="3" maxlength="3" min="0" max="999" value="${playerToEdit.playerNumber}" required></td>
			</tr>
			<tr>
				<th>Team:</th>
				<td>
					<select name="teamId">
				  		<c:forEach items="${requestScope.allTeams}" var="thisTeam">
					  		<c:if test="${currentTeam.id == thisTeam.id}">
 								<option value="${thisTeam.id}" selected>${thisTeam.city}|${thisTeam.nickname}</option>
							</c:if>
							<c:if test="${currentTeam.id != thisTeam.id}">
								<option value="${thisTeam.id}">${thisTeam.city}|${thisTeam.nickname}</option>
							</c:if>
				  		</c:forEach>
			  		</select> 
					<br />
				</td>
			</tr>
		</table>
		<br />
		<input type="hidden" name="id" value="${playerToEdit.playerId}"> 
		<input type="submit" value="Save Edited Player">
	</form>
</body>
</html>