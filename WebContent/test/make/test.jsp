<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<!-- reset을 제일 위에 -->
<link rel="stylesheet" href="../../assets/css/reset.css" type="text/css">

<link href="../../assets/css/test/test_make.css" type="text/css"
	rel="stylesheet">
<script src="../../assets/js/test/make/test.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

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
						<h1 class="d-none">테스트 제작 페이지</h1>
						<div class="create-container" id="create-container">
							<div class="title">
								<h1>테스트 제작</h1>
								<input type="range">
							</div>
							<section class="input-container low-step1 active">
								<form id="reg-test" action="reg-test" method="post">
									<div class="testName-box">
										<h1>테스트명</h1>
										<input type="text" maxlength="20" autofocus
											placeholder="테스트명을 작성해주세요" name="test-name">
									</div>
									<div class="type-box">
										<h1>성격 유형</h1>
										<input type="button" class="gray-button-s" value="예시보기">
										<p class="ex-list d-none">
											다음 유형들을 참고하세요 <br> <br> 친화력, 협동성, 사교적, 성실함, 인내심,
											정직성<br> 책임감, 현실적, 능동적, 비열함, 사회성, 냉철함<br> 자발성, 위법성,
											나태함, 능동성, 폭력성, 신뢰성<br> 지도성, 사교성, 집중력, 침착성, 창의성, 인내성
										</p>
										<div class="type-input">
											<span>1</span> <input class="type1" name="types" type="text">
											<span>2</span> <input class="type2" name="types" type="text">
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question1" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>1/6</P>
										<input name="page" value="1" type="text" class="d-none page">
										<div class="question">
											<span>문제1</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question2" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>2/6</P>
										<input name="page" value="2" type="text" class="d-none page">
										<div class="question">
											<span>문제2</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question2" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>3/6</P>
										<input name="page" value="3" type="text" class="d-none page">
										<div class="question">
											<span>문제3</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question2" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>4/6</P>
										<input name="page" value="4" type="text" class="d-none page">
										<div class="question">
											<span>문제4</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question2" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>5/6</P>
										<input name="page" value="5" type="text" class="d-none page">
										<div class="question">
											<span>문제5</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step2">
								<form id="reg-question2" action="reg-question" method="post"
									encType="multipart/form-data">
									<div class="question-container">
										<P>6/6</P>
										<input name="page" value="6" type="text" class="d-none page">
										<div class="question">
											<span>문제6</span> <input class="question-content"
												name="question" type="text">
										</div>
									</div>
									<div class="question-img-box">
										<div class="question-img">
										</div>
											<input type="file" name="file" class="file file-input" onchange="previewImg(this)" />
									</div>
									<div class="answer-box">
										<input type="text" class="preview-type1" readonly> <input
											type="text" class="preview-type2" readonly>
										<div class="answer-set">
											<span>선택지1</span> <input class="answer1" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
										<div class="answer-set">
											<span>선택지2</span> <input class="answer2" name="answer"
												type="text"> <select name="type-value"
												class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select> <select name="type-value" class="type-value">
												<option value="-1">-1</option>
												<option value="0">0</option>
												<option value="1">1</option>
											</select>
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step3">
								<form id="reg-result-name" action="reg-result-name"
									method="post">
									<h1 class="title-h1">결과 이름 짓기</h1>
									<div class="name-container">
										<div class="types">
											<input type="text" class="preview-type1" readonly> <input
												type="text" class="preview-type2" readonly>
										</div>
										<div class="result-name-container">
											<p>결과1</p>
											<input type="text" readonly value="높음"> <input
												type="text" readonly value="높음"> <input type="text"
												class="result-name" name="result-name">
										</div>
										<div class="result-name-container">
											<p>결과2</p>
											<input type="text" readonly value="높음"> <input
												type="text" readonly value="낮음"> <input type="text"
												class="result-name" name="result-name">
										</div>
										<div class="result-name-container">
											<p>결과3</p>
											<input type="text" readonly value="낮음"> <input
												type="text" readonly value="높음"> <input type="text"
												class="result-name" name="result-name">
										</div>
										<div class="result-name-container">
											<p>결과4</p>
											<input type="text" readonly value="낮음"> <input
												type="text" readonly value="낮음"> <input type="text"
												class="result-name" name="result-name">
										</div>
								</form>
							</section>
							<section class="input-container low-step4">
								<form id="reg-result-content" action="reg-result-content"
									method="post" encType="multipart/form-data">
									<div class="result-detail-container">
										<input name="page" value="1" type="text" class="d-none page">
										<div class="detail-content">
											<div>
												<p class="result-type1 blue-text">도덕성</p>
												<p class="result-type2 blue-text">사교성</p>
											</div>
											<span class="result-name">결과이르으으음</span>
											<textarea name="result-content" class="result-content"
												placeholder="결과에 대한 설명을 작성해주세요"></textarea>
										</div>
										<div class="img-container">
											<div class="img"></div>
											<!-- 나중에 자바스크립트로 변경예정 -->
											<input  class="file file-input"  name="result-img" type="file"
												accept="image/gif,image/jpeg,image/png" onchange="previewImg(this)" >
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step4">
								<form id="reg-result-content" action="reg-result-content"
									method="post" encType="multipart/form-data">
									<div class="result-detail-container">
										<input name="page" value="2" type="text" class="d-none page">
										<div class="detail-content">
											<div>
												<p class="result-type1 blue-text">도덕성</p>
												<p class="result-type2 gray-text">사교성</p>
											</div>
											<span class="result-name">결과이르으으음</span>
											<textarea name="result-content" class="result-content"
												placeholder="결과에 대한 설명을 작성해주세요"></textarea>
										</div>
										<div class="img-container">
											<div class="img"></div>
											<!-- 나중에 자바스크립트로 변경예정 -->
											<input  class="file file-input"  name="result-img" type="file"
												accept="image/gif,image/jpeg,image/png" onchange="previewImg(this)" >
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step4">
								<form id="reg-result-content" action="reg-result-content"
									method="post" encType="multipart/form-data">
									<div class="result-detail-container">
										<input name="page" value="3" type="text" class="d-none page">
										<div class="detail-content">
											<div>
												<p class="result-type1 gray-text">도덕성</p>
												<p class="result-type2 blue-text">사교성</p>
											</div>
											<span class="result-name">결과이르으으음</span>
											<textarea name="result-content" class="result-content"
												placeholder="결과에 대한 설명을 작성해주세요"></textarea>
										</div>
										<div class="img-container">
											<div class="img"></div>
											<!-- 나중에 자바스크립트로 변경예정 -->
											<input class="file file-input" name="result-img" type="file"
												accept="image/gif,image/jpeg,image/png" onchange="previewImg(this)" >
										</div>
									</div>
								</form>
							</section>
							<section class="input-container low-step4">
								<form id="reg-result-content" action="reg-result-content"
									method="post" encType="multipart/form-data">
									<div class="result-detail-container">
										<input name="page" value="4" type="text" class="d-none page">
										<div class="detail-content">
											<div>
												<p class="result-type1 gray-text">도덕성</p>
												<p class="result-type2 gray-text">사교성</p>
											</div>
											<span class="result-name">결과이르으으음</span>
											<textarea name="result-content" class="result-content"
												placeholder="결과에 대한 설명을 작성해주세요"></textarea>
										</div>
										<div class="img-container">
											<div class="img"></div>
											<!-- 나중에 자바스크립트로 변경예정 -->
											<input  class="file file-input"  name="result-img" type="file"
												accept="image/gif,image/jpeg,image/png" onchange="previewImg(this)" >
										</div>
									</div>
								</form>
							</section>.
							<section class="input-container low-step5">
								<form id="update-cover-img" action="update-cover-img"
									method="post" encType="multipart/form-data">
									<h1 class="title-h1">테스트 표지 등록</h1>
											<span class="mainCover-text">표지에 나올 설명</span>
									<div class="cover-container">
										<div class="mainCover-img">
										</div>

										<!-- 나중에 자바스크립트로 변경예정 -->
										<input  class="file"  type="file" accept="image/gif,image/jpeg,image/png" onchange="previewImg(this)" >
									</div>
								</form>
							</section>
							<section class="input-container low-step6">
								<h1 class="title-h1">결과 미리보기</h1>
								<div class="result-preview-container">
									<div class="result-preview">
										<div class="result">
											<div class="result-img"  style="background: center / cover no-repeat url('/test/make/character-img?no=1')"></div>
											<div class="text">
												<p>${name1}</p>
											</div>
										</div>
										<div class="result">
											<div class="result-img"  style="background: center / cover no-repeat url('/test/make/character-img?no=2')"></div>
											<div class="text">
											<p>${requestScope.name2}</p>
											</div>
										</div>
										<div class="result">
											<div class="result-img"  style="background: center / cover no-repeat url('/test/make/character-img?no=3')"></div>
											<div class="text"></div>
										</div>
										<div class="result">
											<div class="result-img"  style="background: center / cover no-repeat url('/test/make/character-img?no=4')"></div>
											<div class="text"></div>
										</div>
									</div>
								</div>
							</section>
							<nav class="nav-buttons">
								<input type="button" value="pro" class="puple-button-m">
								<input type="button" value="next" class="puple-button-m">
							</nav>
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