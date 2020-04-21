<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../template/inc/taglib.jsp" %>
<section class="admin-login-wrap">
<h1 class="hide">로그인</h1>

	<form class="admin-login-form" id="adminLoginForm" method="post">
	<fieldset>
	<legend>관리자 로그인</legend>
	<ul>
		<li>
			<label for="adminId">아이디</label>
			<input type="text" id="adminId" title="아이디를 입력하세요." />
		</li>
		<li>
			<label for="adminPwd">비밀번호</label>
			<input type="password" id="adminPwd" title="비밀번호를 입력하세요." />
		</li>
	</ul>
	</fieldset>
		
	<p class="admin-login-btn"><input type="submit" value="로그인"></p>
	</form>
</section>



<script>
document.getElementById('adminLoginForm').addEventListener('submit', async (e) => {

	e.preventDefault();

	const {validate} = await import('${path}/common-js/validate.js');
	const {fetchInit} = await import('${path}/common-js/fetch.js');
	const fetch = fetchInit; 
	const {getAdminSessionConstant} = await import('${path}/src/js/adminSessionStorage.js');
	
	if(document.querySelector('.error-msg') != null){
		document.querySelectorAll('.error-msg').forEach(e => e.parentNode.removeChild(e));
	}

	const $data = {
		id : document.getElementById('adminId').value,
		pwd : document.getElementById('adminPwd').value
	}

	validate( $data, valid => {

		if(valid != true){

			alert(valid);

		} else {

			fetch('ajax.adminLogin', $data).then( server => {
				if( server.code == 1 ){

					if(server.result){
						errorPrint(server.result);
					} else {
						alert(server.message);
						document.getElementById('adminPwd').value = '';
					}
			
				} else {
					
					const key = getAdminSessionConstant();
					sessionStorage.setItem(key, JSON.stringify(server.result));	

					window.location.href = 'main';	

				}

			});	
		}
	
	});

});



function errorPrint(e){

	const li = document.getElementsByTagName('li');
	
	if(e.id != undefined){
		const adminId = document.createElement('div');
		adminId.className = 'error-msg';
		const error = document.createTextNode(e.id);
		adminId.appendChild(error);
		li[0].appendChild(adminId);
	}
	
	if(e.pwd != undefined){
		const adminPwd = document.createElement('div');
		adminPwd.className = 'error-msg';
		const error = document.createTextNode(e.pwd);
		adminPwd.appendChild(error);
		li[1].appendChild(adminPwd);
	}
	
}
</script>