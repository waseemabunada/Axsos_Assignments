<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
</head>
<body>
<h1>time</h1>
<p><fmt:formatDate value="${now}" pattern="hh:mm:ss a" /></p> 
</body>
</html>