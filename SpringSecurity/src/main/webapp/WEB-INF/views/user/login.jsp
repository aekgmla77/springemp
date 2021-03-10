<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<font color="red">
		${SPRING_SECURITY_LAST_EXCEPTION.message }
		<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	</font>
</c:if>
<form id="frm" method="post" action="login">
	&nbsp;ID:&nbsp; <input type="text" id="id" name="id"><br><br>
	PW: <input type="password" id="password" name="password"><br><br>
	
	<button type="submit">로그인</button>
	<button type="reset">취소</button>
</form>
<a href="https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=a4ebdf8d627fdcb7cf96c8c39951aebf&redirect_uri=http://localhost/temp/callback">카카오 로그인</a>

</div>
</body>
</html>