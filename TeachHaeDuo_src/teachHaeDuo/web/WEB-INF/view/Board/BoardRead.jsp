<%@page import="kh.semi.thduo.board.vo.BoardVo"%>
<%@page import="kh.semi.thduo.board.vo.BoardReCommentVo"%>
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<style>
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed, 
figure, figcaption, footer, header, hgroup, 
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, 
footer, header, hgroup, menu, nav, section {
	display: block;
}
body {
	line-height: 1;
}
ol, ul {
	list-style: none;
}
blockquote, q {
	quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
	content: '';
	content: none;
}
table {
	border-collapse: collapse;
	border-spacing: 0;
}
.container{
width:100%;
height:100%;
text-align:center;
}
.wrap{
display:inline-block;
width:800px;
height:700px;
border: 1px solid rgb(174,174,174);
border-radius:5px;
margin-top:50px;
margin-bottom:30px;
}
.profile{
width:700px;
height:100px;
}
#profile_img>img{
width:50px;
height:50px;
}
#profile_img{
margin-right:30px;
float:left;
}
.content{
width:700px;
height:500px;
}
.recomment{
width:700px;
height:200px;
text-align:center;
display:inline-block;
border-bottom: 1px solid rgb(174,174,174);

}
#modal>button{
width:50px;
height:25px;
}
.recomment>form>input{
border: 1px solid rgb(174,174,174);
border-radius:5px;
width:700px;
height:100px;
display:inline-block;

}
.recomment>form{
margin-top:30px;
margin-bottom:30px;
}
.recomment>form>button{
float:right;
margin:10px;
}
dt{
 	font-size:20px;
	width:800px;
	height:50px;
	border-bottom: 1px solid rgb(174,174,174);
	border-radius: 5px;
	margin-bottom:10px;
	text-align:left;
	position:relative;
}
dt>a{
position: absolute;
top:15px;
left:10px;
}
.wrap_wrap{
display:inline-block;
width:700px;
height:100%;
text-align:left;
margin-top:30px;

}
.wrap_recomment{
display:inline-block;
text-align:center;
width:800px;
height:700px;
border: 1px solid rgb(174,174,174);
border-radius:5px;
margin-bottom:30px;

}
#title{
margin-bottom:10px;
}
#writed{
float:left;
}
#title{
font-size:23px;
font-weight:600;
}
#cnt{
float:right;
font-size:20px;
font-weight:400;

}
#bno{
float:right;
font-size:20px;
font-weight:400;
margin-right:10px;
}
.wrap_container{
display:inline-block;
width:800px;
position:relative;
}
#report{
float:right;
}
#modal{	
display:none;
border: 1px solid rgb(174,174,174);
border-radius:5px;
width:200px;
top:35%;
height:100px;
left:45%;
text-align:center;
position:fixed;
background:rgb(220,220,220);


}
.modalwindow{
margin-top:25px;
width:200px;
height:50px;
display:inline-block;
text-align:center;
}
.modalwindow>a{
margin-bottom:10px;
}
#btn1{

}
#btn2{

}
.rread{
	width:700px;
height:100px;
text-align:center;
display:inline-block;
border-bottom: 1px solid rgb(174,174,174);

}
.rread>table{
margin-top:40px;
	width:700px;
	text-align:center;
}
.rread>table>tr{
margin-top:10px;
}
</style>
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
<div class="wrap_container">
	<div id="modal">
		<div class="modalwindow">
			<a>정말로 신고하시겠습니까?</a>
			<button type="button" id="btn1" onclick="location.href='BoardReportRead?bno=<%= vo.getbNo() %>'">확인</button>
			<button type="button" id="btn2" onclick="javascript:btn2()">취소</button>
		</div>
	</div>
	<div class="wrap">
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
				<input type="text" name="reComment" placeholder="댓글을 입력하세요."><br>
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
					<td><%= rvo.getrWriteDate().substring(0,16) %></td>
					<td colspan="9"><%= rvo.getrContent() %></td>
					<td><button type="button" onclick="location.href='BoardReCommentDelete?bno=<%= vo.getbNo() %>&rno=<%= rvo.getrNo() %>'">삭제</button>
				</tr>
			</table>
		</div>
		<%
				}
			}
			%>
	</div>
	</div>
</div>
<%
			}
%> 
</body>
</html>