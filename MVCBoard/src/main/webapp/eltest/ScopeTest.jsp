<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- scope : 데이터를 사용할 수 있는 범위 --%>
	<h1>Scope Test</h1>

	<%
	pageContext.setAttribute("num1", 100);
	request.setAttribute("num2", 200);
	session.setAttribute("num3", 300);
	application.setAttribute("num4", 400);
	%>
	
	<h3>jsp 내장 객체를 이용한 scope</h3>
	pageContext : <%=pageContext.getAttribute("num1") %>
	request : <%=request.getAttribute("num2") %>
	session : <%=session.getAttribute("num3") %>
	application : <%=application.getAttribute("num4") %>

	<h3>el 내장 객체를 이용한 scope</h3>
	pageScope : ${ pageScope.num1 } <br>
	requestScope : ${ requestScope.num2 } <br>
	sessionScope : ${ sessionScope.num3 } <br>
	applicationScope : ${ applicationScope.num4 } <br>
	<hr>
	
	pageScope : ${ num1 } <br>
	requestScope : ${ num2 } <br>
	sessionScope : ${ num3 } <br>
	applicationScope : ${ num4 } <br>
</body>
</html>