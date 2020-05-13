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
<div class = "row mt-5">
	<div class = "col-xs-2 col-md-2"></div>
		<div class = "col-xs-8 col-md-8">
			<h2 class = "text-center">게시글 보기</h2><p>&nbsp;</p>
	<div class = "table table-responsive">
		<table class = "table">
		<tr>
			<th class = "success">글번호</th>
			<td>${aaaa.boardVo.board_no }</td>
			<th class = "success">조회수</th>
			<td>${aaaa.boardVo.board_readcount }</td>
		</tr>
		
		<tr>
			<th class = "success">작성자</th>
			<td>${aaaa.memberVo.member_nick }</td>
			<th class = "success">작성일</th>
			<td>${aaaa.boardVo.board_writedate }</td>
		</tr>
		
		<tr>
			<th class = "success">이메일</th>
			<td colspan="3">xxxxx@naver.com</td>
		</tr>
		
		<tr>
			<th class = "success">제목</th>
			<td colspan="3">${aaaa.boardVo.board_title }</td>
		</tr>
		
		<tr>
			<th class = "success">글 내용</th>
			<td colspan="3">${aaaa.boardVo.board_content }</td>
		</tr>
		
		<tr>
			<td colspan="4" class = text-center">
			<c:if test="${!empty sessionUser && sessionUser.member_no == aaaa.memberVo.member_no }">
			<a href = "${pageContext.request.contextPath}/board/delete_content_process.do?board_no=${aaaa.boardVo.board_no}">삭제</a>
			<a href = "${pageContext.request.contextPath}/board/update_content_page.do?board_no=${aaaa.boardVo.board_no}">수정</a>
			</c:if>
			</td>
		</tr>				
		</table>
	</div>
	</div>
</div>		
		
<%-- 제목 : ${aaaa.boardVo.board_title }<br>
글쓴이 : ${aaaa.memberVo.member_nick }<br>
조회수 : ${aaaa.boardVo.board_readcount }<br>
내용 : <br>
${aaaa.boardVo.board_content }<br>
<br>

<a href="${pageContext.request.contextPath}/board/main_page.do">목록으로</a>

<c:if test="${!empty sessionUser && sessionUser.member_no == aaaa.memberVo.member_no }">
<a href = "${pageContext.request.contextPath}/board/delete_content_process.do?board_no=${aaaa.boardVo.board_no}">삭제</a>
<a href = "${pageContext.request.contextPath}/board/update_content_page.do?board_no=${aaaa.boardVo.board_no}">수정</a>
</c:if> --%>



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