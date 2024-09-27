<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set value="${param.num}" var="num" />
	<c:if test="${empty num }">
		<h1>empty!!!</h1>
	</c:if>
	<c:if test="${!empty num }">
		<c:if test="${num eq 100 }">
	welcome!</c:if>
		<c:if test="${num ne 100 }"> bye! </c:if>
	</c:if>

</body>
</html>