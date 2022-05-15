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
<link href="<%=request.getContextPath()%>/resources/css/teacherReportList.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님 신고 관리 - 관리자 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="main_wrap">
		<jsp:include page="../template_nav.jsp"></jsp:include>
		<div class="wrap content">
			<section>
				<div id="teacherReport">
					<p class="teacherReport-title">선생님 신고 관리</p>
					<div class="teacherReport-tableAll">
						<table class="teacherReport-tableAll">
							<tr id=title>
								<th>신고자 아이디</th>
								<th>신고자 성명</th>
								<th>피신고자 아이디</th>
								<th>피신고자 성명</th>
								<th>신고 사유</th>
								<th>신고 내용</th>
								<th>신고 일자</th>
								<th>강제 탈퇴</th>
							</tr>

							<c:forEach items="${voList}" var="vo">
								<tr>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_sendid()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_sendName()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_receiveid()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_receiveName()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_category()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getM_r_content()}</a></td>
									<td><a href="reportDetail?rNo=${vo.getM_r_no()}">${vo.getT_r_date()}</a></td>
									
									<td><a id="cancel_btn" href="teacherCancel?mId=${vo.getM_r_receiveid()}&mNickname=${vo.getM_r_receiveNickname()}&tNo=${vo.getT_no()}">자격 박탈</a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</section>
		</div>

	</div>
	<script>
$(function(){
	var msgTeacherCancelVal = '${msgTeacherCancel}';
	if(msgTeacherCancelVal != null && msgTeacherCancelVal != ""){
		alert('${msgTeacherCancel}');
		location.replace("teacherReportList");
	}
	
	$("#cancel_btn").click(function(e){
		var confm = confirm("자격박탈 처리 하시겠습니까?");
		if (confm == false) {
			preventClick(e);
			alert("취소하셨습니다.")
			location.replace("teacherReportList");
		}
	});

});

function preventClick(e){
	e.preventDefault()
}
</script>
<% request.getSession().removeAttribute("msgTeacherCancel"); %>
</body>

</html>