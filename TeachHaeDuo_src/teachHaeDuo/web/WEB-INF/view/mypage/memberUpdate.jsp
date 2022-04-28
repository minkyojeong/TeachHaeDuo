<%@page import="kh.semi.thduo.member.vo.MemberVo"%>
<link href="<%=request.getContextPath()%>/resources/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/resources/css/button.css"
	rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/css/mypageUpdate.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/header.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>mypage_modifymember</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<div>
	<jsp:include page="../template_header.jsp"></jsp:include>
    <div id="main_wrap">
        <form action="#" method="post">
            <div id="top_div">
                <p style="font-size:17px"><회원정보수정></p>
            </div>
            <div id="middle_div">
                <table>
                    <tr>
                        <td>
                            아이디
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
							<% MemberVo ssMV = (MemberVo)request.getSession().getAttribute("ssMV"); %>
							<%= ssMV.getmId() %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            주소변경
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
                            <input type="text">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            닉네임 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            <input name="mNickname" type="text" placeholder="<%= ssMV.getmNickname()%>">
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            휴대폰 번호 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td colspan="2">
                            <input name="mPhone" type="text" placeholder="<%= ssMV.getmPhone()%>">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            이메일 변경
                        </td>
                        <td>
                            :
                        </td>
                        <td>
                            <input name="mEmail" type="text" placeholder="<%= ssMV.getmEmail()%>">
                        </td>
                        <td>
                            
                        </td>
                    </tr>
                </table>
            </div>
            <div id="low_div">
            <input type="hidden" name="mId" id="mId" value="<%=ssMV.getmId() %>">
                <button class="btn2_2" type="submit">수정 완료</button>
                <button class="btn2_2" type="button" id="cancel">취소</button>
                <button class="btn2_2" type="button" id="member_delete_btn">회원탈퇴</button>
            </div>
        </form>
    </div>
    <jsp:include page="../template_footer.jsp"></jsp:include>
    </div>
    <script>
    $(function(){
    	console.log($("#mId").val());
    });
    $("#cancel").click(function(){
    	console.log("취소 버튼 클릭");
		var roleSt = "<%= ssMV.getRoleSt() %>";
		if(roleSt == "S"){
    		location.href="mypageStudent";
		} else if(roleSt == "T"){
    		location.href="mypageTeacher";
		}
	});
    $("#member_delete_btn").click(function(){
    	var confm = confirm("정말로 회원 탈퇴를 진행하시겠습니까? 삭제된 정보는 복구 불가능합니다.");
        if(confm == true){
        	var mId = "<%= ssMV.getmId() %>";
        	$.ajax({
        		url:"memberDelete.ax",
        		type:"post",
        		date:{
        			// mId: $("#mId").val()
        				},
        		success: function(result){
        			if(result == "로그인 먼저 해주세요."){
        				alert(result);
        				location.href = "login";
        			}
        			alert(result);
        			location.href="<%= request.getContextPath() %>";
        		},
        		error: function(){
        			
        		}
        	});
        }
        else if(confm == false){
          alert("회원탈퇴를 취소했습니다.");
        }
    });
    
    </script>
</body>
</html>