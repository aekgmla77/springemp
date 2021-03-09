<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h3>상품 조회</h3>
<c:forEach items="${list }" var = "pro">
	${pro.product_id } ${pro.product_name } ${pro.product_price } ${pro.product_info } ${pro.product_date } ${pro.company } ${pro.manager_id } <br>
</c:forEach>
</body>
</html>