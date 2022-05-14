<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="kh.semi.thduo.board.controller.BoardListController" %>
    <%@ page import="kh.semi.thduo.board.service.BoardService" %>
    <%@ page import="kh.semi.thduo.board.dao.BoardDao" %>
    <%@ page import="kh.semi.thduo.board.vo.BoardVo" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="<%=request.getContextPath()%>/resources/css/header.css"
	rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath()%>/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/font.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/reset.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/css/boardList.css" rel="stylesheet" type="text/css">


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content=text/html; charset="UTF-8">
<meta name="viewport" content="width=device=width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/font.css">
<title>BoardList</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<style>
body {
	width: 1600px;
	box-sizing: border-box;
	margin: 0 auto;
}

.wrap.content {
	width: 1280px;
	
}

a {
    text-decoration: none;
}
</style>

</head>
<body>
	<div class="container">
		<jsp:include page="../template_header.jsp"></jsp:include>
		<div class="wrap.content">
		<div class="board_box">
			<div class="board_title">
				<h1>질문하기 게시판</h1>
				<form action="BoardList" method="post">
				<button type="submit" id="searchBt">검색</button>
				<input type="text" name="boardSearch" value="" class="boardright">
				<select class="boardright" name="boardOption">
        			<option name="select1" value="1">제목</option>
        			<option name="select2" value="2">내용</option>
        			<option name="select3" value="3">작성자</option>
				</select>
				</form>
			</div>
			<div class="write" onclick = "location.href='BoardWrite'">
				<a href="BoardWrite" id="question">글쓰기</a>
			</div>
			<div>
			<c:forEach items="${boardList }" var="vo">
				<dl class="board_list" style="cursor:pointer;" onClick = " location.href='BoardRead?bno=${vo.getbNo()}' " onMouseOver = " indow.status = '' " onMouseOut = " window.status = '' ">
					<dt><a>${vo.getbCategory()}</a></dt>
					<dl class="set2">
						<dd id="profile"><img src="${pageContext.request.contextPath}/resources/icons/profile.png"></dd>
						<dl id="writed">
							<dd id="title">${vo.getbTitle()}</dd>
							<dd id="writer">${vo.getbWriter()}</dd>
							<dd id="writedate">${vo.getbWriteDate().substring(0,16)}</dd>
						</dl>
						<dd id="cnt"><a style="padding:3px;">조회수</a>${vo.getbCnt()}</dd>
						<dd id="bno"><a style="padding:3px;">No.</a>${vo.getbNo()}</dd>
					</dl>
					<dd id="content">${vo.getbContent()}</dd>
				</dl>
				</c:forEach>
		</div>
		<p>
			<c:if test="${    startPage    >    1    }">
			<a href="BoardList?page=${startPage-1 }">이전</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:forEach begin="${startPage }" end="${endPage }" var="p">
				<a href="BoardList?page=${p }">${p }</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:forEach>
			<c:if test="${endPage < totalPageCnt }">
			<a href="BoardList?page=${endPage+1 }">다음</a>
			</c:if>
		</p>
	</div>
	</div>
	<jsp:include page="../template_footer.jsp"></jsp:include>
</div>
</body>
</html>