<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>

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
		<dt>등록자
		<dd>${result.result.regAdmin}
		<dt>등록일
		<dd>${result.result.regDate}
		<dt>등록 이유 
		<dd>${result.result.regMsg}
	</dl>
	</div>

	<div style="text-align:center">
	<span class="common-btn-wrap">
		<!-- <button type="button" class="modify-btn" id="btnModifyAdmin">수정</button> -->
		<button type="button" id="btnClosePopup">닫기</button>
	</span>
	</div>

</section>



<script>
/** 관리자 수정 
document.getElementById('btnModifyAdmin').addEventListener('click', (e) => {
});
*/



/** 팝업 닫기 */
document.getElementById('btnClosePopup').addEventListener('click', (e) => {
	self.close()
});
</script>
