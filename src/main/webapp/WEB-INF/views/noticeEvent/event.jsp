<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/reset.css">
	    <link rel="stylesheet" href="/resources/css/header.css">
	    <link rel="stylesheet" href="/resources/css/footer.css">
	    <link rel="stylesheet" href="/resources/css/noticeEvent/event.css">
	    <link rel="stylesheet" href="/resources/css/admin/main.css">
	    <script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>행사</title>
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
        	<div id="main_left">
                <table>
                    <tr>
                        <td><a href="/notice/list.do">공지사항</a></td>
                    </tr>
                    <tr>
                        <td style="background-color: black;"><a href="/event/list.do" style="color:white;">행사</a></td>
                    </tr>
                    <tr>
                        <td><a href="/newsRoom/list.do">뉴스룸</a></td>
                    </tr>
                </table>
            </div>
            <div id="main_middle">
                <h2><b>행사</b></h2>
                <hr>
                <div class="search">
                    <form action="/event/search.do" method="get">
						<input type="text" name="searchKeyword" placeholder="제목을 입력하세요." style="width:30%">
						<button id="findProduct" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: blue;"></i></button>
					</form>	
	                <c:if test="${userId eq 'admin' }">
	                	<button class="eventNotice" onclick="javascript: location.href='/noticeEvent/write.do'" style="margin-top:-30px;">행사 등록</button>
	                </c:if>
                </div><br>
                <div class="container itemlist">
                        <div class="row">
                        	<c:forEach var="event" items="${eList}">
	                            <div class="col-md-4 col-sm-12" style="margin-bottom: 50px;">
	                                <a href="/noticeEvent/detail.do?boardNo=${event.boardNo }">
	                                    <div class="card" style="width: auto;">
	                                        <img src="../resources/nuploadFiles/${event.boardFileRename }" class="card-img-top">
	                                        <div class="card-body">
	                                            <h6 class="card-title"><b>${event.boardTitle }</b></h6>
	                                        </div>
	                                    </div>
	                                </a>
	                            </div>
                            </c:forEach>
                       </div>
               	</div>
               	<div style="text-align:center;" class="pageNavi">
               		<c:if test="${pInfo.currentPage != 1 }">
								<a href="/event/list.do?currentPage=${pInfo.currentPage - 1 }">&lt;</a>&nbsp;
							</c:if>
							<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
								<c:url var="pageUrl" value="/event/list.do">
									<c:param name="currentPage" value="${p }"></c:param>
								</c:url>
								<c:if test="${pInfo.currentPage == p }"><a href="${pageUrl }" style="color:black;">${p }</a>&nbsp;</c:if>
								<c:if test="${pInfo.currentPage != p }"><a href="${pageUrl }">${p }</a>&nbsp;</c:if>
							</c:forEach>
							<c:if test="${pInfo.currentPage ne pInfo.naviTotalCount }">
								<a href="/event/list.do?currentPage=${pInfo.currentPage + 1 }">&gt;</a>
							</c:if>
               	</div><br>
            </div>
            <div id="main_right"></div>
        </main>
		<!-- footer -->
	    <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>
</html>