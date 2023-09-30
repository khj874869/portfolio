<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
      	<link rel="stylesheet" href="/resources/css/reset.css">
      	<link rel="stylesheet" href="/resources/css/header.css">
      	<link rel="stylesheet" href="/resources/css/footer.css">
      	<link rel="stylesheet" href="/resources/css/user/findUserId.css">
      	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap">
		<title>SpecialAlone 아이디 찾기</title>
		<script>
			function validateForm(){
				var userEmail = document.getElementById("userEmail").value;
				if(userEmail === ""){
					alert("이메일을 입력하세요.");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		<div class="container">
		<!-- header -->
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
			
		<!-- main -->
		<main>
			<div class="container-main">
				<section>
					<h1>Special Alone</h1><br>
					<h3>더 특별한 혼자가 되기를 바랍니다.</h3><br>
					<h2>아이디 찾기</h2><br><br>
					<div class="findUserIdArea">
						<form action="/user/findUserIdResult.do" method="get" onsubmit="return validateForm();">
							<input type="text" id="userEmail" name="userEmail" placeholder="가입시 입력했던 이메일을 입력하세요" class="in">
							<button type="submit" id="btn">아이디 찾기</button>
						</form>
						<a href="/user/findUserPw.do" class="button">비밀번호찾기</a>
						<a href="/user/register.do" class="button">회원가입</a>
					</div>
				</section>
			</div>
		</main>
			
		<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>