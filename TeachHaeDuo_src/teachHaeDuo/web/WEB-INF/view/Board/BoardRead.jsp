<%@page import="kh.semi.thduo.board.vo.BoardVo"%>
<%@page import="kh.semi.thduo.board.vo.BoardReCommentVo"%>
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@page import="kh.semi.thduo.admin.vo.AdminVo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/boardread.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<script>
$(function btn(){
	const modal = document.getElementById("modal")
	const rep = document.getElementById("report")
	rep.addEventListener("click",e => {
		modal.style.display = "inline-block"
	})
});
function btn1(){
	
	
}
$(function btn2(){
	const modal = document.getElementById("modal")
	const rep = document.getElementById("btn2")
	rep.addEventListener("click", e => {
		modal.style.display = "none"
	})
});
</script>
</head>
<body>

						<%
					    MemberVo ssvo = (MemberVo)session.getAttribute("ssMV");
						String ssId = ssvo.getmNickname();%>
					
<%
ArrayList<BoardReCommentVo> rvolist = (ArrayList<BoardReCommentVo>)request.getAttribute("rvo");
%>
<%
			BoardVo vo = (BoardVo)request.getAttribute("bvo");
			if(vo!=null){
		%>
<div class="container">
<jsp:include page="../template_header.jsp"></jsp:include>
<div class="wrap_container">
	<div id="modal">
		<div class="modalwindow">
			<a>정말로 신고하시겠습니까?</a>
			<button type="button" id="btn1" onclick="location.href='BoardReportRead?bno=<%= vo.getbNo() %>'">확인</button>
			<button type="button" id="btn2" onclick="javascript:btn2()">취소</button>
		</div>
	</div>
	<div class="wrap_read">
	<dt><a><%= vo.getbCategory() %></a></dt>
	<div class="wrap_wrap">
		<div class="profile">
						<dd id="profile_img"><img src="${pageContext.request.contextPath}/resources/icons/profile.png"></dd>
						<dl id="writed">
							<dd id="title"><%= vo.getbTitle() %></dd>
							<dd id="writer"><%= vo.getbWriter() %></dd>
							<dd id="writedate"><%= vo.getbWriteDate().substring(0,10) %></dd>
						</dl>
						<%if( ssId.equals(vo.getbWriter()))  { %>
						<dd id="cnt"><button type="button" onclick="location.href='BoardModify?bno=<%= vo.getbNo() %>&mid=<%= vo.getmId() %>'">글 수정</button></dd>
						<dd id="bno"><button type="button" onclick="location.href='BoardDelete?bno=<%= vo.getbNo() %>&mid=<%= vo.getmId() %>'">글 삭제</button></dd>
		                <%} %> 
		                <%if( !ssId.equals(vo.getbWriter())) { %>
		                <dd><button type="button" id="report" onclick="javascript:btn()">신고</button></dd>
						<%} %>
		</div>
		<div class="content">
			<p><%= vo.getbContent() %></p>
		</div>
		</div>
	</div>
	<div class="wrap_recomment">
	<dt><a>댓글</a></dt>
		<div class="recomment">
			<form action="BoardReCommentWrite" method="get">
				<input style="display:none;"type="text" name="rWriter" value="<%= ssvo.getmName() %>">
				<% System.out.println(ssvo.getmName()); %>
				<input style="display:none;"type="text" id="bno" name="bno" value="<%= vo.getbNo() %>">
				<input type="text" name="reComment" placeholder="댓글을 입력하세요." maxlength="100"><br>
				<button type="submit">댓글등록</button>
			</form>
		</div>
		<%
			if(rvolist != null) {
				for(BoardReCommentVo rvo: rvolist){
		%>
		<div class="rread">
			<table>
				<tr>
					<td><%= rvo.getrWriter() %></td>
					<td><%= rvo.getrWriteDate().substring(0,10) %></td>
					<td colspan="9"><%= rvo.getrContent() %></td>
						<%if( ssId.equals(vo.getbWriter()))  { %>
					<td><button type="button" onclick="location.href='BoardReCommentDelete?bno=<%= vo.getbNo() %>&rno=<%= rvo.getrNo() %>'">삭제</button>
					<%} %>
				</tr>
			</table>
		</div>
		<%
				}
			}
			%>
	</div>
	</div>
	<jsp:include page="../template_footer.jsp"></jsp:include>
</div>
<%
			}
%> 
</body>
</html>