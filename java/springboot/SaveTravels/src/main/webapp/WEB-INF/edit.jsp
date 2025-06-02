<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="container mt-5">

    <h2>Edit Expense</h2>
    
        <form:form action="/expenses/edit/${travels.id}" method="post" modelAttribute="travels">
        <div class="mb-3">
        <input type="hidden" name="_method" value="put">
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
            <form:label path="amount" cssClass="form-label">amount</form:label>
            <form:input path="amount" type="number" min="1" max="10000" cssClass="form-control" />
            <form:errors path="amount" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="description" cssClass="form-label">Descriotion</form:label>
            <form:input path="description" cssClass="form-control" />
            <form:errors path="description" cssClass="text-danger" />
        </div>

        <input type="submit" value="Submit" class="btn btn-primary" />
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
