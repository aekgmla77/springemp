<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>job 입력</h3>
<form action="insertJob" method="post" name="frm">
	job_id <input name="job_id"><br>
	job_title <input name="job_title"><br>
	min_salary <input name="min_salary"><br>
	max_salary <input name="max_salary"><br>
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>