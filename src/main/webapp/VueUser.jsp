<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="controlleur" method="post">
			Login : <input type="text" name="login">
			Password : <input type="password" name="password">
			<input type="submit" value="Connecter" name="action">
			<input type="submit" value="Annuler" name="action">
	</form>
	
	<table border="1" width="80%">
		<th>
			Login
		</th>
		<th>
			Password
		</th>
		
		<c:forEach items="${userList}" var="u">
			<tr>
				<td>
					${u.login}
				</td>
				<td>
					${u.password}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>