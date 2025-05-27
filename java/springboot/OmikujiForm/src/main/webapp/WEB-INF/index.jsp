<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">
<div class="container mt-5">
    <div class="card shadow p-4">
        <h1 class="mb-4 text-success">Send an Omikuji!</h1>
        <form action="/Omikuji/display" method="post">
            <div class="mb-3">
                <label for="number" class="form-label">Pick any number from 5 to 25</label>
                <input type="number" id="number" name="number" min="5" max="25" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Enter the name of any city</label>
                <input type="text" name="name_city" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Enter the name of any real person</label>
                <input type="text" name="name_person" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Enter professional endeavor or hobby</label>
                <input type="text" name="professional" class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label">Enter any type of living thing</label>
                <input type="text" name="living" class="form-control">
            </div>

            <div class="mb-3">
                <label for="w3review" class="form-label">Say something nice to someone</label>
                <textarea id="w3review" name="nice" rows="4" class="form-control"></textarea>
            </div>

            <button type="submit" class="btn btn-success w-100">Send</button>
        </form>

        <p class="text-center mt-3 text-muted">Send and show a friend</p>
    </div>
</div>

</body>
</html>