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
<link rel="stylesheet" type="text/css" href="css/main.css">
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
  <form action="./login_process.do" method = "post">
    <img id="login_title" src="img/ttl_login.png">
    <div id="input_button">
    <ul id="login_input">
      <li><input name="m_id" type="text"></li>
      <li><input name="m_pw" type="password"></li>
    </ul>
    <!-- <img id="login_btn" src="img/btn_login.gif"> -->
    <input type="image" src="img/btn_login.gif">
    </div> 
    </form>
    <form action = "./join_member_page.do" method="post">
    <div class="clear"></div>
    <div id="join_search">
      <input type="image" src="img/btn_join.gif">
   <!--    <img src="img/btn_join.gif"> -->
      <img src="img/btn_search.gif">
    </div>
    </form>
  </article>
  <article id="guestbook">
    <div id="guestbook_title">
      <img src="img/ttl_memo.gif">
    </div>
    <ul>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
      <li>안녕하세요!</li>
    </ul>
  </article>
</aside>

<section id="main">
  <img src="img/main_img.png">
  <section id="notice_free_youtube">
    <article id="notice"> 	<!-- 공지사항 -->
      <div class="latest_title">
        <img class="latest_img" src="img/latest1.gif">
        <img class="more" src="img/more.gif">
        <div class="clear"></div>					
      </div>
      <div class="latest_content">
        <img class="image" src="img/book_pen.gif">
        <ul class="list">
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>								
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>		
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>	
          <li>
            <div class="subject">루바토 개편과 사이트 이용...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>				
        </ul>							
      </div>
    </article>
    <article id="free"> 	<!—자유 게시판 -->
      <div class="latest_title">
        <img class="latest_img" src="img/latest2.gif">
        <img class="more" src="img/more.gif">
        <div class="clear"></div>					
      </div>
      <div class="latest_content">
        <img class="image" src="img/book_pen.gif">
        <ul class="list">
        <%-- <c:forEach items = "${contentList }" var = "data">
        <tr>
        <td class="col1">${data.boardVo.b_no }</td>
        <td class="col2">
          <a href= "./board_view.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a>
        </td>
        <td class="col3">${data.memberVo.m_nick }</td>
        <td class="col4">${data.boardVo.b_writedate }</td>
        <td class="col5">15</td>
         <td>${data.boardVo.b_no }</td>
        <td>
          <a href= "./board_view.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a>
        </td>
        <td>${data.memberVo.m_nick }</td>
        <td>${data.boardVo.b_writedate }</td>
        <td>15</td>
        </tr>
      </c:forEach> --%>
      	  <c:forEach items = "${contentList }" var = "data">
          <li>
            <div class="subject">
            <a href = "./board_list.do?b_no=${data.boardVo.b_no }">${data.boardVo.b_title }</a>
            </div>
            <div class="date">${data.boardVo.b_writedate }</div>
            <div class="clear"></div>		
          </li>
          </c:forEach>
          <!-- <li>
            <div class="subject">까스통님의 선물인 보드카...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>		
          <li>
            <div class="subject">까스통님의 선물인 보드카...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>	
          <li>
            <div class="subject">까스통님의 선물인 보드카...</div>
            <div class="date">2017-09-20</div>
            <div class="clear"></div>	
          </li>	 -->							
        </ul>							
      </div>
    </article>			
    <article id="youtube">	    <!—YOUTUBE 동영상 -->		
      <div class="latest_title">
        <img class="latest_img" src="img/latest3.gif">
        <img class="more" src="img/more.gif">
        <div class="clear"></div>					
      </div>				
      <img id="youtube_img" src="img/bach.jpg">
    </article>
  </section> <!-- notice_free_youtube -->
  <section id="gallery">
    <img src="img/latest4.gif">
    <div id="gallery_box">
      <div id="gallery_list">
        <div class="items">
          <ul>
            <li><img src="img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
        <div class="items">
          <ul>
            <li><img src="img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
        <div class="items">
          <ul>
            <li><img src="img/img1.jpg"></li>
            <li>기타 페스티벌 4중주</li>
          </ul>
        </div>
      </div> <!-- galley_list -->
    </div> <!-- gallery_box -->		
  </section> <!-- gallery -->
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
