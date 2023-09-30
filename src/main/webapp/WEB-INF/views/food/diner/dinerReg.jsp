<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>식당 정보 등록</title>
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
                <form action="/diner/register.do" method="POST">   
                        <br><br>                
                        <h1>식당정보 등록</h1><br><hr><br>
                        <br>                        
                        <select name="fDinerType" id="fDinerType" class="pl">
                            <option value="Seoul">서울</option>
                            <option value="Incheon">인천</option>
                            <option value="Gyeonggi">경기</option>
                        </select>
                        <br><br>
                        <div class="input_box">
                            <div class="input_title">
                                <label>식당명</label> 
                            </div>
                            <input type="text" id="fDinerName" name="fDinerName" placeholder="식당명을 입력하세요!"><br><br>
                        </div>
                        <div class="input_box">
                            <div class="input_title">
                                <label>주소</label> 
                            </div>
                            <input type="text" id="fDinerAddress" name="fDinerAddress" placeholder="주소 입력하세요!"><br><br>
                        </div>
                        <div class="input_box">
                            <div class="input_title">
                                <label>주차정보</label> 
                            </div>
                            <input type="text" id="fDinerParking" name="fDinerParking" placeholder="주차정보를 입력하세요!"><br><br>                        
                        </div>
                        <div class="input_box">
                            <div class="input_title">
                                <label>전화번호</label> 
                            </div>
                            <input type="text" id="fDinerPhone" name="fDinerPhone" placeholder="전화번호를 입력하세요!"><br><br>
                        </div>
                        <div class="input_box">
                            <div class="input_title">
                                <label>영업시간</label> 
                            </div>
                            <input type="text" id="fDinerBHour" name="fDinerBHour" placeholder="영업시간을 입력하세요!"><br><br>
                        </div>
                        <br><br><br><br>
                        <div id="textarea_box">
                            <label for="textarea">참고사항</label><br>                             
                            <textarea name="fDinerNote" id="fDinerNote" cols="70" rows="10"></textarea><br><br>                       
                        </div>
                        <br><br>
                    
                        <button id="submit-button" class="custom-btn btn-11">제출</button>
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
		            window.location.href = '/diner/register.do';
		        });
		    });
		</script>	      	
	</body>
</html>