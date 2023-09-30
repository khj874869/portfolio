<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고하기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/security/singo.css">

</head>
<body>
	
	
	<form id="reportPopup" action="/admin/singo.do" method="POST" >
    <select name="reason" id="categorySelect">
        <option value="폭력적인언어">폭력적인 언어</option>
        <option value="비적절한 내용">비적절한 내용</option>
        <option value="광고">광고</option>
    </select>
    <input type="hidden" name="productTitle" value="${Product.sProductName }">
    <input type="hidden" name="name" value="${rv.sUserId }">
    <input type="hidden" name="url" value="/product/sdetail.do?sProductId=${rv.sProductId }">
    <input type="hidden" name="content" value="${rv.sReviewContent }">
    <hr>
    <br>
   	<p>사유</p>
    <textarea rows="3"cols="50" name="singocontents"></textarea>
    
    <button id="submit" onclick="xx();">보내기</button>
    <button type="button" id="closePopup">닫기</button>
    
</form>
</body>
</html>