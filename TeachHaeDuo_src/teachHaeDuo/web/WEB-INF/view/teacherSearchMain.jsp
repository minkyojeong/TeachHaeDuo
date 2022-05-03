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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님찾기 메인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
			</div>
			<!-- 검색창 -->
			<div class="search_container">
				<span class="object_name">과목</span>
				<div class="object_input">
					<img src="${pageContext.request.contextPath}/resources/icons/search.png">
					<input type="text" name="object" placeholder="어느 과목 선생님을 찾으시나요?">
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
						<option value="init">성별</option>
						<img src="${pageContext.request.contextPath}/resources/icons/down.png">
						<option value="m">남성</option>
						<option value="f">여성</option>
					</select> 
					<select name="area" id="area_search">
						<option value="init">선생님 활동지역</option>
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
						<button type="button" id="btn_call">
							<img src="${pageContext.request.contextPath}/resources/icons/smartphone.png">
							<span class="btn_text">통화허용</span>
						</button>
						<button type="button" id="btn_recruit">
							<img src="${pageContext.request.contextPath}/resources/icons/recruit.png">
							<span class="btn_text">모집중</span>
						</button>
						<button type="button" id="btn_like">
							<img src="${pageContext.request.contextPath}/resources/icons/like_color.png">
							<span class="btn_text">찜</span>
						</button>
					</div>
				</div>
				<script>
					$("#gender").on("change", changeOption);
					$("#area_search").on("change", changeOption);
					function changeOption() {
						console.log(this);
						var genderVal = $("#gender").val();
						var areaVal = $("#area_search").val();
						console.log(genderVal);
						console.log(areaVal);
						// ajax
						$.ajax({
							url : "TeacherSearchWithAreaGender.ajax",
							type : "post",
							data : {
								gender : genderVal,
								area : areaVal
							},
							dataType : "json",
							success : function(result) {
								console.log(result); ///aaa
								$("#content1").html(""); // 텅비움. 열리고 닫히는 태그 사이 
								htmlVal = "";
								htmlVal += '<div class="grid-init grid">';
								for (var i = 0; i < result.length; i++) {
									vo = result[i];
									
									htmlVal += '    <div class="box-init box1" onclick="location.href=' + "'" + "teacherInfo?tNo=" + vo.t_no + "'" + '">';
									htmlVal += '        <div class="list">';
									htmlVal += '            <div class="profile"></div>';
									htmlVal += '            <p class="nickname">' + vo.m_nickname + '</p>';
									htmlVal += '        </div>';
									htmlVal += '    </div>';
									htmlVal += '    <div class="box-init box2" onclick="location.href=' + "'" + "teacherInfo?tNo=" + vo.t_no + "'" + '">';
									htmlVal += '        <div class="title">';
									htmlVal += '            <ul>';
									htmlVal += '                <li>' + vo.object_list + '</li>';
									htmlVal += '                <li>' + vo.t_major + '</li>';
									htmlVal += '                <li>서울특별시 ' + vo.area_list + '</li>';
									htmlVal += '                <li>' + vo.avg_rscore + '</li>';
									htmlVal += '            </ul>';
									htmlVal += '        </div>';
									htmlVal += '    </div>';
								}
								htmlVal += '     </div>';

								$("#content1").html(htmlVal); // 채움. 열리고 닫히는 태그 사이 
							},
							error : function() {

							}
						});

					}
				</script>

				<!-- 각 탭마다 프로필 -->
				<section id="content1">
					<c:if test="${empty teachVolist}"><h1 class="nothing">해당되는 선생님이 없습니다.</h1></c:if>
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content2">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content3">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content4">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content5">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content6">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>

				<section id="content7">
					<div class="grid-init grid">
						<%
							for (TeacherVo vo : volist) {
						%>
						<div class="box-init box1" onclick="location.href='teacherInfo?tNo=<%=vo.getT_no()%>'">
							<div class="list">
								<div class="profile"></div>
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
				</section>
			</div>

			<!-- 페이징처리 -->
			<div class="page_wrap">
				<div class="page_nation">
					<a class="arrow prev" href="#"><img src="${pageContext.request.contextPath}/resources/icons/page_prev.png"></a>
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a class="arrow next" href="#"><img src="${pageContext.request.contextPath}/resources/icons/page_next.png"></a>
				</div>
			</div>
		</div>
		<jsp:include page="template_footer.jsp"></jsp:include>
	</div>

	<!-- 스크립트 -->
	<!--  <script>
        var main = function () {
            /* Push the body and the nav over by 285px over */
            var isOpened = false;

            $('.menu').on("mouseover", function () {
                clearInterval(walk_through);
            });

            $('.icon-menu').on("mouseover", function () {
                clearInterval(walk_through);
            });
            $('.icon-menu').click(function () {
                isOpened = true;

                $('.menu').animate({
                    left: "0px"
                }, 200);

                $('body').animate({
                    left: "285px"
                }, 200);
            });

            /* Then push them back */
            $('.icon-close').on("mouseover", function () {
                clearInterval(walk_through);
            });
            $('.icon-close').click(function () {
                isOpened = false;

                $('.menu').animate({
                    left: "-285px"
                }, 200);

                $('body').animate({
                    left: "0px"
                }, 200);
            });

            // Walkthrough the menu
            var walk_through = setInterval(function () {
                if (!isOpened) {
                    $('.icon-menu').trigger('click');
                }
                else if (isOpened) {
                    $('.icon-close').trigger('click');
                }
            }, 3000);
        };

        $(document).ready(main);
    </script>  -->

</body>
</html>