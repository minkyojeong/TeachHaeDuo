<%@page import="kh.semi.thduo.report.model.vo.ReportVo"%>
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
<link href="<%=request.getContextPath()%>/resources/css/teacherReportDetail.css" rel="stylesheet" type="text/css">



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
					<p class="teacherReport-title">신고 상세 조회</p>
					<div class="teacherReport-tableAll">
						<table class="teacherReport-tableAll">
						<% ReportVo vo = (ReportVo)request.getAttribute("rVo"); %>
							<tr id=title>
								<th>신고 내용</th>
							</tr>
							<tr>
								<td><%= vo.getM_r_content() %></td>
							</tr>
						</table>
					</div>
				</div>
			</section>
		</div>

	</div>

<script>
$(function(){
	var msgReportDetailVal = '${msgReportDetail}';
	if(msgReportDetailVal != null && msgReportDetailVal != ""){
		alert('${msgReportDetail}');
		location.replace("teacherReportList");
	}
});
</script>
<% request.removeAttribute("msgReportDetail"); %>
</body>

</html>