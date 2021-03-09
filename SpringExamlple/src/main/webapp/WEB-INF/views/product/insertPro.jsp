<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품 등록</h3>
<form action="insertProduct" method="post">
	아이디: <input name="product_id"><br>
	이름: <input name="product_name"><br>
	가격: <input name="product_price"><br>
	정보: <input name="product_info"><br>
	출시일: <input name="product_date"><br>
	회사: <input name="company"><br>
	담당자: <input name="manager_id"><br>
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
</body>
</html>