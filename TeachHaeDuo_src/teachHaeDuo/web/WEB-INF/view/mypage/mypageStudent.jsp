 	<link href="${pageContext.request.contextPath}/resources/css/mypageStudent.css" rel="stylesheet" type="text/css">
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>

<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_Student</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mypageStudent.js"></script>
</head>
<body>

	<div>
	<jsp:include page="template_header.jsp"></jsp:include>
    <div id="main_wrap">
        <div id="left_div">
            <div id="top_div">
                <div id="profile_div" style="width:50%">
                    <div style="width:40%">
                        <img src="${pageContext.request.contextPath}/resources/icons/profile.png" width="100" height="100">
                    </div>
                    <div style="width:60%">
                        <div class="nickname_div">
                            <p>
                            	<% MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV"); %>
                            	[<%= ssMV.getmNickname() %>]
                            </p>
                        </div>
                        <div class="nickname_div">
                            <p>
								<%= ssMV.getmName() %> 학생
							</p>
                        </div>
                    </div>
                </div>
                <div style="width:50%">
                    <div class="pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p style="line-height:30px">잔여 연필</p>
                        </div>
                        <div>
                            <a href="#"><p>0원</p></a>
                        </div>
                    </div>
                    <div class="pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p style="line-height:30px">연필 충전</p>
                        </div>
                        <div>
                            <button class="charge_btn btn2_2">충전하기</button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="bottom_div">
                <div class="text_div" id="text_div1">
                    <div style="display:flex">
                        <img class="arrow" id="arrow1" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active1" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">알람 수신거부 여부</p>
                    </div>
                    <div>
                        <p class="toggle_p">OFF</p><p class="toggle_p" style="display:none;">ON </p>
                        <label class="switch">
                        <input type="checkbox">
                        <span class="slider round"></span>
                        </label>
                    </div>
                </div>
                <div class="text_div" id="text_div2">
                    <div style="display:flex">
                        <img class="arrow" id="arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <a href="#">이번 달 0건</a>
                    </div>
                </div>
                <div class="text_div" id="text_div3">
                    <div style="display:flex">
                        <img class="arrow" id="arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">내가 찜한 선생님</p>
                    </div>
                    <a href="#">총 0건</a>
                </div>
            </div>
        </div>
        <div id="right_div">
            <div style="margin:50px">
                <button class="btn1_2" onclick="location.href='memberUpdateLogin'">회원 정보 수정</button>
            </div>
        </div>
    </div>
    
    <div id="pencilcharge_modal" class="pencilcharge_modal_overlay">
        <div class="pencilcharge_modal_window">
            <div class="pencilcharge_modal_title">
                <h2>연필충전</h2>
            </div>
            <div class="pencilcharge_modal_close">X</div>
            <div class="pencilcharge_modal_content">
                <form name="charge_frm">
                    <div class="pencilcharge_won">
                        <input type="text" name="won" id="won" value="0">
                        <p> 원</p>
                    </div>
                    <div class="btns">
                        <button type="button" class="btn3_2" id="btn1">-1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="btn2">+1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="btn3">+3만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="btn4">+5만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="btn5">+10만원</button>
                    </div>
                    <div class="pencilcharge_btn">
                        <button class="btn2_2" id="charge" type="button">충전하기</button>
                        <button class="btn2_2" id="reset" type="button">정정</button>
                    </div>
                </form>
                
            </div>
        </div>
    </div>
    <jsp:include page="template_footer.jsp"></jsp:include>
    </div>
</body>
</html>