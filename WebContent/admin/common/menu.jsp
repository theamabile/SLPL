<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener("load", function() {
		var firstMenus = document.getElementsByClassName("first-menu");

		for(var menu of firstMenus) {
			console.log("menu1");
			menu.click(function() {
			
				var selectedMenus = document.getElementsByClassName("first-menu-selected");
				for(var selected of selectedMenus) {
					selected.classList.remove("first-menu-selected")
				}

				menu.classList.add("first-menu-selected");
			});
		}
	});
</script>
</head>
<body>
<nav>
	    <h1 class="d-none">메인 메뉴</h1>
	    <ul class="main-menu">
	        <li>
	            <div class="first-menu-item">
	                <img class="menu-img" src="<%=request.getContextPath()%>/assets/images/admin/admin_menu_dashboard.png" alt="대시보드"/>   
	                <a href="#">DASH BOARD</a>    
	            </div>                    
	        </li>
	        <li>
	            <div class="first-menu-item">
	                <img class="menu-img" src="<%=request.getContextPath()%>/assets/images/admin/admin_menu_member.png" alt="회원 관리"/> 
	                <a href="#">MEMBER</a>    
	            </div>                    
	            
	            <ul>
	                <li><a href="/admin/member/list">LIST</a></li>
	                <li><a href="/admin/member/add">ADD</a></li>
	                <li><a href="/admin/member/messageList">MESSAGE</a></li>
	            </ul>
	        </li>
	        <li>
	            <div class="first-menu-item">
	            	<img class="menu-img" src="<%=request.getContextPath()%>/assets/images/admin/admin_menu_community.png" alt="게시판 관리"/> 
	                <!-- <img class="menu-img" src="../../assets/images/admin/admin_menu_community.png" alt="게시판 관리"/>  -->
	                <a href="#">COMMUNITY</a>    
	            </div>                    
	        </li>
	        <li>
	            <div class="first-menu-item">
	                <img class="menu-img" src="<%=request.getContextPath()%>/assets/images/admin/admin_menu_test.png" alt="테스트 관리"/> 
	                <a href="#">TEST</a>
	            </div>                    
	
	            <ul>
	                <li><a href="">맡으신거</a></li>
	                <li><a href="">여기다</a></li>
	                <li><a href="">적어주세요</a></li>
	            </ul>
	        </li>
	    </ul>
	</nav> 
</body>
</html>