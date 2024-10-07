<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 페이지</title>
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
	<h1>제품 상세 페이지</h1>
	</nav>
	<a href="product?act=list">목록으로</a>
	<table>
		<tr>
			<th>제품 코드</th>
			<td>${product.code }</td>
		</tr>
		<tr>
			<th>제품명</th>
			<td>${product.name }</td>

		</tr>
		<tr>
			<th>수량</th>
			<td>${product.quantity }</td>
		</tr>
		<tr>
			<th>제품 분류</th>
			<td>${product.category }</td>
		</tr>
	</table>
	<a href="product?act=update&code=${product.code }">수정</a>
	<a href="product?act=delete&code=${product.code }">삭제</a>
</body>
</html>