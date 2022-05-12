<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선생님 증명서</title>
</head>
<body>

<c:choose>
<c:when test="${filePath==null}"><p>증명서가 없습니다.</p></c:when>
<c:when test="${filePath != null}"><img src="${filePath}" width="300" height="300"></c:when>
</c:choose>

</body>
</html>