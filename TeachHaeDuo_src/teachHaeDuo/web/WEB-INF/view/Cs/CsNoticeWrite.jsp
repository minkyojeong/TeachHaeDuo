<link href="<%=request.getContextPath()%>/resources/css/header.css"
rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
 
    <style>
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
    height:50px;;
    margin: 0 auto;
    display:block;
    
}
.cs_q_q{
    float:left;
    padding:10px;
    font-size: 20px;
    height:25px;
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
    height:220px;
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
	 <jsp:include page="../template_header.jsp"></jsp:include>
        <div class="cs_section">
            <div class="cs_body_all">
            <div class="cs_title">
                <h1>고객센터</h1>
            </div>
            <div class="cs_body">
            <form action="CsFaqWrite" method="get">
                <div id="cs_box_q">
                    <div class="cs_q">
                        <textarea name="cs_q_q"class="cs_q_q" placeholder="제목 작성"></textarea>
                    </div>
                     <div class="cs_a">
                        <textarea name="cs_q_a" class="cs_q_a"placeholder="공지사항 작성"></textarea>
                    </div>
                </div>
                <button id="bt1"type="submit" onclick="location.href='CsNoticeWriteDo'">글 등록</button>
                <button id="bt2"type="submit" onclick="location.href='CsMain'">취소</button>
                </form>
            </div>
        </div>
        </div>
    </div>
</body>
</html>