<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test = "${!empty sessionUser }">
		${sessionUser.member_nick }님 환영합니다.
		<a href = "${pageContext.request.contextPath}/member/logout_process.do">로그아웃</a>
	</c:when>
	<c:otherwise>
		비회원 접근.... <a href = "${pageContext.request.contextPath}/member/login_page.do">로그인</a>
	</c:otherwise>
</c:choose>

<!-- 게시글 목록.... -->
<br>
<table border="1">
	<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>조회수</td>
		<td>작성일</td>
	</tr>
	<c:forEach items="${dataList }" var="xxx">
		<tr>
			<td>${xxx.boardVo.board_no }</td>
			<td>${xxx.boardVo.board_title }</td>
			<td>${xxx.memberVo.member_nick }</td>
			<td>${xxx.boardVo.board_readcount }</td>
			<td>${xxx.boardVo.board_writedate }</td>		
		</tr>		
	</c:forEach>

</table>



<br>




<c:if test="${!empty sessionUser }">
	<a href="${pageContext.request.contextPath}/board/write_content_page.do">글쓰기</a>
</c:if>

</body>
</html>