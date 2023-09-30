<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/header.css">
    <link rel="stylesheet" href="/resources/css/footer.css">
    <link rel="stylesheet" href="/resources/css/noticeEvent/write.css">
    <link rel="stylesheet" href="/resources/css/admin/main.css">
	<script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	  	integrity="sha256-7ZWbZUAi97rkirk4DcEp4GWDPkWpRMcNaEyXGsNXjLg=" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.css"
		integrity="sha256-IKhQVXDfwbVELwiR0ke6dX+pJt0RSmWky3WB2pNx9Hg=" crossorigin="anonymous">
	<title>Write</title>
	</head>
	<body>
		<!-- header -->
        <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        <!-- main -->
        <main>
			<div id="main_left">
                <table>
                    <tr>
                        <td><a href="/notice/list.do">공지사항</a></td>
                    </tr>
                    <tr>
                        <td><a href="/event/list.do">행사</a></td>
                    </tr>
                    <tr>
                        <td><a href="/newsRoom/list.do">뉴스룸</a></td>
                    </tr>
                </table>
            </div>
            <div id="main_middle">
                <h2><b>글 쓰기</b></h2>
                <hr>
                <form action="/noticeEvent/write.do" method="post" enctype="multipart/form-data" onsubmit="return blankValid();">
	                <div class="selectType">
	                    <select name="boardType" style="width: 15%;">
	                        <option value="NOTICE" selected>공지 등록</option>
	                        <option value="EVENT">행사 등록</option>
	                    </select>
	                    <label>제목</label><input type="text" name="boardTitle" class="title" style="width: 65%;">
	                </div>
	                <label>첨부파일</label>
					<input type="file" name="uploadFile" class="file"><br><br>
	                <textarea id="summernote" class="content" name="boardContent"></textarea>
	                <button type="submit" class="writeBtn success"><i class="fa-solid fa-check"></i>&nbsp;&nbsp;글 등록</button>
	                <button class="writeBtn cancel" onclick="javascript: window.history.back()"><i class="fa-solid fa-arrow-rotate-left"></i>&nbsp;돌아가기</button>
                </form>
            </div>
            <div id="main_right">
            
            </div>
        </main>
        <!-- footer -->
        <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"
		integrity="sha256-u7e5khyithlIdTpu22PHhENmPcRdFiHRjhAuHcs05RI=" crossorigin="anonymous"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/summernote-lite.min.js"
		integrity="sha256-5slxYrL5Ct3mhMAp/dgnb5JSnTYMtkr4dHby34N10qw=" crossorigin="anonymous"></script>
		
		<!-- language pack -->
		<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.20/dist/lang/summernote-ko-KR.min.js"
		integrity="sha256-y2bkXLA0VKwUx5hwbBKnaboRThcu7YOFyuYarJbCnoQ=" crossorigin="anonymous"></script>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
		  integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
        <script>
	      $('#summernote').summernote({
	        placeholder: '글을 등록하세요',
	        tabsize: 2,
	        height: 400,
	        lang: 'ko-KR'
	      });
	      
	      function blankValid(){
	    	  const select = document.querySelector('select');
	    	  const selectVal = select.value;
	    	  console.log(selectVal);
	    	  if(selectVal == "NOTICE"){
		        	if(document.querySelector(".content").value != "" &&
		                    document.querySelector(".title").value != ""){
		        		return true;
		        	} else {
		        		alert("제목과 내용은 빈칸일 수 없습니다");
		        		return false;
		        	}
	    	  } else if(selectVal == "EVENT"){
	    		  if(document.querySelector(".content").value != "" &&
		                    document.querySelector(".title").value != "" &&
		                    document.querySelector(".file").value != ""){
		        		return true;
		        	} else {
		        		alert("제목과 내용은 빈칸일 수 없습니다\n행사홍보관련 사진 파일을 업로드해주세요");
		        		return false;
		        	}
	    	  }
	        }
    	</script>
	</body>
</html>