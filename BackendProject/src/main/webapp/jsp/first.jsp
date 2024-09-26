<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" info="my First JSP"%>
<%@ page import="java.sql.Connection, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>first jsp</h1>
	<% int num = 999; %>
	number: <%= num %>
	<br>
	<%@ include file="second.jsp" %>
	
	<h1>this is another world</h1>
	<%@ include file="second.jsp" %>
	
</body>
</html>