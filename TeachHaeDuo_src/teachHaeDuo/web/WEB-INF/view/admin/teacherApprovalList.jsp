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
<link href="<%=request.getContextPath()%>/resources/css/teacherApprovalList.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님 리스트 - 관리자 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

 <div class="main_wrap">
       <jsp:include page="../admin_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="teacherList">
	               	   <p class="teacher-title" >선생님 조회</p>
		               <div class="teacher-tableAll">
		                    <table class="teacher-tableAll">
								<tr id=title>
									<th>선생님 번호</th>
									<th>아이디</th> 
									<th>성명</th>
									<th>생년월일</th>
									<th>핸드폰</th>
									<th>이메일</th>
									<th>성별</th>
									<th>가입일자</th>
									<th>증명서</th>
									<th>승인/비승인</th>
								</tr>
								
								<c:forEach items="${voList }" var="vo">
								<tr>
									<td>${vo.gettNo()}</td>
									<td>${vo.getmId()}</td> 
									<td>${vo.getmName()} </td>
									<td>${vo.getmBirth()}</td>
									<td>${vo.getmPhone()}</td>
									<td>${vo.getmEmail()}</td>
									<td>${vo.getGenderFm()}</td>
									<td>${vo.getmDate()}</td>
									<td>
										<a href="teacherCertificate?file=${vo.getmCertificate()}">증명서 보기</a>
									</td>
									<td>
										<a class="ok_btn" href="teacherApproval.do?tNoOk=${vo.gettNo()}&nickname=${vo.getmNickname()}&mId=${vo.getmId()}">승인</a>
										<a class="no_btn"  href="teacherApproval.do?tNoNo=${vo.gettNo()}&nickname=${vo.getmNickname()}&mId=${vo.getmId()}">비승인</a>
									</td>
								</tr>
								</c:forEach>
	                         </table>
		                 </div>
	              </div>
	            </section>
		</div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
</div>
<script>
$(function(){
	var msgApprovalVal = '${msgApproval}';
	if(msgApprovalVal != null && msgApprovalVal != ""){
		alert('${msgApproval}');
		location.replace("teacherApprovalList");
	}
	
	$(".ok_btn").click(function(e){
		var confm = confirm("승인처리 하시겠습니까?");
		if (confm == false) {
			preventClick(e);
			alert("취소하셨습니다.")
			location.replace("teacherApprovalList");
		} 
	});
	$(".no_btn").click(function(e){
		var confm = confirm("비승인처리 하시겠습니까?");
		if (confm == false) {
			preventClick(e);
			alert("취소하셨습니다.")
			location.replace("teacherApprovalList");
		}
	});
});
function preventClick(e){
	e.preventDefault()
}
</script>
<% request.getSession().removeAttribute("msgApproval"); %>

</body>

</html>