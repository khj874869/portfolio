<%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <header>
	<nav class="nav_left">
		<a href="/index.jsp">Special Alone</a>
	</nav>
	
	<nav class="nav_center">
		<div id="nav">
			<div id="main_nav">
				<ul>
					<li><a href="#">공지</a></li>
					<li><a href="#">음식</a></li>
					<li><a href="#">안전</a></li>
					<li><a href="/hobby/category/list.do">취미</a></li>
				</ul>

				<c:if test="${userId eq 'admin' }">
					<ul>					
						<li><a href="/member/list.do">관리자</a></li>
					</ul>
					</c:if>
					<c:if test="${userId ne 'admin' }">
					<ul style = "display: none;">
						<li></li>
					</ul>
				</c:if>
			</div>
			
			<div id="sub" class="background-with-opacity">
				<div id="sub_menu">
					<ul class="menu">
						<li><a href="/notice/list.do">공지사항</a></li>
						<li><a href="/event/list.do">행사</a></li>
						<li><a href="/newsRoom/list.do">뉴스룸</a></li>
					</ul>
					<ul class="menu">
						<li><a href="/foodProduct/list.do">추천상품</a></li>
						<li><a href="/diner/list.do">추천식당</a></li>
					</ul>
					<ul class="menu">
						<li><a href="/product/slistproduct.do">안전상품</a></li>
						<li><a href="/comment/map.do">안전지도</a></li>
					</ul>
					<ul class="menu">
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
						<li><a href="#"></a></li>
					</ul>
					<c:if test="${userId eq 'admin' }">
						<ul class="menu" style = "display: flex;">					
							<li></li>
						</ul>
					</c:if>
					<c:if test="${userId ne 'admin' }">
						<ul class="menu" style = "display: none;">
							<li></li>
						</ul>
					</c:if>
				</div>
			</div>
		</div>
	</nav>
	
	<div class="nav_right">
		<ul>
			<c:if test="${userId ne null }">
		<li style="float: left;"><a href="/user/logout.do">로그아웃</a></li>
		<li style="float: left;"><a href="/user/mypage.do?userId=${userId }">내정보</a></li>
<!-- 			<form action="/user/mypage.do" method="post"> -->
<%-- 				<input type="hidden" name="userId" value="${userId }"><br> --%>
<!-- 				<input type="submit" value="Mypage"> -->
<!-- 			</form> -->
		</c:if>
		<c:if test="${userId eq null }">
			<li style="float: left;"><a href="/user/login.do">로그인</a></li>
			<li style="float: left;"><a href="/user/register.do">회원가입</a></li>
		</c:if>
		</ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
         $(function() {
             $('#sub').hide();
            
 	        $('#main_nav').mouseenter(function() {
 	            $(this).parent().find('#sub').slideDown();
 	        });
 	        $('#sub').mouseleave(function() {
 	            $(this).slideUp(1000); // 1초 동안 유지
 	        });
         });
     </script>
</header>