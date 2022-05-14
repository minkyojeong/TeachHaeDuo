<%@page import="kh.semi.thduo.teacher.model.vo.TeacherVo"%>
<%@page import="java.util.ArrayList"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/pencilChart.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출 조회 - 관리자 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

 <div class="main_wrap">
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="pencilchart">
	               	   <p class="pencilchart-title" >매출 조회</p>
	               	   <div class="pencil_chart_btn">
		               	   <button type="button" class="btn2_3" id="all_btn">전체 조회</button>
		               	   <button type="button" class="btn2_3" id="month_btn">달 조회</button>
		               	   <button type="button" class="btn2_3" id="year_btn">연도 조회</button>
	               	   </div>
		               <div class="pencilchart-tableAll">
		                    <table class="pencilchart-tableAll">
								<tr id=title>
									<th>아이디</th> 
									<th>성명</th>
									<th>신분</th>
									<th>핸드폰</th>
									<th>이메일</th>
									<th>성별</th>
									<th>충전금액</th>
									<th>충전일자</th>
								</tr>
								
								<c:forEach items="${voList }" var="vo">
								<tr>
									<td>${vo.getmId()}</td> 
									<td>${vo.getmName()} </td>
									<td>${vo.getRoleSt()}</td>
									<td>${vo.getmPhone()}</td>
									<td>${vo.getmEmail()}</td>
									<td>${vo.getGenderFm()}</td>
									<td>${vo.getCpCash()}</td>
									<td>${vo.getCpDate()}</td>
								</tr>
								</c:forEach>
	                         </table>
		                 </div>
	              </div>
	            </section>
		</div>
		<div id="month_chart_modal" class="month_chart_modal_overlay">
        <div class="month_chart_modal_window">
            <div class="month_chart_modal_title">
                <img src="${pageContext.request.contextPath}/resources/icons/pencil_month.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">달 조회</p>
                <div class="month_chart_modal_close">X</div>
            </div>
            <div class="month_chart_modal_content">
                <button type="button" class="btn3_3 month" id="this_month">이번달</button>
                <button type="button" class="btn3_3 month" id="three_month">3개월</button>
                <button type="button" class="btn3_3 month" id="six_month">6개월</button>
            </div>
        </div>
    </div>
    <div id="year_chart_modal" class="year_chart_modal_overlay">
        <div class="year_chart_modal_window">
            <div class="year_chart_modal_title">
                <img src="${pageContext.request.contextPath}/resources/icons/pencil_month.png" width="30" height="30" style="margin-right:10px">
                <p style="line-height:30px">연 조회</p>
                <div class="year_chart_modal_close">X</div>
            </div>
            <div class="year_chart_modal_content">
                <button type="button" class="btn3_3 year" id="this_year">이번년</button>
                <button type="button" class="btn3_3 year" id="pre_year">작년</button>
                <button type="button" class="btn3_3 year" id="pre2_year">제작년</button>
            </div>
        </div>
    </div>
</div>
</body>

<script>

/* modal 달조회 */
$("#month_btn").click(function() {
	$("#month_chart_modal").show();
});

$(".month_chart_modal_close").click(function() {
	$("#month_chart_modal").hide();
});

month_chart_modal.addEventListener("click", e => {
	const evTarget = e.target
	if (evTarget.classList.contains("month_chart_modal_overlay")) {
		$("#month_chart_modal").hide();
	}
})
/* modal 년조회 */
$("#year_btn").click(function() {
	$("#year_chart_modal").show();
});

$(".year_chart_modal_close").click(function() {
	$("#year_chart_modal").hide();
});

year_chart_modal.addEventListener("click", e => {
	const evTarget = e.target
	if (evTarget.classList.contains("year_chart_modal_overlay")) {
		$("#year_chart_modal").hide();
	}
})

$("#all_btn").click(function(){
	console.log("전체조회");
	location.href="pencilChart?type=A";
});
$("#this_month").click(function(){
	location.href="pencilChart?type=M&num=0";
});
$("#three_month").click(function(){
	location.href="pencilChart?type=M&num=3";
});
$("#six_month").click(function(){
	location.href="pencilChart?type=M&num=6";
});
$("#this_year").click(function(){
	location.href="pencilChart?type=Y&num=0";
});
$("#pre_year").click(function(){
	location.href="pencilChart?type=Y&num=12";
});
$("#pre2_year").click(function(){
	location.href="pencilChart?type=Y&num=24";
});
</script>
</html>