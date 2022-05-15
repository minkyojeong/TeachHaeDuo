<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.thduo.alarm.model.vo.AlarmVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<div class="wrap header">
	<header>
		<div class="logo">
			<a href=" "> 
				<img src="${pageContext.request.contextPath}/resources/icons/logo.jpg">
			</a>
		</div>
		<nav class="menu">
			<ul>
				<c:choose>
					<c:when test="${not empty ssMV}">
						<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a><span>&nbsp;&nbsp;</span></li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
	</header>
	<div class="clear line">
		<hr>
	</div>
</div>
