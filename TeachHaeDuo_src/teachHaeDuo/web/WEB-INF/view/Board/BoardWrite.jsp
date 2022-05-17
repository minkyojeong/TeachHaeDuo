    <link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
         <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
<script>

</script>
<style>

.container{
width:100%;
height:100%;
text-align:center;
}
.wrap_container{
margin-top:50px;
display:inline-block;
width:1100px;

}
.board_title{
margin-top:50px;
width:1100px;
}
.board_title>h1{
float:left;
font-weight:600;
	font-size:25px;
	}
textarea{width:500px; height:100px; 
 resize:none;
/*   resize: horizontal; */

}
</style>
</head>
<body>
	<div class="container">
	<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap_container">
      		<form action="BoardWriteDo" method="post" >
      		<div style="height:35px; margin-bottom:10px;">
      			<input type="text" name="bTitle" maxlength="100" required placeholder="제목" style="width:900px; height:30px;float:left;margin-right:10px;">
       			<select name="bCategory" style="width:190px; height:30px;margin-bottom:10px; float:right;">
        			<option>학습 질문하기</option>
        			<option>자유게시판</option>
        		</select>
        	</div>
            	<textarea name="editor1" id="editor1" rows="10" cols="80" style="width:1100px;height:300px;margin-top:20px;" placeholder="여기에 작성하세요." maxlength="2048">               
            	</textarea>
            	<script>
            	CKEDITOR.replace('editor1',{
            		width : '1100px',
            	      height : '300px',  // 입력창의 높이
            	      startupFocus : false
            	});
            	</script>
            	<div style="text-align:center">
            		<button type="submit" style="width:50px;height:25px; text-align:center; margin-left:5px;margin-top:10px;">제출</button>
            		<button type="button" onclick="location.href='BoardList'" style="width:50px;height:25px; text-align:center; margin-top:10px;">취소</button>
            	</div>
        	</form>
        	
       </div>
	</div>
</body>
</html>