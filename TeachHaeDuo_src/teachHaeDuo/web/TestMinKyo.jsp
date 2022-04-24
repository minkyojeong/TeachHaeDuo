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
    <input type="text" name="id"> <br>
	<input type="password" name="pwd"><br>
	<%
    	MemberVo ssMV = (MemberVo)session.getAttribute("ssMV");
    	if(ssMV==null){
    %>
    	<button type="submit">로그인</button>
<%}else{ %>
    	<button id="logout">Sign out</button>
  <%} %>
    <%=ssMV %>
	<button id="btn1">마이페이지</button>
	${ssMV.getRoleSt()}
	<button id="btn3" type="button">메인으로</button>
	<script>
	 $("#btn1").click(function(){
		if(ssMV != null){
			var roleSt = "<%= ssMV.getRoleSt() %>";
		
			if(roleSt == "S"){
				location.href = "mypageStudent";
			} else if(roleSt == "T"){
				location.href = "mypageTeacher"
			}
		} else {
			alert("로그인을 해주세요.");
			location.href = "login";
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