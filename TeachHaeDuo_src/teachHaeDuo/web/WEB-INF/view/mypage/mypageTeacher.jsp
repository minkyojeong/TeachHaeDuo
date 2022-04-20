<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>mypage_Teacher</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        *{
            font-family: MinSans sans-serif;
        }
        p{
            font-weight: bold;
        }
        a:link{color:black}
        a:visited {color: black;}
       
        #mt_main_wrap{
            width:1200px;
            display: flex;
            margin:0 auto;
        }
        #mt_left_div{
            width:70%;
            
        }
        #mt_right_div{
            width:30%;
        }
        #mt_top_div{
            display: flex;
            margin:50px 50px 50px 50px;
        }
        #mt_profile_div{
            display: flex;
        }
        .mt_nickname_div{
            padding: 10px 0px;
        }
        .mt_pencil_div{
            display: flex;
            padding: 10px 0px;
            justify-content: space-between;
        }
        #mt_bottom_div{
            margin-top: 50px;
        }
        .mt_arrow,.mt_arrow_active{
            width:20px;
            height:20px;
            margin: 0 10px;
        }
        .mt_text_div{
            width:50%;
            margin:20px;
            display:flex;
            justify-content: space-between;
        }
        .mt_arrow_active{
            display: none;
        }
    </style>
     <!-- 스위치 버튼 -->
     <style>
        .mt_switch {
            position: relative;
            display: inline-block;
            width: 50px;
            height: 20px;
            vertical-align:middle;
        }

        .mt_switch input {display:none;}

        .mt_slider {
        position: absolute;
        cursor: pointer;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background-color: #ccc;
        -webkit-transition: .4s;
        transition: .4s;
        }

        .mt_slider:before {
        position: absolute;
        content: "";
        height: 13px;
        width: 13px;
        left: 4px;
        bottom: 4px;
        background-color: white;
        -webkit-transition: .4s;
        transition: .4s;
        }

        input:checked + .mt_slider {
        background-color: #2196F3;
        }

        input:focus + .mt_slider {
        box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .mt_slider:before {
        -webkit-transform: translateX(28px);
        -ms-transform: translateX(28px);
        transform: translateX(28px);
        }

        /* Rounded sliders */
        .mt_slider.mt_round {
        border-radius: 34px;
        }

        .mt_slider.mt_round:before {
        border-radius: 50%;
        }

        .mt_toggle_p {
            margin:0px;
            display:inline-block;
            font-size:15px;
            font-weight:bold;
        }
    </style>
    <script>
        $(function(){
            var check = $("input[type='checkbox']");
                check.click(function(){
                    $(".mt_toggle_p").toggle();
            });
            $("#mt_text_div1").mouseover(function(){
                $("#mt_arrow_active1").show();
                $("#mt_arrow1").hide();
            });
            $("#mt_text_div1").mouseout(function(){
                $("#mt_arrow_active1").hide();
                $("#mt_arrow1").show();
            });
            $("#mt_text_div2").mouseover(function(){
                $("#mt_arrow_active2").show();
                $("#mt_arrow2").hide();
            });
            $("#mt_text_div2").mouseout(function(){
                $("#mt_arrow_active2").hide();
                $("#mt_arrow2").show();
            });
            $("#mt_text_div3").mouseover(function(){
                $("#mt_arrow_active3").show();
                $("#mt_arrow3").hide();
            });
            $("#mt_text_div3").mouseout(function(){
                $("#mt_arrow_active3").hide();
                $("#mt_arrow3").show();
            });
         
        });
    </script>
</head>
<body>
    <div id="mt_main_wrap">
        <div id="mt_left_div">
            <div id="mt_top_div">
                <div id="mt_profile_div" style="width:50%">
                    <div style="width:40%">
                        <img src="./images/profile.png" width="100" height="100">
                    </div>
                    <div style="width:60%">
                        <div class="mt_nickname_div">
                            <p>[닉네임]</p>
                        </div>
                        <div class="mt_nickname_div">
                            <p>[이름]</p>
                        </div>
                        <div class="mt_nickname_div">
                            <button class="btn2_2">프로필사진 수정</button>
                        </div>
                    </div>
                </div>
                <div style="width:50%">
                    <div class="mt_pencil_div">
                        <div style="display:flex;">
                            <img src="./images/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p>잔여 연필</p>
                        </div>
                        <div>
                            <a href="#"><p>0원</p></a>
                        </div>
                    </div>
                    <div class="mt_pencil_div">
                        <div style="display:flex;">
                            <img src="./images/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p>연필 충전</p>
                        </div>
                        <div>
                            <a href="#"><p>충전하기</p></a>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div id="mt_bottom_div">
                <div class="mt_text_div" id="mt_text_div1">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow1" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active1" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">수강생 모집 여부</p>
                    </div>
                    <div>
                        <p class="mt_toggle_p">OFF</p><p class="mt_toggle_p" style="display:none;">ON </p>
                        <label class="mt_switch">
                        <input type="checkbox">
                        <span class="mt_slider mt_round"></span>
                        </label>
                    </div>
                </div>
                <div class="mt_text_div" id="mt_text_div2">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <a href="#">이번 달 0건</a>
                    </div>
                </div>
                <div class="mt_text_div" id="mt_text_div3">
                    <div style="display:flex">
                        <img class="mt_arrow" id="mt_arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="mt_arrow_active" id="mt_arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="mt_text_div_p">내가 찜한 선생님</p>
                    </div>
                    <a href="#">총 0건</a>
                </div>
            </div>
        </div>
        <div id="mt_right_div">
            <div style="margin:50px">
                <button class="btn1_2" onclick="location.href='memberModify'">회원 정보 수정</button>
            </div>
            <div style="margin:50px">
                <button class="btn1_2">교습 정보 수정</button>
            </div>

        </div>
    </div>
</body>
</html>