<%@page import="kh.semi.thduo.board.vo.BoardVo"%>
<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
.container{
    width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgb(174,174,174);
}
#modal{		
			background: #ddd;
			text-align:center;
			border: 1px solid rgb(174,174,174);
			border-radius:5px;
			width: 400px;
            height: 500px;
            position: relative;
            top: -100px;
            padding: 10px;
            
}
#box{
font-size:20px;
margin: 50px;
}
#bno{
display:none;
}
#b_r_category{
margin-left:20px;
margin-right:20px;
margin-bottom:20px;
width:200px;
height:50px;
font-size:20px;
border-radius:5px;
text-align:center;
}
#b_r_writer{
display:none;
}
#reason{
margin-left:0;
display: inline-block;
margin-top:30px;
width:200px;
height:50px;
font-size:20px;
}
#modal>button{
width:70px;
height:30px;
font-size:15px;
border-radius:5px;
}
#modal>button:hover{

	color: gray;
}
</style>
</head>
<body>
	<%
					    MemberVo ssvo = (MemberVo)session.getAttribute("ssMV");
						String ssId = ssvo.getmNickname();%>

<%
			BoardVo vo = (BoardVo)request.getAttribute("bvo");
			if(vo!=null){
			
		%>
<div class="container">
<form action="BoardReport" method="get">
	<div id="modal">
		<input type="text" id="bno" name="bno" value="<%= vo.getbNo() %>">
		<input id="b_r_writer" name="b_r_writer" value="<%= vo.getbWriter() %>">
		<p id="reason">신고 사유</p>
		<select id="b_r_category" name="b_r_category">
			<option value="광고">광고</option>
			<option value="성적인 발언">성적인 발언</option>
			<option value="대상비하/무시 발언">대상비하/무시 발언</option>
			<option value="욕설">욕설</option>
		</select>
	<dd id="box">신고자 정보는 안전하게 보호됩니다:)</dd>
	<button type="submit">제출</button>
	</div>
	</form>
</div>
<% } %>
</body>
</html>