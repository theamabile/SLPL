<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>관리자 - 회원관리</title>
<link href="../../../assets/css/reset.css" type="text/css" rel="stylesheet">
<link href="../../../assets/css/admin/style.css" type="text/css"
	rel="stylesheet">
<link href="../../../assets/css/admin/community.css" type="text/css"
	rel="stylesheet">


<script>
        
     window.onload = function() {
        console.log("시작");

        var allCheckBox = document.getElementById("checkAll");
        allCheckBox.onchange = function() {
            var checks = document.getElementsByName("checkMember");
            for(var check of checks) {
                check.checked = !(check.checked);
            }
        }
        
    }; 

    </script>
</head>
<body>
	<!------------------------------------------- 헤더 -------------------------------------------------->
    <jsp:include page="../../common/header.jsp"></jsp:include> 
	
    <div id="body" class="body" >  
        
        <!------------------------------------------- 메뉴  -------------------------------------------------->
        <jsp:include page="../../common/menu.jsp"></jsp:include>
		<main class="main">
			<section class="container">
				<h1 class="d-none">공지글 등록</h1>

				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<section class="container-item member-container">
					<h1>공지글 등록</h1>


					<form method="post">
						<div class="noticereg-select">
						<input class="select-checkbox" type="checkbox"
                              name="checkCategory">전체 <input class="select-checkbox"
                              type="checkbox" name="checkCategory" value=1>민슈찍 <input
                              class="select-checkbox" type="checkbox" name="checkCategory"
                              value=2>민슈부 <input class="select-checkbox"
                              type="checkbox" name="checkCategory" value=8>반민슈찍 <input
                              class="select-checkbox" type="checkbox" name="checkCategory"
                              value=6>반민슈부 <input class="select-checkbox"
                              type="checkbox" name="checkCategory" value=7>민팥찍 <input
                              class="select-checkbox" type="checkbox" name="checkCategory"
                              value=3>민팥부 <input class="select-checkbox"
                              type="checkbox" name="checkCategory" value=5>반민팥찍 <input
                              class="select-checkbox" type="checkbox" name="checkCategory"
                              value=4>반민팥부 
						</div>


						<div>
							<input class="input-title" type="text" placeholder="공지사항 제목"
								name="title">
						</div>
						<div>
							<input class="input-content" type="text" value="" name="content">
						</div>

						<div class="notice-reg-box">
							<input class="button" type="submit" value="등록">
							 <a class="button-black" type="button"  href="list"> 취소</a>
						</div>

					</form>

				</section>
			</section>

			<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../../common/footer.jsp"></jsp:include> 

		</main>

	</div>

</body>
</html>