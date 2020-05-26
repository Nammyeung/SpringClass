<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
NeFlex 결제 항목 입니다.<br>
	<a1>결제 페이지</a1>
	<br>
	<form action="${pageContext.request.contextPath }/member/payment_process.ne">
		카드번호 : <input type="text" name="mem_card"><br>
		카드유효기간 : <input type="text" name="mem_val"><br>
		카드비밀번호 : <input type="text" name="mem_cardpw"><br>
		할부개월 : <input type="text" name="mem_installment_month"><br>
		결제내역 : <input type="text" name="mem_price"><br>
		<input type="submit" value="구독">
	</form>
<br>	
NeFlex 구독 신청 항목 입니다.<br>
	<a1>구독 신청</a1>
	<br>
	<form id="subscription" action="${pageContext.request.contextPath }/member/subscription_process.ne" method="post">
		<input name="subscriptionType" type="radio" value="100000">100000원(3개월) 구독</input>
		<input name="subscriptionType" type="radio" value="500000">500000원(6개월) 구독</input>
		<input name="subscriptionType" type="radio" value="1000000">100000원(9개월) 구독</input>
	</form>
	<a href="${pageContext.request.contextPath }/member/payment_page.ne">결제</a>

	
</body>
</html>