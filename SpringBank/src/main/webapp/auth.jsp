<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>auth.jsp</title>
</head>
<body>
<a href="auth">사용자 인증</a>
<a href="callback">토큰 발급</a>
<a href="userinfo?access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAwNzcwNTIwIiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2MjMxMzgwNjYsImp0aSI6ImNiYmZlMWFmLTc1NDktNGM5ZS05OWFjLTBjZWY2MDUzMTc2ZiJ9.nMqCKwR8FgwbWv9g5aECGrafuZYGnNQZ6aH7yI7l3R8">사용자 발급</a>
<div>
	access_token: ${access_token }
</div>
</body>
</html>