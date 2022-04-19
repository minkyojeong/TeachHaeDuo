<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>로그인</title>
</head>
<body>
	<form action="TestLogin" method="post">
		<input type="text" name="id" required="required">
		<input type="password" name="pwd" required="required">
		<br>
		<button type="submit">로그인</button>
	</form>
	<button type="button" id="enroll">회원가입</button>
	<button type="button" id="findId">아이디 찾기</button>
	<button type="button" id="findPwd">비밀번호 찾기</button>
	<script>
	$("#enroll").click(function(){
		location.href="enroll";
	});
	$("#findId").click(function(){
		location.href="findId";
	});
	$("#findPwd").click(function(){
		location.href="findPwd";
	});
	</script>
</body>
</html>