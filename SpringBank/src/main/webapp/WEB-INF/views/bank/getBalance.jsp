<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<td>계좌 개설일</td>
		<td>${balance.bank_tran_date}</td>
	</tr>
	<tr>	
		<td>상품명</td>
		<td>${balance.product_name }</td>
	</tr>	
	<tr>
		<td>잔액</td>
		<td>${balance.balance_amt }</td>
	</tr>		
	<tr>
		<td>은행명</td>	
		<td>${balance.bank_name }</td>
	</tr>	
	<tr>
		<td>출금 가능액</td>	
		<td>${balance.available_amt }</td>
	</tr>	
	<tr>
		<td>거래일시</td>
		<td>${balance.api_tran_dtm }</td>
	</tr>
</table>
</body>
</html>