<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천상품 등록</title>
		<link rel="stylesheet" href="/resources/css/footer.css">
        <link rel="stylesheet" href="/resources/css/header.css">
        <link rel="stylesheet" href="/resources/css/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productReg.css">
        <link rel="stylesheet" href="/resources/css/food/button.css">
        <link rel="stylesheet" href="/resources/css/food/selectbox.css">

	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
               <section>
                <form action="/foodProduct/register.do" method="POST">
                    <br><br>
                    <h1>추천상품 등록</h1><br><hr><br>
                    <br>
                    <select name="fProductType" id="fProductType" class="pl">
                        <option value="koreanfood">한식</option>
                        <option value="chinesefood">중식</option>
                        <option value="japanesefood">일식</option>
                        <option value="westernfood">양식</option>
                        <option value="snackfood">분식</option>
                    </select>
                    <br><br><br>
                    <div class="input_box">
                        <div class="input_title">
                            <label>기업명</label> 
                        </div>
                        <input type="text" id="fProductCompany" name="fProductCompany" placeholder="기업명을 입력하세요!"><br><br>
                    </div>
                    <div class="input_box">
                        <div class="input_title">
                            <label>상품명</label> 
                        </div>
                        <input type="text" id="fProductName" name="fProductName" placeholder="상품명을 입력하세요!"><br><br>
                    </div>
                    <div class="input_box">
                        <div class="input_title">
                            <label>가격</label> 
                        </div>
                        <input type="text" id="fProductPrice" name="fProductPrice" placeholder="가격을 입력하세요!"><br><br>                        
                    </div>
                    <div class="input_box">
                        <div class="input_title">
                            <label>간단설명</label> 
                        </div>
                        <input type="text" id="fProductSimple" name="fProductSimple" placeholder="설명을 입력하세요!"><br><br>
                    </div>
                    <br><br><br><br>
                    <div id="textarea_box">
                        <label for="textarea">영양정보</label><br>                             
                        <textarea name="fProductInfo" id="fProductInfo" cols="30" rows="10"></textarea><br><br>                       
                        <label for="textarea">상세정보</label><br> 
                        <textarea name="fProductDetail" id="fProductDetail" cols="60" rows="10"></textarea><br>
                    </div>
                    <br><br><br>
                    <button id="submit-button" class="custom-btn btn-11">제출</button>
                </form>
	            <br><br>  
               </section>
            </main>
	
         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
		<script>
		    document.addEventListener('DOMContentLoaded', function () {
		        var submitButton = document.getElementById('submit-button');
		
		        submitButton.addEventListener('click', function () {
		            window.location.href = '/foodProduct/register.do';
		        });
		    });
		</script>	
	</body>
</html>