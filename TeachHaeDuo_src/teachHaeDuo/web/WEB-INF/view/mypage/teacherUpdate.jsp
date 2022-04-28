<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/resources/css/teacherUpdate.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css"
	rel="stylesheet" type="text/css">
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>teacher_update</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/teacherUpdate.js"></script>
</head>
<body>
	<div>
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div id="main_wrap">
			<div id="top_div">
				<p style="font-size: 17px">
					<회원정보수정>
				</p>
			</div>
			<table>
				<tr>
					<td>학력<sup> *</sup></td>
					<td>:</td>
					<td><input type="text" name="major"
						placeholder="최종학력을 입력해주세요."></td>
				</tr>
				<tr>
					<td>교습 소개<sup> *</sup></td>
					<td>:</td>
					<td><textarea class="text_area" name="t_intro"
							placeholder="내용을 입력해주세요.(최대 한글1000자)"></textarea></td>
				</tr>
				<tr>
					<td>교습 과목<sup> *</sup></td>
					<td>:</td>
					<td><label for="object1"> <input type="checkbox"
							id="object1" value="국어">국어
					</label> <label for="object2"> <input type="checkbox" id="object2"
							value="수학">수학
					</label> <label for="object3"> <input type="checkbox" id="object3"
							value="영어">영어
					</label> <label for="object4"> <input type="checkbox" id="object4"
							value="사회">사회
					</label> <label for="object5"> <input type="checkbox" id="object5"
							value="과학">과학
					</label> <label for="object6"> <input type="checkbox" id="object6"
							value="기타">기타
					</label></td>
				</tr>
				<tr>
					<td>교습 가능 지역<sup> *</sup></td>
					<td>:</td>
					<td>
						<div style="display: flex">
							<select class="sel">
								<option>선택해주세요.</option>
								<option value="A1">서울시 강남구</option>
								<option value="A2">서울시 강동구</option>
								<option value="A3">서울시 강북구</option>
								<option value="A4">서울시 강서구</option>
								<option value="A5">서울시 관악구</option>
								<option value="A6">서울시 광진구</option>
								<option value="A7">서울시 구로구</option>
								<option value="A8">서울시 금천구</option>
								<option value="A9">서울시 노원구</option>
								<option value="A10">서울시 도봉구</option>
								<option value="A11">서울시 동대문구</option>
								<option value="A12">서울시 동작구</option>
								<option value="A13">서울시 마포구</option>
								<option value="A14">서울시 서대문구</option>
								<option value="A15">서울시 서초구</option>
								<option value="A11">서울시 성동구</option>
								<option value="A17">서울시 성북구</option>
								<option value="A18">서울시 송파구</option>
								<option value="A19">서울시 양천구</option>
								<option value="A20">서울시 영등포구</option>
								<option value="A21">서울시 용산구</option>
								<option value="A22">서울시 은평구</option>
								<option value="A23">서울시 종로구</option>
								<option value="A24">서울시 중구</option>
								<option value="A25">서울시 중랑구</option>
							</select> &nbsp;&nbsp;&nbsp;
							<div>
								<button class="btn2_2" type="button">지역 초기화</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td>
						<div id="active"></div>
					</td>
				</tr>
				<tr>
					<td>온라인 교습 여부<sup> *</sup></td>
					<td>:</td>
					<td><label for="online"> <input type="radio"
							name="online_yna" id="online" value="Y">온라인
					</label> <label for="offline"> <input type="radio"
							name="online_yna" id="offline" value="N">오프라인
					</label> <label for="all"> <input type="radio" name="online_yna"
							id="all" value="A">모두
					</label></td>
				</tr>
				<tr>
					<td>교습 횟수</td>
					<td>:</td>
					<td><input type="text" name="tcnt"
						placeholder="예) 주2회, 미입력시 협의"></td>
				</tr>
				<tr>
					<td>비용</td>
					<td>:</td>
					<td><input type="text" name="tprice" placeholder="미입력시 협의">
					</td>
				</tr>
				<tr>
					<td>희망 학생<sup> *</sup></td>
					<td>:</td>
					<td><label for="student1"> <input type="checkbox"
							id="student1" value="초등학생">초등학생
					</label> <label for="student2"> <input type="checkbox"
							id="student2" value="중학생">중학생
					</label> <label for="student3"> <input type="checkbox"
							id="student3" value="고등학생">고등학생
					</label> <label for="student4"> <input type="checkbox"
							id="student4" value="일반인">일반인
					</label> <label for="student5"> <input type="checkbox"
							id="student4" value="무관">무관
					</label></td>
				</tr>
				<tr>
					<td>어학</td>
					<td>:</td>
					<td><select class="sel1">
							<option>선택해주세요.</option>
							<option value="TOEIC">TOEIC</option>
							<option value="TOFEL">TOFEL</option>
							<option value="TEPS">TEPS</option>
							<option value="JPT">JPT</option>
							<option value="HSK">HSK</option>
					</select> <input type="text" name="sel1_score">
						<button type="button" id="btn">+</button></td>
				</tr>
				<tr id="tr2" class="language_sel">
					<td></td>
					<td></td>
					<td><select class="sel2">
							<option>선택해주세요.</option>
							<option value="TOEIC">TOEIC</option>
							<option value="TOFEL">TOFEL</option>
							<option value="TEPS">TEPS</option>
							<option value="JPT">JPT</option>
							<option value="HSK">HSK</option>
					</select> <input type="text" name="sel2_score">
						<button type="button" id="btn_2">-</button></td>
				</tr>
				<tr id="tr3" class="language_sel">
					<td></td>
					<td></td>
					<td><select class="sel3">
							<option>선택해주세요.</option>
							<option value="TOEIC">TOEIC</option>
							<option value="TOFEL">TOFEL</option>
							<option value="TEPS">TEPS</option>
							<option value="JPT">JPT</option>
							<option value="HSK">HSK</option>
					</select> <input type="text" name="sel3_score">
						<button type="button" id="btn_3">-</button></td>
				</tr>
				<tr id="tr4" class="language_sel">
					<td></td>
					<td></td>
					<td><select class="sel4">
							<option>선택해주세요.</option>
							<option value="TOEIC">TOEIC</option>
							<option value="TOFEL">TOFEL</option>
							<option value="TEPS">TEPS</option>
							<option value="JPT">JPT</option>
							<option value="HSK">HSK</option>
					</select> <input type="text" name="sel4_score">
						<button type="button" id="btn_4">-</button></td>
				</tr>
				<tr id="tr5" class="language_sel">
					<td></td>
					<td></td>
					<td><select class="sel5">
							<option>선택해주세요.</option>
							<option value="TOEIC">TOEIC</option>
							<option value="TOFEL">TOFEL</option>
							<option value="TEPS">TEPS</option>
							<option value="JPT">JPT</option>
							<option value="HSK">HSK</option>
					</select> <input type="text" name="sel5_score">
						<button type="button" id="btn_5">-</button></td>
				</tr>
				<tr>
					<td>개인 교습 경력</td>
					<td>:</td>
					<td><input type="text" name="t_career" placeholder="예) 경력2년">
					</td>
				</tr>
				<tr>
					<td>특이 사항</td>
					<td>:</td>
					<td><textarea class="text_area" name="t_special"
							placeholder="내용을 입력해주세요. (최대 한글100자)"></textarea></td>
				</tr>
			</table>
			<div id="bottom_div">
				<button type="button" id="submit" class="btn2_2 update_btn">교습
					정보 저장</button>
				<button type="button" id="cancel" class="btn2_2 update_btn">취소</button>
			</div>
		</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
	<% MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV"); %>
	<script>
	$("#cancel").click(function(){
    	console.log("취소 버튼 클릭");
		var roleSt = "<%= ssMV.getRoleSt() %>";
		if(roleSt == "S"){
    		location.href="mypageStudent";
		} else if(roleSt == "T"){
    		location.href="mypageTeacher";
		}
	});
	</script>
</body>
</html>