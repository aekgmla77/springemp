<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<a href = "getSearchEmp">사원조회</a>
<a href = "getSearchDept">부서조회</a>
<a href = "getSearchJob">job 조회</a> <br><br>

<c:if test="${! empty sessionScope.loginid }">
	${sessionScope.loginid }님 환영합니다!
	<br><a href="logout">로그아웃</a> <br>
	<a href="changePw">패스워드 변경</a>
</c:if>

<c:if test="${ empty sessionScope.loginid }">
	<a href="login">로그인</a> <br>
</c:if>
</body>
</html>