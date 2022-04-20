<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/font.css"
	rel="stylesheet" type="text/css">

<%@ page import="test.kh.semi.thduo.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
</style>
</head>
<body>
	<ol>
		<li>reset.css 적용이</li>
		<li>왜 안돼</li>
		<il>된당</il>
	</ol>

	<button id="testbtn" class="btn2_2">테스트</button>
	<%
		MemberVo ssMV = (MemberVo) session.getAttribute("ssMV");

	if (ssMV == null) {
	%>
	<button id="testbtn2" class="btn1_1">db 연동 로그인</button>
	<%
		} else {
	%>
	<button id="testbtn3" class="btn2_1">로그아웃</button>
	<%=ssMV.getmId()%>
	<%
		}
	%>
	<img src="${pageContext.request.contextPath}/resources/icons/profile.png" width="50">
	<p>폰트 체크체크</p><br>
	<p style="font-weight:bold">폰트 체크체크</p><br>
	<p style="font-family: MinSans-Medium">폰트 체크체크</p><br>
	<p style="font-family: MinSans-Bold">폰트 체크체크</p><br>
	



	<script>
		$("#testbtn").click(function() {
			location.href = "TestViewPageController";
		});
		$("#testbtn2").click(function() {
			location.href = "TestLogin";
		});
		$("#testbtn3").click(function() {
			location.href = "testlogout";
		});
	</script>
</body>
</html>