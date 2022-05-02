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
                        <div class="modal_content">
                            <div class="btn_close"><button>닫기</button></div>
                               <div id="id_content">
                               
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
                        <button id="btn-Yes"  class="form-control   type="button">비밀번호 재설정</button><br>
                    </div>
                    <div class="links">
                        <a href="findId">&nbsp;아이디 찾기 &nbsp;|</a>  <a href="login">&nbsp;로그인 &nbsp;</a>  <a href="join">| &nbsp; 회원가입</a>
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


                </div>
            </section>
		</div>
		<jsp:include page="../template_footer.jsp"></jsp:include>
		
	</div>
</body>
</html>