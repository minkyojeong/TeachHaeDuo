<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/mypageTeacher.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_Teacher</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/mypageTeacher.js"></script>
</head>
<body>
	<div>
	<jsp:include page="template_header.jsp"></jsp:include>
    <div id="mt_main_wrap">
        <div id="mt_left_div">
            <div id="mt_top_div">
                <div id="mt_profile_div" style="width:50%">
                    <div style="width:40%">
                        <img src="${pageContext.request.contextPath}/resources/icons/profile.png" width="100" height="100">
                    </div>
                    <div style="width:60%">
                        <div class="mt_nickname_div">
                            <p>[닉네임]</p>
                        </div>
                        <div class="mt_nickname_div">
                            <p>[이름]</p>
                        </div>
                        <div class="mt_nickname_div">
                            <button class="btn2_2">사진 수정</button>
                        </div>
                    </div>
                </div>
                <div style="width:50%">
                    <div class="mt_pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p>잔여 연필</p>
                        </div>
                        <div>
                            <a href="#"><p>0원</p></a>
                        </div>
                    </div>
                    <div class="mt_pencil_div">
                        <div style="display:flex;">
                            <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p>연필 충전</p>
                        </div>
                        <div>
                            <a href="#"><p>충전하기</p></a>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="mt_bottom_div">
                <div class="mt_text_div" id="mt_text_div1">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow1" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active1" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">수강생 모집 여부</p>
                    </div>
                    <div>
                        <p class="mt_toggle_p">OFF</p><p class="mt_toggle_p" style="display:none;">ON </p>
                        <label class="mt_switch">
                        <input type="checkbox">
                        <span class="mt_slider mt_round"></span>
                        </label>
                    </div>
                </div>
                <div class="mt_text_div" id="mt_text_div2">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <a href="#">이번 달 0건</a>
                    </div>
                </div>
                <div class="mt_text_div" id="mt_text_div3">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">내가 찜한 선생님</p>
                    </div>
                    <a href="#">총 0건</a>
                </div>
            </div>
        </div>
        <div id="mt_right_div">
            <div style="margin:50px">
                <button class="btn1_2" onclick="location.href='memberModify'">회원 정보 수정</button>
            </div>
            <div style="margin:50px">
                <button class="btn1_2">교습 정보 수정</button>
            </div>

        </div>
    </div>
    <jsp:include page="template_footer.jsp"></jsp:include>
    </div>
</body>
</html>