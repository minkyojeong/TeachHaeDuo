<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
<script src="//cdn.ckeditor.com/4.18.0/standard/ckeditor.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<title>Insert title here</title>
<script>


</script>
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
}
.board_title>h1{
font-weight:600;
	font-size:25px;
	}

</style>
</head>
<body>
	<div class="container">
		<div class="board_title">
				<h1>질문하기 게시판</h1>
		</div>
		<div class="wrap_container">
      		<form action="BoardWriteDo" method="post" >
      			<input type="text" name="bTitle" maxlength="100" required placeholder="제목" style="width:900px; height:25px;float:left;margin-right:10px;">
       			<select name="bCategory" style="width:100px; height:30px;margin-bottom:10px;">
       				<option>게시판 선택</option>
        			<option>학습 질문하기</option>
        			<option>자유게시판</option>
        		</select>
            	<textarea name="editor1" id="editor1" rows="10" cols="80" placeholder="여기에 작성하세요." maxlength="2048">               
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
</body>
</html>