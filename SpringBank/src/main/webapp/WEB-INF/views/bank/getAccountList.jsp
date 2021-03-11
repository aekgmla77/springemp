<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<table border="1">
<c:forEach items="${list.res_list }" var = "bank">
	<tr>
	<td><a href = "#" onclick="getBalance('${bank.fintech_use_num}')">${bank.fintech_use_num}</a></td>
<%-- 	<a href = "#" onclick="getBalance?fintech_use_num=${bank.fintech_use_num}">${bank.fintech_use_num}</a> --%>
	<td>성함: ${bank.account_holder_name }</td>
	<td>은행명: ${bank.bank_name }</td>
	<td>계좌: ${bank.account_num_masked }</td>
	<td>명의: ${bank.account_holder_name }</td>
	<td>개설일: ${bank.inquiry_agree_dtime }</td>
	</tr>
</c:forEach>
</table>
<div id="result">
</div>
<script>
function getBalance(fin){
	//ajax 호출
	//ajaxGetBalance
	//fintechUserNum="+fun;
	$.ajax({
		url: "getBalance",
		data: {fintech_use_num: fin},
// 		dataType: "json", /* @ResponseBody랑 세트 */
		success: function(response){
			$("#result").html(response);
// 			$("#result").empty();
// 			$("#result").append("bankname: " + response.bank_name + "<br>")
// 			.append("amt: " + response.balance_amt + "<br>")
// 			.append("name: " + response.product_name + "<br>")
// 			.append("available_amt: " + response.available_amt + "<br>");
		}
	});
}
</script>
</body>
</html>