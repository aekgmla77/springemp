<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
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
<style>
.error {color : red;}
</style>
</head>
<body>
<h3 id="top">사원등록</h3>

<form:form modelAttribute="empVO" action="insertEmp" method="post" name="frm">
	employee_id <form:input path="employee_id" />
					<form:errors path="employee_id" cssClass="error" /><br>
	first_name  <form:input path="first_name" />
					<form:errors path="first_name" cssClass="error" /><br>
	last_name   <form:input path="last_name" />
					<form:errors path="last_name" cssClass="error" /><br>
	email       <form:input type="text" path="email" />
					<form:errors path="email" cssClass="error" />
				<button type="button" id="btnEmail">중복 체크</button>
				<span id="emailResult"></span><br>
	phone_number<form:input type="text" path="phone_number" />
					<form:errors path="phone_number" cssClass="error" /><br>
	hire_date   <form:input type="date" path="hire_date" />
					<form:errors path="hire_date" cssClass="error" /><br>
	job_id  
				<form:select path="job_id">  
				   <option value="">선택</option>
				   <form:options items="${jobList}" itemLabel="job_title" itemValue="job_id"/>
				</form:select> 
				   <form:errors path="job_id" cssClass="error" /><br>
	department_id 
				<form:radiobuttons items="${deptList }" itemLabel="department_name" itemValue="department_id" path="department_id" />
					<form:errors path="department_id" cssClass="error" />
				<br>
	manager_id 
	<form:input path="manager_id"/>
	<input type="text" name="mname">
		<form:errors path="manager_id" cssClass="error" />	
	<button type="button" onclick="EmpSerch()">사원검색</button><br>	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form:form>
</body>
</html>
