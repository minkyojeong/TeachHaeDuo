<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/join.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<title>회원가입 화면</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>


//중복체크 아이디 ajax -ok
$(function() {
	
	var chkVal = false;
	
	
	$('#mId').focusout(function() {
		
		let findStr = $('#mId').val(); // input_id에 입력되는 값
		
		
		if ($('#mId').val().length < 6){
			$("#checkId").html('사용할 수 없는 아이디입니다.');
			$("#checkId").attr('color', 'red');
			$("#mIdCheck").val('N');
		}else if($('#mId').val().length > 5){
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
		}
	});
	//중복체크 닉네임 ajax -ok
	$('#mNickName').focusout(function() {
		
		
		
		let findStr = $('#mNickName').val(); // input_id에 입력되는 값
		
		
		if($('#mNickName').val().length < 2){
			$("#checkNickName").html('닉네임은 2자리 이상입니다.');
			$("#checkNickName").attr('color', 'red');
			$("#NickNameCheck").val('N');
			
		}else if ($('#mNickName').val().length > 1){
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
			
		}
		
	});
	//중복체크 - 이메일 -x 
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
					$("#checkmEmail_info").html('사용할 수 없는 이메일입니다.');
					$("#checkmEmail_info").attr('color', 'red');
					$("#mEmailCheck").val('N');
				} else {
					$("#checkmEmail_info").html('사용할 수 있는 이메일입니다.');
					$("#checkmEmail_info").attr('color', 'green');
					$("#mEmailCheck").val('Y');
				}
			},
			error : function(data, textStatus) {
				console.log('error');
			}
		}) //ajax
	});
			
	//신분 선생님 클릭시 증명서 첨부 활성화  - ok
	$("#fileupload").hide();
	 
	$("#radioT").click(function(){
	     $("#fileupload").show();
	});
	
	$("#radioS").click(function(){
	    $("#fileupload").hide();
	});
	
	
	
	
	$('#btn_register').on("click", function(){
		checkValue();
		if(chkVal){
			var frm = document.frm_register;
			frm.action = "join";
			frm.method = 'post';
			frm.submit();
		}
		
	});
	
	//필수 입력정보 입력되었는지 확인하는 함수
	function checkValue() {
		
		//아이디 6자 이상 
		if ($("#mId").val().length < 6) {
			alert("아이디는 6자 이상입니다.");
			return ;
		}
		//아이디 중복(N)이면 다시 입력 
		if ($("#mIdCheck").val() == 'N') {
			alert("아이디를 확인하세요.");
			return;
		}
		if ($("#pw").val().length == 0) {
			alert("비밀번호를 입력하세요.");
			return ;
		}
		if ($("#pw").val().length < 8) {
			alert("비밀번호는 8자 이상입니다.");
			return ;
		}
	    
	    //비밀번호== 비밀번호확인 일치 한지 확인 
		if (document.getElementById('pw').value != document
				.getElementById('pw_cf').value) {  
			alert("비밀번호가 일치하지 않습니다. 확인해 주세요");
			document.getElementById('pw_cf').focus();
			return;
		}
	    //생년월일 미입력시 확인 
		if ($("#mBirth").val().length < 6) {
			alert("생년월일을 제대로 입력하세요.");
			return;
		}
	    //주소 미입력시 확인 
		if (document.getElementById('mAddress1').value == "") { 
			alert("주소를 입력해주세요");
			document.getElementById('postcode_button').focus();
			return;
		}
	    //성별 라디오 미 선택시 확인 
		if($("input[name=genderFm]:checked").length == 0){
			alert("선택을 바르게 입력해주세요.");
			return;
		}
	    //신분구분 미 선택시 확인 
		if($("input[name=roleSt]:checked").length == 0){
			alert("선택을 바르게 입력해주세요.");
			return;
		}
		chkVal = true;
	}
});  // onload 


</script>
<script>
var idChk = false;
var pwdChk = false;
var NickNameChk = false;
var EmailChk = false;
var phoneChk = false;
var BirthChk = false;
// 함수실행 on 
$(function(){
	// 아이디 형식 확인  -ok
	$("#mId").on("input", function(){
		var idRegEx = /^[0-9a-zA-Z]{6,15}$/;
		var idVal = $("#mId").val();
		if(!idRegEx.test(idVal)){
			console.log("아이디 형식을 바르게 입력해주세요.");
			idChk = false;
			$("#checkId").html("아이디 형식이 맞지 않습니다.");
			$("#checkId").attr('color', 'red');
		} else {
			idChk = true;
			$("#checkId").html("");
		}
	});

	//패스워드 형식 확인	 -ok
	$("#pw").on("input", function(){
	//최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각각 1개 이상 (패스워드 체크시 활용)
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
	//닉네임 형식 확인 -ok > 엔터는 안넘어가지만 커서 이동되면 가능으로 바뀜 
	$("#mNickName").on("input", function(){
	//한글, 영문, 특수문자 (- _ .) 포함한 2 ~ 12글자 닉네임
	var NickNameRegEx = /^[a-zA-Zㄱ-힣0-9-_.]{2,12}$/;
	var NickNameVal = $("#mNickName").val();
		if(!NickNameRegEx.test(NickNameVal)){
			console.log("닉네임 형식을 바르게 입력해주세요. console");
			NickNameChk = false;
			$("#checkNickName").html("닉네임 형식이 맞지 않습니다.");
			$("#checkNickName").attr('color', 'red');

		} else {
			NickNameChk = true;
			$("#checkNickName").html("");
		}
	});	
	//이메일 형식 확인-ok 
	$("#mEmail").on("input", function(){
	//
	var EmailRegEx = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;
	var EmailVal = $("#mEmail").val();
		if(!EmailRegEx.test(EmailVal)){
			console.log("이메일 형식을 바르게 입력해주세요. console");
			EmailChk = false;
			$("#checkmEmail_info").html("이메일 형식이 맞지 않습니다.");
			$("#checkmEmail_info").attr('color', 'red');

		} else {
			EmailChk = true;
			$("#checkmEmail_info").html("");
		}
	});		

	//핸드폰 형식확인 -ok
	$("#phone").on("input", function(){
	var phoneRegEx = /^[0][0-9]{2}-[0-9]{3,4}-[0-9]{4}$/;
	var phoneVal = $("#phone").val();

		if(!phoneRegEx.test(phoneVal)){
			console.log("phone 형식을 바르게 입력해주세요.console");
			phoneChk = false;
			$("#phone_info").html("phone 형식을 바르게 입력해주세요.");
			$("#phone_info").attr('color', 'red');
		} else {
			$("#phone_info").html("");
			console.log("phone 형식 OK");
			phoneChk = true;
		}
	});	
	//생년월일 형식확인	 - ok  
	$("#mBirth").on("input", function(){
	//
	var BirthRegEx = /^[0-9]{6}$/;
	var BirthVal = $("#mBirth").val();
		if(!BirthRegEx.test(BirthVal)){
			console.log("생년월일 형식을 바르게 입력해주세요.");
			BirthChk = false;
			$("#mBirth_info").html("생년월일 형식이 맞지 않습니다.");
			$("#mBirth_info").attr('color', 'red');

		} else {
			BirthChk = true;
			$("#mBirth_info").html("");
			console.log("생년월일 형식 OK");
		}

	});	
	
	
});

</script>
<script type="text/javascript">




//취소 버튼 클릭시 메인 화면으로 이동 -ok
function goLoginForm() {
	location.href = "/";
}

function open_Postcode() { //다음 카카오 주소찾기 -ok
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

</head>
<body>
<div class="main_wrap">
        <jsp:include page="../template_header.jsp"></jsp:include>
          <div class="wrap content">
            <section>
                <div id="join">
                    <form name="frm_register"  enctype="multipart/form-data">
                         <div>
							<h2 id="join_title"> 회원가입 </h2>
					    </div>
                        <table id="memberTable">
                                      
                                <tr>
                                    <td id="title">아이디</td>
                                    <td><input type="text" class="in_box"  name="mId" id="mId"  tabindex="1"
                                         placeholder="아이디(6자리 이상, 최대 15자)" title="6자 이상의 영문 대소문자와 숫자로만 입력."  required> 
                                        <input type="hidden" id="mIdCheck"  /> 
                                        <font id="checkId" size="2"></font>
                                </tr>
                                <tr>
                                    <td id="title">비밀번호</td>
                                    <td><input type="password" class="in_box" name="mPw" id="pw"  tabindex="2" maxlength="20" placeholder="8자이상 영문대소문자, 숫자, 특수문자가 각각 1개이상" required> 
                                        <font id="pwd_info"size="2"></font></td>
                                </tr>
                                <tr>
                                    <td id="title">비밀번호 확인</td>
                                    <td><input type="password" class="in_box" size="30" name="passwordcheck" id="pw_cf" tabindex="3" maxlength="60" onkeyup="check_pw()" placeholder="비밀번호 확인"  required>
                                        <font id="pw_check_msg" size="2"> </font></td>
                                </tr>
                                <tr>
                                    <td id="title">닉네임</td>
                                    <td><input type="text" class="in_box"  name="mNickName" id="mNickName" tabindex="4" maxlength="60" 
                                     placeholder="한글, 영문, 특수문자를 포함한 2 ~ 12글자" required> 
                                        <font id="checkNickName" size="2"></font></td>
                                </tr>
                                <tr>
                                    <td id="title">이름</td>
                                    <td><input type="text" class="in_box" name="mName"  tabindex="5"  maxlength="60" required></td>
                
                                </tr>
                                <tr>
                                    <td id="title">생년월일</td>
                                    <td><input type="text" class="in_box" name="mBirth" id="mBirth"   tabindex="5"  maxlength="8" id="mBirth"  placeholder="예) 210210" required>
                                        <font id="mBirth_info" size="2"></font></td>
                                </tr>
                                <tr>
                                    <td id="title">휴대전화번호</td>
                                    <td><input type="text" class="in_box" name="mPhone" id="phone"  tabindex="6"  maxlength="13"  placeholder="예) 010-2222-3333" required />
                                        <font id="phone_info" size="2"></font></td>
                                </tr>
                                <tr>
                                    <td id="title">이메일주소</td>
                                    <td><input type="email" class="in_box" name="mEmail" id="mEmail" tabindex="7" required placeholder="예) id@domain.com" required> 
                                          
                                          <input type="button" value="인증번호 보내기"><font id="checkmEmail_info" size="2"></font> </td>
                                </tr>
                                <tr>
                                    <td id="title">주소</td>
                                    <td><input type="text" class="in_box" name="mAddress1" id="mAddress1"  tabindex="8" readonly required /> 
                                        <input type="button"  value="주소검색" id="postcode_button" onclick="open_Postcode()">
                                        <br><input type="text" class="in_box" name="mAddress2" id="mAddress2" placeholder="상세주소 입력해 주세요" required /></td>
                                </tr>
                                <tr>
                                    <td id="title">성별</td>
                                    <td><input type="radio" name="genderFm" value="M"  checked>남
                                        <input type="radio" name="genderFm" value="F">여</td>
                                </tr>
							    <tr>
                                    <td id="title">신분</td>
                                    <td><input type="radio" name="roleSt" id="radioS"  value="S" checked>학생
                                        <input type="radio" name="roleSt"  id="radioT" value="T">선생님</td>
                                </tr>
                                <tr id="fileupload">
                                    <td id="file">증명서류</td>
                                    <td><input type="file" name="joinupload"></td>
                                </tr>
                            </table>
                            <div id="joinbnt">
                                 <input type="button" id="btn_register" value="회원가입"/> 
	                             <input type="button" value="취소" onclick="goLoginForm()">
                            </div>
	                           
                       </form>
                                    
                </div>
            </section>
          </div>
          <jsp:include page="../template_footer.jsp"></jsp:include>
   </div>    
    
</body>
</html>