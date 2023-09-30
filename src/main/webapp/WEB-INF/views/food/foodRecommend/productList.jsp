<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>추천상품 목록</title>
		<link rel="stylesheet" href="/resources/css/footer.css">
        <link rel="stylesheet" href="/resources/css/header.css">
        <link rel="stylesheet" href="/resources/css/reset.css">
        <link rel="stylesheet" href="/resources/css/food/product/productList.css">		
	</head>
	<body>
      <div class="container">
         <!-- header -->
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	        <nav class="nav_category">
	            <ul class="menu align-center expanded text-center SMN_effect-13">
	            	<li>
	                    <a href="/foodProduct/list.do" data-hover="전체">전체</a>
	                </li>
	                <li>
	                    <a href="/foodProduct/list.do?category=koreanfood" data-hover="KOREA">KOREA</a>
	                </li>
	                <li>
	                    <a href="/foodProduct/list.do?category=chinesefood" data-hover="CHINA">CHINA</a>
	                </li>
	                <li>
	                    <a href="/foodProduct/list.do?category=japanesefood" data-hover="JAPAN">JAPAN</a>
	                </li>
	                <li>
	                    <a href="/foodProduct/list.do?category=westernfood" data-hover="WESTERN">WESTERN</a>
	                </li>
	                <li>
	                    <a href="/foodProduct/list.do?category=snackfood" data-hover="SNACKFOOD">SNACKFOOD</a>
	                </li>
	            </ul>
	        </nav>
         <!-- main -->
            <main>
            <section>
                <br><br><br>                   
                <c:choose>
			        <c:when test="${empty category}">
			            전체
			        </c:when>
			        <c:otherwise>
			            ${foodProductSetList[0].foodProduct.fProductType}
			        </c:otherwise>
			    </c:choose>
                <br>
                <span>전체 상품 수 : ${pInfo.totalCount }</span>         
                <br><br>
                <h1>상품 리스트</h1><br><hr><br>
                <c:if test="${userId eq 'admin' }">
					<button onclick="productRegister();" id="product_register_button">상품등록</button>
                </c:if>

			<div class="product_list">
                <!-- 상품 리스트를 반복하여 출력합니다 -->
                <c:forEach var="productSet" items="${foodProductSetList}">
                    <div class="product_item">
                        <div class="image_thumbnail">
                            <img src="${productSet.foodProductFile.fProductFilepath}" alt="${productSet.foodProduct.fProductName}" 
                            onclick="showProductDetail(${productSet.foodProduct.fProductId}, ${productSet.foodProductFile.refFProductId})">
                        </div>
                        <div class="product_info">
                            <h2>${productSet.foodProduct.fProductName}</h2>
                            <br>
                            가격 : ${productSet.foodProduct.fProductPrice}원
                            <br>
                            간단설명 : ${productSet.foodProduct.fProductSimple}
                        </div>
                    </div>
                </c:forEach>        
            </div>
				<div class="pagination">
					<c:if test="${ pInfo.startNavi != 1 }">
					    <c:url var="prevUrl" value="/foodProduct/list.do">
					        <c:param name="page" value="${ pInfo.startNavi - 1 }"></c:param>
					        <c:if test="${not empty category}">
					            <c:param name="category" value="${category}" />
					        </c:if>
					    </c:url>
					    <a href="${prevUrl}">[이전]</a>
					</c:if>
					<c:forEach begin="${pInfo.startNavi}" end="${pInfo.endNavi}" var="p">
					    <c:url var="pageUrl" value="/foodProduct/list.do">
					        <c:param name="page" value="${p}"></c:param>
					        <c:if test="${not empty category}">
					            <c:param name="category" value="${category}" />
					        </c:if>
					    </c:url>
					    <a href="${pageUrl}">${p}</a>&nbsp;
					</c:forEach>
					<c:if test="${pInfo.endNavi != pInfo.naviTotalCount }">
					    <c:url var="nextUrl" value="/foodProduct/list.do">
					        <c:param name="page" value="${pInfo.endNavi + 1 }"></c:param>
					        <c:if test="${not empty category}">
					            <c:param name="category" value="${category}" />
					        </c:if>
					    </c:url>
					    <a href="${nextUrl}">[다음]</a>
					</c:if>


				</div>			
            </section>
            </main>

         <!-- footer -->
            <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
      </div>
      
      <script>
      function showProductDetail(fProductId, refFProductId) {    	    
    	    var isUserLoggedIn = <%= session.getAttribute("userId") != null %>;
    	    if (isUserLoggedIn) {    	       
    	        var url = "/foodProduct/productdetail.do?fProductId=" + fProductId + "&refFProductId=" + refFProductId;
    	        window.location.href = url;
    	    } else {    	        
    	        alert("로그인이 필요합니다.");
    	        var url = "/user/login.do";
    	        window.location.href = url;
    	    }
    	}
      

      function productRegister(){    	
    	  var url = "register.do";
    	  window.location.href = url;
      }
		</script>			
	</body>
</html>