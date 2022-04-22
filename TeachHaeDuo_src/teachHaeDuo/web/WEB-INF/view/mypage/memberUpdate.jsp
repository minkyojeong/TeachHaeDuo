<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/mypageUpdate.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_modifymember</title>
    <style>

    </style>
</head>
<body>
	<div>
	<jsp:include page="template_header.jsp"></jsp:include>
    <div id="mm2_main_wrap">
        <form action="#" method="post">
            <div id="mm2_top_div">
                <p style="font-size:17px"><회원정보수정></p>
            </div>
            <div id="mm2_middle_div">
                <table>
                    <tr>
                        <td>
                            아이디
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
							<% MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV"); %>
							<%= ssMV.getmId() %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            주소변경
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
                            <input type="text">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            닉네임 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            <input name="mNickname" type="text" placeholder="<%= ssMV.getmNickname()%>">
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            휴대폰 번호 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
                            <input name="mPhone" type="text" placeholder="<%= ssMV.getmPhone()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            이메일 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            <input name="mEmail" type="text" placeholder="<%= ssMV.getmEmail()%>">
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>
            </div>
            <div id="mm2_low_div">
                <button class="btn2_2" type="submit">수정 완료</button>
                <button class="btn2_2">취소</button>
                <button class="btn2_2">회원탈퇴</button>
            </div>
        </form>
    </div>
    <jsp:include page="template_footer.jsp"></jsp:include>
    </div>
</body>
</html>