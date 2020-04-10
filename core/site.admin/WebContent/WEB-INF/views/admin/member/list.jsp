<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/inc/taglib.jsp" %>
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
				<option value="0" selected>0</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
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
			<col style="width:10%;">
			<col style="width:15%;">
			<col span="6" style="width:10%;">
			<col style="width:15%;">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>등급</th>
				<th>사용여부</th>
				<th>등록자</th>
				<th>등록일</th>
				<th>수정자</th>
				<th>수정일</th>
				<th>수정</th>
			</tr>
		</thead>
		<tbody>
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
				<td>${admin.id}</td>
				<td>
					<select name="adminLevel" disabled>
						<option value="0" <c:if test="${admin.level eq 0}">selected</c:if>>0</option>
						<option value="1" <c:if test="${admin.level eq 1}">selected</c:if>>1</option>
						<option value="2" <c:if test="${admin.level eq 2}">selected</c:if>>2</option>
						<option value="3" <c:if test="${admin.level eq 3}">selected</c:if>>3</option>
						<option value="4" <c:if test="${admin.level eq 4}">selected</c:if>>4</option>
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
				<td>${admin.updateAdmin}</td>
				<td>${fn:substring(admin.updateDate, 0, 10)}</td>
				<td>
					<span class="common-btn-wrap">
						<button type="button" class="update-btn btnUpdateAdmin">수정</button>
						<button type="button" class="delete-btn btnDeleteAdmin">삭제</button>
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