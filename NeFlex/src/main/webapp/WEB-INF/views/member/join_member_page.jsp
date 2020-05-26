<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NeFlex Join Member Page</title>
</head>
<body>
	<a1>회원 가입</a1>
	<form action="${pageContext.request.contextPath }/member/join_member_process.ne">
		ID : <input type="text" name="mem_id"><br>
		PW : <input type="password" name="mem_pw"><br>
		이름 : <input type="text" name="mem_name"><br>
		닉네임 : <input type="text" name="mem_nick"><br>
		전화번호 : <input type="text" name="mem_phone"><br>
		e-Mail : <input type="text" name="mem_email"><br>
		성별(남:M,여:W) : <input type="text" name="mem_gender"><br>
		생일(19xx/xx/xx) : <input type="date" name="mem_birthdate"><br>
		프로필 사진 url : <input type="text" name="mem_imageurl"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>