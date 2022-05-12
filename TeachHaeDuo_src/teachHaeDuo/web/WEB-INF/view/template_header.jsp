<%@page import="java.util.ArrayList"%>
<%@page import="kh.semi.thduo.alarm.model.vo.AlarmVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<div class="wrap header">
	<header>
		<div class="logo">
			<a href="${pageContext.request.contextPath}/"> 
				<img src="${pageContext.request.contextPath}/resources/icons/logo.jpg">
			</a>
		</div>
		<nav class="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/teacherSearch">선생님찾기</a><span>&nbsp;&nbsp;</span></li>
				<li><a href="#">질문하기</a><span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span></li>
				<li>
					<a style="cursor: pointer">고객센터</a><span>&nbsp;&nbsp;</span>
					<ul class="sub_menu">
						<li><a href="#">공지사항</a></li>
						<li><a href="#">1대1 문의</a></li>
						<li><a href="#">자주묻는 질문</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/guide">이용방법</a><span>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</span></li>
				<c:choose>
					<c:when test="${empty ssMV}">
						<li><a href="${pageContext.request.contextPath}/login">로그인</a><span>&nbsp;&nbsp;</span></li>
						<li><a href="${pageContext.request.contextPath}/join">회원가입</a></li>
					</c:when>
					<c:when test="${not empty ssMV}">
						<li><p id="p_alarm">알람</p><span>&nbsp;&nbsp;</span></li>
						<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a><span>&nbsp;&nbsp;</span></li>
						<!-- 관리자 로그인 시 처리할 부분 -->
						<%-- 						<c:if test="${ssMV.mId == 'admin'}">
							<li><a href="logout">관리자페이지&nbsp;&nbsp;</a></li>
						</c:if> --%>
						<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
					</c:when>
				</c:choose>
			</ul>
		</nav>
	</header>
	<div class="clear line">
		<hr>
	</div>
</div>
<div id="alarm_modal" class="alarm_modal_overlay">
	<div class="alarm_modal_window">
		<div class="alarm_modal_title">
			<img
				src="${pageContext.request.contextPath}/resources/icons/alarm_icon.png"
				width="30" height="30" style="margin-right: 10px">
			<p style="line-height: 30px">알람</p>
			<div class="alarm_modal_close">X</div>
		</div>
		<br>
		<div style="display: flex">
			<div class="header_btn_div">
				<input type="radio" id="all_btn" name="header_btn" value="1" checked>
				<label for="all_btn" id="all_label" class="header_btn">전체 알람</label>
				<input type="radio" id="receive_btn" name="header_btn" value="2">
				<label for="receive_btn" id="receive_label" class="header_btn">받은
					알람</label> <input type="radio" id="send_btn" name="header_btn" value="3">
				<label for="send_btn" id="send_label" class="header_btn">보낸
					알람</label>
			</div>
			
		</div>
		<div id="notice">
			<div style="float: right;">
				<p>*최근 30일 내역만 보여집니다.</p>
			</div>
		</div>
		<div id="div_reply">
				<button class="btn2_3" type="button" id="btn_reply">답장하기</button>
			</div>
		<div class="alarm_modal_content" style="clear: both;"></div>

	</div>
</div>
<div id="send_modal" class="header_modal header_message">
	<div class="header_message_content">
		<p class="header_modal_title">쪽지 보내기</p>
		<%
			ArrayList<AlarmVo> idList = (ArrayList<AlarmVo>) request.getSession().getAttribute("nicknameList");
		%>
		<select id="sel_send_message" onchange="selectBoxChange(this.value);">
			<option value="">받는 사람을 선택해주세요</option>
			<%
				if (idList == null) {
			%>
			<option value="">쪽지를 보낸 사람이 없습니다.</option>
			<%
				} else {
			for (int i = 0; i < idList.size(); i++) {
				AlarmVo id = idList.get(i);
			%>
			<option value="<%=idList.get(i).getAlarm_sendid()%>"><%=idList.get(i).getAlarm_sendid()%></option>
			<%
				}
			%>
			<%
				}
			%>
		</select> <input type="hidden" name="alarm_receiveid" id="header_alarm_receiveid"
			value="">
		<p class="header_message_notice">* 쪽지를 보낼 시, 연필이 500원 차감됩니다. *</p>
		<div class="header_message_input">

			<textarea cols="35" rows="10" name="alarm_content" id="header_alarm_content"
				maxlength="200" placeholder="쪽지 내용을 입력해주세요.(최대 한글 200자)"></textarea>
		</div>
		<div class="header_message_send">
			<button type="button" id="header_btn_message_cancel">취소</button>
			<button type="button" id="header_btn_message_send">보내기</button>
		</div>
	</div>
</div>

<script>
//고객센터메뉴에 마우스 호버 시, 드롭다운 메뉴 나옴
$(".menu > ul li:eq(2)").hover(function() {
	$(this).children("ul").stop().slideToggle(500);
});
// 알람 창 클릭
$("#p_alarm").on("click", function() {
	console.log("알람클릭");
	$("#alarm_modal").show();
	
	$.ajax({
		url: "allAlarmList.ax",
		type:"post",
		dataType:"json",
		success: function(result){
			 
          $(".alarm_modal_content").find("*").remove();
			var html = "";
			html += '<table id="header_allalarm_table">'
			html += '<tr id="header_allalarm_table_tr1">';
			html += '<th><img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20"></th>';
			html += '<th>알림 내용</th>';
			html += '<th>보낸 사람</th>';
			html += '<th>받는 사람</th>';
			html += '<th>날짜</th>';
			html += '</tr>';
			for(var i = 0; i < result.length; i++){
				var vo = result[i];
				html += '<tr>';
				html += '<td><img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20"></td>';
				html += '<td>'+ vo.alarm_content + '</td>';
				html += '<td>'+ vo.alarm_sendid + '</td>';
				html += '<td>'+ vo.alarm_receiveid + '</td>';
				html += '<td>' + vo.alarm_date + '</td>';
				html += '</tr>';
			}
			$("#header_alarm_table_tr1").nextAll().remove();
			$(".alarm_modal_content").append(html);
		},
		error: function(){
		
		}
	
	}); 
	
		
	
	
	
});

$(".alarm_modal_close").click(function() {
	$("#alarm_modal").hide();
});

alarm_modal.addEventListener("click", e => {
	const evTarget = e.target
	if (evTarget.classList.contains("alarm_modal_overlay")) {
		$("#alarm_modal").hide();
	}
});

$("input[name=header_btn]").click(function(){
	if($("input[name=header_btn]:checked").val() == "1"){
		console.log("전체 알람");
		

		 $.ajax({
			url: "allAlarmList.ax",
			type:"post",
			dataType:"json",
			success: function(result){
				 
              $(".alarm_modal_content").find("*").remove();
				var html = "";
				html += '<table id="header_allalarm_table">'
				html += '<tr id="header_allalarm_table_tr1">';
				html += '<th><img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20"></th>';
				html += '<th>알림 내용</th>';
				html += '<th>보낸 사람</th>';
				html += '<th>받는 사람</th>';
				html += '<th>날짜</th>';
				html += '</tr>';
				for(var i = 0; i < result.length; i++){
					var vo = result[i];
					html += '<tr>';
					html += '<td><img src="${pageContext.request.contextPath}/resources/icons/message.png" width="20" height="20"></td>';
					html += '<td>'+ vo.alarm_content + '</td>';
					html += '<td>'+ vo.alarm_sendid + '</td>';
					html += '<td>'+ vo.alarm_receiveid  + '</td>';
					html += '<td>' + vo.alarm_date + '</td>';
					html += '</tr>';
				}
				$("#header_alarm_table_tr1").nextAll().remove();
				$(".alarm_modal_content").append(html);
			},
			error: function(){
			
			}
		
		}); 
	} else if ($("input[name=header_btn]:checked").val() == "2"){
		console.log("받은 알람");
		
		 $.ajax({
			url: "receiveAlarmList.ax",
			type:"post",
			dataType:"json",
			success: function(result){
				
               $(".alarm_modal_content").find("*").remove();
				var html = "";
				html += '<table id="header_alarm_table">'
				html += '<tr id="header_alarm_table_tr1">';
				html += '<th><img src="${pageContext.request.contextPath}/resources/icons/receive.png" width="20" height="20"></th>';
				html += '<th>알림 내용</th>';
				html += '<th>보낸 사람</th>';
				html += '<th>날짜</th>';
				html += '</tr>';
				for(var i = 0; i < result.length; i++){
					var vo = result[i];
					html += '<tr>';
					html += '<td><img src="${pageContext.request.contextPath}/resources/icons/receive.png" width="20" height="20"></td>';
					html += '<td>'+ vo.alarm_content + '</td>';
					html += '<td>'+ vo.alarm_sendid + '</td>';
					html += '<td>' + vo.alarm_date + '</td>';
					html += '</tr>';
				}
				$("#header_alarm_table_tr1").nextAll().remove();
				$(".alarm_modal_content").append(html);
			},
			error: function(){
			
			}
		
		}); 
		
	} else if ($("input[name=header_btn]:checked").val() == "3"){
		console.log("보낸 알람");
		
		 $.ajax({
			url: "sendAlarmList.ax",
			type:"post",
			dataType:"json",
			success: function(result){
                $(".alarm_modal_content").find("*").remove();
				var html = "";
				html += '<table id="header_alarm_table">'
				html += '<tr id="header_alarm_table_tr1">';
				html += '<th><img src="${pageContext.request.contextPath}/resources/icons/send.png" width="20" height="20"></th>';
				html += '<th>알림 내용</th>';
				html += '<th>받는 사람</th>';
				html += '<th>날짜</th>';
				html += '</tr>';
				for(var i = 0; i < result.length; i++){
					var vo = result[i];
					html += '<tr>';
					html += '<td><img src="${pageContext.request.contextPath}/resources/icons/send.png" width="20" height="20"></td>';
					html += '<td>'+ vo.alarm_content + '</td>';
					html += '<td>'+ vo.alarm_receiveid + '</td>';
					html += '<td>' + vo.alarm_date + '</td>';
					html += '</tr>';
				}
				
				$("#header_alarm_table_tr1").nextAll().remove();
				$(".alarm_modal_content").append(html);
			},
			error: function(){
			
			}
		
		}); 
	}
});
/* 알람 답장 보내기 */

//답장하기 버튼 클릭 시 모달창 띄우기
$("#btn_reply").on('click', function() {
	console.log("답장하기 클릭");
	$(".header_message").show();
	
});
//취소 버튼 클릭 시 모달창 닫기
$("#header_btn_message_cancel").on('click', function() {
	$(".header_message").hide();
});
//모달창 띄우고 내용 있는 곳 부분 제외한 곳 누르면 모달창 닫기
$(".header_message").on('click', function() {
	if (event.target == $(".header_message").get(0)) {
		$(".header_message").hide();
	}
});
//쪽지 보내기 버튼 클릭 시 처리 내용
$("#header_btn_message_send").on('click', function() {
	if ($("#header_alarm_content").val() == "") {
		alert("쪽지 내용을 입력해주세요. 내용을 입력해야 쪽지를 보낼 수 있습니다.");
		$("#header_alarm_content").focus();
		return;
	}
	if($("#header_alarm_receiveid").val() == ""){
		alert("받는 사람을 선택해주세요.");
		return;
	} 
	$.ajax({
		url: "sendAlarm.ax",
		type: "post",
		data: {
			alarm_receiveid: $("#header_alarm_receiveid").val(),
			alarm_content: $("#header_alarm_content").val()
		},
		success: function(result) {
			console.log(result);
			if (result == 1) {
				alert("쪽지를 보냈습니다. 답장을 기다려주세요.");
				$("#header_alarm_content").val("");
				$(".header_message").hide();
			} else if (result == -1) {
				alert("쪽지가 보내지지 않았습니다. 다시 시도해주세요.");
				$("#header_alarm_content").focus();
			} else if (result == 0) {
				alert("로그인을 한 후에 쪽지 보내기가 가능합니다. 로그인 페이지로 이동합니다.");
				location.href = "login";
			} else if (result == 2) {
				alert("잔액이 부족합니다. 연필 충전 후, 쪽지 보내기를 사용해주세요.");
				//location.href = "pencilCharge";
			}
		},
		error: function(request, status, error) {
			console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
});


var selectBoxChange = function(value){
	console.log("값변경돼");
	$("#header_alarm_receiveid").val(value);
	console.log($("#header_alarm_receiveid").val());
}
$.ajax({
	url: "receiveIdList.ax",
	type: "post",
	dataType:"json",
	success: function(result){
	},
	error: function(){
		
	}
});

</script>
