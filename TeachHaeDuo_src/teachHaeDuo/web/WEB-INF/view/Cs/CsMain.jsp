<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
        $(function(){
         $('#cs_box_n').hide();
         $('#cs_box_q').hide();
         $('#cs_box_email').hide();
         $('#questionBoard').hide();
         $('#questionBoard1').hide();
        })
        $(document).ready(function() {
     $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option1') {
         $('#cs_box_q').show();
         $('#questionBoard').show();
       } else {
         $('#cs_box_q').hide();
         $('#questionBoard').hide();
       }
     }); 
   }); 
      $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option2') {
         $('#cs_box_n').show();
         $('#questionBoard1').show();
       } else {
         $('#cs_box_n').hide();
         $('#questionBoard1').hide();
       }
     }); 
   }); 
   $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option3') {
         $('#cs_box_email').show();
       } else {
         $('#cs_box_email').hide();
       }
     }); 
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
.cs_container{
    width:100%;
    
    
}
.cs_section{
    width:100%;
    height:200px;
    
}
.cs_title{
    width:1100px;
    height:100px;
    display:block; 
    position:relative;
    margin: 0 auto;
}
h1{
    margin-top:100px;
    font-size:30px;
    float:left;
}
.cs_select{
    width:1100px;
    height:100px;
    position:relative;
    margin: 0 auto;
}
#cs_select_option{
float:right;
width:250px;
height:50px;
border-radius: 5px;
border:1px solid rgb(174, 173, 173);
font-size: 20px;
padding:3px;
}
.cs_body{
    width:1100px;
    position:relative;
    margin: 0 auto;
    margin-top:20px;
}
#cs_box_q{
    width:1100px;
    height:400px;
    border-radius:5px;
    border:1px solid rgb(165, 165, 165);
    position:relative;
}

#cs_box_n{
    width:1100px;
    height:100px;
    border-radius:5px;
    border:1px solid rgb(165, 165, 165);
    position:relative;
}
.cs_q{
    width:1000px;
    height:200px;;
    margin: 0 auto;
    display:block;
    border-bottom: 1px solid rgb(174,174,174);
}
.cs_q_q{
    float:left;
    padding:10px;
    font-size: 20px;
}
.cs_a{
   width:1000px;
    height:200px;;
    margin: 0 auto;
}
.cs_q_a{
    float:left;
    padding:10px;
    font-size: 20px;
}
#cs_box_email{
    width:1100px;
    height:500px;
    border-radius:5px;
    border:1px solid rgb(165, 165, 165);
    position:relative;
    text-align: center;
}
.write{
	width:1100px;
	height:60px;
	background: #FA9D00;
	border-radius: 5px;
	
	position: relative;
    margin: 0 auto;
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
#question1{
float:left;
text-decoration-line: none;
color: black;
padding: 20px;
font-size: 20px;
}
#question1:hover{
	text-decoration-line:underline;
}
.write>a{

}
}
#cs_e{
    margin:100px;
}
#cs_e>p{
font-size: 20px;
}
.cs_body_all{
    position:relative;
}
.bt{
float:right;
display:inline-block;
width:50px;
height:25px;
margin:10px;
}
.bt:hover{
	background:rgb(220,220,220);
}
    </style>
</head>
<body>
	 <div class="cs_container">
	 <jsp:include page="../template_header.jsp"></jsp:include>
        <div class="cs_section">
            <div class="cs_body_all">
            <div class="cs_title">
                <h1>고객센터</h1>
            </div>
            <div class="cs_select">
                <select id="cs_select_option">
                    <option value="option4">카테고리 선택</option>
                    <option value="option1">자주 묻는 질문</option>
                    <option value="option2">공지사항</option>
                    <option value="option3">1대1 문의</option>
                </select>
            </div>
            <div class="write" id="questionBoard" onclick = "location.href='CsFaqWrite'">
				<a href="CsFaqWrite" id="question">자주묻는 질문 글 쓰기</a>
			</div>
			<div class="write" id="questionBoard1" onclick = "location.href='CsNoticeWrite'">
				<a href="CsNoticeWrite" id="question1">공지사항 글 쓰기</a>
			</div>
            <div class="cs_body">
            <button type="button" class="bt" onclick="location.href='CsFaqDelete'">삭제</button>
            	<c:forEach items="${csvo }" var="vo">
                <div id="cs_box_q">
                    <div class="cs_q">
                        <p class="cs_q_q">${vo.getFaqQuestion()}</p>
                      
                    </div>
                    <div class="cs_a">
                        <p class="cs_q_a">${vo.getFaqAnswer()}</p>
                    </div>
                </div>
                </c:forEach>
                <c:forEach items="${ vo }" var="vo">
                <div id="cs_box_n">
                    <div class="cs_n_title">
                      <p style="padding:10px;float:right;">${vo.getNoticeContent()}</p>
                    </div>
                    <div class="cs_n">
                        <p class="cs_n_n"></p>
                    </div>
                </div>
                </c:forEach>
                <div id="cs_box_email">
                    <div id="cs_e">
                    <br><br><br><br>
                        <p>1 대 1 문의사항은 아래의 이메일로 보내주시면</p><br><br>
                        <p>성실하게 답변 드리겠습니다</p><br><br>
                        <a href="mailto:ig476363@gmail.com">ig476363@gmail.com</a>
                      
                    </div>
                </div>
                

            </div>
        </div>
        </div>
    </div>
</body>
</html>