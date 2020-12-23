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
                  <div class="form-select-container">
                <h1 class="title">폼 카테고리 선택</h1>
                <div>
                    <a href="" class="test-form">
                        <h1 class="form-title">Yes or No</h1>
                        <span class="form-content">
                            Yes or No! <br>
                            복잡하지 않은 문제로 빠르게 테스트 제작을 만들 수 있는 폼 유형
                        </span>
                     </a>
                    <a href="levelSelect.jsp" class="test-form">
                        <h1 class="form-title">사지선다형</h1>
                        <span class="form-content">
                            
                            여러 답안을 작성하여 세부적으로 성향에 점수를 메길 수 있는 폼 유형 
                        </span>
                     </a>
                    <a href="" class="test-form">
                        <h1 class="form-title">사지선다<br>+ 점수 평가</h1>
                        <span class="form-content">
                            한 가지 성향에 대해 점수를 기준으로 결과를 나눌 수 있는 폼 유형
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