<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        })
        $(document).ready(function() {
     $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option1') {
         $('#cs_box_q').show();
       } else {
         $('#cs_box_q').hide();
       }
     }); 
   }); 
      $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option2') {
         $('#cs_box_n').show();
       } else {
         $('#cs_box_n').hide();
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
}
#cs_box_q{
    width:1100px;
    height:200px;
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
    width:1100px;
    height:50%;
    margin: 0 auto;
    display:block;
}
.cs_q_q{
    float:left;
    padding:10px;
    font-size: 20px;
}
.cs_a{
    width:1100px;
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
#cs_e{
    margin:100px;
    font-size: 25px;
}
.cs_body_all{
    position:relative;
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
                <select id="cs_select_option">
                    <option value="option4">카테고리 선택</option>
                    <option value="option1">자주 묻는 질문</option>
                    <option value="option2">공지사항</option>
                    <option value="option3">1대1 문의</option>
                </select>
            </div>
            <div class="cs_body">
                <div id="cs_box_q">
                    <div class="cs_q">
                        <p class="cs_q_q">Q. 자주 묻는 질문은 무엇이 있나요?</p>
                      
                    </div>
                    <div class="cs_a">
                        <p class="cs_q_a">A. 궁금해하시는 것들이 있습니다.</p>
                    </div>
                </div>
                <div id="cs_box_n">
                    <div class="cs_n_title">
                      <p style="padding:10px;float:right;">고정(추후 아이콘처리)</p>
                    </div>
                    <div class="cs_n">
                        <p class="cs_n_n"></p>
                    </div>
                </div>
                <div id="cs_box_email">
                    <div id="cs_e">
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