<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Instructor Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
<%@include file="menu.jsp" %>
	<h3>Add instructor here</h3>
	<form:form action="submit-instructor" method="POST"
		modelAttribute="instructor">
		<label>Name: </label>
		<form:input path="instructor_name" />
		<br />
		<label>Experience: </label>
		<form:input path="instructor_training_exp" />
		<br />
		<label>Email: </label>
		<form:input path="instructor_email" />
		<br />
		<input type="submit" value="Add">
	</form:form>
</body>
</html>