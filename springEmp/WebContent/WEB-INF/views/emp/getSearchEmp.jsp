<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnIn").on("click", function(){
		location.href = "insertEmp"
	});
});
</script>
</head>
<body>
<h3>사원 목록</h3>
<c:forEach items="${list }" var = "emp">
	${emp.employee_id } <a href="getEmp?employee_id=${emp.employee_id }">${emp.first_name } ${emp.last_name }</a> ${emp.job_id } ${emp.department_name} ${emp.job_title}<br>
</c:forEach>
<br>
<button id="btnIn">등록</button>
</body>
</html>