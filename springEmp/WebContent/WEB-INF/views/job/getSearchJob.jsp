<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnIn").on("click", function(){
		location.href = "insertJob"
	});
});
</script>
</head>
<body>
<h3>job 목록</h3>
<c:forEach items="${list }" var = "job">
	<a href="getJob?job_id=${job.job_id }">id: ${job.job_id }</a> 내용: ${job.job_title } 최저: ${job.min_salary } 최고: ${job.max_salary }<br>
</c:forEach>
<br>
<button id="btnIn">등록</button>
</body>
</html>