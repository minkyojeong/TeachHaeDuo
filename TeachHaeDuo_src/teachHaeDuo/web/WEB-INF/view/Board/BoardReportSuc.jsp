<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.container{
		width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgb(174,174,174);
}
	
	.modal{
			background: #ddd;
			text-align:center;
			border: 1px solid rgb(174,174,174);
			border-radius:5px;
			width: 300px;
            height: 100px;
            position: relative;
            top: -100px;
            padding: 10px;
	}
	.modal>p{
	margin-top:20px;
	}
	.modal>button{
		width:50px;
		height:25px;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="modal">
			<p>신고가 완료됐습니다!</p>
			<button type="submit" onclick="location.href='BoardList'">확인</button>
		</div>
	</div>
</body>
</html>