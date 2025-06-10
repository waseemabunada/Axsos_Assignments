<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Dorms</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
	<h1>Dorms</h1>
	<div> <a href="/dorms/new">Add a new dorm </a> </div>
	<div> <a href="/students/new">Add a new student  </a> </div>
	
	<table class="table table-striped mt-3">
		<thead>
			<tr>
				<th>Dorm</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach var="dorm" items="${dorms}">
			<tr>
					<td>${dorm.name}</td>
					<td> <a href="/dorm/${dorm.id}">See Students </a> </td>
			</tr>
				</c:forEach>
		</tbody>
	</table>
</body>
</html>