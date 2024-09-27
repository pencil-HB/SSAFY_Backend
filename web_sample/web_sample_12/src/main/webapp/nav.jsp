<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<c:if test="${empty member }">
		<a href="movie?act=loginForm">로그인</a>
</c:if>
<c:if test="${!empty member }">
		<div>
			<span> 님 로그인 중</span> 
			<a href="movie?act=logout">로그아웃</a>
		</div>
</c:if>
