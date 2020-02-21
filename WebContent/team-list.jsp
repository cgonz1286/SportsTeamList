<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
					<td>${currentTeam.city}</td>
					<td>${currentTeam.nickname}</td>
					<td>${currentTeam.numOfPlayers}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Edit" name="doThisToTeam"> 
		<input type="submit" value="Delete" name="doThisToTeam"> 
		<input type="submit" value="Add" name="doThisToTeam">
	</form>
</body>
</html>