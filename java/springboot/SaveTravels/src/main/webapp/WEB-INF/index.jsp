<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4 text-center"> Save Travels</h1>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Action</th>
                <th>delete<th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="travels" items="${travelss}">
                <tr>
                    <td>${travels.id}</td>
                    <td><a href="/expenses/${travels.id}" class="text-decoration-none">${travels.expenseName}</a></td>
                    <td>${travels.vendor}</td>
                    <td>${travels.amount}$</td>
                    <td><a href="/expenses/edit/${travels.id}">edit</a></td>
                    <td>
                    <form action="/travels/${travels.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
					</td>
                   
            </c:forEach>
        </tbody>
    </table>

    <hr class="my-5"/>

    <h2 class="mb-3">Add an expense:</h2>
    <p class="text-muted">* Notes must not be blank</p>

    <form:form action="/" method="post" modelAttribute="travels">
        <div class="mb-3">
            <form:label path="expenseName" cssClass="form-label">expenseName</form:label>
            <form:input path="expenseName" cssClass="form-control" />
            <form:errors path="expenseName" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="vendor" cssClass="form-label">vendor</form:label>
            <form:textarea path="vendor" cssClass="form-control" rows="2" />
            <form:errors path="vendor" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="amount" cssClass="form-label" >amount</form:label>
            <form:input path="amount" type="number" min="1" max="10000" cssClass="form-control" step="0.01" />
            <form:errors path="amount" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="description" cssClass="form-label">Description</form:label>
            <form:input path="description" cssClass="form-control" />
            <form:errors path="description" cssClass="text-danger" />
        </div>

        <input type="submit" value="Submit" class="btn btn-primary" />
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
