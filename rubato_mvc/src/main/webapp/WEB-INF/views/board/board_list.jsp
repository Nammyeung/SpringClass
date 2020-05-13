<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head> 
<meta charset="utf-8">
<title>클래식기타 커뮤니티</title>
  <link rel="stylesheet" type="text/css" href="css/common.css">
  <link rel="stylesheet" type="text/css" href="css/header.css">
  <link rel="stylesheet" type="text/css" href="css/footer.css">
  <link rel="stylesheet" type="text/css" href="css/board_left.css">
  <link rel="stylesheet" type="text/css" href="css/board_list_main.css">
</head>
<body>
<div id="wrap">
<header>
  <a href="index.do"><img id="logo" src="img/logo.png"></a>
<nav id="top_menu">
  HOME | LOGIN | JOIN | NOTICE
</nav>
<nav id="main_menu">
  <ul>
    <li><a href="board_list.do">자유 게시판</a></li>
    <li><a href="#">기타 연주</a></li>
    <li><a href="#">공동 구매</a></li>
    <li><a href="#">연주회 안내</a></li>
    <li><a href="#">회원 게시판</a></li>
  </ul>
</nav>
</header> <!-- header -->
<aside>
  <article id="login_box">
    <img id="login_title" src="img/ttl_login.png">
    <div id="input_button">
    <ul id="login_input">
      <li><input type="text"></li>
      <li><input type="password"></li>
    </ul>
    <img id="login_btn" src="img/btn_login.gif">
    </div> 
    <div class="clear"></div>
    <div id="join_search">
      <img src="img/btn_join.gif">
      <img src="img/btn_search.gif">
    </div>
  </article>
  <nav id="sub_menu">
    <ul>
      <li><a href="board_list.do">+ 자유 게시판</a></li>
      <li><a href="#">+ 방명록</a></li>
      <li><a href="#">+ 공지사항</a></li>
      <li><a href="#">+ 등업 요청</a></li>
      <li><a href="#">+ 포토갤러리</a></li>
    </ul>
  </nav>
  <article id="sub_banner">
    <ul>
      <li><img src="img/banner1.png"></li>
      <li><img src="img/banner2.png"></li>		
      <li><img src="img/banner3.png"></li>
    </ul>	
  </article>
</aside>
  <section id="main">
    <img src="img/comm.gif">
    <h2 id="board_title">자유 게시판 </h2>
    <div id="total_search">
      <div id="total">▷ 총 5개의 게시물이 있습니다.</div>
      <div id="search">
        <div id="select_img"><img src="img/select_search.gif"></div>
        <div id="search_select">
          <select>
            <option>제목</option>
            <option>내용</option>
            <option>글쓴이</option>
          </select> 
        </div>
        <div id="search_input"><input type="text"></div>
        <div id="search_btn"><img src="img/search_button.gif"></div>
      </div>
    </div>
    <%-- <table border="1">
	<tr><td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td></tr>
	<c:forEach items = "${contentList }" var = "data"> <!-- data 키로 pageContext에 setAttribute함. -->
		<tr>
			<td>${data.boardVo.b_no }</td>
			<td><a href = "./read_content_page.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a></td>
			<!-- 링크로 파라미터를 넘기는 방법 : ?(물음표) -->
			<!-- 4가지의 저장 공간에 getAttribute -->
			<!-- data - pageContext.getAttribute, object.getboardVo 호출 -->
			<td>${data.memberVo.m_nick }</td>
			<td>${data.boardVo.b_writedate }</td>
		</tr>	
	</c:forEach>	
</table>

<br>

<c:if test="${!empty sessionUserInfo }">
	<a href = "./write_content_page.do">글쓰기</a>
</c:if> --%>
    <table>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>일시</th>
        <th>조회수</th>
      </tr>
        <c:forEach items = "${contentList }" var = "data">
        <tr>
        <%-- <td class="col1">${data.boardVo.b_no }</td>
        <td class="col2">
          <a href= "./board_view.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a>
        </td>
        <td class="col3">${data.memberVo.m_nick }</td>
        <td class="col4">${data.boardVo.b_writedate }</td>
        <td class="col5">15</td> --%>
         <td class="col1">${data.boardVo.b_no }</td>
        <td class="col2">
          <a href= "./board_view.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a>
        </td>
        <td class="col3">${data.memberVo.m_nick }</td>
        <td class="col4">${data.boardVo.b_writedate }</td>
        <td class="col5">15</td>
        </tr>
      </c:forEach>
      <!-- <tr>
        <td class="col1">2</td>
        <td class="col2">
          <a href="board_view.do">까스통님의 선물인 보드카가 정말 독하네요!!!</a>
        </td>
        <td class="col3">루바토</td>
        <td class="col4">2017-09-20</td>
        <td class="col5">15</td>
      </tr>	
      <tr>
        <td class="col1">3</td>
        <td class="col2">
          <a href="board_view.do">까스통님의 선물인 보드카가 정말 독하네요!!!</a>
        </td>
        <td class="col3">루바토</td>
        <td class="col4">2017-09-20</td>
        <td class="col5">15</td>
      </tr> -->
    </table>
    <div id="buttons">
      <div class="col1">◀ 이전 1 다음 ▶</div>
      <div class="col2">
        <a href="board_list.do"><img src="img/list.png"></a><!-- <img src="img/list.png">  -->
        <c:if test="${!empty sessionUserInfo }">
        <a href="board_write.do"><img src="img/write.png"></a>
        </c:if>
      </div>
    </div>
  </section> <!-- section main -->
  <div class="clear"></div>

  <footer>
    <img id="footer_logo" src="img/footer_logo.gif">
    <ul id="address">
      <li>서울시 강남구 삼성동 1234 우 : 123-1234</li>  
      <li>TEL : 031-123-1234  Email : email@domain.com</li>
      <li>COPYRIGHT (C) 루바토 ALL RIGHTS RESERVED</li>
    </ul>
    <ul id="footer_sns">
      <li><img src="img/facebook.gif"></li>  
      <li><img src="img/blog.gif"></li>
      <li><img src="img/twitter.gif"></li>
    </ul>
  </footer> <!-- footer -->
</div> <!-- wrap -->
</body>
</html>