<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/taglib.jsp" %>
<!doctype html>
<html lang="<spring:message code="home.head.lang" text="ko"/>">
<head>
<meta charset="utf-8">
<title>:: admin - <spring:message code="home.head.title" text=""/> :: </title>

<link rel="icon" href="${path}/img/favicon.ico">

<link rel="stylesheet" href="${path}/common-css/base.css">
<link rel="stylesheet" href="${path}/common-css/component/modal.css">
<link rel="stylesheet" href="${path}/common-css/component/dialog.css">
<link rel="stylesheet" href="${path}/dist/build.css">

<link rel="dns-prefetch" href="//cdnjs.com">

<!--[if lt IE 9]>
	<script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/livingston-css3-mediaqueries-js/1.0.0/css3-mediaqueries.min.js"></script>
<![endif]-->

<script>
Object.defineProperty(window, '$constant', {

	value : {},
	writable: true

});
</script>

</head>