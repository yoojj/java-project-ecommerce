<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>
<header class="common-header-wrap">
	<h1 class="header-logo"><a href="${path}/">LOGO</a></h1>

	<nav class="header-nav-wrap">
		<h2 class="hide">바로가기</h2>

		<ul class="header-nav-ul">
			<c:if test="${ sessionUser != null }">
			<li>
				<a href="${path}/logout">로그아웃</a>
			</li>
			</c:if>
			
			<c:if test="${ sessionUser == null }">
			<li><a href="${path}/user/login">로그인</a></li>
			<li><a href="${path}/user/join">가입</a></li>
			</c:if>
			
			<li class="cart">
				<a href="${path}/product/cart">장바구니</a>
				<em>10</em><span class="hide">개의 상품이 담겼습니다.</span>
			</li>
			<li><a href="${path}/mypage/">마이페이지</a></li>
		</ul>
	</nav>

	<jsp:include page="/WEB-INF/template/component/search-product.jsp">
		<jsp:param name="css" value="header-search-product"/>
	</jsp:include> 

</header>
	