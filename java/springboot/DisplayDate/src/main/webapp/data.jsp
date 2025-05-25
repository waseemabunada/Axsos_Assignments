<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
</head>
<body>
<h1>Date1</h1>

 <p><fmt:formatDate value="${now}" pattern="EEEE, MMMM d, yyyy" /></p>
 
 <script src="/js/alert.js"></script>
</body>
</html>
