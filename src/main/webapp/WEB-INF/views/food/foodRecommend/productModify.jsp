<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천상품 등록</title>
		<link rel="stylesheet" href="/resources/css/common/footer.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productReg.css">

	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
               <section>
                <form action="/foodProduct/modifyInfo.do" method="POST">
                		             
                        <h1>추천상품 수정</h1><br><hr><br>
                        
                        <input type="submit" value="제출"><br>
                        <input type="hidden" name="fProductId" value="${foodProduct.fProductId }">
                        <select name="fProductType" id="fProductType">
						    <option value="koreanfood" ${foodProduct.fProductType == 'koreanfood' ? 'selected' : ''}>한식</option>
						    <option value="chinesefood" ${foodProduct.fProductType == 'chinesefood' ? 'selected' : ''}>중식</option>
						    <option value="japanesefood" ${foodProduct.fProductType == 'japanesefood' ? 'selected' : ''}>일식</option>
						    <option value="westernfood" ${foodProduct.fProductType == 'westernfood' ? 'selected' : ''}>양식</option>
						    <option value="snackfood" ${foodProduct.fProductType == 'snackfood' ? 'selected' : ''}>분식</option>
                        </select>
                        <label>기업명</label> 
                        <input type="text" id="fProductCompany" name="fProductCompany" value="${foodProduct.fProductCompany }"><br><br>
                        <label>상품명</label> 
                        <input type="text" id="fProductName" name="fProductName" value="${foodProduct.fProductName }"><br><br>
                        <label>가격</label> 
                        <input type="text" id="fProductPrice" name="fProductPrice" value="${foodProduct.fProductPrice }"><br><br>
                        <label>간단설명</label> 
                        <input type="text" id="fProductSimple" name="fProductSimple" value="${foodProduct.fProductSimple }"><br><br>
                        <label for="textarea">영양정보</label> 
                        <textarea name="fProductInfo" id="fProductInfo" cols="30" rows="10">${foodProduct.fProductInfo }</textarea><br>                 
                        <label for="textarea">상세정보</label> 
                        <textarea name="fProductDetail" id="fProductDetail" cols="60" rows="10">${foodProduct.fProductDetail }</textarea><br>
                </form>
	            <br><br>  
               </section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>	
	</body>
</html>