<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="body-nav">
	<c:if test="${login != null}">
		<jsp:include page="my-info.jsp"></jsp:include>
	</c:if>
	<div>
		<ul class="body-menu">
			<li><a href="#">MAKE</a></li>
			<li><a href="#">TEST</a></li>
			<li><a href="#">COMMUNITY</a>
				<ul class="body-detail-menu">
					<li value=""><a  href="/community/all/list?category=">전체게시판 </a></li>
					<li><a href="">민팥부 </a></li>
					<li><a href="">민팥찍 </a></li>
					<li><a href="">민슈부 </a></li>
					<li><a href="">민슈찍 </a></li>
					<li><a href="">반민팥부 </a></li>
					<li><a href="">반민팥찍 </a></li>
					<li><a href="">반민슈부 </a></li>
					<li><a href="">반민슈찍 </a></li>
				</ul></li>

		</ul>
	</div>
</nav>