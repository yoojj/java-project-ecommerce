<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>
<%@ include file="/WEB-INF/template/inc/adminLevel.jsp" %>

<section class="common-content-wrap">
	<h2 class="hide">서브 컨텐츠</h2>

	<section class="common-content">
		<h3 class="page-title">관리자 관리</h3>
		<p class="page-location"><span class="hide">현 위치</span> Home - 관리자 - 목록</p>

		<span class="common-btn-wrap common-btn-top-right" style="top:5px;">
			<button type="button" class="reg-btn" id="btnRegAdmin">관리자 등록</button>
		</span>

<script type="module">
/** 관리자 등록 */
import { toggleModal } from '${path}/common-js/component/modal.js';

document.getElementById('btnRegAdmin').addEventListener('click', toggleModal);
</script>		

<template>
<aside class="common-modal-layout common-modal-wrap admin-reg-modal">
<h1 class="modal-title">관리자 등록</h1>
	<form class="common-form admin-reg-form-modal" id="adminRegForm" method="post">
	<fieldset>
	<legend class="hide">관리자 등록 폼 (필수 입력)</legend>
	<ul>
		<li>
			<label for="checkId">아이디</label>
			<input type="text" id="checkId" title="아이디를 입력하세요">
			
			<button type="button" class="form-btn id-check-btn" id="idCheck">아이디 확인</button>
		</li>
		<li>
			<label for="adminId">사용 아이디</label>
			<input type="text" id="adminId" placeholder="사용 아이디" readonly>
		</li>
		<li>
			<label for="adminPwd">비밀번호</label>
			<input type="password" id="adminPwd" title="비밀번호를 입력하세요" >
		</li>
		<li>
			<label for="adminLevel">등급</label>
			<select name="level" id="adminLevel" title="관리자 등급을 입력하세요" >
			<c:forEach var="level" items="${adminLevelEnum}">
				<option value="${level.num}">${level.str}</option>
			</c:forEach>
			</select>
			<p class="error-msg" id="errorAdminLevel"></p>
		</li>
		<li>
			<label for="adminState">사용여부</label>
			<input type="checkbox" name="status" id="adminState" title="사용 여부를 선택하세요" >
		</li>
		<li>
			<label for="adminRegMag" style="vertical-align:top;">등록 이유</label>
			<textarea id="adminRegMag"></textarea>
		</li>
	</ul>
	
	<p class="common-btn-wrap admin-reg-btn-modal">
		<input type="submit" class="reg-btn" value="등록">
	</p>
	</fieldset>
	</form>
	
	<button type="button" title="close modal" id="btnCloseModal">닫기</button>
</aside>

<script type="module">
import { validate } from '${path}/common-js/validate.js';
import { fetchInit as fetch } from '${path}/common-js/fetch.js';

/** 아이디 중복 체크 */
document.getElementById('idCheck').addEventListener('click', () => {

	const $data = {
		id : document.getElementById('checkId').value
	};

	validate( $data, valid => {

		if(valid != true){

			alert(valid);

		} else {

			fetch('ajax.adminRegIdCheck', $data).then( server => {

				if( server.code == 1 ){

					alert(server.message);
			
				} else {

					setResult(server.result);

				}

			});

		}

	});	

	function setResult(id){
		
		alert(`입력한 아이디 [\${id}]를 사용합니다.`);
		document.getElementById('adminId').value = id;
		document.getElementById('checkId').value = '';

	}

});



/** 관리자 등록 */
document.getElementById('adminRegForm').addEventListener('submit', (e) => {
	
	e.preventDefault();

	if(document.querySelector('.form-error-msg') != null){
		document.querySelectorAll('.form-error-msg').forEach(e => e.parentNode.removeChild(e));
	}

	const $data = {
		id: document.getElementById('adminId').value,
		pwd: document.getElementById('adminPwd').value,
		level: document.getElementById('adminLevel').value,
		state: document.getElementById('adminState').checked,
		regMsg: document.getElementById('adminRegMag').value
	}
	
	validate( $data, valid => {

		console.log($data);

		if(valid != true){

			alert(valid);

		} else {

			if( confirm('관리자로 등록하시겠습니까?') ){
			
				fetch('ajax.adminReg', $data).then( server => {
					console.log(server);

					if( server.code == 1 ){

						if(server.result){
							errorPrint(server.result);
						} else {
							alert(server.message);
						}

					} else {

						alert('등록되었습니다.');

						setTimeout(function() {
							location.reload(true);
						}, 500);

					}

				});

			} 
			
		}

	});
});



function errorPrint(e){

	const form = document.getElementById('adminRegForm');
	const li = form.getElementsByTagName('li');

	if(e.id != undefined){
		const adminId = document.createElement('div');
		adminId.className = 'form-error-msg';
		const error = document.createTextNode(e.id);
		adminId.appendChild(error);
		li[0].appendChild(adminId);
	}
	
	if(e.pwd != undefined){
		const adminPwd = document.createElement('div');
		adminPwd.className = 'form-error-msg';
		const error = document.createTextNode(e.pwd);
		adminPwd.appendChild(error);
		li[1].appendChild(adminPwd);
	}

}



/** 저장된 값 삭제 */
document.getElementById('btnCloseModal').addEventListener('click', () => {
	document.getElementById('adminRegForm').reset();
});
</script>
</template>

		<table class="common-box-shadow common-table member-list-table" border="1">
		<caption class="hide">관리자 목록</caption>
		<colgroup>
			<col style="width:8%;">
			<col style="width:20%;">
			<col span="4" style="width:10%;">
			<col style="width:12%;">
			<col style="width:10%;">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>등급</th>
				<th>사용 여부</th>
				<th>등록자</th>
				<th>등록일</th>
				<th>수정</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		<tbody id="adminListTbody">
		<c:choose>
		<c:when test="${empty result}">
			<tr>
				<td colspan="8">등록된 관리자가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise>
		<c:forEach items="${result}" var="admin" varStatus="obj">
			<tr>
				<td>${obj.count}</td>
				<td class="admin-id">
					<a href="/admin/member/popup/${admin.id}" target="popup" onclick="popup()">${admin.id}</a>
					<script>
					function popup(){	
						
						const popupWidth  = '500';
						const popupHeight = '500';
						const popupTop  = (window.screen.height/2) - (popupHeight/2);
						const popupLeft = (window.screen.width/2) - (popupWidth/2);
						
						window.open(
							this.href, 
							'popup', 
							`width= \${popupWidth} , 
							height= \${popupHeight} , 
							top= \${popupTop},
							left= \${popupLeft}`
						);
					}
					</script>
				</td>
				<td>
					<select name="adminLevel" class="admin-level-select-${admin.level}" disabled>
					<c:forEach var="level" items="${adminLevelEnum}">
					<c:choose>
					<c:when test="${level.num eq admin.level}">
						<option value="${level.num}" class="admin-level-${level.num}" selected>${level.str}</option>
					</c:when>
					
					<c:otherwise>
						<option value="${level.num}" class="admin-level-${level.num}">${level.str}</option>
					</c:otherwise>
					</c:choose>
					</c:forEach>
					</select>
				</td>
				<td>
					<c:choose>
					<c:when test="${admin.state == true}">
					<p style="color:green;">
						<label><input type="checkbox" name="adminState" checked disabled>사용 가능</label>
					</p>
					</c:when>
					<c:otherwise>
					<p style="color:red;">
						<label><input type="checkbox" name="adminState" disabled>사용 불가</label>
					</p>
					</c:otherwise>
					</c:choose>
				</td>
				<td>${admin.regAdmin}</td>
				<td>${fn:substring(admin.regDate, 0, 10)}</td>
				<td>
					<span class="common-btn-wrap">
						<button type="button" value="modify" class="modify-btn">수정</button>
						<button type="button" value="delete" class="delete-btn">삭제</button>
						<button type="button" value="update" class="update-btn" style="display:none;">수정</button>
						<button type="button" value="cancel" class="cancel-btn" style="display:none;">취소</button>
					</span>
				</td>
				<td>
					<span class="common-btn-wrap">
						<button type="button" class="pwd-reset-btn" title="아이디 역순으로 비밀 번호를 초기화합니다.">초기화</button>
					</span>
				</td>
			</tr>
		</c:forEach>
		</c:otherwise>
		</c:choose>
		</tbody>		
		</table>
				
	</section>

</section>
<hr>

<style>
.member-list-table .update-btn {background:gold;}
.member-list-table .cancel-btn {background:crimson;}
</style>



<script type="module">
import { validate } from '${path}/common-js/validate.js';
import { fetchInit as fetch } from '${path}/common-js/fetch.js';
import { getAdminSessionConstant } from '${path}/src/js/adminSessionStorage.js';

const tbody = document.getElementById('adminListTbody');
const tr = tbody.getElementsByTagName('tr');



/** 어드민 수정 */
const btnModidfy = document.getElementsByClassName('modify-btn');

for(let i=0 ; i < btnModidfy.length ; ++i){
	
	btnModidfy[i].addEventListener('click', (e) => {

		if(confirm('수정하시겠습니까?')){	
			modifyAdmin(i);
		}
		
	});
	
}

function modifyAdmin(i){

	tr[i].style.background = '#f5f5f5';
	tr[i].querySelector('select').disabled = false;
	tr[i].querySelector('input[type=checkbox]').disabled = false;
	
	tr[i].querySelector('.modify-btn').style.display = 'none';
	tr[i].querySelector('.update-btn').style.display = 'inline';
	
	tr[i].querySelector('.update-btn').addEventListener('click', (e) => {
		
		const $data = {
			id: tr[i].querySelector('.admin-id').innerText,
			level: tr[i].querySelector('select').value,
			state: tr[i].querySelector('input[type=checkbox]').checked
		}

		alert('해당 내용으로 수정하시겠습니까?');
		
		fetch('ajax.adminUpdate', $data).then( server => {

			if( server.code == 1 ){

				alert( result.message );

			} else {

				alert('수정되었습니다.');
				location.reload(true);

			}

		});
	});
	
	tr[i].querySelector('.delete-btn').style.display = 'none';
	tr[i].querySelector('.cancel-btn').style.display = 'inline';

	tr[i].querySelector('.cancel-btn').addEventListener('click', (e) => {
		alert('수정을 취소합니다.');
		cancelModifyAdmin(i);
	});
	
}

function cancelModifyAdmin(i){
	
	tr[i].style.background = '#fff';
	tr[i].querySelector('select').disabled = true;
	tr[i].querySelector('input[type=checkbox]').disabled = true;
	
	tr[i].querySelector('.modify-btn').style.display = 'inline';
	tr[i].querySelector('.update-btn').style.display = 'none';
	
	tr[i].querySelector('.delete-btn').style.display = 'inline';
	tr[i].querySelector('.cancel-btn').style.display = 'none';
	
};



/** 어드민 삭제 */
const key = getAdminSessionConstant();
const session = JSON.parse(sessionStorage.getItem(key));

const btnDelete = document.getElementsByClassName('delete-btn');

for(let i=0 ; i < btnDelete.length ; ++i){
	
	btnDelete[i].addEventListener('click', (e) => {

		const id = tr[i].querySelector('.admin-id').innerText;

		if(session.id === id) {
			// 프로필에서 탈퇴처리 
			alert('자신의 아이디는 삭제할 수 없습니다.');
		} else {

			if(confirm('삭제하시겠습니까?')){	
				deleteAdmin(i);
			}

		}

	});
	
}

function deleteAdmin(i){

	document.getElementById('deleteAdminId').innerText = tr[i].querySelector('.admin-id').innerText;

	const dialog = document.getElementById('adminDialog');

	if(typeof dialog.showModal != 'function'){

		const script = document.createElement('script');

		script.src = '${path}/src/js/dialog-polyfill.js';
		script.className = 'dialog-script-load';

		document.head.appendChild(script);

		if(document.querySelector('.dialog-script-load') != null){ 
			dialogPolyfill.registerDialog(dialog);
		}

    } 
	 
	dialog.showModal();

	document.getElementById('btnPwdCheck').addEventListener('click', (e) => {
		
		e.stopImmediatePropagation();

		const $data = {
			deleteAdminId : document.getElementById('deleteAdminId').innerText,
			pwd : document.getElementById('adminPwd').value
		};

		validate( $data, valid => {

			if(valid != true){

				alert(valid);
			
			} else {
				
				fetch('ajax.adminDelete', $data).then( server => {

					if( server.code == 1 ){

						alert(server.message);
						document.getElementById('adminPwd').value = '';
						dialog.close();

					} else {

						alert('삭제하였습니다.');

						// 방법1
						location.reload(true);
		
						// 방법2
						//tbody.removeChild(tr[i]); 
						//dialog.close();

					}

				});

			}
		});

	});

	document.getElementById('btnCancelDelte').addEventListener('click', () => {
		document.getElementById('adminPwd').value = '';
		dialog.close();
	});

}



/** 비밀번호 초기화 */
const btnPwdReset = document.getElementsByClassName('pwd-reset-btn');

for(let i=0 ; i < btnPwdReset.length ; ++i){
	
	btnPwdReset[i].addEventListener('click', (e) => {

		if(confirm('비밀번호를 초기화하시겠습니까?')){
			adminPwdReset(i);
		}

	});

}

function adminPwdReset(i){

	const $data = {
		pwdResetAdminId : tr[i].querySelector('.admin-id').innerText
	};

	fetch('ajax.adminPwdReset', $data).then( server => {
		
		alert(server.message);

	});

};

</script>



<dialog class="common-dialog admin-delete-dialog" id="adminDialog">
	<h1 class="dialog-title">비밀번호 확인</h1>

	<p>관리자 [<b id="deleteAdminId">id</b>] 를 삭제합니다.</p>
	
	<div>
		<label for="adminPwd">비밀번호 입력</label>
		<input type="password" id="adminPwd" title="비밀번호를 입력하세요." />
	</div>
	
	<span class="common-btn-wrap admin-delete-btn-wrap">
		<button type="button" class="admin-delete-update-btn" id="btnPwdCheck">확인</button>
		<button type="button" class="admin-delete-cancel-btn" id="btnCancelDelte">취소</button>
	</span>
					
</dialog>