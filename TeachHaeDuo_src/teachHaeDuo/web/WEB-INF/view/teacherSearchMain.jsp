<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/teacherSearchMain.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님찾기 메인</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
   <!-- 선생님찾기 메인 -->
    <div class="TSearch_main">
        <h1 class="intro_2">과외선생님 찾기</h1>
        <h5 class="intro_3">연결이 성사되어도 수수료가 없어요<br>
            연락 요청은 5건, 직접 연락은 3건까지 매월 이용할 수 있어요</h5>
    </div>
    <!-- 검색창 -->
    <div class="search_container">
        <span class="object_name">과목</span>
        <div class="object_input">
            <img src="images/search.png">
            <input type="text" name="object" placeholder="어느 과목 선생님을 찾으시나요?">
        </div>
        <button type="button" id="btn_search" class="btn3_1">검색</button>
    </div>

    <!-- 탭메뉴 -->
    <div class="main_teacher">
        <input id="tab1" type="radio" name="tabs" checked>
        <!--디폴트 메뉴-->
        <label for="tab1">통합</label>

        <input id="tab2" type="radio" name="tabs">
        <label for="tab2">국어</label>

        <input id="tab3" type="radio" name="tabs">
        <label for="tab3">수학</label>

        <input id="tab4" type="radio" name="tabs">
        <label for="tab4">영어</label>

        <input id="tab5" type="radio" name="tabs">
        <label for="tab5">사회</label>

        <input id="tab6" type="radio" name="tabs">
        <label for="tab6">과학</label>

        <input id="tab7" type="radio" name="tabs">
        <label for="tab7">기타</label>

        <!-- 선택사항 버튼들 -->
        <div class="choice_option">
            <select name="gender" id="gender">
                <option value="init">성별</option>
                <option value="m">남성</option>
                <option value="f">여성</option>
            </select>
            <select name="area" id="area_search">
                <option> 선생님 활동지역</option>
                <option> 강남구</option>
                <option> 도봉구</option>
                <option> 3</option>
                <option> 4</option>
                <option> 5</option>
                <option> 6</option>
                <option> 7</option>
            </select>
            <button type="button" id="btn_online"><img src="images/online.png">온라인 교습</button>
            <button type="button" id="btn_offline"><img src="images/offline.png">오프라인 교습</button>
            <button type="button" id="btn_call"><img src="images/smartphone.png">통화허용</button>
            <button type="button" id="btn_recruit"><img src="images/recruit.png">모집중</button>
            <button type="button" id="btn_like"><img src="images/like_color.png">찜</button>
        </div>

        <!-- 각 탭마다 프로필 -->
        <section id="content1">
            <div class="grid-init grid">
                <div class="list1">
                    <div class="profile"></div>
                    <p class="nickname">닉네임</p>
                </div>
                <div class="box-init box"><a href="#"></a>
                    <div class="title">
                        <h2>과목리스트</h2><br>
                        <ul>
                            <li>재학중인 학교 및 전공</li>
                            <li>활동지역</li>
                            <li>평점</li>
                        </ul>
                        </a>
                    </div>
                </div>
                <div class="box-init box">
                    <div class="list2">
                        <div class="profile"></div>
                        <p class="nickname">닉네임</p>

                    </div>
                </div>
                <div class="box-init box">
                    <div class="title">
                        <h2>과목리스트</h2><br>
                        <ul>
                            <li>재학중인 학교 및 전공</li>
                            <li>활동지역</li>
                            <li>평점</li>
                        </ul>
                    </div>
                </div>
                <div class="box-init box">
                    <div class="list3">
                        <div class="profile"></div>
                        <p class="nickname">닉네임</p>

                    </div>
                </div>
                <div class="box-init box">
                    <div class="title">
                        <h2>과목리스트</h2><br>
                        <ul>
                            <li>재학중인 학교 및 전공</li>
                            <li>활동지역</li>
                            <li>평점</li>
                        </ul>
                    </div>
                </div>
                <div class="box-init box">
                    <div class="list4">
                        <div class="profile"></div>
                        <p class="nickname">닉네임</p>
                    </div>
                </div>
                <div class="box-init box">
                    <div class="title">
                        <h2>과목리스트</h2><br>
                        <ul>
                            <li>재학중인 학교 및 전공</li>
                            <li>활동지역</li>
                            <li>평점</li>
                        </ul>
                    </div>
                </div>
                <div class="box-init box">
                    <div class="list5">
                        <div class="profile"></div>
                        <p class="nickname">닉네임</p>

                    </div>
                </div>
                <div class="box-init box">
                    <div class="title">
                        <h2>과목리스트</h2><br>
                        <ul>
                            <li>재학중인 학교 및 전공</li>
                            <li>활동지역</li>
                            <li>평점</li>
                        </ul>
                    </div>
                </div>

            </div>

        </section>


        <section id="content2">
            <p>tab menu2의 내용</p>
        </section>

        <section id="content3">
            <p>tab menu3의 내용</p>
        </section>

        <section id="content4">
            <p>tab menu4의 내용</p>
        </section>

        <section id="content5">
            <p>tab menu5의 내용</p>
        </section>

        <section id="content6">
            <p>tab menu6의 내용</p>
        </section>

        <section id="content7">
            <p>tab menu7의 내용</p>
        </section>

    </div>

    <!-- 페이징처리 -->
    <div class="page_wrap">
        <div class="page_nation">
            <a class="arrow prev" href="#"><img src="images/page_prev.png"></a>
            <a href="#" class="active">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a class="arrow next" href="#"><img src="images/page_next.png"></a>
        </div>
    </div>


    <!-- 활동지역검색 모달창 -->
    <!-- <div class="modal report">
            <div class="report_content">
                <p class="modal_title">신고하기</p>
                <div class="report_sel">
                    <span>신고사유 선택</span>
                    <select name="report_category" id="report_category">
                    </select>
                </div>
                <div class="report_input">
                    <p>신고 내용 입력</p>
                    <textarea cols="35" rows="10" name="report" placeholder="신고 내용을 입력해주세요."></textarea>
                </div>
                <div class="report_send">
                    <button id="btn_report_cancel">취소</button>
                    <button id="btn_report_send">신고</button>
                </div>
            </div>
        </div> -->

    <!-- 스크립트 -->
  <!--  <script>
        var main = function () {
            /* Push the body and the nav over by 285px over */
            var isOpened = false;

            $('.menu').on("mouseover", function () {
                clearInterval(walk_through);
            });

            $('.icon-menu').on("mouseover", function () {
                clearInterval(walk_through);
            });
            $('.icon-menu').click(function () {
                isOpened = true;

                $('.menu').animate({
                    left: "0px"
                }, 200);

                $('body').animate({
                    left: "285px"
                }, 200);
            });

            /* Then push them back */
            $('.icon-close').on("mouseover", function () {
                clearInterval(walk_through);
            });
            $('.icon-close').click(function () {
                isOpened = false;

                $('.menu').animate({
                    left: "-285px"
                }, 200);

                $('body').animate({
                    left: "0px"
                }, 200);
            });

            // Walkthrough the menu
            var walk_through = setInterval(function () {
                if (!isOpened) {
                    $('.icon-menu').trigger('click');
                }
                else if (isOpened) {
                    $('.icon-close').trigger('click');
                }
            }, 3000);
        };

        $(document).ready(main);
    </script>  --> 

</body>
</html>