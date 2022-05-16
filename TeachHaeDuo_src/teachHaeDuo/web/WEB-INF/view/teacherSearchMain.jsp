<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/teacherSearchMain.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="kh.semi.thduo.teacher.model.vo.TeacherVo"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님찾기 메인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.page_nation .arrow.prev.btnPage {
    opacity: 1;
}

.page_nation .arrow.next.btnPage {
    opacity: 1;
}

.btnPage {
	cursor: pointer;
}

.page_nation .arrow.next{
    background: #f8f8f8  no-repeat center center;
    font-size:0;
    color: #fff;
    margin-right: 7px;
	background-image: url('resources/icons/next_arrow.jpg' );
	background-size: 38px 38px; 
	opacity: 0.2;
}
.page_nation .arrow.prev{
    background: #f8f8f8  no-repeat center center;
    font-size:0;
    color: #fff;
    margin-left: 7px;
	background-image: url('resources/icons/prev_arrow.jpg');
	background-size: 38px 38px; 
	opacity: 0.2;
}
</style>
</head>
<body>
	<%
		ArrayList<TeacherVo> volist = (ArrayList<TeacherVo>) request.getAttribute("teachVolist");
	%>
	<!-- 선생님찾기 메인 -->
	<div class="main_wrap">
		<jsp:include page="template_header.jsp"></jsp:include>
		<div class="wrap content">
			<div class="TSearch_main">
				<h1 class="intro_2">과외선생님 찾기</h1>
				<br>
				<h5>내가 원하는 조건을 골라<br>
				다양한 과목의 선생님을 간편하게 찾아보세요!</h5>
			</div>
			<!-- 검색창 -->
			<div class="search_container">
				<span class="object_name">
					<c:if test="${empty object || empty teachVolist}">과목</c:if>
					<c:if test="${not empty object && not empty teachVolist}">${object}</c:if>
				</span>
				<!-- <span class="object_name">과목</span> -->
				<div class="object_input">
					<img src="${pageContext.request.contextPath}/resources/icons/search.png">
					<input type="text" name="object" id="object" placeholder="어느 과목 선생님을 찾으시나요?">
				</div>
				<button type="button" id="btn_search" class="btn3_1">검색</button>
			</div>

			<!-- 탭메뉴 -->
			<div class="main_teacher">
				<!--디폴트 메뉴-->
				<input id="tab1" type="radio" name="tabs" checked> <label for="tab1">통합</label> 
				<input id="tab2" type="radio" name="tabs"> <label for="tab2">국어</label> 
				<input id="tab3" type="radio" name="tabs"> <label for="tab3">수학</label> 
				<input id="tab4" type="radio" name="tabs"> <label for="tab4">영어</label> 
				<input id="tab5" type="radio" name="tabs"> <label for="tab5">사회</label>
				<input id="tab6" type="radio" name="tabs"> <label for="tab6">과학</label> 
				<input id="tab7" type="radio" name="tabs"> <label for="tab7">기타</label>
				<!-- 선택사항 버튼들 -->
				<div class="choice_option">
					<select name="gender" id="gender">
						<option value="">성별</option>
						<option value="M">남성</option>
						<option value="F">여성</option>
					</select> 
					<select name="area" id="area_search">
						<option value="">선생님 활동지역</option>
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
					</select>

					<div class="btns_on_off">
						<button type="button" id="btn_online">
							<img src="${pageContext.request.contextPath}/resources/icons/online.png">
							<span class="btn_text">온라인 교습</span>
						</button>
						<button type="button" id="btn_offline">
							<img src="${pageContext.request.contextPath}/resources/icons/offline.png">
							<span class="btn_text">오프라인 교습</span>
						</button>
					</div>
					<div class="btns_etc">
						<button type="button" id="btn_recruit">
							<img src="${pageContext.request.contextPath}/resources/icons/recruit.png">
							<span class="btn_text">모집중</span>
						</button>
						<button type="button" id="btn_like">
							<img src="${pageContext.request.contextPath}/resources/icons/like.png">
							<span class="btn_text">찜</span>
						</button>
					</div>
				</div>
				<!-- 각 탭마다 프로필 -->
				<section id="content1">
					<c:if test="${empty teachVolist}">
						<h1 class="nothing">해당되는 선생님이 없습니다.</h1>
					</c:if>
					<c:if test="${not empty teachVolist}">
						<div class="grid-init grid">
							<%
								for (TeacherVo vo : volist) {
							%>
							<div class="box-init box" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
								<div class="list1">
									<%
										if(vo.getT_picture() == null){
									%>
										<div class="profile" style="background-image: url('<%=request.getContextPath()%>/resources/icons/profile.png')"></div>
									<%
										} else {
									%>
										<div class="profile" style="background-image: url('<%=vo.getT_picture()%>')"></div>
									<% 
										}
									%>
									<!-- <div class="profile"></div> -->
									<p class="nickname"><%=vo.getM_nickname()%></p>
								</div>
							</div>
							<div class="box-init box2" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
								<div class="title">
									<ul>
										<li><%=vo.getObject_list()%></li>
										<li><%=vo.getT_major()%></li>
										<li>서울특별시 <%=vo.getArea_list()%></li>
										<li><%=vo.getAvg_rscore()%></li>
									</ul>
								</div>
							</div>
							<%
								}
							%>
						</div>
					</c:if>
				</section>
				<!-- 페이징처리 -->
				<div class="page_wrap">
					<div class="page_nation">
					<c:choose>
						<c:when test="${startPage > 1}">
							<input type="button" class="arrow prev btnPage" value="${startPage-1 }">
						</c:when>
						<c:otherwise>
							<input type="button" class="arrow prev">
						</c:otherwise>
					</c:choose>
					<c:forEach var="i" begin="${startPage}" end="${endPage }">
						<c:if test="${i == currentPage }">
						<input type="button" class="active btnPage"  value="${i }">
						</c:if>
						<c:if test="${i != currentPage }">
						<input type="button" class="btnPage"  value="${i }">
						</c:if>
					</c:forEach>
					<c:choose>
						<c:when test="${endPage < totalPageCnt}">
							<input type="button" class="arrow next btnPage" value="${endPage+1 }">
						</c:when>
						<c:otherwise>
							<input type="button" class="arrow next">
						</c:otherwise>
					</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
/* 		let online_yna = ""; // Y, N, A, ""null 전체보기
		let t_permit_yn = ""; // Y, ""null 전체보기
		let t_recruit_yn = ""; // Y, ""null 전체보기
		let object_list = ""; // '국어', ""null 전체보기
		let area_list = ""; // '강남', ""null 전체보기
		let gender_fm = ""; // 'M','F', ""null 전체보기
		let liked = ""; // 'Y' ""null전체보기 */
			
		let online_yna; // Y, N, A, ""null 전체보기
		let t_permit_yn; // Y, ""null 전체보기
		let t_recruit_yn; // Y, ""null 전체보기
		let object_list = "${object}"; // '국어', ""null 전체보기
		let area_list; // '강남', ""null 전체보기
		let gender_fm; // 'M','F', ""null 전체보기
		let liked; // 'Y' ""null전체보기
		let page = 1; // '1'
		
		if (online_yna == undefined) {
			online_yna = "";
		}
		if (t_permit_yn == undefined) {
			t_permit_yn = "";
		}
		if (t_recruit_yn == undefined) {
			t_recruit_yn = "";
		}
		if (object_list == undefined || object_list == "null") {
			object_list = "";
		}
		if (area_list == undefined) {
			area_list = "";
		}
		if (gender_fm == undefined) {
			gender_fm = "";
		}
		if (liked == undefined) {
			liked = "";
		}

		$("#object").on("keydown", function() {
			if (event.keyCode == 13) {
				console.log($("#object").val());
				object_list = $("#object").val();
				if(object_list == ""){
					$("#tab1").prop("checked", true);
					$(".object_name").text("과목");
				} else if(object_list == '국어' || object_list == '수학' || object_list == '영어' || object_list == '사회' || object_list == '과학' || object_list == '기타'){
					$(".object_name").text(object_list);
				}
				page = 1;
				searchTeacher();
			}
		});
		$("#btn_search").on("click", function() {
			object_list = $("#object").val();
			$(".object_name").text(object_list);
			page = 1;
			searchTeacher();
		});
		$("#gender").on("change", function() {
			gender_fm = $("#gender").val();
			page = 1;
			searchTeacher();
		});
		$("#area_search").on("change", function() {
			area_list = $("#area_search").val();
			page = 1;
			searchTeacher();
		});
		$(".main_teacher [type=radio]").on("change", function() {
			object_list = $(this).next().text().trim();
			$(".object_name").text(object_list);
			if (object_list == "통합") {
				$(".object_name").text("과목");
				object_list = "";
			}
			page = 1;
			searchTeacher();
		});
		$("#btn_like").on("click", function() {
			if ($(this).hasClass("enabled")) {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/like.png"><span class="btn_text">찜</span>');
				$(this).css({background : "#F3F4F6", color : "black"});
				$(this).removeClass("enabled");
				liked = "";
			} else {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/like_color.png"><span class="btn_text">찜</span>');
				$(this).css({background : "gray", color : "white"});
				$(this).addClass("enabled");
				liked = 'Y';
			}
			page = 1;
			searchTeacher();
		});
		$("#btn_recruit").on("click", function() {
			if ($(this).hasClass("enabled")) {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/recruit.png"><span class="btn_text">모집중</span>');
				$(this).css({background : "#F3F4F6", color : "black"});
				$(this).removeClass("enabled");
				t_recruit_yn = "";
			} else {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/recruit_color.png"><span class="btn_text">모집중</span>');
				$(this).css({background : "gray",color : "white"});
				$(this).addClass("enabled");
				t_recruit_yn = 'Y';
			}
			page = 1;
			searchTeacher();
		});

		$("#btn_online").on("click", function() {
			if ($(this).hasClass("enabled")) {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/online.png"><span class="btn_text">온라인 교습</span>');
				$(this).css({background : "#F3F4F6", color : "black"});
				$(this).removeClass("enabled");
				online_yna = "";
			} else {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/online_white.png"><span class="btn_text">온라인 교습</span>');
				$(this).css({background : "gray", color : "white"});
				$(this).addClass("enabled");
				online_yna = 'Y';
			}
			page = 1;
			searchTeacher();
		});
		$("#btn_offline").on("click", function() {
			if ($(this).hasClass("enabled")) {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/offline.png"><span class="btn_text">오프라인 교습</span>');
				$(this).css({background : "#F3F4F6", color : "black"});
				$(this).removeClass("enabled");
				online_yna = "";
			} else {
				$(this).html('<img src="${pageContext.request.contextPath}/resources/icons/offline_white.png"><span class="btn_text">오프라인 교습</span>');
				$(this).css({background : "gray", color : "white"});
				$(this).addClass("enabled");
				online_yna = 'N';
			}
			page = 1;
			searchTeacher();
		});
		$(".btnPage").click(btnPageClickHandler);
		function btnPageClickHandler(){
			console.log($(this));
			page = $(this).val();
			console.log("page 값: "+page);
			searchTeacher();
		}
		function searchTeacher() {
			//console.log(this);
			var objSearchVal = {
				online_yna : online_yna,
				t_permit_yn : t_permit_yn,
				t_recruit_yn : t_recruit_yn,
				object_list : object_list,
				area_list : area_list,
				gender_fm : gender_fm,
				liked : liked,
				page: page
			};
			console.log(objSearchVal);
			// ajax
			$.ajax({
				url : "teacherSearch.ax",
				type : "post",
				data : objSearchVal,
				dataType : "json",
				success : function(resultMap) {
					console.log(resultMap); // 맵 형태로 가져와서 수정함.
					var result = resultMap.retVolist;
					var searchSetVo = resultMap.searchSetVo;
					var startPage = resultMap.startPage;
					var endPage = resultMap.endPage;
					var totalPageCnt = resultMap.totalPageCnt;
					var currentPage = resultMap.currentPage;
					
					setOption(searchSetVo);

					$("#content1").html(""); // 텅비움. 열리고 닫히는 태그 사이 
					if (result) { // 찾은 데이터가 있다면 나타냄
						htmlVal = "";
						htmlVal += '<div class="grid-init grid">';
						for (var i = 0; i < result.length; i++) {
							vo = result[i];
							htmlVal += '    <div class="box-init box" onclick="location.href=' + "'" + "teacherInfo?tNo=" + vo.t_no + "'" + '">';
							htmlVal += '        <div class="list1">';
							if(vo.t_picture != null){
								htmlVal += '		<div class="profile" style = "background-image: url('+ vo.t_picture +')"></div>';
							} else {
								htmlVal += '		<div class="profile"></div>';
							}
							/* htmlVal += '            <div class="profile"></div>'; */
							htmlVal += '            <p class="nickname">' + vo.m_nickname + '</p>';
							htmlVal += '        </div>';
							htmlVal += '    </div>';
							htmlVal += '    <div class="box-init box2" onclick="location.href=' + "'" + "teacherInfo?tNo=" + vo.t_no + "'" + '">';
							htmlVal += '        <div class="title">';
							htmlVal += '            <ul>';
							htmlVal += '				<li>' + vo.object_list + '</li>';
							htmlVal += '                <li>' + vo.t_major + '</li>';
							htmlVal += '                <li>서울특별시 ' + vo.area_list + '</li>';
							htmlVal += '                <li>' + vo.avg_rscore + '</li>';
							htmlVal += '            </ul>';
							htmlVal += '        </div>';
							htmlVal += '    </div>';
						}
						htmlVal += '     </div>';

						$("#content1").html(htmlVal); // 채움. 열리고 닫히는 태그 사이 
						
						var htmlPageVal = "";
						//htmlPageVal +='<div class="page_nation">';
					if(startPage > 1){
						htmlPageVal +='<input type="button" class="arrow prev btnPage" value="'+(startPage-1)+'">';
					}else {
						htmlPageVal +='<input type="button" class="arrow prev" >';
					}
										
					for(var i=startPage; i<=endPage; i++){
						if(i == currentPage){
							htmlPageVal +='<input type="button" class="active btnPage"  value="'+i+'">';
						} else {
							htmlPageVal +='<input type="button" class="btnPage"  value="'+i+'">';
						}
					}
					if(endPage < totalPageCnt){
						htmlPageVal +='<input type="button" class="arrow next btnPage" value="'+(Number(endPage)+1)+'" >';
					} else {
						htmlPageVal +='<input type="button" class="arrow next" >';
					}
						//htmlPageVal +='</div>';
						$(".page_nation").html(htmlPageVal); 
						
						// 많이중요!!!
						$(".btnPage").click(btnPageClickHandler);
					} else {
						htmlVal = "<h1 class='nothing'>해당되는 선생님이 없습니다.</h1>";
						
						$("#content1").html(htmlVal);
					}
				},
				error : function() {
				}
			});
		}

		function setOption(searchSetVo) {
			console.log(searchSetVo);
			object_list = searchSetVo.object_list;
			gender_fm = searchSetVo.gender_fm;
			area_list = searchSetVo.area_list;
			t_permit_yn = searchSetVo.t_permit_yn;

			$(".main_teacher [type=radio]").each(function(idx, ele) {
				var eleLabel = $(ele).next().text().trim();
				if (eleLabel == object_list) {
					$(ele).prop("checked", true);
					return;
				}
			});
			$("#gender").val(gender_fm);
			$("#area_search").val(area_list);
		}
	</script>
		<jsp:include page="template_footer.jsp"></jsp:include>
</body>

</html>