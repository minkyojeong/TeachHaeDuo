<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/common.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/icons/sun.ico" rel="shortcut icon" type="image/x-icon">
<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/findpw.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호찾기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


</head>
<body>
<div class="main_wrap">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap content">
            <section>
                <div id="PwFind">
                    <div class="modal">
                    
                        <div class="message_content">
                              <p class="modal_title">비밀번호 재설정 </p>                                                                     
	                               <div id="id_content">
	                               
	                               </div>
                               <div class="message_send">
								   	<button type="button" class="btn_close">닫기</button>
			                  </div>
                        </div>
                        
                    </div>
                    <div class="card align-middle" style="width:25rem;">        
                        <div>
                            <h2 class="card-title" style="color:#FA9D00;" >비밀번호 찾기</h2> 
                        </div>
                    <div class="card-body">
                        <input type="text" name="mId" id="mId" class="form-control" placeholder="아이디" required autofocus><br>
                        <input type="email" name="mEmail" id="mEmail" class="form-control"placeholder="이메일" required><br>
                            <p class="check" id="check">${check}</p><br />
                        <button id="btn-Yes"  class="form-control"   type="button">비밀번호 재설정</button><br>
                    </div>
                    <div class="links">
                        <a href="findId"  id="findId">&nbsp;아이디 찾기 &nbsp;|</a>  <a href="login"  id="login">&nbsp;로그인 &nbsp;</a>  <a href="join" id="join">| &nbsp; 회원가입</a>
                    </div>
                 </div>

                    <script type="text/javascript">
                     $("#btn-Yes").click(function(){
                    	 console.log("버튼 클릭");
                      $.ajax({
                          url:"findPw",
                          type:"post", 
                          data:{mId: $("#mId").val(),
                              mEmail: $("#mEmail").val(), },
                          success:function(result){
                            
                            console.log(result);
                              
                            if(result == "empty"){
                                 $("#id_content").html("<p>회원정보가 없습니다.</p>");
                                 location.href = "findpw.jsp";
                                 
                            } else if (result == "success"){
                                 $("#id_content").html("<p>임시 비밀번호가 메일로 전송 되었습니다. </p>");
                                   location.href = "login.jsp";
                                
                            } else{
                                 $("#id_content").html("<p>임시 비밀번호가 메일로 전송 실패되었습니다. </p>");
                                 location.href = "findpw.jsp";
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
                
                    $("#join").on("mousedown",function(){ // 마우스 버튼 누르면 
                    	console.log("mId mousedown");  
                    	event.preventDefault();  // 다른 이벤트가 발생하지 않게 함 
                    });
                    $("#findId").on("mousedown",function(){
                    	console.log("mId mousedown");
                    	event.preventDefault();
                    });
                    $("#login").on("mousedown",function(){
                    	console.log("mId mousedown");
                    	event.preventDefault();
                    });
                    
                    
                    $("#mId").on("blur",function(){
                    	console.log("mId blur");    
                        if($('#mId').val() == ""){
                                $('#check').text('아이디을 입력해주세요.');
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