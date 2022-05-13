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
		<jsp:include page="../template_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="pencilchart">
	               	   <p class="pencilchart-title" >매출 조회</p>
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
	<jsp:include page="../template_footer.jsp"></jsp:include>
</div>
</body>

</html>