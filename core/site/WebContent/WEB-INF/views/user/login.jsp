<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>
<section class="common-wrap common-sub-wrap">
	<h2 class="hide">서브 컨텐츠</h2>
	
	<section class="common-sub-content sub-login">
		<h3 class="sub-title">로그인</h3>
		<p class="location"><span class="hide">현 위치</span>Home - 회원 - 로그인</p>
		
		
		<form class="common-form sub-user-form" id="userLoginForm">
		<fieldset>
			<legend>회원 로그인</legend>
			<ul>
				<li>
					<label for="userId">아이디</label>
					<input type="text" id="userId" title="아이디를 입력하세요.">
				</li>
				<li>
					<label for="userPwd">비밀번호</label>
					<input type="password" id="userPwd" title="비밀번호를 입력하세요.">
				</li>
			</ul>
			
			<nav class="sub-user-login-btn">
				<span class="find-info">
					<a href="${path}/user/find-id">아이디 찾기</a>
					<a href="${path}/user/find-pwd">비밀번호 찾기</a>
				</span>

				<span class="login">
					<input type="submit" value="로그인">
				</span>
				
				<span class="save-id">
					<label for="saveId">
						<input type="checkbox" id="saveId">
						아이디 기억하기
					</label>
				</span>
			</nav>
		</fieldset>
		</form>
		
	</section>
	
	
</section>



<script>
document.getElementById('userLoginForm').addEventListener('submit', async (e) => {

	e.preventDefault();
	
	const {validate} = await import('${path}/common-js/validate.js');
	const {fetchInit} = await import('${path}/common-js/fetch.js');
	const fetch = fetchInit;

	const {cookie} = await import('${path}/common-js/cookie.js');
	const $saveId = document.getElementById('saveId').checked;
	const $userId = document.getElementById('userId').value;

	if(document.querySelector('.error-msg') != null){
		document.querySelectorAll('.error-msg').forEach(e => e.parentNode.removeChild(e));
	}
	
	const $data = {
		id: document.getElementById('userId').value,
		pwd: document.getElementById('userPwd').value,
	};
	
	validate( $data, valid => {
		
		if(valid != true){

			alert(valid);

		} else {
			
			fetch('ajax.user.login', $data).then( server => {

				console.log(server)
				
				if(server.message === 'ERROR'){
					errorPrint(server.result, e.target.getElementsByTagName('li'));
					
				} else if(server.code == 21000){
					
					alert(server.message);
					document.getElementById('userId').value = '';
					document.getElementById('userPwd').value = '';
					
				} else if(server.code == 21004){
	
					alert(server.message);
					document.getElementById('userPwd').value = '';
					
				} else if(server.message === 'SUCCESS'){ 
		
					if($saveId == true) {
						cookie.set(window.$constant.cookie.userId, $userId);
					}	
					
					location.href = location.origin + '/' + location.pathname.split('/')[1] + '/main'
				} else {
					
					alert(server.message);
				}
				
			});
			
		}
		
	});

});



function errorPrint(e, tag){

	const li = tag;
	
	if(e.id != undefined){
		const userId = document.createElement('div');
		userId.className = 'error-msg';
		const error = document.createTextNode(e.id);
		userId.appendChild(error);
		li[0].appendChild(userId);
	}
	
	if(e.pwd != undefined){
		const userPwd = document.createElement('div');
		userPwd.className = 'error-msg';
		const error = document.createTextNode(e.pwd);
		userPwd.appendChild(error);
		li[1].appendChild(userPwd);
	}
	
}
</script>

<script type="module">
import {cookie} from '${path}/common-js/cookie.js';

(function(){

	if( cookie.get(window.$constant.cookie.userId) && document.getElementById('userId').value.length < 1 ){
		document.getElementById('userId').value = cookie.get(window.$constant.cookie.userId);
	}

})();
</script>