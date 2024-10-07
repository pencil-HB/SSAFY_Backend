<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 목록 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

nav {
display : flex;
justify-content : space-between;
align-items : center
}
nav a {
margin-right: 10px
}
</style>
</head>
<body>
<nav>
	<h1>제품 목록 페이지</h1>
	</nav>
	<a href="index.jsp">메인 화면으로</a>
	<a href="product?act=regist">등록하기</a>
	<table>
		<thead>
			<tr>
				<th>제품 코드</th>
				<th>제품명</th>
				<th>제품 수량</th>
			</tr>
		</thead>
			 <c:forEach items="${list }" var="p">
		<tbody>
			 	<td><a href="product?act=read&code=${p.code }">${p.code }</a></td>
			 	<td>${p.name }</td>
			 	<td>${p.quantity }</td>
		</tbody>
			 </c:forEach>
	</table>
</body>
</html>