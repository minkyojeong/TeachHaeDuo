<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 
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
textarea{
margin-top:35px;
	width:950px;
	height:100px;
}
#bt1{
margin-top:20px;
margin-left:480px;
width:60px;
height:30px;
}
#bt2{
margin-top:20px;
margin-left:10px;
width:60px;
height:30px;
}
    </style>
</head>
<body>
	 <div class="cs_container">
        <div class="cs_section">
            <div class="cs_body_all">
            <div class="cs_title">
                <h1>고객센터</h1>
            </div>
            <div class="cs_select">
            </div>
            
            <div class="cs_body">
            <form action="CsFaqWrite" method="get">
                <div id="cs_box_q">
                    <div class="cs_q">
                        <textarea name="cs_q_q"class="cs_q_q" placeholder="질문 작성"></textarea>
                    </div>
                    <div class="cs_a">
                        <textarea name="cs_q_a" class="cs_q_a"placeholder="답변 작성"></textarea>
                    </div>
                </div>
                <button id="bt1"type="submit" onclick="location.href='CsFaqWrite'">글 등록</button>
                <button id="bt2"type="submit" onclick="location.href='CsMain'">취소</button>
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
</html>