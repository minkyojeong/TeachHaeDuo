<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/login.css" rel="stylesheet" type="text/css">
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
</div>
	<div class="card align-middle" style="width:25rem;">

      <div>
        <h2 class="card-title" style="color:#FA9D00;" >로그인</h2> 
      </div>

        <form action="login"  class="login" method="post">
            <div class="checkbox">
                <label>
                <input type="radio"  name="mode" value="admin"> 관리자
                &nbsp;&nbsp;
                <input type="radio" name="mode" value="member" checked> 일반회원
                </label>
            </div>
            <div class="card-body">
                <input type="text" name="id"  class="form-control" placeholder="아이디" required="required"> <br>
                <input type="password" name="pwd" class="form-control" placeholder="비밀번호"  required="required"><br>
                <p id="check" class="check">${login_msg}</p><br/>
                <button type="submit" id="btn-Yes" class="form-control">로그인</button> <br>
                
        </form>
 	</div>
 	
    <div class="links">
    
            <a href="findId">아이디 찾기 &nbsp; |</a>   <a href="findPw">&nbsp;비밀번호 찾기 &nbsp;</a>   <a href="join">| &nbsp; 회원가입</a>
    </div>

    




</div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
</div>
</html>