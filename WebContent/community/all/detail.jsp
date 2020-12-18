<%@page import="java.util.List"%>
<%@page import="com.slpl.web.service.community.*"%>
<%@page import="com.slpl.web.entity.community.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../../common/header.jsp"%>


<section id="body" class="body">
	<div class="container">
		<main id="main" class="main">
			<%@include file="../../common/nav.jsp"%>

			<section class="content detail">
				<div class="content-box">
					<div class="content-box-top">
						<div class="detail-list">
							<a class="a-input" href="list">목록</a> <a class="a-input" href="">이전글</a>
							<a class="a-input" href="">다음글</a>
						</div>
						<div class="detail-update">
							<a class="a-input-black" href="update?id=${n.id}">수정</a> <a
								class="a-input-black" href="delete?id=${n.id}">삭제</a>
						</div>
					</div>


					<div class="breadcrumbs">
						<ul>
							<li>community&nbsp></li>
							<li>all</li>
						</ul>
					</div>

					<h3 class="hidden">내용</h3>
					<span class="detail-title">${n.title}</span>
					<div class="cover-info">${n.memberName}&nbsp${n.regDate}&nbsp
						${n.hitCnt}</div>
					<div class="board-post">${n.content}</div>
					<div class="hidden">${n.categoryId }</div>
					

					<div class="recommend-box">
						<div class="recommend-button" onclick="">
							<img class="heart" src="/assets/images/community/heart.png">
							<div class="box"></div>

							<img class="hand" src="/assets/images/community/hand.png">
							<span class="recommen-cnt">15</span>
						</div>
					</div>


					<h3 class="hidden">댓글</h3>
					<div class="reply-post">
						<input class="input-reply" type="textarea" min="1" max="200"
							placeholder="댓글작성.."> <input class="button" type="submit"
							value="등록">
					</div>
					<div class="reply-view">
						<%-- <c:forEach var>
						
						</c:forEach> --%>


					</div>

				</div>

			</section>
		</main>
	</div>
</section>
<!--//content -->

<%@include file="../../common/footer.jsp"%>



<script>
        
    window.addeventListner("load",function(){
    	var recommendBtn = document.querySelelctor(".recommend-button");
    	
    	recommendBtn.
    });

    </script>
