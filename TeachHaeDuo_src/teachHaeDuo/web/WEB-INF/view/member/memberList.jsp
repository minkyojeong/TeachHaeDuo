<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트 - 관리자 화면</title>
</head>
<body>
 <div class="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		<div class="wrap content">
			   <section>
	                <div id="memberList">
	               	   <p class="member-title" style="color:#FA9D00;">회원정보 조회</p>
		               <div class="member-tableAll">
		                    <table>
								  <tr>
								     <td>아이디</td> 
								     <td>비밀번호</td>
								     <td>성명</td>
								     <td>닉네임</td> 
								     <td>생년월일</td>
								     <td>주소</td>
								     <td>핸드폰</td>
								     <td>이메일</td>
								     <td>성별</td>
								     <td>신분</td>
								     <td>알람여부</td>
								  </tr>
								 	   <c:forEach items="${retVolist }" var="vo">
									<tr>
								     <td>${vo.getmId()}</td> 
								     <td>${vo.getmPw()}</td>
								     <td>${vo.getmName()} </td>
								     <td>${vo.getmNickname()}</td> 
								     <td>${vo.getmBirth()}</td>
								     <td>${vo.getmAddress()}</td>
								     <td>${vo.getmPhone()}</td>
								     <td>${vo.getmEmail()}</td>
								     <td>${vo.getGenderFm()}</td>
								     <td>${vo.getmDate()}</td>
								     <td>${vo.getmAlarmYn()}</td>
								  </tr>
								        </c:forEach>
	       
	                         </table>
		                 </div>
	              </div>
	            </section>
		</div>
	<jsp:include page="../template_footer.jsp"></jsp:include>
</div>
			
</html>