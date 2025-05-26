<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Fruits List</title></head>
  <link rel="stylesheet" type="text/css" href="/style.css">
  
<body>
    <h1>Fruit Store</h1>
<table>
  <tr>
    <th>Name</th>
    <th>Price</th>
  </tr>
    <c:forEach var="item" items="${fruits}">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
            </tr>
        </c:forEach>
</table>

</body>
</html>