<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P><br>
<c:if test="${empty access_token }">
	<a href="loginForm">로그인</a>
</c:if>
<c:if test="${not empty access_token }">
	${loginid }<a href="logout">로그아웃</a>
</c:if>
</body>
</html>
