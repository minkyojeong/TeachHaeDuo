<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	     .modal {
            display: none;
            position: fixed; top: 0; left: 0; 
            width: 100%; height: 100%;
            z-index: 1;
            background-color: rgba(128, 128, 128, .9);
        }
        .modal > .modal_content {
            position: relative;  top:100px;
            margin: auto;
            width: 200px;
            background-color: white;
            padding: 20px;
        }
</style>

</head>
<body>
       <div class="modal">
      	<div class="modal_content">
      	        <div class="btn_close"><button>&#9932;</button></div>
                <div id="id_content"> </div>
      	</div>
      </div>
<!-- 	<form action="findId" class="form-signin" method="POST"> -->
	     <h3>아이디찾기</h3> <br>
  		 <p class="text2"> ${findid2}</p>
        <input type="text" name="mName" id="mName" class="form-control" placeholder="이름" required autofocus><BR>
        <input type="email" name="mEmail" id="mEmail" class="form-control" placeholder="이메일" required><br>
        	<p class="check" id="check">${check}</p><br/>
        <button id="btn-Yes" class="btn btn-lg btn-primary btn-block" type="button">아이디찾기</button>
     
<!--       </form> -->

  <script type="text/javascript">
  $("#btn-Yes").click(function(){
	  $.ajax({
		  url:"findId",
		  type:"post",
		  data:{mName: $("#mName").val(),
			  mEmail: $("#mEmail").val(), },
		  success:function(result){
			 if(result == ""){
				  //
			     $("#id_content").html("<p>찾는 아이디가 없습니다.</p>");
			} else{
				 $("#id_content").html("<p>당신의 아이디는 "+result+"입니다.</p>");
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