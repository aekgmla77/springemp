<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>부서 수정</h3>
<form action="insertDept" method="post" name="frm">
	department_id <input type="number" name="department_id"><br>
	department_name <input name="department_name"><br>
	manager_id <input name="manager_id"><br>
	location_id <input name="location_id"><br>
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>