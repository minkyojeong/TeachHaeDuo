<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kh.semi.thduo.board.controller.BoardListController" %>
    <%@ page import="kh.semi.thduo.board.service.BoardService" %>
    <%@ page import="kh.semi.thduo.board.dao.BoardDao" %>
    <%@ page import="kh.semi.thduo.board.vo.BoardVo" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content=text/html; charset="UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font.css">
<title>BoardList</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
footer {
    font-family: MinSans-Medium;
    font-size: 13px;
    color: #504A4D;
}
.footerTop {
    overflow: hidden;
    margin-bottom: 5px;
}
.footerTop_section1 {
    float: left;
    width: 15%;
    text-align: center;
    vertical-align: middle;
}
.footerTop_section1 img {
    width: 150px;
}
.footerTop_space {
    float: left;
    width: 15%;
}
.footerTop_section2 {
    float: left;
    line-height: 1.5em;
    width: 35%;
    padding-top: 5px;
}
.footerTop_section3 {
    float: right;
    width: 35%;
}
.footerBottom {
    clear: both;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background-color: #FA9D00;
}
header {
    background-color: yellow;
    overflow: hidden;
}
.logo {
    float: left;
}
.logo img {
    width: 200px;
    height: 100px;
}
.menu {
    background-color: yellowgreen;
    float: right;
    margin: 40px 30px 0 0;
}
.menu li{
    font-family: MinSans-Medium;
    font-size: 20px;
    float: left;
}
.menu li > a {
    color: black;
}
.claer {
    clear: both;
}

.board_list{
    text-align: center;
    border-radius: 5px;
    border: 1px solid rgb(174, 174, 174)
    
			}
.container{
	width:100%;
	text-align:center;
}
.board_box{
	width:1100px;
	display:inline-block;
	margin-top:50px;
	
}
.board_title{
	width:1100px;
	height:50px;
display:block;}
.board_title > h1{
	font-size:25px;
	float:left;
}
.boardright{
	float:right;
}
input{
	border: 1px solid rgb(174,174,174);
	width:200px;
	height: 40px;
	border-radius: 5px;
}

select{
	padding-left:5px;
	border: 1px solid rgb(174,174,174);
	margin-right:5px;
	width:120px;
	height:40px;	
	border-radius: 5px;
	font-size: 17px;
}
.board_list{
	width:1100px;
	height:400px;
	
}
.write{
	width:1100px;
	height:60px;
	background: #FA9D00;
	border-radius: 5px;
	margin-top:10px;
	margin-bottom:15px;

}
.write:hover{
	background: #e49103;

}
#question{
float:left;
text-decoration-line: none;
color: black;
padding: 20px;
font-size: 20px;
}
#question:hover{
	text-decoration-line:underline;
}
dl{
	
	margin-bottom:50px;
}
dt{
 	font-size:20px;
	width:1100px;
	height:50px;
	border-bottom: 1px solid rgb(174,174,174);
	border-radius: 5px;
	margin-top:10px;
	margin-bottom:10px;

}
dt>a{
float:left;
padding:12px;
padding-left:15px;
}
.set2{
	text-align:left;
	width:1100px;
	height:150px;
	position:relative;
	margin:0;
}
#profile>img{
	width:50px;
	height:50px;
}
#profile{
display: inline-block;
margin:50px;

}
#writed{
height:50px;
display: inline-block;
margin-top:50px;

}
#writer{
margin:5px;
font-weight:400;
}
#writedate{
margin:5px;
font-weight:400;
color:rgb(60, 60, 60)
}
#title{
margin-bottom:10px;
font-size:22px;
font-weight:500;
color:rgb(60, 60, 60)

}
.set{
	
	text-align:right;
	font-size:20px;
	font-weight:lighter;
}
#bno{
	
	margin-right:10px;
	margin-top:50px;
	font-size:22px;
	display:none;
	
	

}
#cnt{
	margin-right:20px;
	margin-top:50px;
	float:right;
	font-size:20px;
	
	
	

}
#content{
	float:left;
	margin-left:50px;
	margin-bottom:50px;
	overflow: hidden;
	text-overflow: elipsis;
}
.board_list:hover{
background:#ddd;
}
</style>
</head>
<body>
<div class="wrap header">
	<header>
		<div class="logo">
			<a href="./"> 
				<img src="${pageContext.request.contextPath}/resources/icons/logo.jpg">
			</a>
		</div>
		<nav class="menu">
			<ul>
				<li><a href="./tearcherSearch.html">선생님찾기&nbsp;&nbsp;</a></li>
				<li><a>질문하기&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<li><a>고객센터&nbsp;&nbsp;</a></li>
				<li><a>이용방법&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;</a></li>
				<li><a>로그인&nbsp;&nbsp;</a></li>
				<li><a>회원가입</a></li>
			</ul>
		</nav>
	</header>
	<div class="clear line">
		<hr>
	</div>
</div>
	<div class="container">
		<div class="board_box">
			<div class="board_title">
				<h1>질문하기 게시판</h1>
				<input type="search" name="boardSearch" value="" class="boardright">
				<select class="boardright">
					<option value="option0">게시판 선택</option>
					<option value="option1">option1</option>
					<option value="option2">option2</option>
					<option value="option3">option3</option>
				</select>
			</div>
			<div class="write" onclick = "location.href='BoardWriteController.java'">
				<a href="BoardWriteController.java" id="question">질문하기</a>
			</div>
			<form action="BoardList" method="get" class="boardlist">
					<%
						BoardService boardService = new BoardService();
						ArrayList<BoardVo> boardList = boardService.boardList();
						for(int i = 0; i < boardList.size();i++){
					%>
				<dl class="board_list" style="cursor:pointer;" onClick = " location.href='BoardRead.jsp?b_no=<%= boardList.get(i).getbNo() %>' " onMouseOver = " indow.status = '' " onMouseOut = " window.status = '' ">
					<dt><a><%= boardList.get(i).getbCategory() %></a></dt>
					<dl class="set2">
						<dd id="profile"><img src="${pageContext.request.contextPath}/resources/icons/profile.png"></dd>
						<dl id="writed">
							<dd id="title"><%= boardList.get(i).getbTitle() %></dd>
							<dd id="writer"><%= boardList.get(i).getbWriter() %></dd>
							<dd id="writedate"><%= boardList.get(i).getbWriteDate().substring(0,11) + boardList.get(i).getbWriteDate().substring(11,13) + ":" + boardList.get(i).getbWriteDate().substring(14,16)  %></dd>
						</dl>
						<dd id="cnt"><a style="padding:3px;">댓글</a><%= boardList.get(i).getbCnt() %></dd>
						<dd id="bno"><a style="padding:3px;">No.</a><%= boardList.get(i).getbNo() %></dd>
					</dl>
					<dd id="content"><%= boardList.get(i).getbContent() %></dd>
				</dl>
						<%
							}
						%>
			</form>
		</div>
	</div>
	<div class="wrap footer">
	<footer>
		<div class="footerTop">
			<div class="footerTop_section1">
				<a href="./">
					<img src="${pageContext.request.contextPath}/resources/icons/footer_logo.png">
				</a>
				<!-- <span>과외해듀오</span> -->
			</div>
			<div class="footerTop_space">&nbsp;</div>
			<div class="footerTop_section2">
				<p>과외해듀오는 게시판을 통해 고객센터를 운영하고있습니다.</p>
				<p>1:1 문의를 원하신다면 teachHaeDuo@gmail.com으로</p>
				<p>이메일을 보내주시면 신속하게 답변해드리겠습니다.</p>
			</div>
			<div class="footerTop_section3">
				<p>주식회사 KH정보교육원</p>
				<p>대표이사 정민교</p>
				<p>강남지원 1관 : 서울특별시 강남구 테헤란로14길 남도빌딩 2F,3F,4F,5F,6F</p>
				<p>강남지원 2관 : 서울특별시 강남구 테헤란로10길 그랑프리 빌딩 4F,5F,7F</p>
				<p>강남지원 3관 : 서울특별시 강남구 테헤란로 130 호산빌딩 5F,6F</p>
			</div>
		</div>
		<div class="footerBottom">
			<p>Copyright &copy; 1998-2022 Information Educational Institute All Right Reserved</p>
		</div>
	</footer>
</div>
</body>
</html>