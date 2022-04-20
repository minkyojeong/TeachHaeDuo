<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_Student</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        *{
            font-family: MinSans, serif;
        }
        p{
            font-weight: bold;
        }
        a:link{color:black}
        a:visited {color: black;}
    
        #ms_main_wrap{
            width:1200px;
            display: flex;
            margin:0 auto;
        }
        #ms_left_div{
            width:70%;
            
        }
        #ms_right_div{
            width:30%;
        }
        #ms_top_div{
            display: flex;
            margin:50px 50px 50px 50px;
        }
        #ms_profile_div{
            display: flex;
        }
        .ms_nickname_div{
            padding: 10px 0px;
        }
        .ms_pencil_div{
            display: flex;
            padding: 10px 0px;
            justify-content: space-between;
        }
        #ms_bottom_div{
            margin-top: 50px;
        }
        .ms_arrow,.ms_arrow_active{
            width:20px;
            height:20px;
            margin: 0 10px;
        }
        .ms_text_div{
            width:50%;
            margin:20px;
            display:flex;
            justify-content: space-between;
        }
        .ms_arrow_active{
            display: none;
        }
    </style>
    <!-- 스위치 버튼 -->
    <style>
        .ms_switch {
            position: relative;
            display: inline-block;
            width: 50px;
            height: 20px;
            vertical-align:middle;
        }

        .ms_switch input {display:none;}

        .ms_slider {
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

        .ms_slider:before {
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

        input:checked + .ms_slider {
        background-color: #2196F3;
        }

        input:focus + .ms_slider {
        box-shadow: 0 0 1px #2196F3;
        }

        input:checked + .ms_slider:before {
        -webkit-transform: translateX(28px);
        -ms-transform: translateX(28px);
        transform: translateX(28px);
        }

        /* Rounded sliders */
        .ms_slider.ms_round {
        border-radius: 34px;
        }

        .ms_slider.ms_round:before {
        border-radius: 50%;
        }

        .ms_toggle_p {
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
                    $(".ms_toggle_p").toggle();
            });
            $("#ms_text_div1").mouseover(function(){
                $("#ms_arrow_active1").show();
                $("#ms_arrow1").hide();
            });
            $("#ms_text_div1").mouseout(function(){
                $("#ms_arrow_active1").hide();
                $("#ms_arrow1").show();
            });
            $("#ms_text_div2").mouseover(function(){
                $("#ms_arrow_active2").show();
                $("#ms_arrow2").hide();
            });
            $("#ms_text_div2").mouseout(function(){
                $("#ms_arrow_active2").hide();
                $("#ms_arrow2").show();
            });
            $("#ms_text_div3").mouseover(function(){
                $("#ms_arrow_active3").show();
                $("#ms_arrow3").hide();
            });
            $("#ms_text_div3").mouseout(function(){
                $("#ms_arrow_active3").hide();
                $("#ms_arrow3").show();
            });
         
        });
    </script>
</head>
<body>
    <div id="ms_main_wrap">
        <div id="ms_left_div">
            <div id="ms_top_div">
                <div id="ms_profile_div" style="width:50%">
                    <div style="width:40%">
                        <img src="./images/profile.png" width="100" height="100">
                    </div>
                    <div style="width:60%">
                        <div class="ms_nickname_div">
                            <p>[닉네임]</p>
                        </div>
                        <div class="ms_nickname_div">
                            <p>[이름]</p>
                        </div>
                    </div>
                </div>
                <div style="width:50%">
                    <div class="ms_pencil_div">
                        <div style="display:flex;">
                            <img src="./images/pencil.png" width="25" height="25" style="margin-right:10px">
                            <p>잔여 연필</p>
                        </div>
                        <div>
                            <a href="#"><p>0원</p></a>
                        </div>
                    </div>
                    <div class="ms_pencil_div">
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
            <div id="ms_bottom_div">
                <div class="ms_text_div" id="ms_text_div1">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow1" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active1" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">알람 수신거부 여부</p>
                    </div>
                    <div>
                        <p class="ms_toggle_p">OFF</p><p class="ms_toggle_p" style="display:none;">ON </p>
                        <label class="ms_switch">
                        <input type="checkbox">
                        <span class="ms_slider ms_round"></span>
                        </label>
                    </div>
                </div>
                <div class="ms_text_div" id="ms_text_div2">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow2" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active2" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">연락 요청 보낸 내역</p>
                    </div>
                    <div>
                    <a href="#">이번 달 0건</a>
                    </div>
                </div>
                <div class="ms_text_div" id="ms_text_div3">
                    <div style="display:flex">
                        <img class="ms_arrow" id="ms_arrow3" src="${pageContext.request.contextPath}/resources/icons/arrow_normal.png">
                        <img class="ms_arrow_active" id="ms_arrow_active3" src="${pageContext.request.contextPath}/resources/icons/arrow_active.png">
                        <p class="ms_text_div_p">내가 찜한 선생님</p>
                    </div>
                    <a href="#">총 0건</a>
                </div>
            </div>
        </div>
        <div id="ms_right_div">
            <div style="margin:50px">
                <button class="btn1_2" onclick="location.href='memberModify'">회원 정보 수정</button>
            </div>
            

        </div>
    </div>
</body>
</html>