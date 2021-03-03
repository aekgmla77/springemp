<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	//이메일 중복체크
	$("#btnEmail").on("click", function(){
 		var param = "email=" + $("[name=email]").val()  
		$.ajax({
			url : "empEmail", 
			data : param,         //서버에 보낼 파라미터
			dataType : "xml",    //결과 타입
			success : function(response) {
				//json
				/* if(response.email == true){
					$("#emailResult").html("<font color='blue'>사용 가능</font>");
				} else{
					$("#emailResult").html("<font color='red'>사용 불가능</font>");
				} */
				//xml
				$("#emailResult").html( $(response).find("email").text() );
			}
		});
	});
});
function EmpSerch(){
	url = "empSerch"
	window.open(url, "매니저 조회",
			"width=600, height=200, left=100")
}
</script>
</head>
<body>
<h3 id="top">사원등록</h3>

<form action="insertEmp" method="post" name="frm">
	employee_id <input type="number" name="employee_id"><br>
	first_name  <input name="first_name"><br>
	last_name   <input name="last_name"><br>
	email       <input type="text" name="email">
				<button type="button" id="btnEmail">중복 체크</button>
				<span id="emailResult"></span><br>
	phone_number<input type="text" name="phone_number"><br>
	hire_date   <input type="date" name="hire_date"><br>
	job_id  
	<select name="job_id">  
	   <option value="AC_ACCOUNT">Public Accountant</option>
	<c:forEach items="${jobList }" var = "job">
		<option value="${job.job_id }" <c:if test="${job.job_id == empVO.job_id}">selected="selected" </c:if>>${job.job_title }
	</c:forEach></select><br>
	department_id 
	<input type="radio" name="department_id" value="10">기획
	<c:forEach items="${deptList }" var = "dept">
		<input type="radio" name="${dept.department_id }" value="${dept.department_id }" 
		<c:if test="${dept.department_id == empVO.department_id}">checked="checked" </c:if>>${dept.department_name }
	</c:forEach><br>
	manager_id 
	<input type="text" name="manager_id" value="${empVO.manager_id }">
	<input type="text" name="mname" value="${empVO.first_name }">
	<button type="button" onclick="EmpSerch()">사원검색</button><br>	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>
