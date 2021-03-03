<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnUp").on("click", function(){
		location.href = "updateJob?job_id=${job.job_id }"
	});
});
</script>
</head>
<body>
job_id: ${job.job_id } <br>
job_title: ${job.job_title } <br>
최저 급여: ${job.min_salary } <br>
최고 급여: ${job.max_salary } <br>
<br>
<button id="btnUp">수정</button>
<a href="deleteJob?job_id=${job.job_id }">삭제</a>
<a href="getSearchJob">목록</a>
</body>
</html>