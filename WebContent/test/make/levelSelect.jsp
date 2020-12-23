<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- reset을 제일 위에 -->
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">
<link rel="stylesheet" href="../../assets/css/common/style.css" type="text/css">
<link href="../../assets/css/test/test_make.css" type="text/css" rel="stylesheet">
    

</head>

<body>
<!------------------------------------------- 헤더 -------------------------------------------------->
	<jsp:include page="../../common/header.jsp"></jsp:include>


	<section id="body" class="body">
		<div class="container">
			<main id="main" class="main">
				<!------------------------------------------- 메뉴  -------------------------------------------------->
				<jsp:include page="../../common/nav.jsp"></jsp:include>



            <section class="content">
               <div class="content-box">
                  <div class="level-select-container">
                <h1 class="title">난이도 설정</h1>
                <!-- <a href="#0" class="btn10">
                  <span>button 10</span>
                     <div class="transition"></div>
                  </a> -->
                <div class="level-select-box">
                    <a href="test.jsp" class="low-level test-levels">
                        <h1 class="level-title">초급</h1>
                        <span>테스트 제작이 처음이신가요??</span>
                        <span>간단한 테스트 제작부터<br> 시작해보세요!</span>
                        <span class="testLevel-content">질문 개수 6 <br>
                            답변 개수 2 <br>
                            평가항목 2 <br>
                            결과 개수 4 <br>
                        </span>
                     </a>
                    <a href="" class="middle-level test-levels">
                        <h1 class="level-title">중급</h1>
                        <span>테스트 제작에 익숙해지셨나요?</span>
                        <span>보다 다양한 결과를 <br> 추가해보세요!</span>
                        <span class="testLevel-content">질문 개수 12 <br>
                            답변 개수 3 <br>
                            평가항목 3 <br>
                            결과 개수 8 <br>
                        </span>
                     </a>
                    <a href="" class="hight-level test-levels">
                        <h1 class="level-title">고급</h1>
                        <span>더 세부적으로 유형을 나눠볼까요?</span>
                        <span>전문적인 테스트 제작자가 <br> 되어보세요!</span>
                        <span class="testLevel-content">질문 개수 20 <br>
                            답변 개수 4 <br>
                            평가항목 4 <br>
                            결과 개수 16 <br>
                        </span>
                     </a>
                  </div>
                </div>
                </div>
            </section>
         </main>
      </div>
   </section>
 	<!------------------------------------------- 풋터  -------------------------------------------------->
	<jsp:include page="../../common/footer.jsp"></jsp:include>
</body>

</html>