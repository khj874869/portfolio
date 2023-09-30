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
      <link rel="stylesheet" href="/resources/css/reset.css">
      <link rel="stylesheet" href="/resources/css/header.css">
      <link rel="stylesheet" href="/resources/css/footer.css">
      <link rel="stylesheet" href="/resources/css/hobby/detail.css">
      <title>Special Alone</title>
   </head>
   <body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
               <section class="hobby_detail_left">
                  <section class="hobby_detail_title">
                     <a href="/hobby/board/list.do?category=${ refCategoryName }">${ refCategoryName }</a>
                  </section>
                  <section class="hobby_detail_bigNav">
                     <div class="hobby_detail_memberInfo">
                        <a href="/hobby/board/searchBySession.do?category=${ refCategoryName }&hBoardWriter=${ hBoardWriter }">내가 쓴 글 보기</a>
                     </div>
                     <div class="hobby_detail_insertBTN">
                        <a href="/hobby/board/insert.do?category=${ refCategoryName }">
                           <input type="button" value="글쓰기">
                        </a>
                     </div>
                     <form action="/hobby/board/search.do" method="get">
                        <input type="hidden" name="category" value="${ refCategoryName }">
                        <div class="hobby_detail_searchOPT">
                           <select name="searchCondition1" id="">
                              <option value="카테고리">카테고리</option>
                              <option value="후기">후기</option>
                              <option value="질문">질문</option>
                              <option value="소모임모집">소모임 모집</option>
                              <option value="소모임">소모임</option>
                           </select>
                           <select name="searchCondition2" id="">
                              <option value="all">전체</option>
                              <option value="title">제목</option>
                              <option value="content">내용</option>
                              <option value="writer">작성자</option>
                           </select>
                        </div>
                        <div class="hobby_detail_searchBar">
                           <input type="text" name="searchKeyword" id="" placeholder="검색어를 입력해주세요.">
                           <input type="submit" value="검색">
                        </div>
                     </form>
                     <div class="hobby_detail_categorySelector">
                        <ul>
                           <li>
                              카테고리
                           </li>
                           <li>
                              <hr>
                           </li>
                           <li>
                              <a href="/hobby/board/searchByCategoryBar.do?category=${ refCategoryName }&searchCondition1=all">전체보기</a>
                           </li>
                           <li>
                              <a href="/hobby/board/searchByCategoryBar.do?category=${ refCategoryName }&searchCondition1=후기">후기</a>
                           </li>
                           <li>
                              <a href="/hobby/board/searchByCategoryBar.do?category=${ refCategoryName }&searchCondition1=질문">질문</a>
                           </li>
                           <li>
                              <a href="/hobby/board/searchByCategoryBar.do?category=${ refCategoryName }&searchCondition1=소모임모집">소모임 모집</a>
                           </li>
                           <li>
                              <a href="/hobby/board/searchByCategoryBar.do?category=${ refCategoryName }&searchCondition1=소모임">소모임</a>
                           </li>
                        </ul>
                     </div>
                  </section>
               </section>
               <section class="hobby_detail_center">
                  <section class="hobby_detail_center_top"></section>
                  <table class="hobby_detail_board_table">
                     <thead>
                        <tr class="hobby_detail_table_title">
                           <th>${ board.hBoardCategory }</th>
                           <th>${ board.hBoardTitle }</th>
                           <th>${ board.hBoardWriter }</th>
                           <th><fmt:formatDate pattern="yyyy-MM-dd" value="${ board.hBoardCreateDate }"/></th>
                           <th>${ board.hBoardReplyNum }</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <c:if test="${ board.hBoardCategory != '소모임'}">
                              <td colspan="5" class="hobby_detail_table_content">
                                 ${ board.hBoardContent }
                              </td>
                           </c:if>
                           <c:if test="${ board.hBoardCategory == '소모임'}">
                              <td colspan="5" class="hobby_detail_table_content">
                                 <h2>${ board.hBoardTitle }</h2>
                                 <ul>
                                    <li>일시 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ board.hGroupTime }"/></li>
                                    <li>장소 : ${ board.hGroupPlace }</li>
                                    <li>모집인원 : ${ board.hGroupApplyPersonNum } / ${ board.hGroupPersonNum }</li>
                                    <li>모임장 : ${ board.hBoardWriter }</li>
                                    <li>모임원 : ${ board.hGroupApplyPerson }</li>
                                 </ul>
                              </td>
                           </c:if>
                        </tr>
                     </tbody>
                  </table>
                  <section class="hobby_detail_center_bottom">
                     <div>
                        <a href="../resources/images/hobby/bUploadFiles/${ board.hBoardFilerename }" download>${ board.hBoardFilename }</a>
                     </div>
                     <div class="hobby_detail_listBTN">
                        <input type="button" value="    List    " onClick="javascript:history.go(-1);">
                     </div>
                     <c:if test="${ board.hBoardCategory != '소모임'}">
                        <c:url var="updateUrl" value="/hobby/board/update.do">
                           <c:param name="category" value="${ refCategoryName }"></c:param>
                           <c:param name="hBoardNo" value="${ board.hBoardNo }"></c:param>
                        </c:url>
                        <c:url var="boardDelUrl" value="/hobby/board/delete.do">
                           <c:param name="category" value="${ refCategoryName }"></c:param>
                           <c:param name="hBoardNo" value="${ board.hBoardNo }"></c:param>
                        </c:url>
                        <div>
                           <c:if test="${ board.hBoardWriter eq userId && board.hGroupPersonNum ne board.hGroupApplyPersonNum }">
                              <button type="button" onclick="updateBoard('${ updateUrl}');">수정</button>
                              <button type="button" onclick="deleteBoard('${ boardDelUrl }');">삭제</button>
                           </c:if>
                           <c:if test="${ board.hBoardWriter ne userId && board.hBoardCategory == '소모임모집' && userId ne null &&board.hGroupPersonNum ne board.hGroupApplyPersonNum }">
                              <button type="button" onclick="openPopup();">신청</button>
                           </c:if>
                        </div>
                     </c:if>
                     <c:if test="${ board.hBoardCategory == '소모임'}"><div></div></c:if>
                  </section>
                  <section class="hobby_detail_reply_tableBox">
                     <table class="hobby_detail_reply_table">
                        <thead>
                           <form action="/hobby/reply/insert.do" method="post">
                              <input type="hidden" name="refCategoryName" value="${ refCategoryName }">
                              <input type="hidden" name="refBoardNo" value="${ board.hBoardNo }">
                              <tr>
                                 <td colspan="4"><input type="text" name="hReplyContent" id="" placeholder="댓글을 입력하세요."></td>
                                 <td><input type="submit" value="등록"></td>
                              </tr>
                           </form>
                        </thead>
                        <tbody>
                           <c:forEach var="reply" items="${ rList }">
                              <tr>
                                 <td>${ reply.hReplyWriter }</td>
                                 <td>${ reply.hReplyContent }</td>
                                 <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ reply.hReplyCreateDate }"/></td>
                                 <td><a href="javascript:void(0);" onclick="showModifyForm(this, '${ reply.hReplyContent }');">수정</a></td> <!-- javascript:void(0); : 기본 기능 없애기 , 문자열은 홑따옴표로-->
                                 <td>
                                    <c:url var="delUrl" value="/hobby/reply/delete.do">
                                       <c:param name="category"      value="${ refCategoryName }"></c:param>
                                       <c:param name="hReplyNo" 	   value="${ reply.hReplyNo }"></c:param>
                                       <c:param name="hReplyWriter"   value="${ reply.hReplyWriter }"></c:param>	<!-- 본인 것만 지우게 하기 위해 작성자 추가 -->
                                       <c:param name="refBoardNo"    value="${ reply.refBoardNo }"></c:param>		<!-- 성공하면 detail로 가기위한 boardNo 세팅 -->
                                    </c:url>
                                    <a href="javascript:void(0);" onclick="deleteReply('${ delUrl }');">삭제</a>
                                 </td>
                              </tr>
                              <tr style="display: none;">
                                 <form action="/hobby/reply/update.do" method="post">
                                    <input type="hidden" name="refCategoryName"  value="${ refCategoryName }">
                                    <input type="hidden" name="hReplyNo"         value="${ reply.hReplyNo }">
                                    <input type="hidden" name="hReplyWriter"     value="${ reply.hReplyWriter }">
                                    <input type="hidden" name="refBoardNo"       value="${ reply.refBoardNo }">
                                    <td colspan="4"><input type="text" name="hReplyContent" value="${ reply.hReplyContent }"></td>
                                    <td><input type="submit" value="수정하기"></td>
                                 </form>
                              </tr>
                           </c:forEach>
                        </tbody>
                     </table>
                  </section>
               </section>
               <section class="hobby_detail_right"></section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
      <script>
         function updateBoard(url) {
            location.href = url;
         }
         function deleteBoard(url) {
            location.href = url;
         }
         function showModifyForm(obj, replyContent){
            obj.parentElement.parentElement.nextElementSibling.style.display="";	/* obj의 부모의 부모의 다음 element 값 */
         }
         function deleteReply(url) {
            location.href = url;
         }
         function openPopup() {
            var width = 400;
            var height = 450;
            var left = (window.innerWidth - width) / 2;
            var top = (window.innerHeight - height) / 2;
            var noticeWin = window.open("/hobby/board/popup.do?category=${ refCategoryName }&hBoardNo=${ board.hBoardNo }", "", "width=" + width + ", height=" + height + ", left=" + left + ", top=" + top);
            if (!noticeWin) {
               alert("팝업이 차단되었습니다. 팝업차단을 해제해주세요.");
            }
         }

      </script>
   </body>
</html>