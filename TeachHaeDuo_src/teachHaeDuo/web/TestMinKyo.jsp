<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</head>
<body>
	<%-- 
	<%
	    	MemberVo ssMV = (MemberVo)session.getAttribute("ssMV");
	    	if(ssMV==null){
	    %>
	    	<button id="login">Sign in</button>
	<%}else{ %>
	    	<button id="logout">Sign out</button>
	  <%} %> 
 --%>
	<form action="login" method="post">
		<h3>로그인</h3>
		<input type="text" name="id"> <br> <input type="password"
			name="pwd"><br>
		<%
			MemberVo ssMV = (MemberVo) session.getAttribute("ssMV");
		if (ssMV == null) {
		%>
		<button type="submit">로그인</button>
		<%
			} else {
		%>
		<button id="logout" type="button">Sign out</button>
		<%
			}
		%>
		<%=ssMV%>
		<button id="btn1" type="button">마이페이지</button>
		<a href = "mypage">a태그 마이페이지</a>
		${ssMV.getRoleSt()}
		<button id="btn3" type="button">메인으로</button>
	</form>
	<script>
	$("#btn1").click(function(){
		location.href = "mypage";
	});
	$("#logout").click(function(){
		location.href="logout";
	});
	$("#btn3").click(function(){
		console.log("메인으로");
		location.href="<%= request.getContextPath() %>";
	});
	</script>
</body>
</html>