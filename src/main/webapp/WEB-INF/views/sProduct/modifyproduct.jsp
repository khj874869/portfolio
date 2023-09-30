<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/security/insertProduct.css">

<link rel="stylesheet"href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.3.0/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css"
		integrity="sha256-IKhQVXDfwbVELwiR0ke6dX+pJt0RSmWky3WB2pNx9Hg=" crossorigin="anonymous">
<style>
.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 10px;
}

</style>
</head>
<body>
<main>
	<jsp:include page="/WEB-INF/views/include/header.jsp"  />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.3.0/js/plugins/sortable.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/5.3.0/js/fileinput.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
<div id="left"></div>
	<div id="middle">
		<h2>상품 수정</h2>
		<form action="/product/update.do" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="sProductId" value="${Product.sProductId }">
<!-- 		기존 업로드 파일 체크할 때 사용 -->
			<input type="hidden" name="sFileName" 	 value="${Product.sFileName }">
			<input type="hidden" name="sFileReName" value="${Product.sFileReName }">
			<input type="hidden" name="sFilePath" 	 value="${Product.sFilePath }">
			<input type="hidden" name="sFileLength" value="${Product.sFileLength }">
			<div class="form-group">
				<label for="name">상품이름</label> <input type="text" class="form-control" id="productname" name="sProductName" value="${Product.sProductName }" >
			</div>
			<div class="form-group">
				<label for="price">가격</label> <input type="number" class="form-control" id="price" name="sPrice" value="${Product.sPrice} }">
			</div>
			<div class="form-group">
				<label for="summernote">설명</label>
				<textarea class="form-control" id="summernote" name="sDescription" value="${Product.sDescription} "></textarea>
			</div>
			<div class="form-group">
				<a href="../resources/image/${Product.sFileName }" download>${Product.sFileName }</a>
				<label for="productImage">상품 이미지:</label> <input id="productImage" type="file" name="uploadFile" class="file" data-show-upload="false" data-show-caption="true" >
			</div>
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="reset" class="btn btn-warning">리셋</button>
		</form>
	</div>
			<div id="right"></div>
	<script>
		$(document).ready(function() {
			$("#productImage").fileinput({
				browseClass : "btn btn-primary",
				showCaption : true,
				showRemove : false,
				showUpload : false,
				allowedFileExtensions : [ "jpg", "jpeg", "png", "gif" ]
			});
		});
		$(document).ready(function() {
		
			$('#summernote').summernote({
				  height: 300,                 // 에디터 높이
				  minHeight: null,             // 최소 높이
				  maxHeight: null,             // 최대 높이
				  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
				  lang: "ko-KR",					// 한글 설정
				  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
		          
			});
		});
	</script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"
			integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>
			
			<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"
			integrity="sha256-5slxYrL5Ct3mhMAp/dgnb5JSnTYMtkr4dHby34N10qw=" crossorigin="anonymous"></script>
			
			<!-- language pack -->
			<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/lang/summernote-ko-KR.min.js"
			integrity="sha256-y2bkXLA0VKwUx5hwbBKnaboRThcu7YOFyuYarJbCnoQ=" crossorigin="anonymous"></script>
			
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
			  integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</main>
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />

</body>
</html>