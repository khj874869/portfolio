<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="/resources/css/reset.css">
		<link rel="stylesheet" href="/resources/css/header.css">
		<link rel="stylesheet" href="/resources/css/footer.css">
		<link rel="stylesheet" href="/resources/css/index.css">
		<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<link type="text/css" rel="stylesheet" href="css/styles.css">
    	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<title>Special Alone</title>
	</head>
	
	<body>
		<div class="container">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<!-- main -->
		<main>
			<section class="index_background">
				<div id="index">
					<div id="slide">
						<ul>
							<li><a href="#"><img id="slide_image" src="/resources/images/user_images/slide-image1.png" alt="슬라이드1"></a></li>
							<li><a href="#"><img id="slide_image" src="/resources/images/user_images/slide-image2.png" alt="슬라이드2"></a></li>
							<li><a href="#"><img id="slide_image" src="/resources/images/user_images/slide-image3.png" alt="슬라이드3"></a></li>
							<li><a href="#"><img id="slide_image" src="/resources/images/user_images/slide-image4.png" alt="슬라이드4"></a></li>
						</ul>
					</div>
				</div>
			</section>
		</main>
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
  		<script>
  	        $(document).ready(function() {
  	            $('#slide ul li').hide();
  	            $('#slide ul li:first-child').show();
	
  	            setInterval(function() {
  	                $('#slide ul li:first-child').fadeOut()
  	                    .next().fadeIn().end(1000)
  	                    .appendTo('#slide ul');
  	            }, 3000);
  	        });
  	    </script>
	</body>
</html>