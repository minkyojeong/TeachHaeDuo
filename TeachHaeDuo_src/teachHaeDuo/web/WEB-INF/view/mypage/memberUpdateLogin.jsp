
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/memberUpdateLogin.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_updateMember</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div>
	<jsp:include page="../template_header.jsp"></jsp:include>
    <div id="main_wrap">
        <form action="memberUpdate" method="post">
            <div id="top_div">
                <p style="font-size:17px"><회원정보수정></p>
            </div>
            <div id="middle_div">
                <table>
                    <tr>
                        <td>
                            아이디
                        </td>
                        <td>
                            :
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
                            :
                        </td>
                        <td>
                            <input name="pw" type="password">
                        </td>
                    </tr>
                </table>
            </div>
            <div id="low_div">
                <button class="btn2_2" type="submit" id="login">로그인</button>
                <button class="btn2_2" type="button" id="cancel">취소</button>
            </div>
        </form>
    </div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
    </div>
    <script>
	    $("#cancel").click(function(){
	    	console.log("취소 버튼 클릭");
			var roleSt = "<%= ssMV.getRoleSt() %>";
			if(roleSt == "S"){
	    		location.href="mypageStudent";
			} else if(roleSt == "T"){
	    		location.href="mypageTeacher";
			}
		});
   </script>
</body>
</html>