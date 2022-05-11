<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/css/mypageUpdate.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>mypage_modifymember</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

</head>
<body>
	<div id="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap content">
			<form name="frm_update">
				<div id="top_div">
					<p id="updateTitle">
						회원 정보 수정
					</p>
				</div>
				<div id="middle_div">
					<table id="memberUpdateTable">
						<tr>
							<td>아이디</td>
							<td colspan="2">
								<%
									MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
								%>
								<%=ssMV.getmId()%>
							</td>
						</tr>
						<tr>
							<td>이름</td>
							<td colspan="2">
								<%=ssMV.getmName()%>
							</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td colspan="2">
								<%=ssMV.getmNickname()%>
							</td>
						</tr>
						<tr>
							<td>비밀번호 변경</td>
							<td><input type="password" class="in_box" name="mPw" id="pw" tabindex="2" maxlength="20"
								placeholder="8자이상 영문대소문자, 숫자, 특수문자가 각각 1개이상">
								<font id="pwd_info" size="2"></font>
							</td>
							</tr>
						<tr>
							<td>비밀번호 확인</td>
							<td><input type="password" class="in_box" size="30" name="passwordcheck" id="pw_cf" tabindex="3" maxlength="60"
								onkeyup="check_pw()" placeholder="비밀번호 확인"> 
								<font id="pw_check_msg" size="2"> </font>
							</td>
							<input type="hidden" name="initPw" id="initPw" value="<%=ssMV.getmPw()%>">
						</tr>
						<tr>
							<td>주소변경</td>
							<td colspan="2">
							<input type="text" class="in_box" name="mAddress1" id="mAddress1"  tabindex="8" value="<%=ssMV.getmAddress()%>" readonly /> 
							<input type="button" class="btn2_3" value="주소검색" id="postcode_button" onclick="open_Postcode()"><br> 
							<input type="text"  class="in_box" name="mAddress2" id="mAddress2" placeholder="변경을 원하시면 주소 검색 후 입력해주세요" />
							</td>
						</tr>
						<tr>
							<td>휴대폰 번호 변경</td>
							<td colspan="2"><input name="mPhone" id="phone" type="text"  tabindex="6" class="in_box" maxlength="13"
								placeholder="예) 010-2222-3333"
								value="<%=ssMV.getmPhone()%>"><font
									id="phone_info" size="2"></font></td>
						</tr>
						<tr>
							<td id="title">이메일 변경</td>
								<td><input type="email" class="in_box" name="mEmail" id="mEmail" tabindex="7" value="<%=ssMV.getmEmail()%>"
									placeholder="예) id@domain.com" required> 
									<!-- <input type="button" id="bnt_Cert1" class="btn2_3" value="인증번호 전송"> -->
									<font id="checkmEmail_info" size="2"></font>
								</td>
						</tr>
						<!-- <tr id="email_Cert">
								<td id="title">인증번호</td>
								<td><input type="text" id="cert" class="in_box">
									<input type="hidden" id="certChk" class="in_box">
									<input type="hidden" id="certEmail" class="in_box">
									<input type="button" id="bnt_Cert2"  class="btn2_3" value="인증하기">
									<font id="cert_info" size="2"></font><br/>
									
								</td>
							</tr> -->
					</table>
				</div>
				<div id="low_div" style="margin-top:100px;">
					<input type="hidden" name="mId" id="mId" value="<%=ssMV.getmId()%>">
					<button class="btn2_3" type="button" id="update_btn">수정 완료</button>
					<button class="btn2_3" type="button" id="cancel">취소</button>
					<button class="btn2_3" type="button" id="member_delete_btn">회원탈퇴</button>
				</div>
			</form>
		</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
	<script>
		$(function() {
			var pwdChk = true;
			var emailChk = true;
			var phoneChk = true;
			var chkVal = false;
			
			
			
			console.log($("#mId").val());

			$("#cancel").click(function() {
				console.log("취소 버튼 클릭");
				location.href = "mypage";
			});
			$("#update_btn").click(function() {
				console.log("수정완료 클릭");
				checkValue();
				if (chkVal) {
					var frm = document.frm_update;
					frm.action = "memberUpdate.do";
					frm.method = "post";
					frm.submit();
				} 
			});
			

			$("#member_delete_btn").click(function() {
				var confm = confirm("정말로 회원 탈퇴를 진행하시겠습니까? 삭제된 정보는 복구 불가능합니다.");
				if (confm == true) {

					$.ajax({
						url : "memberDelete.ax",
						type : "post",
						date : {
						// mId: $("#mId").val()
						},
						success : function(result) {
							if (result == "로그인 먼저 해주세요.") {
								alert(result);
								location.href = "login";
							}
							alert(result);
							location.href = "";
						},
						error : function() {

						}
					});
				} else if (confm == false) {
					alert("회원탈퇴를 취소했습니다.");
				}
			});

			//패스워드 형식 확인	 -ok
			$("#pw").on("input",function() {
				
				var passwordRegEx = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*-]).{8,}$/;// 8자리이상  대소문자, 숫자, 특수문자가 각각 1개 이상 (패스워드 체크시 활용)
				var passwordVal = null;
				if ($("#pw").val().trim() == null || $("#pw").val().trim() == ""){
					passwordVal = $("#initPw").val();
				} else {
					passwordVal = $("#pw").val();
				}
				
				if (!passwordRegEx.test(passwordVal)) { //passwordVal값이 정규식에 맞는지 체크
					console.log("패스워드 형식을 바르게 입력해주세요.");
					pwdChk = true;
					$("#pwd_info").html("패스워드 형식이 맞지 않습니다.");
					$("#pwd_info").attr('color', 'red');

				} else {
					pwdChk = false;
					$("#pwd_info").html("");
				}
			});
			
			//이메일 형식 확인-ok 
			$("#mEmail").on("input",function() {
								//
				var EmailRegEx = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;// 이메일 정규식 
				var EmailVal = $("#mEmail").val();
				if (!EmailRegEx.test(EmailVal)) { // mEmail 이메일 정규식 맞는지 체크
					console.log("이메일 형식을 바르게 입력해주세요. console");
					emailChk = true;
					$("#checkmEmail_info").html("이메일 형식이 맞지 않습니다.");
					$("#checkmEmail_info").attr('color', 'red');

				} else {
					emailChk = false;
					$("#checkmEmail_info").html("");
				}
			});

			//중복체크 - 이메일 -ok
			$('#mEmail').focusout(function() {
				let findStr = $('#mEmail').val(); // input_id에 입력되는 값

				$.ajax({
					type : 'post',
					async : false, //false가 기본값임 - 비동기
					url : 'findStr',  //MemberFindStrAjaxController.java 주소 이동 
					dataType : 'text', //리턴값 형식  
					data : {
						str : findStr,
						type : 'mEmail'
					},
					success : function(data, textStatus) {

						if (data == 'not-usable') {
							$("#checkmEmail_info").html('사용할 수 없는 이메일입니다.');
							$("#checkmEmail_info").attr('color', 'red');
							emailChk = true;
						} else {
							$("#checkmEmail_info").html('사용할 수 있는 이메일입니다.');
							$("#checkmEmail_info").attr('color', 'green');
							emailChk = false;
						}
					},
					error : function(data, textStatus) {
						console.log('error');
					}
				}) //ajax
			});
			
			
			//핸드폰 형식확인 -ok
			$("#phone").on("input", function() {
				var phoneRegEx = /^[0][0-9]{2}-[0-9]{3,4}-[0-9]{4}$/;
				var phoneVal = $("#phone").val();

				if (!phoneRegEx.test(phoneVal)) {
					console.log("phone 형식을 바르게 입력해주세요.console");
					phoneChk = true;
					$("#phone_info").html("phone 형식을 바르게 입력해주세요.");
					$("#phone_info").attr('color', 'red');
				} else {
					$("#phone_info").html("");
					console.log("phone 형식 OK");
					phoneChk = false;
				}
			});
			
			
			

			//필수 입력정보 입력되었는지 확인하는 함수
			function checkValue() {
				if (pwdChk) {
					alert("비밀번호를 확인하세요.");
					return;
				}
				if (phoneChk) {
					alert("핸드폰번호을 확인하세요.");
					return;
				}
				if (emailChk) {
					alert("이메일을 확인하세요.");
					return;
				}
				//비밀번호== 비밀번호확인 일치 한지 확인 
				if (document.getElementById('pw').value != document
						.getElementById('pw_cf').value) {
					alert("비밀번호가 일치하지 않습니다. 확인해 주세요");
					document.getElementById('pw_cf').focus();
					return;
				}
				chkVal = true;
			}
			
		});
		
		function open_Postcode() { //다음 카카오 주소찾기 
			new daum.Postcode({
				oncomplete : function(data) {
					console.log(data);
					// 우편번호와 주소 정보를 해당 필드에 넣는다.  
					document.getElementById("mAddress1").value = data.roadAddress;

				}
			}).open();
		}
		
		function check_pw() { //비밀번호 확인 - ok
			var p = document.getElementById('pw').value;
			var p_cf = document.getElementById('pw_cf').value;

			if (p != p_cf) {
				document.getElementById('pw_check_msg').innerHTML = "비밀번호가 다릅니다. 다시 확인해 주세요.";
				$("#pw_check_msg").attr('color', 'red');
			} else {
				document.getElementById('pw_check_msg').innerHTML = "";
			}
			if (p_cf == "") {
				document.getElementById('pw_check_msg').innerHTML = "";
			}
		}
	</script>
</body>
</html>