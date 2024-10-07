<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정 페이지</title>
<style>
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
	<h1>제품 수정 페이지</h1>
	</nav>
	<form action="prduct?act=updateProcess" method="post">
		<fieldset>
			<br>
			<label> 제품 코드 <input type="text" name="code" value=""></label>
			<br>
			<label> 제품명 <input type="text" name="name" value=""></label>
			<br>
			<label> 수량 <input type="number" name="quantity" value=""></label>
			<br>
			<label> 제품 분류 
			<select name="category">
					<option value="book" >책</option>
					<option value="keyboard" >키보드</option>
					<option value="mouse" >마우스</option>
			</select></label>
			<br>
			<input type="submit" value="수정">
			<br>
			<a href="product?act=read&code=${param.code}">상세 페이지</a>
		</fieldset>
	</form>
</body>
</html>