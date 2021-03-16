<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
번호: ${board.seq } <br>
제목: ${board.title } <br>
작성자: ${board.writer } <br>
내용: ${board.content } <br>
파일 단건: <a href="fileDown?seq=${board.seq }">${board.filename } </a><br>
파일 여러건:
	<a href="">일괄 다운 받기(zip)</a>
	<c:forTokens items="${board.filename }" delims="," var="file">  <!-- ,으로 구분한 여러건을 나누고 ${file} 하나씩 다운로드-->
		<a href="fileNameDown?filename=${file }">${file } </a><br>
	</c:forTokens>
</body>
</html>