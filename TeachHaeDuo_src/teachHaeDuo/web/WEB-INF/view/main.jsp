<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/main_content.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과외해듀오</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="main_wrap">
		<jsp:include page="template_header.jsp"></jsp:include>
		<div class="wrap content">
			<div class="intro">
				<h1>내게 맞는</h1>
				<h1>과외 선생님을 찾아보세요!</h1>
			</div>
			<div class="search">
				<img src="${pageContext.request.contextPath}/resources/icons/search.png"> 
					<input type="text" placeholder="어느 과목 선생님을 찾으시나요?" autocomplete="off">
			</div>
			<div class="category">
				<h2>교습 서비스 카테고리</h2>
				<a class="object korean" href="#1"> 
					<span class="category_name">국어</span>
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/korean.png">
				</a> <a class="object math" href="#2"> 
					<span class="category_name">수학</span>
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/math.png">
				</a> <a class="object eng" href="#3"> 
					<span class="category_name">영어</span>
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/eng.png">
				</a> <a class="object social" href="#4"> 
					<span class="category_name">사회</span>
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/social.png">
				</a> <a class="object science" href="#5"> 
					<span class="category_name">과학</span> 
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/science.png">
				</a> <a class="object etc" href="#6"> 
					<span class="category_name">기타</span>
					<img class="object_icon" src="${pageContext.request.contextPath}/resources/icons/lightbulb.png">
				</a>
			</div>
		</div>
		<div class="line">
			<hr>
		</div>
		<jsp:include page="template_footer.jsp"></jsp:include>
	</div>
</body>
</html>