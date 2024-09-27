<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>forEach Test</h1>

<c:forEach begin="1" end="5" step="1" var="i">
	${i }. hello<hr>
</c:forEach>

<% int[] score = {100, 30, 78, 56, 98};
pageContext.setAttribute("score", score);

ArrayList<String> list = new ArrayList();
list.add("Summer");
list.add("Sinter");
list.add("Autumn");
list.add("Spring");
pageContext.setAttribute("list", list);
%>

<c:forEach var="s" items="${score }">
	${s } <br>
</c:forEach>

<hr>

<c:forEach var="s" items="${list }">
	${s } <br>
</c:forEach>

</body>
</html>