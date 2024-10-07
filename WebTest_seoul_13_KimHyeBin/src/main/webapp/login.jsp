<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
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
		<h1>로그인 페이지</h1>
	</nav>
	<form action="member?act=login" method="post">
		<fieldset>
			<label> 아이디 <input type="text" name="id"></label>
			<br> 
			<label> 비밀번호 <input type="password" name="password">
				</label> <br>
			<div>
				<label> <input type="checkbox" name="remember"> 아이디 기억하기
				</label>
			</div>
			<input type="submit" value="로그인"> <br> <a
				href="index.jsp">메인 화면으로</a>
		</fieldset>
	</form>
</body>
</html>