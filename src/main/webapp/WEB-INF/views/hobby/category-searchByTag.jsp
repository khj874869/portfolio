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
      <link rel="stylesheet" href="/resources/css/hobby/category.css">
      <title>Special Alone</title>
   </head>
   <body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
               <section class="hobby_category_left"></section>
               <section class="hobby_category_center">
                  <div class="hobby_category_center_top">
                     <div class="hobby_category_tag">
                        <form action="/hobby/category/searchByTag.do" method="get">
                           <ul>
                              <li>
                                 <input type="submit" name="searchCondition" value="indoor">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="outdoor">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="alone">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="together">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="health">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="exercise">
                              </li>
                              <li>
                                 <input type="submit" name="searchCondition" value="art">
                              </li>
                           </ul>
                        </form>
                     </div>
                     <c:if test= "${ userId eq 'admin' }">
                        <div class="hobby_category_functionBTN">
                           <input type="button" value="등록" onclick="openInsertForm();">
                           <input type="button" value="삭제" onclick="openDeleteBTN();">
                        </div>
                     </c:if>
                     <c:if test= "${ userId ne 'admin' }">
                        <div class="hobby_category_functionBTN"></div>
                     </c:if>
                     <form action="/hobby/category/searchByKeyword.do" method="get">
                        <div class="hobby_category_searchBar">
                           <input type="text" name="searchKeyword" id="" placeholder="Search">
                           <input type="submit" value="검색">
                        </div>
                     </form>
                  </div>
                  <div class="hobby_category_center_bottom">
                     <div class="hobby_category_col" id="insertForm">
                        <div class="hobby_category_row"></div>
                        <div class="hobby_category_row">
                           <form action="/hobby/category/insert.do" method="post" enctype="multipart/form-data">
                              <div class="hobby_category_image">
                                 <input type="file" name="uploadFile" id="">
                              </div>
                              <div class="hobby_category_titleBox">
                                 <input type="text" name="hCategoryName" id="" placeholder="카테고리를 입력해주세요.">
                                 <select name="hCategoryTag" id="">
                                    <option value="">태그</option>
                                    <option value="indoor">실내</option>
                                    <option value="outdoor">실외</option>
                                    <option value="alone">혼자</option>
                                    <option value="together">같이</option>
                                    <option value="health">건강</option>
                                    <option value="exercise">운동</option>
                                    <option value="art">예술</option>
                                 </select>
                              </div>
                              <div class="hobby_category_insertBTN">
                                 <input type="submit" value="V">
                              </div>
                           </form>
                        </div>
                        <div class="hobby_category_row"></div>
                     </div>

                     <c:forEach var="category" items="${tagList}" varStatus="loop">
                        <c:if test="${loop.index % 3 == 0}">
                           <div class="hobby_category_col">
                        </c:if>
                        <div class="hobby_category_row">
                           <form action="/hobby/category/delete.do" method="post">
                              <input type="hidden" name="hCategoryName" value="${category.hCategoryName}">
                              <div class="hobby_category_image">
                                 <a href="/hobby/board/list.do?category=${category.hCategoryName}">
                                    <img src="../../../resources/images/hobby/cUploadFiles/${category.hCategoryFilename}" alt="">
                                 </a>
                              </div>
                              <div class="hobby_category_titleBox">
                                 <span class="hobby_category_title">${category.hCategoryName}</span>
                              </div>
                              <input type="submit" value="X" class="deleteBTN">
                           </form>
                        </div>
                        <c:if test="${loop.index % 3 == 2 or loop.last}">
                           </div>
                        </c:if>
                     </c:forEach>

                  </div>
               </section>
               <section class="hobby_category_right"></section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
      <script>
         function openInsertForm() {
            document.querySelector("#insertForm").style.display = "flex";
         }
         function openDeleteBTN() {
            var deleteButtons = document.querySelectorAll(".deleteBTN");

            // NodeList의 각 요소에 대한 루프
            deleteButtons.forEach(function(button) {
               button.style.display = "block"; // 스타일 설정
            });
         }
      </script>
   </body>
</html>