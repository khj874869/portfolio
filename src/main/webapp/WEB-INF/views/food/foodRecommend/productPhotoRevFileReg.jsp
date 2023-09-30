<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천식당 포토리뷰 파일등록폼</title>
		<link rel="stylesheet" href="/resources/css/common/footer.css">
        <link rel="stylesheet" href="/resources/css/common/header.css">
        <link rel="stylesheet" href="/resources/css/common/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productFileReg.css">
	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
            <section>
                <h2>${fProductCompany }</h2>
                <h3>${fProductName }</h3>    
                <h1>포토리뷰 이미지등록</h1><br><hr><br>            
            <br><br>
            <form action="/foodProduct/photorevfilereg.do" method="POST" enctype="multipart/form-data">
            	
            	<!-- <input type="hidden" name="fProductId" value="${fProductId }">
            		포토리뷰 파일등록하고 해당상세리스트로 보내려고 이걸 써서 fProductId를 컨트롤러로 넘기고 RequestParam으로 받으려고
            		시도했는데 RequestParam으로 fProductId를 받으면 파일도 안들어가고 에러발생 400에러 일단 전체상품리스트로 넘김
            	 -->
                <input type="submit" value="파일등록">
                <br><br><br>
                <div id="image-file-container">
                    <div id="image1" class="imageFile">
                        <div id="image_container1" class="image_thumbnail"></div>
                        <div id="image_reg_btn1" class = "image_reg_btn">
                            <input type="file" id="image" name="revImageName1"/>
                        </div>
                    </div>
                    <div id="image2" class="imageFile">
                        <div id="image_container2" class="image_thumbnail"></div>
                        <div id="image_reg_btn2" class = "image_reg_btn">
                            <input type="file" id="image" name="revImageName2"/>
                        </div>
                    </div>
                    <!-- 이미지 썸네일 -->
                </div>
            </form>
            </section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>		
	</body>
</html>