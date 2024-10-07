<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<c:if test="${userId == null }">
	<a href="login.jsp">로그인</a>
</c:if>
<c:if test="${userId  != null}">
	<div>
		<span> ${sessionScope.userName }님 로그인 중</span> <a href="member?act=logout">로그아웃</a>
	</div>
</c:if>