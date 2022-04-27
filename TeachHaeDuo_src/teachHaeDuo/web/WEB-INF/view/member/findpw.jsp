<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
.modal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 1;
	background-color: rgba(128, 128, 128, .9);
}

.modal>.modal_content {
	position: relative;
	top: 100px;
	margin: auto;
	width: 200px;
	background-color: white;
	padding: 20px;
}
</style>

</head>
<body>
<div class="main_wrap">
	<jsp:include page="../template_header.jsp"></jsp:include>
</div>

	<!--  <form action="findPw" class="" method="POST"> -->
	<h3>비밀번호 찾기</h3>
	<br>
	<p class="text2">${findPw2}</p>
	<input type="text" name="mId" id="mId" class="" placeholder="아이디"
		required autofocus>
	<BR>
	<input type="email" name="mEmail" id="mEmail" class=""
		placeholder="이메일" required>
	<br>
	<p class="check" id="check">${check}</p>
	<br />
	<button id="btn-Yes" class="btn btn-lg btn-primary btn-block"
		type="button">비밀번호 재설정</button>

	<div class="modal">
		<div class="modal_content">
			<div class="btn_close">
				<button>&#9932;</button>
			</div>
			<div id="id_content"></div>
		</div>
	</div>



	<script type="text/javascript">
 
 	$("#btn-Yes").click(function(){
	  $.ajax({
		  url:"/findPw",
		  type:"post",
		  data:{mId: $("#mId").val(),
			  mEmail: $("#mEmail").val(), },
		  success:function(result){
			
			console.log(result);
			  
			if(result == "empty"){
			     $("#id_content").html("<p>회원정보가 없습니다.</p>  비밀번호 찾기");
			} else if (result == "success"){
				 $("#id_content").html("<p>임시 비밀번호가 메일로 전송 되었습니다. </p> 로그인 페이지 이동");
				 
			} else{
				 $("#id_content").html("<p>임시 비밀번호가 메일로 전송 실패되었습니다. </p>  비밀번호 찾기 페이지");
			}
			  $(".modal").show();
		  },
		  error:function(){
			  
		  }		  
	  });
	});
 		  
	$(".btn_close").on("click", function(){
	    $(".modal").hide();
	});
	  
	 
	$(".modal").on("click", function(){
	      console.log(event.target);
	      // console.log(this.event.target);
	      if(event.target == $(".modal")[0]){
	          $(".modal").hide();
	      }
	});

	$("#mId").focusout(function(){
				
		if($('#mId').val() == ""){
				$('#check').text('아이디을 입력해주세요.');
			  	$('#check').css('color', 'red');
		}else{
			 $('#check').hide();
		}
	});
		
	$("#mEmail").focusout(function(){
		if($('#mEmail').val() == ""){
				$('#check').text('이메일을 입력해주세요');
			  	$('#check').css('color', 'red');
		}else{
			 $('#check').hide();
		}
	});

</script>

    <div class="line">
	  <hr>
	</div>
         <jsp:include page="../template_footer.jsp"></jsp:include>
</body>
</html>