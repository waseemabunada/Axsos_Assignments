<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4 text-center">Home Page</h1>
    <h2>User: ${user.username}</h2>
    <a href="/logout" class="btn btn-outline-primary mb-3">Sign Out</a>

    <div class="mb-3">
        <a href="/products/new" class="btn btn-primary me-2">New Product</a>
        <a href="/categories/new" class="btn btn-secondary">New Category</a>
    </div>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Products</th>
                <th>Categories</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>
                    <ul class="list-unstyled">
                        <c:forEach var="p" items="${products}">
                            <li><a href="/products/${p.id}">${p.name}</a></li>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <ul class="list-unstyled">
                        <c:forEach var="c" items="${categories}">
                            <li><a href="/categories/${c.id}">${c.name}</a></li>
                        </c:forEach>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>
</div>
</body>
</html>
