<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>



<body>
<div class="main_wrap">
	<jsp:include page="../template_header.jsp"></jsp:include>

<div>
    <form action="login" method="post">
    <h3>로그인</h3> 
    <input type="text" name="id" required="required"> <br>
	<input type="password" name="pwd" required="required"><br>
    <button type="submit">로그인</button>
    <button type="button" id="enroll">회원가입</button>
   
	</form>
	<a href="findId">아이디찾기 |</a>
	<a href="findPw">비밀번호찾기</a>
	
	 <!--<button type="button" id="findId">아이디찾기</button>
	 <button type="button" id="findPwd">비밀번호찾기</button> -->
</div>

	<script>
		$("#enroll").click(function(){
			location.href = "join";
		});
		//$("#findId").click(function(){
		//	location.href = "findId";
		//});
		//$("#findPwd").click(function(){
		//	location.href = "findPwd";
		//});
	</script> 
	
	<div class="line">
			<hr>
	</div>
         <jsp:include page="../template_footer.jsp"></jsp:include>
  </div>
</html>