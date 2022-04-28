<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/teacherInfo_modal.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/teacherInfo_section.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/teacherInfo_aside.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과외해듀오</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="modal report">
		<div class="report_content">
			<p class="modal_title">신고하기</p>
			<!-- <form> -->
				<div class="report_sel">
					<span>신고사유 선택</span>
					<select name="report_category" id="report_category">
						<option value="비난">비난</option>
						<option value="성희롱적 발언">성희롱적 발언</option>
						<option value="광고">광고</option>
						<option value="도배">도배</option>
						<option value="기타">기타</option>
					</select>
				</div>
				<div class="report_input">
					<p>신고 내용 입력</p>
					<input type="hidden" name="m_r_receiveid" id="m_r_receiveid" value="${tvo.m_id}">
					<textarea cols="35" rows="10" name="m_r_content" id="m_r_content" placeholder="신고 내용을 입력해주세요." required></textarea>
				</div>
				<div class="report_send">
					<button type="button" id="btn_report_cancel">취소</button>
					<button type="button" id="btn_report_send">신고</button>
				</div>
			<!-- </form> -->
		</div>
	</div>
	<div class="modal message">
		<div class="message_content">
			<p class="modal_title">쪽지 보내기</p>
			<p class="message_notice">* 쪽지를 보낼 시, 연필이 500원 차감됩니다. *</p>
			<div class="message_input">
				<input type="hidden" name="alarm_receiveid" id="alarm_receiveid" value="${tvo.m_nickname}">
				<textarea cols="35" rows="10" name="alarm_content" id="alarm_content" placeholder="쪽지 내용을 입력해주세요."></textarea>
			</div>
			<div class="message_send">
				<button type="button" id="btn_message_cancel">취소</button>
				<button type="button" id="btn_message_send">보내기</button>
			</div>
		</div>
	</div>
	<div class="modal review">
		<div class="review_content">
			<p class="modal_title">리뷰 작성하기</p>
			<p class="review_notice">* 리뷰는 해당 선생님에게 쪽지를 보낸 사람만 가능해요 *</p>
			<div class="review_input">
				<span>별점 선택</span>
				<select name="t_r_score" id="t_r_score">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<input type="hidden" name="alarm_receiveid" id="alarm_receiveid" value="${tvo.m_nickname}">
				<input type="hidden" name="t_no" id="t_no" value="${tvo.t_no}">
				<textarea cols="35" rows="10" name="t_r_content" id="t_r_content" placeholder="리뷰를 입력해주세요." required></textarea>
			</div>
			<div class="review_send">
				<button type="button" id="btn_review_cancel">취소</button>
				<button type="button" id="btn_review_send">등록</button>
			</div>
		</div>
	</div>
	<div class="modal like">
		<div class="like_content">
			<p>선생님을 찜 했어요!</p>
		</div>
	</div>
	<div class="modal cancle_like">
		<div class="cancle_like_content">
			<p>찜을 취소했어요.</p>
		</div>
	</div>
<c:set var="vo" value="vo"></c:set>
	<div class="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap content">
			<div class="wrap content">
				<div class="content">
					<section>
						<div class="t_profile">
							<div class="t_profile_left">
								<div class="t_img"></div>
								<p class="t_name">${tvo.m_nickname}</p>
								<p class="t_age">
									<c:choose>
										<c:when test="${tvo.gender_fm == 'F'}">(여 / ${tvo.t_age}세)</c:when>
										<c:when test="${tvo.gender_fm == 'M'}">(남 / ${tvo.t_age}세)</c:when>
									</c:choose>
								</p>
							</div>
							<div class="t_profile_right">
								<p>${tvo.object_list}</p>
								<p>${tvo.t_major}</p>
								<p>${tvo.m_address}</p>
								<p>${tvo.avg_rscore}</p>
								<div class="yes_no">
									<div class="on_off">
										<c:choose>
											<c:when test="${tvo.online_yna == 'Y'}">온라인만 가능해요.</c:when>
											<c:when test="${tvo.online_yna == 'N'}">오프라인만 가능해요.</c:when>
											<c:when test="${tvo.online_yna == 'A'}">온라인 / 오프라인 모두 가능해요.</c:when>
										</c:choose>
									</div>
									<div class="stu_recruit">
										<c:choose>
											<c:when test="${tvo.t_recruit_yn == 'Y'}">수강생을 모집 중입니다.</c:when>
											<c:when test="${tvo.t_recruit_yn == 'N'}">수강생을 모집하지 않습니다.</c:when>
										</c:choose>
									</div>
								</div>
							</div>
						</div>
						<nav class="t_menu">
							<ul>
								<li><a href="#t_train_intro">교습소개</a></li>
								<li><a href="#t_train_info">교습정보</a></li>
								<li><a href="#t_info">선생님정보</a></li>
								<li><a href="#t_review">리뷰</a></li>
							</ul>
						</nav>
						<div class="t_content">
							<article id="t_train_intro">
								<h1>교습소개</h1>
								<pre>${tvo.t_intro}</pre>
							</article>
							<div class="t_info_line">
								<hr>
							</div>
							<article id="t_train_info">
								<h1>교습정보</h1>
								<p>교습 과목 : ${tvo.object_list}</p>
								<p>활동 지역 : [서울] ${tvo.area_list}</p>
								<p>교습 횟수 : ${tvo.t_tcnt}</p>
								<p>교습 비용 : ${tvo.t_tprice}</p>
								<p>교습 희망학생 : ${tvo.t_wantstud}</p>
							</article>
							<div class="t_info_line">
								<hr>
							</div>
							<article id="t_info">
								<h1>선생님정보</h1>
								<p>
									이름 / 성별 / 나이 : ${tvo.m_name} 선생님 / 
									<c:choose>
										<c:when test="${tvo.gender_fm == 'F'}">여 / ${tvo.t_age}세</c:when>
										<c:when test="${tvo.gender_fm == 'M'}">남 / ${tvo.t_age}세</c:when>
									</c:choose>
								</p>
								<p>대학교 학력 : ${tvo.t_major}</p>
								<p>거주지 : ${tvo.m_address}</p>
								<p>개인교습 경력 : ${tvo.t_career}</p>
								<p>어학 : ${tvo.t_language}</p>
								<p>특이사항 : ${tvo.t_special}</p>
							</article>
							<div class="t_info_line">
								<hr>
							</div>
							<article id="t_review">
								<h1>리뷰</h1>
								<button id="btn_review" class="btn1_2">리뷰쓰기</button>
								<div class="review_list_content">
									<c:choose>
										<c:when test="${empty tvo.t_review}">아직 리뷰가 없습니다.</c:when>
										<c:when test="${not empty tvo.t_review}">
											<c:forEach items="${tvo.t_review}" var="rvo">
												<div class="review_info">
													<span>${rvo.t_r_writer}</span> 
													<span>
													<c:forEach begin="1" end="${rvo.t_r_score}">
														<img src="<%=request.getContextPath()%>/resources/icons/star.png">
													</c:forEach>
													</span>
													<span>${rvo.t_r_date}</span>
													<input type="hidden" name="t_r_no" id="t_r_no" value="${rvo.t_r_no}">
													<!-- TODO : 세션 닉네임이랑 리뷰 닉네임 비교해서 같으면 삭제버튼 나오게 하기(아래 주석 풀어서 테스트) -->
<%-- 													<c:if test="${ssMV.mNickname == rvo.t_r_writer}">
														<button type="button" id="btn_review_delete" class="btn3_1">리뷰삭제</button>
													</c:if> --%>
													<button type="button" id="btn_review_delete" class="btn3_1">리뷰삭제</button>
												</div>
												<p>${rvo.t_r_content}</p>
											</c:forEach>
										</c:when>
									</c:choose>
								</div>
							</article>
						</div>
					</section>
					<aside>
						<div class="aside_menu">
							<div class="like_report">
							<!-- TODO : 로그인 세션 정보와 비교해서 사진 다르게 뜨나 테스트 해보기 -->
<%-- 								<c:choose>
									<c:when test="${empty tvo.like}">
										<input type="hidden" name="liked_id" id="liked_id" value="${ssMV.mId}">
										<input type="hidden" name="t_no" id="t_no" value="${tvo.t_no}">
										<button type="button" id="btn_like" class="btn3_1">
											<img id="img_like" src="<%=request.getContextPath()%>/resources/icons/like.png">찜
										</button>
									</c:when>
									<c:when test="${not empty tvo.like}">
										<input type="hidden" name="s_no" id="s_no" value="${tvo.like.s_no}">
										<input type="hidden" name="t_no" id="t_no" value="${tvo.like.t_no}">
										<button id="btn_cancle_like" class="btn3_1">
											<img id="img_cancle_like" src="<%=request.getContextPath()%>/resources/icons/like_color.png">찜
										</button>
									</c:when>
								</c:choose> --%>
							<c:choose>
									<c:when test="${empty tvo.like}">
										<input type="hidden" name="liked_id" id="liked_id" value="b12345">
										<input type="hidden" name="t_no" id="t_no" value="${tvo.t_no}">
										<button type="button" id="btn_like" class="btn3_1">
											<img id="img_like" src="<%=request.getContextPath()%>/resources/icons/like.png">찜
										</button>
									</c:when>
									<c:when test="${not empty tvo.like}">
										<input type="hidden" name="s_no" id="s_no" value="${tvo.like.s_no}">
										<input type="hidden" name="t_no" id="t_no" value="${tvo.like.t_no}">
										<button id="btn_cancle_like" class="btn3_1">
											<img id="img_cancle_like" src="<%=request.getContextPath()%>/resources/icons/like_color.png">찜
										</button>
									</c:when>
								</c:choose>
								<button id="btn_report" class="btn3_1">
									<img src="<%=request.getContextPath()%>/resources/icons/report.png">신고
								</button>
							</div>
							<div class="message_area">
								<button id="btn_message" class="btn2_1">쪽지보내기</button>
							</div>
						</div>
					</aside>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/resources/js/teacherInfo.js"></script>
</body>
</html>