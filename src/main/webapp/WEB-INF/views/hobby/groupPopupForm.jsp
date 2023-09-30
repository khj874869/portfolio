<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Document</title>
      <style>
         .box {
            border: 2px double skyblue;
            border-radius: 10px;
            padding: 30px;
            margin: 30px;
         }
         ul {
            list-style-type: none;
         }
         ul li {
            margin: 10px 10px;
         }
         button {
            margin: 5px;
         }
         h1 {
            text-align: center;
         }
      </style>
   </head>
   <body>
      <div class="box">
         <h1>소모임 모집</h1>
         <ul>
            <li>일시 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ board.hGroupTime }"/></li>
            <li>장소 : ${ board.hGroupPlace }</li>
            <c:if test="${ board.hGroupApplyPersonNum != board.hGroupPersonNum}">
               <li>모집인원 : ${ board.hGroupApplyPersonNum } / ${ board.hGroupPersonNum }</li>
            </c:if>
            <c:if test="${ board.hGroupApplyPersonNum eq board.hGroupPersonNum}">
               <c:url var="autoCreateUrl" value="/hobby/board/autoCreateBoard.do">
                  <c:param name="category" value="${ board.refCategoryName }"></c:param>
                  <c:param name="hBoardNo" value="${ board.hBoardNo }"></c:param>
               </c:url>
               <li id="autoCloseAndExecute" autoCreateUrl="${ autoCreateUrl }">모집인원 : ${ board.hGroupApplyPersonNum } / ${ board.hGroupPersonNum }</li>
            </c:if>
            <li>모임장 : ${ board.hBoardWriter }</li>
            <li>모임원 : ${ board.hGroupApplyPerson }</li>
         </ul>
         <c:url var="doApplyUrl" value="/hobby/board/doApply.do">
            <c:param name="category" value="${ board.refCategoryName }"></c:param>
            <c:param name="hBoardNo" value="${ board.hBoardNo }"></c:param>
         </c:url>
         <c:url var="undoApplyUrl" value="/hobby/board/undoApply.do">
            <c:param name="category" value="${ board.refCategoryName }"></c:param>
            <c:param name="hBoardNo" value="${ board.hBoardNo }"></c:param>
         </c:url>
         <button type="button" onclick="applyGroup('${ doApplyUrl}');">신청하기</button>
         <button type="button" onclick="cancelGroup('${ undoApplyUrl}');">취소하기</button>
      </div>
      <button onclick="popupClose();">닫기</button>
      <script>
         function popupClose() {
            window.close();
         }
         function applyGroup(url) {
            location.href = url;
         }
         function cancelGroup(url) {
            location.href = url;
            // alert("취소가 완료되었습니다.");
            // window.close();
         }
         function autoCreateBoard() {
            var url = document.getElementById("autoCloseAndExecute").getAttribute("autoCreateUrl");
            location.href = url;
            alert("소모임 게시물이 자동생성 되었습니다.");
            window.close();
         }
         var autoCloseAndExecuteElement = document.getElementById("autoCloseAndExecute");
         if (autoCloseAndExecuteElement) {
            autoCreateBoard();
         }
      </script>
   </body>
</html>