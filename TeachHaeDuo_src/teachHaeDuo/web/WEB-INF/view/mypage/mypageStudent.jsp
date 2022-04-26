 <link href="${pageContext.request.contextPath}/resources/css/mypageStudent.css" rel="stylesheet" type="text/css">
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>

<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
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

	<div id = "wrap">
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
                        	<!-- <p id="p"><u>잔여금액 확인</u></p> -->
                            <p id="p_won" style="line-height:30px"><u><span>0</span>원</u></p>
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
                    <p id="p_send_alarm"><u>이번 달 <span>0</span>건</u></p>
                    </div>
                </div>
                <div class="text_div" id="text_div3">
                    <div style="display:flex">
                        <img class="arrow" id="arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">내가 찜한 선생님</p>
                    </div>
                    <p id="p_like"><u>총 <span>0</span>명</u></p>
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
                <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">연필충전</p>
                <div class="pencilcharge_modal_close">X</div>
            </div>
            
        
            <div class="pencilcharge_modal_content">
                <form name="charge_frm">
                    <div class="pencilcharge_won">
                        <input type="text" name="won" id="won" value="0">
                        <p> 원</p>
                    </div>
                    <div class="btns">
                        <button type="button" class="btn3_1" id="btn1">-1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn2">+1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn3">+3만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn4">+5만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn5">+10만원</button>
                    </div>
                    <div class="pencilcharge_btn">
                        <button class="btn2_2" id="charge" type="button">충전하기</button>
                        <button class="btn2_2" id="reset" type="button" >정정</button>
                    </div>
                </form>
                
            </div>
        </div>
    </div>
    
    <div id="won_modal" class="won_modal_overlay">
        <div class="won_modal_window">
            <div class="won_modal_title">
               <img src="${pageContext.request.contextPath}/resources/icons/pencil.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">연필 사용 내역</p>
                <div class="won_modal_close">X</div>
            </div>
            <div class="won_modal_content">
                <table id="won_table">
                	<tr>
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/charge_updown.png" width="20" height="20">
                		</th>
                		<th>상세 내용</th>
                		<th>날짜</th>
                	</tr>
                	<tr>
	                	<td>
	                		<img src="${pageContext.request.contextPath}/resources/icons/charge_up.png" width="20" height="20">
	                	</td>
	                	<td></td>
	                	<td></td>
                	</tr>
                	<tr>
	                	<td>
	                		<img src="${pageContext.request.contextPath}/resources/icons/charge_down.png" width="20" height="20">
	                	</td>
	                	<td></td>
	                	<td></td>
                	</tr>
                </table>
            </div>
        </div>
    </div>
    
    <div id="send_alarm_modal" class="send_alarm_modal_overlay">
        <div class="send_alarm_modal_window">
            <div class="send_alarm_modal_title">
               <img src="${pageContext.request.contextPath}/resources/icons/alarm_icon.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">연락 요청 보낸 내역</p>
                <div class="send_alarm_modal_close">X</div>
            </div>
            <div class="send_alarm_modal_content">
                <table id="send_alarm_table">
                	<tr>
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20">
                		</th>
                		<th>연락 보낸 선생님</th>
                		<th>날짜</th>
                	</tr>
                	<tr>
	                	<td>
	                		<img src="${pageContext.request.contextPath}/resources/icons/send.png" width="20" height="20">
	                	</td>
	                	<td></td>
	                	<td></td>
                	</tr>                
                </table>
            </div>
        </div>
    </div>
    
    <div id="like_modal" class="like_modal_overlay">
        <div class="like_modal_window">
            <div class="like_modal_title">
               <img src="${pageContext.request.contextPath}/resources/icons/heart.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">내가 찜한 선생님</p>
                <div class="like_modal_close">X</div>
            </div>
            <div class="like_modal_content">
                <table id="like_table">
                	<tr>
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/like_teacher.png" width="20" height="20">
                		</th>
                		<th>찜한 선생님</th>
                		<th>날짜</th>
                	</tr>
                	<tr>
	                	<td>
	                		<img src="${pageContext.request.contextPath}/resources/icons/heart.png" width="20" height="20">
	                	</td>
	                	<td></td>
	                	<td></td>
                	</tr> 
                </table>
                
            </div>
        </div>
    </div>
    <jsp:include page="template_footer.jsp"></jsp:include>
    </div>
</body>
</html>