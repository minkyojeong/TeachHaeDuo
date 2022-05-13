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
out.println("<a href=./upload/" + multi.getFilesystemName("upload") + ">다운로드</a>");
out.println("<img src=./upload/" + multi.getFilesystemName("upload") + "/>");
</body>
</html>