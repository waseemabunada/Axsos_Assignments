<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h1 class="mb-4">New Student</h1>
   <div> <a href="/dorms">Back Dashboard</a> </div>
    
    <form:form action="/students/form" method="post" modelAttribute="student" class="w-50">
        <div class="mb-3">
            <form:label path="name" class="form-label">Name</form:label>
            <form:input path="name" class="form-control" />
            <form:errors path="name" class="text-danger" />
        </div>
 
        <div class="mb-3">
            <form:label path="dorm" class="form-label">Select Dorm :</form:label>
            <form:select path="dorm" class="form-select">
            <form:errors path="dorm" class="text-danger" />
                <c:forEach var="oneDorm" items="${dorms}">
                <form:option value="">-- No Dorm --</form:option>
 
                    <form:option value="${oneDorm.id}">
                        ${oneDorm.name}
                    </form:option>
                </c:forEach>
            </form:select>
        </div>
        
 
 
        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</body>
</html>