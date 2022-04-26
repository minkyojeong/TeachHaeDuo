<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>회원가입 화면</title>

<!-- css 파일 분리 -->
<link href='<%=request.getContextPath()%>/css/reset.css'
	rel='stylesheet' style='text/css' />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	// 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수
	//$("#btn_register").click(checkValue);

	$("input").keydown(function(e) {
		if (e.keyCode == 13) {
			$('input').eq(idx + 1).focus();
		}
	});

	function checkValue() {
		if ($("#mId").val().length < 6) {
			alert("아이디는 6자 이상입니다.");
			return;
		}
		if ($("#mIdCheck").val() == 'N') {
			alert("아이디를 확인하세요.");
			return;
		}

		if (!document.getElementById('mId').value) {
			alert("아이디를 입력하세요.");
			return false;
		}
		if (!document.getElementById('pw').value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		if (document.getElementById('pw').value != document
				.getElementById('p_cf').value) { //비밀번호 확인 
			alert("비밀번호가 일치하지 않습니다. 확인해 주세요");
			document.getElementById('pw_cf').focus();
			return false;
		}

		if (!document.getElementById('mBirth').value) {
			alert("생년월일을 입력하세요.");
			return false;
		}

		if (document.getElementById('mAddress1').value == "") { //주소 확인 
			alert("주소를 입력해주세요");
			document.getElementById('postcode_button').focus();
			return false;
		}
	}

	// 취소 버튼 클릭시 로그인 화면으로 이동
	function goLoginForm() {
		location.href = "login.jsp";
	}

	function open_Postcode() { //다음 카카오 주소찾기 
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data);
				// 우편번호와 주소 정보를 해당 필드에 넣는다.  
				document.getElementById("mAddress1").value = data.roadAddress;

			}
		}).open();
	}

	function check_pw() { //비밀번호 확인 
		var p = document.getElementById('pw').value;
		var p_cf = document.getElementById('pw_cf').value;

		if (p != p_cf) {
		
			document.getElementById('pw_check_msg').innerHTML = "비밀번호가 다릅니다. 다시 확인해 주세요.";
			$("#pwd_info").attr('color', 'red');
		} else {
			document.getElementById('pw_check_msg').innerHTML = "";
		}
		if (p_cf == "") {
			document.getElementById('pw_check_msg').innerHTML = "";
		}
	}
</script>
<script>
	//체크 아이디 ajax
	$(function() {
		$('#mId').focusout(function() {

			let findStr = $('#mId').val(); // input_id에 입력되는 값

			$.ajax({
				type : 'post',
				async : false, //false가 기본값임 - 비동기
				url : 'findStr',
				dataType : 'text',
				data : {
					str : findStr,
					type : 'mId'
				},
				success : function(data, textStatus) {
					if (data == 'not-usable') {
						$("#checkId").html('사용할 수 없는 아이디입니다.');
						$("#checkId").attr('color', 'red');
						$("#mIdCheck").val('N');
					} else {
						$("#checkId").html('사용할 수 있는 아이디입니다.');
						$("#checkId").attr('color', 'green');
						$("#mIdCheck").val('Y');
					}
				},
				error : function(data, textStatus) {
					console.log('error');
				}
			})
		});
		
		$('#mNickName').focusout(function() {

			let findStr = $('#mNickName').val(); // input_id에 입력되는 값

			$.ajax({
				type : 'post',
				async : false, //false가 기본값임 - 비동기
				url : 'findStr', // 컨트롤 만들기
				dataType : 'text',
				data : {
					str : findStr,
					type : 'mNickName'
				},
				success : function(data, textStatus) {
					if (data == 'not-usable') {
						$("#checkNickName").html('사용할 수 없는 닉네임입니다.');
						$("#checkNickName").attr('color', 'red');
						$("#NickNameCheck").val('N');
					} else {
						$("#checkNickName").html('사용할 수 있는 닉네임입니다.');
						$("#checkNickName").attr('color', 'green');
						$("#NickNameCheck").val('Y');
					}
				},
				error : function(data, textStatus) {
					console.log('error');
				}
			}) //ajax
		});
		
		$('#mEmail').focusout(function() {

			let findStr = $('#mEmail').val(); // input_id에 입력되는 값

			$.ajax({
				type : 'post',
				async : false, //false가 기본값임 - 비동기
				url : 'findStr', // 컨트롤 만들기
				dataType : 'text',
				data : {
					str : findStr,
					type : 'mEmail'
				},
				success : function(data, textStatus) {
					if (data == 'not-usable') {
						$("#checkmEmail").html('사용할 수 없는 이메일입니다.');
						$("#checkmEmail").attr('color', 'red');
						$("#mEmailCheck").val('N');
					} else {
						$("#checkmEmail").html('사용할 수 있는 이메일입니다.');
						$("#checkmEmail").attr('color', 'green');
						$("#mEmailCheck").val('Y');
					}
				},
				error : function(data, textStatus) {
					console.log('error');
				}
			}) //ajax
		});
		
		$("#mId").keyup(function(event){
	        if (!(event.keyCode >=37 && event.keyCode<=40)) {
	            var inputVal = $(this).val();
	            $(this).val(inputVal.replace(/[^a-zA-Z0-9]/gi, ''));
	        }
	    });
		
		$("#pw").on("input", function(){
			// 패스워드 형식 확인
			var passwordRegEx = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[!@#$%^&*-]).{8,}$/;
			var passwordVal = $("#pw").val();
			if(!passwordRegEx.test(passwordVal)){
				console.log("패스워드 형식을 바르게 입력해주세요.");
				pwdChk = false;
				$("#pwd_info").html("패스워드 형식이 맞지 않습니다.");
				$("#pwd_info").attr('color', 'red');
		
			} else {
				pwdChk = true;
				$("#pwd_info").html("");
			}
		});
		
		$("#phone").on("input", function(){
			// 패스워드 형식 확인
			var phoneRegEx = /^[0][0-9]{2}-[0-9]{3,4}-[0-9]{4}$/;
			var phoneVal = $("#phone").val();
			if(!phoneRegEx.test(phoneVal)){
				console.log("phone 형식을 바르게 입력해주세요.");
				phoneChk = false;
			} else {
				console.log("phone 형식 OK");
				phoneChk = true;
			}
		});	
		
		
		
	});


</script>
</head>
<body>
	<!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
	<div id="wrap">
		<br> <br> <b><font size="6" color="gray">회원가입</font></b> <br>
		<br> <br>

		<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
		<!-- 값(파라미터) 전송은 POST 방식, 전송할 페이지는 join.jsp -->
		<form action="join" method="post" onsubmit="return checkValue();">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="mId" id="mId" maxlength="20"
						pattern="[a-zA-Z0-9]{6,20}" title="6자 이상의 영문 대소문자와 숫자로만 입력."
						required> <input type="hidden" id="mIdCheck" value=""
						placeholder="아이디(6자리 이상, 최대 15자)" /> <font id="checkId" size="2"></font>
				</tr>
				<tr>

					<td id="title">비밀번호</td>
					<td><input type="password" name="mPw" id="pw" 
						placeholder="비밀번호(8자리 이상)" required> <font id="pwd_info"size="2"></font></td>
				</tr>

				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" name="passwordcheck" id="pw_cf"
						onkeyup="check_pw()"  required placeholder="비밀번호 확인" >
						<font id="pw_check_msg" size="2"> </font></td>
				</tr>
				<tr>
					<td id="title">닉네임</td>
					<td><input type="text" name="mNickName" id="mNickName"
						maxlength="50" 
						placeholder="닉네임을 입력해 주세요." required> <font
						id="checkNickName" size="2"></font></td>
				</tr>
				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="mName" maxlength="50" required></td>

				</tr>
				<tr>
					<td id="title">생년월일</td>
					<td><input type="text" name="mBirth" maxlength="50"
						id="mBirth" required></td>
				</tr>
				<tr>
					<td id="title">휴대전화번호</td>
					<td><input type="text" name="mPhone" id="phone" required /></td>
				</tr>
				<tr>
					<td id="title">이메일주소</td>
					<td><input type="email" name="mEmail" id="mEmail" value=""
						size="20"
						pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}"
						required placeholder="예) id@domain.com" required> <font
						id="checkmEmail" size="2"></font> <!--patter으로 메일 유효성 검사 --> <input
						type="button" value="인증번호 보내기"></td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td><input type="text" size="50" name="mAddress1"
						id="mAddress1" readonly required /> <input type="button"
						value="주소검색" id="postcode_button" onclick="open_Postcode()">
						<br> <input type="text" size="50" name="mAddress2"
						id="mAddress2" placeholder="상세주소 입력해 주세요" required /></td>
				</tr>
				<tr>
					<td id="title">성별</td>
					<td><input type="radio" name="genderFm" value="M" checked>남
						<input type="radio" name="genderFm" value="F">여</td>
				</tr>
				<tr>
					<td id="title">신분</td>
					<td><input type="radio" name="roleSt" value="S" checked>학생
						<input type="radio" name="roleSt" value="T">선생님</td>
				</tr>

			</table>
			<br> <input type="submit" id="btn_register" value="회원가입" /> <input
				type="button" value="취소" onclick="goLoginForm()">
		</form>
	</div>

</body>
</html>