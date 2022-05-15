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
<title>선생님 증명서</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

 <div class="main_wrap">
       <jsp:include page="../admin_header.jsp"></jsp:include>
		<jsp:include page="../template_nav.jsp"></jsp:include>
		   <div class="wrap content">
			   <section>
	                <div id="teacherList">
	               	   <p class="teacher-title" >선생님 증명서</p>
		               <div class="teacher-tableAll">
		                    <table class="teacher-tableAll">
								<tr id=title>
									<c:choose>
										<c:when test="${filePath==null}"><p>증명서가 없습니다.</p></c:when>
										<c:when test="${filePath != null}"><a href="${filePath}"><img src="${filePath}" width="500" height="500"></a></c:when>
									</c:choose>
								</tr>
	                         </table>
		                 </div>
	              </div>
	            </section>
		</div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
</div>

</body>

</html>