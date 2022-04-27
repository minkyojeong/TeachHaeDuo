<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wrap header">
	<header>
		<div class="logo">
			<a href="./"> 
				<img src="${pageContext.request.contextPath}/resources/icons/logo.jpg">
			</a>
		</div>
		<nav class="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/teacherSearch">선생님찾기&nbsp;&nbsp;</a></li>
				<li><a>질문하기&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<li><a>고객센터&nbsp;&nbsp;</a></li>
				<li><a>이용방법&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<c:choose>
					<c:when test="${empty ssMV}">
						<li><a href="login">로그인&nbsp;&nbsp;</a></li>
						<li><a href="join">회원가입</a></li>
					</c:when>
					<c:when test="${not empty ssMV}">
						<li><a href="#1">알림&nbsp;&nbsp;</a></li>
						<li><a href="logout">로그아웃&nbsp;&nbsp;</a></li>
						<!-- 관리자 로그인 시 처리할 부분 -->
<%-- 						<c:if test="${ssMV.mId == 'admin'}">
							<li><a href="logout">관리자페이지&nbsp;&nbsp;</a></li>
						</c:if> --%>
						<li><a href="mypage">마이페이지</a></li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
	</header>
	<div class="clear line">
		<hr>
	</div>
</div>