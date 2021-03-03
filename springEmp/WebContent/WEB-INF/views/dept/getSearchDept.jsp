<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("#btnIn").on("click", function(){
		location.href = "insertDept"
	});
});
</script>
</head>
<body>
<h3>부서 조회</h3>
<c:forEach items="${list }" var = "dept">
	${dept.department_id } <a href="getDept?department_id=${dept.department_id }">${dept.department_name }</a> ${dept.manager_id } ${dept.location_id } ${dept.city } ${dept.last_name } <br>
</c:forEach>
<button id="btnIn">등록</button>
</body>
</html>