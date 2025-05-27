<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Counter</title>
     <link rel="stylesheet" type="text/css" href="/style.css">
    
</head>
<body>
    <h1>You have Visited  <a href="/">http://localhost:8080/</a>  <c:out value="${count}" /> times.</h1>

    <p><a href="/">Test another visit?</a></p>

</body>
</html>
