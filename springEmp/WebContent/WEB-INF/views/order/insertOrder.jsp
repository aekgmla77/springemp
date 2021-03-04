<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>order/insertOrder.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btnUp").on("click", function(){
			var tr = $("tr:last").clone().appendTo($("tbody"));
			var num = 2;
			for(i = 2; i < i+1; i++){
				if(i < i +1) {
					num = num +i;
				tr.find("input").eq(0).attr("name","ords["+num+"].no");
				tr.find("input").eq(1).attr("name","ords["+num+"].cnt");
				}
			}
		})
	})
</script>
</head>
<body>
<button type="button" id="btnUp">상품 추가</button>
<form action="insertOrder" method="post">
$("tr:last").clone().appendTo($("tbody"));
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input name="name" /></td>
		</tr>
		<tr>
			<td>배송지</td>
			<td><input name="addr" /></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input name="tel" /></td>
		</tr>
		<tr>
			<td><input name="ords[0].no" /></td>
			<td><input name="ords[0].cnt" /></td>
		</tr>
		<tr>
			<td><input name="ords[1].no" /></td>
			<td><input name="ords[1].cnt" /></td>
		</tr>
		<tr>
			<td><input name="ords[2].no" /></td>
			<td><input name="ords[2].cnt" /></td>
		</tr>
	</table>
	<button>주문하기</button>
</form>
</body>
</html>