<%@page import="kh.semi.thduo.teacher.model.vo.TeacherVo"%>
<%@page import="java.util.ArrayList"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/adminMain.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>



	<div class="main_wrap">
	    <jsp:include page="../admin_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		<div class="wrap content admin_main_div">
			<section>
				<div id="section_div">
					<p>메뉴를 선택해주세요.</p>
				</div>
			</section>
		</div>

       <jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
<script>
$(function(){
	var msgPencilChartVal = '${msgPencilChart}';
	if(msgPencilChartVal != null && msgPencilChartVal != ""){
		alert('${msgPencilChart}');
		location.replace("adminMain");
	}
	var msgApprovalListVal = '${msgApprovalList}';
	if(msgApprovalListVal != null && msgApprovalListVal != ""){
		alert('${msgApprovalList}');
		location.replace("adminMain");
	}
	var msgReportDetailVal = '${msgReportDetail}';
	if(msgReportDetailVal != null && msgReportDetailVal != ""){
		alert('${msgReportDetail}');
		location.replace("adminMain");
	}
	var msgTeacherReportListVal = '${msgTeacherReportList}';
	if(msgTeacherReportListVal != null && msgTeacherReportListVal != ""){
		alert('${msgTeacherReportList}');
		location.replace("adminMain");
	}
});
</script>
<% request.getSession().removeAttribute("msgPencilChart"); %>
<% request.getSession().removeAttribute("msgApprovalList"); %>
<% request.getSession().removeAttribute("msgReportDetail"); %>
<% request.getSession().removeAttribute("msgTeacherReportList"); %>
</body>
</html>