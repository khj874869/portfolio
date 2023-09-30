<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/reset.css">
	    <link rel="stylesheet" href="/resources/css/header.css">
	    <link rel="stylesheet" href="/resources/css/footer.css">
	    <link rel="stylesheet" href="/resources/css/admin/main.css">
	    <link rel="stylesheet" href="/resources/css/noticeEvent/noticeDetail.css">
	    <script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
		<c:if test="${notice.boardType eq 'NOTICE' }"><title>공지사항 상세</title></c:if>
		<c:if test="${notice.boardType eq 'EVENT' }"><title>행사 상세</title></c:if>
		
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
        	<div id="main_left">
                <table>
                    <tr>
                        <c:if test="${notice.boardType eq 'NOTICE' }">
                        	<td style="background-color: black;"><a href="/notice/list.do" style="color:white;">공지사항</a></td>
                        </c:if>
						<c:if test="${notice.boardType eq 'EVENT' }"><td><a href="/notice/list.do">공지사항</a></td></c:if>
                    </tr>
                    <tr>
                        <c:if test="${notice.boardType eq 'NOTICE' }"><td><a href="/event/list.do">행사</a></td></c:if>
						<c:if test="${notice.boardType eq 'EVENT' }">
							<td style="background-color: black;"><a href="/event/list.do" style="color:white;">행사</a></td>
						</c:if>
                    </tr>
                    <tr>
                        <td><a href="/newsRoom/list.do">뉴스룸</a></td>
                    </tr>
                </table>
            </div>
   	        <div id="main_middle">
				<c:if test="${notice.boardType eq 'NOTICE' }">
					<label class="back"><a href="/notice/list.do"><i class="fa-solid fa-arrow-rotate-left"></i>목록으로</a></label>
					<h2><b>공지사항 상세</b></h2>
				</c:if>
				<c:if test="${notice.boardType eq 'EVENT' }">
					<label class="back"><a href="/event/list.do"><i class="fa-solid fa-arrow-rotate-left"></i>목록으로</a></label>
					<h2><b>행사 상세</b></h2>
				</c:if>
				<hr>
	        	<div id="noticeDetailBlock">
					<div class="titlePassword">
	                    <label>&nbsp;글번호 &nbsp;</label>
	                    <input type="text" style="width: 5%;" value="${notice.boardNo }" readonly>
	                    <label>제목</label>
	                    <input type="text" style="width: 30%;" value="${notice.boardTitle }" readonly>
	                    <label>작성일</label>
	                    <input type="text" style="width: 100px;" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${notice.bCreateDate }"/>" readonly>
	                	<label>첨부파일</label>
	                	<a href="../resources/nuploadFiles/${notice.boardFileRename }" download>${notice.boardFileName }</a>
	                </div>
	                    <br>
						<p>${notice.boardContent }</p>
					<c:if test="${userId eq 'admin' }">
						<div class="modify">
		                        <label>
		                            <button onclick="javascript: location.href='/noticeEvent/modify.do?boardNo=${notice.boardNo }'"><i class="fa-solid fa-pen-to-square"></i>글 수정</button>
		                            <button onclick="deleteCheck();"><i class="fa-solid fa-trash"></i>글 삭제</button>
		                        </label>
		               	</div>
	               	</c:if>
               	</div>
			</div>
            <div id="main_right"></div>
        </main>
		<!-- footer -->
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		<script>
			const deleteCheck = () => {
				if(confirm("삭제 하시겠습니까?")){
					location.href = "/noticeEvent/delete.do?boardNo=${notice.boardNo }&boardFileRename=${notice.boardFileRename}&boardType=${notice.boardType}";
				}
			}
			

		</script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
	</body>
</html>