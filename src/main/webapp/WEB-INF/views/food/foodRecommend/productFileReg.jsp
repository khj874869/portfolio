<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="/resources/css/footer.css">
        <link rel="stylesheet" href="/resources/css/header.css">
        <link rel="stylesheet" href="/resources/css/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productFileReg.css">
        <link rel="stylesheet" href="/resources/css/food/button.css">
	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

         <!-- main -->
            <main>
            <section>
                <h1>추천상품 이미지등록</h1><br><hr><br>            
            <br><br>
            <form action="/foodProduct/fileregister.do" method="POST" enctype="multipart/form-data">                
                <div id="image-file-container">
                    <div id="image1" class="imageFile">
                        <div id="image_container1" class="image_thumbnail"></div><br>
                        <div id="image_reg_btn1" class = "image_reg_btn">
                            <input type="file" id="image1" name="imagename1"/>
                        </div>
                    </div>
                    <div id="image2" class="imageFile">
                        <div id="image_container2" class="image_thumbnail"></div><br>
                        <div id="image_reg_btn2" class = "image_reg_btn">
                            <input type="file" id="image2" name="imagename2"/>
                        </div>
                    </div>
                    <div id="image3" class="imageFile">
                        <div id="image_container3" class="image_thumbnail"></div><br>
                        <div id="image_reg_btn3" class = "image_reg_btn">
                            <input type="file" id="image3" name="imagename3"/>
                        </div>
                    </div>
                </div>
                <br><br><br>
                <button id="submit-button" class="custom-btn btn-11">제출</button>
                <br><br>
            </form>
            </section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
    	<script>

	    document.addEventListener('DOMContentLoaded', function () {
	        var submitButton = document.getElementById('submit-button');
	
	        submitButton.addEventListener('click', function () {
	            window.location.href = '/foodProduct/fileregister.do';
	        });
	    });
    	
        // 파일 선택 버튼 1에 이벤트 리스너 추가
            document.querySelector('#image1 input[type="file"]').addEventListener('change', function(event) {
                const selectedFile = event.target.files[0];
                const imageContainer = document.querySelector('#image_container1');
        
                // 이미지 파일인지 확인
                if (selectedFile && selectedFile.type.startsWith('image')) {
                    const reader = new FileReader();
        
                    reader.onload = function() {
                        // 선택한 이미지를 미리보기로 표시
                        const image = new Image();
                        image.src = reader.result;
                        imageContainer.innerHTML = ''; // 이미지를 초기화
                        imageContainer.appendChild(image);
                    };
        
                    reader.readAsDataURL(selectedFile);
                } else {
                    // 이미지 파일이 아닌 경우에 대한 처리
                    imageContainer.innerHTML = '선택한 파일이 이미지가 아닙니다.';
                }
            });
        
            // 파일 선택 버튼 2, 3에 대해서도 동일하게 처리
            document.querySelector('#image2 input[type="file"]').addEventListener('change', function(event) {
                const selectedFile = event.target.files[0];
                const imageContainer = document.querySelector('#image_container2');
        
                // 이미지 파일인지 확인
                if (selectedFile && selectedFile.type.startsWith('image')) {
                    const reader = new FileReader();
        
                    reader.onload = function() {
                        // 선택한 이미지를 미리보기로 표시
                        const image = new Image();
                        image.src = reader.result;
                        imageContainer.innerHTML = ''; // 이미지를 초기화
                        imageContainer.appendChild(image);
                    };
        
                    reader.readAsDataURL(selectedFile);
                } else {
                    // 이미지 파일이 아닌 경우에 대한 처리
                    imageContainer.innerHTML = '선택한 파일이 이미지가 아닙니다.';
                }
            });
        
            document.querySelector('#image3 input[type="file"]').addEventListener('change', function(event) {
                const selectedFile = event.target.files[0];
                const imageContainer = document.querySelector('#image_container3');
        
                // 이미지 파일인지 확인
                if (selectedFile && selectedFile.type.startsWith('image')) {
                    const reader = new FileReader();
        
                    reader.onload = function() {
                        // 선택한 이미지를 미리보기로 표시
                        const image = new Image();
                        image.src = reader.result;
                        imageContainer.innerHTML = ''; // 이미지를 초기화
                        imageContainer.appendChild(image);
                    };
        
                    reader.readAsDataURL(selectedFile);
                } else {
                    // 이미지 파일이 아닌 경우에 대한 처리
                    imageContainer.innerHTML = '선택한 파일이 이미지가 아닙니다.';
                }
            });
    
        </script>  
	</body>
</html>