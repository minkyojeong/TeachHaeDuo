<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="wrap header">
	<header>
		<div class="logo">
			<a href="./"> 
				<img src="${pageContext.request.contextPath}/resources/icons/logo.jpg">
			</a>
		</div>
		<nav class="menu">
			<ul>
				<li><a href="${pageContext.request.contextPath}/teacherSearch">선생님찾기&nbsp;&nbsp;</a></li>
				<li><a>질문하기&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<li><a>고객센터&nbsp;&nbsp;</a></li>
				<li><a>이용방법&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<c:choose>
					<c:when test="${empty ssMV}">
						<li><a href="login">로그인&nbsp;&nbsp;</a></li>
						<li><a href="join">회원가입</a></li>
					</c:when>
					<c:when test="${not empty ssMV}">
						<li><p id="p_alarm">알람&nbsp;&nbsp;</p></li>
						<li><a href="logout">로그아웃&nbsp;&nbsp;</a></li>
						<!-- 관리자 로그인 시 처리할 부분 -->
<%-- 						<c:if test="${ssMV.mId == 'admin'}">
							<li><a href="logout">관리자페이지&nbsp;&nbsp;</a></li>
						</c:if> --%>
						<li><a href="mypage">마이페이지</a></li>
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
               <img src="${pageContext.request.contextPath}/resources/icons/alarm_icon.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">알람</p>
                <div class="alarm_modal_close">X</div>
            </div>
            <br>
            <div class="header_btn_div">
	            <input type="radio" id="all_btn" name="header_btn" value="1" checked>
	            <label for="all_btn" id="all_label" class="header_btn">전체 알람</label>
	            <input type="radio" id="receive_btn" name="header_btn" value="2">
	            <label for="receive_btn" id="receive_label" class="header_btn">받은 알람</label>
	            <input type="radio" id="send_btn" name="header_btn" value="3">
	            <label for="send_btn" id="send_label" class="header_btn">보낸 알람</label>
            </div>
            <div class="alarm_modal_content">
                
            </div>
        </div>
    </div>
  
<script>
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


</script>