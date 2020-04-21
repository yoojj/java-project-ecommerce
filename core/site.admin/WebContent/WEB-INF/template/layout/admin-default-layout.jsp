<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp" %>
<tiles:insertAttribute name="head" />
<body>

<header class="common-header-layout common-header-wrap">
<h1 class="header-logo-layout header-logo">
	<a href="${path}/">logo</a>
</h1>

<nav class="header-nav-layout header-nav">
	<h2 class="hide">바로가기</h2>
	<button type="button" id="btnLogout">로그아웃</button>
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

<script type="module">
import * as session from '${path}/src/js/adminSessionStorage.js';

document.getElementById('btnLogout').addEventListener('click', () => {
	
	const key = session.getAdminSessionConstant();
	sessionStorage.removeItem(key);

	if(confirm('로그아웃하시겠습니까?')){
		window.location.href = 'logout';
	}

});
</script>
</body>
</html>