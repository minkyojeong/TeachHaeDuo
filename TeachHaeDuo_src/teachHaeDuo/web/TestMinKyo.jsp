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
	<button id="btn1">마이페이지 학생</button>
	<button id="btn2">마이페이지 선생</button>
	<script>
	$("#btn1").click(function(){
		location.href = "mypageStudent"
	});
	$("#btn2").click(function(){
		location.href = "mypageTeacher"
	});
	</script>
</body>
</html>