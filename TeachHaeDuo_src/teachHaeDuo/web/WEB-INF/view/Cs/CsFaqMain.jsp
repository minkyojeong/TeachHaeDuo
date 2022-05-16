
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
<title>자주 묻는 질문</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>

        $(document).ready(function() {
     $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option1') {
         $('#cs_box_q').show();
         $('#cs_body').show();
         $('#questionBoard').show();
         $('#FaqDel').show();
       } else {
         $('#cs_box_q').hide();
         $('#questionBoard').hide();
         $('#FaqDel').hide();
         $('#cs_body').hide();
       }
     }); 
   }); 
      $(document).ready(function() {
        $('#cs_select_option').change(function() {
       var result = $('#cs_select_option option:selected').val();
       if (result == 'option2') {
         $('#cs_box_n').show();
         $('#questionBoard1').show();
         $('#NoticeDel').show();
       } else {
         $('#cs_box_n').hide();
         $('#questionBoard1').hide();
         $('#NoticeDel').hide();
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
body {
	width: 1600px;
	box-sizing: border-box;
	margin: 0 auto;
}

.wrap.content {
	width: 1280px;
	
}

a {
    text-decoration: none;
}
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
    margin-bottom:100px;
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
<%
					    AdminVo ssvo = (AdminVo)session.getAttribute("ssMV");
						%>
	 <div class="cs_container">
	 <jsp:include page="../template_header.jsp"></jsp:include>
	 <div class="wrap.content">
            <div class="cs_body_all">
            	<div class="cs_title">
               	 	<h1>자주 묻는 질문</h1>
           	 	</div>
	            <div class="cs_select">
	                
	            </div>
            <%
                if(ssvo != null){
                %>
	            <div class="write" id="questionBoard" onclick = "location.href='CsFaqWrite'">
					<a href="CsFaqWrite" id="question">자주묻는 질문 글 쓰기</a>
				</div>
			    <%
                }
                    %>
	            <div class="cs_body" id="cs_body">
	            	<c:forEach items="${ csvo }" var="cvo">
	                <div id="cs_box_q">
	                <%
	                if(ssvo != null){
	                %>
	                <button type="button" class="bt" id="FaqDel" onclick="location.href='CsFaqDelete'">삭제</button>
	                    <%
	                }
	                    %>
	                    <div class="cs_q">
	                        <p class="cs_q_q">${cvo.getFaqQuestion()}</p>
	                      	  <p style="float:right;margin-top:30px;font-size:25px;">No.${cvo.getFaqNo()}</p>
	                    </div>
	                    <div class="cs_a">
	                        <p class="cs_q_a">${cvo.getFaqAnswer()}</p>
	                    </div>
	                </div>
	                </c:forEach>
	                
	             </div>
	                <p>
						<c:if test="${    startPage    >    1    }">
						<a href="CsFaqMain?page=${startPage-1 }">이전</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:if>
						<c:forEach begin="${startPage }" end="${endPage }" var="p">
							<a href="CsFaqMain?page=${p }">${p }</a>&nbsp;&nbsp;&nbsp;&nbsp;
						</c:forEach>
						<c:if test="${endPage < totalPageCnt }">
						<a href="CsFaqMain?page=${endPage+1 }">다음</a>
						</c:if>
					</p>
        </div>
    </div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
    </div>
</body>
</html>