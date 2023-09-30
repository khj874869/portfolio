<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천식당 목록</title>
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/header.css">
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/food/diner/dinerList.css">
</head>
<body>
	<div class="container">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>

		<!-- main -->
		<nav class="nav_region">
			<ul>
				<li><a href="/diner/list.do">전체</a></li>
				<li><a href="/diner/list.do?region=Seoul">서울</a></li>
				<li><a href="/diner/list.do?region=Incheon">경기</a></li>
				<li><a href="/diner/list.do?region=Gyeonggi">인천</a></li>
			</ul>
		</nav>
		<main>
			<section>
				<h1>추천식당 목록</h1>
				<br>
				<br><br><br>                   
                <c:choose>
			        <c:when test="${empty region}">
			            전체
			        </c:when>
			        <c:otherwise>
			            ${dinerSetList[0].diner.fDinerType}
			        </c:otherwise>
			    </c:choose>
                <br>
                <span>전체 상품 수 : ${pInfo.totalCount }</span> 
				<hr>
				<br> <br>

				<c:forEach var="dinerSet" items="${dinerSetList}">

					<div class="diner-list">
						<!-- 이미지 영역 -->
						<div class="dinerListImage">
							<img src="${dinerSet.dinerFile.fDinerFilepath}"
								alt="${dinerSet.dinerFile.fDinerFilename}"
								onclick="showDinerDetail(${dinerSet.diner.fDinerId}, ${dinerSet.dinerFile.refFDinerId})">
						</div>
						<!-- 정보 영역 -->
						<div class="dinerListInfo">
							<p id="dinerName">${dinerSet.diner.fDinerName}</p>
							<br>
							<h3>${dinerSet.diner.fDinerAddress}</h3>
							<br>
							<p>
								대표메뉴 <br> <br> 간단설명 : ${dinerSet.diner.fDinerNote}
							</p>
						</div>
						<!-- 영업시간 영역 -->
						<div class="dinerListImage">
							<p>
								영업시간 <br> ${dinerSet.diner.fDinerBHour}<br> <br>
							</p>
						</div>
					</div>
				
				</c:forEach>

				<div class="pagination">
					<c:if test="${ pInfo.startNavi != 1 }">
					    <c:url var="prevUrl" value="/diner/list.do">
					        <c:param name="page" value="${ pInfo.startNavi - 1 }"></c:param>
					        <c:if test="${not empty region}">
					            <c:param name="region" value="${region}" />
					        </c:if>
					    </c:url>
					    <a href="${prevUrl}">[이전]</a>
					</c:if>
					<c:forEach begin="${pInfo.startNavi}" end="${pInfo.endNavi}" var="p">
					    <c:url var="pageUrl" value="/diner/list.do">
					        <c:param name="region" value="${p}"></c:param>
					        <c:if test="${not empty category}">
					            <c:param name="region" value="${region}" />
					        </c:if>
					    </c:url>
					    <a href="${pageUrl}">${p}</a>&nbsp;
					</c:forEach>
					<c:if test="${pInfo.endNavi != pInfo.naviTotalCount }">
					    <c:url var="nextUrl" value="/diner/list.do">
					        <c:param name="page" value="${pInfo.endNavi + 1 }"></c:param>
					        <c:if test="${not empty region}">
					            <c:param name="region" value="${region}" />
					        </c:if>
					    </c:url>
					    <a href="${nextUrl}">[다음]</a>
					</c:if>
				</div>
				<br> <br> <br>

			</section>
		</main>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
	<script>
	      function showDinerDetail(fDinerId, refFDinerId) {    	    
	    	    var isUserLoggedIn = <%=session.getAttribute("userId") != null%>;
	    	    if (isUserLoggedIn) {    	       
	    	    	var url = "/diner/dinerDetail.do?fDinerId=" + fDinerId + "&refFDinerId=" + refFDinerId;
	    	        window.location.href = url;
	    	    } else {    	        
	    	        alert("로그인이 필요합니다.");
	    	        var url = "/user/login.do";
	    	        window.location.href = url;
	    	    }
	    	}		
		</script>
</body>
</html>