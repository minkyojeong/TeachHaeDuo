<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/findid.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</head>
<body> 

<div class="main_wrap">
         <jsp:include page="../template_header.jsp"></jsp:include>
          <div class="wrap content">
            <section>
                <div id="IdFind">
                    <div class="modal">
                        <div class="message_content">
                             <p class="modal_title">아이디 찾기</p> 
                                 <div id="id_content">
	                                
                                 </div>
                                 <div class="message_send">
									   <button type="button" class="btn_close">닫기</button>
				                 </div>
                        </div>
                    </div>
                    <div class="card align-middle" style="width:25rem;">
                        <div>
                            <p class="card-title" style="color:#FA9D00;">아이디 찾기</p> 
                        </div>
                        <div class="card-body">
                            <input type="text" name="mName" id="mName" class="form-control" placeholder="이름" required autofocus><br>
                            <input type="email" name="mEmail" id="mEmail" class="form-control" placeholder="이메일" required><br>
                                <p class="check" id="check">${check}</p><br/>
                            <button id="btn-Yes" class="form-control type="button">아이디찾기</button>
                        </div>
                        <div class="links">
                            <a href="findPw" id="findPw">&nbsp;비밀번호 찾기 &nbsp;|</a>  <a href="login" id="login">&nbsp;로그인 &nbsp;</a>  <a href="join" id="join" >| &nbsp; 회원가입</a>
                        </div>
                    </div>
                    
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
                                    $("#id_content").html("<p>회원님의 아이디는" +result+ "입니다.</p>");
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
                        
                        $("#join").on("mousedown",function(){
                        	console.log("mId mousedown");
                        	event.preventDefault();
                        });
                        
                        $("#findPw").on("mousedown",function(){
                        	console.log("mId mousedown");
                        	event.preventDefault();
                        });
                        $("#login").on("mousedown",function(){
                        	console.log("mId mousedown");
                        	event.preventDefault();
                        });
                        
                                        
                        $("#mName").on("blur",function(){
                        	console.log("mName blur"); 
                        if($('#mName').val() == ""){
                                $('#check').text('이름을 입력해주세요.');
                                $('#check').css('color', 'red');
                        
                            }else{
                                $('#check').hide();
                            }
                            });
                            
                            $("#mEmail").on("blur",function(){
                            	console.log("mEmail blur"); 
                            if($('#mEmail').val() == ""){
                                $('#check').text('이메일을 입력해주세요');
                                    $('#check').css('color', 'red');
                            }else{
                                $('#check').hide();
                            }
                            });     
                    </script>
                </div>
            </section>
          </div>
         <jsp:include page="../template_footer.jsp"></jsp:include>
      </div>    
  
</body>
</html>