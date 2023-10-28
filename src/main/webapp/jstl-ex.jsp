<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WEB STUDY</title>
</head>
<body>
    <% for (int i = 0; i < 3; i++) {%>
        <c:forEach var="i" begin="1" end="3" step="1">
            <h1>Inspire ${i} millions</h1>
        </c:forEach>
        <h1>Inspire <%= i %> millions</h1>
<%}%>


    <c:set var="age" value="10" />
    <c:if test="${age > 19}">
        <h2>Inspire $ millions</h2>
    </c:if>
    <c:set var="age" value="10" />
    <c:if test="${age <= 19}">
        <h2>Inspire * millions</h2>
    </c:if>

    <c:choose>
        <c:when test="${age > 19}">
            <h2>성인입니다.</h2>
        </c:when>
        <c:when test="${age > 16}">
            <h2>고등학생입니다.</h2>
        </c:when>
        <c:otherwise>
            <h2>중학생 이하입니다.</h2>
        </c:otherwise>
    </c:choose>


</body>
</html>