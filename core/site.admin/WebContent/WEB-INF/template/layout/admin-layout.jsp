<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp" %>
<!doctype html>
<html lang="<spring:message code="home.head.lang" text="ko"/>">
<head>
<meta charset="utf-8">
<title>:: admin - <spring:message code="home.head.title" text=""/> :: </title>

<link rel="icon" href="${path}/img/favicon.ico">

<link rel="stylesheet" href="${path}/common-css/base.css">
<link rel="stylesheet" href="${path}/dist/build.css">

<link rel="dns-prefetch" href="//cdnjs.com">

<!--[if lt IE 9]>
	<script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/livingston-css3-mediaqueries-js/1.0.0/css3-mediaqueries.min.js"></script>
<![endif]-->

</head>

<body>

<header class="common-header-layout common-header-wrap">
<h1 class="header-logo-layout header-logo">
	<a href="${path}/">logo</a>
</h1>

<nav class="header-nav-layout header-nav">
	<h2 class="hide">바로가기</h2>
	<a href="${path}/logout">로그아웃</a>
</nav>
</header>
<hr>

<tiles:insertAttribute name="nav" />

<div class="common-content-scroll">
<tiles:insertAttribute name="content" />
</div>

<footer class="common-footer-layout common-footer-wrap none">
	<h2>고객지원 안내</h2>
	<ul class="common-contact">
		<li><strong>업무시간</strong> 10:00 ~ 19:00 (<strong>점심시간</strong> 12:00 ~ 13:00)
		<li><strong>업무요일</strong> 월 ~ 금
		<li class="tel"><span class="hide">전화번호</span>+82-2-1000-1000
		<li class="email"><span class="hide">이메일</span>메일
	</ul>
</footer>



<script>
Object.defineProperty(window, '$constant', {

	value : {},
	writable: true

});
</script>

</body>
</html>
