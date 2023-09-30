<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="/resources/css/reset.css">
      <link rel="stylesheet" href="/resources/css/header.css">
      <link rel="stylesheet" href="/resources/css/footer.css">
      <link rel="stylesheet" href="/resources/css/hobby/insert.css">
      <title>Special Alone</title>
   </head>
   <body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
               <form action="/hobby/board/insert.do" method="post" enctype="multipart/form-data">
                  <input type="hidden" name="refCategoryName" value="${ refCategoryName }">
                  <section class="hobby_insert_left">
                     <section class="hobby_board_title">
                        <a href="/hobby/board/list.do?category=${ refCategoryName }">${ refCategoryName }</a>
                     </section>
                     <section class="hobby_insert_nav" id="insertForm">
                        일시 : <input type="datetime-local" name="setTime" id="">
                        장소 : <input type="text" name="hGroupPlace" id="">
                        인원 : <input type="number" name="hGroupPersonNum" value="0" id="insertForm-personNum">
                        신청인 : ${ userId }
                     </section>
                  </section>
                  <section class="hobby_insert_center">
                     <section class="hobby_insert_center_top"></section>
                     <table>
                        <thead>
                           <tr>
                              <td class="hobby_insert_table_category">
                                 <select name="hBoardCategory" id="categoryValue" onchange="openInsertForm(value);">
                                    <option value="카테고리">카테고리</option>
                                    <option value="후기">후기</option>
                                    <option value="질문">질문</option>
                                    <option value="소모임모집">소모임 모집</option>
                                 </select>
                              </td>
                              <td class="hobby_insert_table_title">
                                 <input type="text" name="hBoardTitle" id="" placeholder="제목을 입력해주세요.">
                              </td>
                           </tr>
                        </thead>
                        <tbody>
                           <tr>
                              <td colspan="2" class="hobby_insert_table_content">
                                 <textarea name="hBoardContent" id="" placeholder="내용을 입력해주세요."></textarea>
                              </td>
                           </tr>
                        </tbody>
                     </table>
                     <section class="hobby_insert_center_bottom">
                        <div>
                           <input type="file" name="uploadFile" id="">
                        </div>
                        <div class="hobby_insert_listBTN">
                           <a href="#"><input type="button" value="    List    " onClick="javascript:history.go(-1);"></a>
                        </div>
                        <div>
                           <input type="submit" value="등록">
                        </div>
                     </section>
                  </section>
                  <section class="hobby_insert_right"></section>
               </form>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
      <script>
         function openInsertForm(value) {
            if(document.querySelector("#categoryValue").value == "소모임모집") {
               document.querySelector("#insertForm").style.display = "block";
            } else {
               document.querySelector("#insertForm").style.display = "none";
               document.querySelector("#insertForm-personNum").value = 0;
            }
         }
      </script>
   </body>
</html>