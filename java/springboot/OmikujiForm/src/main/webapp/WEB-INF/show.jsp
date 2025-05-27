<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        <h1 class="text-center text-primary mb-4">Here's Your Omikuji!</h1>

        <div class="alert alert-success">
            <p class="fw-bold">Your fortune includes:</p>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    Lucky Number: <span class="fw-bold text-success"><c:out value="${sessionScope.number}" /></span>
                </li>
                <li class="list-group-item">
                    City: <span class="fw-bold"><c:out value="${sessionScope.name_city}" /></span>
                </li>
                <li class="list-group-item">
                    Person: <span class="fw-bold"><c:out value="${sessionScope.name_person}" /></span>
                </li>
                <li class="list-group-item">
                    Hobby or Profession: <span class="fw-bold"><c:out value="${sessionScope.professional}" /></span>
                </li>
                <li class="list-group-item">
                    Nice Message: <span class="fw-bold text-info"><c:out value="${sessionScope.nice}" /></span>
                </li>
            </ul>
        </div>

        <div class="text-center mt-4">
            <a href="/" class="btn btn-primary">Send Another Omikuji</a>
        </div>
    </div>
</div>

<!--
<h1>Here's Your Omikuji!</h1>
<p>
  <c:out value="${sessionScope.number}" />,
  <c:out value="${sessionScope.name_city}" />,
  <c:out value="${sessionScope.name_person}" />,
  <c:out value="${sessionScope.professional}" />,
  <c:out value="${sessionScope.nice}" />
</p>
 -->

</body>
</html>
