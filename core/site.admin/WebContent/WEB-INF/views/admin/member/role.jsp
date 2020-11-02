<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/template/inc/taglib.jsp" %>

<section class="common-content-wrap">
	<h2 class="hide">서브 컨텐츠</h2>

		<section class="common-content">
		<h3 class="page-title">관리자 권한 관리</h3>
		<p class="page-location"><span class="hide">현 위치</span> Home - 관리자 - 권한 관리</p>

		<span class="common-btn-wrap common-btn-top-right" style="top:50px;">
			<button type="button" class="reg-btn" id="btnRegAdminRole">관리자 권한 등록</button>
		</span>

		<table class="common-box-shadow common-table">
		<caption class="hide">관리자 목록</caption>
		<colgroup>
			<col style="width:10%;">
			<col style="width:10%;">
			<col style="width:15%;">
			<col style="width:45%;">
			<col style="width:10%;">
			<col style="width:10%;">
		</colgroup>
		<thead>
			<tr>
				<th>no.</th>
				<th>권한</th>
				<th>권한 설정</th>
				<th class="width_90">권한 설명</th>
				<th>등록자</th>
				<th>등록일</th>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>관리자</td>
				<td>설정</td>
				<td class="align-left">설명설명설명설명</td>
				<td>test</td>
				<td>2020-11-02</td>
			</tr>
		</tbody>
		</table>

		</section>

</section>
