<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addAlien">
Enter Id:<input type="text" name="aid" ><br>
Enter name:<input type="text" name="aname"><br>
Enter tech:<input type="text" name="tech"><br>
<input type="submit" value="Add to DB">
</form>

<br>
<form action="getAlien">
Enter Id:<input type="text" name="aid" ><br>
<input type="submit" value="Fetch from DB">
</form>

</body>
</html>