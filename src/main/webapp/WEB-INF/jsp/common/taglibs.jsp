<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%-- <%@ taglib prefix="utils" uri="http://stsm/tags/utils" %> --%>
<%-- <%@ taglib prefix="s" uri="/struts-tags" %> --%>
<%-- <%@ taglib prefix="utils" uri="http://stsm/tags/utils" %> --%>

<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="/js/jquery.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/jquery.validate.extends.js"></script>
<script type="text/javascript" src="/js/jquery.tmpl.min.js"></script>
<script type="text/javascript" src="/js/jquery.tmplPlus.min.js"></script>
<script src="https://cdn.rawgit.com/serratus/quaggaJS/0420d5e0/dist/quagga.min.js"></script>
<link rel="stylesheet" type="text/css" href='<c:url value="/css/jquery-ui-1.8.17.custom.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/common.css"/>' />
<link rel="stylesheet" type="text/css" href='<c:url value="/css/button.css"/>' />

<script type="text/javascript">
	$.ajaxPrefilter(function (options) { 
		var headerName = '${_csrf.headerName}'; 
		var token = '${_csrf.token}'; 
		if (options.method === 'POST' || options.method === 'post'|| options.type === 'post' || options.type === 'POST') {
			console.log("csrf 해더 설정 인입: "+headerName);
			options.headers = options.headers || {}; 
			options.headers[headerName] = token; 
		} 
	});
</script>