<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="/resources/css/reset.css">
		<link rel="stylesheet" href="/resources/css/header.css">
		<link rel="stylesheet" href="/resources/css/footer.css">
		<link rel="stylesheet" href="/resources/css/index.css">
        <link rel="stylesheet" href="/resources/css/admin/17.companyHistory.css">

        <script src="https://kit.fontawesome.com/dbb376a4c5.js" crossorigin="anonymous"></script>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>CompanyHistory</title>
    </head>
    <body>
        <header class="sticky-top navbar navbar-expand-lg" style="padding-top: 0px;">
            <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
        </header>
        <main>
            <div class="section" id="section1">
                <div class="set1">
                    <div class="reveal one fade-bottom">
                        <h1>우리가</h1>
                    </div>
                    <div class="reveal two fade-bottom">
                        <h1>함께</h1>
                    </div>
                    <div class="reveal three fade-bottom">
                        <h1>걸어온 길</h1>
                    </div>
                </div>
            </div>
            <div class="section" id="section2">
                <div class="set2">
                    <div class="reveal oneL fade-bottom">
                        <h1>CNBC '혁신기업 50' 중 1위 선정 - <label style="color: red;">2024</label></h1>
                    </div>
                    <div class="reveal twoR fade-bottom">
                        <h1><label style="color: red;">2023</label> - 올해의 Best 웹 수상</h1>
                    </div>
                    <div class="reveal threeL fade-bottom">
                        <h1>뉴욕 증권 거래소 상장 - <label style="color: red;">2022</label></h1>
                    </div>
                    <div class="reveal fourR fade-bottom">
                        <h1><label style="color: red;">2022</label>- 회원 수 50만명 돌파</h1>
                    </div>
                </div>
            </div>
            </div>
        </main>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        <script>
            window.onload = function(){
                reveal();
                const elm = document.querySelectorAll('.section');
                const elmCount = elm.length;
                elm.forEach(function(item, index){
                    item.addEventListener('mousewheel', function(event){
                    event.preventDefault();
                    let delta = 0;

                    if (!event) event = window.event;
                    if (event.wheelDelta) {
                        delta = event.wheelDelta / 120;
                        if (window.opera) delta = -delta;
                    } 
                    else if (event.detail)
                        delta = -event.detail / 3;

                    let moveTop = window.scrollY;
                    let elmSelector = elm[index];

                    // wheel down : move to next section
                    if (delta < 0){
                        if (elmSelector !== elmCount-1){
                        try{
                            moveTop = window.pageYOffset + elmSelector.nextElementSibling.getBoundingClientRect().top;
                        }catch(e){}
                        }
                    }
                    // wheel up : move to previous section
                    else{
                        if (elmSelector !== 0){
                        try{
                            moveTop = window.pageYOffset + elmSelector.previousElementSibling.getBoundingClientRect().top;
                        }catch(e){}
                        }
                    }

                    const body = document.querySelector('html');
                    window.scrollTo({top:moveTop, left:0, behavior:'smooth'});
                    });
                });
    }


            function reveal() {
            var reveals = document.querySelectorAll(".reveal");
            for (var i = 0; i < reveals.length; i++) {
                var windowHeight = window.innerHeight;
                var elementTop = reveals[i].getBoundingClientRect().top;
                var elementVisible = 50;

                if (elementTop < windowHeight - elementVisible) {
                console.log(reveals.length);
                    reveals[i].classList.add("active");
                } else {
                    reveals[i].classList.remove("active");
                }
            }
        }
            
        window.addEventListener("scroll", reveal);

        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>