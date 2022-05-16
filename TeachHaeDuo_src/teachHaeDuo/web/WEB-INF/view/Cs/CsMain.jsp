
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="kh.semi.thduo.admin.vo.AdminVo"%>
    <link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link href="<%=request.getContextPath()%>/resources/css/header.css"
rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<style>
.cs_container{
    width:100%;
	text-align:center;
	height:100%;
    
    
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
    font-weight:550;
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
    height:300px;
    border-radius:5px;
    border:1px solid rgb(165, 165, 165);
    position:relative;
    margin-bottom:30px;
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
    height:100px;;
    margin: 0 auto;
    display:block;
    border-bottom: 1px solid rgb(174,174,174);
}
.cs_q_q{
font-weight:500;
margin-top:30px;
    float:left;
    padding:10px;
    font-size: 25px;
}
.cs_a{
   width:1000px;
    height:200px;;
    margin: 0 auto;
}
.cs_q_a{
margin-top:20px;
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
.CsDiv{
    width:900px;
    height:50px;
    margin:10px;
    border-radius:5px;
    border:2px solid rgb(165, 165, 165);
    position:relative;
    text-align: center;
    background:#FA9D00;
    line-decoration:none;
    padding-top:30px;
}
.CsDiv>a{
color:black;
font-size: 30px;
}
.CsDiv:hover{
background:
#e49103;
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
                
            </div>
            <div class="cs_body" id="cs_body">
            <div class="CsDiv" onclick="location.href='CsNoticeMain'" style="cursor:pointer;">
            <a href="CsNoticeMain">공지사항</a>
            </div>
            <div class="CsDiv" onclick="location.href='CsFaqMain'" style="cursor:pointer;">
            <a href="CsFaqMain">자주 묻는 질문</a>
            </div>
            <div class="CsDiv" onclick="location.href='${pageContext.request.contextPath}/CsOne.jsp'" style="cursor:pointer;">
           	<a href="${pageContext.request.contextPath}/CsOne.jsp">1 대 1 문의</a> 
            </div>
            </div>
        </div>
        </div>
    </div>
</body>
</html>