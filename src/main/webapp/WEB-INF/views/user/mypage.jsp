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
      	<link rel="stylesheet" href="/resources/css/user/mypage.css">
      	<link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap">
      	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<title>SpecialAlone 마이페이지</title>
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
				<h2>마이페이지</h2><br><br>
					<div class="mypageArea">
					<form action="/user/update.do" method="post">

						<input id="textbox" type="text" name="userId" value="${user.userId }" class="in" readonly>
						
						<input id="textbox" type="password" name="userPw" placeholder="비밀번호를 입력하세요" class="in"><br>
						
						<input id="textbox" type="text" name="userName" value="${user.userName }" class="in" readonly><br>
						
						<input name="userGender" value="${user.userGender }" class="in" readonly><br>
							<c:if test="${user.userGender eq 'M' }"></c:if>
							<c:if test="${user.userGender eq 'F' }"></c:if>
						
						<input id="userEmail" type="text" name="userEmail" value="${user.userEmail }" class="in"><br>
						<span id="userEmailMsg"></span>

						<input id="textbox" type="text" name="userPhone" value="${user.userPhone }" class="in"><br>

						<input id="userAddr" type="text" name="userAddr" value="${user.userAddr }" class="in_addr" readonly>
						<input type="button" onclick="sample4_execDaumPostcode();" value="주소검색" class="button"><br>

						관심사 : <input type="radio" name="userHobby" value="음식"> 음식
								 <input type="radio" name="userHobby" value="안전"> 안전
								 <input type="radio" name="userHobby" value="취미"> 취미 <br><br>
								 
						<button type="submit" id="btn">수정하기</button>
				</form>
				<form action="/user/delete.do" method="get">
					<input type="hidden" name="userId" value="${user.userId }">
					<button type="submit" id="btn" onclick="return confirm('정말 탈퇴하시겠습니까?');">탈퇴하기</button>
				</form>
				</div>
				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
				function sample4_execDaumPostcode(){
					new daum.Postcode({
						oncomplete : function(data){
							document.querySelector("#userAddr").value=data.roadAddress
						}
					}).open();
				}
				</script>
				<script>
 				$(document).ready(function () {
 				    var userEmailInput = $("#userEmail");
 				    var userEmailMsg = $("#userEmailMsg");

 				    userEmailInput.on("input", function () {
 				        var userEmail = userEmailInput.val();
 				        // 입력란이 비어 있는 경우 메시지를 숨깁니다.
 				        if (userEmail.trim() === "") {
 				            userEmailMsg.removeClass("valid invalid").text("");
 				            return;
 				        }
 				        // 이메일 주소의 형식을 정규 표현식으로 검사
 				        if (isValidEmailFormat(userEmail)) {
 				            // AJAX 요청을 사용하여 중복 여부를 서버에 보냅니다.
 				            $.ajax({
 				                url: "/user/checkUserEmail.do",
 				                method: "POST",
 				                data: { userEmail: userEmail },
 				                success: function (result) {
 				                    if (result === "valid") {
 				                        userEmailMsg.removeClass("invalid").addClass("valid").text("사용 가능한 이메일 주소입니다.");
 				                    } else {
 				                        userEmailMsg.removeClass("valid").addClass("invalid").text("이미 사용 중인 이메일 주소입니다.");
 				                    }
 				                }
 				            });
 				        } else {
 				            // 형식이 올바르지 않은 경우 메시지를 표시
 				            userEmailMsg.removeClass("valid").addClass("invalid").text("유효하지 않은 이메일 주소 형식입니다.");
 				        }
 				    });
 				});
 				// 이메일 주소의 형식을 정규 표현식으로 검사하는 함수
 				function isValidEmailFormat(email) {
 				    // 간단한 이메일 형식 유효성 검사 정규 표현식
 				    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
 				    return emailPattern.test(email);
 				}
 				</script>
			</section>
			</div>
		</main>
			
		<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		</div>
	</body>
</html>