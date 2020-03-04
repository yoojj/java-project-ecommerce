<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../template/inc/taglib.jsp" %>



<section class="admin-login-wrap">
<h1 class="hide">로그인</h1>

	<f:form cssClass="admin-login-form" modelAttribute="adminLoginForm" action="adminLoginSubmit">
	<fieldset>
	<legend>관리자 로그인</legend>
	<ul>
		<li>
			<label for="adminId">아이디</label>
			<f:input path="adminId" id="adminId" title="아이디를 입력하세요." value="${input}" />
			<p class="error-msg">${errorTest.adminId}</p>
		</li>
		<li>
			<label for="adminPwd">비밀번호</label>
			<f:password path="adminPwd" id="adminPwd" title="비밀번호를 입력하세요." />
			<p class="error-msg">${errorTest.adminPwd}</p>
		</li>
	</ul>
	</fieldset>
		
	<p class="admin-login-btn"><input type="submit" value="로그인"></p>
	</f:form>
</section>



<script type="module">
import { validate } from '${path}/common-js/validate.js';

document.getElementById('adminLoginForm').addEventListener('submit', (e) => {

	const $data = {
		id : document.getElementById('adminId').value,
		pwd: document.getElementById('adminPwd').value
	}
	
	validate( $data, result => {

		if( result != true ){
			e.preventDefault();
			alert(result);
		}
	
	});

});
</script>

<c:if test="${ not empty result }">
<script>
if( ${result.code} == 1 ){
	alert( '${ result.message }' );
}
</script>
</c:if>
