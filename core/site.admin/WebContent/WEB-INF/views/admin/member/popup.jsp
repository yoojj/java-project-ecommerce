<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/inc/taglib.jsp" %>
<section class="common-popup-wrap">
	<h1>사용자 정보</h1>
	
	<c:if test="${result.code eq 1}">
	<div class="common-popup-error-wrap">
		<strong>오류</strong>
		<p>다시 시도해주시기 바랍니다.</p>
	</div>
	</c:if>

	<div class="popup-admin-info-wrap">
	<dl>
		<dt>아이디
		<dd>${result.result.id}
		<dt>등급
		<dd>${result.result.level}
	</dl>
	</div>

	<div style="text-align:center">
	<span class="common-btn-wrap">
		<!-- 임시 -->
		<button type="button" class="modify-btn">수정</button>
		<button type="button">닫기</button>
	</span>
	</div>
</section>