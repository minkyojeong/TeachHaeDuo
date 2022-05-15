<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css"
rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
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
}
.cs_body{
    width:1100px;
    position:relative;
    margin: 0 auto;
    margin-top:20px;
    margin-bottom:100px;
}
.cs_title{
    width:1100px;
    height:100px;
    display:block; 
    position:relative;
    margin: 0 auto;
}
h1{
    margin-top:50px;
    font-size:30px;
    float:left;
}
.cs_select{
    width:1100px;
    height:50px;
    position:relative;
    margin: 0 auto;
}
#cs_e{
font-size:20px;
}
</style>
</head>
<body>
 <div class="cs_container">
	 <jsp:include page="WEB-INF/view/template_header.jsp"></jsp:include>
	 <div class="cs_title">
                <h1>1 대 1 문의</h1>
            </div>
         
            <div class="cs_body" id="cs_body">
			<div id="cs_box_email">
                    <div id="cs_e">
                    <br><br><br>
                        <p>1 대 1 문의사항은 아래의 이메일로 보내주시면</p><br><br>
                        <p>성실하게 답변 드리겠습니다</p><br><br>
                        <a href="mailto:ig476363@gmail.com">ig476363@gmail.com</a>
                      
                    </div>
                </div>
                </div>
                <jsp:include page="WEB-INF/view/template_footer.jsp"></jsp:include>
              </div>
</body>
</html>