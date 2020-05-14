<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

제목 : ${aaaa.boardVo.board_title }<br>
글쓴이 : ${aaaa.memberVo.member_nick }<br>
조회수 : ${aaaa.boardVo.board_readcount }<br>
내용 : <br>
${aaaa.boardVo.board_content }<br>
<br>

<a href="${pageContext.request.contextPath}/board/main_page.do">목록으로</a>

<c:if test="${!empty sessionUser &&  sessionUser.member_no == aaaa.memberVo.member_no}">
<a href="${pageContext.request.contextPath}/board/delete_content_process.do?board_no=${aaaa.boardVo.board_no}">삭제</a>
<a href="${pageContext.request.contextPath}/board/update_content_page.do?board_no=${aaaa.boardVo.board_no}">수정</a>
</c:if>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
crossorigin="anonymous"></script>
</body>
</html>