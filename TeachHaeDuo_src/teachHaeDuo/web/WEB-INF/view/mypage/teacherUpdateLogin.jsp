
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/teacherUpdateLogin.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="UTF-8">
    <title>mypage_updateMember</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div id="main_wrap">
	<jsp:include page="../template_header.jsp"></jsp:include>
    <div class="wrap content">
        <form action="teacherUpdate" method="post">
            <div id="top_div">
                <p id="updateTitle">교습 정보 등록</p>
            </div>
            <div id="middle_div">
                <table id="teacherUpdateLoginTable">
                    <tr>
                        <td>
                           <p> 아이디</p>
                        </td>
                        <td>
                            <% MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV"); %>
                            <%= ssMV.getmId() %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            비밀번호
                        </td>
                        <td>
                            <input name="pw" type="password">
                        </td>
                    </tr>
                    <tr>
                    	<td colspan="2" style="color:red;">* 교습 정보 등록을 위해 한번 더 로그인 해 주세요.</td>
                    </tr>
                </table>
            </div>
            <div id="low_div">
                <button class="btn2_3" type="submit" id="login">로그인</button>
                <button class="btn2_3" type="button" id="cancel">취소</button>
            </div>
        </form>
    </div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
    </div>
    <script>
	    $("#cancel").click(function(){
	    	console.log("취소 버튼 클릭");
	    	location.href="mypage";
			
		});
	    var msgPwVal = '${msgPw}';
	    if(msgPwVal != null && msgPwVal != ""){
	    	alert(msgPwVal);
	    	location.replace("memberUpdateLogin");
	    }
   </script>
   <% request.getSession().removeAttribute("msgPw"); %>
</body>
</html>