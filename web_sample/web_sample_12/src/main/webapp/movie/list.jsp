<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 페이지</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

nav {
	display: flex;
	justify-content: space-between;
	align-items: center
}

nav a {
	margin-right: 10px
}
</style>
</head>
<body>
	<nav>
		<h1>영화 목록 페이지</h1>
	</nav>
	<a href="/web_sample_12">메인 화면으로</a>
	<a href="movie?act=insertForm">등록하기</a>
	<table>
		<thead>
			<tr>
				<th>영화 코드</th>
				<th>영화 제목</th>
				<th>영화 장르</th>
			</tr>
		</thead>
		<tbody>
				<c:forEach items="${list}" var="m">
				<tr>
					<td>${m.code}</td>
					<td><a href="movie?act=read&code=${m.code}">${m.title}</a></td>
					<td>${m.genre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>