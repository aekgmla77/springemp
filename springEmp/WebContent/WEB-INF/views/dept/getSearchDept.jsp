<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
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
<form action="getSearchDept" name="searchFrm">
	<input type="hidden" name="page" value="1">
	ID <input name = "department_id" value="${dept.department_id }">
	NAME <input name = "department_name" value="${dept.department_name }">
	MANAGER <input name = "manager_id" value="${dept.manager_id }">
	<button>검색</button>
</form>
<c:forEach items="${list }" var = "dept">
	부서번호: ${dept.department_id } <a href="getDept?department_id=${dept.department_id }">부서명: ${dept.department_name }</a> 매니저 번호: ${dept.manager_id } 로케이션: ${dept.location_id } 나라: ${dept.city } 매니저 이름: ${dept.last_name } <br>
</c:forEach>
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