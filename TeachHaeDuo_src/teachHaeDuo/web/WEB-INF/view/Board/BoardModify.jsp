    <link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kh.semi.thduo.board.vo.BoardVo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>

<style>
.container{
width:100%;
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
float:left;
}
.board_title>h1{
font-weight:600;
	font-size:25px;
	}

</style>
</head>
<body>
<%
			BoardVo vo = (BoardVo)request.getAttribute("bvo");
			if(vo!=null){
		%>
	<div class="container">
	<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="board_title">
				
		</div>
		<div class="wrap_container">
      		<form action="BoardUpdate" method="post" >
      			<input type="text" name="bNo" value="<%= vo.getbNo() %>" style="display:none;">
      			<input type="text" name="bTitle" maxlength="100" required placeholder="제목" style="width:900px; height:30px;float:left;margin-right:10px;" value="<%= vo.getbTitle() %>">
       			<select name="bCategory" style="width:190px; height:30px;margin-bottom:10px;float:right;">
        			<option>질문하기</option>
        		</select>
            	<textarea name="editor1" id="editor1" rows="10" cols="80" style="width:1100px;height:300px;resize:none;" placeholder="여기에 작성하세요." maxlength="2048">               
            	<%= vo.getbContent() %>
            	</textarea>
            	<script>
            	CKEDITOR.replace('editor1');
            	</script>
            	<div style="text-align:center">
            		<button type="submit" style="width:50px;height:25px; text-align:center; margin-left:5px;margin-top:10px;">제출</button>
            		<button type="button" onclick="location.href='BoardList'" style="width:50px;height:25px; text-align:center; margin-top:10px;">취소</button>
            	</div>
        	</form>
       </div>
	</div>
	<%
			}
	%>
</body>
</html>