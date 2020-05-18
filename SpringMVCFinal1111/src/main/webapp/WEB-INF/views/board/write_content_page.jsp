<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action = "${pageContext.request.contextPath}/board/write_content_process.do" method = "post" enctype="multipart/form-data">
	닉네임 : ${sessionUser.member_nick }<br>
	제목 : <input type = "text" name = "board_title"><br>
	내용 : <br>
	<textarea rows="10" cols="40" name = "board_content"></textarea>
	<br>
	<input type = "file" name = "upload_files" multiple accept="image/*"><br>
	
	
	<input type = "submit" value = "글쓰기">
	
	
	
	
</form>

</body>
</html>


<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
crossorigin="anonymous"></script>