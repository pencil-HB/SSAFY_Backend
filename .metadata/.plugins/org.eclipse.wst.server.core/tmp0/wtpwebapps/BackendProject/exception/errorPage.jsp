<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%--  에러 처리 페이지는 반드시 아래 속성을 가져야 함 --%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>예외 발생</h1>
예외 종류: <%=exception.getClass().getSimpleName() %> <br>
예외 메세지: <%=exception.getMessage() %>
</body>
</html>