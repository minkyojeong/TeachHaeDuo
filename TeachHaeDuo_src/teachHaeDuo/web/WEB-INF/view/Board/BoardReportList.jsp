<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/nav.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#tb:hover{
		background:rgb(220,220,220);
	}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		<div class="wrqp_all" style="width:1100px; text-align:center; display:inline-block;">
		<div style="width:1000px;height:100px;" >
			<h1 style="font-size:30px;font-weight:500;float:left;margin-left:75px;margin-top:40px;">신고글 관리</h1>
		</div>
		<div class="wrap_report" style="width:1000px; display:inline-block; text-align:center;">
			<c:forEach items="${reportList }" var="vo">
				<table id="tb"border="1" width ="1000" height="70" align = "center" style="font-size: 20px; border:1px solid #fed08b; margin:20px;cursor:pointer;" onClick = " location.href='BoardRead?bno=${vo.getbNo()}'" onMouseOver = " window.status = '' " onMouseOut = " window.status = ''">
    			<tr bgcolor="#fed08b" align ="center" style="font-size: 20px; border:1px solid #fed08b;">
					<th>글 번호</th>
					<th>신고 번호</th>
					<th>신고자</th>
					<th>신고 카테고리</th>
					<th>신고 일자</th>
					</tr>
					<tr align ="center" style="font-size: 20px; border:1px solid #fed08b">
						<td>${vo.getbNo()}</td>
						<td>${vo.getbRNo()}</td>
						<td>${vo.getbRWriter()}</td>
						<td>${vo.getbRCategory()}</td>
						<td>${vo.getbRWriteDate().substring(0,16)}</td>
					</tr>
			
					</table>
							</c:forEach>
					<p>
			<c:if test="${    startPage    >    1    }">
			<a href="BoardReportList?page=${startPage-1 }">이전</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="p">
				<a href="BoardReportList?page=${p }">${p }</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${endPage < totalPageCnt }">
			<a href="BoardReportList?page=${endPage+1 }">다음</a>
			</c:if>
		</p>
			</div>
			</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
	</div>
</body>
</html>