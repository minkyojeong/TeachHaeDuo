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


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님 리스트 - 관리자 화면</title>

</head>
<body>
<%
		ArrayList<TeacherVo> volist = (ArrayList<TeacherVo>) request.getAttribute("teachVolist");
	%>
 <div class="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="teacherList">
	               	   <p class="teacher-title" >선생님 조회</p>
		               <div class="teacher-tableAll">
		                    <table class="teacher-tableAll">
		                     <thead>
		           
								  <tr id=title>
								     <th>아이디</th> 
								     <th>성명</th>
								     <th>닉네임</th> 
								     <th>생년월일</th>
								     <th>주소</th>
								     <th>핸드폰</th>
								     <th>이메일</th>
								     <th>성별</th>
								     <th>가입일자</th>
								     <th>승인/비승인</th>
								  </tr>
							 <thead>
								 	   <c:forEach items="${volist }" var="vo">
									<tr>
								     <td>${vo.getmId()}</td> 
								   	 <td>${vo.getmName()} </td>
								     <td>${vo.getmNickname()}</td> 
								     <td>${vo.getmBirth()}</td>
								     <td>${vo.getmAddress()}</td>
								     <td>${vo.getmPhone()}</td>
								     <td>${vo.getmEmail()}</td>
								     <td>${vo.getGenderFm()}</td>
								     <td>${vo.getmDate()}</td>
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