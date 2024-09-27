<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>jsp 내장 객체를 이용한 scope / Second Page</h3>
	pageContext : <%=pageContext.getAttribute("num1") %>
	request : <%=request.getAttribute("num2") %>
	session : <%=session.getAttribute("num3") %>
	application : <%=application.getAttribute("num4") %>

</body>
</html>