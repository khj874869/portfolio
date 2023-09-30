<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천상품 상세정보</title>
		<link rel="stylesheet" href="/resources/css/footer.css">
        <link rel="stylesheet" href="/resources/css/header.css">
        <link rel="stylesheet" href="/resources/css/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productDetail.css">
        <link rel="stylesheet" href="/resources/css/food/button.css">
	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
         <!-- main -->
        <main>
            <section>                
                <h1 id="Title">상품 상세정보</h1><br><hr><br>                               
                <h2>${foodProduct.fProductCompany }</h2><br>
                <p id="fProductName">${foodProduct.fProductName }</p>
                <br>       
                <br><br>
                <div id="product_list_first" class="product_list">
                    <div id="product_item1" class="product_item">
                        <div id="image_container1" class="image_thumbnail">
                            <img src="${fPFileList[0].fProductFilepath }" alt="${fPFileList[0].fProductFilerename }">
                        </div>
                    </div>
                    <div id="product_item2" class="product_item">
                        <div id="image_container2" class="image_thumbnail">
                            <img src="${fPFileList[1].fProductFilepath }" alt="${fPFileList[1].fProductFilerename }">
                        </div>
                    </div>
                    <div id="product_item3" class="product_item">
                        <div id="image_container3" class="image_thumbnail">
                            <img src="${fPFileList[2].fProductFilepath }" alt="${fPFileList[2].fProductFilerename }">
                        </div>
                    </div>
                </div>
                <br><br>
                <hr>
                
                <br><br>
                <div id="product_detail_container">
                    <div id="product_recommendation">
                        <span>상세정보</span> <br><br>
                        <br><br><br>
                        <p>${foodProduct.fProductDetail }</p>
                        <br><br><br><br><br><br><br>
                    </div>
                    <div id="product_starRev">
                        
                            <span>평균별점 : ${roundedRevStar}/5.0</span><br><br>
                            <span>한줄평 및 별점</span>
                            <br><br>                        
                            <p>1.${fPOneRevList[0].fProductOneRevWriter} :</p>
                            <p>${fPOneRevList[0].fProductOneRevStar}</p><br><br> 
                            <p>2.${fPOneRevList[1].fProductOneRevWriter} :</p>
                            <p>${fPOneRevList[1].fProductOneRevStar}</p><br><br>
                            <p>3.${fPOneRevList[2].fProductOneRevWriter} :</p>
                            <p>${fPOneRevList[2].fProductOneRevStar}</p><br><br>                                                  
                    </div>
                </div>
                <div id="product_nutrient_info">
                    <h3>식품정보</h3>
                    <p>${foodProduct.fProductInfo }</p>
                </div>
                <br>
                <div id="toReviewDiv">
                    <button onclick="toReviewReg(${foodProduct.fProductId})" id="toReviewBtn" class="custom-btn btn-11">리뷰작성</button>
                    <button onclick="toReviewList(${foodProduct.fProductId})" id="toReviewBtn" class="custom-btn btn-11">리뷰로 이동</button>
                </div>
            </section>
        </main>  
         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
      <script>
		function toReviewList(fProductId) {
		    // 리뷰 목록 페이지 URL을 생성하고 상품 ID를 쿼리 문자열로 추가
		    var url = '/foodProduct/revlist.do?fProductId=' + fProductId;		
		    // 새로운 URL로 이동
		    window.location.href = url;
		}
		function toReviewReg(fProductId) {
		    // 리뷰 목록 페이지 URL을 생성하고 상품 ID를 쿼리 문자열로 추가
		    var url = '/foodProduct/photoRevInfoRegister.do?fProductId=' + fProductId;		
		    // 새로운 URL로 이동
		    window.location.href = url;
		}		
		function toModifyForm(fProductId) {
		    // 리뷰 목록 페이지 URL을 생성하고 상품 ID를 쿼리 문자열로 추가
		    var url = '/foodProduct/modifyInfo.do?fProductId=' + fProductId;		
		    // 새로운 URL로 이동
		    window.location.href = url;
		}		
		</script>		
	</body>
</html>