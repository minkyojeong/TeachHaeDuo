<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/guide.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용방법</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="main_wrap">
		<jsp:include page="template_header.jsp"></jsp:include>
		<div class="wrap content">
            <h2>과외해듀오 이용방법을 알려드려요!</h2>
            <dl>
                <dt><span class="number">1</span>가입하기</dt>
                <dd>
                    회원가입 시 간단한 개인정보 입력 후, 학생 · 선생님 중 신분을 선택해주세요. <br>
                    전문성 및 신뢰성 있는 검증을 위해 선생님으로 가입 시, 재학증명서 또는 졸업증명서를 첨부해야 관리자의 승인 후 선생님으로 활동 할 수 있어요. <br>
                    등록된 증명서가 거짓이거나 위조된 문서이면 관리자에 의해 승인이 거부되고 탈퇴 후, 재가입을 해야 한다는 점 꼭 알아두세요!
                </dd>
                <dt><span class="number">2</span>질문하기 게시판 이용하기</dt>
                <dd>
                    학생만 게시글을 등록할 수 있어요. 질문 유형을 선택하고 내용을 입력해 게시글을 등록해보세요!<br>
                    누군가를 비난하거나 광고, 도배 등의 게시글은 신고 될 수 있고 관리자의 판단 하에 무통보로 게시글이 삭제되거나<br> 
                    심한 경우 해당 게시글 작성자는 강제 탈퇴 될 수 있습니다.<br>
                    댓글은 과외해듀오 회원 누구나 입력할 수 있어요.
                </dd>
                <dt><span class="number">3</span>연필 충전하기</dt>
                <dd>
                    과외해듀오의 다양한 기능을 이용하기 위해 연필을 충전할 수 있습니다.<br>
                    선생님의 경우, 교습 정보 최초 등록 시 연필 5000원이 차감되고 수정 시에는 연필 500원이 차감됩니다.<br>
                    모든 회원님들의 경우, 쪽지 보내기 기능을 이용할 시 연필 500원이 차감됩니다.
                </dd>
                <dt><span class="number">4</span>선생님찾기 이용하기</dt>
                <dd>
                    내게 맞는 조건을 선택해 선생님을 찾아보세요. 마음에 드는 선생님이 너무 많다면 찜 해뒀다가 비교 후, 선생님을 선택할 수 있어요.<br>
                    선생님에게 쪽지를 보내 궁금한 사항을 물어보세요! 쪽지를 보내려면 연필 500원이 차감된다는 점 꼭 알아두세요!<br>
                    어떤 선생님이 내게 비난, 성희롱적 발언 등을 했다면 해당 선생님을 신고해주세요. 관리자가 신고 내역을 보고 빠르게 조치를 취하도록 하겠습니다.<br>
                    리뷰쓰기를 통해 선생님을 추천해보세요! 리뷰쓰기는 해당 선생님에게 쪽지를 보낸 사람만 가능하다는 점 꼭 알아두세요!
                </dd>
            </dl>
		</div>
		<jsp:include page="template_footer.jsp"></jsp:include>
	</div>
</body>
</html>