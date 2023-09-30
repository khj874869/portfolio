<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
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
                <h1>추천상품 이미지수정</h1><br><hr><br>            
            <br><br>
				<form action="/foodProduct/modifyFile.do" method="POST" enctype="multipart/form-data">
	                <!-- 수정할 때, 리다이렉트 될 때 사용 -->
	                <input type="hidden" name="refFProductId" value="${refFProductId}">
	                <!-- 각 파일에 대한 히든 필드 추가 -->
	                <input type="hidden" name="updateImage1" value="false">
	                <input type="hidden" name="updateImage2" value="false">
	                <input type="hidden" name="updateImage3" value="false">
	                <input type="submit" value="파일수정">
	                <br><br><br>
	                <div id="image-file-container">
	                    <div id="image1" class="imageFile">
	                        <div id="image_container1" class="image_thumbnail">
	                        	<img src="${fPFileList[0].fProductFilepath}" alt="${fPFileList[0].fProductFilename }">	                            
	                        </div>
	                        <div id="image_reg_btn1" class="image_reg_btn">
	                            <!-- 파일을 수정할지 여부를 결정하는 체크박스를 추가 -->
	                            <input type="checkbox" name="updateImage1" value="true"> 파일 수정
	                            <input type="file" id="image1" name="imagename1"/>
	                        </div>
	                    </div>
	                    <div id="image2" class="imageFile">
	                        <div id="image_container2" class="image_thumbnail">
	                            <img src="${fPFileList[1].fProductFilepath}" alt="${fPFileList[0].fProductFilename }">
	                        </div>
	                        <div id="image_reg_btn2" class="image_reg_btn">
	                            <!-- 파일을 수정할지 여부를 결정하는 체크박스를 추가 -->
	                            <input type="checkbox" name="updateImage2" value="true"> 파일 수정
	                            <input type="file" id="image2" name="imagename2"/>
	                        </div>
	                    </div>
	                    <div id="image3" class="imageFile">
	                        <div id="image_container3" class="image_thumbnail">
	                            <img src="${fPFileList[2].fProductFilepath}" alt="${fPFileList[0].fProductFilename }">
	                        </div>
	                        <div id="image_reg_btn3" class="image_reg_btn">
	                            <!-- 파일을 수정할지 여부를 결정하는 체크박스를 추가 -->
	                            <input type="checkbox" name="updateImage3" value="true"> 파일 수정
	                            <input type="file" id="image3" name="imagename3"/>
	                        </div>
	                    </div>
	                </div>
	            </form>
            </section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>		
	</body>
</html>