<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learning Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
</head>
<body>
	<%@include file="menu.jsp"%>
	<div class="container">
		<h1>Our Instructors</h1>
		<div align="left">
			<form:form action="process-search-id" method="GET"
				modelAttribute="searchDTO">
				<label>Search by Id</label>
				<form:input path="id" />
				<input type="submit" value="search">
			</form:form>
			<br/>
		</div>
		<div align="left">
			<form:form action="process-search-name" method="GET"
				modelAttribute="searchDTO">
				<label>Search by Name</label>
				<form:input path="name" />
				<input type="submit" value="search">
			</form:form>
			<br/>
		</div>
		<div align="right">
		<a href="/ORM/instructor-info">Refresh-list</a>
		</div>
		<table class="table">

			<thead>
				<tr class="table-primary">
					<th>Id</th>
					<th>Name</th>
					<th>Experience</th>
					<th>E-Mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="instructor" items="${instructorList}">
					<tr>

						<td>${instructor.instructor_id}</td>
						<td>${instructor.instructor_name}</td>
						<td>${instructor.instructor_training_exp}</td>
						<td>${instructor.instructor_email}</td>
						<td><a href="/ORM/delete/${instructor.instructor_id}" class="btn btn-danger">delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>