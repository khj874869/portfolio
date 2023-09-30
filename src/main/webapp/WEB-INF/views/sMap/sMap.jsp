<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device=width, initial-scale=1 shrink-to-fit=no">
	<title>맵</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/security/smap.css">
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c7a14b510baba8f2aa2d6bdf15c8181a"></script>
	

</head>
<body>



<main>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<
<div id="map" style="width: 80%; height: 500px; margin-left:10%;"></div>
    
 

	

	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c7a14b510baba8f2aa2d6bdf15c8181a"></script>
	
	<script>
	var mapContainer = document.getElementById('map'), // 지도의 중심좌표
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.52250335538303,126.97511281291301), // 지도의 중심좌표
	        level: 8 // 지도의 확대 레벨
	    }; 

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	var markerData =[
		  {
		position: new kakao.maps.LatLng(37.48048226779397, 126.9862971037794),
        title: '사당역 칼부림 예고',
        content: '사당역 칼부림 예고',
        image: '/resources/images/police.jpg',
        link: 'https://www.topstarnews.net/news/articleView.html?idxno=15383443'
		  },
        {
    	position: new kakao.maps.LatLng(37.55173597799377,
    				126.92242351574195),
		title : '홍대 상상마당 칼부림 예고',
		content : '홍대 상상마당 칼부림 예고',
		image: '/resources/images/hongdae.png',
		link :'https://n.news.naver.com/article/003/0012019041?sid=102'		
        },
        {
    	position: new kakao.maps.LatLng(37.56653577399968,126.97805243344285),
		title : '시청역 폭탄테러',
		content : '시청역 폭탄테러',
		image : '/resources/images/bomb.png',
		link : 'https://n.news.naver.com/article/020/0003514001?sid=102'
	
        },  {
    		position: new kakao.maps.LatLng(37.56754515172555,126.97951230967526),
    		title : '서울시청 폭탄예고',
    		content : '서울시청 폭탄예고',
    		image: '/resources/images/sichung.png',
    		link: 'https://n.news.naver.com/article/437/0000355349?cds=news_edit'
    		
            },{
        		position: new kakao.maps.LatLng(37.554843106487965,126.9682324950644),
        		title : '용산구 칼부림',
        		content :  '용산구 칼부림',
        		image: '/resources/images/yongsan.png',
        		link: 'https://n.news.naver.com/article/025/0003298750?sid=102'
        	
                },
                {
            		position: new kakao.maps.LatLng(37.49706800400672,126.94759632030025),
            		title : '신림역 칼부림',
            		content : '신림역 칼부림',
            		image : '/resources/images/sinrim.png',
            		link: 'https://news.kbs.co.kr/news/pc/view/view.do?ncd=7729781'
            
                    },
                    {
                		position: new kakao.maps.LatLng(37.551504936647426,127.05594995898417),
                		title : '서울숲역 SM엔터테인먼트',
                		content : '서울숲역 SM엔터테인먼트',
                		image: '/resources/images/police.jpg',
                		link : 'https://m.mk.co.kr/star/view/2023/616277/'
                		
                        },
                        {
                    		position: new kakao.maps.LatLng(37.551504936647426,127.05594995898417),
                    		title : '혜화역',
                    		content : '혜화역',
                    		image : '/resources/images/police.jpg',
                    		link : 'https://n.news.naver.com/article/008/0004921576?sid=102'
                    		
                            }, {
                        		position: new kakao.maps.LatLng(37.51558406713862,127.02282623017605),
                        		title : '서초구 반포동 도로 한복판',
                        		content : '서초구 반포동 도로 한복판',
                        		image : '/resources/images/banpo.png',
                        		link: 'https://news.mt.co.kr/mtview.php?no=2023081016500825810'
                        		
                                },{
                            		position: new kakao.maps.LatLng(37.5071164421341,127.00959091016826),
                            		title : '서울고속버스터미널',
                            		content :'서울고속버스터미널',
                            		image : '/resources/images/gangnamterminal.png',
                            		link : 'https://news.imaeil.com/page/view/2023080411484095671'
                            		
                                    },{
                                		position: new kakao.maps.LatLng(37.55701460166768,127.06464597295061),
                                		title : '합정역 칼부림',
                                		content :'합정역 칼루림',
                                		image : '/resources/images/police.jpg',
                                		link : 'https://n.news.naver.com/article/449/0000255884'
                                		
                                        },{
                                    		position: new kakao.maps.LatLng(37.532579615850445,126.93555614545221),
                                    		title : '더현대 칼부림',
                                    		content :'더현대 칼루림',
                                    		image : '/resources/images/police.jpg',
                                    		link : 'https://twitter.com/make_save_korea/status/1689131375407054848?s=46&t=BX0mDNHizXtfLWo0lvcI-A'
                                    		
                                            },{
                                        		position: new kakao.maps.LatLng(37.63933654269959,126.9506916289992),
                                        		title : '구산역 인근 주택가',
                                        		content :'구산역 인근 주택가',
                                        		image : '/resources/images/police.jpg',
                                        		link : 'https://n.news.naver.com/article/081/0003387956'
                                        		
                                                },{
                                            		position: new kakao.maps.LatLng(37.568051339703935,127.04649944721719),
                                            		title : '왕십리역 살인예고',
                                            		content :'왕십리역 살인예고',
                                            		image : '/resources/images/police.jpg',
                                            		link : 'https://n.news.naver.com/article/025/0003298696'
                                            		
                                                    },{
                                                		position: new kakao.maps.LatLng(37.485887553474846,126.93197808767329),
                                                		title : '신림역 살인예고',
                                                		content :'신림역 살인예고',
                                                		image : '/resources/images/police.jpg',
                                                		link : 'https://n.news.naver.com/mnews/article/001/0014093397'
                                                		
                                                        },{
                                                    		position: new kakao.maps.LatLng(37.570273344996615,126.92855082311863),
                                                    		title : '경성고 칼부림예고',
                                                    		content :'경성고 칼부림예고',
                                                    		image : '/resources/images/police.jpg',
                                                    		link : 'http://weekly.chosun.com/news/articleView.html?idxno=28119'
                                                    		
                                                            },{
                                                            	position: new kakao.maps.LatLng(37.50255950713821,127.06197522483517),
                                                        		title : '한티역 칼부림',
                                                        		content :'한티역 칼부림',
                                                        		image : '/resources/images/police.jpg',
                                                        		link : 'https://www.topstarnews.net/news/articleView.html?idxno=15377289'
                                                            }
		
	]
	var overlays =[];
	  var overlayContainer = document.createElement('div');
      overlayContainer.className = 'overlay-container';

      mapContainer.appendChild(overlayContainer);

      function displayOverlay(markerData) {
    	    var existingOverlay = overlays.find(function (overlay) {
    	        return overlay.getTitle() === markerData.title;
    	    });

    	    if (existingOverlay) {
    	        var overlayContent = createOverlayContent(markerData);
    	        existingOverlay.setContent(overlayContent);
    	    } else {
    	        var overlayContent = createOverlayContent(markerData);
    	        var overlay = new kakao.maps.CustomOverlay({
    	            content: overlayContent,
    	            position: markerData.position,
    	            clickable: true
    	        });

    	        overlay.setMap(map);
    	        overlays.push(overlay);
    	    }
    	}

      function hideOverlay() {
    	    overlays.forEach(function (overlay) {
    	        overlay.setMap(null);
    	    });
    	    overlays = [];
    	}
      function closeOverlay(button) {
    	    var overlay = button.closest('.wrap');
    	    if (overlay) {
    	        overlay.setMap(null);
    	    }
    	}

      kakao.maps.event.addListener(map, 'click', function () {
  	    hideOverlay();
  	});
      function createOverlayContent(markerData) {
    	    var content ='<div class="wrap">' +
            '<div class="info">' +
            '<div class="title">' +
            markerData.title +
            '<div class="close" onclick="closeOverlay(this)" title="닫기"></div>' +
            '</div>' +
            '<div class="body">' +
            '<div class="img">' +
            '<img src="' + markerData.image + '" width="73" height="70">' +
            '</div>' +
            '<div class="desc">' +
            '<div class="ellipsis">' + markerData.content + '</div>' +
            '<div><a href="' + markerData.link + '" target="_blank" class="link">관련뉴스</a></div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    	    return content;
    	}

      for (var i = 0; i < markerData.length; i++) {
    	    var marker = new kakao.maps.Marker({
    	        map: map,
    	        position: markerData[i].position,
    	        title: markerData[i].title
    	    });

    	    kakao.maps.event.addListener(marker, 'click', function (data) {
    	        return function () {
    	            displayOverlay(data);
    	        };
    	    }(markerData[i])); 
    	}


</script>


	<section class="container">
	<input type="hidden" name="userId"value="${User.userId }" >
		<form method="POST" action="/comment/select.do" class="form-inline mt-3" style="font-family:emoji;">
			<select name="searchCondition" class="form-control mx-1 mt-2">
				<option value="Writer'">작성자</option>
				<option value="content" >내용</option>
			</select>
			<input type="text" name="searchKeyword" class="form-control mx-1 mt-2 col-10" placeholder="내용을 입력하세요.">
			<button type="submit" class="btn btn-outline-info mx-1 mt-2">검색</button>
			<a class="btn btn-outline-primary mx-1 mt-2 insert-Comment" id="openModalButton">댓글쓰기</a>
		</form>
<c:choose>
    <c:when test="${not empty Comments}">
    <c:forEach var="Comment" items="${Comments}">
		<div class="card bg-light mt-3">
			<div class="card-header bg-light">
			</div>
			<div class="card-body" style="font-family:emoji;">
				<h5 class="card-title; mx-3;">
					댓글
				</h5>&nbsp;
				<input type="hidden" value="${Comment.sCommentNo }">
				<p class="card-text">${Comment.userId }</p>
				<p class="card-text">${Comment.sCommentContent }</p>
				<div class="row">
				
					<div class="text-left">
						
							<c:if test="${Comment.sRecommend ne 0 }">
							<span style="color: red;">
							${Comment.sRecommend} 명의 사용자가 이 평가를 유익하다고 생각합니다.
							</span>
							
							</c:if> 
						<c:if test="${Comment.sRecommend eq 0 }">
						<span style="color: blue;"> 정보가 유익했나요? 도움이 되셨다면 추천을 눌러주세요. 
							</span>
						</c:if>
					</div>
					<div class="col-12 text-right">
					<c:if test="${Comment.userId ne sessionScope.userId }">
							<a class="fa fa-thumbs-o-up like-button" onclick="return confirm('추천하시겠습니까?')" data-comments="${Comment.sCommentNo}" >
   						 <span class="vote-count">${Comment.sRecommend}</span>
							</a>	
							</c:if>				
						<c:if test="${Comment.userId eq sessionScope.userId or User.userGrade eq '2' }">
						<a onclick="return confirm('삭제하시겠습니까?')"href="/comment/commentdelete.do?sCommentNo=${Comment.sCommentNo }">삭제</a>
						<a style="color:gray" data-toggle="modal" id="sCommentNo" data-commentno="${Comment.sCommentNo}" data-target="#editModal"href="/comment/updatecomment?sCommentNo=${Comment.sCommentNo }">수정</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>

					</c:forEach>
		 </c:when>
    <c:otherwise>
        <p>댓글이 없습니다.</p>
    </c:otherwise>
</c:choose>		
<div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="registerModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content"style="font-family:emoji;">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">댓글쓰기</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="insertComment" action="/comment/insertComment.do" method="POST">
                    <input type="hidden" name="userId" value="${User.userId}">
                    <input type="hidden" name="userNo" value="${User.userNo}">
                    <textarea id="commentContent" name="sCommentContent" class="form-control" rows="3"></textarea>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="insertButton">쓰기</button>
                <button type="button" class="btn btn-secondary" id="closeInsertButton" data-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content"style="font-family:emoji;">
            <div class="modal-header">
                <h5 class="modal-title edit-button" id="sCommentNo" data-scommentno="${Comment.sCommentNo }">댓글 수정</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
	          <form id="editCommentForm"action="/comment/update.do" method="POST" >
	          	<input type="hidden" name="sCommentNo" id="sCommentInput" value="${Comment.sCommentNo }">
                <textarea id="editCommentContent" name="sCommentContent" class="form-control" rows="3"></textarea>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" id="closeEditButton"data-dismiss="modal">닫기</button>
                <button type="submit" class="btn btn-primary" id="saveEditButton" data-comment-no="${Comment.sCommentNo }">저장</button>
            </div>
        </div>
    </div>
</div>
	</section>
</main>
  	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
  	<script>
  	$(document).ready(function() {
  	    $("#openModalButton").on("click", function(e) {
  	        e.preventDefault(); // 링크의 기본 동작 방지
  	        $("#registerModal").modal("show"); // 모달 열기
  	    });

  	});
  	$(document).ready(function() {
  	    $("#insertButton").on("click", function() {
  	        var commentData = $("#insertComment").serialize(); 
  	        $.ajax({
  	            type: "POST",
  	            url: "/comment/insertComment.do",
  	            data: commentData,
  	            success: function(response) {
  	                $("#registerModal").modal("hide");
                    location.replace(window.location.href);

  	            },
  	            error: function(xhr, status, error) {
  	                console.error(error);
  	            }
  	        });
  	    });
  	});
  	
	$('#editModal').on('show.bs.modal', function (event) {	
		    var commentno = $("#sCommentNo").data('commentno'); 
		    $('#sCommentInput').val(commentno); 
		});

	$(".edit-button").on("click", function() {
	    var sCommentNo = $(this).data("scommentno"); 
	    var reviewContent = $(this).closest("tr").find(".review-content").text();
	    $("#editReviewContent").val(reviewContent);
	    $("#saveEditButton").data("comment-no", sCommentNo); 
	    $("#editModal").modal("show");
	    
	    console.log("sCommentNo in modal:", sCommentNo); // 수정된 부분
	});
	
	$("#saveEditButton").on("click", function() {
	    var sCommentNo = $(this).data("comment-no"); // 수정된 부분
  	 	 $("#editCommentForm").submit();
	});
    $("#closeEditButton").on("click", function() {
        $("#editModal").modal("hide");
    });
    $(document).ready(function() {
        $(".fa.fa-thumbs-o-up.like-button").on("click", function(event) {
            event.preventDefault(); 

            var commentId = $(this).data("comments");
            var voteCountElement = $(this).find(".vote-count");

            if (localStorage.getItem('recommendedComment' + commentId)) {
                alert('이미 추천하셨습니다.');
                return; 
            }

            $.ajax({
                type: "POST",
                url: "/comment/insertrecommend.do",
                data: {
                    commentId: commentId
                },
                success: function(response) {
                    var updatedVoteCount = response;

                    localStorage.setItem('recommendedComment' + commentId, 'true');

                    voteCountElement.text(updatedVoteCount);
                    location.reload();
                },
                error: function(xhr, status, error) {
                    alert("추천 중 오류가 발생했습니다.");
                    console.error(error);
                }
            });
        });
    });
  	</script>
  	
</body>

</html>