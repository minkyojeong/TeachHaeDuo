<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
 <link href="${pageContext.request.contextPath}/resources/css/mypageStudent.css" rel="stylesheet" type="text/css">
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_Student</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mypageStudent.js"></script>
</head>
<body>

	<div id = "main_wrap">
	<jsp:include page="../template_header.jsp"></jsp:include>
    <div class="wrap content" id="content">
        <div id="left_div">
            <div id="top_div">
                <div id="profile_div" style="width:50%">
                    <div id="profile" style="width:40%">
                        <img src="${pageContext.request.contextPath}/resources/icons/profile.png" width="150" height="150">
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
                            <p id="p_won" style="line-height:30px; font-weight:bold"><u><%= request.getAttribute("balance") %>원</u></p>
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
                        <c:choose>
							<c:when test="${ssMV.mAlarmYn == 'Y'}"><p class="text_div_p">알림 받을거에요</p></c:when>
							<c:when test="${ssMV.mAlarmYn == 'N'}"><p class="text_div_p">알림 안 받아요</p></c:when>
						</c:choose>
                    </div>
                    <div>
                    	<% if(ssMV.getmAlarmYn().equals("Y")){ %>
                    	<input type="hidden" id="alarm_yn" value="Y">
                    	<%} else { %>
                    	<input type="hidden" id="alarm_yn" value="N">
                    	<%} %>
                        <p class="toggle_p" id="off">OFF</p>
                        <label class="switch">
                        <input type="checkbox" id="checkbox">
                        <span class="slider round"></span>
                        </label>
                        <p class="toggle_p" id="on">ON</p>
                    </div>
                </div>
                <div class="text_div" id="text_div2">
                    <div style="display:flex">
                        <img class="arrow" id="arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <p id="p_send_alarm" style="font-weight:bold"><u>최근 30일 <%= request.getAttribute("numberOfSendAlarm") %>건</u></p>
                    </div>
                </div>
                <div class="text_div" id="text_div3">
                    <div style="display:flex">
                        <img class="arrow" id="arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="arrow_active" id="arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="text_div_p">내가 찜한 선생님</p>
                    </div>
                    <p id="p_like"  style="font-weight:bold"><u>총 <%= request.getAttribute("numberOfLike") %>명</u></p>
                </div>
            </div>
        </div>
        <div id="right_div">
            <div style="margin:50px">
                <button class="btn1_4" onclick="location.href='memberUpdateLogin'">회원 정보 수정</button>
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
                        <p style="line-height:20px"> 원</p>
                    </div>
                    <div class="btns">
                        <button type="button" class="btn3_1" id="btn1">-1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn2">+1만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn3">+3만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn4">+5만원</button>&nbsp;&nbsp;
                        <button type="button" class="btn3_1" id="btn5">+10만원</button>
                    </div>
                    <div class="pencilcharge_btn">
                        <button class="btn2_3" id="charge" type="button">충전하기</button>
                        <button class="btn2_3" id="reset" type="button" >정정</button>
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
                	<tr id="won_table_tr1">
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/charge_updown.png" width="20" height="20">
                		</th>
                		<th>연필</th>
                		<th>상세 내용</th>
                		<th>날짜</th>
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
                	<tr id="send_alarm_table_tr1">
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20">
                		</th>
                		<th>연락 보낸 선생님</th>
                		<th>날짜</th>
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
                	<tr id="like_table_tr1">
                		<th>
                			<img src="${pageContext.request.contextPath}/resources/icons/like_teacher.png" width="20" height="20">
                		</th>
                		<th>찜한 선생님</th>
                	</tr>
                </table>
                
            </div>
        </div>
    </div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
    </div>

<script>
/* 연필 사용 내역 */
$("#p_won").on("click", function() {
	$("#won_modal").show();
	
	$.ajax({
	url: "listPencil.ax",
	type: "post",
	dataType: "json",
	success: function(result) {
		console.log(result);
		console.log(result[0]);

		console.log(result.alarm_receiveid);
		console.log(result.length);
		var html = "";
		for (var i = 0; i < result.length; i++) {
			/* <table id="won_table">
            	<tr id="won_table_tr1">
            		<th>
            			<img src="${pageContext.request.contextPath}/resources/icons/charge_updown.png" width="20" height="20">
            		</th>
            		<th>연필</th>
            		<th>상세 내용</th>
            		<th>날짜</th>
            	</tr>
       		 </table> */
			var vo = result[i];
			html += '<tr>';
			if(vo.cpCash < 0){
				html += '<td><img src="${pageContext.request.contextPath}/resources/icons/charge_down.png" width="20" height="20"></td>';
			} else {
				html += '<td><img src="${pageContext.request.contextPath}/resources/icons/charge_up.png" width="20" height="20"></td>';
			}
			html += '<td>' + vo.cpCash + '</td>';
			html += '<td>' + vo.cpContent + '</td>';
			html += '<td>' + vo.cpDate + '</td>';
			html += '</tr>';

			console.log("html:" + html);

		}
		$("#won_table_tr1").nextAll().remove();
		$("#won_table").append(html);
	},
	error: function() {

	}
});
});
// 연락 요청 보낸 리스트 출력
$("#p_send_alarm").on("click", function() {
	$("#send_alarm_modal").show();
	
	$.ajax({
		url: "sendAlarmList.ax",
		type:"post",
		dataType:"json",
		success: function(result){
			var html = "";
			for(var i = 0; i < result.length; i++){
				var vo = result[i];
				html += '<tr>';
				html += '<td><img src="${pageContext.request.contextPath}/resources/icons/send.png" width="20" height="20"></td>';
				html += '<td><a href="teacherInfo?tNo='+vo.t_no+'">'+ vo.alarm_receiveid + '</td>';
				html += '<td>' + vo.alarm_date + '</td>';
				html += '</tr>';
			}
			$("#send_alarm_table_tr1").nextAll().remove();
			$("#send_alarm_table").append(html);
		},
		error: function(){
		
		}
	
	});
});

// 찜한 선생님 리스트
$("#p_like").on("click", function() {
	$("#like_modal").show();
	
	$.ajax({
		url: "likeList.ax",
		type:"post",
		dataType:"json",
		success: function(result){
			var html = "";
			for(var i = 0; i < result.length; i++){
				var vo = result[i];
				html += "<tr>";
				html += '<td><img src="${pageContext.request.contextPath}/resources/icons/heart.png" width="20" height="20"></td>';
				html += '<td><a href="teacherInfo?tNo='+vo.t_no+'">'+ vo.mNickname + '</td>';
				html += '</tr>';
				console.log(vo.t_no);
			}
			$("#like_table_tr1").nextAll().remove();
			$("#like_table").append(html);
		},
		error: function(){
		
		}
	
	});
});
	
var msgAlarmVal = '${msgAlarm}';
if(msgAlarmVal != "" && msgAlarmVal != null){
	alert('${msgAlarm}');
	location.href="mypage";
}
	
var msgChargeVal = '${msgCharge}';
if(msgChargeVal != "" && msgChargeVal != null){
	alert('${msgCharge}');
	location.href="mypage";
}
var msgUpdateVal = '${msgUpdate}';
if(msgUpdateVal != "" && msgUpdateVal != null){
	alert('${msgUpdate}');
	location.href="mypage";
}
</script>
<% request.removeAttribute("msgAlarm"); %>
<% request.getSession().removeAttribute("msgCharge"); %>
<% request.getSession().removeAttribute("msgUpdate"); %>
</body>
</html>