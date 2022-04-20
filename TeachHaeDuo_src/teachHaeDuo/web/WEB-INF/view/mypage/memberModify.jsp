
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mypage_modifymember</title>
    <style>
        *{
            font-family: MinSans, serif;
        }
        p{
            font-weight: bold;
        }
        #mm_top_div{
            text-align: center;
             margin-top: 20px;
        }
        #mm_middle_div{
            margin: 20px 0px 50px 0px;
        }
        #mm_low_div{
            text-align: center;
        }
        table{
            border-spacing: 20px 20px;
            margin: 0 auto;
            border-collapse: separate;
        }
    </style>
</head>
<body>
    <div id="mm_main_wrap">
        <form action="#" method="post">
            <div id="mm_top_div">
                <p style="font-size:17px"><회원정보수정></p>
            </div>
            <div id="mm_middle_div">
                <table>
                    <tr>
                        <td>
                            아이디
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            비밀번호
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            <input type="password">
                        </td>
                    </tr>
                </table>
            </div>
            <div id="mm_low_div">
                <button class="btn2_2" type="submit">로그인</button>
                <button class="btn2_2">취소</button>
            </div>
        </form>
    </div>
    
</body>
</html>