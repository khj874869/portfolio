<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<link rel="stylesheet" href="/resources/css/reset.css">
	    <link rel="stylesheet" href="/resources/css/header.css">
	    <link rel="stylesheet" href="/resources/css/footer.css">
	    <link rel="stylesheet" href="/resources/css/admin/singo.css">
	    <link rel="stylesheet" href="/resources/css/admin/main.css">
		<script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<title>신고회원</title>
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
        	<div id="main_left">
                <table>
                    <tr>
                        <td><a href="/member/list.do">회원관리</a></td>
                    </tr>
                    <tr>
                        <td style="background-color: black;"><a href="/singo/list.do" style="color:white;">신고회원</a></td>
                    </tr>
                    <tr>
                        <td><a href="/manageBoard.do?selectedValue=notice">게시글/리뷰 관리</a></td>
                    </tr>
                    <tr>
                        <td><a href="/manageReply.do?selectedValue=hobby">댓글 관리</a></td>
                    </tr>
                </table>
            </div>
        	<div id="main_middle">
            	<h2><b>신고 회원</b></h2>
                <hr>
                <div class="search">
                    <form action="/singo/search.do" method="get">
						<input type="text" name="searchKeyword" placeholder="아이디를 입력하세요.">
						<button id="findProduct" type="submit"><i class="fa-solid fa-magnifying-glass" style="color: blue;"></i></button>
					</form>	
                </div>
                <br>
                <table class="table table-striped table-hover">
                	<colgroup>
						<col width="5%"></col>
						<col width="20%"></col>
						<col width="20%"></col>
						<col width="20%"></col>
						<col width="20%"></col>
						<col width="15%"></col>
					</colgroup>
                    <thead>
                        <tr style="text-align:center">
                            <th>No</th>
                            <th>신고 이유</th>
                            <th>신고 내용</th>
                            <th>신고 위치</th>
                            <th>신고된 아이디</th>
                            <th>관리</th>
                        </tr>
                    </thead>
                    <tbody class="table-group-divider">
						<c:forEach var="singo" items="${singoList}">
							<tr>
								<td style="text-align:center">${singo.singoNo }</td>
								<td style="text-align:center">${singo.singoReason }</td>
								<td style="text-align:center">${singo.singoContent }</td>
								<td style="text-align:center"><a href="${singo.singoLocation }">${singo.singoLocationTitle }</a></td>
								<td style="text-align:center">${singo.singoId }</td>
								<td style="text-align:center" class="manage">
									<button class="userDelete" onclick="if (confirm('삭제 하시겠습니까?')) { location.href = '/singo/delete.do?singoNo=${singo.singoNo }'; window.location.href = window.location.href; }">신고 취소</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr align="center">
							<td colspan="6">
							<c:if test="${pInfo.currentPage != 1 }">
								<a href="/singo/list.do?currentPage=${pInfo.currentPage - 1 }">&lt;</a>&nbsp;
							</c:if>
							<c:forEach begin="${pInfo.startNavi }" end="${pInfo.endNavi }" var="p">
								<c:url var="pageUrl" value="/singo/list.do">
									<c:param name="currentPage" value="${p }"></c:param>
								</c:url>
								<c:if test="${pInfo.currentPage == p }"><a href="${pageUrl }" style="color:black;">${p }</a>&nbsp;</c:if>
								<c:if test="${pInfo.currentPage != p }"><a href="${pageUrl }">${p }</a>&nbsp;</c:if>
							</c:forEach>
							<c:if test="${pInfo.currentPage ne pInfo.naviTotalCount }">
								<a href="/singo/list.do?currentPage=${pInfo.currentPage + 1 }">&gt;</a>
							</c:if>
							</td>
						</tr>
					</tfoot>
                </table>
            </div>
        	<div id="main_right"></div>
        </main>
        <!-- footer -->
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>
</html>