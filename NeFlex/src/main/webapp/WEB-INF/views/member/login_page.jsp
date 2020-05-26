<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NeFlex Login Page</title>
</head>
<body>
	NeFlex Login Page 입니다.
	<a1>로그인</a1>
	<form action="${pageContext.request.contextPath }/member/login_process.ne">
		ID : <input type="text" name="mem_id"><br>
		PW : <input type="password" name="mem_pw"><br>
		<input type="submit" value="로그인">
	</form>
	<a href="${pageContext.request.contextPath }/member/join_member_page.ne">회원가입</a>
	<a href="${pageContext.request.contextPath }/member/subscription_page.ne">구독</a>		
</body>
</html>