<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp" %>
<nav class="common-nav-layout common-nav-wrap">
<ul class="left-nav">
	<c:if test="${sessionAdmin.level == 1}">
	<li><a href="${path}/member/"     <c:if test="${memberOn}">     class="on"</c:if> >관리자 관리</a></li>
	<li><a href="${path}/member/role" <c:if test="${memberRoleOn}"> class="on"</c:if> >권한 관리</a></li>
	</c:if>
	
	<li><a href="${path}/profile/"    <c:if test="${profileOn}">    class="on"</c:if> >관리자 프로필</a></li>
	<li><a href="${path}/board/"      <c:if test="${boardOn}">      class="on"</c:if> >게시판 관리</a></li>
	<li><a href="${path}/product/"    <c:if test="${producOn}">     class="on"</c:if> >상품 관리</a></li>
	<li><a href="${path}/site/user"   <c:if test="${siteUserOn}">   class="on"</c:if> >사이트-회원 관리</a></li>
	<li><a href="${path}/site/board"  <c:if test="${siteBoardOn}">  class="on"</c:if> >사이트-게시판 관리</a></li>
</ul>
</nav>
<hr>