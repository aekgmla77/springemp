<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnUpd").on("click", function(){
		//location.href = "updateEmp?employee_id=${emp.employee_id }"
		location.assign("updateEmp?employee_id=${emp.employee_id }");
	});
});
</script>
</head>
<body>
파라미터 ${employee }
<hr>
사번: ${emp.employee_id } <br>
이름: ${emp.first_name } ${emp.last_name }<br>
이메일: ${emp.email } <br>
급여: ${emp.salary } <br>
폰 번호: ${emp.phone_number } <br>
부서: ${emp.department_id } <br>
매니저: ${emp.manager_id } <br>
<br>
<button id="btnUpd">수정</button>
<a href="deleteEmp?employee_id=${emp.employee_id }">삭제</a>
<a href="getSearchEmp">목록으로</a>
</body>
</html>