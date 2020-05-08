<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<%-- <c:choose>
	<c:when test = "${!empty sessionUser }">
		${sessionUser.member_nick }님 환영합니다.
		<a href = "${pageContext.request.contextPath}/member/logout_process.do">로그아웃</a>
	</c:when>
	<c:otherwise>
		비회원 접근.... <a href = "${pageContext.request.contextPath}/member/login_page.do">로그인</a>
	</c:otherwise>
</c:choose> --%>

<div class = "container mt-5">
	
	<div class = "row">
		
		<div class = "col-2"></div>
		
		<div class = "col">
			<div class = "row"><!--  테이블 -->
				<div class = "col">
					<table class = "table table-hover">
					<thead>
						<tr><td>글번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
					</thead>
					<tbody>
						<c:forEach items = "${dataList }" var = "xxx">
							<tr>
								<td>${xxx.boardVo.board_no }</td>
								<td><a href = "${pageContext.request.contextPath}/board/read_content_page.do?board_no=${xxx.boardVo.board_no}">${xxx.boardVo.board_title }</a></td>
								<td>${xxx.memberVo.member_nick }</td>
								<td>${xxx.boardVo.board_readcount }</td>
								<td>${xxx.boardVo.board_writedate }</td>
								
								<%-- <td>${xxx.boardVo.board_no }</td>
								<td><a href = "./board_read_content_page.do?board_no=">${xxx.boardVo.board_title }</a></td>
								<td>${xxx.memberVo.member_nick }</td>
								<td>${xxx.boardVo.board_readcount }</td>
								<td>${xxx.boardVo.board_writedate }</td> --%>
							<tr>			
						</c:forEach>
					</tbody>						
					</table>
				</div>
			</div>
			
			<div class = "row mt-3"><!--  버튼들... -->
				<div class="col-8"><!-- 페이지 버튼 -->
				<nav aria-label="Page navigation example">
				  	<ul class="pagination">
				    <li class="page-item"><a class="page-link" href="#">이전</a></li>
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item active"><a class="page-link" href="#">3</a></li>
				    <li class="page-item"><a class="page-link" href="#">4</a></li>
				    <li class="page-item"><a class="page-link" href="#">5</a></li>
				    <li class="page-item"><a class="page-link" href="#">다음</a></li>
  					</ul>
				</nav>
				</div>
				<div class="col">
					<a class = "btn btn-primary btn-block" href = "./write_content_page.do">글쓰기</a>
				</div>
			</div>
		</div>
		
		<div class = "col-2"></div>
		
	</div>
	
	<div class = "row"></div>
	
</div>






<%-- <!-- 게시글 목록.... -->
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
			<td><a href = "${pageContext.request.contextPath}/board/read_content_page.do?board_no=${xxx.boardVo.board_no}">${xxx.boardVo.board_title }</a></td>
			<td>${xxx.memberVo.member_nick }</td>
			<td>${xxx.boardVo.board_readcount }</td>
			<td>${xxx.boardVo.board_writedate }</td>		
		</tr>		
	</c:forEach>

</table>

<br>

<c:if test="${!empty sessionUser }">
	<a href="${pageContext.request.contextPath}/board/write_content_page.do">글쓰기</a>
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