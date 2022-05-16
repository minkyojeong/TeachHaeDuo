<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://ucarecdn.com/libs/widget/3.x/uploadcare.full.min.js"></script>
<style>
.uploadcare--widget__button.uploadcare--widget__button_type_open {
	background-color: #FA9D00;
}
</style>
<script>
    UPLOADCARE_LOCALE = "ko"
    UPLOADCARE_LOCALE_TRANSLATIONS = {
        buttons: {
            choose: {
                files: {
                    one: '사진등록'
                }
            }
        }
    }
</script>
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
		<a href="mypage">a태그 마이페이지</a> ${ssMV.getRoleSt()}
		<button id="btn3" type="button">메인으로</button>
		<button id="btn4" type="button">테스트버튼</button>
		<input type="hidden" role="uploadcare-uploader"
			data-public-key="43cc829c5d2fae8676a5"
			data-tabs="file camera url facebook gdrive gphotos" />
	</form>
	<!-- <img src="https://ucarecdn.com/3bf330a6-5d50-4824-a2e6-896f9cc34e81/"> -->
	
	<script>
	$("#btn1").click(function(){
		location.href = "mypage";
	});
	$("#logout").click(function(){
		location.href="logout";
	});
	$("#btn3").click(function(){
		console.log("메인으로");
		location.href="<%=request.getContextPath()%>";
	});
	$("#btn4").click(function(){
		console.log("테스트버튼클릭");
		location.href= "test";
	});
	var singleWidget = uploadcare.SingleWidget('[role=uploadcare-uploader]');
	singleWidget.onUploadComplete(function(info){
		console.log(info.cdnUrl);
	});
	</script>
</body>
</html>