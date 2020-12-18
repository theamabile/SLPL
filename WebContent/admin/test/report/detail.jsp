<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 테스트 신고 목록</title>
<link href="../../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../../assets/css/admin/style.css" type="text/css" rel="stylesheet">
<link href="../../../assets/css/admin/reportTest.css" type="text/css" rel="stylesheet">

<!-- 상세페이지 넘어갔을 때 보여지는 것들 생각해오기 !
	1. 상세페이지 세부내용 : 폼유형, 난이도, 신고 아이디, 신고 유형, 신고 내용, 신고 날짜, (코멘트)
	2. 신고유형, 상태 -> DB는 숫자로, 사용자에게 나타낼때는 한글로 나타내는 방법
	3. 리스트에서도 추가 -> 폼유형, 난이도 타입 추가
	
 -->
<!-- 상태  -->
<script>
	window.addEventListener("load", function() {
		var testStartButton = document.querySelector(".test-start-button");
		var preButton = document.querySelector(".pre-button");
		
		
		preButton.onclick = function() {
			console.log("이전 페이지");
			location.href = "list";
		}

		testStartButton.onclick = function() {
			console.log("테스트 참여하기");
			location.href = "../../../test/play/action?id="+(${r.testId});
		}

	});
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../../common/header.jsp"></jsp:include>

	<div id="body" class="body">
		<!-- menu  -->
		<jsp:include page="../../common/menu.jsp"></jsp:include>

		<!-- main -->
		<main class="main">
			<section class="container">
				<h1 class="d-none">신고 테스트 검수</h1>

				<div class="detail-container">
					<!-- container-item클래스로 제작된걸 사이징만 해주기 위해 감쌌음 -->
					<section class="container-item">
						<h1>신고 테스트 검수</h1>
						<div class="margin-top first">
							<h3 class="d-done">공지사항 내용</h3>
							<table class="table">
								<tbody>
									<tr>
										<th>신고 번호</th>
										<td>${r.id}</td>
									</tr>
									<tr>
										<th>신고자 아이디</th>
										<td>${r.memberNicname}</td>
									</tr>
									<tr>
										<th>신고사유</th>
										<td>${r.reason}</td>
									</tr>
									<tr>
										<th>신고유형</th>
										<td>${r.type}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="button-area">
							<button type="button" value="test-start" class="puple-button-wf test-start-button">테스트 참여하기</button>
							<button type="button" value="pre-button" class="puple-button-wf pre-button">이전</button>
						</div>
					</section>
				</div>
			</section>
			<!-- footer -->
			<jsp:include page="../../common/footer.jsp"></jsp:include>
		</main>
	</div>


</body>
</html>