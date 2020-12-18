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
    
    window.addEventListener("load", function(){
        var categoryAdd = document.getElementById("category-add");

        
        categoryAdd.onclick = function(){
        	var win = open("category_add","_blank", "width=350px, height=250px");
            
        };
        
       
        
    });
    


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
				<h1 class="d-none">카테고리 관리</h1>

				<!-- container-item클래스가 꽉 채워진 박스 기준이라 min-width만 설정해주기 위해 member-container를 같이 넣어줌-->
				<section class="container-item member-container">
					<h1>카테고리관리</h1>
					<form action="delete" method="post" >
						<div class="tools">
							<section class="filter">
								<h1 class="d-none">필터</h1>

							</section>
							
								<section class="delete-box">

									<h1 class="d-none">삭제 메뉴</h1>
									<input type="button" value="추가" id="category-add"
										class=" puple-button-m"> <input type="submit"
										value="삭제" class="gray-button-m">
								</section>
						</div>


						<section>
							<h1 class="d-none">회원 목록</h1>
							<table>
								<thead>
									<tr>
										<th><input type="checkbox" id="checkAll"></th>
										<th>아이디</th>
										<th >커뮤니티 명</th>
										<th class="center">회원수</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="n" items="${list}">

										<tr>
											<td><input type="checkbox" class="checkMember" name="checkMember" value="${n.id}"></td>
											<td>${n.id}</td>
											<td>${n.name}</td>
											<td class="center">${n.memberCnt}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</section>
					</form>
				</section>
			</section>


			<!------------------------------------------- 풋터  -------------------------------------------------->
            
            <jsp:include page="../../common/footer.jsp"></jsp:include> 
		</main>

	</div>

</body>
</html>