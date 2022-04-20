<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>


</head>
<body>
  
	<form action="findId" class="form-signin" method="POST">
	     <h3>아이디찾기</h3> <br>
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="mName" id="mName" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="mEmail" id="mEmail" class="form-control" placeholder="이메일" required><br>
        	<p class="check" id="check">${check}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="submit">아이디찾기</button>
     
      </form>
      
  <script type="text/javascript">
		  		  
  		$("#mName").focusout(function(){
  			
	     if($('#mName').val() == ""){
	   		$('#check').text('이름을 입력해주세요.');
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


</body>
</html>