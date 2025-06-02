<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body class="container mt-5">

    <h2>Edit Burger</h2>
    
    <form:form action="/burgers/edit/${burger.id}" method="post" modelAttribute="burger">
        <div class="mb-3">
        <input type="hidden" name="_method" value="put">
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
            <form:textarea path="notes" cssClass="form-control" rows="3" />
            <form:errors path="notes" cssClass="text-danger" />
        </div>

        <input type="submit" value="Submit Burger" class="btn btn-primary" />
    </form:form>
    	<a href="/"  class="text-primary text-decoration-underline"> Back Page</a>

</body>
</html>
