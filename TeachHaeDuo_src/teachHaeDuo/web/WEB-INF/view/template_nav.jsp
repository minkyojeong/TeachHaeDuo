<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="wrap nav">

  <nav class="adminList">
      <p>관리자 페이지</p>
		  <ul>
		    <li><a href="${pageContext.request.contextPath}/memberList">회원정보 조회</a></li>
		    <li><a href="${pageContext.request.contextPath}/teacherApprovalList">선생님 승인여부</a></li>
		    <li><a href="#">선생님 신고관리</a></li>
		    <li><a href="#">게시판관리</a></li>
		    <li><a href="${pageContext.request.contextPath}/pencilChart?type=A">충전금액 조회</a></li>
		    <li><a href="#">자주 묻는 질문관리</a></li>
		  </ul>
 </nav>


</div>