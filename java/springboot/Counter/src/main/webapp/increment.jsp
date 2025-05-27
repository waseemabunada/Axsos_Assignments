<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>The counter has been incremented by 2!</h1>
    <h1>Page Visit Counter You have <a href="/">http://localhost:8080/</a>  <c:out value="${count}" /> times.</h1>
    
    
    <a href="/counter">Go to counter page</a>

</body>
</html>