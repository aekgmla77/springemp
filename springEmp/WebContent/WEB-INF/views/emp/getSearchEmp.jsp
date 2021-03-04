<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>   
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %> 
<!DOCTYPE html>
<html>
<head>
<title>emp/getSearchEmp.jsp</title>
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
<form action="getSearchEmp" name="searchFrm">
	<input type="hidden" name="page" value="1">
	부서 <input name = "department_id" value="${empSearchVO.department_id }">
	JOB <input name = "job_id" value="${empSearchVO.job_id }">
	NAME <input name = "first_name" value="${empSearchVO.first_name }">
	<button>검색</button>
</form>
<c:forEach items="${list }" var = "emp">
	id: ${emp.employee_id } <a href="getEmp?employee_id=${emp.employee_id }">이름: ${emp.first_name } ${emp.last_name }</a> 직무: ${emp.job_id } 부서명: ${emp.department_name} 직무 내용:${emp.job_title}<br>
</c:forEach>
<br>
<my:paging paging="${paging }" jsFunc="goPage" />
<button id="btnIn">등록</button>
<script>
	function goPage(p){
		//location.href = "getSearchEmp?page=" + p;
		searchFrm.page.value = p;
		searchFrm.submit();
	}
</script>
</body>
</html>