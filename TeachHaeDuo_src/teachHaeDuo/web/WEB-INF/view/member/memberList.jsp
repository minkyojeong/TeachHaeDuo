<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/nav.css" rel="stylesheet" type="text/css">
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
<style>
section{
 padding: 10px;
}
  table.member-tableAll {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
    text-align: center;
   // font-family: "MinSans-Medium"
   
  }
  th, td{
    border-bottom: 1px solid #444444;
    padding: 10px;
  }
  th {
    background-color:#c8c8c8;
  }
  .member-title{
  font-size: 20px;
  padding: 20px 30px;
  font-family: "MinSans-Bold"
  }
  .member-tableAll{
     padding: 10px;
  }
  #memberList{
   //background-color: antiquewhite;
  }
 
</style>
</head>
<body>
 <div class="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="memberList">
	               	   <p class="member-title" >회원정보 조회</p>
		               <div class="member-tableAll">
		                    <table class="member-tableAll">
		                     <thead>
		           
								  <tr id=title>
								     <th>아이디</th> 
								     <th>비밀번호</th>
								     <th>성명</th>
								     <th>닉네임</th> 
								     <th>생년월일</th>
								     <th>주소</th>
								     <th>핸드폰</th>
								     <th>이메일</th>
								     <th>성별</th>
								     <th>신분</th>
								     <th>가입일자</th>
								     <th>알람여부</th>
								  </tr>
							 <thead>
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
								     <td>${vo.getRoleSt()}</td>
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