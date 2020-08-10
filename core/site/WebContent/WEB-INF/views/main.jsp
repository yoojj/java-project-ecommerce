<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>
<link rel="stylesheet" href="https://unpkg.com/flickity@2/dist/flickity.min.css">
<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<div class="carousel" data-flickity='{ "autoPlay": 2000 }'>
	<div class="carousel-cell"><img src="${path}/img/main-img01.jpg" alt="1"></div>
	<div class="carousel-cell"><img src="${path}/img/main-img02.jpg" alt="2"></div>
</div>
<hr>



<style>

.main-content-wrap {height:1000px;}
</style>

<section class="main-content-wrap">
	<h2 class="hide">메인 컨텐츠</h2>
	
	<section class="main-content-notice">
		<h3>공지사항</h3>
		<ul>
		<c:choose>

		<c:when test="${empty notice}">
			<li>등록된 글이 없습니다.</li>
		</c:when>

		<c:otherwise>
		<c:forEach items="${notice}" var="notice">
			<li><a href="${path}/board/view/${kind='공지사항'}/${notice.bno}">${notice.title}</a></li>
		</c:forEach>
		</c:otherwise>

		</c:choose>
		</ul>
		<p class="btn-more">
			<span class="hide">공지사항 모든 목록 보기</span>
			<a href="${path}/board/list/${kind='공지사항'}">+ more</a>
		</p>
	</section>

	<nav class="main-content-event">
		<h3>이벤트</h3>
		<ul>
		<c:choose>

		<c:when test="${empty event}">
			<li>등록된 이벤트가 없습니다.</li>
		</c:when>

		<c:otherwise>
		<c:forEach items="${event}" var="event">
			<li>${event.bno} <a href="${path}/board/view/${boardKind='이벤트'}/${event.bno}">${event.title}</a>
		</c:forEach>
		</c:otherwise>

		</c:choose>
		</ul>
		<p class="hide"><a href="${path}/board/list/${boardKind='이벤트'}">게시판 목록 보기</a></p>
	</nav>	
	
	<section class="main-content-product">
		<h3 class="hide">상품 목록</h3>

		<jsp:include page="/WEB-INF/template/component/product-list.jsp">
			<jsp:param name="css" value="main-product-list"/>
		</jsp:include>
	</section>
	
</section>