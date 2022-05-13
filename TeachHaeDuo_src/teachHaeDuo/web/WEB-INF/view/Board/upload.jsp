<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String uploadPath = "/Users/gim-ingon/Work_space/java_work_space/teachHaeDuo";
	int maxFileSize = 1024 * 1024 * 2;
	String encType = "utf-8";
	
	MultipartRequest multi 
		= new MultipartRequest(request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
		out.println("업로드 완료");
%>
</body>
</html>