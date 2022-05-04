<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/teacherUpdate.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>

<head>
<meta charset="UTF-8">
<title>teacher_update</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/teacherUpdate.js"></script>
</head>
<body>
	<div id="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap content">
			<div id="top_div">
				<p style="font-size: 17px">
					<교습 정보 수정>
				</p>
			</div>
			<form name="teacherUpdatefrm" action="teacherUpdate.do" method="post">
				<table id="teacherUpdateTable">
					<tr>
						<td>학력<sup> *</sup></td>
						<td>:</td>
						<td><input type="text" name="major"
							placeholder="최종학력을 입력해주세요."></td>
					</tr>
					<tr>
						<td>교습 소개<sup> *</sup></td>
						<td>:</td>
						<td><textarea class="text_area" name="tIntro"
								placeholder="내용을 입력해주세요.(최대 한글1000자)"></textarea></td>
					</tr>
					<tr>
						<td>교습 과목<sup> *</sup></td>
						<td>:</td>
						<td>
							<label for="object1"> <input type="checkbox" name="object" id="object1" value="국어">국어</label> 
							<label for="object2"> <input type="checkbox" name="object" id="object2" value="수학">수학</label> 
							<label for="object3"> <input type="checkbox" name="object" id="object3" value="영어">영어</label> 
							<label for="object4"> <input type="checkbox" name="object" id="object4" value="사회">사회</label> 
							<label for="object5"> <input type="checkbox" name="object" id="object5" value="과학">과학</label> 
							<label for="object6"> <input type="checkbox" name="object" id="object6" value="기타">기타</label>
						</td>
					</tr>
					<tr>
						<td>교습 가능 지역<sup> *</sup></td>
						<td>:</td>
						<td>
							<div style="display: flex">
								<select class="sel">
									<option value="">선택해주세요.</option>
									<option value="강남구">강남구</option>
									<option value="강동구">강동구</option>
									<option value="강북구">강북구</option>
									<option value="강서구">강서구</option>
									<option value="관악구">관악구</option>
									<option value="광진구">광진구</option>
									<option value="구로구">구로구</option>
									<option value="금천구">금천구</option>
									<option value="노원구">노원구</option>
									<option value="도봉구">도봉구</option>
									<option value="동대문구">동대문구</option>
									<option value="동작구">동작구</option>
									<option value="마포구">마포구</option>
									<option value="서대문구">서대문구</option>
									<option value="서초구">서초구</option>
									<option value="성동구">성동구</option>
									<option value="성북구">성북구</option>
									<option value="송파구">송파구</option>
									<option value="양천구">양천구</option>
									<option value="영등포구">영등포구</option>
									<option value="용산구">용산구</option>
									<option value="은평구">은평구</option>
									<option value="종로구">종로구</option>
									<option value="중구">중구</option>
									<option value="중랑구">중랑구</option>
								</select> &nbsp;&nbsp;&nbsp;
								<div>
									<button id="area_reset" class="btn2_2" type="button">지역 초기화</button>
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>
							<div id="active">
								<div class="active_div">-선택 지역 목록-</div>
							</div>
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
					<button type="submit" id="submit" class="btn2_2 update_btn">교습
						정보 저장</button>
					<button type="button" id="cancel" class="btn2_2 update_btn">취소</button>
				</div>
			</form>
		</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
	<%
		MemberVo ssMV = (MemberVo) request.getSession().getAttribute("ssMV");
	%>
	<script>
	$("#cancel").click(function(){
    	console.log("취소 버튼 클릭");
		location.href = "mypage";
		});
	
	</script>
</body>
</html>











