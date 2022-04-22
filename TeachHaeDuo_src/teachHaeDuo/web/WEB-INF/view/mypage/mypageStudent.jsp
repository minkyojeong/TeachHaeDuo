<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/mypageStudent.css"
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
    <div id="ms_main_wrap">
        <div id="ms_left_div">
            <div id="ms_top_div">
                <div id="ms_profile_div" style="width:50%">
                    <div style="width:40%">
                        <img src="${pageContext.request.contextPath}/resources/icons/profile.png" width="100" height="100">
                    </div>
                    <div style="width:60%">
                        <div class="ms_nickname_div">
                            <p>[닉네임]</p>
                        </div>
                        <div class="ms_nickname_div">
                            <p>[이름]</p>
                        </div>
                    </div>
                </div>
                <div style="width:50%">
                    <div class="ms_pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p style="line-height:30px">잔여 연필</p>
                        </div>
                        <div>
                            <a href="#"><p>0원</p></a>
                        </div>
                    </div>
                    <div class="ms_pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p style="line-height:30px">연필 충전</p>
                        </div>
                        <div>
                            <button class="ms_charge_btn btn2_2">충전하기</button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="ms_bottom_div">
                <div class="ms_text_div" id="ms_text_div1">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow1" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active1" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">알람 수신거부 여부</p>
                    </div>
                    <div>
                        <p class="ms_toggle_p">OFF</p><p class="ms_toggle_p" style="display:none;">ON </p>
                        <label class="ms_switch">
                        <input type="checkbox">
                        <span class="ms_slider ms_round"></span>
                        </label>
                    </div>
                </div>
                <div class="ms_text_div" id="ms_text_div2">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <a href="#">이번 달 0건</a>
                    </div>
                </div>
                <div class="ms_text_div" id="ms_text_div3">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">내가 찜한 선생님</p>
                    </div>
                    <a href="#">총 0건</a>
                </div>
            </div>
        </div>
        <div id="ms_right_div">
            <div style="margin:50px">
                <button class="btn1_2" onclick="location.href='memberModify'">회원 정보 수정</button>
            </div>
        </div>
    </div>
    
    <div id="ms_pencilcharge_modal" class="ms_pencilcharge_modal_overlay">
        <div class="ms_pencilcharge_modal_window">
            <div class="ms_pencilcharge_modal_title">
                <h2>연필충전</h2>
            </div>
            <div class="ms_pencilcharge_modal_close">X</div>
            <div class="ms_pencilcharge_modal_content">
                <form name="ms_charge_frm">
                    <div class="ms_pencilcharge_won">
                        <input type="text" name="won" id="won" value="0">
                        <p> 원</p>
                    </div>
                    <div class="ms_btns">
                        <button type="button" class="btn3_2" id="ms_btn1">-1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="ms_btn2">+1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="ms_btn3">+3만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="ms_btn4">+5만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_2" id="ms_btn5">+10만원</button>
                    </div>
                    <div class="ms_pencilcharge_btn">
                        <button class="btn2_2" id="ms_charge" type="button">충전하기</button>
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