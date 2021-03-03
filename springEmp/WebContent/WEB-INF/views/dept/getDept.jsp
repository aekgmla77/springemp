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
		location.href = "updateDept?department_id=${dept.department_id }"
	});
});
</script>
</head>
<body>
부서번호: ${dept.department_id } <br>
부서이름: ${dept.department_name } <br>
매니저: ${dept.manager_id } <br>
로케이션: ${dept.location_id } <br>
<br>
<button id="btnUp">수정</button>
<a href="deleteDept?department_id=${dept.department_id }">삭제</a>
<a href="getSearchDept">목록</a>
</body>
</html>