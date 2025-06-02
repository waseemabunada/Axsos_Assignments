<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4 text-center">🍔 Burger Tracker</h1>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Burger Name</th>
                <th>Restaurant Name</th>
                <th>Rating (out of 5)</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="burger" items="${burgers}">
                <tr>
                    <td>${burger.id}</td>
                    <td><a href="/burger/${burger.id}" class="text-decoration-none">${burger.burgerName}</a></td>
                    <td>${burger.restaurantName}</td>
                    <td>${burger.rating}</td>
                     <td><a href="/burgers/edit/${burger.id}">edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <hr class="my-5"/>

    <h2 class="mb-3">Add a Burger</h2>
    <p class="text-muted">* Notes must not be blank</p>

    <form:form action="/" method="post" modelAttribute="burger">
        <div class="mb-3">
            <form:label path="burgerName" cssClass="form-label">Burger Name</form:label>
            <form:input path="burgerName" cssClass="form-control" />
            <form:errors path="burgerName" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="restaurantName" cssClass="form-label">Restaurant Name</form:label>
            <form:textarea path="restaurantName" cssClass="form-control" rows="2" />
            <form:errors path="restaurantName" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="rating" cssClass="form-label">Rating (1 to 5)</form:label>
            <form:input path="rating" type="number" min="1" max="5" cssClass="form-control" />
            <form:errors path="rating" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="notes" cssClass="form-label">Notes</form:label>
            <form:input path="notes" cssClass="form-control" />
            <form:errors path="notes" cssClass="text-danger" />
        </div>

        <input type="submit" value="Submit Burger" class="btn btn-primary" />
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
