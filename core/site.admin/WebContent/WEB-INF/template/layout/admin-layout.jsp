<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp" %>
<!doctype html>
<html lang="<spring:message code="head.lang"/>">
<head>
<meta charset="utf-8">
<title>:: admin - <spring:message code="head.title"/> :: </title>

<link rel="icon" href="${path}/img/favicon.ico">

<link rel="dns-prefetch" href="//cdnjs.com">
<link rel="stylesheet" href="${path}/css/base.css">
<link rel="stylesheet" href="${path}/css/admin/login.css">

<!--[if lt IE 9]>
	<script src="//cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/livingston-css3-mediaqueries-js/1.0.0/css3-mediaqueries.min.js"></script>
<![endif]-->

</head>

<body>


<tiles:insertAttribute name="content" />


</body>
</html>