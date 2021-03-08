<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {color: lightblue;}
div {
	height: auto; width: 100%; border:2px solid gold;
}
</style>
</head>
<body>
<div align="center">
<h3 align="center">로그인</h3>
<form id="frm" method="post" action="login">
	ID : <input type="text" id="id" name="id"><br>
	PW: <input type="password" id="password" name="password"><br><br>
	
	<button type="submit">로그인</button>
	<button type="reset">취소</button>
</form>
</div>
</body>
</html>