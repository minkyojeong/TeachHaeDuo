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
					<p style="font-size: 17px">
						<회원정보수정>
					</p>
				</div>
				<div id="middle_div">
					<table id="memberUpdateTable">
						<tr>
							<td>아이디</td>
							<td>:</td>
							<td colspan="2">
								<%
									MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
								%> <%=ssMV.getmId()%>
							</td>
						</tr>
						<tr>
							<td>주소변경</td>
							<td>:</td>
							<td colspan="2"><input type="text" size="50" name="mAddress1"
						id="mAddress1" readonly  value="<%=ssMV.getmAddress()%>"/> <input type="button"
						value="주소검색" id="postcode_button" onclick="open_Postcode()">
						<br> <input type="text" size="50" name="mAddress2"
						id="mAddress2" placeholder="변경을 원하시면 주소 검색 후 입력해주세요" /></td>
						</tr>
						<tr>
							<td>닉네임 변경</td>
							<td>:</td>
							<td><input name="mNickName" id="mNickName" type="text"
								placeholder="<%=ssMV.getmNickname()%>"
								value="<%=ssMV.getmNickname()%>" maxlength="50"><font
								id="checkNickName" size="2"></font></td>
							<td></td>
						</tr>
						<tr>
							<td>휴대폰 번호 변경</td>
							<td>:</td>
							<td colspan="2"><input name="mPhone" id="mphone" type="text"
								placeholder="<%=ssMV.getmPhone()%>"
								value="<%=ssMV.getmPhone()%>"></td>
						</tr>
						<tr>
							<td>이메일 변경</td>
							<td>:</td>
							<td><input name="mEmail" id="mEmail" type="email"
								placeholder="<%=ssMV.getmEmail()%>"
								value="<%=ssMV.getmEmail()%>"
								size="20"
								pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}">
								<font id="checkmEmail" size="2"></font></td>
							<td></td>
						</tr>
					</table>
				</div>
				<div id="low_div">
					<input type="hidden" name="mId" id="mId" value="<%=ssMV.getmId()%>">
					<button class="btn2_2" type="button" id="update_btn">수정 완료</button>
					<button class="btn2_2" type="button" id="cancel">취소</button>
					<button class="btn2_2" type="button" id="member_delete_btn">회원탈퇴</button>
				</div>
			</form>
		</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
<script>
   $(function(){
   	console.log($("#mId").val());
   });
   $("#cancel").click(function(){
	   	console.log("취소 버튼 클릭");
	   	location.href="mypage";
	});
   $("#update_btn").click(function(){
	   console.log("수정완료 클릭");
	   var frm = document.frm_update;
	   frm.action = "memberUpdate.do";
	   frm_update.method = "post";
	   frm.submit();
   });

   $("#member_delete_btn").click(function(){
   	var confm = confirm("정말로 회원 탈퇴를 진행하시겠습니까? 삭제된 정보는 복구 불가능합니다.");
       if(confm == true){
      
       	$.ajax({
       		url:"memberDelete.ax",
       		type:"post",
       		date:{
       			// mId: $("#mId").val()
       				},
       		success: function(result){
       			if(result == "로그인 먼저 해주세요."){
       				alert(result);
       				location.href = "login";
       			}
       			alert(result);
       			location.href="";
				},
				error : function() {

				}
			});
		} else if (confm == false) {
			alert("회원탈퇴를 취소했습니다.");
		}
	});
   
   function open_Postcode() { //다음 카카오 주소찾기
	   console.log("주소검색") 
		new daum.Postcode({
			oncomplete : function(data) {
				console.log(data);
				// 우편번호와 주소 정보를 해당 필드에 넣는다.  
				document.getElementById("mAddress1").value = data.roadAddress;

			}
		}).open();
	   $("input#mAddress2").attr("placeholder", "상세 주소를 입력해주세요.");

	   
	}
   
 //체크 아이디 ajax
	$(function() {
		
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
			}) 
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
			}) 
		});
		
		$("#phone").on("input", function(){
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
</body>
</html>