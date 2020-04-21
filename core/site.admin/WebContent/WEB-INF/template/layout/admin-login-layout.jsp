<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/taglib.jsp" %>
<tiles:insertAttribute name="head" />

<script type="module">
import { xhr } from '${path}/common-js/xhr.js';
import * as adminSession from '${path}/src/js/adminSessionStorage.js';

xhr('ajax.valid.json', null, server => { 
	sessionStorage.setItem('valid.json', server);			
});

adminSession.getAdminSessionConstant();
</script>

<body>

<tiles:insertAttribute name="content" />

</body>
</html>